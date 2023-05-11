package me.unvstore.service.impl;

import java.util.List;

import javax.inject.Inject;

import me.unvstore.dao.IRoleDAO;
import me.unvstore.entity.RoleEntity;
import me.unvstore.service.IRoleService;

public class RoleService implements IRoleService{
	@Inject
	private IRoleDAO roleDAO;
	
	@Override
	public List<RoleEntity> findAll() {
		return roleDAO.findAll();
	}

	@Override
	public RoleEntity findOne(Integer roleId) {
		return roleDAO.findOne(roleId);
	}

}
