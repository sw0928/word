package com.iwilley.b1ec2.api.request;

import java.util.List;
import java.util.Map;

import com.iwilley.b1ec2.api.B1EC2Request;
import com.iwilley.b1ec2.api.internal.util.B1EC2HashMap;
import com.iwilley.b1ec2.api.response.StockQueryResponse;

public class StockQueryRequest implements B1EC2Request<StockQueryResponse>{

    //�ֿ�ID
    public Integer whsId;
    
    //sku
    public List<String> skus;
       
	public String getApiMethodName() {
        return "B1EC2.Stock.Query";
	}

	public Map<String, String> GetParameters() {
		B1EC2HashMap parameters = new B1EC2HashMap();
		parameters.put("WhsId", whsId);
		if (skus != null && skus.size() > 0)
        {
			StringBuffer lineInfo = new StringBuffer();
            for(String sku :skus)
            {
                lineInfo.append(sku);
                lineInfo.append(";");
            }
            parameters.put("SkuInfo", lineInfo.toString());
        }
		return parameters;
	}

	public Class<StockQueryResponse> getResponseClass() {
		return StockQueryResponse.class;
	}

	public Integer getWhsId() {
		return whsId;
	}

	public void setWhsId(Integer whsId) {
		this.whsId = whsId;
	}

	public List<String> getSkus() {
		return skus;
	}

	public void setSkus(List<String> skus) {
		this.skus = skus;
	}

	
	
}
