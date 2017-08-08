package com.iwilley.b1ec2.api.request;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.iwilley.b1ec2.api.B1EC2Request;
import com.iwilley.b1ec2.api.domain.PurchaseReceiptLine;
import com.iwilley.b1ec2.api.internal.util.B1EC2HashMap;
import com.iwilley.b1ec2.api.response.PurchaseReceiptResponse;

public class PurchaseReceiptRequest implements B1EC2Request<PurchaseReceiptResponse>{

    //����ID
    public Integer purchaseOrderId;
    
    //������
    public String purchaseOrderNo;

    //��������
    public String whsAreaCode;

    public List<PurchaseReceiptLine> receiptLines;
    
    //��ע
    public String memo;
    
  //�Զ����ֶ�1
    public String userDefinedField1;

    //�Զ����ֶ�2
    public String userDefinedField2;

    //�Զ����ֶ�3
    public String userDefinedField3;

    //�Զ����ֶ�4
    public String userDefinedField4;

    //�Զ����ֶ�5
    public String userDefinedField5;

	//�Զ�������6
    public Double userDefinedField6;

    //�Զ�������7
    public Double userDefinedField7;

    //�Զ�������8
    public Date userDefinedField8;
       
	public String getApiMethodName() {
        return "B1EC2.Purchase.Receipt";
	}

	public Map<String, String> GetParameters() {
		B1EC2HashMap parameters = new B1EC2HashMap();
		parameters.put("PurchaseOrderId", purchaseOrderId);
		parameters.put("PurchaseOrderNo", purchaseOrderNo);
		parameters.put("WhsAreaCode", whsAreaCode);
		parameters.put("Memo", memo);
		parameters.put("UserDefinedField1", userDefinedField1);
		parameters.put("UserDefinedField2", userDefinedField2);
		parameters.put("UserDefinedField3", userDefinedField3);
		parameters.put("UserDefinedField4", userDefinedField4);
		parameters.put("UserDefinedField5", userDefinedField5);
		parameters.put("UserDefinedField6", userDefinedField6);
		parameters.put("UserDefinedField7", userDefinedField7);
		parameters.put("UserDefinedField8", userDefinedField8);
		if (receiptLines != null && receiptLines.size() > 0)
        {
			StringBuffer lineInfo = new StringBuffer();
            for(PurchaseReceiptLine receiptLine :receiptLines)
            {
                lineInfo.append(receiptLine.getLineNum());
                lineInfo.append(":");
                lineInfo.append(receiptLine.getQuantity());
                lineInfo.append(":");
                lineInfo.append(receiptLine.getSerialNumbers());
                lineInfo.append(";");
            }
            parameters.put("LineInfo", lineInfo.toString());
        }
		return parameters;
	}

	public Class<PurchaseReceiptResponse> getResponseClass() {
		return PurchaseReceiptResponse.class;
	}

	public int getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(int purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public String getPurchaseOrderNo() {
		return purchaseOrderNo;
	}

	public void setPurchaseOrderNo(String purchaseOrderNo) {
		this.purchaseOrderNo = purchaseOrderNo;
	}

	public String getWhsAreaCode() {
		return whsAreaCode;
	}

	public void setWhsAreaCode(String whsAreaCode) {
		this.whsAreaCode = whsAreaCode;
	}

	public List<PurchaseReceiptLine> getReceiptLines() {
		return receiptLines;
	}

	public void setReceiptLines(List<PurchaseReceiptLine> receiptLines) {
		this.receiptLines = receiptLines;
	}
	public String getUserDefinedField1() {
		return userDefinedField1;
	}

	public void setUserDefinedField1(String userDefinedField1) {
		this.userDefinedField1 = userDefinedField1;
	}

	public String getUserDefinedField2() {
		return userDefinedField2;
	}

	public void setUserDefinedField2(String userDefinedField2) {
		this.userDefinedField2 = userDefinedField2;
	}

	public String getUserDefinedField3() {
		return userDefinedField3;
	}

	public void setUserDefinedField3(String userDefinedField3) {
		this.userDefinedField3 = userDefinedField3;
	}

	public String getUserDefinedField4() {
		return userDefinedField4;
	}

	public void setUserDefinedField4(String userDefinedField4) {
		this.userDefinedField4 = userDefinedField4;
	}

	public String getUserDefinedField5() {
		return userDefinedField5;
	}

	public void setUserDefinedField5(String userDefinedField5) {
		this.userDefinedField5 = userDefinedField5;
	}

	public Double getUserDefinedField6() {
		return userDefinedField6;
	}

	public void setUserDefinedField6(Double userDefinedField6) {
		this.userDefinedField6 = userDefinedField6;
	}

	public Double getUserDefinedField7() {
		return userDefinedField7;
	}

	public void setUserDefinedField7(Double userDefinedField7) {
		this.userDefinedField7 = userDefinedField7;
	}

	public Date getUserDefinedField8() {
		return userDefinedField8;
	}

	public void setUserDefinedField8(Date userDefinedField8) {
		this.userDefinedField8 = userDefinedField8;
	}
	
	public String getMemo() {
		 return memo;
	}

	public void setMemo(String memo) {
		 this.memo = memo;
	}
	public PurchaseReceiptRequest()
    {
		receiptLines = new ArrayList<PurchaseReceiptLine>();
    }
}
