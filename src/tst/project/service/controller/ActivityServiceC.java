package tst.project.service.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
import tst.project.dao.controller.ActivityDaoC;
import tst.project.page.PageBean;

@Service
@Transactional(rollbackFor = Exception.class)
public class ActivityServiceC {
	@Resource
	ActivityDaoC activityDaoc;

	@Resource
	GoodsService goodsService;
	
	/**
	 * 更新其他配置
	 * @param othersBean
	 * @return
	 */
	public int updateHomeOthers(OthersBean othersBean){
		return activityDaoc.updateHomeOthers(othersBean);
	}
	
	/**
	 * 获得其他配置
	 * @return
	 * @throws Exception 
	 */
	public OthersBean getActivityOthers(OthersBean othersBean){
		return activityDaoc.getActivityOthers(othersBean);
	}
	
	
	/**
	 * 删除活动详情
	 * @return
	 * @throws Exception 
	 */
	public int deleteActivityDetail(tst.project.bean.activity.ActivityBean activityBean) throws Exception{
		int num=activityDaoc.deleteActivityDetail(activityBean);
		if(num<=0){
			throw new Exception("活动详情删除失败");
		}
		
		activityDaoc.deleteActivityGoodss(activityBean);
		
		return num;
	}
	
	/**
	 * 添加活动详情
	 * @return
	 * @throws Exception 
	 */
	public int insertActivityDetail(tst.project.bean.activity.ActivityBean activityBean
			,GiveBean giveBean,ReduceBean reduceBean,GiftBean giftBean,HalfBean halfBean,ExemptBean exemptBean) throws Exception{
		int num=activityDaoc.insertActivityDetail(activityBean);
		if(num>0){
			if(activityBean.getActivity_type().equals("give")){
				num=activityDaoc.insertActivityGive(giveBean.setActivity_id(activityBean.getActivity_id()));
				if(num<=0){
					throw new Exception("赠送活动添加失败");
				}	
			}else if(activityBean.getActivity_type().equals("reduce")){
				num=activityDaoc.insertActivityReduce(reduceBean.setActivity_id(activityBean.getActivity_id()));
				if(num<=0){
					throw new Exception("满减活动添加失败");
				}	
			}else if(activityBean.getActivity_type().equals("gift")){
				num=activityDaoc.insertActivityGift(giftBean.setActivity_id(activityBean.getActivity_id()));
				if(num<=0){
					throw new Exception("礼物活动添加失败");
				}	
			}else if(activityBean.getActivity_type().equals("half")){
				num=activityDaoc.insertActivityHalf(halfBean.setActivity_id(activityBean.getActivity_id()));
				if(num<=0){
					throw new Exception("半价活动添加失败");
				}	
			}else if(activityBean.getActivity_type().equals("exempt")){
				num=activityDaoc.insertActivityExempt(exemptBean.setActivity_id(activityBean.getActivity_id()));
				if(num<=0){
					throw new Exception("半价活动添加失败");
				}	
			}
			
		}
		return num;
	}
	
	/**
	 * 修改活动详情
	 * @return
	 * @throws Exception 
	 */
	public int updateActivityDetail(tst.project.bean.activity.ActivityBean activityBean
			,GiveBean giveBean,ReduceBean reduceBean,GiftBean giftBean,HalfBean halfBean,ExemptBean exemptBean) throws Exception{
		int num=activityDaoc.updateActivityDetail(activityBean);
		if(num>0){
			if(activityBean.getActivity_type().equals("give")){
				num=activityDaoc.updateActivityGive(giveBean);
				if(num<=0){
					throw new Exception("满送活动修改失败");
				}	
			}else if(activityBean.getActivity_type().equals("reduce")){
				num=activityDaoc.updateActivityReduce(reduceBean);
				if(num<=0){
					throw new Exception("满减活动修改失败");
				}	
			}else if(activityBean.getActivity_type().equals("gift")){
				num=activityDaoc.updateActivityGift(giftBean);
				if(num<=0){
					throw new Exception("礼物活动修改失败");
				}	
			}else if(activityBean.getActivity_type().equals("half")){
				num=activityDaoc.updateActivityHalf(halfBean);
				if(num<=0){
					throw new Exception("半价活动修改失败");
				}	
			}else if(activityBean.getActivity_type().equals("exempt")){
				num=activityDaoc.updateActivityExempt(exemptBean);
				if(num<=0){
					throw new Exception("满免活动修改失败");
				}	
			}
		}
		return num;
	}
	
	/**
	 * 获得活动商品列表
	 * @param activityBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> getActivityGoods(tst.project.bean.activity.ActivityBean activityBean,PageBean pageBean){
		return activityDaoc.getActivityGoods(activityBean, pageBean);
	}
	
	
	public int deleteAllActivityGoods(tst.project.bean.activity.ActivityBean activityBean){
		return activityDaoc.deleteAllActivityGoods(activityBean);
	}
	/**
	 * 某活动下的某个商品
	 * 
	 * @return
	 */
	public tst.project.bean.activity.ActivityBean getActivityGoodsByActivity(
			tst.project.bean.activity.ActivityBean activityBean) {
		return activityDaoc.getActivityGoodsByActivity(activityBean);
	}
	
	/**
	 * 某商品的活动列表
	 * 
	 * @return
	 */
	public List<tst.project.bean.activity.ActivityBean> getActivityGoodsByGoods(
			tst.project.bean.activity.ActivityBean activityBean) {
		return activityDaoc.getActivityGoodsByGoods(activityBean);
	}

	/**
	 * 添加活动商品
	 * 
	 * @param activityBean
	 * @return
	 */
	public int insertActivityGoods(tst.project.bean.activity.ActivityBean activityBean) {
		return activityDaoc.insertActivityGoods(activityBean);
	}

	
	public int insertAllActivityGoods(tst.project.bean.activity.ActivityBean activityBean){
		return activityDaoc.insertAllActivityGoods(activityBean);
	}
	/**
	 * 删除活动商品
	 * @param activityBean
	 * @return
	 */
	public int deleteActivityGoods(tst.project.bean.activity.ActivityBean activityBean){
		return activityDaoc.deleteActivityGoods(activityBean);
	}
	/**
	 * 活动详情
	 * 
	 * @param activityBean
	 * @return
	 */
	public tst.project.bean.activity.ActivityBean getActivityDetail(
			tst.project.bean.activity.ActivityBean activityBean) {
		tst.project.bean.activity.ActivityBean activityBean2 = activityDaoc.getActivityDetail(activityBean);
		if (activityBean2.getActivity_type().equals("give")) {
			GiveBean giveBean = activityDaoc
					.getActivityGive(new GiveBean().setActivity_id(activityBean.getActivity_id()));
			activityBean2.setGiveBean(giveBean);
		}else if (activityBean2.getActivity_type().equals("reduce")) {
			ReduceBean reduceBean=activityDaoc.getActivityReduce(new ReduceBean().setActivity_id(activityBean.getActivity_id()));
			activityBean2.setReduceBean(reduceBean);
		}else if (activityBean2.getActivity_type().equals("gift")) {
			GiftBean giftBean=activityDaoc.getActivityGift(new GiftBean().setActivity_id(activityBean.getActivity_id()));
			activityBean2.setGiftBean(giftBean);
		}else if (activityBean2.getActivity_type().equals("half")) {
			HalfBean halfBean=activityDaoc.getActivityHalf(new HalfBean().setActivity_id(activityBean.getActivity_id()));
			activityBean2.setHalfBean(halfBean);
		}else if (activityBean2.getActivity_type().equals("exempt")) {
			ExemptBean exemptBean=activityDaoc.getActivityExempt(new ExemptBean().setActivity_id(activityBean.getActivity_id()));
			activityBean2.setExemptBean(exemptBean);
		}
		return activityBean2;
	}

	/**
	 * 获得所有的活动
	 * 
	 * @param activityBean
	 * @return
	 */
	public List<tst.project.bean.activity.ActivityBean> getActivitys(
			tst.project.bean.activity.ActivityBean activityBean, PageBean pageBean) {
		return activityDaoc.getActivitys(activityBean, pageBean);
	}

	/**
	 * 获得所有的活动
	 * 
	 * @param activityBean
	 * @return
	 */
	public List<tst.project.bean.activity.ActivityBean> getActivitysNoPage(
			tst.project.bean.activity.ActivityBean activityBean) {
		return activityDaoc.getActivitysNoPage(activityBean);
	}

	/**
	 * 删除首页商品
	 * 
	 * @param homeGoodsBean
	 * @return
	 */
	public int deleteHomeGoods(HomeGoodsBean homeGoodsBean) {
		return activityDaoc.deleteHomeGoods(homeGoodsBean);
	}

	/**
	 * 添加首页商品
	 * 
	 * @return
	 */
	public int insertHomeGoods(HomeGoodsBean homeGoodsBean) {
		return activityDaoc.insertHomeGoods(homeGoodsBean);
	}

	/**
	 * 修改首页商品
	 * 
	 * @return
	 */
	public int updateHomeGoods(HomeGoodsBean homeGoodsBean) {
		return activityDaoc.updateHomeGoods(homeGoodsBean);
	}

	/**
	 * 获得首页商品
	 * 
	 * @return
	 */
	public List<HomeGoodsBean> getHomeGoods(HomeGoodsBean homeGoodsBean) {
		return activityDaoc.getHomeGoods(homeGoodsBean);
	}

	/**
	 * 删除首页活动
	 * 
	 * @param activityBean
	 * @return
	 */
	public int deleteHomeActivity(ActivityBean activityBean) {
		return activityDaoc.deleteHomeActivity(activityBean);
	}

	/**
	 * 添加首页活动
	 * 
	 * @param activityBean
	 * @return
	 */
	public int insertHomeActivity(ActivityBean activityBean) {
		return activityDaoc.insertHomeActivity(activityBean);
	}

	/**
	 * 修改首页活动
	 * 
	 * @param activityBean
	 * @return
	 */
	public int updateHomeActivity(ActivityBean activityBean) {
		return activityDaoc.updateHomeActivity(activityBean);
	}

	/**
	 * 首页活动管理
	 * 
	 * @param activityBean
	 * @return
	 */
	public List<ActivityBean> getHomeActivitys(ActivityBean activityBean) {
		return activityDaoc.getHomeActivitys(activityBean);
	}

	/**
	 * 修改首页标签
	 * 
	 * @return
	 */
	public int updateHomeLabel(LabelBean labelBean) {
		return activityDaoc.updateHomeLabel(labelBean);
	}

	/**
	 * 首页标签管理
	 * 
	 * @param labelBean
	 * @return
	 */
	public List<LabelBean> getHomeLabels(LabelBean labelBean) {
		return activityDaoc.getHomeLabels(labelBean);
	}

	/**
	 * 根据商品id 获得促销详情
	 * 
	 * @param promotionGoodsBean
	 * @return
	 */
	public PromotionGoodsBean getPromotionGoodssByGoodsId(PromotionGoodsBean promotionGoodsBean) {
		return activityDaoc.getPromotionGoodssByGoodsId(promotionGoodsBean);
	}

	/**
	 * 添加限时促销的活动的商品
	 * 
	 * @param promotionGoodsBean
	 * @return
	 */
	public int insertPromotionGoods(PromotionGoodsBean promotionGoodsBean) {
		return activityDaoc.insertPromotionGoods(promotionGoodsBean);
	}
	
	public int insertAllPromotionGoods(PromotionGoodsBean promotionGoodsBean){
		return activityDaoc.insertAllPromotionGoods(promotionGoodsBean);
	}

	/**
	 * 修改限时促销的活动的商品
	 * 
	 * @param promotionGoodsBean
	 * @return
	 */
	public int updatePromotionGoods(PromotionGoodsBean promotionGoodsBean) {
		return activityDaoc.updatePromotionGoods(promotionGoodsBean);
	}

	/**
	 * 删除限时促销的活动的商品
	 * 
	 * @param promotionGoodsBean
	 * @return
	 */
	public int deletePromotionGoods(PromotionGoodsBean promotionGoodsBean) {
		return activityDaoc.deletePromotionGoods(promotionGoodsBean);
	}

	/**
	 * 获得所有限时促销的活动的商品列表
	 * 
	 * @return
	 */
	public List<PromotionGoodsBean> getPromotionGoodss(PromotionGoodsBean promotionGoodsBean, PageBean pageBean) {
		List<PromotionGoodsBean> promotionGoodsBeans = activityDaoc.getPromotionGoodss(promotionGoodsBean, pageBean);
		for (int i = 0; i < promotionGoodsBeans.size(); i++) {
			GoodsBean goodsBean = goodsService.getOneGoodsDetail(
					new GoodsBean().setGoods_id(Integer.valueOf(promotionGoodsBeans.get(i).getGoods_id())));
			promotionGoodsBeans.get(i).setGoodsBean(goodsBean);
		}
		return promotionGoodsBeans;
	}

	/**
	 * 获得促销活动列表
	 * 
	 * @param promotionBeans
	 * @return
	 */
	public List<PromotionBean> getPromotions(PromotionBean promotionBeans, PageBean pageBean) {
		return activityDaoc.getPromotions(promotionBeans, pageBean);
	}

	/**
	 * 添加限时促销活动
	 * 
	 * @param promotionBean
	 * @return
	 */
	public int insertPromotion(PromotionBean promotionBean) {
		return activityDaoc.insertPromotion(promotionBean);
	}

	/**
	 * 修改限时促销活动
	 * 
	 * @param promotionBean
	 * @return
	 */
	public int updatePromotion(PromotionBean promotionBean) {
		return activityDaoc.updatePromotion(promotionBean);
	}

	/**
	 * 删除限时促销活动
	 * 
	 * @param promotionBean
	 * @return
	 */
	public int deletePromotion(PromotionBean promotionBean) {
		return activityDaoc.deletePromotion(promotionBean);
	}
}
