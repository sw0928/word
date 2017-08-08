package tst.project.dao.interfaces;

import java.util.List;
import java.util.Map;

import tst.project.bean.goods.GoodsBean;
import tst.project.bean.merchants.LabelQualificationBean;
import tst.project.bean.merchants.MerchantsAccountBean;
import tst.project.bean.merchants.MerchantsBean;
import tst.project.bean.merchants.MerchantsDescImgBean;
import tst.project.bean.merchants.MerchantsImgBean;
import tst.project.bean.merchants.MerchantsLabelBean;
import tst.project.bean.merchants.QualificationBean;
import tst.project.page.PageBean;

public interface MerchantsDaoI {
	/**
	 * 店铺的分类列表
	 * @return
	 */
	public List<GoodsBean> getMerchantsClass1(GoodsBean goodsBean);
	
	/**
	 * 店铺的分类列表
	 * @return
	 */
	public List<GoodsBean> getMerchantsClass2(GoodsBean goodsBean);
	
	/**
	 * 店铺的分类列表
	 * @return
	 */
	public List<GoodsBean> getMerchantsClass3(GoodsBean goodsBean);
	
	/**
	 * 搜索店铺列表
	 * @param merchantsBean
	 * @param pageBean
	 * @return
	 */
	public List<MerchantsBean> searchMerchants(MerchantsBean merchantsBean,PageBean pageBean);
	
	/**
	 * 更新推广员
	 * @return
	 */
	public int updateMerchantsAccountDetail(MerchantsAccountBean merchantsAccountBean);
	/**
	 * 获得推广员
	 * @return
	 */
	public MerchantsAccountBean getMerchantsAccountDetail(MerchantsAccountBean merchantsAccountBean);
	/**
	 * 更新商家信息
	 * @return
	 */
	public int updateMerchantsDetail(MerchantsBean merchantsBean);
	
	/**
	 * 获得商家所有需要的资质证明
	 * @param qualificationBean
	 * @return
	 */
	public List<QualificationBean> getAllQualifications(QualificationBean qualificationBean);
	/**
	 * 单个商家的商品列表
	 * @param merchantsBean
	 * @return
	 */
	public List<GoodsBean> getMerchantsGoodss(GoodsBean goodsBean,PageBean pageBean);
	
	/**
	 * 商家的资质图片
	 * @param merchantsImgBean
	 * @return
	 */
	public List<MerchantsImgBean> getMerchantsImgs(MerchantsImgBean merchantsImgBean);
	
	/**
	 * 商家的资质图片
	 * @param merchantsImgBean
	 * @return
	 */
	public List<MerchantsDescImgBean> getMerchantsDescImgs(MerchantsDescImgBean merchantsImgBean);
	
	public List<MerchantsLabelBean> getLabels(Map<String, Object> params);

	/**
	 * 根据用户id获得申请信息
	 * @param merchantsBean
	 * @return
	 */
	public MerchantsBean getMerchantsByMember(MerchantsBean merchantsBean);
	/**
	 * 商家申请入驻
	 * @param merchantsBean
	 * @return
	 */
	public int applyMerchants(MerchantsBean merchantsBean);
	
	/**
	 * 修改商家申请入驻
	 * @param merchantsBean
	 * @return
	 */
	public int updateApplyMerchants(MerchantsBean merchantsBean);

	/**
	 * 商家图片信息入库
	 * @param merchantsImgBean
	 * @return
	 */
	public int insertMerchantsImg(MerchantsImgBean merchantsImgBean);
	
	/**
	 * 删除商家图片信息
	 * @param merchantsImgBean
	 * @return
	 */
	public int deleteMerchantsImgs(MerchantsImgBean merchantsImgBean);
	/**
	 * 单个商家详情
	 * @param merchantsBean
	 * @return
	 */
	public MerchantsBean getOneMerchantsDetail(MerchantsBean merchantsBean);
	
	/**
	 * 获得商家可能含有的标签
	 * @param merchantsLabelBean
	 * @return
	 */
	public List<MerchantsLabelBean> getMerchantsLabels(MerchantsLabelBean merchantsLabelBean);
	
	/**
	 * 商家 标签资质证明
	 * @param labelQualificationBean
	 * @return
	 */
	public List<LabelQualificationBean> getLabelQualifications(LabelQualificationBean labelQualificationBean);
}
