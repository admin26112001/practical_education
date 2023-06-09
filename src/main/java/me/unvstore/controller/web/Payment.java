package me.unvstore.controller.web;

import java.io.IOException;
import java.sql.Timestamp;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.unvstore.converter.UserConverter;
import me.unvstore.dto.CartDTO;
import me.unvstore.dto.OrderDTO;
import me.unvstore.dto.UserDTO;
import me.unvstore.entity.UserEntity;
import me.unvstore.service.IOrderDetailService;
import me.unvstore.service.IOrderService;
import me.unvstore.utils.EmailUtil;
import me.unvstore.utils.SesstionUtil;

@WebServlet(urlPatterns = { "/payment" })
public class Payment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private IOrderService orderServlet;
	
	@Inject
	private IOrderDetailService orderDetailServlet;
	
	@Inject
	private UserConverter userConverter;
	
	private String host;
	private String port;
	private String userName;
	private String password;
	
	public void init() {
		ServletContext context = getServletContext();
		this.host = context.getInitParameter("host");
		this.port = context.getInitParameter("port");
		this.userName = context.getInitParameter("userName");
		this.password = context.getInitParameter("password");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SesstionUtil.getInstance().getValue(request, "USERMODEL");
		RequestDispatcher rd = request.getRequestDispatcher("views/web/payment.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		UserEntity userEntity = (UserEntity) SesstionUtil.getInstance().getValue(request, "USERMODEL");
		Long total = (Long) SesstionUtil.getInstance().getValue(request, "totalSum");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		CartDTO cart = (CartDTO) SesstionUtil.getInstance().getValue(request, "cart");

		if (address != null && phone != null && userEntity != null) {	
			Boolean isSuccess;
			try {
                                String list = "Invoice details are updated at : http://phonewebute.herokuapp.com/ , Thanks for order: ";
                                
				for(int i=0; i< cart.getCartDetails().size(); i++) {
						list += "x"+cart.getCartDetails().get(i).getQuantity()+" "+cart.getCartDetails().get(i).getProduct().getProductName()+ " - "+cart.getCartDetails().get(i).getTotal() +"VND";
						if(i < cart.getCartDetails().size() - 1) {
							list += ", ";
						}
				}
                                
                                
                                
				
				isSuccess = EmailUtil.sendEmail(host, port, userName, password, 
						userEntity.getEmail(), "Order at Universal Store", list);
				
				UserDTO userDTO = userConverter.toDto(userEntity);
				OrderDTO orderDTO = new OrderDTO();
				orderDTO.setUserId(userDTO.getUserId());
				orderDTO.setAddress(address);
				orderDTO.setOrderDate(new Timestamp(System.currentTimeMillis()));
				orderDTO.setPhone(phone);
				orderDTO.setTotal(total);
				orderDTO.setStatus(0);
				OrderDTO order =  orderServlet.save(orderDTO);
				orderDetailServlet.save(cart, order);
				
				SesstionUtil.getInstance().removeValue(request, "totalSum");
				SesstionUtil.getInstance().removeValue(request, "cart");
			}catch (Exception e) {
				e.printStackTrace();
				isSuccess = false;
			}
			if(isSuccess) {
				response.sendRedirect(request.getContextPath()+"/payment-thanks");
			}
		}
	}
}
