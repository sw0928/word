package com.iwilley.b1ec2.sample;

import java.util.ArrayList;
import java.util.List;

import com.iwilley.b1ec2.api.ApiException;
import com.iwilley.b1ec2.api.B1EC2Client;
import com.iwilley.b1ec2.api.domain.AfterSaleServiceExchangeAndRedeliveryItemLine;
import com.iwilley.b1ec2.api.domain.AfterSaleServiceReturnItemLine;
import com.iwilley.b1ec2.api.request.AfterSalesServiceCreateRequest;
import com.iwilley.b1ec2.api.response.AfterSalesServiceCreateResponse;

public class AfterSalesServiceCreateSample {
	public static void main(String[] args) throws ApiException {
		B1EC2Client client = new B1EC2Client(Constants.URL, Constants.COMPANY,
				Constants.LOGIN_NAME, Constants.PASSWORD);
		AfterSalesServiceCreateRequest request = new AfterSalesServiceCreateRequest();
		
		request.setOrderNo("20150505000799");
		request.setRefundMemo("java test");
		request.setType(30);
        request.setReceiverName("黄县僧");
        request.setReceiverState("北京");
        request.setReceiverCity("北京市");
        request.setReceiverDistrict("东城区");
        request.setReceiverAddress("新街口外大街4-103");
        request.setReceiverMobile("18614088260");
        request.setUserDefinedField1("userDefinedField1");
        request.setUserDefinedField2("userDefinedField2");
        request.setUserDefinedField3("userDefinedField3");
        request.setUserDefinedField4("userDefinedField4");
        
        List<AfterSaleServiceReturnItemLine> returnLines = new ArrayList<AfterSaleServiceReturnItemLine>();
        AfterSaleServiceReturnItemLine afterSaleServiceReturnItemLine1 = new AfterSaleServiceReturnItemLine();
        afterSaleServiceReturnItemLine1.setOrderLineNum(0);
        afterSaleServiceReturnItemLine1.setQuantity(1);
        AfterSaleServiceReturnItemLine afterSaleServiceReturnItemLine2 = new AfterSaleServiceReturnItemLine();
        afterSaleServiceReturnItemLine2.setOrderLineNum(1);
        afterSaleServiceReturnItemLine2.setQuantity(2);
        returnLines.add(afterSaleServiceReturnItemLine1);
        returnLines.add(afterSaleServiceReturnItemLine2);
        request.setReturnItemLines(returnLines);
        List<AfterSaleServiceExchangeAndRedeliveryItemLine> exchangeAndRedeliveryItemLines = new ArrayList<AfterSaleServiceExchangeAndRedeliveryItemLine>();
        AfterSaleServiceExchangeAndRedeliveryItemLine afterSaleServiceExchangeAndRedeliveryItemLine2 = new AfterSaleServiceExchangeAndRedeliveryItemLine();
        afterSaleServiceExchangeAndRedeliveryItemLine2.setOrderLineNum(0);
        afterSaleServiceExchangeAndRedeliveryItemLine2.setQuantity(1);
        exchangeAndRedeliveryItemLines.add(afterSaleServiceExchangeAndRedeliveryItemLine2);
        request.setExchangeAndRedeliveryItemLines(exchangeAndRedeliveryItemLines);
        
        AfterSalesServiceCreateResponse response = client.execute(request);
        System.out.println(response.getBody());
        System.out.println("errorCode:"+response.getErrorCode()+",errorMessage"+response.getErrorMsg());
	}
}
