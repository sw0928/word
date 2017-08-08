package com.iwilley.b1ec2.api.domain;

import com.iwilley.b1ec2.api.internal.mapping.ApiField;

public class Brand extends B1EC2Object {
	
	private static final long serialVersionUID = 7714556169907078758L;

	//Æ·ÅÆID
	@ApiField("BrandId")
    public int brandId;

    //Æ·ÅÆÃû³Æ,20
    @ApiField("BrandName")
    public String brandName;

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	
}
