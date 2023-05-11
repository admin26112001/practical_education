package me.unvstore.service;

import java.util.List;

import me.unvstore.entity.ImageEntity;

public interface IImageService {
	List<ImageEntity> findAll();
	ImageEntity findOne(Integer imageId);
	Integer save(ImageEntity imageEntity);
	void update(ImageEntity imageEntity);
	void delete(Integer imageId);
}
