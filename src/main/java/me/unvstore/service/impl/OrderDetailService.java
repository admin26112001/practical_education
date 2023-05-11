package me.unvstore.service.impl;

import java.util.List;

import javax.inject.Inject;

import me.unvstore.dao.IOrderDAO;
import me.unvstore.dao.IOrderDetailDAO;
import me.unvstore.dao.IProductDAO;
import me.unvstore.dto.CartDTO;
import me.unvstore.dto.CartDetailDTO;
import me.unvstore.dto.OrderDTO;
import me.unvstore.entity.OrderDetailEntity;
import me.unvstore.service.IOrderDetailService;

public class OrderDetailService implements IOrderDetailService{
	
	@Inject
	private IOrderDetailDAO orderDetailDAO;
	
	@Inject
	private IProductDAO productDAO;
	
	@Inject
	private IOrderDAO orderDAO;

	@Override
	public void save(CartDTO cart, OrderDTO orderDTO) {
		OrderDetailEntity detailEntity = new OrderDetailEntity();
		for(CartDetailDTO cartDetailDTO : cart.getCartDetails()) {
			detailEntity.setPrice(cartDetailDTO.getTotal());
			detailEntity.setQuantity(cartDetailDTO.getQuantity());
			detailEntity.setOrderId(orderDAO.findOne(orderDTO.getOrderId()));
			detailEntity.setProductId(productDAO.findOne(cartDetailDTO.getProduct().getProductId()));
			orderDetailDAO.insert(detailEntity);
		}
	}

	@Override
	public List<OrderDetailEntity> findAll() {
		return orderDetailDAO.findAll();
	}

	@Override
	public List<OrderDetailEntity> findByOrder(Integer orderId) {
		return orderDetailDAO.findByOrder(orderId);
	}

	@Override
	public void delete(Integer orderDetailId) {
		orderDetailDAO.delete(orderDetailId);
	}
	
}
