package com.example.product_service.dto;

import java.math.BigDecimal;

import com.example.product_service.model.Product;

public class ProductResponse {


	//private String id;
	private String name;
	private String description;
	private BigDecimal price;
	
	
	
	public ProductResponse() {
		super();
		// TODO Auto-generated constructor stub
	}



	public ProductResponse(String id, String name, String description, BigDecimal price) {
		super();
		//this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	
	
//	public String getId() {
//		//return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
//	
	 public String getName() {
	        return name;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public BigDecimal getPrice() {
	        return price;
	    }

	    // Setters
	    public void setName(String name) {
	        this.name = name;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public void setPrice(BigDecimal price) {
	        this.price = price;
	    }

	    // Builder Pattern
	    public static Builder builder() {
	        return new Builder();
	    }

	    public static class Builder {
	    	//private String id;
	        private String name;
	        private String description;
	        private BigDecimal price;

	        
	        
//	        public Builder id(String id) {
//	            this.id = id;
//	            return this;
//	        }
	        public Builder name(String name) {
	            this.name = name;
	            return this;
	        }

	        public Builder description(String description) {
	            this.description = description;
	            return this;
	        }

	        public Builder price(BigDecimal price) {
	            this.price = price;
	            return this;
	        }

	        public Product build() {
	            Product product = new Product();
	         //   product.setId(this.id);
	            product.setName(this.name);
	            product.setDescription(this.description);
	            product.setPrice(this.price);
	            return product;
	        }
	    }
	}

	

