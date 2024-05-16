package com.ssafit.shopping.model.dao;

import java.util.List;

import com.ssafit.shopping.model.dto.Product;

public interface ProductDao {
	List<Product> findByIdIn(List<Integer> ids);
}
