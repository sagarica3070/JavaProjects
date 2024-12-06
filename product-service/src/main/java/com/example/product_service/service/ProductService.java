package com.example.product_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product_service.dto.ProductRequest;
import com.example.product_service.dto.ProductResponse;
import com.example.product_service.model.Product;
import com.example.product_service.repository.ProductRepository;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {

	@Autowired
	public ProductRepository productRepository;

	public void createProduct(ProductRequest productRequest) {

		Product product = Product.builder().name(productRequest.getName()).description(productRequest.getDescription())
				.price(productRequest.getPrice()).build();

		productRepository.save(product);
		// Log.("Product {} is saved", product.getId());
	}

	public List<ProductResponse> getAllProducts() {
		// TODO Auto-generated method stub
		List<Product> products = productRepository.findAll();

		List<ProductResponse> result = new ArrayList<>();
		for (Product product : products) {
			ProductResponse res = new ProductResponse();

			// res.setId(product.getId());
			res.setName(product.getName());
			res.setDescription(product.getDescription());
			res.setPrice(product.getPrice());

			result.add(res);
		}

		return result;
	}

}