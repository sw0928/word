package com.iwilley.b1ec2.api.request;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.iwilley.b1ec2.api.B1EC2Request;
import com.iwilley.b1ec2.api.domain.PurchaseReturnLineInfo;
import com.iwilley.b1ec2.api.internal.util.B1EC2HashMap;
import com.iwilley.b1ec2.api.response.PurchaseReturnResponse;

public class PurchaseReturnRequest implements B1EC2Request<PurchaseReturnResponse>{

    //����ID
    public Integer returnId;
    
    //������
    public String purchaseReturnNo;

    //��������
    public String whsAreaCode;

    public List<PurchaseReturnLineInfo> returnLines;
       
	public String getApiMethodName() {
        return "B1EC2.Purchase.Return";
	}

	public Map<String, String> GetParameters() {
		B1EC2HashMap parameters = new B1EC2HashMap();
		parameters.put("ReturnId", returnId);
		parameters.put("PurchaseReturnNo", purchaseReturnNo);
		parameters.put("WhsAreaCode", whsAreaCode);
		if (returnLines != null && returnLines.size() > 0)
        {
			StringBuffer lineInfo = new StringBuffer();
            for(PurchaseReturnLineInfo returnLine :returnLines)
            {
                lineInfo.append(returnLine.getLineNum());
                lineInfo.append(":");
                lineInfo.append(returnLine.getQuantity());
                lineInfo.append(":");
                lineInfo.append(returnLine.getSerialNumbers());
                lineInfo.append(";");
            }
            parameters.put("LineInfo", lineInfo.toString());
        }
		return parameters;
	}

	public Class<PurchaseReturnResponse> getResponseClass() {
		return PurchaseReturnResponse.class;
	}

	public int getReturnId() {
		return returnId;
	}

	public void setReturnId(int returnId) {
		this.returnId = returnId;
	}

	public String getPurchaseReturnNo() {
		return purchaseReturnNo;
	}

	public void setPurchaseReturnNo(String purchaseReturnNo) {
		this.purchaseReturnNo = purchaseReturnNo;
	}

	public String getWhsAreaCode() {
		return whsAreaCode;
	}

	public void setWhsAreaCode(String whsAreaCode) {
		this.whsAreaCode = whsAreaCode;
	}

	public List<PurchaseReturnLineInfo> getReceiptLines() {
		return returnLines;
	}

	public void setReceiptLines(List<PurchaseReturnLineInfo> returnLines) {
		this.returnLines = returnLines;
	}
	
	public PurchaseReturnRequest()
    {
		returnLines = new ArrayList<PurchaseReturnLineInfo>();
    }
}
