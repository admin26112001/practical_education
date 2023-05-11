package me.unvstore.service;

import me.unvstore.dto.InformationDTO;
import me.unvstore.dto.ProductDetailDTO;

public interface IInformationService {
	InformationDTO findOne(Integer infId);
	void update(ProductDetailDTO productDetailDTO);
	Integer save(ProductDetailDTO productDetailDTO);
}
