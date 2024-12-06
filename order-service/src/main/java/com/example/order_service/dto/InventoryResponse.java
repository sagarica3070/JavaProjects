package com.example.order_service.dto;


public class InventoryResponse {

    private String skuCode;
    private boolean isInStock;

    // Getters and Setters
    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public boolean isInStock() {
        return isInStock;
    }

    public void setInStock(boolean isInStock) {
        this.isInStock = isInStock;
    }

    // Constructors
    public InventoryResponse(String skuCode, boolean isInStock) {
        this.skuCode = skuCode;
        this.isInStock = isInStock;
    }

    public InventoryResponse() {
        super();
    }

    // Builder Class
    public static class Builder {
        private String skuCode;
        private boolean isInStock;

        public Builder skuCode(String skuCode) {
            this.skuCode = skuCode;
            return this;
        }

        public Builder isInStock(boolean isInStock) {
            this.isInStock = isInStock;
            return this;
        }

        public InventoryResponse build() {
            return new InventoryResponse(skuCode, isInStock);
        }
    }

    // Static Builder Method
    public static Builder builder() {
        return new Builder();
    }
}

