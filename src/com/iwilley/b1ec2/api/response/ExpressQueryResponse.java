package com.iwilley.b1ec2.api.response;

import java.util.List;

import com.iwilley.b1ec2.api.B1EC2Response;
import com.iwilley.b1ec2.api.domain.Express;
import com.iwilley.b1ec2.api.internal.mapping.ApiField;
import com.iwilley.b1ec2.api.internal.mapping.ApiListField;

public class ExpressQueryResponse extends B1EC2Response {

	private static final long serialVersionUID = 1681860172988485216L;
	
	@ApiListField("Expresses")
	@ApiField("Express")
	private List<Express> expresses;

	public List<Express> getExpresses() {
		return expresses;
	}

	public void setExpresses(List<Express> expresses) {
		this.expresses = expresses;
	}

}
