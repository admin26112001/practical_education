package me.unvstore.service.impl;

import java.util.List;

import javax.inject.Inject;

import me.unvstore.converter.ProductConverter;
import me.unvstore.dao.ICategoryDAO;
import me.unvstore.dao.IImageDAO;
import me.unvstore.dao.IInformationDAO;
import me.unvstore.dao.IProductDAO;
import me.unvstore.dto.ProductDetailDTO;
import me.unvstore.entity.ProductEntity;
import me.unvstore.service.IProductService;

public class ProductService implements IProductService{
	@Inject
	private IProductDAO productDAO;
	
	@Inject
	private ICategoryDAO categoryDAO;
	

	@Inject
	private IInformationDAO informationDAO;
	
	@Inject
	private IImageDAO imageDAO;
	
	@Inject ProductConverter productConverter;
	
	@Override
	public List<ProductEntity> findAll() {
		return productDAO.findAll();
	}

	@Override
	public ProductEntity findOne(Integer productId) {
		return productDAO.findOne(productId);
	}

	@Override
	public List<ProductEntity> findByBrand(Integer brandId) {
		return productDAO.findByBrand(brandId);
	}

	@Override
	public void update(ProductDetailDTO productDetailDTO) {
		ProductEntity productEntity = new ProductEntity();
		productEntity.setProductId(productDetailDTO.getProductId());
		productEntity.setProductName(productDetailDTO.getProductName());
		productEntity.setCategoryId(categoryDAO.findOne(productDetailDTO.getCategoryId()));
		productEntity.setImageId(imageDAO.findOne(productDetailDTO.getImageId()));
		productEntity.setInfoId(informationDAO.findOne(productDetailDTO.getInfoId()));
		productEntity.setDescription(productDetailDTO.getDescription());
		productEntity.setPrice(productDetailDTO.getPrice());
		
		productDAO.update(productEntity);
	}

	@Override
	public Integer save(ProductDetailDTO productDetailDTO) {
		ProductEntity productEntity = new ProductEntity();
		productEntity.setProductId(productDetailDTO.getProductId());
		productEntity.setProductName(productDetailDTO.getProductName());
		productEntity.setCategoryId(categoryDAO.findOne(productDetailDTO.getCategoryId()));
		productEntity.setInfoId(informationDAO.findOne(productDetailDTO.getInfoId()));
		productEntity.setImageId(imageDAO.findOne(productDetailDTO.getImageId()));
		productEntity.setDescription(productDetailDTO.getDescription());
		productEntity.setPrice(productDetailDTO.getPrice());
		
		return productDAO.insert(productEntity);
	}

	@Override
	public void delete(Integer productId) {
		ProductEntity product = productDAO.findOne(productId);
		informationDAO.delete(product.getInfoId().getInfoId());
		imageDAO.delete(product.getImageId().getImageId());
		productDAO.delete(productId);
	}

	@Override
	public void updateByImage(ProductEntity productEntity) {
		productDAO.update(productEntity);
	}

	@Override
	public List<ProductEntity> search(String keyWord) {
		return productDAO.search(keyWord);
	}

	@Override
	public List<ProductEntity> findByCategory(Integer categoryId) {
		return productDAO.findByCategory(categoryId);
	}

	@Override
	public List<ProductEntity> findProductOutstanding() {
		return productDAO.findProductOutstanding();
	}

	@Override
	public Long productNumber() {
		return productDAO.productNumber();
	}

}
