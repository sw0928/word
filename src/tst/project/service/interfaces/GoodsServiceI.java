package tst.project.service.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tst.project.bean.activity.ActivityBean;
import tst.project.bean.activity.GroupBuyGoodsBean;
import tst.project.bean.address.LocationBean;
import tst.project.bean.goods.BrandBean;
import tst.project.bean.goods.BrandPackageBean;
import tst.project.bean.goods.BrandPackageGoodsBean;
import tst.project.bean.goods.BrandPackageImgBean;
import tst.project.bean.goods.GoodsBean;
import tst.project.bean.goods.GoodsImgBean;
import tst.project.bean.goods.GoodsLabelBean;
import tst.project.bean.goods.GoodsParameterBean;
import tst.project.bean.goods.GoodsServiceBean;
import tst.project.bean.goods.SSPClassBean;
import tst.project.bean.goods.StandardBean;
import tst.project.bean.goods.StoreHouseBean;
import tst.project.bean.merchants.MerchantsBean;
import tst.project.bean.others.SearchBean;
import tst.project.dao.interfaces.GoodsDaoI;
import tst.project.module.ClassMoudle;
import tst.project.page.PageBean;
import tst.project.utils.BaiduUtils;
import tst.project.utils.DistanceUtils;
import tst.project.utils.NumberUtils;

@Service
@Transactional(rollbackFor = Exception.class)
public class GoodsServiceI {
	@Resource
	GoodsDaoI goodsDaoI;

	@Resource
	MerchantsServiceI merchantsServiceI;

	@Resource
	ActivityService activityService;

	/**
	 * 获得搜热列表
	 * 
	 * @return
	 */
	public List<SearchBean> getHotSearchs(SearchBean searchBean, PageBean pageBean) {
		return goodsDaoI.getHotSearchs(searchBean, pageBean);
	}

	/**
	 * 获得一个搜热
	 * 
	 * @return
	 */
	public SearchBean getHotSearch(SearchBean searchBean) {
		return goodsDaoI.getHotSearch(searchBean);
	}

	/**
	 * 修改搜热
	 * 
	 * @return
	 */
	public int updateHotSearch(SearchBean searchBean) {
		return goodsDaoI.updateHotSearch(searchBean);
	}

	/**
	 * 添加搜热
	 * 
	 * @return
	 */
	public int inserHotSearch(SearchBean searchBean) {
		return goodsDaoI.inserHotSearch(searchBean);
	}

	/**
	 * 首页活动列表
	 * 
	 * @param activityBean
	 * @return
	 */
	public List<ActivityBean> getHomeActivitys(tst.project.bean.home.ActivityBean activityBean) {
		return goodsDaoI.getHomeActivitys(activityBean);
	}

	/**
	 * 预售商品列表
	 * 
	 * @return
	 */
	public List<GoodsBean> getPreSaleGoodss(GoodsBean goodsBean, PageBean pageBean) {
		List<GoodsBean> goodsBeans = goodsDaoI.getPreSaleGoodss(goodsBean, pageBean);
		for (int i = 0; i < goodsBeans.size(); i++) {
			List<GoodsImgBean> goodsImgBeans = goodsDaoI
					.getGoodsImgs(new GoodsImgBean().setGoods_id(goodsBeans.get(i).getGoods_id() + ""));
			goodsBeans.get(i).setGoodsImgBeans(goodsImgBeans);
		}
		return goodsBeans;
	}

	/**
	 * 热门商品
	 * 
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> getHotGoods(GoodsBean goodsBean, PageBean pageBean) {
		List<GoodsBean> goodsBeans = goodsDaoI.getHotGoods(goodsBean, pageBean);
		for (int i = 0; i < goodsBeans.size(); i++) {
			List<GoodsImgBean> goodsImgBeans = goodsDaoI
					.getGoodsImgs(new GoodsImgBean().setGoods_id(goodsBeans.get(i).getGoods_id() + ""));
			goodsBeans.get(i).setGoodsImgBeans(goodsImgBeans);
		}
		return goodsBeans;
	}

	/**
	 * 畅销商品(后台设置的)
	 * 
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> getSellingGoods(GoodsBean goodsBean, PageBean pageBean) {
		List<GoodsBean> goodsBeans = goodsDaoI.getSellingGoods(goodsBean, pageBean);
		for (int i = 0; i < goodsBeans.size(); i++) {
			List<GoodsImgBean> goodsImgBeans = goodsDaoI
					.getGoodsImgs(new GoodsImgBean().setGoods_id(goodsBeans.get(i).getGoods_id() + ""));
			goodsBeans.get(i).setGoodsImgBeans(goodsImgBeans);
		}
		return goodsBeans;
	}

	/**
	 * 畅销商品(真正的按销量排名)
	 * 
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> getSellingGoodsReal(GoodsBean goodsBean, PageBean pageBean) {
		List<GoodsBean> goodsBeans = goodsDaoI.getSellingGoodsReal(goodsBean, pageBean);
		for (int i = 0; i < goodsBeans.size(); i++) {
			List<GoodsImgBean> goodsImgBeans = goodsDaoI
					.getGoodsImgs(new GoodsImgBean().setGoods_id(goodsBeans.get(i).getGoods_id() + ""));
			goodsBeans.get(i).setGoodsImgBeans(goodsImgBeans);
		}
		return goodsBeans;
	}
	public List<Map> getOneGoodsClassParentNoV2(GoodsBean goodsBean) {
		return goodsDaoI.getGoodsClassParentV2(goodsBean);
	}
	public List<GoodsBean> getOneGoodsClassParentNo(GoodsBean goodsBean) {
		return goodsDaoI.getGoodsClassParent(goodsBean);
	}

	public List<GoodsBean> getGoodsClassLevel(GoodsBean goodsBean, int level) {
		if (level == 1 && ClassMoudle.getInstance().getGoods1Beans() != null) {
			// return ClassMoudle.getInstance().getGoods1Beans();
		}
		if (level == 2 && ClassMoudle.getInstance().getGoods2Beans() != null&&"-1".equals(goodsBean.getParent_id())) {
			return ClassMoudle.getInstance().getGoods2Beans();
		}
		if (level == 3 && ClassMoudle.getInstance().getGoods3Beans() != null&&"-1".equals(goodsBean.getParent_id())) {
			return ClassMoudle.getInstance().getGoods3Beans();
		}

		List<GoodsBean> goodsBeans = getOneGoodsClassParentNo(goodsBean.setGoods_type("1"));
		if (level < 2) {// 只取一级
			return goodsBeans;
		}
		List<GoodsBean> goods2Beans = getGoodsClassLevel(goodsBeans, level, 2);
		
		if (level == 1) {
			//ClassMoudle.getInstance().setGoods1Beans(goods2Beans);
		} else if (level == 2&&"-1".equals(goodsBean.getParent_id())) {
			ClassMoudle.getInstance().setGoods2Beans(goods2Beans);
		} else if (level == 3&&"-1".equals(goodsBean.getParent_id())) {
			ClassMoudle.getInstance().setGoods3Beans(goods2Beans);
		}
		return goods2Beans;
	}

	
	public List<Map> getGoodsClassLevelV2(GoodsBean goodsBean, int level) {
//		if (level == 1 && ClassMoudle.getInstance().getGoods1Beans() != null) {
//			// return ClassMoudle.getInstance().getGoods1Beans();
//		}
//		if (level == 2 && ClassMoudle.getInstance().getGoods2Beans() != null&&"-1".equals(goodsBean.getParent_id())) {
//			return ClassMoudle.getInstance().getGoods2Beans();
//		}
//		if (level == 3 && ClassMoudle.getInstance().getGoods3Beans() != null&&"-1".equals(goodsBean.getParent_id())) {
//			return ClassMoudle.getInstance().getGoods3Beans();
//		}

		List<Map> goodsBeans = getOneGoodsClassParentNoV2(goodsBean.setGoods_type("1"));
		if (level < 2) {// 只取一级
			return goodsBeans;
		}
		List<Map> goods2Beans = getGoodsClassLevelV2(goodsBeans, level, 2);
		
//		if (level == 1) {
//			//ClassMoudle.getInstance().setGoods1Beans(goods2Beans);
//		} else if (level == 2&&"-1".equals(goodsBean.getParent_id())) {
//			ClassMoudle.getInstance().setGoods2Beans(goods2Beans);
//		} else if (level == 3&&"-1".equals(goodsBean.getParent_id())) {
//			ClassMoudle.getInstance().setGoods3Beans(goods2Beans);
//		}
		return goods2Beans;
	}

	/**
	 * 
	 * @param goodsBeans
	 * @param level
	 *            总共需要取层级
	 * @param start
	 *            目前取到的层级
	 * @return
	 */
	public List<GoodsBean> getGoodsClassLevel(List<GoodsBean> goodsBeans, int level, int start) {
		if (goodsBeans != null) {
			for (int i = 0; i < goodsBeans.size(); i++) {
				List<GoodsBean> goodsBeans2 = getOneGoodsClassParentNo(
						new GoodsBean().setParent_id(goodsBeans.get(i).getGoods_id() + "").setGoods_type("1"));
				if (start < level && goodsBeans2 != null) {// 目前取到的层级 小于
															// 总共需要取层级时 向下取
					goodsBeans2 = getGoodsClassLevel(goodsBeans2, level, start + 1);
				}
				goodsBeans.get(i).setGoodsBeans(goodsBeans2);
			}
		}
		return goodsBeans;
	}
	
	/**
	 * 
	 * @param goodsBeans
	 * @param level
	 *            总共需要取层级
	 * @param start
	 *            目前取到的层级
	 * @return
	 */
	public List<Map> getGoodsClassLevelV2(List<Map> goodsBeans, int level, int start) {
		if (goodsBeans != null) {
			for (int i = 0; i < goodsBeans.size(); i++) {
				List<Map> goodsBeans2 = getOneGoodsClassParentNoV2(
						new GoodsBean().setParent_id(goodsBeans.get(i).get("goods_id") + "").setGoods_type("1"));
				if (start < level && goodsBeans2 != null) {// 目前取到的层级 小于
															// 总共需要取层级时 向下取
					goodsBeans2 = getGoodsClassLevelV2(goodsBeans2, level, start + 1);
				}
				goodsBeans.get(i).put("goodsBeans",goodsBeans2);
			}
		}
		return goodsBeans;
	}

	/**
	 * 通过数组获得参数列表
	 * 
	 * @return
	 */
	public List<GoodsParameterBean> getGoodsParameterBeansByArray(Map<String, Object> params) {
		return goodsDaoI.getGoodsParameterBeansByArray(params);
	}

	/**
	 * 根据父id获得所有商品分类
	 * 
	 * @param goodsBean
	 * @return
	 */
	public List<GoodsBean> getGoodsClassOrder(GoodsBean goodsBean) {
		List<GoodsBean> goodsBeans = goodsDaoI.getGoodsClassParent(goodsBean);
		for (int i = 0; i < goodsBeans.size(); i++) {
			List<BrandBean> brandBeans = getAllBrandByClass(
					new GoodsBean().setGoods_uuid(goodsBeans.get(i).getGoods_uuid()));
			goodsBeans.get(i).setBrandBeans(brandBeans);

		}
		return goodsBeans;
	}

	/**
	 * 根据父id获得所有商品分类
	 * 
	 * @param goodsBean
	 * @return
	 */
	public List<GoodsBean> getGoodsClassParent(GoodsBean goodsBean) {
		List<GoodsBean> goodsBeans = goodsDaoI.getGoodsClassParent(goodsBean);
		for (int i = 0; i < goodsBeans.size(); i++) {
			List<BrandBean> brandBeans = getAllBrandByClass(
					new GoodsBean().setGoods_uuid(goodsBeans.get(i).getGoods_uuid()));
			goodsBeans.get(i).setBrandBeans(brandBeans);

		}
		return goodsBeans;
	}

	/**
	 * 获得该分类下的活动列表
	 * 
	 * @param goodsBean
	 * @return
	 */
	public List<ActivityBean> getActivityByClass(GoodsBean goodsBean) {
		return goodsDaoI.getActivityByClass(goodsBean);
	}

	/**
	 * 获得该品牌下分类列表
	 * 
	 * @param goodsBean
	 * @return
	 */
	public List<GoodsBean> getClassByBrand(GoodsBean goodsBean, String level) {
		if ("1".equals(level)) {
			return goodsDaoI.getClassByBrand1(goodsBean);
		} else if ("2".equals(level)) {
			return goodsDaoI.getClassByBrand2(goodsBean);
		} else {
			return goodsDaoI.getClassByBrand3(goodsBean);
		}
	}

	/**
	 * 获得该分类下的品牌列表
	 * 
	 * @param goodsBean
	 * @return
	 */
	public List<BrandBean> getAllBrandByClass(GoodsBean goodsBean) {
		return goodsDaoI.getAllBrandByClass(goodsBean);
	}

	/**
	 * 获得该分类下的标签列表
	 * 
	 * @param goodsLabelBean
	 * @return
	 */
	public List<GoodsLabelBean> getAllGoodsLabelByClass(GoodsBean goodsBean) {
		return goodsDaoI.getAllGoodsLabelByClass(goodsBean);
	}

	/**
	 * 获得该分类下的仓库列表
	 * 
	 * @param goodsLabelBean
	 * @return
	 */
	public List<StoreHouseBean> getAllStoreHouseByClass(GoodsBean goodsBean) {
		return goodsDaoI.getAllStoreHouseByClass(goodsBean);
	}

	/**
	 * 根据各种条件 搜索商品列表
	 * 
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> searchGoodsDetailList(GoodsBean goodsBean,LocationBean locationBean,PageBean pageBean) {
		List<GoodsBean> goodsBeans = goodsDaoI.searchGoodsDetailList(goodsBean,pageBean);
		for (int i = 0; i < goodsBeans.size(); i++) {
			LocationBean locationBean2=BaiduUtils.getLLByAddress(goodsBeans.get(i).getGoods_address());
			String distance=DistanceUtils.Distan(locationBean,locationBean2);
			goodsBeans.get(i).setDistance(NumberUtils.KeepDecimal(distance,2)+"");
			List<GoodsImgBean> goodsImgBeans = goodsDaoI
					.getGoodsImgs(new GoodsImgBean().setGoods_id(goodsBeans.get(i).getGoods_id() + ""));
			goodsBeans.get(i).setGoodsImgBeans(goodsImgBeans);
		}
		return goodsBeans;
	}

	/**
	 * 商品的其他参数选择
	 * 
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsLabelBean> getGoodsClassLabels(GoodsLabelBean goodsLabelBean) {
		return goodsDaoI.getGoodsClassLabels(goodsLabelBean);
	}

	/**
	 * 修改商品浏览量
	 * 
	 * @param goodsBean
	 * @return
	 */
	public int updateGoodsDetailSeenum(GoodsBean goodsBean) {
		return goodsDaoI.updateGoodsDetailSeenum(goodsBean);
	}

	/**
	 * 获得商品详情
	 * 
	 * @param goodsBean
	 * @return
	 */
	public GoodsBean getOneGoodsDetail(GoodsBean goodsBean) {
		GoodsBean goodsBean1 = goodsDaoI.getOneGoodsDetail(goodsBean);
		if (goodsBean1 != null) {
			List<GoodsLabelBean> goodsLabelBeans = getGoodsClassLabels(
					new GoodsLabelBean().setGoods_id(goodsBean.getGoods_id() + ""));
			goodsBean1.setGoodsLabelBeans(goodsLabelBeans);

			List<GoodsImgBean> goodsImgBeans = goodsDaoI
					.getGoodsImgs(new GoodsImgBean().setGoods_id(goodsBean1.getGoods_id() + ""));
			goodsBean1.setGoodsImgBeans(goodsImgBeans);// 商品图片

			MerchantsBean merchantsBean = merchantsServiceI.getOneMerchantsDetail(
					new MerchantsBean().setMerchants_id(Integer.valueOf(goodsBean1.getMerchants_id()))
							.setMember_id(goodsBean.getMember_id()));
			goodsBean1.setMerchantsBean(merchantsBean);

			List<GoodsParameterBean> goodsParameterBeans = getAllParameters(new GoodsParameterBean()
					.setParameter_type("1").setParent_id("-1").setGoods_id(goodsBean1.getGoods_id() + ""));
			goodsBean1.setGoodsParameterBeans(goodsParameterBeans);// 商品选择参数

			List<GoodsServiceBean> goodsServiceBeans = getAllServices(new GoodsServiceBean().setService_type("1")
					.setParent_id("-1").setGoods_id(goodsBean1.getGoods_id() + ""));
			goodsBean1.setGoodsServiceBeans(goodsServiceBeans);// 商品售后服务

			List<StandardBean> standardBeans = getGoodsStandards(
					new StandardBean().setGoods_id(goodsBean1.getGoods_id() + ""));
			goodsBean1.setStandardBeans(standardBeans);// 商品规格

			List<ActivityBean> activityBeans = activityService
					.getGoodsActivity(new ActivityBean().setGoods_id(goodsBean1.getGoods_id()));
			goodsBean1.setActivityBeans(activityBeans);

			if (goodsBean1.getIs_group_buy().equals("1")) {
				List<GroupBuyGoodsBean> groupBuyGoodsBeans = getGroupBuyGoodss(
						new GroupBuyGoodsBean().setGoods_id(goodsBean1.getGoods_id() + ""));
				goodsBean1.setGroupBuyGoodsBeans(groupBuyGoodsBeans);
			}
		}
		return goodsBean1;
	}

	/**
	 * 商品的规格数据
	 * 
	 * @param groupBuyGoodsBean
	 * @return
	 */
	public List<StandardBean> getGoodsStandards(StandardBean standardBean) {
		return goodsDaoI.getGoodsStandards(standardBean);
	}

	/**
	 * 商品的团购详情
	 * 
	 * @param groupBuyGoodsBean
	 * @return
	 */
	public List<GroupBuyGoodsBean> getGroupBuyGoodss(GroupBuyGoodsBean groupBuyGoodsBean) {
		return goodsDaoI.getGroupBuyGoodss(groupBuyGoodsBean);
	}

	/**
	 * 商品的图片列表
	 * 
	 * @param goodsImgBean
	 * @return
	 */

	public List<GoodsImgBean> getGoodsImgs(GoodsImgBean goodsImgBean) {
		return goodsDaoI.getGoodsImgs(goodsImgBean);
	}

	/**
	 * 获得所有商品参数
	 * 
	 * @return
	 */
	public List<GoodsParameterBean> getAllParameters(GoodsParameterBean goodsParameterBean) {
		List<GoodsParameterBean> goodsParameterBeans = goodsDaoI.getAllParametersByParent(goodsParameterBean);
		if (goodsParameterBeans != null) {
			for (int i = 0; i < goodsParameterBeans.size(); i++) {
				List<GoodsParameterBean> goodsParameterBeans2 = goodsDaoI.getAllParametersByParent(goodsParameterBean
						.setParameter_type("2").setParent_id(goodsParameterBeans.get(i).getParameter_id() + ""));
				goodsParameterBeans.get(i).setGoodsParameterBeans(goodsParameterBeans2);
			}
		}
		return goodsParameterBeans;
	}

	/**
	 * 获得所有服务参数
	 * 
	 * @return
	 */
	public List<GoodsServiceBean> getAllServices(GoodsServiceBean goodsServiceBean) {
		List<GoodsServiceBean> goodsServiceBeans = goodsDaoI.getAllServiceByParent(goodsServiceBean);
		if (goodsServiceBeans != null) {
			for (int i = 0; i < goodsServiceBeans.size(); i++) {
				List<GoodsServiceBean> goodsServiceBeans2 = goodsDaoI.getAllServiceByParent(goodsServiceBean
						.setService_type("2").setParent_id(goodsServiceBeans.get(i).getService_id() + ""));
				goodsServiceBeans.get(i).setGoodsServiceBeans(goodsServiceBeans2);
			}
		}
		return goodsServiceBeans;
	}

	/**
	 * 获得品牌套餐
	 * 
	 * @param brandPackageBean
	 * @return
	 */
	public List<BrandPackageBean> getBrandPackageByBrand(BrandPackageBean brandPackageBean) {
		List<BrandPackageBean> brandPackageBeans = goodsDaoI.getBrandPackageByBrand(brandPackageBean);
		for (int i = 0; i < brandPackageBeans.size(); i++) {
			List<BrandPackageImgBean> brandPackageImgBeans = getBrandPackageImgs(
					new BrandPackageImgBean().setPackage_id(brandPackageBeans.get(i).getPackage_id() + ""));
			brandPackageBeans.get(i).setBrandPackageImgBeans(brandPackageImgBeans);
		}
		return brandPackageBeans;
	}

	/**
	 * 获得单个品牌详情
	 * 
	 * @param brandPackageBean
	 * @return
	 */
	public BrandBean getBrandDetail(BrandBean brandBean) {
		BrandBean brandBean2 = goodsDaoI.getBrandDetail(brandBean);
		if (brandBean2 != null) {
			List<BrandPackageBean> brandPackageBeans = goodsDaoI
					.getBrandPackageByBrand(new BrandPackageBean().setBrand_id(brandBean.getBrand_id() + ""));
			for (int i = 0; i < brandPackageBeans.size(); i++) {
				List<BrandPackageImgBean> brandPackageImgBeans = getBrandPackageImgs(
						new BrandPackageImgBean().setPackage_id(brandPackageBeans.get(i).getPackage_id() + ""));
				brandPackageBeans.get(i).setBrandPackageImgBeans(brandPackageImgBeans);
			}
			brandBean2.setBrandPackageBeans(brandPackageBeans);
		}
		return brandBean2;
	}

	/**
	 * 获得品牌套餐图片
	 * 
	 * @param brandPackageBean
	 * @return
	 */
	public List<BrandPackageImgBean> getBrandPackageImgs(BrandPackageImgBean brandPackageImgBean) {
		return goodsDaoI.getBrandPackageImgs(brandPackageImgBean);
	}

	/**
	 * 获得品牌套餐详情
	 * 
	 * @param brandPackageBean
	 * @return
	 */
	public BrandPackageBean getBrandPackageGoodsDetail(BrandPackageBean brandPackageBean) {
		BrandPackageBean brandPackageBean2 = goodsDaoI.getBrandPackageGoodsDetail(brandPackageBean);
		if (brandPackageBean2 != null) {
			brandPackageBean2.setBrandPackageImgBeans(getBrandPackageImgs(
					new BrandPackageImgBean().setPackage_id(brandPackageBean.getPackage_id() + "")));
			brandPackageBean2.setBrandPackageGoodsBeans(getBrandPackageGoods(
					new BrandPackageGoodsBean().setPackage_id(brandPackageBean.getPackage_id() + "")));
		}
		return brandPackageBean2;
	}

	/**
	 * 获得品牌套餐商品
	 * 
	 * @param brandPackageBean
	 * @return
	 */
	public List<BrandPackageGoodsBean> getBrandPackageGoods(BrandPackageGoodsBean brandPackageGoodsBean) {
		List<BrandPackageGoodsBean> brandPackageGoodsBeans = goodsDaoI.getBrandPackageGoods(brandPackageGoodsBean);
		for (int i = 0; i < brandPackageGoodsBeans.size(); i++) {
			GoodsBean goodsBean = getOneGoodsDetail(
					new GoodsBean().setGoods_id(Integer.valueOf(brandPackageGoodsBeans.get(i).getGoods_id())));
			brandPackageGoodsBeans.get(i).setGoodsBean(goodsBean);
		}
		return brandPackageGoodsBeans;
	}

	// 顺手拍

	/**
	 * 所有商品
	 * 
	 * @return
	 */
	public List<GoodsBean> getAllGoods(GoodsBean goodsBean, PageBean pageBean) {
		List<GoodsBean> goodsBeans = goodsDaoI.getAllGoods(goodsBean, pageBean);
		for (int i = 0; i < goodsBeans.size(); i++) {
			List<GoodsImgBean> goodsImgBeans = goodsDaoI
					.getGoodsImgs(new GoodsImgBean().setGoods_id(goodsBeans.get(i).getGoods_id() + ""));
			goodsBeans.get(i).setGoodsImgBeans(goodsImgBeans);
		}
		return goodsBeans;
	}

	/**
	 * 顺手拍七个标签 分类
	 * 
	 * @param goodsBean
	 * @return
	 */
	public List<SSPClassBean> getSSPGoodsClass(SSPClassBean sspClassBean) {
		return goodsDaoI.getSSPGoodsClass(sspClassBean);
	}

	/**
	 * 促销标签
	 * 
	 * @return
	 */
	public List<GoodsBean> getPromotionGoods(GoodsBean goodsBean, PageBean pageBean) {
		List<GoodsBean> goodsBeans = goodsDaoI.getPromotionGoods(goodsBean, pageBean);
		for (int i = 0; i < goodsBeans.size(); i++) {
			List<GoodsImgBean> goodsImgBeans = goodsDaoI
					.getGoodsImgs(new GoodsImgBean().setGoods_id(goodsBeans.get(i).getGoods_id() + ""));
			goodsBeans.get(i).setGoodsImgBeans(goodsImgBeans);
		}
		return goodsBeans;
	}

	/**
	 * 礼物标签
	 * 
	 * @return
	 */
	public List<GoodsBean> getGiftGoods(GoodsBean goodsBean, PageBean pageBean) {
		List<GoodsBean> goodsBeans = goodsDaoI.getGiftGoods(goodsBean, pageBean);
		for (int i = 0; i < goodsBeans.size(); i++) {
			List<GoodsImgBean> goodsImgBeans = goodsDaoI
					.getGoodsImgs(new GoodsImgBean().setGoods_id(goodsBeans.get(i).getGoods_id() + ""));
			goodsBeans.get(i).setGoodsImgBeans(goodsImgBeans);
		}
		return goodsBeans;
	}

	/**
	 * 生鲜标签
	 * 
	 * @return
	 */
	public List<GoodsBean> getFreshGoods(GoodsBean goodsBean, PageBean pageBean) {
		List<GoodsBean> goodsBeans = goodsDaoI.getFreshGoods(goodsBean, pageBean);
		for (int i = 0; i < goodsBeans.size(); i++) {
			List<GoodsImgBean> goodsImgBeans = goodsDaoI
					.getGoodsImgs(new GoodsImgBean().setGoods_id(goodsBeans.get(i).getGoods_id() + ""));
			goodsBeans.get(i).setGoodsImgBeans(goodsImgBeans);
		}
		return goodsBeans;
	}

	/**
	 * 母婴标签
	 * 
	 * @return
	 */
	public List<GoodsBean> getBabyGoods(GoodsBean goodsBean, PageBean pageBean) {
		List<GoodsBean> goodsBeans = goodsDaoI.getBabyGoods(goodsBean, pageBean);
		for (int i = 0; i < goodsBeans.size(); i++) {
			List<GoodsImgBean> goodsImgBeans = goodsDaoI
					.getGoodsImgs(new GoodsImgBean().setGoods_id(goodsBeans.get(i).getGoods_id() + ""));
			goodsBeans.get(i).setGoodsImgBeans(goodsImgBeans);
		}
		return goodsBeans;
	}

	/**
	 * 女士标签
	 * 
	 * @return
	 */
	public List<GoodsBean> getLadyGoods(GoodsBean goodsBean, PageBean pageBean) {
		List<GoodsBean> goodsBeans = goodsDaoI.getLadyGoods(goodsBean, pageBean);
		for (int i = 0; i < goodsBeans.size(); i++) {
			List<GoodsImgBean> goodsImgBeans = goodsDaoI
					.getGoodsImgs(new GoodsImgBean().setGoods_id(goodsBeans.get(i).getGoods_id() + ""));
			goodsBeans.get(i).setGoodsImgBeans(goodsImgBeans);
		}
		return goodsBeans;
	}

	/**
	 * 特色标签
	 * 
	 * @return
	 */
	public List<GoodsBean> getFeatureGoods(GoodsBean goodsBean, PageBean pageBean) {
		List<GoodsBean> goodsBeans = goodsDaoI.getFeatureGoods(goodsBean, pageBean);
		for (int i = 0; i < goodsBeans.size(); i++) {
			List<GoodsImgBean> goodsImgBeans = goodsDaoI
					.getGoodsImgs(new GoodsImgBean().setGoods_id(goodsBeans.get(i).getGoods_id() + ""));
			goodsBeans.get(i).setGoodsImgBeans(goodsImgBeans);
		}
		return goodsBeans;
	}

	/**
	 * 进口商品
	 * 
	 * @return
	 */
	public List<GoodsBean> getImportGoods(GoodsBean goodsBean, PageBean pageBean) {
		List<GoodsBean> goodsBeans = goodsDaoI.getImportGoods(goodsBean, pageBean);
		for (int i = 0; i < goodsBeans.size(); i++) {
			List<GoodsImgBean> goodsImgBeans = goodsDaoI
					.getGoodsImgs(new GoodsImgBean().setGoods_id(goodsBeans.get(i).getGoods_id() + ""));
			goodsBeans.get(i).setGoodsImgBeans(goodsImgBeans);
		}
		return goodsBeans;
	}

	// 家纺
	/**
	 * 首页热门商品
	 * 
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> getHomeHotGoods(GoodsBean goodsBean, PageBean pageBean) {
		List<GoodsBean> goodsBeans = goodsDaoI.getHomeHotGoods(goodsBean, pageBean);
		for (int i = 0; i < goodsBeans.size(); i++) {
			List<GoodsImgBean> goodsImgBeans = goodsDaoI
					.getGoodsImgs(new GoodsImgBean().setGoods_id(goodsBeans.get(i).getGoods_id() + ""));
			goodsBeans.get(i).setGoodsImgBeans(goodsImgBeans);
		}
		return goodsBeans;
	}

	/**
	 * 首页最新商品
	 * 
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> getNewHotGoods(GoodsBean goodsBean, PageBean pageBean) {
		List<GoodsBean> goodsBeans = goodsDaoI.getNewHotGoods(goodsBean, pageBean);
		for (int i = 0; i < goodsBeans.size(); i++) {
			List<GoodsImgBean> goodsImgBeans = goodsDaoI
					.getGoodsImgs(new GoodsImgBean().setGoods_id(goodsBeans.get(i).getGoods_id() + ""));
			goodsBeans.get(i).setGoodsImgBeans(goodsImgBeans);
		}
		return goodsBeans;
	}

	/**
	 * 首页畅销商品(后台设置的)
	 * 
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> getHomeSellingGoods(GoodsBean goodsBean, PageBean pageBean) {
		List<GoodsBean> goodsBeans = goodsDaoI.getHomeSellingGoods(goodsBean, pageBean);
		for (int i = 0; i < goodsBeans.size(); i++) {
			List<GoodsImgBean> goodsImgBeans = goodsDaoI
					.getGoodsImgs(new GoodsImgBean().setGoods_id(goodsBeans.get(i).getGoods_id() + ""));
			goodsBeans.get(i).setGoodsImgBeans(goodsImgBeans);
		}
		return goodsBeans;
	}

	/**
	 * 分类热门商品
	 * 
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> getClassHotGoods(GoodsBean goodsBean, PageBean pageBean) {
		List<GoodsBean> goodsBeans = goodsDaoI.getClassHotGoods(goodsBean, pageBean);
		for (int i = 0; i < goodsBeans.size(); i++) {
			List<GoodsImgBean> goodsImgBeans = goodsDaoI
					.getGoodsImgs(new GoodsImgBean().setGoods_id(goodsBeans.get(i).getGoods_id() + ""));
			goodsBeans.get(i).setGoodsImgBeans(goodsImgBeans);
		}
		return goodsBeans;
	}

	/**
	 * 分类畅销商品(后台设置的)
	 * 
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> getClassSellingGoods(GoodsBean goodsBean, PageBean pageBean) {
		List<GoodsBean> goodsBeans = goodsDaoI.getClassSellingGoods(goodsBean, pageBean);
		for (int i = 0; i < goodsBeans.size(); i++) {
			List<GoodsImgBean> goodsImgBeans = goodsDaoI
					.getGoodsImgs(new GoodsImgBean().setGoods_id(goodsBeans.get(i).getGoods_id() + ""));
			goodsBeans.get(i).setGoodsImgBeans(goodsImgBeans);
		}
		return goodsBeans;
	}

	/**
	 * 分类畅销商品(后台设置的)
	 * 
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> getClassPriceSortGoods(GoodsBean goodsBean, PageBean pageBean) {
		List<GoodsBean> goodsBeans = goodsDaoI.getClassPriceSortGoods(goodsBean, pageBean);
		for (int i = 0; i < goodsBeans.size(); i++) {
			List<GoodsImgBean> goodsImgBeans = goodsDaoI
					.getGoodsImgs(new GoodsImgBean().setGoods_id(goodsBeans.get(i).getGoods_id() + ""));
			goodsBeans.get(i).setGoodsImgBeans(goodsImgBeans);
		}
		return goodsBeans;
	}
	public BrandBean getBrandMerchantsAndStoreHouseList(String goods_id){
		return goodsDaoI.getBrandMerchantsAndStoreHouseList(goods_id);
	}
	
	public List<StoreHouseBean> getGoodsStorehouses2NoPage(){
		return goodsDaoI.getGoodsStorehouses2NoPage();
	};
}
