package com.iwilley.b1ec2.api.response;

import java.util.List;

import com.iwilley.b1ec2.api.B1EC2Response;
import com.iwilley.b1ec2.api.domain.Supplier;
import com.iwilley.b1ec2.api.internal.mapping.ApiField;
import com.iwilley.b1ec2.api.internal.mapping.ApiListField;

public class SupplierQueryResponse extends B1EC2Response {

	
	private static final long serialVersionUID = 4118957599344277771L;
	
	@ApiListField("Suppliers")
	@ApiField("Supplier")
	private List<Supplier> suppliers;

	public List<Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

}
