package com.example.inventory_service.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventory_service.dto.InventoryResponse;
import com.example.inventory_service.repository.InventoryRepository;

import jakarta.transaction.Transactional;

@Service
public class InventoryService {

	
	@Autowired
	InventoryRepository inventoryRepository;
	
	@Transactional
	public List<InventoryResponse> isInStock(List<String> skuCode)
	{
		return inventoryRepository.findBySkuCodeIn(skuCode).stream().map(inventory->InventoryResponse.builder()
																									 .skuCode(inventory.getSkuCode())
																									 .isInStock(inventory.getQuantity()>0)
																									 .build()).toList();
	}
}


