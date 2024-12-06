package com.example.order_service.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.order_service.dto.InventoryResponse;
import com.example.order_service.dto.OrderLineItemsDto;
import com.example.order_service.dto.OrderRequest;
import com.example.order_service.entity.Order;
import com.example.order_service.entity.OrderLineItems;
import com.example.order_service.repository.OrderRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderService {

	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	WebClient.Builder webClientBuilder; 
	
	public void placeOrder(OrderRequest orderRequest) {
		Order order = new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
//		List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDto().stream()
//				.map(orderLineItemDto -> maptoDto(orderLineItemDto)).toList();
//		order.setOrderLineItemsList(orderLineItems);
//		
		
		
	List<OrderLineItems> list= new ArrayList<>();
	for (OrderLineItemsDto ol : orderRequest.getOrderLineItemsDto()) {
		
		OrderLineItems oli = new OrderLineItems();
		oli.setPrice(ol.getPrice());
		oli.setSkuCode(ol.getSkuCode());
		oli.setQuantity(ol.getQuantity());
		//oli.setPrice(null);
		
		list.add(oli);
		
	}	
	order.setOrderLineItemsList(list);
	List<String>skuCodes=order.getOrderLineItemsList().stream().map(OrderLineItems::getSkuCode).toList();
	
	//make a get call to the inventory service to check if the products exists in the inventory;
//
	
	InventoryResponse[] inventoryResponseArray = 
			webClientBuilder.build().get().uri("http://inventory-service/api/inventory", uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build()).retrieve().bodyToMono(InventoryResponse[].class).block();

	
	
//	
//	.uri("http://localhost:8092/api/inventory",uriBuilder->uriBuilder.queryParam("name", "skuCode", skuCodes).build()).retrieve().bodyToMono(InventoryResponse[].class)
//		.block();
//	InventoryResponse[] inventoryResponseArray = webClient.get()
//		    .uri(uriBuilder -> uriBuilder
//		        .path("http://localhost:8092/api/inventory")
//		        .queryParam("skuCode", skuCodes)
//		        .build())
//		    .retrieve()
//		    .bodyToMono(InventoryResponse[].class)
//		    .block();
	
//	InventoryResponse[] inventoryResponseArray = webClient.get()
//		    .uri(uriBuilder -> uriBuilder
//		        .scheme("http")
//		        .host("localhost")
//		        .port(8092)
//		        .path("/api/inventory")
//		        .queryParam("skuCode", skuCodes)
//		        .build())
//		    .retrieve()
//		    .bodyToMono(InventoryResponse[].class)
//		    .block();
//
	boolean allProductsInStock=Arrays.stream(inventoryResponseArray).allMatch(InventoryResponse::isInStock);
	
	
	if (allProductsInStock) {
		orderRepository.save(order);
	} else {

		throw new IllegalArgumentException("Product is not in stock, please try again later");
	}
}
	public OrderLineItems maptoDto(OrderLineItemsDto orderLineItemsDto) {
		OrderLineItems orderLineItems = new OrderLineItems();
		orderLineItems.setPrice(orderLineItemsDto.getPrice());
		orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
		orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
		return orderLineItems;
	}
}


