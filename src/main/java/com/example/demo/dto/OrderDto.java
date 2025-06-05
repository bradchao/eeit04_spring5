package com.example.demo.dto;

import java.util.Date;

public class OrderDto {
	private Integer orderid;
	private Date orderdate;	
	
	public OrderDto(Integer orderid,
			Date orderdate
			) {
		this.orderid = orderid;
		this.orderdate = orderdate;
	}

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	
	
}
