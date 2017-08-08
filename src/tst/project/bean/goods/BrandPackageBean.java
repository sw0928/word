package tst.project.bean.goods;

import java.util.List;

public class BrandPackageBean {
	private int package_id;
	private String package_name;
	private String brand_id;
	private String package_count;
	private String package_origin_price;
	private String package_now_price;
	private String is_delete;
	private String create_time;
	private String package_state;
	private String sort;	
	private String package_assessment_count;
	private String package_sales;
	private String package_address;
	private String package_url;
	private String package_url_content;
	private List<BrandPackageImgBean> brandPackageImgBeans;
	private List<BrandPackageGoodsBean> brandPackageGoodsBeans;

	

	public String getPackage_url() {
		return package_url;
	}

	public BrandPackageBean setPackage_url(String package_url) {
		this.package_url = package_url;
		return this;
	}

	public String getPackage_url_content() {
		return package_url_content;
	}

	public BrandPackageBean setPackage_url_content(String package_url_content) {
		this.package_url_content = package_url_content;
		return this;
	}

	public String getPackage_address() {
		return package_address;
	}

	public BrandPackageBean setPackage_address(String package_address) {
		this.package_address = package_address;
		return this;
	}

	public String getPackage_assessment_count() {
		return package_assessment_count;
	}

	public BrandPackageBean setPackage_assessment_count(String package_assessment_count) {
		this.package_assessment_count = package_assessment_count;
		return this;
	}

	public String getPackage_sales() {
		return package_sales;
	}

	public BrandPackageBean setPackage_sales(String package_sales) {
		this.package_sales = package_sales;
		return this;
	}

	public List<BrandPackageGoodsBean> getBrandPackageGoodsBeans() {
		return brandPackageGoodsBeans;
	}

	public BrandPackageBean setBrandPackageGoodsBeans(List<BrandPackageGoodsBean> brandPackageGoodsBeans) {
		this.brandPackageGoodsBeans = brandPackageGoodsBeans;
		return this;
	}

	public String getSort() {
		return sort;
	}

	public BrandPackageBean setSort(String sort) {
		this.sort = sort;
		return this;
	}
	
	public List<BrandPackageImgBean> getBrandPackageImgBeans() {
		return brandPackageImgBeans;
	}
	
	public BrandPackageBean setBrandPackageImgBeans(List<BrandPackageImgBean> brandPackageImgBeans) {
		this.brandPackageImgBeans = brandPackageImgBeans;
		return this;
	}
	
	
	public String getPackage_state() {
		return package_state;
	}
	public BrandPackageBean setPackage_state(String package_state) {
		this.package_state = package_state;
		return this;
	}
	public int getPackage_id() {
		return package_id;
	}
	public BrandPackageBean setPackage_id(int package_id) {
		this.package_id = package_id;
		return this;
	}
	public String getPackage_name() {
		return package_name;
	}
	public BrandPackageBean setPackage_name(String package_name) {
		this.package_name = package_name;
		return this;
	}
	public String getBrand_id() {
		return brand_id;
	}
	public BrandPackageBean setBrand_id(String brand_id) {
		this.brand_id = brand_id;
		return this;
	}
	public String getPackage_count() {
		return package_count;
	}
	public BrandPackageBean setPackage_count(String package_count) {
		this.package_count = package_count;
		return this;
	}
	public String getPackage_origin_price() {
		return package_origin_price;
	}
	public BrandPackageBean setPackage_origin_price(String package_origin_price) {
		this.package_origin_price = package_origin_price;
		return this;
	}
	public String getPackage_now_price() {
		return package_now_price;
	}
	public BrandPackageBean setPackage_now_price(String package_now_price) {
		this.package_now_price = package_now_price;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public BrandPackageBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public BrandPackageBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	
	
	
}
