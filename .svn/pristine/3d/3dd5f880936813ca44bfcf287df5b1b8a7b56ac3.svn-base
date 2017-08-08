package com.iwilley.b1ec2.api.request;

import java.util.List;
import java.util.Map;

import com.iwilley.b1ec2.api.B1EC2Request;
import com.iwilley.b1ec2.api.domain.StockTransferLine;
import com.iwilley.b1ec2.api.internal.util.B1EC2HashMap;
import com.iwilley.b1ec2.api.response.StockTransferLineUpdateResponse;

public class StockTransferLineUpdateRequest implements B1EC2Request<StockTransferLineUpdateResponse> {
	
	// ת����ID
	public Integer transferId;
	
	// ת������
	public String stockTransferNo;
	
	// ���ת��������Ϣ
	private List<StockTransferLine> transferLines;
	
	public String getApiMethodName() {
		return "B1EC2.StockTransferLine.Update";
	}

	public Map<String, String> GetParameters() {
		B1EC2HashMap parameters = new B1EC2HashMap();
		parameters.put("TransferId", transferId);
		parameters.put("StockTransferNo", stockTransferNo);
		if (transferLines != null && transferLines.size() > 0) {
			StringBuffer lineInfo = new StringBuffer();
			for (StockTransferLine transferLine : transferLines) {
				lineInfo.append(transferLine.getSkuCode());
                lineInfo.append(":");
                lineInfo.append(transferLine.getFromWhsArea());
                lineInfo.append(":");
                lineInfo.append(transferLine.getToWhsArea());
                lineInfo.append(":");
                lineInfo.append(transferLine.getQuantity());
                lineInfo.append(":");
                lineInfo.append(transferLine.getLineMemo());
                lineInfo.append(";");
			}
			parameters.put("TransferLineInfo", lineInfo.toString());
		}
		return parameters;
	}

	public Class<StockTransferLineUpdateResponse> getResponseClass() {
		return StockTransferLineUpdateResponse.class;
	}

	public Integer getTransferId() {
		return transferId;
	}

	public void setTransferId(Integer transferId) {
		this.transferId = transferId;
	}

	public String getStockTransferNo() {
		return stockTransferNo;
	}

	public void setStockTransferNo(String stockTransferNo) {
		this.stockTransferNo = stockTransferNo;
	}

	public List<StockTransferLine> getTransferLines() {
		return transferLines;
	}

	public void setTransferLines(List<StockTransferLine> transferLines) {
		this.transferLines = transferLines;
	}
	
}
