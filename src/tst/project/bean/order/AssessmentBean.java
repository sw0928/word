package tst.project.bean.order;

import java.util.List;

import tst.project.bean.goods.GoodsBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.merchants.MerchantsBean;

public class AssessmentBean {
	private int assessment_id;
	private String member_id;
	private String order_id;
	private String assessment_desc;
	private String assessment_type;
	private String assessment_type_show;
	private String assessment_star1;
	private String assessment_star2;
	private String assessment_star3;
	private String create_time;
	private String relation_id;
	private String goods_id;
	private String goods_name;
	private String merchants_id;
	private String merchants_name;
	private String is_delete;
	private String nick_name;
	private String name;
	private String buy_time;
	
	private List<AssessmentImgBean> assessmentImgBeans;
	private List<AssessmentBean> assessmentBeans;
	private String assessment_imgs;
	private MemberBean memberBean;
	private GoodsBean goodsBean;
	private MerchantsBean merchantsBean;


	public List<AssessmentBean> getAssessmentBeans() {
		return assessmentBeans;
	}
	public AssessmentBean setAssessmentBeans(List<AssessmentBean> assessmentBeans) {
		this.assessmentBeans = assessmentBeans;
		return this;
	}
	public String getBuy_time() {
		return buy_time;
	}
	public AssessmentBean setBuy_time(String buy_time) {
		this.buy_time = buy_time;
		return this;
	}
	public MerchantsBean getMerchantsBean() {
		return merchantsBean;
	}
	public AssessmentBean setMerchantsBean(MerchantsBean merchantsBean) {
		this.merchantsBean = merchantsBean;
		return this;
	}
	public GoodsBean getGoodsBean() {
		return goodsBean;
	}
	public AssessmentBean setGoodsBean(GoodsBean goodsBean) {
		this.goodsBean = goodsBean;
		return this;
	}
	public String getGoods_id() {
		return goods_id;
	}
	public AssessmentBean setGoods_id(String goods_id) {
		this.goods_id = goods_id;
		return this;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public AssessmentBean setGoods_name(String goods_name) {
		this.goods_name = goods_name;
		return this;
	}
	public String getMerchants_id() {
		return merchants_id;
	}
	public AssessmentBean setMerchants_id(String merchants_id) {
		this.merchants_id = merchants_id;
		return this;
	}
	public String getMerchants_name() {
		return merchants_name;
	}
	public AssessmentBean setMerchants_name(String merchants_name) {
		this.merchants_name = merchants_name;
		return this;
	}
	public String getAssessment_type_show() {
		return assessment_type_show;
	}
	public AssessmentBean setAssessment_type_show(String assessment_type_show) {
		this.assessment_type_show = assessment_type_show;
		return this;
	}
	public String getNick_name() {
		return nick_name;
	}
	public AssessmentBean setNick_name(String nick_name) {
		this.nick_name = nick_name;
		return this;
	}
	
	public String getName() {
		return name;
	}
	public AssessmentBean setName(String name) {
		this.name = name;
		return this;
	}
	public MemberBean getMemberBean() {
		return memberBean;
	}
	public AssessmentBean setMemberBean(MemberBean memberBean) {
		this.memberBean = memberBean;
		return this;
	}
	public List<AssessmentImgBean> getAssessmentImgBeans() {
		return assessmentImgBeans;
	}
	public AssessmentBean setAssessmentImgBeans(List<AssessmentImgBean> assessmentImgBeans) {
		this.assessmentImgBeans = assessmentImgBeans;
		return this;
	}
	public String getAssessment_imgs() {
		return assessment_imgs;
	}
	public AssessmentBean setAssessment_imgs(String assessment_imgs) {
		this.assessment_imgs = assessment_imgs;
		return this;
	}
	public int getAssessment_id() {
		return assessment_id;
	}
	public AssessmentBean setAssessment_id(int assessment_id) {
		this.assessment_id = assessment_id;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public AssessmentBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getOrder_id() {
		return order_id;
	}
	public AssessmentBean setOrder_id(String order_id) {
		this.order_id = order_id;
		return this;
	}
	public String getAssessment_desc() {
		return assessment_desc;
	}
	public AssessmentBean setAssessment_desc(String assessment_desc) {
		this.assessment_desc = assessment_desc;
		return this;
	}
	public String getAssessment_type() {
		return assessment_type;
	}
	public AssessmentBean setAssessment_type(String assessment_type) {
		this.assessment_type = assessment_type;
		this.assessment_type_show="goods".equals(assessment_type)?"商品评价":
									("merchants".equals(assessment_type)?"商家评价":"商品评价");
		return this;
	}
	public String getAssessment_star1() {
		return assessment_star1==null?"5":assessment_star1;
	}
	public AssessmentBean setAssessment_star1(String assessment_star1) {
		this.assessment_star1 = assessment_star1;
		return this;
	}
	public String getAssessment_star2() {
		return assessment_star2==null?"5":assessment_star2;
	}
	public AssessmentBean setAssessment_star2(String assessment_star2) {
		this.assessment_star2 = assessment_star2;
		return this;
	}
	public String getAssessment_star3() {
		return assessment_star3==null?"5":assessment_star3;
	}
	public AssessmentBean setAssessment_star3(String assessment_star3) {
		this.assessment_star3 = assessment_star3;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public AssessmentBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getRelation_id() {
		return relation_id;
	}
	public AssessmentBean setRelation_id(String relation_id) {
		this.relation_id = relation_id;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public AssessmentBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}	
}
