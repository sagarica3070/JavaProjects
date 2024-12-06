package com.example.order_service.dto;

import java.util.List;

public class OrderRequest {
	
	 private List<OrderLineItemsDto> orderLineItemsDto;

	public List<OrderLineItemsDto> getOrderLineItemsDto() {
		return orderLineItemsDto;
	}

	public void setOrderLineItemsDto(List<OrderLineItemsDto> orderLineItemsDto) {
		this.orderLineItemsDto = orderLineItemsDto;
	}

	public OrderRequest(List<OrderLineItemsDto> orderLineItemsDto) {
		super();
		this.orderLineItemsDto = orderLineItemsDto;
	}

	public OrderRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	 
	 
	 

}
