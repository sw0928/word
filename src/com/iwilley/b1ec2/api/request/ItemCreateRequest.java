package com.iwilley.b1ec2.api.request;

import java.util.List;
import java.util.Map;

import com.iwilley.b1ec2.api.B1EC2Request;
import com.iwilley.b1ec2.api.domain.SkuCreateLine;
import com.iwilley.b1ec2.api.internal.util.B1EC2HashMap;
import com.iwilley.b1ec2.api.response.ItemCreateResponse;

// ��Ʒ����
public class ItemCreateRequest implements B1EC2Request<ItemCreateResponse> {

	// ����
	public String itemCode;

	// ��Ʒ����
	public String itemName;

	// / ��Ŀ����
	public Integer catCode;

	// ��Ӧ��
	public Integer supplierId;

	// ��Ӧ�̻���
	public String supplierCode;

	// ��ͼUrl
	public String pictureUrl;

	// ������
	public String barCode;

	// �ɹ��۸�
	public Double purchasePrice;

	// ���ۼ۸�
	public Double salesPrice;

	// ����ۼ�
	public Double lowestPrice;

	// ���Ƽ۸�
	public Double marketPrice;

	// ��λ
	public String unit;

	// �ɹ���λ
	public String purchaseUnit;

	// ���(������)
	public Double size;

	// ������ǧ�ˣ�
	public Double weight;

	// �Ƿ�������Ʒ Ĭ��false
	public Boolean isVirtual;

	// �Զ�������1
	public String property1;

	// �Զ�������2
	public String property2;

	// �Զ�������3
	public String property3;

	// �Զ�������4
	public String property4;

	// �Զ�������5
	public String property5;

	// �Զ�������6
	public String property6;

	// �Զ�������7
	public String property7;

	// �Զ�������8
	public String property8;

	// �Զ�������9
	public String property9;

	// �Զ�������10
	public String property10;

	// �Զ�������11
	public String property11;

	// �Զ�������12
	public String property12;

	private List<SkuCreateLine> skus;

	public String getApiMethodName() {
		return "B1EC2.Item.Create";
	}

	public Map<String, String> GetParameters() {
		B1EC2HashMap parameters = new B1EC2HashMap();
		parameters.put("ItemCode", itemCode);
		parameters.put("ItemName", itemName);
		parameters.put("CatCode", catCode);
		parameters.put("SupplierId", supplierId);
		parameters.put("SupplierCode", supplierCode);
		parameters.put("PictureUrl", pictureUrl);
		parameters.put("BarCode", barCode);
		parameters.put("PurchasePrice", purchasePrice);
		parameters.put("SalesPrice", salesPrice);
		parameters.put("LowestPrice", lowestPrice);
		parameters.put("MarketPrice", marketPrice);
		parameters.put("Unit", unit);
		parameters.put("PurchaseUnit", purchaseUnit);
		parameters.put("Size", size);
		parameters.put("Weight", weight);
		parameters.put("IsVirtual", isVirtual);
		parameters.put("Property1", property1);
		parameters.put("Property2", property2);
		parameters.put("Property3", property3);
		parameters.put("Property4", property4);
		parameters.put("Property5", property5);
		parameters.put("Property6", property6);
		parameters.put("Property7", property7);
		parameters.put("Property8", property8);
		parameters.put("Property9", property9);
		parameters.put("Property10", property10);
		parameters.put("Property11", property11);
		parameters.put("Property12", property12);
		if (skus != null && skus.size() > 0) {
			StringBuffer lineInfo = new StringBuffer();
			for (SkuCreateLine sku : skus) {
				lineInfo.append(sku.getSkuCode());
				lineInfo.append(":");
				lineInfo.append(sku.getBarCode());
				lineInfo.append(":");
				lineInfo.append(sku.getProperty1());
				lineInfo.append(":");
				lineInfo.append(sku.getProperty2());
				lineInfo.append(":");
				lineInfo.append(sku.getSalesPrice());
				lineInfo.append(":");
				lineInfo.append(sku.getUnit());
				lineInfo.append(";");
			}
			parameters.put("SkuInfo", lineInfo.toString());
		}
		return parameters;
	}

	public Class<ItemCreateResponse> getResponseClass() {
		return ItemCreateResponse.class;
	}

	public String getItemCode() {
		return itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public Integer getCatCode() {
		return catCode;
	}

	public Integer getSupplierId() {
		return supplierId;
	}

	public String getSupplierCode() {
		return supplierCode;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public String getBarCode() {
		return barCode;
	}

	public Double getPurchasePrice() {
		return purchasePrice;
	}

	public Double getSalesPrice() {
		return salesPrice;
	}

	public Double getLowestPrice() {
		return lowestPrice;
	}

	public Double getMarketPrice() {
		return marketPrice;
	}

	public String getUnit() {
		return unit;
	}

	public String getPurchaseUnit() {
		return purchaseUnit;
	}

	public Double getSize() {
		return size;
	}

	public Double getWeight() {
		return weight;
	}

	public Boolean getIsVirtual() {
		return isVirtual;
	}

	public String getProperty1() {
		return property1;
	}

	public String getProperty2() {
		return property2;
	}

	public String getProperty3() {
		return property3;
	}

	public String getProperty4() {
		return property4;
	}

	public String getProperty5() {
		return property5;
	}

	public String getProperty6() {
		return property6;
	}

	public String getProperty7() {
		return property7;
	}

	public String getProperty8() {
		return property8;
	}

	public String getProperty9() {
		return property9;
	}

	public String getProperty10() {
		return property10;
	}

	public String getProperty11() {
		return property11;
	}

	public String getProperty12() {
		return property12;
	}

	public List<SkuCreateLine> getSkus() {
		return skus;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setCatCode(Integer catCode) {
		this.catCode = catCode;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public void setSalesPrice(Double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public void setLowestPrice(Double lowestPrice) {
		this.lowestPrice = lowestPrice;
	}

	public void setMarketPrice(Double marketPrice) {
		this.marketPrice = marketPrice;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public void setPurchaseUnit(String purchaseUnit) {
		this.purchaseUnit = purchaseUnit;
	}

	public void setSize(Double size) {
		this.size = size;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public void setIsVirtual(Boolean isVirtual) {
		this.isVirtual = isVirtual;
	}

	public void setProperty1(String property1) {
		this.property1 = property1;
	}

	public void setProperty2(String property2) {
		this.property2 = property2;
	}

	public void setProperty3(String property3) {
		this.property3 = property3;
	}

	public void setProperty4(String property4) {
		this.property4 = property4;
	}

	public void setProperty5(String property5) {
		this.property5 = property5;
	}

	public void setProperty6(String property6) {
		this.property6 = property6;
	}

	public void setProperty7(String property7) {
		this.property7 = property7;
	}

	public void setProperty8(String property8) {
		this.property8 = property8;
	}

	public void setProperty9(String property9) {
		this.property9 = property9;
	}

	public void setProperty10(String property10) {
		this.property10 = property10;
	}

	public void setProperty11(String property11) {
		this.property11 = property11;
	}

	public void setProperty12(String property12) {
		this.property12 = property12;
	}

	public void setSkus(List<SkuCreateLine> skus) {
		this.skus = skus;
	}

}
