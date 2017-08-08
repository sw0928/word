package tst.project.service.interfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.bean.merchants.MerchantsLabelBean;
import tst.project.bean.merchants.QualificationBean;
import tst.project.bean.goods.GoodsBean;
import tst.project.bean.goods.GoodsImgBean;
import tst.project.bean.merchants.LabelQualificationBean;
import tst.project.bean.merchants.MerchantsAccountBean;
import tst.project.bean.merchants.MerchantsBean;
import tst.project.bean.merchants.MerchantsDescImgBean;
import tst.project.bean.merchants.MerchantsImgBean;
import tst.project.dao.interfaces.GoodsDaoI;
import tst.project.dao.interfaces.MerchantsDaoI;
import tst.project.page.PageBean;
@Service
@Transactional(rollbackFor = Exception.class)
public class MerchantsServiceI {
	@Resource
	MerchantsDaoI merchantsDaoI;
	
	@Resource
	GoodsServiceI goodsServiceI;
	
	@Resource
	SWService swService;
	/**
	 * 店铺的分类列表
	 * @return
	 */
	public List<GoodsBean> getMerchantsClass(GoodsBean goodsBean,String level){
		if("1".equals(level)){
			return merchantsDaoI.getMerchantsClass1(goodsBean);
		}else if("2".equals(level)){
			return merchantsDaoI.getMerchantsClass2(goodsBean);
		}else{
			return merchantsDaoI.getMerchantsClass3(goodsBean);
		}
	}

	/**
	 * 店铺的分类列表
	 * @return
	 */
	public List<GoodsBean> getMerchantsClasss(GoodsBean goodsBean){
		List<GoodsBean> goodsBeans=merchantsDaoI.getMerchantsClass1(goodsBean.setParent_id("-1"));
		if(goodsBeans!=null){
			for (int i = 0; i < goodsBeans.size(); i++) {
				GoodsBean goodsBean2=goodsBeans.get(i);
				List<GoodsBean> goodsBeans2=merchantsDaoI.getMerchantsClass2(goodsBean.setParent_id(goodsBean2.getGoods_id()+""));
				if(goodsBeans2!=null){
					for (int j = 0; j < goodsBeans2.size(); j++) {
						GoodsBean goodsBean3=goodsBeans2.get(j);
						List<GoodsBean> goodsBeans3=merchantsDaoI
								.getMerchantsClass3(goodsBean.setParent_id(goodsBean3.getGoods_id()+""));
						goodsBean3.setGoodsBeans(goodsBeans3);
					}
				}
				goodsBean2.setGoodsBeans(goodsBeans2);
			}
		}
		return goodsBeans;
	}
	/**
	 * 搜索店铺列表
	 * @param merchantsBean
	 * @param pageBean
	 * @return
	 */
	public List<MerchantsBean> searchMerchants(MerchantsBean merchantsBean,PageBean pageBean){
		List<MerchantsBean> merchantsBeans=merchantsDaoI.searchMerchants(merchantsBean, pageBean);
		for (int i = 0; i < merchantsBeans.size(); i++) {
			List<GoodsBean> goodsBeans=swService.getMerchantsRecommendGoods(new GoodsBean()
					.setMerchants_id(merchantsBeans.get(i).getMerchants_id()+""));
			merchantsBeans.get(i).setGoodsBeans(goodsBeans);
		}
		return merchantsBeans;
	}
	
	/**
	 * 更新商家信息
	 * @return
	 */
	public int updateMerchantsDetail(MerchantsBean merchantsBean){
		return merchantsDaoI.updateMerchantsDetail(merchantsBean);
	}
	
	/**
	 * 更新推广员
	 * @return
	 */
	public int updateMerchantsAccountDetail(MerchantsAccountBean merchantsAccountBean){
		return merchantsDaoI.updateMerchantsAccountDetail(merchantsAccountBean);
	}
	
	/**
	 * 获得推广员
	 * @return
	 */
	public MerchantsAccountBean getMerchantsAccountDetail(MerchantsAccountBean merchantsAccountBean){
		return merchantsDaoI.getMerchantsAccountDetail(merchantsAccountBean);
	}
	
	/**
	 * 获得商家所有需要的资质证明
	 * @param qualificationBean
	 * @return
	 */
	public List<QualificationBean> getAllQualifications(QualificationBean qualificationBean){
		return merchantsDaoI.getAllQualifications(qualificationBean);
	}
	/**
	 * 单个商家的商品列表
	 * @param merchantsBean
	 * @return
	 */
	public List<GoodsBean> getMerchantsGoodss(GoodsBean goodsBean,PageBean pageBean){
		List<GoodsBean> goodsBeans = merchantsDaoI.getMerchantsGoodss(goodsBean,pageBean);
//		if(goodsBeans!=null){
//			for (int i = 0; i < goodsBeans.size(); i++) {
//				List<GoodsImgBean> goodsImgBeans = goodsDaoI
//						.getGoodsImgs(new GoodsImgBean().setGoods_id(goodsBeans.get(i).getGoods_id() + ""));
//				goodsBeans.get(i).setGoodsImgBeans(goodsImgBeans);
//			}		
//		}
		return goodsBeans;
	}
	/**
	 * 根据用户id获得申请信息
	 * @param merchantsBean
	 * @return
	 */
	public MerchantsBean getMerchantsByMember(MerchantsBean merchantsBean){
		MerchantsBean merchantsBean2=merchantsDaoI.getMerchantsByMember(merchantsBean);
		if(merchantsBean2!=null){
			List<MerchantsImgBean> merchantsImgBeans=
					merchantsDaoI.getMerchantsImgs(new MerchantsImgBean().
							setMerchants_id(merchantsBean2.getMerchants_id()+""));
			merchantsBean2.setMerchantsImgBeans(merchantsImgBeans);
			String a[] =new String[1];
			String label_ids=merchantsBean2.getLabel_ids();
			Map<String, Object> params = new HashMap<String, Object>(2);
			params.put("ids", label_ids!=null&&label_ids.length()>0?label_ids.split(","):a);
			
			List<MerchantsLabelBean> merchantsLabelBeans=merchantsDaoI.getLabels(params);
			merchantsBean2.setMerchantsLabelBeans(merchantsLabelBeans);
		}
		return merchantsBean2;
	}
	
	/**
	 * 商家申请入驻
	 * @param merchantsBean
	 * @return
	 * @throws Exception 
	 */
	public int applyMerchants(MerchantsBean merchantsBean,List<MerchantsImgBean> merchantsImgBeans,String label_ids) 
			throws Exception{
		int num=merchantsDaoI.applyMerchants(merchantsBean);
		if(num>0){
			if(merchantsImgBeans!=null){
				for (int i = 0; i < merchantsImgBeans.size(); i++) {
					int h=merchantsDaoI.insertMerchantsImg(merchantsImgBeans.get(i).
							setMerchants_id(merchantsBean.getMerchants_id()+""));
					if(h<=0){
						throw new Exception("商家认证信息入库失败!");
					}
				}	
			}
			
		}
		return num;
	}
	/**
	 * 商家申请入驻
	 * @param merchantsBean
	 * @return
	 * @throws Exception 
	 */
	public int updateApplyMerchants(MerchantsBean merchantsBean,List<MerchantsImgBean> merchantsImgBeans,String label_ids) 
			throws Exception{
		int num=merchantsDaoI.updateApplyMerchants(merchantsBean);
		if(num>0){
			num=merchantsDaoI.deleteMerchantsImgs(new MerchantsImgBean().setMerchants_id(merchantsBean.getMerchants_id()+""));
			
			if(merchantsImgBeans!=null){
				for (int i = 0; i < merchantsImgBeans.size(); i++) {
					int h=merchantsDaoI.insertMerchantsImg(merchantsImgBeans.get(i).
							setMerchants_id(merchantsBean.getMerchants_id()+""));
					if(h<=0){
						throw new Exception("商家认证信息入库失败!");
					}
				}	
			}
			
		}
		return num;
	}
	
	
	/**
	 * 单个商家详情
	 * @param merchantsBean
	 * @return
	 */
	public MerchantsBean getOneMerchantsDetail(MerchantsBean merchantsBean){
		MerchantsBean merchantsBean2= merchantsDaoI.getOneMerchantsDetail(merchantsBean);
		if(merchantsBean2!=null){
			List<MerchantsImgBean> merchantsImgBeans=merchantsDaoI
					.getMerchantsImgs(new MerchantsImgBean().setMerchants_id(merchantsBean2.getMerchants_id()+""));
			merchantsBean2.setMerchantsImgBeans(merchantsImgBeans);
			
			List<MerchantsDescImgBean> merchantsDescImgBeans=merchantsDaoI
					.getMerchantsDescImgs(new MerchantsDescImgBean().setMerchants_id(merchantsBean2.getMerchants_id()+""));
			merchantsBean2.setMerchantsDescImgBeans(merchantsDescImgBeans);
		}
		return merchantsBean2;
	}
	
	/**
	 * 获得商家可能含有的标签
	 * @param merchantsLabelBean
	 * @return
	 */
	public List<MerchantsLabelBean> getMerchantsLabels(MerchantsLabelBean merchantsLabelBean){
		List<MerchantsLabelBean> merchantsLabelBeans=merchantsDaoI.getMerchantsLabels(merchantsLabelBean);
		for (int i = 0; i < merchantsLabelBeans.size(); i++) {
			List<LabelQualificationBean> labelQualificationBeans
				=merchantsDaoI.getLabelQualifications(new LabelQualificationBean().setLabel_id(merchantsLabelBeans.get(i).getLabel_id()+""));
			merchantsLabelBeans.get(i).setLabelQualificationBeans(labelQualificationBeans);
		}
		return merchantsLabelBeans;
	}
}
