package me.unvstore.service;

import java.util.List;

import me.unvstore.dto.OrderDTO;
import me.unvstore.entity.OrderEntity;

public interface IOrderService {
	OrderDTO save(OrderDTO orderDTO);
	List<OrderEntity> findByUser(Integer useId);
	List<OrderEntity> findAll();
	void update(OrderDTO orderDTO);
	void delete(Integer orderId);
	List<OrderEntity> findByStatus(Integer status);
	Long getEarning();
	Long orderSuccessNumber();
}
