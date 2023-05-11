package me.unvstore.service;

import java.util.List;

import me.unvstore.entity.RoleEntity;

public interface IRoleService {
	List<RoleEntity> findAll();
	RoleEntity findOne(Integer roleId);
}
