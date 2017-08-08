package com.iwilley.b1ec2.api.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.crypto.Data;

import com.iwilley.b1ec2.api.internal.mapping.ApiField;
import com.iwilley.b1ec2.api.internal.mapping.ApiListField;

// 库存转储单
public class StockTransfer extends B1EC2Object {

	private static final long serialVersionUID = 1L;

	// 转储单ID
	@ApiField("TransferId")
	public int transferId;

	// 转储单号
	@ApiField("StockTransferNo")
	public String stockTransferNo;

	// 转储类型
	// 10:仓内调拨；20仓外调拨
	@ApiField("StockTransferType")
	public int stockTransferType;

	// 转储单状态
	@ApiField("StockTransferStatus")
	public int stockTransferStatus;

	// 从仓库
	@ApiField("FromWhsId")
	public int fromWhsId;

	@ApiField("Warehouse")
	public Warehouse warehouseFrom;

	// 从库区
	@ApiField("FromWhsAreaId")
	public int fromWhsAreaId;

	// 至仓库
	@ApiField("ToWhsId")
	public int toWhsId;

	@ApiField("Warehouse")
	public Warehouse warehouseTo;

	// 至库区
	@ApiField("ToWhsAreaId")
	public int toWhsAreaId;

	// 转储时间
	@ApiField("PostDate")
	public Data postDate;

	// 创建人
	@ApiField("CreateUser")
	public String createUser;

	// 创建时间
	@ApiField("CreateTime")
	public Date createTime;

	// 备注
	@ApiField("Memo")
	public String memo;

	@ApiListField("Lines")
	@ApiField("StockTransferLine")
	public List<StockTransferLine> lines;

	public int getTransferId() {
		return transferId;
	}

	public void setTransferId(int transferId) {
		this.transferId = transferId;
	}

	public String getStockTransferNo() {
		return stockTransferNo;
	}

	public void setStockTransferNo(String stockTransferNo) {
		this.stockTransferNo = stockTransferNo;
	}

	public int getStockTransferType() {
		return stockTransferType;
	}

	public void setStockTransferType(int stockTransferType) {
		this.stockTransferType = stockTransferType;
	}

	public int getStockTransferStatus() {
		return stockTransferStatus;
	}

	public void setStockTransferStatus(int stockTransferStatus) {
		this.stockTransferStatus = stockTransferStatus;
	}

	public int getFromWhsId() {
		return fromWhsId;
	}

	public void setFromWhsId(int fromWhsId) {
		this.fromWhsId = fromWhsId;
	}

	public Warehouse getWarehouseFrom() {
		return warehouseFrom;
	}

	public void setWarehouseFrom(Warehouse warehouseFrom) {
		this.warehouseFrom = warehouseFrom;
	}

	public int getFromWhsAreaId() {
		return fromWhsAreaId;
	}

	public void setFromWhsAreaId(int fromWhsAreaId) {
		this.fromWhsAreaId = fromWhsAreaId;
	}

	public int getToWhsId() {
		return toWhsId;
	}

	public void setToWhsId(int toWhsId) {
		this.toWhsId = toWhsId;
	}

	public Warehouse getWarehouseTo() {
		return warehouseTo;
	}

	public void setWarehouseTo(Warehouse warehouseTo) {
		this.warehouseTo = warehouseTo;
	}

	public int getToWhsAreaId() {
		return toWhsAreaId;
	}

	public void setToWhsAreaId(int toWhsAreaId) {
		this.toWhsAreaId = toWhsAreaId;
	}

	public Data getPostDate() {
		return postDate;
	}

	public void setPostDate(Data postDate) {
		this.postDate = postDate;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public List<StockTransferLine> getLines() {
		return lines;
	}

	public void setLines(List<StockTransferLine> lines) {
		this.lines = lines;
	}

	public StockTransfer() {
		lines = new ArrayList<StockTransferLine>();
	}
}
