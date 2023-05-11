package me.unvstore.service.impl;

import java.util.List;

import javax.inject.Inject;

import me.unvstore.dao.IImageDAO;
import me.unvstore.entity.ImageEntity;
import me.unvstore.service.IImageService;

public class ImageService implements IImageService{
	@Inject
	private IImageDAO imageDAO;
	
	@Override
	public List<ImageEntity> findAll() {
		return imageDAO.findAll();
	}

	@Override
	public ImageEntity findOne(Integer imageId) {
		return imageDAO.findOne(imageId);
	}

	@Override
	public Integer save(ImageEntity imageEntity) {
		return imageDAO.insert(imageEntity);
	}

	@Override
	public void update(ImageEntity imageEntity) {
		imageDAO.update(imageEntity);
	}

	@Override
	public void delete(Integer imageId) {
		imageDAO.delete(imageId);
	}

}
