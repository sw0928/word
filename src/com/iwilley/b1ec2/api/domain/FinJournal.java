package com.iwilley.b1ec2.api.domain;

import java.util.Date;

import com.iwilley.b1ec2.api.internal.mapping.ApiField;

public class FinJournal extends B1EC2Object {
	

	private static final long serialVersionUID = 2985147578238179695L;

    //���˵�ID
    @ApiField("FinJournalId")
    public int finJournalId;

    //ҵ����ˮ��
    @ApiField("BusinessId")
    public String businessId;

    //������
    @ApiField("ShopOrderId")
    public String shopOrderId;

    //����
    @ApiField("ShopId")
    public int shopId;

    //��Ŀ����
    @ApiField("AccountCode")
    public String accountCode;

    //��Ŀ����
    @ApiField("FinAccount")
    public  FinAccount finAccount;

    //���׽��
    @ApiField("Amount")
    public double amount;

    //�˺����
    @ApiField("AccountBalance")
    public double accountBalance;

    //�˵�״̬
    @ApiField("TransferStatus")
    public int transferStatus;

    //Ӧ��������
    @ApiField("PostDate")
    public Date postDate;

    //����ʱ��
    @ApiField("CreateTime")
    public Date createTime;

    //��ע
    @ApiField("Memo")
    public String memo;

    //����޸�ʱ��
    @ApiField("LastModifiedTime")
    public Date lastModifiedTime;

    //����޸���
    @ApiField("LastModifiedUser")
    public String lastModifiedUser;

	public int getFinJournalId() {
		return finJournalId;
	}

	public void setFinJournalId(int finJournalId) {
		this.finJournalId = finJournalId;
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public String getShopOrderId() {
		return shopOrderId;
	}

	public void setShopOrderId(String shopOrderId) {
		this.shopOrderId = shopOrderId;
	}

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public FinAccount getFinAccount() {
		return finAccount;
	}

	public void setFinAccount(FinAccount finAccount) {
		this.finAccount = finAccount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public int getTransferStatus() {
		return transferStatus;
	}

	public void setTransferStatus(int transferStatus) {
		this.transferStatus = transferStatus;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
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

	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	public String getLastModifiedUser() {
		return lastModifiedUser;
	}

	public void setLastModifiedUser(String lastModifiedUser) {
		this.lastModifiedUser = lastModifiedUser;
	}
    
}
