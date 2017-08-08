package com.iwilley.b1ec2.api.domain;

import com.iwilley.b1ec2.api.internal.mapping.ApiField;

// 商品类目
public class Category extends B1EC2Object {

	private static final long serialVersionUID = -4486291141033132478L;
	// 类目代码
	@ApiField("CatCode")
	public int catCode;

	// 类目名称
	@ApiField("CatName")
	public String catName;

	// 父类代码
	@ApiField("FatherCode")
	public int fatherCode;

	// 路径范例(包含自身): \10\1010\101010
	// 类目路径
	@ApiField("CatPath")
	public String catPath;

	// 是否为叶子
	@ApiField("IsLeaf")
	public Boolean isLeaf;

	public int getCatCode() {
		return catCode;
	}

	public void setCatCode(int catCode) {
		this.catCode = catCode;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public int getFatherCode() {
		return fatherCode;
	}

	public void setFatherCode(int fatherCode) {
		this.fatherCode = fatherCode;
	}

	public String getCatPath() {
		return catPath;
	}

	public void setCatPath(String catPath) {
		this.catPath = catPath;
	}

	public Boolean getIsLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(Boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

}
