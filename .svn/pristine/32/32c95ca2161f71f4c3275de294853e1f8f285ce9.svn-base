package tst.project.dao.controller;

import java.util.List;
import java.util.Map;

import tst.project.bean.activity.ActivityBean;
import tst.project.bean.activity.GroupBuyGoodsBean;
import tst.project.bean.goods.BrandBean;
import tst.project.bean.goods.BrandPackageBean;
import tst.project.bean.goods.BrandPackageGoodsBean;
import tst.project.bean.goods.BrandPackageImgBean;
import tst.project.bean.goods.BusinessGoodsBean;
import tst.project.bean.goods.GoodsBean;
import tst.project.bean.goods.GoodsImgBean;
import tst.project.bean.goods.GoodsLabelBean;
import tst.project.bean.goods.GoodsParameterBean;
import tst.project.bean.goods.GoodsServiceBean;
import tst.project.bean.goods.SSPClassBean;
import tst.project.bean.goods.StandardBean;
import tst.project.bean.goods.StoreHouseBean;
import tst.project.page.PageBean;

public interface GoodsDao {
	/**
	 * 删除首页设置(服装)
	 * @param activityBean
	 * @return
	 */
	public int deleteHomeActivity(tst.project.bean.home.ActivityBean activityBean);
	
	/**
	 * 修改首页设置(服装)
	 * @param activityBean
	 * @return
	 */
	public int updateHomeActivityState(tst.project.bean.home.ActivityBean activityBean);
	/**
	 * 添加首页设置
	 * @param activityBean
	 * @return
	 */
	public int insertHomeActivity(tst.project.bean.home.ActivityBean activityBean);
	
	/**
	 * 修改首页设置(服装)
	 * @param activityBean
	 * @return
	 */
	public int updateHomeActivity(tst.project.bean.home.ActivityBean activityBean);
	/**
	 * 首页活动列表
	 * @param activityBean
	 * @return
	 */
	public List<ActivityBean> getHomeActivitys(tst.project.bean.home.ActivityBean activityBean);
	
	/**
	 * 导出商品信息
	 * @param goodsBean
	 * @return
	 */
	public List<Object> exportGoodsExcel(GoodsBean goodsBean);
	/**
	 * 根据商家id 修改商品的状态
	 * @return
	 */
	public int updateGoodsStateByMerchants(GoodsBean goodsBean);
	
	/**
	 * 添加仓库信息
	 * @param storeHouseBean
	 * @return
	 */
	public int insertStorehouse(StoreHouseBean storeHouseBean);
	

	/**
	 * 修改仓库信息
	 * @param storeHouseBean
	 * @return
	 */
	public int updateStorehouse(StoreHouseBean storeHouseBean);
	

	/**
	 * 删除仓库信息
	 * @param storeHouseBean
	 * @return
	 */
	public int deleteStorehouse(StoreHouseBean storeHouseBean);
	
	/**
	 * 所有仓库信息
	 * @param storeHouseBean
	 * @return
	 */
	public List<StoreHouseBean> getGoodsStorehouses(StoreHouseBean storeHouseBean,PageBean pageBean);
	
	/**
	 * 所有网点信息
	 * @param storeHouseBean
	 * @return
	 */
	public List<StoreHouseBean> getGoodsStorehouses2(StoreHouseBean storeHouseBean,PageBean pageBean);
	
	
	/**
	 * 所有仓库信息 不分页
	 * @param storeHouseBean
	 * @return
	 */
	public List<StoreHouseBean> getGoodsStorehousesNoPage(StoreHouseBean storeHouseBean);
	/**
	 * 所有网点信息 不分页
	 * @param storeHouseBean
	 * @return
	 */
	public List<StoreHouseBean> getGoodsStorehouses2NoPage(StoreHouseBean storeHouseBean);
	/**
	 * 通过数组获得参数列表
	 * 
	 * @return
	 */
	public List<GoodsParameterBean> getGoodsParameterBeansByArray(Map<String, Object> params) ;
	/**
	 * 添加某个商品的团购信息
	 * @param groupBuyGoodsBean
	 * @return
	 */
	public int insertGoodsGroupBuy(GroupBuyGoodsBean groupBuyGoodsBean);
	
	/**
	 * 修改某个商品的团购信息
	 * @param groupBuyGoodsBean
	 * @return
	 */
	public int updateGoodsGroupBuy(GroupBuyGoodsBean groupBuyGoodsBean);
	
	/**
	 * 删除某个商品的团购信息
	 * @param groupBuyGoodsBean
	 * @return
	 */
	public int deleteGoodsGroupBuy(GroupBuyGoodsBean groupBuyGoodsBean);
	
	/**
	 * 获得某个商品的团购列表
	 * @param groupBuyGoodsBean
	 * @return
	 */
	public List<GroupBuyGoodsBean> getGoodsGroupBuys(GroupBuyGoodsBean groupBuyGoodsBean);
	
	
	/**
	 * 删除商品的规格参数
	 * @param standardBean
	 * @return
	 */
	public int deleteStandard(StandardBean standardBean);
	
	/**
	 * 批量删除商品的规格参数
	 * @param standardBean
	 * @return
	 */
	public int deleteStandards(StandardBean standardBean);
	
	/**
	 * 修改商品的规格参数
	 * @param standardBean
	 * @return
	 */
	public int updateStandard(StandardBean standardBean);
	
	/**
	 * 添加商品的规格参数
	 * @param standardBean
	 * @return
	 */
	public int insertStandard(StandardBean standardBean);
	
	/**
	 * 获得商品的规格参数
	 * @param standardBean
	 * @return
	 */
	public List<StandardBean> getGoodsStandard(StandardBean standardBean);
	
	
	/**
	 * 获得所有分类的标签
	 * @return
	 */
	public List<GoodsLabelBean> getGoodsClassLabels();
	
	
	/**
	 * 获得某个分类的所有标签
	 * @param goodsLabelBean
	 * @return
	 */
	public List<GoodsLabelBean> getAllGoodsClassLabels(GoodsLabelBean goodsLabelBean);
	
	/**
	 * 添加某个分类的标签
	 * @param goodsLabelBean
	 * @return
	 */
	public int insertGoodsClassLabel(GoodsLabelBean goodsLabelBean);
	
	/**
	 * 修改某个分类的标签
	 * @param goodsLabelBean
	 * @return
	 */
	public int updateGoodsClassLabel(GoodsLabelBean goodsLabelBean);
	
	/**
	 * 删除某个分类的标签
	 * @param goodsLabelBean
	 * @return
	 */
	public int deleteGoodsClassLabel(GoodsLabelBean goodsLabelBean);
	/**
	 * 所有分类列表 不分类部分等级
	 * @param goodsBean
	 * @return
	 */
	public List<GoodsBean> getAllGoodsClassNoPage(GoodsBean goodsBean);
	/**
	 * 根据父id 获得商品分类
	 * @return
	 */
	public List<GoodsBean> getGoodsClassByParentId(GoodsBean goodsBean);
	
	/**
	 * 添加商品分类
	 * @param goodsBean
	 * @return
	 */
	public int insertGoodsClass(GoodsBean goodsBean);
	
	/**
	 * 修改商品分类
	 * @param goodsBean
	 * @return
	 */
	public int updateGoodsClass(GoodsBean goodsBean);
	
	/**
	 * 删除商品分类
	 * @param goodsBean
	 * @return
	 */
	public int deleteGoodsClass(GoodsBean goodsBean);
	
	
	
	/**
	 * 获得所有品牌
	 * @return
	 */
	public List<BrandBean> getAllBrands(BrandBean brandBean);
	
	/**
	 * 添加品牌
	 * @param goodsBean
	 * @return
	 */
	public int insertBrand(BrandBean brandBean);
	
	/**
	 * 修改品牌
	 * @param goodsBean
	 * @return
	 */
	public int updateBrand(BrandBean brandBean);
	
	/**
	 * 删除品牌
	 * @param goodsBean
	 * @return
	 */
	public int deleteBrand(BrandBean brandBean);
	
	/**
	 * 所有商品详情
	 * @param goodsBean
	 * @return
	 */
	public List<GoodsBean> getAllGoodsDetail(GoodsBean goodsBean,PageBean pageBean);
	
	public List<GoodsBean> getTemp(GoodsBean goodsBean);
	
	public List<GoodsBean> getAllGoodsDetailNoPage(GoodsBean goodsBean);
	/**
	 * 单个商品详情
	 * @param goodsBean
	 * @return
	 */
	public GoodsBean getOneGoodsDetail(GoodsBean goodsBean);
	/**
	 * 单个商品详情 通过sku
	 * 
	 * @param goodsBean
	 * @return
	 */
	public GoodsBean getOneGoodsDetailBySku(GoodsBean goodsBean);
	/**
	 * 添加商品详情
	 * @param goodsBean
	 * @return
	 */
	public int insertGoodsDetail(GoodsBean goodsBean);
	
	/**
	 * 获得商品图片列表
	 * @param goodsImgBean
	 * @return
	 */
	public List<GoodsImgBean> getGoodsImgs(GoodsImgBean goodsImgBean);
	/**
	 * 添加商品图片列表
	 * @return
	 */
	public int insertGoodsImg(GoodsImgBean goodsImgBean);
	
	/**
	 * 添加商品关联标签
	 * @param goodsLabelBean
	 * @return
	 */
	public int insertGoodsLabel(GoodsLabelBean goodsLabelBean);
	/**
	 * 删除商品关联标签
	 * @param goodsLabelBean
	 * @return
	 */
	public int deleteGoodsLabel(GoodsLabelBean goodsLabelBean);
	/**
	 * 删除商品图片列表
	 * @return
	 */
	public int deleteGoodsImg(GoodsImgBean goodsImgBean);
	/**
	 * 修改商品详情
	 * @param goodsBean
	 * @return
	 */
	public int updateGoodsDetail(GoodsBean goodsBean);
	/**
	 * 删除商品详情
	 * 
	 * @param goodsBean
	 * @return
	 */
	public int deleteAllGoods(GoodsBean goodsBean) ;
	
	public int updateAllGoodsPrice(GoodsBean goodsBean);
	/**
	 * 删除商品详情
	 * @param goodsBean
	 * @return
	 */
	public int deleteGoodsDetail(GoodsBean goodsBean);
	
	/**
	 * 获得所有商品参数
	 * @return
	 */
	public List<GoodsParameterBean> getAllParametersByParent(GoodsParameterBean goodsParameterBean);
	
	/**
	 * 添加商品参数
	 * @param goodsBean
	 * @return
	 */
	public int insertParameter(GoodsParameterBean goodsParameterBean);
	
	/**
	 * 修改商品参数
	 * @param goodsBean
	 * @return
	 */
	public int updateParameter(GoodsParameterBean goodsParameterBean);
	
	/**
	 * 删除商品参数
	 * @param goodsBean
	 * @return
	 */
	public int deleteParameter(GoodsParameterBean goodsParameterBean);
	/**
	 * 批量删除商品参数
	 * @param goodsBean
	 * @return
	 */
	public int deleteParameters(GoodsParameterBean goodsParameterBean);
	/**
	 * 获得所有服务参数
	 * @return
	 */
	public List<GoodsServiceBean> getAllServiceByParent(GoodsServiceBean goodsServiceBean);
	
	/**
	 * 添加服务参数
	 * @param goodsBean
	 * @return
	 */
	public int insertService(GoodsServiceBean goodsServiceBean);
	
	/**
	 * 修改服务参数
	 * @param goodsBean
	 * @return
	 */
	public int updateService(GoodsServiceBean goodsServiceBean);
	
	/**
	 * 删除服务参数
	 * @param goodsBean
	 * @return
	 */
	public int deleteService(GoodsServiceBean goodsServiceBean);
	
	
	
	/**
	 * 获得品牌套餐
	 * @param brandPackageBean
	 * @param pageBean
	 * @return
	 */
	public List<BrandPackageBean> getBrandPackages(BrandPackageBean brandPackageBean);
	
	public List<BrandPackageImgBean> getBrandPackageImgs(BrandPackageImgBean brandPackageImgBean);
	/**
	 * 添加品牌套餐
	 * @param brandPackageBean
	 * @return
	 */
	public int insertBrandPackage(BrandPackageBean brandPackageBean);
	/**
	 * 添加品牌套餐图片
	 * @param brandPackageBean
	 * @return
	 */
	public int insertBrandPackageImg(BrandPackageImgBean brandPackageImgBean);
	/**
	 * 修改品牌套餐
	 * @param brandPackageBean
	 * @return
	 * @throws Exception 
	 */
	public int updateBrandPackage(BrandPackageBean brandPackageBean);
	/**
	 * 删除品牌套餐图片
	 * @param brandPackageBean
	 * @return
	 * @throws Exception 
	 */
	public int deleteBeandPackageImg(BrandPackageImgBean brandPackageImgBean);
	/**
	 * 获得某个品牌的所有商品
	 * @param goodsBean
	 * @return
	 */
	public List<GoodsBean> getGoodsByBrand(GoodsBean goodsBean);
	
	/**
	 * 获得某个品牌套餐的选择商品
	 * @return
	 */
	public List<BrandPackageGoodsBean> getBrandPackageGoods(BrandPackageGoodsBean brandPackageGoodsBean);
	/**
	 * 添加某个品牌的套餐商品
	 * @return
	 */
	public int insertBrandPackageGoods(BrandPackageGoodsBean brandPackageGoodsBean);
	/**
	 * 删除某个品牌的套餐商品
	 * @param goodsBean
	 * @return
	 */
	public int deleteBrandPackageGoods(BrandPackageGoodsBean brandPackageGoodsBean);
	
	/**
	 * 获得商家商品
	 * @param businessGoodsBean
	 * @param pageBean
	 * @return
	 */
	public List<BusinessGoodsBean> getBusinessGoods(BusinessGoodsBean  businessGoodsBean,
			PageBean pageBean);
	
	public List<String> getBusinessGoodsQRCodePath(BusinessGoodsBean  businessGoodsBean);
	/**
	 * 获得单个商家商品
	 * @param businessGoodsBean
	 * @return
	 */
	public BusinessGoodsBean getBusinessGood(BusinessGoodsBean  businessGoodsBean);
	/**
	 * 添加商家商品
	 * @param businessGoodsBean
	 * @return
	 */
	public int insertBusinessGoods(BusinessGoodsBean  businessGoodsBean);
	/**
	 * 删除商家商品
	 * @param businessGoodsBean
	 * @return
	 */
	public int deleteBusinessGoods(BusinessGoodsBean  businessGoodsBean);
	
	/*
	 * 顺手拼
	 */
	/**
	 * 首页7个标签的2级分类
	 * @param sspClassBean
	 * @return
	 */
	public List<SSPClassBean> getSSPHomeClasss(SSPClassBean sspClassBean);
	/**
	 * 添加标签2级分类
	 * @param sspClassBean
	 * @return
	 */
	public int insertSSPHomeClass(SSPClassBean sspClassBean);
	/**
	 * 修改标签2级分类
	 * @param sspClassBean
	 * @return
	 */
	public int updateSSPHomeClass(SSPClassBean sspClassBean);
	/**
	 * 删除标签2级分类
	 * @param sspClassBean
	 * @return
	 */
	public int deleteSSPHomeClass(SSPClassBean sspClassBean);
}
