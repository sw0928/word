package com.iwilley.b1ec2.api.response;

import java.util.List;

import com.iwilley.b1ec2.api.B1EC2Response;
import com.iwilley.b1ec2.api.domain.Warehouse;
import com.iwilley.b1ec2.api.internal.mapping.ApiField;
import com.iwilley.b1ec2.api.internal.mapping.ApiListField;

public  class WarehouseQueryResponse extends B1EC2Response {

	private static final long serialVersionUID = -2658876638992452770L;
	
	@ApiListField("Warehouses")
	@ApiField("Warehouse")
	private List<Warehouse> warehouses;

	public List<Warehouse> getWarehouses() {
		return warehouses;
	}

	public void setWarehouses(List<Warehouse> warehouses) {
		this.warehouses = warehouses;
	}

}
