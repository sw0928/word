package tst.project.dao.interfaces;

import java.util.List;
import java.util.Map;

import tst.project.bean.activity.ActivityBean;
import tst.project.bean.activity.GroupBuyGoodsBean;
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
import tst.project.bean.others.SearchBean;
import tst.project.page.PageBean;

public interface GoodsDaoI {
	/**
	 * 获得搜热列表
	 * @return
	 */
	public List<SearchBean> getHotSearchs(SearchBean searchBean,PageBean pageBean);
	
	
	/**
	 * 获得一个搜热
	 * @return
	 */
	public SearchBean getHotSearch(SearchBean searchBean);
	
	/**
	 * 修改搜热
	 * @return
	 */
	public int updateHotSearch(SearchBean searchBean);
	
	/**
	 * 添加搜热
	 * @return
	 */
	public int inserHotSearch(SearchBean searchBean);
	
	
	/**
	 * 首页活动列表
	 * @param activityBean
	 * @return
	 */
	public List<ActivityBean> getHomeActivitys(tst.project.bean.home.ActivityBean activityBean);
	
	/**
	 * 预售商品列表
	 * @return
	 */
	public List<GoodsBean> getPreSaleGoodss(GoodsBean goodsBean, PageBean pageBean);
	
	
	/**
	 * 热门商品
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> getHotGoods(GoodsBean goodsBean,PageBean pageBean);
	
	/**
	 * 畅销商品(后台设置的)
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> getSellingGoods(GoodsBean goodsBean,PageBean pageBean);
	/**
	 * 畅销商品(真正的按销量排名)
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> getSellingGoodsReal(GoodsBean goodsBean,PageBean pageBean);
	
	public GoodsBean getGoodsClassById(GoodsBean goodsBean);
	/**
	 * 根据父id获得所有商品分类
	 * @param goodsBean
	 * @return
	 */
	public List<GoodsBean> getGoodsClassParent(GoodsBean goodsBean);
	
	/**
	 * 根据父id获得所有商品分类
	 * @param goodsBean
	 * @return
	 */
	public List<Map> getGoodsClassParentV2(GoodsBean goodsBean);
	
	/**
	 * 通过数组获得参数列表
	 * @return
	 */
	public List<GoodsParameterBean> getGoodsParameterBeansByArray(Map<String,Object> params);
	
	/**
	 * 获得该分类下的活动列表
	 * 
	 * @param goodsBean
	 * @return
	 */
	public List<ActivityBean> getActivityByClass(GoodsBean goodsBean) ;
	
	/**
	 * 获得该品牌下分类列表
	 * @param goodsBean
	 * @return
	 */
	public List<GoodsBean> getClassByBrand3(GoodsBean goodsBean);
	/**
	 * 获得该品牌下分类列表
	 * @param goodsBean
	 * @return
	 */
	public List<GoodsBean> getClassByBrand1(GoodsBean goodsBean);
	/**
	 * 获得该品牌下分类列表
	 * @param goodsBean
	 * @return
	 */
	public List<GoodsBean> getClassByBrand2(GoodsBean goodsBean);
	/**
	 * 获得该分类下的品牌列表
	 * @param goodsBean
	 * @return
	 */
	public List<BrandBean> getAllBrandByClass(GoodsBean goodsBean);
	
	/**
	 * 获得该分类下的标签列表
	 * @param goodsLabelBean
	 * @return
	 */
	public List<GoodsLabelBean> getAllGoodsLabelByClass(GoodsBean goodsBean);
	/**
	 * 获得该分类下的标签列表
	 * @param goodsLabelBean
	 * @return
	 */
	public List<StoreHouseBean> getAllStoreHouseByClass(GoodsBean goodsBean);
	
	/**
	 * 根据各种条件 搜索商品列表
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> searchGoodsDetailList(GoodsBean goodsBean,PageBean pageBean);
	
	
	/**
	 * 修改商品浏览量
	 * @param goodsBean
	 * @return
	 */
	public int updateGoodsDetailSeenum(GoodsBean goodsBean);
	
	/**
	 * 获得商品详情
	 * @param goodsBean
	 * @return
	 */
	public GoodsBean getOneGoodsDetail(GoodsBean goodsBean);
	
	/**
	 * 商品的其他参数选择
	 * 
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsLabelBean> getGoodsClassLabels(GoodsLabelBean goodsLabelBean) ;
	
	/**
	 * 商品的团购详情
	 * @param groupBuyGoodsBean
	 * @return
	 */
	public List<GroupBuyGoodsBean> getGroupBuyGoodss(GroupBuyGoodsBean groupBuyGoodsBean);
	
	/**
	 * 商品的规格数据
	 * @param groupBuyGoodsBean
	 * @return
	 */
	public List<StandardBean> getGoodsStandards(StandardBean standardBean) ;
	
	/**
	 * 商品的图片列表
	 * @param goodsImgBean
	 * @return
	 */
	public List<GoodsImgBean> getGoodsImgs(GoodsImgBean goodsImgBean);
	
	/**
	 * 获得所有商品参数
	 * @return
	 */
	public List<GoodsParameterBean> getAllParametersByParent(GoodsParameterBean goodsParameterBean);
	/**
	 * 获得所有服务参数
	 * @return
	 */
	public List<GoodsServiceBean> getAllServiceByParent(GoodsServiceBean goodsServiceBean);
	
	
	/**
	 * 获得品牌套餐
	 * @param brandPackageBean
	 * @return
	 */
	public List<BrandPackageBean> getBrandPackageByBrand(BrandPackageBean brandPackageBean);
	
	/**
	 * 获得品牌详情
	 * @param brandBean
	 * @return
	 */
	public BrandBean getBrandDetail(BrandBean brandBean);
	/**
	 * 获得品牌套餐图片
	 * @param brandPackageBean
	 * @return
	 */
	public List<BrandPackageImgBean> getBrandPackageImgs(BrandPackageImgBean brandPackageImgBean);
	/**
	 * 获得品牌套餐详情
	 * @param brandPackageBean
	 * @return
	 */
	public BrandPackageBean getBrandPackageGoodsDetail(BrandPackageBean brandPackageBean);
	/**
	 * 获得品牌套餐商品
	 * @param brandPackageBean
	 * @return
	 */
	public List<BrandPackageGoodsBean> getBrandPackageGoods(BrandPackageGoodsBean brandPackageGoodsBean);
	
	
	//顺手拍
	
	/**
	 *所有商品
	 * @return
	 */
	public List<GoodsBean> getAllGoods(GoodsBean goodsBean,PageBean pageBean);
	/**
	 * 顺手拍七个标签 分类
	 * @param goodsBean
	 * @return
	 */
	public List<SSPClassBean> getSSPGoodsClass(SSPClassBean sspClassBean);
	
	/**
	 * 促销标签
	 * 
	 * @return
	 */
	public List<GoodsBean> getPromotionGoods(GoodsBean goodsBean, PageBean pageBean);

	/**
	 * 礼物标签
	 * @return
	 */
	public List<GoodsBean> getGiftGoods(GoodsBean goodsBean,PageBean pageBean);
	
	
	/**
	 * 生鲜标签
	 * @return
	 */
	public List<GoodsBean> getFreshGoods(GoodsBean goodsBean,PageBean pageBean);
	
	
	/**
	 * 母婴标签
	 * @return
	 */
	public List<GoodsBean> getBabyGoods(GoodsBean goodsBean,PageBean pageBean);
	
	
	/**
	 * 女士标签
	 * @return
	 */
	public List<GoodsBean> getLadyGoods(GoodsBean goodsBean,PageBean pageBean);
	
	
	/**
	 * 特色标签
	 * @return
	 */
	public List<GoodsBean> getFeatureGoods(GoodsBean goodsBean,PageBean pageBean);
	
	/**
	 * 进口标签
	 * @return
	 */
	public List<GoodsBean> getImportGoods(GoodsBean goodsBean,PageBean pageBean);
	
	
	//家纺
	/**
	 * 首页热门商品
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> getHomeHotGoods(GoodsBean goodsBean,PageBean pageBean);
	/**
	 * 首页最新商品
	 * 
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> getNewHotGoods(GoodsBean goodsBean,PageBean pageBean) ;
	/**
	 * 首页畅销商品(后台设置的)
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> getHomeSellingGoods(GoodsBean goodsBean,PageBean pageBean);
	
	
	/**
	 * 分类热门商品
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> getClassHotGoods(GoodsBean goodsBean,PageBean pageBean);
	
	/**
	 * 分类畅销商品(后台设置的)
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> getClassSellingGoods(GoodsBean goodsBean,PageBean pageBean);
	
	/**
	 * 分类畅销商品(后台设置的)
	 * @param goodsBean
	 * @param pageBean
	 * @return
	 */
	public List<GoodsBean> getClassPriceSortGoods(GoodsBean goodsBean,PageBean pageBean);
	
	/**
	 * 根据产品ID获取供应该商品的供应商的信息及其仓库信息
	 * @param sspClassBean
	 * @return
	 */
	public BrandBean getBrandMerchantsAndStoreHouseList(String goods_id);
	
	/**
	 * 得到所有的网店的信息
	 * 
	 */
	public List<StoreHouseBean> getGoodsStorehouses2NoPage();
}
