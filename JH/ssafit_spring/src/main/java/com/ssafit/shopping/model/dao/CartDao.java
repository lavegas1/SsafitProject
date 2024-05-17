package com.ssafit.shopping.model.dao;

import java.util.List;

import com.ssafit.shopping.model.dto.Cart;

public interface CartDao {
	List<Cart> findByUserId(String id);
	Cart findByUserIdAndProductId(String id, int productId);
	void insertCart(Cart cart);
}
