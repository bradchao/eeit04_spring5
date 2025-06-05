package com.example.demo.dto;

import java.util.Date;
import java.util.List;

public class OrderDto {
	private Integer orderid;
	private Date orderdate;	
	private List<OrderDetailDto> detail;
	
	public OrderDto(Integer orderid,
			Date orderdate,
			List<OrderDetailDto> detail
			) {
		this.orderid = orderid;
		this.orderdate = orderdate;
		this.detail = detail;
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

	public List<OrderDetailDto> getDetail() {
		return detail;
	}

	public void setDetail(List<OrderDetailDto> detail) {
		this.detail = detail;
	}
	
	
}
