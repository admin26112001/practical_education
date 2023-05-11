package me.unvstore.service;

import java.util.List;

import me.unvstore.dto.CartDTO;
import me.unvstore.dto.OrderDTO;
import me.unvstore.entity.OrderDetailEntity;

public interface IOrderDetailService {
	void save(CartDTO cart, OrderDTO orderDTO);
	List<OrderDetailEntity> findAll();
	List<OrderDetailEntity> findByOrder(Integer orderId);
	void delete(Integer orderDetailId);
}
