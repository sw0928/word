package tst.project.dao.controller;

import java.util.List;

import tst.project.bean.activity.ExemptBean;
import tst.project.bean.activity.GiftBean;
import tst.project.bean.activity.GiveBean;
import tst.project.bean.activity.HalfBean;
import tst.project.bean.activity.PromotionBean;
import tst.project.bean.activity.PromotionGoodsBean;
import tst.project.bean.activity.ReduceBean;
import tst.project.bean.goods.GoodsBean;
import tst.project.bean.home.ActivityBean;
import tst.project.bean.home.HomeGoodsBean;
import tst.project.bean.home.LabelBean;
import tst.project.bean.home.OthersBean;
import tst.project.page.PageBean;

public interface ActivityDaoC {
	/**
	 * 更新其他配置
	 * @param othersBean
	 * @return
	 */
	public int updateHomeOthers(OthersBean othersBean);
	
	/**
	 * 获得其他配置
	 * @return
	 * @throws Exception 
	 */
	public OthersBean getActivityOthers(OthersBean othersBean);
	
	/**
	 * 删除活动详情
	 * @return
	 * @throws Exception 
	 */
	public int deleteActivityDetail(tst.project.bean.activity.ActivityBean activityBean);
	
	/**
	 * 删除活动详情
	 * @return
	 * @throws Exception 
	 */
	public int deleteActivityGoodss(tst.project.bean.activity.ActivityBean activityBean);
	
	
	/**
	 * 添加活动详情
	 * @return
	 */
	public int insertActivityDetail(tst.project.bean.activity.ActivityBean activityBean);
	/**
	 * 添加满赠活动详情
	 * @return
	 */
	public int insertActivityGive(GiveBean giveBean);
	
	/**
	 * 添加满减活动详情
	 * @return
	 */
	public int insertActivityReduce(ReduceBean reduceBean);
	
	/**
	 * 添加送礼物活动详情
	 * @return
	 */
	public int insertActivityGift(GiftBean giftBean);
	
	/**
	 * 添加半价活动详情
	 * @return
	 */
	public int insertActivityHalf(HalfBean halfBean);
	
	/**
	 * 添加满免活动
	 * @param exemptBean
	 * @return
	 */
	public int insertActivityExempt(ExemptBean exemptBean);
	/**
	 * 修改活动详情
	 * @return
	 */
	public int updateActivityDetail(tst.project.bean.activity.ActivityBean activityBean);
	/**
	 * 修改满赠活动详情
	 * @return
	 */
	public int updateActivityGive(GiveBean giveBean);
	
	/**
	 * 修改满减活动详情
	 * @return
	 */
	public int updateActivityReduce(ReduceBean reduceBean);
	
	/**
	 * 修改送礼物活动详情
	 * @return
	 */
	public int updateActivityGift(GiftBean giftBean);
	
	/**
	 * 修改满免活动
	 * @param exemptBean
	 * @return
	 */
	public int updateActivityExempt(ExemptBean exemptBean);
	/**
	 * 修改半价活动详情
	 * @param halfBean
	 * @return
	 */
	public int updateActivityHalf(HalfBean halfBean);
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
	 * 半价礼物
	 * @param activityBean
	 * @return
	 */
	public HalfBean getActivityHalf(HalfBean halfBean);
	
	/**
	 * 满免活动
	 * @param exemptBean
	 * @return
	 */
	public ExemptBean getActivityExempt(ExemptBean exemptBean);
	
	/**
	 * 获得活动商品列表
	 * @param activityBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> getActivityGoods(tst.project.bean.activity.ActivityBean activityBean,PageBean pageBean);
	
	public int deleteAllActivityGoods(tst.project.bean.activity.ActivityBean activityBean);
	/**
	 * 某活动下的某个商品
	 * @return
	 */
	public tst.project.bean.activity.ActivityBean getActivityGoodsByActivity(tst.project.bean.activity.ActivityBean activityBean );
	
	/**
	 *  某商品的活动列表
	 * @return
	 */
	public  List<tst.project.bean.activity.ActivityBean>  getActivityGoodsByGoods(tst.project.bean.activity.ActivityBean activityBean );
	
	/**
	 * 添加活动商品
	 * @param activityBean
	 * @return
	 */
	public int insertActivityGoods(tst.project.bean.activity.ActivityBean activityBean);
	
	public int insertAllActivityGoods(tst.project.bean.activity.ActivityBean activityBean);
	/**
	 * 删除活动商品
	 * @param activityBean
	 * @return
	 */
	public int deleteActivityGoods(tst.project.bean.activity.ActivityBean activityBean);
	
	
	/**
	 * 活动详情
	 * @param activityBean
	 * @return
	 */
	public tst.project.bean.activity.ActivityBean getActivityDetail(tst.project.bean.activity.ActivityBean activityBean);
	
	/**
	 * 获得所有的活动
	 * @param activityBean
	 * @return
	 */
	public List<tst.project.bean.activity.ActivityBean> getActivitys(tst.project.bean.activity.ActivityBean activityBean,PageBean pageBean);
	/**
	 * 获得所有的活动
	 * @param activityBean
	 * @return
	 */
	public List<tst.project.bean.activity.ActivityBean> getActivitysNoPage(tst.project.bean.activity.ActivityBean activityBean);
	
	/**
	 * 删除首页商品
	 * @param homeGoodsBean
	 * @return
	 */
	public int deleteHomeGoods(HomeGoodsBean homeGoodsBean);
	/**
	 * 添加首页商品
	 * @return
	 */
	public int insertHomeGoods(HomeGoodsBean homeGoodsBean);
	
	/**
	 * 修改首页商品
	 * @return
	 */
	public int updateHomeGoods(HomeGoodsBean homeGoodsBean);
	
	/**
	 * 获得首页商品
	 * @return
	 */
	public List<HomeGoodsBean> getHomeGoods(HomeGoodsBean homeGoodsBean);
	
	
	/**
	 * 删除首页活动
	 * @param activityBean
	 * @return
	 */
	public int deleteHomeActivity(ActivityBean activityBean);
	
	/**
	 * 添加首页活动
	 * @param activityBean
	 * @return
	 */
	public int insertHomeActivity(ActivityBean activityBean);
	
	/**
	 * 修改首页活动
	 * @param activityBean
	 * @return
	 */
	public int updateHomeActivity(ActivityBean activityBean);
	
	/**
	 * 首页活动管理
	 * @param activityBean
	 * @return
	 */
	public List<ActivityBean> getHomeActivitys(ActivityBean activityBean);
	/**
	 * 修改首页标签
	 * @return
	 */
	public int updateHomeLabel(LabelBean labelBean);
	
	/**
	 * 首页标签管理
	 * @param labelBean
	 * @return
	 */
	public List<LabelBean> getHomeLabels(LabelBean labelBean);
	
	
	/**
	 * 根据商品id 获得促销详情
	 * @param promotionGoodsBean
	 * @return
	 */
	public PromotionGoodsBean getPromotionGoodssByGoodsId(PromotionGoodsBean promotionGoodsBean);
	/**
	 * 添加限时促销的活动的商品
	 * @param promotionGoodsBean
	 * @return
	 */
	public int insertPromotionGoods(PromotionGoodsBean promotionGoodsBean);
	
	public int insertAllPromotionGoods(PromotionGoodsBean promotionGoodsBean);
	/**
	 * 修改限时促销的活动的商品
	 * @param promotionGoodsBean
	 * @return
	 */
	public int updatePromotionGoods(PromotionGoodsBean promotionGoodsBean);
	
	/**
	 * 删除限时促销的活动的商品
	 * @param promotionGoodsBean
	 * @return
	 */
	public int deletePromotionGoods(PromotionGoodsBean promotionGoodsBean);
	
	/**
	 * 获得所有限时促销的活动的商品列表
	 * @return
	 */
	public List<PromotionGoodsBean> getPromotionGoodss(PromotionGoodsBean promotionGoodsBean,PageBean pageBean);
	
	/**
	 * 获得促销活动列表
	 * @param promotionBeans
	 * @return
	 */
	public List<PromotionBean> getPromotions(PromotionBean promotionBean,PageBean pageBean);
	
	/**
	 * 添加限时促销活动
	 * @param promotionBean
	 * @return
	 */
	public int insertPromotion(PromotionBean promotionBean);
	
	/**
	 * 修改限时促销活动
	 * @param promotionBean
	 * @return
	 */
	public int updatePromotion(PromotionBean promotionBean);
	
	/**
	 * 删除限时促销活动
	 * @param promotionBean
	 * @return
	 */
	public int deletePromotion(PromotionBean promotionBean);
	
	
}
