package com.iwilley.b1ec2.sample;

import java.util.ArrayList;
import java.util.List;

import com.iwilley.b1ec2.api.ApiException;
import com.iwilley.b1ec2.api.B1EC2Client;
import com.iwilley.b1ec2.api.domain.SkuCreateLine;
import com.iwilley.b1ec2.api.request.ItemCreateRequest;
import com.iwilley.b1ec2.api.response.ItemCreateResponse;

public class ItemCreateSample_FALSE {
	public static void main(String[] args) throws ApiException {
		B1EC2Client client = new B1EC2Client(Constants.URL, Constants.COMPANY,
				Constants.LOGIN_NAME, Constants.PASSWORD);
		ItemCreateRequest request = new ItemCreateRequest();
		request.itemCode = "fdg324234";
		request.itemName = "444";
		request.isVirtual = true;
		request.supplierCode = "SupplierCode";
		request.barCode = "jjh1110222";
		request.pictureUrl = "PictureUrl";
		request.purchasePrice = 10.2;
		request.salesPrice = 40.0;
		request.lowestPrice = 20.0;
		request.marketPrice = 30.0;
		request.unit = "meter";
		request.purchaseUnit = "centerMeter";
		request.size = 10.1;
		request.weight = 0.12;
		request.property1 = "Property1";
		request.property2 = "Property2";
		request.property3 = "Property3";
		request.property4 = "Property4";
		request.property5 = "Property5";
		request.property6 = "Property6";
		request.property7 = "Property7";
		request.property8 = "Property8";
		request.property9 = "Property9";
		request.property10 = "Property10";
		request.property11 = "Property11";
		request.property12 = "Property12";
		List<SkuCreateLine> skuList = new ArrayList<SkuCreateLine>();
		SkuCreateLine sku1 = new SkuCreateLine();
		sku1.skuCode = "testSku1";
		sku1.barCode = "testSku1";
		sku1.property1 = "Property1";
		sku1.property2 = "Property2";
		sku1.salesPrice = 22.0;
		sku1.unit = "kg";
		skuList.add(sku1);
		SkuCreateLine sku2 = new SkuCreateLine();
		sku2.skuCode = "testsku2";
		sku2.barCode = "testsku2";
		sku2.property1 = "Property1";
		sku2.property2 = "Property2";
		sku2.salesPrice = 22.0;
		sku2.unit = "kg";
		skuList.add(sku2);
		request.setSkus(skuList);
		ItemCreateResponse response = client.execute(request);
		System.out.println(response.getBody());
		System.out.println("errorCode:" + response.getErrorCode()
				+ ",errorMessage" + response.getErrorMsg());
	}
}
