package com.iwilley.b1ec2.api.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.iwilley.b1ec2.api.internal.mapping.ApiField;
import com.iwilley.b1ec2.api.internal.mapping.ApiListField;

public class PurchaseReturn extends B1EC2Object {

	private static final long serialVersionUID = 2282158723466756631L;

	// 出库单ID
	@ApiField("ReturnId")
	public int returnId;

	// 出库单号
	@ApiField("PurchaseReturnNo")
	public String purchaseReturnNo;

	// 供应商代码
	@ApiField("SupplierId")
	public int supplierId;

	@ApiField("Supplier")
	public Supplier supplier;

	// 仓库代码
	@ApiField("WhsId")
	public int whsId;

	@ApiField("Warehouse")
	public Warehouse warehouse;

	// 出库单状态
	@ApiField("PurchaseReturnStatus")
	public int purchaseReturnStatus;

	// 退货时间
	@ApiField("PostDate")
	public Date postDate;

	// 是否打开原始订单
	@ApiField("ReopenPurchaseOrder")
	public Boolean reopenPurchaseOrder;

	// 创建人
	@ApiField("CreateUser")
	public String createUser;

	// 创建时间
	@ApiField("CreateTime")
	public Date createTime;

	// 最后修改日期
	@ApiField("LastModifiedTime")
	public Date lastModifiedTime;

	// 最后修改人
	@ApiField("LastModifiedUser")
	public String lastModifiedUser;

	// 备注
	@ApiField("Memo")
	public String memo;

	// 未清金额
	@ApiField("OpenTotal")
	public double openTotal;

	// 退货总额
	@ApiField("ReturnTotal")
	public double returnTotal;

	@ApiListField("Lines")
	@ApiField("PurchaseReturnLine")
	public List<PurchaseReturnLine> lines;

	public int getReturnId() {
		return returnId;
	}

	public String getPurchaseReturnNo() {
		return purchaseReturnNo;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public int getWhsId() {
		return whsId;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public int getPurchaseReturnStatus() {
		return purchaseReturnStatus;
	}

	public Date getPostDate() {
		return postDate;
	}

	public Boolean getReopenPurchaseOrder() {
		return reopenPurchaseOrder;
	}

	public String getCreateUser() {
		return createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}

	public String getLastModifiedUser() {
		return lastModifiedUser;
	}

	public String getMemo() {
		return memo;
	}

	public double getOpenTotal() {
		return openTotal;
	}

	public double getReturnTotal() {
		return returnTotal;
	}

	public List<PurchaseReturnLine> getLines() {
		return lines;
	}

	public void setReturnId(int returnId) {
		this.returnId = returnId;
	}

	public void setPurchaseReturnNo(String purchaseReturnNo) {
		this.purchaseReturnNo = purchaseReturnNo;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public void setWhsId(int whsId) {
		this.whsId = whsId;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public void setPurchaseReturnStatus(int purchaseReturnStatus) {
		this.purchaseReturnStatus = purchaseReturnStatus;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public void setReopenPurchaseOrder(Boolean reopenPurchaseOrder) {
		this.reopenPurchaseOrder = reopenPurchaseOrder;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	public void setLastModifiedUser(String lastModifiedUser) {
		this.lastModifiedUser = lastModifiedUser;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public void setOpenTotal(double openTotal) {
		this.openTotal = openTotal;
	}

	public void setReturnTotal(double returnTotal) {
		this.returnTotal = returnTotal;
	}

	public void setLines(List<PurchaseReturnLine> lines) {
		this.lines = lines;
	}

	public PurchaseReturn() {
		lines = new ArrayList<PurchaseReturnLine>();
	}

}
