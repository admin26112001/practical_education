package me.unvstore.service.impl;

import java.util.List;

import javax.inject.Inject;

import me.unvstore.converter.UserConverter;
import me.unvstore.dao.IRoleDAO;
import me.unvstore.dao.IUserDAO;
import me.unvstore.dto.UserDTO;
import me.unvstore.entity.RoleEntity;
import me.unvstore.entity.UserEntity;
import me.unvstore.service.IUserService;

public class UserService implements IUserService{
	@Inject 
	private IUserDAO userDAO;
	
	@Inject
	private IRoleDAO roleDAO;
	
	@Inject
	private UserConverter converter;
	
	@Override
	public UserEntity findByEmailPassword(String email, String password) {
		return userDAO.findByEmailPassword(email, password);
	}

	@Override
	public UserEntity save(UserDTO userDTO) {
		RoleEntity role = new RoleEntity();
		role.setRoleId(2);
		UserEntity userEntity = new UserEntity();
		userEntity = converter.toEntity(userEntity, userDTO);
		userEntity.setRole(role);
		Integer id = userDAO.insert(userEntity);
		return userDAO.findOne(id);
	}

	@Override
	public UserEntity findOne(Integer userId) {
		return userDAO.findOne(userId);
	}

	@Override
	public List<UserEntity> findAll() {
		return userDAO.findAll();
	}

	@Override
	public void update(UserDTO userDTO) {
		UserEntity userEntity = userDAO.findOne(userDTO.getUserId());
		userEntity = converter.toEntity(userEntity, userDTO);
		if(userDTO.getRoleId() != null) {
			RoleEntity role = roleDAO.findOne(userDTO.getRoleId());
			userEntity.setRole(role);
		}
		userDAO.update(userEntity);
	}

	@Override
	public void delete(Integer userId) {
		userDAO.delete(userId);
	}

	@Override
	public Long customerNumber() {
		return userDAO.customerNumber();
	}

	@Override
	public List<UserEntity> findByEmail(String email) {
		return userDAO.findByEmail(email);
	}

}
