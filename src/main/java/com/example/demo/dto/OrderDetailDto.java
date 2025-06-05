package com.example.demo.dto;

import java.math.BigDecimal;

public class OrderDetailDto {
	private BigDecimal unitPrice;
	private Integer quantity;
	private String productName;
	
	public OrderDetailDto(
			BigDecimal unitPrice,
			Integer quantity,
			String productName
			) {
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.productName = productName;
		
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
	
	
}
