package me.unvstore.dao;

import java.util.List;

import me.unvstore.entity.CategoryEntity;

public interface ICategoryDAO {
	List<CategoryEntity> findAll();
	CategoryEntity findOne(Integer categoryId);
}
