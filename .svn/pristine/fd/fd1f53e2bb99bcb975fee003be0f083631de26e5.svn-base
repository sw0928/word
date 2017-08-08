package com.iwilley.b1ec2.api.domain;

import java.util.ArrayList;
import java.util.List;

import com.iwilley.b1ec2.api.internal.mapping.ApiField;
import com.iwilley.b1ec2.api.internal.mapping.ApiListField;

public class Warehouse extends B1EC2Object {
	private static final long serialVersionUID = -3713915138676331918L;

	//²Ö¿âID
    @ApiField("WhsId")
    public int whsId;

    //²Ö¿â´úÂë,8
    @ApiField("WhsCode")
    public String whsCode;

    //²Ö¿âÃû³Æ,20
    @ApiField("WhsName")
    public String whsName;

    @ApiField("PickId")
    public Integer pickId;
    
 	@ApiListField("WhsAreas")
 	@ApiField("WhsArea")
    public List<WhsArea> whsAreas;

    public Warehouse()
    {
        whsAreas = new ArrayList<WhsArea>();
    }

	public int getWhsId() {
		return whsId;
	}

	public void setWhsId(int whsId) {
		this.whsId = whsId;
	}

	public String getWhsCode() {
		return whsCode;
	}

	public void setWhsCode(String whsCode) {
		this.whsCode = whsCode;
	}

	public String getWhsName() {
		return whsName;
	}

	public void setWhsName(String whsName) {
		this.whsName = whsName;
	}

	public List<WhsArea> getWhsAreas() {
		return whsAreas;
	}

	public void setWhsAreas(List<WhsArea> whsAreas) {
		this.whsAreas = whsAreas;
	}

	public Integer getPickId() {
		return pickId;
	}

	public void setPickId(Integer pickId) {
		this.pickId = pickId;
	}


}
