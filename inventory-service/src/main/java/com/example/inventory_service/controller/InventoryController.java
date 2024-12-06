package com.example.inventory_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventory_service.Service.InventoryService;
import com.example.inventory_service.dto.InventoryResponse;

@RestController
@RequestMapping("/api/inventory")

public class InventoryController {

	@Autowired
	public InventoryService inventoryService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	//public List<InventoryResponse> inStock(@RequestParam("skuCode") List<String> skuCode)
	public List<InventoryResponse> inStock(@RequestParam ("skuCode") List<String> skuCode)
{
	return inventoryService.isInStock(skuCode);
	
	
}
	
	
	
	

}

