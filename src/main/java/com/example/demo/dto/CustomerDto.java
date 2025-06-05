package com.example.demo.dto;

public class CustomerDto {
	private String customerid;
	private String companyName;
	
	public CustomerDto(String customerid,
			String companyName
			) {
		this.customerid = customerid;
		this.companyName = companyName;
	}
	
	public String getCustomerid() {
		return customerid;
	}
	public String getCompanyName() {
		return companyName;
	}
	
	
	
}
