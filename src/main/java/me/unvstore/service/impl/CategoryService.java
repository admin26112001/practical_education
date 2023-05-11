package me.unvstore.service.impl;

import java.util.List;

import javax.inject.Inject;

import me.unvstore.dao.ICategoryDAO;
import me.unvstore.entity.CategoryEntity;
import me.unvstore.service.ICategoryService;

public class CategoryService implements ICategoryService{

	@Inject
	private ICategoryDAO categoryDAO;
	@Override
	public List<CategoryEntity> findAll() {
		return categoryDAO.findAll();
	}

}
