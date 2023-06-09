package me.unvstore.dao;

import java.util.List;

import me.unvstore.entity.OrderEntity;

public interface IOrderDAO {
	Integer insert(OrderEntity orderEntity);
	OrderEntity findOne(Integer id);
	List<OrderEntity> findByUser(Integer userId);
	List<OrderEntity> findAll();
	void update(OrderEntity orderEntity);
	void delete(Integer orderId);
	List<OrderEntity> findByStatus(Integer status);
	Long getEarning();
	Long orderSuccessNumber();
	
}
