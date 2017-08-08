package tst.project.bean.goods;

public class GoodsRelationClassBean {
	private int goods_class_id;
	private String goods_class_ids;
	private int class_id;
	private int goods_id;
	private String create_time;
	private int is_delete;
	private String uuid;
	private String parent_uuid;
	
	
	public String getGoods_class_ids() {
		return goods_class_ids;
	}
	public GoodsRelationClassBean setGoods_class_ids(String goods_class_ids) {
		this.goods_class_ids = goods_class_ids;
		return this;
	}
	public int getGoods_class_id() {
		return goods_class_id;
	}
	public GoodsRelationClassBean setGoods_class_id(int goods_class_id) {
		this.goods_class_id = goods_class_id;
		return this;
	}
	public int getClass_id() {
		return class_id;
	}
	public GoodsRelationClassBean setClass_id(int class_id) {
		this.class_id = class_id;
		return this;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public GoodsRelationClassBean setGoods_id(int goods_id) {
		this.goods_id = goods_id;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public GoodsRelationClassBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public int getIs_delete() {
		return is_delete;
	}
	public GoodsRelationClassBean setIs_delete(int is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getUuid() {
		return uuid;
	}
	public GoodsRelationClassBean setUuid(String uuid) {
		this.uuid = uuid;
		return this;
	}
	public String getParent_uuid() {
		return parent_uuid;
	}
	public GoodsRelationClassBean setParent_uuid(String parent_uuid) {
		this.parent_uuid = parent_uuid;
		return this;
	}

}
