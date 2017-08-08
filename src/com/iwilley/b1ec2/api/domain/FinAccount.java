package com.iwilley.b1ec2.api.domain;


import com.iwilley.b1ec2.api.internal.mapping.ApiField;

public class FinAccount extends B1EC2Object {
	

	private static final long serialVersionUID = 7316595180605690059L;

	//对账单ID
    @ApiField("FinJournalId")
    public int finJournalId;

    //科目编码
    @ApiField("AccountCode")
    public String accountCode;
    //科目类型
    //Income = 10,
    //Expense = 20,
    //Advertisement= 30,
    //Borrow = 40,
    //Other = 50
    @ApiField("Type")
    public int type;

    //科目名称
    @ApiField("AccountName")
    public String accountName;

    //备注
    @ApiField("Memo")
    public String memo;

	public int getFinJournalId() {
		return finJournalId;
	}

	public void setFinJournalId(int finJournalId) {
		this.finJournalId = finJournalId;
	}

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
    
    
}
