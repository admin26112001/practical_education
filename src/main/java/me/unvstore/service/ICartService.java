package me.unvstore.service;

import me.unvstore.dto.CartDTO;
import me.unvstore.dto.ProductDTO;

public interface ICartService {
	CartDTO addProductToCart(CartDTO cart, ProductDTO product, Integer quantity);
	void editQuantity(CartDTO cart, ProductDTO product, Integer quantity);
	void deleteFromCart(CartDTO cart, Integer productId);
}
