package com.iwilley.b1ec2.sample;


import com.iwilley.b1ec2.api.ApiException;
import com.iwilley.b1ec2.api.B1EC2Client;
import com.iwilley.b1ec2.api.domain.StockTransfer;
import com.iwilley.b1ec2.api.domain.StockTransferLine;
import com.iwilley.b1ec2.api.request.StockTransferLineUpdateRequest;
import com.iwilley.b1ec2.api.response.StockTransferLineUpdateResponse;

public class StockTransferLineUpdateSample {
	public static void main(String[] args) throws ApiException {
		B1EC2Client client = new B1EC2Client(Constants.URL, Constants.COMPANY,
				Constants.LOGIN_NAME, Constants.PASSWORD);
		
		StockTransferLineUpdateRequest request = new StockTransferLineUpdateRequest();
		request.setTransferId(17);
		StockTransfer stf = new StockTransfer();
		request.setTransferLines(stf.getLines());
		StockTransferLine stfLine = null;
		stfLine = new StockTransferLine();
		stfLine.setSkuCode("NB0533xxl01");
		stfLine.setToWhsArea(4);
		stfLine.setFromWhsArea(3);
		stfLine.setQuantity(2);
		stfLine.setLineMemo("55545454545");
        request.getTransferLines().add(stfLine);
        stfLine = new StockTransferLine();
        stfLine.setSkuCode("SP10001001");
        stfLine.setToWhsArea(4);
        stfLine.setFromWhsArea(3);
        stfLine.setQuantity(2);
        stfLine.setLineMemo("r4rrr2edqw");
        request.getTransferLines().add(stfLine);
        
        StockTransferLineUpdateResponse response = client.execute(request);
        System.out.println(response.getBody());
        System.out.println("errorCode:"+response.getErrorCode()+",errorMessage"+response.getErrorMsg());
	}
}
