package tst.project.bean.activity;

import tst.project.bean.member.MemberBean;

public class GroupBuyBean {
	private int group_buy_id;
	private String member_id;
	private String member_group_buy_id;
	private String group_buy_state;
	private String create_time;
	private String order_id;
	private String group_buy_num;
	
	private MemberBean memberBean;
	private GroupBuyMemberBean groupBuyMemberBean;
	
	
	
	public String getOrder_id() {
		return order_id;
	}
	public GroupBuyBean setOrder_id(String order_id) {
		this.order_id = order_id;
		return this;
	}
	public String getGroup_buy_num() {
		return group_buy_num;
	}
	public GroupBuyBean setGroup_buy_num(String group_buy_num) {
		this.group_buy_num = group_buy_num;
		return this;
	}
	public GroupBuyMemberBean getGroupBuyMemberBean() {
		return groupBuyMemberBean;
	}
	public GroupBuyBean setGroupBuyMemberBean(GroupBuyMemberBean groupBuyMemberBean) {
		this.groupBuyMemberBean = groupBuyMemberBean;
		return this;
	}
	public MemberBean getMemberBean() {
		return memberBean;
	}
	public GroupBuyBean setMemberBean(MemberBean memberBean) {
		this.memberBean = memberBean;
		return this;
	}
	public int getGroup_buy_id() {
		return group_buy_id;
	}
	public GroupBuyBean setGroup_buy_id(int group_buy_id) {
		this.group_buy_id = group_buy_id;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public GroupBuyBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getMember_group_buy_id() {
		return member_group_buy_id;
	}
	public GroupBuyBean setMember_group_buy_id(String member_group_buy_id) {
		this.member_group_buy_id = member_group_buy_id;
		return this;
	}
	public String getGroup_buy_state() {
		return group_buy_state;
	}
	public GroupBuyBean setGroup_buy_state(String group_buy_state) {
		this.group_buy_state = group_buy_state;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public GroupBuyBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	
	
}
