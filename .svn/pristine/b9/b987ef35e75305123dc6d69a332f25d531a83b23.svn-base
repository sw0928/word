package tst.project.dao.interfaces;

import java.util.List;

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
import tst.project.page.PageBean;

public interface ActivityDao {
	
	/**
	 * 
	 * @param goodsBean
	 * @return
	 */
	public List<GoodsBean> getActivityClass1(GoodsBean goodsBean);
	
	/**
	 * 
	 * @param goodsBean
	 * @return
	 */
	public List<GoodsBean> getActivityClass2(GoodsBean goodsBean);
	
	/**
	 * 
	 * @param goodsBean
	 * @return
	 */
	public List<GoodsBean> getActivityClass3(GoodsBean goodsBean);
	
	/**
	 * 获得其他的一些设置
	 * @param othersBean
	 * @return
	 */
	public OthersBean getActivityOthers(OthersBean othersBean);
	
	/**
	 * 获得活动商品列表
	 * @param activityBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> getActivityGoods(GoodsBean goodsBean,PageBean pageBean);
	
	/**
	 * 满赠活动
	 * @param activityBean
	 * @return
	 */
	public GiveBean getActivityGive(GiveBean giveBean);
	
	/**
	 * 满减活动
	 * @param activityBean
	 * @return
	 */
	public ReduceBean getActivityReduce(ReduceBean reduceBean);
	
	/**
	 * 满送礼物
	 * @param activityBean
	 * @return
	 */
	public GiftBean getActivityGift(GiftBean giftBean);
	
	/**
	 * 满送礼物
	 * @param activityBean
	 * @return
	 */
	public HalfBean getActivityHalf(HalfBean halfBean);
	
	/**
	 * 满送礼物
	 * @param activityBean
	 * @return
	 */
	public ExemptBean getActivityExempt(ExemptBean exemptBean);
	
	/**
	 * 获得商品的满送活动列表
	 * @param giveGoodsBean
	 * @return
	 */
	public List<ActivityBean> getGoodsActivity(ActivityBean activityBean);
	
	
	/**
	 * 获得我的团购信息进行中
	 * @param groupBuyBean
	 * @return
	 */
	public List<GroupBuyBean> getMyGroupBuysIng(GroupBuyBean groupBuyBean);
	
	/**
	 * 获得我的团购信息完成
	 * @param groupBuyBean
	 * @return
	 */
	public List<GroupBuyBean> getMyGroupBuysEnd(GroupBuyBean groupBuyBean);
	
	/**
	 * 获得我的团购信息失败的
	 * @param groupBuyBean
	 * @return
	 */
	public List<GroupBuyBean> getMyGroupBuysFailed(GroupBuyBean groupBuyBean);
	
	/**
	 * 团购的参与信息
	 * @param groupBuyBean
	 * @return
	 */
	public List<GroupBuyBean> getGroupBugList(GroupBuyBean groupBuyBean);
	
	/**
	 * 更新团购的购买状态
	 * @param groupBuyBean
	 * @return
	 */
	public int updateGroupBuyState(GroupBuyBean groupBuyBean);
	
	/**
	 * 单个团购的具体详情
	 * @param groupBuyGoodsBean
	 * @return
	 */
	public GroupBuyMemberBean getOneGroupBuyDetail(GroupBuyMemberBean groupBuyMemberBean);
	
	
	/**
	 * 获得商品的创建团购信息
	 * @param groupBuyGoodsBean
	 * @return
	 */
	public List<GroupBuyGoodsBean> getGoodsGroupBuys(GroupBuyGoodsBean groupBuyGoodsBean);
	
	
	/**
	 * 申请加入团购
	 * @return
	 */
	public int memberJoinGroupBuy(GroupBuyMemberBean groupBuyMemberBean);
	
	/**
	 * 下单成功后  改变团购的现有人数
	 * @param groupBuyMemberBean
	 * @return
	 */
	public int updateGroupBuyNum(GroupBuyMemberBean groupBuyMemberBean);
	
	/**
	 * 根据用户获得团购信息
	 * @param groupBuyMemberBean
	 * @return
	 */
	public GroupBuyGoodsBean getGoodsGroupBuyByMember(GroupBuyMemberBean groupBuyMemberBean);
	
	/**
	 * 用户创建的团购（精确到团购id）
	 */
	public GroupBuyMemberBean getMemberGroupBuy(GroupBuyMemberBean groupBuyMemberBean);
	
	/**
	 * 团购人数满了 把所有此团购的状态的改变
	 * @param groupBuyBean
	 * @return
	 */
	public int updateGroupBuyStateByMember(GroupBuyBean groupBuyBean);
	
	/**
	 * 用户创建团购
	 * @param groupBuyMemberBean
	 * @return
	 */
	public int memberInsertGroupBuy(GroupBuyMemberBean groupBuyMemberBean);
	/**
	 * 更新团购二维码
	 * @param groupBuyMemberBean
	 * @return
	 */
	public int updateGroupQrCode(GroupBuyMemberBean groupBuyMemberBean);
	
	/**
	 * 用户加入团购 保存信息
	 * @param groupBuyBean
	 * @return
	 */
	public int insertGroupBuy(GroupBuyBean groupBuyBean);
	
	/**
	 * 最近的一次活动
	 * @param promotionBean
	 * @return
	 */
	public PromotionBean getNewPromotionActivity(PromotionBean promotionBean);
	
	/**
	 * 促销活动列表商品
	 * @param promotionBean
	 * @return
	 */
	public List<PromotionBean> getPromotionActivitys(PromotionBean promotionBean);
	
	/**
	 * 促销商品的分类
	 * @param promotionBean
	 * @return
	 */
	public List<GoodsBean> getPromotionGoodsClass(PromotionGoodsBean promotionBean);
	
	/**
	 * 获得促销商品列表
	 * @param promotionGoodsBean
	 * @param pageBean
	 * @return
	 */
	public List<PromotionGoodsBean> getPromotionGoodss(PromotionGoodsBean promotionGoodsBean,PageBean pageBean);
	
	/**
	 * 获得单个促销商品详情
	 * @param promotionGoodsBean
	 * @param pageBean
	 * @return
	 */
	public PromotionGoodsBean getOnePromotionGoods(PromotionGoodsBean promotionGoodsBean);
}
