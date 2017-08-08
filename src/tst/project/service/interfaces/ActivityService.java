package tst.project.service.interfaces;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.bean.HostBean;
import tst.project.bean.activity.ActivityBean;
import tst.project.bean.activity.ExemptBean;
import tst.project.bean.activity.GiftBean;
import tst.project.bean.activity.GiveBean;
import tst.project.bean.activity.GroupBuyBean;
import tst.project.bean.activity.GroupBuyGoodsBean;
import tst.project.bean.activity.GroupBuyMemberBean;
import tst.project.bean.activity.HalfBean;
import tst.project.bean.activity.PromotionBean;
import tst.project.bean.activity.PromotionGoodsBean;
import tst.project.bean.activity.ReduceBean;
import tst.project.bean.goods.GoodsBean;
import tst.project.bean.home.OthersBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.order.OrderMerchantsBean;
import tst.project.dao.interfaces.ActivityDao;
import tst.project.page.PageBean;
import tst.project.utils.QRCodeUtils;
import tst.project.utils.TimeUtils;

@Service
@Transactional(rollbackFor = Exception.class)
public class ActivityService {
	@Resource
	ActivityDao activityDao;

	@Resource
	GoodsServiceI goodsServiceI;

	@Resource
	OrderService orderService;

	@Resource
	MemberService memberService;
	
	@Resource
	OthersService othersService;
	
	public List<GoodsBean> getActivityClass(GoodsBean goodsBean,String level){
		if("1".equals(level)){
			return activityDao.getActivityClass1(goodsBean);
		}else if("2".equals(level)){
			return activityDao.getActivityClass2(goodsBean);
		}else{
			return activityDao.getActivityClass3(goodsBean);
		}
	}
	
	/**
	 * 获得其他的一些设置
	 * @param othersBean
	 * @return
	 */
	public OthersBean getActivityOthers(OthersBean othersBean){
		return activityDao.getActivityOthers(othersBean);
	}
	
	/**
	 * 获得活动商品列表
	 * @param activityBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> getActivityGoods(GoodsBean goodsBean,PageBean pageBean){
		return activityDao.getActivityGoods(goodsBean, pageBean);
	}
	
	
	/**
	 * 获得商品的满送活动列表
	 * @param giveGoodsBean
	 * @return
	 */
	public List<ActivityBean> getGoodsActivity(ActivityBean activityBean){
		List<ActivityBean> activityBeans=activityDao.getGoodsActivity(activityBean);
		if(activityBeans!= null){
			for (int i = 0; i < activityBeans.size(); i++) {
				ActivityBean activityBean2=activityBeans.get(i);
				if("give".equals(activityBean2.getActivity_type())){
					GiveBean giveBean=activityDao
							.getActivityGive(new GiveBean().setActivity_id(activityBean2.getActivity_id()));
					activityBean2.setGiveBean(giveBean);
				}else if("reduce".equals(activityBean2.getActivity_type())){
					ReduceBean reduceBean=activityDao.getActivityReduce(new ReduceBean().setActivity_id(activityBean2.getActivity_id()));
					activityBean2.setReduceBean(reduceBean);
				}else if("gift".equals(activityBean2.getActivity_type())){
					GiftBean giftBean=activityDao.getActivityGift(new GiftBean().setActivity_id(activityBean2.getActivity_id()));
					activityBean2.setGiftBean(giftBean);
				}else if("half".equals(activityBean2.getActivity_type())){
					HalfBean halfBean=activityDao.getActivityHalf(new HalfBean().setActivity_id(activityBean2.getActivity_id()));
					activityBean2.setHalfBean(halfBean);
				}else if("exempt".equals(activityBean2.getActivity_type())){
					ExemptBean exemptBean=activityDao.getActivityExempt(new ExemptBean().setActivity_id(activityBean2.getActivity_id()));
					activityBean2.setExemptBean(exemptBean);
				}
			}
		}
		return activityBeans;
	}
	
	
	/**
	 * 获得我的团购信息
	 * 
	 * @param groupBuyBean
	 * @return
	 */
	public List<GroupBuyBean> getMyGroupBuys(GroupBuyBean groupBuyBean, String type) {
		List<GroupBuyBean> groupBuyBeans = null;
		if (type == null || type.equals("ing")) {
			groupBuyBeans = activityDao.getMyGroupBuysIng(groupBuyBean);
		}else if(type.equals("end")){
			groupBuyBeans = activityDao.getMyGroupBuysEnd(groupBuyBean);
		}else if(type.equals("failed")){
			groupBuyBeans = activityDao.getMyGroupBuysFailed(groupBuyBean);
		}
		if(groupBuyBeans!=null){
			for (int i = 0; i < groupBuyBeans.size(); i++) {
				GroupBuyMemberBean groupBuyMemberBean = getOneGroupBuyDetail(new GroupBuyMemberBean()
						.setMember_group_buy_id(Integer.valueOf(groupBuyBeans.get(i).getMember_group_buy_id())));
				groupBuyBeans.get(i).setGroupBuyMemberBean(groupBuyMemberBean);
			}		
		}
		return groupBuyBeans;
	}

	/**
	 * 团购的参与信息
	 * 
	 * @param groupBuyBean
	 * @return
	 */
	public List<GroupBuyBean> getGroupBugList(GroupBuyBean groupBuyBean) {
		List<GroupBuyBean> groupBuyBeans = activityDao.getGroupBugList(groupBuyBean);
		for (int i = 0; i < groupBuyBeans.size(); i++) {
			MemberBean memberBean = memberService
					.getMemberByID(new MemberBean().setMember_id(Integer.valueOf(groupBuyBeans.get(i).getMember_id())));
			groupBuyBeans.get(i).setMemberBean(memberBean);
		}
		return groupBuyBeans;
	}

	/**
	 * 更新团购的购买状态
	 * 
	 * @param groupBuyBean
	 * @return
	 */
	public int updateGroupBuyState(GroupBuyBean groupBuyBean) {
		return activityDao.updateGroupBuyState(groupBuyBean);
	}

	/**
	 * 单个团购的具体详情
	 * 
	 * @param groupBuyGoodsBean
	 * @return
	 */
	public GroupBuyMemberBean getOneGroupBuyDetail(GroupBuyMemberBean groupBuyMemberBean) {
		GroupBuyMemberBean groupBuyMemberBean2 = activityDao.getOneGroupBuyDetail(groupBuyMemberBean);
		if (groupBuyMemberBean2 != null) {
			GoodsBean goodsBean = goodsServiceI
					.getOneGoodsDetail(new GoodsBean().setGoods_id(Integer.valueOf(groupBuyMemberBean2.getGoods_id())));
			groupBuyMemberBean2.setGoodsBean(goodsBean);

			List<GroupBuyBean> groupBuyBeans = getGroupBugList(
					new GroupBuyBean().setMember_group_buy_id(groupBuyMemberBean2.getMember_group_buy_id() + ""));
			groupBuyMemberBean2.setGroupBuyBeans(groupBuyBeans);
		}
		return groupBuyMemberBean2;
	}

	/**
	 * 获得商品的创建团购信息
	 * 
	 * @param groupBuyGoodsBean
	 * @return
	 */
	public List<GroupBuyGoodsBean> getGoodsGroupBuys(GroupBuyGoodsBean groupBuyGoodsBean) {
		List<GroupBuyGoodsBean> groupBuyGoodsBeans = activityDao.getGoodsGroupBuys(groupBuyGoodsBean);
		if (groupBuyGoodsBeans != null) {
			for (int i = 0; i < groupBuyGoodsBeans.size(); i++) {
				MemberBean memberBean = memberService.getMemberByID(
						new MemberBean().setMember_id(Integer.valueOf(groupBuyGoodsBeans.get(i).getMember_id())));
				groupBuyGoodsBeans.get(i).setMemberBean(memberBean);
				groupBuyGoodsBeans.get(i).setMemberBean(memberBean);

				GoodsBean goodsBean = goodsServiceI.getOneGoodsDetail(
						new GoodsBean().setGoods_id(Integer.valueOf(groupBuyGoodsBeans.get(i).getGoods_id())));
				groupBuyGoodsBeans.get(i).setGoodsBean(goodsBean);
			}
		}
		return groupBuyGoodsBeans;
	}

	/**
	 * 申请加入团购
	 * 
	 * @return
	 * @throws Exception
	 */
	public String memberJoinGroupBuy(GroupBuyMemberBean groupBuyMemberBean, OrderMerchantsBean orderMerchantsBean)
			throws Exception {
		GroupBuyGoodsBean groupBuyGoodsBean = activityDao.getGoodsGroupBuyByMember(groupBuyMemberBean);
		if (Integer.valueOf(groupBuyGoodsBean.getGroup_buy_need_people()) <= Integer
				.valueOf(groupBuyGoodsBean.getGroup_buy_now_people())) {
			return "-100";
		}


		String order_ids = "";
		Map<String,String> map  = orderService.insertOrder(
				orderMerchantsBean.setMember_group_buy_id(groupBuyMemberBean.getMember_group_buy_id() + ""),null);
		order_ids=map.get("order_ids");
		
		int h = insertGroupBuy(new GroupBuyBean().setMember_id(groupBuyMemberBean.getMember_id())
				.setMember_group_buy_id(groupBuyMemberBean.getMember_group_buy_id() + "")
				.setGroup_buy_state("wait_pay")
				.setOrder_id(order_ids)
				.setGroup_buy_num(orderMerchantsBean.getOrderBeans().
						get(0).getOrderGoodsBeans().get(0).getGoods_num()+""));
		if (h <= 0) {
			throw new Exception("团购信息保存失败");
		}
		return order_ids;
	}

	/**
	 * 下单成功后 改变团购的现有人数
	 * 
	 * @param groupBuyMemberBean
	 * @return
	 */
	public int updateGroupBuyNum(GroupBuyMemberBean groupBuyMemberBean) {
		return activityDao.updateGroupBuyNum(groupBuyMemberBean);
	}

	/**
	 * 根据用户获得团购信息
	 * 
	 * @param groupBuyMemberBean
	 * @return
	 */
	public GroupBuyGoodsBean getGoodsGroupBuyByMember(GroupBuyMemberBean groupBuyMemberBean) {
		return activityDao.getGoodsGroupBuyByMember(groupBuyMemberBean);
	}

	/**
	 * 获得用户创建的团购（精确到团购id）
	 */
	public GroupBuyMemberBean getMemberGroupBuy(GroupBuyMemberBean groupBuyMemberBean) {
		return activityDao.getMemberGroupBuy(groupBuyMemberBean);
	}

	/**
	 * 团购人数满了 把所有此团购的状态的改变
	 * @param groupBuyBean
	 * @return
	 */
	public int updateGroupBuyStateByMember(GroupBuyBean groupBuyBean){
		return activityDao.updateGroupBuyStateByMember(groupBuyBean);
	}
	/**
	 * 用户创建团购
	 * 
	 * @param groupBuyMemberBean
	 * @return
	 * @throws Exception
	 */
	public String memberInsertGroupBuy(GroupBuyMemberBean groupBuyMemberBean,
			OrderMerchantsBean orderMerchantsBean,HttpServletRequest request)
			throws Exception {
		int num = activityDao.memberInsertGroupBuy(groupBuyMemberBean);
		String order_ids = "";
		if (num > 0) {
			Map<String,String> map = orderService.insertOrder(
					orderMerchantsBean.setMember_group_buy_id(groupBuyMemberBean.getMember_group_buy_id() + ""),null);
			order_ids=map.get("order_ids");
			
			int h = insertGroupBuy(new GroupBuyBean().setMember_id(groupBuyMemberBean.getMember_id())
					.setMember_group_buy_id(groupBuyMemberBean.getMember_group_buy_id() + "")
					.setGroup_buy_state("wait_pay")
					.setOrder_id(order_ids)
					.setGroup_buy_num(orderMerchantsBean.getOrderBeans().
							get(0).getOrderGoodsBeans().get(0).getGoods_num()+""));
			if (h <= 0) {
				throw new Exception("团购信息保存失败");
			}
			
			String qrcode_img=TimeUtils.getCurrentTime("yyyyMMddHHmmss")+"1.png";

			HostBean hostBean=othersService.getHost(new HostBean().setHost_type("1"));
			
			Boolean a=QRCodeUtils.CreateQrcode(request,"/images/qrcode/"+qrcode_img,
					hostBean.getHost_url()+"shp/index.html?mbuyid="+groupBuyMemberBean.getMember_group_buy_id()+"#tgxq");
			if(!a){
				return "-2";
			}
			
			
			GoodsBean goodsBean=goodsServiceI.getOneGoodsDetail(new GoodsBean()
					.setGoods_id(Integer.valueOf(groupBuyMemberBean.getGoods_id())));

			List<String> result=new ArrayList<String>();
			String goods_name=goodsBean.getGoods_name();
			int goods_name_length=goods_name.length();
			for (int i = 0; i < goods_name_length/16; i++) {
				result.add(goods_name.substring(16*i,16*i+16));
			}
			if(goods_name_length%16!=0){
				result.add(goods_name.substring(16*(goods_name_length/16),16*(goods_name_length/16)+goods_name_length%16));
			}
			
			boolean d=QRCodeUtils.composeQrcodeSSP(request,
					result,"¥"+goodsBean.getGoods_now_price(),"/images/icon/white_backgroup.png",
					goodsBean.getGoods_img(), "/images/icon/fingerprint.png", 
					"/images/qrcode/"+qrcode_img,"/images/qrcode/"+qrcode_img);
			if(!d){
				throw new Exception("合成失败");
			}
			
			int m=updateGroupQrCode(groupBuyMemberBean.setQrcode_img("/images/qrcode/"+qrcode_img));
			if(m<=0){
				return "-2";
			}
		} else {
			return "-1";
		}
		return order_ids+"#"+groupBuyMemberBean.getMember_group_buy_id();
	}

	/**
	 * 更新团购二维码
	 * @param groupBuyMemberBean
	 * @return
	 */
	public int updateGroupQrCode(GroupBuyMemberBean groupBuyMemberBean){
		return activityDao.updateGroupQrCode(groupBuyMemberBean);
	}
	/**
	 * 用户加入团购 保存信息
	 * 
	 * @param groupBuyBean
	 * @return
	 */
	public int insertGroupBuy(GroupBuyBean groupBuyBean) {
		return activityDao.insertGroupBuy(groupBuyBean);
	}

	/**
	 * 最近的一次活动
	 * @param promotionBean
	 * @return
	 */
	public PromotionBean getNewPromotionActivity(PromotionBean promotionBean){
		return activityDao.getNewPromotionActivity(promotionBean);
	}
	
	/**
	 * 促销活动列表商品
	 * 
	 * @param promotionBean
	 * @return
	 */
	public List<PromotionBean> getPromotionActivitys(PromotionBean promotionBean) {
		String start_time=TimeUtils.getCurrentTime("yyyy-MM-dd");
		return activityDao.getPromotionActivitys(promotionBean
				.setStart_time(start_time).setEnd_time(start_time+" 23:59:00"));
	}
	
	/**
	 * 促销商品的分类
	 * @param promotionBean
	 * @return
	 */
	public List<GoodsBean> getPromotionGoodsClass(PromotionGoodsBean promotionBean){
		return activityDao.getPromotionGoodsClass(promotionBean);
	}

	/**
	 * 获得促销商品列表
	 * 
	 * @param promotionGoodsBean
	 * @param pageBean
	 * @return
	 */
	public List<PromotionGoodsBean> getPromotionGoodss(PromotionGoodsBean promotionGoodsBean, PageBean pageBean) {
		List<PromotionGoodsBean> promotionGoodsBeans = activityDao.getPromotionGoodss(promotionGoodsBean, pageBean);
		for (int i = 0; i < promotionGoodsBeans.size(); i++) {
			GoodsBean goodsBean = goodsServiceI.getOneGoodsDetail(
					new GoodsBean().setGoods_id(Integer.valueOf(promotionGoodsBeans.get(i).getGoods_id())));
			promotionGoodsBeans.get(i).setGoodsBean(goodsBean);
		}
		return promotionGoodsBeans;
	}

	/**
	 * 获得单个促销商品详情
	 * 
	 * @param promotionGoodsBean
	 * @param pageBean
	 * @return
	 */
	public PromotionGoodsBean getOnePromotionGoods(PromotionGoodsBean promotionGoodsBean) {
		PromotionGoodsBean promotionGoodsBean1 = activityDao.getOnePromotionGoods(promotionGoodsBean);
		return promotionGoodsBean1;
	}
}
