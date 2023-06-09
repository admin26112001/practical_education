package me.unvstore.converter;

import me.unvstore.dto.ImageDTO;
import me.unvstore.entity.ImageEntity;

public class ImageConverter {
	public ImageEntity toEntity(ImageDTO imageDTO) {
		ImageEntity imageEntity = new ImageEntity();
		imageEntity.setImageSmall(imageDTO.getImageSmall());
		imageEntity.setImageBig(imageDTO.getImageBig());
		return imageEntity;
	}
	
	public ImageDTO toDto(ImageEntity imageEntity) {
		ImageDTO imageDto = new ImageDTO();
		imageDto.setImageId(imageEntity.getImageId());
		imageDto.setImageBig(imageEntity.getImageBig());
		imageDto.setImageSmall(imageEntity.getImageSmall());
		return imageDto;
	}
}
