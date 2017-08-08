package tst.project.bean.activity;

import tst.project.bean.goods.GoodsBean;
import tst.project.bean.member.MemberBean;

public class GroupBuyGoodsBean {
	private int goods_group_buy_id;
	private String goods_id;
	private String group_buy_price;
	private String group_buy_need_time;
	private String group_buy_need_people;
	private String group_buy_name;
	private String is_delete;
	private String group_buy_now_people;
	private String end_time;
	private String member_id;
	private String member_group_buy_id;
	private String sort;
	private MemberBean memberBean;
	private GoodsBean goodsBean;

	public String getSort() {
		return sort;
	}
	
	public GroupBuyGoodsBean setSort(String sort) {
		this.sort = sort;
		return this;
	}
	
	public String getMember_group_buy_id() {
		return member_group_buy_id;
	}
	public GroupBuyGoodsBean setMember_group_buy_id(String member_group_buy_id) {
		this.member_group_buy_id = member_group_buy_id;
		return this;
	}
	public GoodsBean getGoodsBean() {
		return goodsBean;
	}
	public GroupBuyGoodsBean setGoodsBean(GoodsBean goodsBean) {
		this.goodsBean = goodsBean;
		return this;
	}
	public MemberBean getMemberBean() {
		return memberBean;
	}
	public GroupBuyGoodsBean setMemberBean(MemberBean memberBean) {
		this.memberBean = memberBean;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public GroupBuyGoodsBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getEnd_time() {
		return end_time;
	}
	public GroupBuyGoodsBean setEnd_time(String end_time) {
		this.end_time = end_time;
		return this;
	}
	public String getGroup_buy_now_people() {
		return group_buy_now_people;
	}
	public GroupBuyGoodsBean setGroup_buy_now_people(String group_buy_now_people) {
		this.group_buy_now_people = group_buy_now_people;
		return this;
	}
	public int getGoods_group_buy_id() {
		return goods_group_buy_id;
	}
	public GroupBuyGoodsBean setGoods_group_buy_id(int goods_group_buy_id) {
		this.goods_group_buy_id = goods_group_buy_id;
		return this;
	}
	public String getGoods_id() {
		return goods_id;
	}
	public GroupBuyGoodsBean setGoods_id(String goods_id) {
		this.goods_id = goods_id;
		return this;
	}
	public String getGroup_buy_price() {
		return group_buy_price;
	}
	public GroupBuyGoodsBean setGroup_buy_price(String group_buy_price) {
		this.group_buy_price = group_buy_price;
		return this;
	}
	public String getGroup_buy_need_time() {
		return group_buy_need_time;
	}
	public GroupBuyGoodsBean setGroup_buy_need_time(String group_buy_need_time) {
		this.group_buy_need_time = group_buy_need_time;
		return this;
	}
	public String getGroup_buy_need_people() {
		return group_buy_need_people;
	}
	public GroupBuyGoodsBean setGroup_buy_need_people(String group_buy_need_people) {
		this.group_buy_need_people = group_buy_need_people;
		return this;
	}
	public String getGroup_buy_name() {
		return group_buy_name;
	}
	public GroupBuyGoodsBean setGroup_buy_name(String group_buy_name) {
		this.group_buy_name = group_buy_name;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public GroupBuyGoodsBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	
	
	
}
