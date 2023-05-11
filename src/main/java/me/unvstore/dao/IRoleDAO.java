package me.unvstore.dao;

import java.util.List;

import me.unvstore.entity.RoleEntity;

public interface IRoleDAO {
	List<RoleEntity> findAll();
	RoleEntity findOne(Integer roleId);
}
