package tst.project.service.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;

import tst.project.bean.HostBean;
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
import tst.project.bean.member.MemberBean;
import tst.project.bean.others.HtmlStyleBean;
import tst.project.dao.controller.GoodsDao;
import tst.project.page.PageBean;
import tst.project.utils.CreateRandom;
import tst.project.utils.HtmlUtils;
import tst.project.utils.QRCodeUtils;
import tst.project.utils.TimeUtils;

@Service
@Transactional(rollbackFor = Exception.class)
public class GoodsService {
	@Resource
	GoodsDao goodsDao;

	@Resource
	OthersServiceC othersServiceC;
	
	public void test1() throws Exception{
		List<GoodsBean> classBeans=goodsDao.getTemp(new GoodsBean());
		List<GoodsBean> goodsBeans=goodsDao.getAllGoodsDetailNoPage(new GoodsBean());
		//for (int i = 0; i < classBeans.size(); i++) {
			for (int j = 0; j < goodsBeans.size(); j++) {
				System.out.println(j/12+"=====================================");
				int num=goodsDao.updateGoodsDetail(new GoodsBean()
						.setGoods_id(goodsBeans.get(j).getGoods_id())
						.setParent_id(classBeans.get(j/12).getGoods_id()+""));
				if(num<=0){
					throw new Exception("123");
				}
			}
		//}
	}
	
	/**
	 * 删除首页设置(服装)
	 * @param activityBean
	 * @return
	 */
	public int deleteHomeActivity(tst.project.bean.home.ActivityBean activityBean){
		return goodsDao.deleteHomeActivity(activityBean);
	}
	/**
	 * 修改首页设置(服装)
	 * @param activityBean
	 * @return
	 */
	public int updateHomeActivity(tst.project.bean.home.ActivityBean activityBean){
		return goodsDao.updateHomeActivity(activityBean);
	}
	
	/**
	 * 添加首页设置
	 * @param activityBean
	 * @return
	 */
	public int insertHomeActivity(tst.project.bean.home.ActivityBean activityBean){
		return goodsDao.insertHomeActivity(activityBean);
	}
	
	/**
	 * 修改首页设置(服装)
	 * @param activityBean
	 * @return
	 */
	public int updateHomeActivityState(tst.project.bean.home.ActivityBean activityBean){
		return goodsDao.updateHomeActivityState(activityBean);
	}
	
	/**
	 * 首页活动列表
	 * @param activityBean
	 * @return
	 */
	public List<ActivityBean> getHomeActivitys(tst.project.bean.home.ActivityBean activityBean){
		return goodsDao.getHomeActivitys(activityBean);
	}
	
	/**
	 * 导出商品信息
	 * @param goodsBean
	 * @return
	 */
	public List<Object> exportGoodsExcel(GoodsBean goodsBean){
		return goodsDao.exportGoodsExcel(goodsBean);
	}
	
	/**
	 * 根据商家id 修改商品的状态
	 * @return
	 */
	public int updateGoodsStateByMerchants(GoodsBean goodsBean){
		return goodsDao.updateGoodsStateByMerchants(goodsBean);
	}
	/**
	 * 添加仓库信息
	 * 
	 * @param storeHouseBean
	 * @return
	 */
	public int insertStorehouse(StoreHouseBean storeHouseBean) {
		return goodsDao.insertStorehouse(storeHouseBean);
	}

	/**
	 * 修改仓库信息
	 * 
	 * @param storeHouseBean
	 * @return
	 */
	public int updateStorehouse(StoreHouseBean storeHouseBean) {
		return goodsDao.updateStorehouse(storeHouseBean);
	}

	/**
	 * 删除仓库信息
	 * 
	 * @param storeHouseBean
	 * @return
	 */
	public int deleteStorehouse(StoreHouseBean storeHouseBean) {
		return goodsDao.deleteStorehouse(storeHouseBean);
	}

	/**
	 * 所有仓库信息
	 * 
	 * @param storeHouseBean
	 * @return
	 */
	public List<StoreHouseBean> getGoodsStorehouses(StoreHouseBean storeHouseBean, PageBean pageBean) {
		return goodsDao.getGoodsStorehouses(storeHouseBean, pageBean);
	}
	/**
	 * 所有网点信息
	 * 
	 * @param storeHouseBean
	 * @return
	 */
	public List<StoreHouseBean> getGoodsStorehouses2(StoreHouseBean storeHouseBean, PageBean pageBean) {
		return goodsDao.getGoodsStorehouses2(storeHouseBean, pageBean);
	}
	/**
	 * 所有仓库信息 不分页
	 * 
	 * @param storeHouseBean
	 * @return
	 */
	public List<StoreHouseBean> getGoodsStorehousesNoPage(StoreHouseBean storeHouseBean) {
		return goodsDao.getGoodsStorehousesNoPage(storeHouseBean);
	}
	/**
	 * 所有网点信息 不分页
	 * 
	 * @param storeHouseBean
	 * @return
	 */
	public List<StoreHouseBean> getGoodsStorehouses2NoPage(StoreHouseBean storeHouseBean) {
		return goodsDao.getGoodsStorehouses2NoPage(storeHouseBean);
	}
	/**
	 * 通过数组获得参数列表
	 * 
	 * @return
	 */
	public List<GoodsParameterBean> getGoodsParameterBeansByArray(Map<String, Object> params) {
		return goodsDao.getGoodsParameterBeansByArray(params);
	}

	/**
	 * 添加某个商品的团购信息
	 * 
	 * @param groupBuyGoodsBean
	 * @return
	 */
	public int insertGoodsGroupBuy(GroupBuyGoodsBean groupBuyGoodsBean) {
		return goodsDao.insertGoodsGroupBuy(groupBuyGoodsBean);
	}

	/**
	 * 修改某个商品的团购信息
	 * 
	 * @param groupBuyGoodsBean
	 * @return
	 */
	public int updateGoodsGroupBuy(GroupBuyGoodsBean groupBuyGoodsBean) {
		return goodsDao.updateGoodsGroupBuy(groupBuyGoodsBean);
	}

	/**
	 * 删除某个商品的团购信息
	 * 
	 * @param groupBuyGoodsBean
	 * @return
	 */
	public int deleteGoodsGroupBuy(GroupBuyGoodsBean groupBuyGoodsBean) {
		return goodsDao.deleteGoodsGroupBuy(groupBuyGoodsBean);
	}

	/**
	 * 获得某个商品的团购列表
	 * 
	 * @param groupBuyGoodsBean
	 * @return
	 */
	public List<GroupBuyGoodsBean> getGoodsGroupBuys(GroupBuyGoodsBean groupBuyGoodsBean) {
		return goodsDao.getGoodsGroupBuys(groupBuyGoodsBean);
	}

	/**
	 * 删除商品的规格参数
	 * 
	 * @param standardBean
	 * @return
	 */
	public int deleteStandard(StandardBean standardBean) {
		return goodsDao.deleteStandard(standardBean);
	}

	/**
	 * 批量删除商品的规格参数
	 * 
	 * @param standardBean
	 * @return
	 */
	public int deleteStandards(StandardBean standardBean) {
		return goodsDao.deleteStandards(standardBean);
	}

	/**
	 * 修改商品的规格参数
	 * 
	 * @param standardBean
	 * @return
	 */
	public int updateStandard(StandardBean standardBean) {
		return goodsDao.updateStandard(standardBean);
	}

	/**
	 * 添加商品的规格参数
	 * 
	 * @param standardBean
	 * @return
	 */
	public int insertStandard(StandardBean standardBean) {
		return goodsDao.insertStandard(standardBean);
	}

	/**
	 * 获得商品的规格参数
	 * 
	 * @param standardBean
	 * @return
	 */
	public List<StandardBean> getGoodsStandard(StandardBean standardBean) {
		List<StandardBean> standardBeans = goodsDao.getGoodsStandard(standardBean);
		return standardBeans;
	}

	public List<GoodsLabelBean> getGoodsClassLabels(GoodsLabelBean goodsLabelBean) {
		List<GoodsLabelBean> goodsLabelBeans = goodsDao.getGoodsClassLabels();
		for (int i = 0; i < goodsLabelBeans.size(); i++) {
			List<GoodsLabelBean> goodsLabelBeans2 = getAllGoodsClassLabels(new GoodsLabelBean().setParent_id("-1")
					.setGoods_class_id(goodsLabelBeans.get(i).getGoods_id()).setGoods_id(goodsLabelBean.getGoods_id()));
			goodsLabelBeans.get(i).setGoodsLabelBeans(goodsLabelBeans2);
		}
		return goodsLabelBeans;
	}

	/**
	 * 获得某个分类的所有标签
	 * 
	 * @param goodsLabelBean
	 * @return
	 */
	public List<GoodsLabelBean> getAllGoodsClassLabels(GoodsLabelBean goodsLabelBean) {
		List<GoodsLabelBean> goodsLabelBeans = goodsDao.getAllGoodsClassLabels(goodsLabelBean);
		for (int i = 0; i < goodsLabelBeans.size(); i++) {
			GoodsLabelBean goodsLabelBean2 = goodsLabelBeans.get(i);
			List<GoodsLabelBean> goodsLabelBeans2 = goodsDao
					.getAllGoodsClassLabels(goodsLabelBean.setParent_id(goodsLabelBean2.getLabel_id() + ""));
			goodsLabelBean2.setGoodsLabelBeans(goodsLabelBeans2);
		}
		return goodsLabelBeans;
	}

	/**
	 * 添加某个分类的标签
	 * 
	 * @param goodsLabelBean
	 * @return
	 */
	public int insertGoodsClassLabel(GoodsLabelBean goodsLabelBean) {
		return goodsDao.insertGoodsClassLabel(goodsLabelBean);
	}

	/**
	 * 修改某个分类的标签
	 * 
	 * @param goodsLabelBean
	 * @return
	 */
	public int updateGoodsClassLabel(GoodsLabelBean goodsLabelBean) {
		return goodsDao.updateGoodsClassLabel(goodsLabelBean);
	}

	/**
	 * 删除某个分类的标签
	 * 
	 * @param goodsLabelBean
	 * @return
	 */
	public int deleteGoodsClassLabel(GoodsLabelBean goodsLabelBean) {
		return goodsDao.deleteGoodsClassLabel(goodsLabelBean);
	}

	/**
	 * 根据父id 获得商品分类
	 * 
	 * @return
	 */
	public List<GoodsBean> getGoodsClassByParentId(GoodsBean goodsBean) {
		return goodsDao.getGoodsClassByParentId(goodsBean);
	}

	/**
	 * 所有分类列表 不分类部分等级
	 * 
	 * @param goodsBean
	 * @return
	 */
	public List<GoodsBean> getAllGoodsClassNoPage(GoodsBean goodsBean) {
		return goodsDao.getAllGoodsClassNoPage(goodsBean);
	}

	/**
	 * 获得所有分类数据
	 * 
	 * @return
	 */
	public List<GoodsBean> getAllGoodsClass(GoodsBean goodsBean) {
		List<GoodsBean> goodsBeans = goodsDao.getGoodsClassByParentId(goodsBean);
		for (int i = 0; i < goodsBeans.size(); i++) {
			if (goodsBeans.get(i).getIs_end().equals("0")) {
				goodsBeans.get(i)
						.setGoodsBeans(getAllGoodsClass(goodsBean.setParent_id(goodsBeans.get(i).getGoods_id() + "")));
			}
		}
		return goodsBeans;
	}

	/**
	 * 添加商品分类
	 * 
	 * @param goodsBean
	 * @return
	 */
	public int insertGoodsClass(GoodsBean goodsBean) {
		return goodsDao.insertGoodsClass(goodsBean);
	}
	
	public int loadGoodsClassExcel(List<GoodsBean> goodsBeans, HttpServletRequest request) throws Exception{
		int num=0;
		if(goodsBeans!=null){
			for (int i = 0; i < goodsBeans.size(); i++) {
				num=insertGoodsClass(goodsBeans.get(i)
						.setGoods_type("1")
						.setSort(i+""));
				if(num<=0){
					throw new Exception("添加失败");
				}
			}
		}
		return num;
	}
	/**
	 * 添加商品分类
	 * 
	 * @param goodsBean
	 * @return
	 */
	public int insertGoodsClasss(List<String> par, String parent_id) {
		int num = 0;
		for (int i = 0; i < par.size(); i++) {
			String uuid = UUID.randomUUID().toString();
			num = goodsDao.insertGoodsClass(new GoodsBean().setGoods_name(par.get(i)).setGoods_uuid(uuid)
					.setGoods_type("1").setSort(i+"").setParent_id(parent_id).setGoods_state("1").setIs_recommend("1"));
		}
		return num;
	}

	/**
	 * 修改商品分类
	 * 
	 * @param goodsBean
	 * @return
	 */
	public int updateGoodsClass(GoodsBean goodsBean) {
		return goodsDao.updateGoodsClass(goodsBean);
	}

	/**
	 * 删除商品分类
	 * 
	 * @param goodsBean
	 * @return
	 */
	public int deleteGoodsClass(GoodsBean goodsBean) {
		return goodsDao.deleteGoodsClass(goodsBean);
	}

	/**
	 * 获得所有品牌
	 * 
	 * @return
	 */
	public List<BrandBean> getAllBrands(BrandBean brandBean) {
		return goodsDao.getAllBrands(brandBean);
	}

	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public int loadBrandExcel(List<BrandBean> brandBeans, HttpServletRequest request) throws Exception {
		int num = 0;
		for (int i = 0; i < brandBeans.size(); i++) {
			BrandBean brandBean = brandBeans.get(i);

			String fileName = TimeUtils.getCurrentTime("yyyyMMddHHmmss") + ".html";
			String path = "/html/brand/";
			HtmlUtils.writeHtml(request, path + fileName, "品牌展示", false);
			if (!"".equals(brandBean.getBrand_img())) {
				brandBean.setBrand_img("/images/brand/" + brandBean.getBrand_img());
			}
			num = insertBrand(brandBean.setBrand_url(path + "/" + fileName));
			if (num <= 0) {
				throw new Exception("添加失败");
			}
		}

		return num;
	}

	/**
	 * 添加品牌
	 * 
	 * @param goodsBean
	 * @return
	 */
	public int insertBrand(BrandBean brandBean) {
		return goodsDao.insertBrand(brandBean);
	}

	/**
	 * 修改品牌
	 * 
	 * @param goodsBean
	 * @return
	 */
	public int updateBrand(BrandBean brandBean) {
		return goodsDao.updateBrand(brandBean);
	}

	/**
	 * 删除品牌
	 * 
	 * @param goodsBean
	 * @return
	 */
	public int deleteBrand(BrandBean brandBean) {
		return goodsDao.deleteBrand(brandBean);
	}

	/**
	 * 所有商品详情
	 * 
	 * @param goodsBean
	 * @return
	 */
	public List<GoodsBean> getAllGoodsDetail(GoodsBean goodsBean, PageBean pageBean) {
		List<GoodsBean> goodsBeans = goodsDao.getAllGoodsDetail(goodsBean, pageBean);
		for (int i = 0; i < goodsBeans.size(); i++) {
			List<GoodsImgBean> goodsImgBeans = goodsDao
					.getGoodsImgs(new GoodsImgBean().setGoods_id(goodsBeans.get(i).getGoods_id() + ""));
			goodsBeans.get(i).setGoodsImgBeans(goodsImgBeans);
		}
		return goodsBeans;
	}

	public List<GoodsBean> getAllGoodsDetailNoPage(GoodsBean goodsBean) {
		List<GoodsBean> goodsBeans = goodsDao.getAllGoodsDetailNoPage(goodsBean);
		return goodsBeans;
	}

	/**
	 * 单个商品详情
	 * 
	 * @param goodsBean
	 * @return
	 */
	public GoodsBean getOneGoodsDetail(GoodsBean goodsBean) {
		GoodsBean goodsBean1 = goodsDao.getOneGoodsDetail(goodsBean);
		if (goodsBean1 != null) {
			List<GoodsImgBean> goodsImgBeans = goodsDao
					.getGoodsImgs(new GoodsImgBean().setGoods_id(goodsBean.getGoods_id() + ""));
			goodsBean1.setGoodsImgBeans(goodsImgBeans);
		}
		return goodsBean1;
	}

	/**
	 * 单个商品详情 通过sku
	 * 
	 * @param goodsBean
	 * @return
	 */
	public GoodsBean getOneGoodsDetailBySku(GoodsBean goodsBean) {
		return goodsDao.getOneGoodsDetailBySku(goodsBean);
	}
	/**
	 * 获得商品图片列表
	 * 
	 * @param goodsImgBean
	 * @return
	 */
	public List<GoodsImgBean> getGoodsImgs(GoodsImgBean goodsImgBean) {
		return goodsDao.getGoodsImgs(goodsImgBean);
	}

	/**
	 * 批量添加商品详情
	 * 
	 * @param goodsBean
	 * @return
	 * @throws Exception
	 */
	public int loadGoodsDetailExcel(List<GoodsBean> goodsBeans, HttpServletRequest request) throws Exception {
		int num = 0;
//		List<GoodsBean> goodsBeans2=goodsDao.getTemp(new GoodsBean());
//		
//		List<GoodsBean> classBeans=goodsDao.getTemp(new GoodsBean());
		if (goodsBeans != null) {
			for (int i = 0; i < goodsBeans.size(); i++) {
				GoodsBean goodsBean = goodsBeans.get(i);
//				String parent_id=goodsBeans2.get(i/1).getGoods_id()+"";
//				String brand_id=(i/48)+"";
				insertGoodsDetail(goodsBean
//						.setParent_id(parent_id)
//						.setBrand_id(brand_id)
						//.setMerchants_id("1")
						.setGoods_state("1")
						.setGoods_uuid(UUID.randomUUID().toString())
						//.setParent_id(classBeans.get(i/3).getGoods_id()+"")
//						.setGoods_img("/images/goods/1483448955139.png")
//						.setGoods_imgs("/images/goods/1483448955139.png,/images/goods/1476858195751.png")
						.setGoods_type("2")
						.setGoods_now_price(CreateRandom.createRandom(true, 4)), null, request);		
			}
		}
		return num;
	}

	/**
	 * 添加商品详情
	 * 
	 * @param goodsBean
	 * @return
	 * @throws Exception
	 */
	public int insertGoodsDetail(GoodsBean goodsBean, List<GoodsLabelBean> labelBeans,HttpServletRequest request) throws Exception {
		int num = goodsDao.insertGoodsDetail(goodsBean);
		if (num > 0) {
			goodsDao.deleteGoodsLabel(new GoodsLabelBean().setGoods_id(goodsBean.getGoods_id() + ""));
			if (labelBeans != null) {
				for (int i = 0; i < labelBeans.size(); i++) {
					List<GoodsLabelBean> goodsLabelBeans = labelBeans.get(i).getGoodsLabelBeans();
					for (int j = 0; j < goodsLabelBeans.size(); j++) {
						GoodsLabelBean goodsLabelBean = goodsLabelBeans.get(j);
						if (goodsLabelBean.getIs_select().equals("1")) {
							int k = goodsDao.insertGoodsLabel(goodsLabelBean.setGoods_id(goodsBean.getGoods_id() + ""));
							if (k <= 0) {
								
							}
						}
					}
				}
			}
			
			String qrcode_img=TimeUtils.getCurrentTime("yyyyMMddHHmmss")+"1.png";

			boolean is_success=QRCodeUtils.CreateQrcode(request,"/images/qrcode/goods/"+qrcode_img,goodsBean.getGoods_id()+"");
			if(!is_success){
				throw new Exception("二维码生成失败");
			}
			
			num = goodsDao.updateGoodsDetail(new GoodsBean()
					.setGoods_id(goodsBean.getGoods_id())
					.setQrcode_img("/images/qrcode/goods/"+qrcode_img));
			if(num<=0){
				throw new Exception("二维码更新失败");
			}
			
			String goods_imgs=goodsBean.getGoods_imgs();
			if(goods_imgs!=null && goods_imgs.length()>0){
				String []goods_arr=goods_imgs.split(",");
				for (int j = 0; j < goods_arr.length; j++) {
					int k = goodsDao.insertGoodsImg(new GoodsImgBean()
							.setGoods_id(goodsBean.getGoods_id() + "")
							.setGoods_img(goods_arr[j])
							.setSort((j+1)+""));
					if (k <= 0) {
						throw new Exception("添加商品图片失败，回滚事物");
					}
				}
			}
		}		
		
		return goodsBean.getGoods_id();
	}

	/**
	 * 添加商品详情（所有信息一次性填充）
	 * 
	 * @param goodsBean
	 * @return
	 * @throws Exception
	 */
	public int insertGoodsDetailAll(GoodsBean goodsBean, List<GoodsLabelBean> labelBeans,
			List<GoodsImgBean> goodsImgBeans, List<GoodsParameterBean> goodsParameterBeans,
			List<StandardBean> standardBeans) throws Exception {
		int num = goodsDao.insertGoodsDetail(goodsBean);
		if (num > 0) {
			goodsDao.deleteGoodsLabel(new GoodsLabelBean().setGoods_id(goodsBean.getGoods_id() + ""));
			if (labelBeans != null) {
				for (int i = 0; i < labelBeans.size(); i++) {
					List<GoodsLabelBean> goodsLabelBeans = labelBeans.get(i).getGoodsLabelBeans();
					for (int j = 0; j < goodsLabelBeans.size(); j++) {
						GoodsLabelBean goodsLabelBean = goodsLabelBeans.get(j);
						if (goodsLabelBean.getIs_select().equals("1")) {
							int k = goodsDao.insertGoodsLabel(goodsLabelBean.setGoods_id(goodsBean.getGoods_id() + ""));
							if (k <= 0) {
								throw new Exception("标签保存失败");
							}
						}
					}
				}
			}

			int k = insertGoodsImg(goodsBean, goodsImgBeans);
			if (k <= 0) {
				throw new Exception("图片保存失败");
			}

			int m = deleteParameters(new GoodsParameterBean().setGoods_id(goodsBean.getGoods_id() + ""));
			for (int i = 0; i < goodsParameterBeans.size(); i++) {
				List<GoodsParameterBean> goodsParameterBeans2 = goodsParameterBeans.get(i).getGoodsParameterBeans();
				for (int j = 0; j < goodsParameterBeans2.size(); j++) {
					int h = insertParameter(goodsParameterBeans2.get(j).setGoods_id(goodsBean.getGoods_id() + ""));
					if (h <= 0) {
						throw new Exception("保存参数失败");
					}
				}
			}

			deleteStandards(new StandardBean().setGoods_id(goodsBean.getGoods_id() + ""));
			for (int i = 0; i < standardBeans.size(); i++) {
				int h = insertStandard(standardBeans.get(i).setGoods_id(goodsBean.getGoods_id() + ""));
				if (h <= 0) {
					throw new Exception("保存规格失败");
				}
			}
		}
		return goodsBean.getGoods_id();
	}

	public int insertGoodsImg(GoodsBean goodsBean, List<GoodsImgBean> imgs) throws Exception {
		if (imgs != null) {
			int m = goodsDao.deleteGoodsImg(new GoodsImgBean().setGoods_id(goodsBean.getGoods_id() + ""));
			for (int i = 0; i < imgs.size(); i++) {
				int k = goodsDao.insertGoodsImg(imgs.get(i).setGoods_id(goodsBean.getGoods_id() + ""));
				if (k <= 0) {
					throw new Exception("添加商品图片失败，回滚事物");
				}
			}
		}
		return 1;
	}

	/**
	 * 修改商品详情
	 * 
	 * @param goodsBean
	 * @return
	 * @throws Exception
	 */
	public int updateGoodsDetail(GoodsBean goodsBean, List<GoodsLabelBean> labelBeans) throws Exception {
		int num = goodsDao.updateGoodsDetail(goodsBean);
		if (num > 0) {
			goodsDao.deleteGoodsLabel(new GoodsLabelBean().setGoods_id(goodsBean.getGoods_id() + ""));
			if (labelBeans != null) {
				for (int i = 0; i < labelBeans.size(); i++) {
					List<GoodsLabelBean> goodsLabelBeans = labelBeans.get(i).getGoodsLabelBeans();
					for (int j = 0; j < goodsLabelBeans.size(); j++) {
						GoodsLabelBean goodsLabelBean = goodsLabelBeans.get(j);
						if (goodsLabelBean.getIs_select().equals("1")) {
							int k = goodsDao.insertGoodsLabel(goodsLabelBean.setGoods_id(goodsBean.getGoods_id() + ""));
							if (k <= 0) {
								throw new Exception("添加商品标签失败，回滚事物");
							}
						}
					}
				}
			}
		}
		return num;
	}

	/**
	 * 修改商品详情
	 * 
	 * @param goodsBean
	 * @return
	 * @throws Exception
	 */
	public int updateGoodsDetailAll(GoodsBean goodsBean, List<GoodsLabelBean> labelBeans,
			List<GoodsImgBean> goodsImgBeans, List<GoodsParameterBean> goodsParameterBeans,
			List<StandardBean> standardBeans) throws Exception {
		int num = goodsDao.updateGoodsDetail(goodsBean);
		if (num > 0) {
			goodsDao.deleteGoodsLabel(new GoodsLabelBean().setGoods_id(goodsBean.getGoods_id() + ""));
			if (labelBeans != null) {
				for (int i = 0; i < labelBeans.size(); i++) {
					List<GoodsLabelBean> goodsLabelBeans = labelBeans.get(i).getGoodsLabelBeans();
					for (int j = 0; j < goodsLabelBeans.size(); j++) {
						GoodsLabelBean goodsLabelBean = goodsLabelBeans.get(j);
						if (goodsLabelBean.getIs_select().equals("1")) {
							int k = goodsDao.insertGoodsLabel(goodsLabelBean.setGoods_id(goodsBean.getGoods_id() + ""));
							if (k <= 0) {
								throw new Exception("添加商品标签失败，回滚事物");
							}
						}
					}
				}
			}

			int k = insertGoodsImg(goodsBean, goodsImgBeans);
			if (k <= 0) {
				throw new Exception("图片保存失败");
			}

			int m = deleteParameters(new GoodsParameterBean().setGoods_id(goodsBean.getGoods_id() + ""));

			for (int i = 0; i < goodsParameterBeans.size(); i++) {
				List<GoodsParameterBean> goodsParameterBeans2 = goodsParameterBeans.get(i).getGoodsParameterBeans();
				for (int j = 0; j < goodsParameterBeans2.size(); j++) {
					int h = insertParameter(goodsParameterBeans2.get(j));
					if (h <= 0) {
						throw new Exception("保存参数失败");
					}
				}
			}

			deleteStandards(new StandardBean().setGoods_id(goodsBean.getGoods_id() + ""));
			for (int i = 0; i < standardBeans.size(); i++) {
				int h = insertStandard(standardBeans.get(i));
				if (h <= 0) {
					throw new Exception("保存规格失败");
				}
			}
		}
		return num;
	}

	/**
	 * 删除商品详情
	 * 
	 * @param goodsBean
	 * @return
	 */
	public int deleteAllGoods(GoodsBean goodsBean) {
		return goodsDao.deleteAllGoods(goodsBean);
	}
	
	public int updateAllGoodsPrice(GoodsBean goodsBean){
		return goodsDao.updateAllGoodsPrice(goodsBean);
	}
	/**
	 * 删除商品详情
	 * 
	 * @param goodsBean
	 * @return
	 */
	public int deleteGoodsDetail(GoodsBean goodsBean) {
		return goodsDao.deleteGoodsDetail(goodsBean);
	}

	/**
	 * 获得所有商品参数
	 * 
	 * @return
	 */
	public List<GoodsParameterBean> getAllParameters(GoodsParameterBean goodsParameterBean) {
		List<GoodsParameterBean> goodsParameterBeans = goodsDao.getAllParametersByParent(goodsParameterBean);
		if (goodsParameterBeans != null) {
			for (int i = 0; i < goodsParameterBeans.size(); i++) {
				List<GoodsParameterBean> goodsParameterBeans2 = goodsDao.getAllParametersByParent(goodsParameterBean
						.setParameter_type("2").setParent_id(goodsParameterBeans.get(i).getParameter_id() + ""));
				goodsParameterBeans.get(i).setGoodsParameterBeans(goodsParameterBeans2);
			}
		}
		return goodsParameterBeans;
	}

	/**
	 * 添加商品参数
	 * 
	 * @param goodsBean
	 * @return
	 */
	public int insertParameter(GoodsParameterBean goodsParameterBean) {
		return goodsDao.insertParameter(goodsParameterBean);
	}

	/**
	 * 修改商品参数
	 * 
	 * @param goodsBean
	 * @return
	 */
	public int updateParameter(GoodsParameterBean goodsParameterBean) {
		return goodsDao.updateParameter(goodsParameterBean);
	}

	/**
	 * 删除商品参数
	 * 
	 * @param goodsBean
	 * @return
	 */
	public int deleteParameter(GoodsParameterBean goodsParameterBean) {
		return goodsDao.deleteParameter(goodsParameterBean);
	}

	/**
	 * 批量删除商品参数
	 * 
	 * @param goodsBean
	 * @return
	 */
	public int deleteParameters(GoodsParameterBean goodsParameterBean) {
		return goodsDao.deleteParameters(goodsParameterBean);
	}

	/**
	 * 获得所有服务参数
	 * 
	 * @return
	 */
	public List<GoodsServiceBean> getAllServices(GoodsServiceBean goodsServiceBean) {
		List<GoodsServiceBean> goodsServiceBeans = goodsDao.getAllServiceByParent(goodsServiceBean);
		if (goodsServiceBeans != null) {
			for (int i = 0; i < goodsServiceBeans.size(); i++) {
				List<GoodsServiceBean> goodsServiceBeans2 = goodsDao.getAllServiceByParent(goodsServiceBean
						.setService_type("2").setParent_id(goodsServiceBeans.get(i).getService_id() + ""));
				goodsServiceBeans.get(i).setGoodsServiceBeans(goodsServiceBeans2);
			}
		}
		return goodsServiceBeans;
	}

	/**
	 * 添加服务参数
	 * 
	 * @param goodsBean
	 * @return
	 */
	public int insertService(GoodsServiceBean goodsServiceBean) {
		return goodsDao.insertService(goodsServiceBean);
	}

	/**
	 * 修改服务参数
	 * 
	 * @param goodsBean
	 * @return
	 */
	public int updateService(GoodsServiceBean goodsServiceBean) {
		return goodsDao.updateService(goodsServiceBean);
	}

	/**
	 * 删除服务参数
	 * 
	 * @param goodsBean
	 * @return
	 */
	public int deleteService(GoodsServiceBean goodsServiceBean) {
		return goodsDao.deleteService(goodsServiceBean);
	}

	/**
	 * 获得品牌套餐
	 * 
	 * @param brandPackageBean
	 * @param pageBean
	 * @return
	 */
	public List<BrandPackageBean> getBrandPackages(BrandPackageBean brandPackageBean, PageBean pageBean) {
		List<BrandPackageBean> brandPackageBeans = goodsDao.getBrandPackages(brandPackageBean);
		for (int i = 0; i < brandPackageBeans.size(); i++) {
			List<BrandPackageImgBean> brandPackageImgBeans = goodsDao.getBrandPackageImgs(
					new BrandPackageImgBean().setPackage_id(brandPackageBeans.get(i).getPackage_id() + ""));
			brandPackageBeans.get(i).setBrandPackageImgBeans(brandPackageImgBeans);
		}
		return brandPackageBeans;
	}

	/**
	 * 添加品牌套餐
	 * 
	 * @param brandPackageBean
	 * @return
	 * @throws Exception
	 */
	public int insertBrandPackage(BrandPackageBean brandPackageBean, List<BrandPackageImgBean> imgs) throws Exception {
		int num = goodsDao.insertBrandPackage(brandPackageBean);
		if (num > 0) {
			if (imgs != null) {
				for (int i = 0; i < imgs.size(); i++) {
					int k = goodsDao
							.insertBrandPackageImg(imgs.get(i).setPackage_id(brandPackageBean.getPackage_id() + ""));
					if (k <= 0) {
						throw new Exception("添加套餐图片失败 回滚事物");
					}
				}
			}
		}
		return num;
	}

	/**
	 * 修改品牌套餐
	 * 
	 * @param brandPackageBean
	 * @return
	 * @throws Exception
	 */
	public int updateBrandPackage(BrandPackageBean brandPackageBean, List<BrandPackageImgBean> imgs) throws Exception {
		int num = goodsDao.updateBrandPackage(brandPackageBean);
		if (num > 0) {
			if (imgs != null) {
				int l = goodsDao.deleteBeandPackageImg(
						new BrandPackageImgBean().setPackage_id(brandPackageBean.getPackage_id() + ""));
				for (int i = 0; i < imgs.size(); i++) {
					int k = goodsDao
							.insertBrandPackageImg(imgs.get(i).setPackage_id(brandPackageBean.getPackage_id() + ""));
					if (k <= 0) {
						throw new Exception("修改套餐图片失败 回滚事物");
					}
				}
			}
		}
		return num;
	}

	/**
	 * 添加某个品牌的套餐商品
	 * 
	 * @param goodsBean
	 * @return
	 */
	public List<GoodsBean> getGoodsByBrand(GoodsBean goodsBean) {
		return goodsDao.getGoodsByBrand(goodsBean);
	}

	/**
	 * 获得某个品牌套餐的选择商品
	 * 
	 * @return
	 */
	public List<BrandPackageGoodsBean> getBrandPackageGoods(BrandPackageGoodsBean brandPackageGoodsBean) {
		return goodsDao.getBrandPackageGoods(brandPackageGoodsBean);
	}

	/**
	 * 添加某个品牌的套餐商品
	 * 
	 * @return
	 */
	public int insertBrandPackageGoods(BrandPackageGoodsBean brandPackageGoodsBean) {
		return goodsDao.insertBrandPackageGoods(brandPackageGoodsBean);
	}

	/**
	 * 删除某个品牌的套餐商品
	 * 
	 * @param goodsBean
	 * @return
	 */
	public int deleteBrandPackageGoods(BrandPackageGoodsBean brandPackageGoodsBean) {
		return goodsDao.deleteBrandPackageGoods(brandPackageGoodsBean);
	}

	/**
	 * 获得商家商品
	 * 
	 * @param businessGoodsBean
	 * @param pageBean
	 * @return
	 */
	public List<BusinessGoodsBean> getBusinessGoods(BusinessGoodsBean businessGoodsBean, PageBean pageBean) {
		List<BusinessGoodsBean> businessGoodsBeans = goodsDao.getBusinessGoods(businessGoodsBean, pageBean);
		for (int i = 0; i < businessGoodsBeans.size(); i++) {
			GoodsBean goodsBean = goodsDao.getOneGoodsDetail(
					new GoodsBean().setGoods_id(Integer.valueOf(businessGoodsBeans.get(i).getGoods_id())));
			businessGoodsBeans.get(i).setGoodsBean(goodsBean);
		}
		return businessGoodsBeans;
	}

	public List<String> getBusinessGoodsQRCodePath(BusinessGoodsBean businessGoodsBean) {

		return goodsDao.getBusinessGoodsQRCodePath(businessGoodsBean);
	};

	/**
	 * 获得单个商家商品
	 * 
	 * @param businessGoodsBean
	 * @return
	 */
	public BusinessGoodsBean getBusinessGood(BusinessGoodsBean businessGoodsBean) {
		return goodsDao.getBusinessGood(businessGoodsBean);
	}

	/**
	 * 添加商家商品
	 * 
	 * @param businessGoodsBean
	 * @return
	 */
	public int insertBusinessGoods(BusinessGoodsBean businessGoodsBean) {
		return goodsDao.insertBusinessGoods(businessGoodsBean);
	}

	/**
	 * 删除商家商品
	 * 
	 * @param businessGoodsBean
	 * @return
	 */
	public int deleteBusinessGoods(BusinessGoodsBean businessGoodsBean) {
		return goodsDao.deleteBusinessGoods(businessGoodsBean);
	}

	/*
	 * 顺手拍
	 */
	/**
	 * 首页7个标签的2级分类
	 * 
	 * @param sspClassBean
	 * @return
	 */
	public List<SSPClassBean> getSSPHomeClasss(SSPClassBean sspClassBean) {
		return goodsDao.getSSPHomeClasss(sspClassBean);
	}

	/**
	 * 添加标签2级分类
	 * 
	 * @param sspClassBean
	 * @return
	 */
	public int insertSSPHomeClass(SSPClassBean sspClassBean) {
		return goodsDao.insertSSPHomeClass(sspClassBean);
	}

	/**
	 * 修改标签2级分类
	 * 
	 * @param sspClassBean
	 * @return
	 */
	public int updateSSPHomeClass(SSPClassBean sspClassBean) {
		return goodsDao.updateSSPHomeClass(sspClassBean);
	}

	/**
	 * 删除标签2级分类
	 * 
	 * @param sspClassBean
	 * @return
	 */
	public int deleteSSPHomeClass(SSPClassBean sspClassBean) {
		return goodsDao.deleteSSPHomeClass(sspClassBean);
	}
}
