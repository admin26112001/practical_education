package me.unvstore.service;

import java.util.List;

import me.unvstore.entity.CategoryEntity;

public interface ICategoryService {
	List<CategoryEntity> findAll();
}
