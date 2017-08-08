package tst.project.service.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.bean.HostBean;
import tst.project.bean.goods.GoodsBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.merchants.MerchantsAccountBean;
import tst.project.bean.merchants.MerchantsBean;
import tst.project.bean.merchants.MerchantsDescImgBean;
import tst.project.bean.merchants.MerchantsImgBean;
import tst.project.bean.merchants.MerchantsLabelBean;
import tst.project.bean.merchants.QualificationBean;
import tst.project.bean.wx.WXSetingBean;
import tst.project.dao.controller.MerchantsDao;
import tst.project.page.PageBean;
import tst.project.utils.HttpUtils;
import tst.project.utils.QRCodeUtils;
import tst.project.utils.TimeUtils;
import tst.project.utils.WXUtils;

@Service
@Transactional(rollbackFor = Exception.class)
public class MerchantsService {
	@Resource
	MerchantsDao merchantsDao;

	@Resource
	OthersServiceC othersServiceC;
	
	@Resource
	GoodsService goodsService;
	
	
	public int insertMerchantsDescImg(MerchantsDescImgBean merchantsDescImgBean){
		return merchantsDao.insertMerchantsDescImg(merchantsDescImgBean);
	}
	
	public int updateMerchantsDescImg(MerchantsDescImgBean merchantsDescImgBean){
		return merchantsDao.updateMerchantsDescImg(merchantsDescImgBean);
	}
	
	public int deleteMerchantsDescImg(MerchantsDescImgBean merchantsDescImgBean){
		return merchantsDao.deleteMerchantsDescImg(merchantsDescImgBean);
	}
	
	public List<MerchantsDescImgBean> getMerchantsDescImgs(MerchantsDescImgBean merchantsDescImgBean){
		return merchantsDao.getMerchantsDescImgs(merchantsDescImgBean);
	}
	
	
	public int deleteMerchants(MerchantsBean merchantsBean){
		return merchantsDao.deleteMerchants(merchantsBean);
	}
	
	/**
	 * 店铺粉丝
	 * @return
	 */
	public List<MemberBean> getBusinessFollower(MerchantsAccountBean merchantsAccountBean,PageBean pageBean){
		return merchantsDao.getBusinessFollower(merchantsAccountBean, pageBean);
	}
	
	/**
	 * 店铺的推广员详情
	 * @param merchantsAccountBean
	 * @return
	 */
	public List<MerchantsAccountBean> getBusinessExtensionDetail(MerchantsAccountBean merchantsAccountBean){
		return merchantsDao.getBusinessExtensionDetail(merchantsAccountBean);
	}
	/**
	 * 店铺的推广员列表
	 * @param merchantsAccountBean
	 * @return
	 */
	public List<MerchantsAccountBean> getBusinessExtensions(MerchantsAccountBean merchantsAccountBean,PageBean pageBean){
		return merchantsDao.getBusinessExtensions(merchantsAccountBean,pageBean);
	}
	
	/**
	 * 删除商家账号
	 * 
	 * @param merchantsAccountBean
	 * @return
	 * @throws Exception
	 */
	public int deleteMerchantsAccount(MerchantsAccountBean merchantsAccountBean) throws Exception {
		MerchantsAccountBean merchantsAccountBean2 = getOneMerchantsAccount(merchantsAccountBean);

		int num = merchantsDao.deleteMerchantsAccount(merchantsAccountBean);
		if (num > 0) {
			int k = deleteMerchantsRelationAccount(merchantsAccountBean);
			if (k <= 0) {
				throw new Exception("删除失败");
			}

			if (merchantsAccountBean2 != null && "1".equals(merchantsAccountBean2.getIs_relation_defalut())) {// 如果删除的是默认账号
																												// 则设置另外一个默认
				List<MerchantsAccountBean> merchantsAccountBeans = getMerchantsAccounts(merchantsAccountBean2);
				if (merchantsAccountBeans != null && merchantsAccountBeans.size() > 0) {// 还有账号
					int h = setMerchantsAccountDefault(merchantsAccountBeans.get(0));
					if (h <= 0) {
						throw new Exception("设置默认失败");
					}
				}
			}

		}
		return num;
	}

	/**
	 * 设置账号默认
	 * 
	 * @param merchantsAccountBean
	 * @return
	 */
	public int setMerchantsAccountDefault(MerchantsAccountBean merchantsAccountBean) {
		return merchantsDao.setMerchantsAccountDefault(merchantsAccountBean);
	}

	/**
	 * 删除商家关联账号
	 * 
	 * @return
	 */
	public int deleteMerchantsRelationAccount(MerchantsAccountBean merchantsAccountBean) {
		return merchantsDao.deleteMerchantsRelationAccount(merchantsAccountBean);
	}

	/**
	 * 修改商家账号
	 * 
	 * @param merchantsAccountBean
	 * @return
	 */
	public int updateMerchantsAccount(MerchantsAccountBean merchantsAccountBean) {
		return merchantsDao.updateMerchantsAccount(merchantsAccountBean);
	}

	/**
	 * 添加商家账号
	 * 
	 * @param merchantsAccountBean
	 * @return
	 * @throws Exception
	 */
	public int insertMerchantsAccount(MerchantsAccountBean merchantsAccountBean, HttpServletRequest request)
			throws Exception {
		int num = merchantsDao.insertMerchantsAccount(merchantsAccountBean);
		if (num > 0) {
			int k = 0;
			if ("1".equals(merchantsAccountBean.getIs_extension())) {
				
				WXSetingBean wxSetingBean = othersServiceC.getWXSeting(new WXSetingBean().setWeixin_type("1"));

				String access_token = WXUtils.getAccess_token(wxSetingBean.getWeixin_appid(), wxSetingBean.getWeixin_secret());

				String result = WXUtils.getQrcode(access_token,
						"wx_type=merchants_extend&business_id="+
								merchantsAccountBean.getMerchants_id()+"&merchants_account_id="+merchantsAccountBean.getMerchants_account_id());
				
				String qrcode_img = TimeUtils.getCurrentTime("yyyyMMddHHmmss") + "1.png";
				
				boolean is_success=HttpUtils.downloadFile(result,request.getSession().getServletContext()
						.getRealPath("/")+"/images/qrcode/business/"+qrcode_img);
				if(!is_success){
					throw new Exception("二维码生成失败");
				}
				
				is_success=QRCodeUtils.composeQrcode(merchantsAccountBean.getMerchants_name(),request.getSession().getServletContext()
						.getRealPath("/")+merchantsAccountBean.getMerchants_img(), request.getSession().getServletContext()
						.getRealPath("/")+"/images/qrcode/business/"+qrcode_img, request.getSession().getServletContext()
						.getRealPath("/")+"/images/qrcode/business/"+qrcode_img);
				if(!is_success){
					throw new Exception("二维码合成失败");
				}
						
//				String qrcode_img = TimeUtils.getCurrentTime("yyyyMMddHHmmss") + "1.png";
//				
//				HostBean hostBean=othersServiceC.getHost(new HostBean().setHost_type("1"));
//				
//				boolean is_success = QRCodeUtils.CreateQrcode(request, "/images/qrcode/business/" + qrcode_img,
//						hostBean.getHost_url() + "weixinhome/index.html#/saoma?" + "business_id="
//								+ merchantsAccountBean.getMerchants_id() + "&merchants_account_id="
//								+ merchantsAccountBean.getMerchants_account_id());
				if (!is_success) {
					throw new Exception("二维码生成失败");
				}

				// is_success=QRCodeUtils.composeQrcode(merchantsAccountBean.getMerchants_name()+":"+merchantsAccountBean.getMerchants_id(),
				// request.getSession().getServletContext().getRealPath("/")+merchantsAccountBean.getMerchants_img(),
				// request.getSession().getServletContext().getRealPath("/")+"/images/qrcode/business/"+qrcode_img,
				// request.getSession().getServletContext().getRealPath("/")+"/images/qrcode/business/"+qrcode_img);
				// if(!is_success){
				// throw new Exception("二维码合成失败");
				// }
				//

				k = merchantsDao.updateMerchantsAccountDetail(new MerchantsAccountBean()
						.setMerchants_account_id(merchantsAccountBean.getMerchants_account_id())
						.setQrcode_img("/images/qrcode/business/" + qrcode_img));

				if (k <= 0) {
					throw new Exception("推广二维码异常");
				}
			}

			List<MerchantsAccountBean> merchantsAccountBeans = getMerchantsAccounts(merchantsAccountBean);
			String is_default = "0";
			if (merchantsAccountBeans != null && merchantsAccountBeans.size() > 0) {
				is_default = "0";
			} else {
				is_default = "1";
			}

			k = insertMerchantsRelationAccount(merchantsAccountBean.setIs_default(is_default));
			if (k <= 0) {
				throw new Exception("关联账号失败");
			}
		}
		return num;
	}

	/**
	 * 修改商家账号详情
	 * 
	 * @param merchantsAccountBean
	 * @return
	 */
	public int updateMerchantsAccountDetail(MerchantsAccountBean merchantsAccountBean) {
		return merchantsDao.updateMerchantsAccountDetail(merchantsAccountBean);
	}

	/**
	 * 账号和商家关联起来
	 * 
	 * @param merchantsAccountBean
	 * @return
	 */
	public int insertMerchantsRelationAccount(MerchantsAccountBean merchantsAccountBean) {
		return merchantsDao.insertMerchantsRelationAccount(merchantsAccountBean);
	}

	/**
	 * 获得商家的账号信息
	 * 
	 * @return
	 */
	public List<MerchantsAccountBean> getMerchantsAccounts(MerchantsAccountBean merchantsAccountBean) {
		return merchantsDao.getMerchantsAccounts(merchantsAccountBean);
	}

	/**
	 * 获得商家单个账号信息
	 * 
	 * @return
	 */
	public MerchantsAccountBean getOneMerchantsAccount(MerchantsAccountBean merchantsAccountBean) {
		return merchantsDao.getOneMerchantsAccount(merchantsAccountBean);
	}
	
	/**
	 * 获得商家单个账号信息
	 * 
	 * @return
	 */
	public MerchantsAccountBean getOneMerchantsAccountByID(MerchantsAccountBean merchantsAccountBean) {
		return merchantsDao.getOneMerchantsAccountByID(merchantsAccountBean);
	}

	/**
	 * 审核用户申请
	 * 
	 * @return
	 */
	public int auditingApplyMerchants(MerchantsBean merchantsBean) {
		return merchantsDao.auditingApplyMerchants(merchantsBean);
	}

	/**
	 * 单个标签资质
	 * 
	 * @param qualificationBean
	 * @return
	 */
	public QualificationBean getOneMerchantsLabelQualification(QualificationBean qualificationBean) {
		return merchantsDao.getOneMerchantsLabelQualification(qualificationBean);
	}

	/**
	 * 删除标签资质
	 * 
	 * @param qualificationBean
	 * @return
	 */
	public int deleteLabelQualification(QualificationBean qualificationBean) {
		return merchantsDao.deleteLabelQualification(qualificationBean);
	}

	/**
	 * 添加标签资质
	 * 
	 * @param qualificationBean
	 * @return
	 */
	public int insertLabelQualification(QualificationBean qualificationBean) {
		return merchantsDao.insertLabelQualification(qualificationBean);
	}

	/**
	 * 获得所有标签资质
	 * 
	 * @param qualificationBean
	 * @return
	 */
	public List<QualificationBean> getMerchantsLabelQualifications(QualificationBean qualificationBean) {
		return merchantsDao.getMerchantsLabelQualifications(qualificationBean);
	}

	/**
	 * 添加商家资质
	 * 
	 * @param merchantsLabelBean
	 * @return
	 */
	public int insertMerchantsQualification(QualificationBean qualificationBean) {
		return merchantsDao.insertMerchantsQualification(qualificationBean);
	}

	/**
	 * 修改商家资质
	 * 
	 * @param merchantsLabelBean
	 * @return
	 */
	public int updateMerchantsQualification(QualificationBean qualificationBean) {
		return merchantsDao.updateMerchantsQualification(qualificationBean);
	}

	/**
	 * 删除商家资质
	 * 
	 * @param merchantsLabelBean
	 * @return
	 */
	public int deleteMerchantsQualification(QualificationBean qualificationBean) {
		return merchantsDao.deleteMerchantsQualification(qualificationBean);
	}

	/**
	 * 获得所有商家资质
	 * 
	 * @param merchantsLabelBean
	 * @return
	 */
	public List<QualificationBean> getAllMerchantsQualification(QualificationBean qualificationBean) {
		return merchantsDao.getAllMerchantsQualification(qualificationBean);
	}

	/**
	 * 添加商家分类
	 * 
	 * @param merchantsLabelBean
	 * @return
	 */
	public int insertMerchantsLabel(MerchantsLabelBean merchantsLabelBean) {
		return merchantsDao.insertMerchantsLabel(merchantsLabelBean);
	}

	/**
	 * 修改商家分类
	 * 
	 * @param merchantsLabelBean
	 * @return
	 */
	public int updateMerchantsLabel(MerchantsLabelBean merchantsLabelBean) {
		return merchantsDao.updateMerchantsLabel(merchantsLabelBean);
	}

	/**
	 * 删除商家分类
	 * 
	 * @param merchantsLabelBean
	 * @return
	 */
	public int deleteMerchantsLabel(MerchantsLabelBean merchantsLabelBean) {
		return merchantsDao.deleteMerchantsLabel(merchantsLabelBean);
	}

	/**
	 * 获得所有商家标签
	 * 
	 * @param merchantsLabelBean
	 * @return
	 */
	public List<MerchantsLabelBean> getAllMerchantsLabel(MerchantsLabelBean merchantsLabelBean) {
		return merchantsDao.getAllMerchantsLabel(merchantsLabelBean);
	}

	/**
	 * 默认店铺
	 * 
	 * @param merchantsBean
	 * @return
	 */
	public MerchantsBean getMerchantsDefault(MerchantsBean merchantsBean) {
		return merchantsDao.getMerchantsDefault(merchantsBean);
	}

	/**
	 * 获得店铺的客户
	 * 
	 * @return
	 */
	public List<MemberBean> getBusinessMembers(MemberBean memberBean, PageBean pageBean) {
		return merchantsDao.getBusinessMembers(memberBean, pageBean);
	}

	/**
	 * 设置店铺列表默认
	 * 
	 * @return
	 */
	public int setMerchantsDefault(MerchantsBean merchantsBean) {
		return merchantsDao.setMerchantsDefault(merchantsBean);
	}

	/**
	 * 获得账号的店铺列表
	 * 
	 * @return
	 */
	public List<MerchantsBean> getMerchantsByAccount(MerchantsBean merchantsBean, PageBean pageBean) {
		return merchantsDao.getMerchantsByAccount(merchantsBean, pageBean);
	}

	/**
	 * 单个商家信息详情
	 * 
	 * @param merchantsBean
	 * @return
	 */
	public MerchantsBean getOneMerchantsDetail(MerchantsBean merchantsBean) {
		MerchantsBean merchantsBean2=merchantsDao.getOneMerchantsDetail(merchantsBean);
		if(merchantsBean2!=null){
			List<MerchantsImgBean> merchantsImgBeans=
					merchantsDao.getMerchantsImgs(new MerchantsImgBean().
							setMerchants_id(merchantsBean2.getMerchants_id()+""));
			merchantsBean2.setMerchantsImgBeans(merchantsImgBeans);
			String a[] =new String[1];
			String label_ids=merchantsBean2.getLabel_ids();
			Map<String, Object> params = new HashMap<String, Object>(2);
			params.put("ids", label_ids!=null&&label_ids.length()>0?label_ids.split(","):a);
			
			List<MerchantsLabelBean> merchantsLabelBeans=merchantsDao.getLabels(params);
			merchantsBean2.setMerchantsLabelBeans(merchantsLabelBeans);
		}
		return merchantsBean2;
	}

	/**
	 * 所有商家信息
	 * 
	 * @param merchantsBean
	 * @return
	 */
	public List<MerchantsBean> getAllMerchants(MerchantsBean merchantsBean, PageBean pageBean) {
		return merchantsDao.getAllMerchants(merchantsBean, pageBean);
	}

	/**
	 * 所有商家信息
	 * 
	 * @param merchantsBean
	 * @return
	 */
	public List<String> getMerchantsQrCode(MerchantsBean merchantsBean) {
		return merchantsDao.getMerchantsQrCode(merchantsBean);
	}

	/**
	 * 所有商家信息 不分页
	 * 
	 * @param merchantsBean
	 * @return
	 */
	public List<MerchantsBean> getAllMerchantsNopage(MerchantsBean merchantsBean) {
		return merchantsDao.getAllMerchantsNopage(merchantsBean);
	}
	/**
	 * 所有商家信息账号信息 不分页
	 * 
	 * @param merchantsBean
	 * @return
	 */
	public List<MerchantsBean> getAllMerchantsAccountNopage(MerchantsAccountBean merchantsAccountBean) {
		return merchantsDao.getAllMerchantsAccountNopage(merchantsAccountBean);
	}

	
	/**
	 * 添加商家详情
	 * 
	 * @param merchantsBean
	 * @return
	 * @throws Exception
	 */
	public int insertMerchantDetail(HttpServletRequest request, MerchantsBean merchantsBean) throws Exception {
		int num = merchantsDao.insertMerchantDetail(merchantsBean);
		if (num > 0 && "3".equals(merchantsBean.getMerchants_type())) {
			//String qrcode_img = TimeUtils.getCurrentTime("yyyyMMddHHmmss") + "1.png";
			
//			HostBean hostBean=othersServiceC.getHost(new HostBean().setHost_type("1"));
//
//			
//			boolean is_success = QRCodeUtils.CreateQrcode(request, "/images/qrcode/business/" + qrcode_img,
//					hostBean.getHost_url() + "weixinhome/index.html#/saoma?" + "business_id=" + merchantsBean.getMerchants_id());
//			if (!is_success) {
//				throw new Exception("二维码生成失败");
//			}
//
//			is_success = QRCodeUtils.composeQrcode(
//					merchantsBean.getMerchants_name(),
//					request.getSession().getServletContext().getRealPath("/") + merchantsBean.getMerchants_img(),
//					request.getSession().getServletContext().getRealPath("/") + "/images/qrcode/business/" + qrcode_img,
//					request.getSession().getServletContext().getRealPath("/") + "/images/qrcode/business/"
//							+ qrcode_img);
//			if (!is_success) {
//				throw new Exception("二维码合成失败");
//			}

			WXSetingBean wxSetingBean = othersServiceC.getWXSeting(new WXSetingBean().setWeixin_type("1"));

			String access_token = WXUtils.getAccess_token(wxSetingBean.getWeixin_appid(), wxSetingBean.getWeixin_secret());

			String result = WXUtils.getQrcode(access_token,
					"wx_type=merchants&business_id="+ merchantsBean.getMerchants_id());
			
			String qrcode_img = TimeUtils.getCurrentTime("yyyyMMddHHmmss") + "1.png";
			
			boolean is_success=HttpUtils.downloadFile(result,request.getSession().getServletContext()
					.getRealPath("/")+"/images/qrcode/business_goods/"+qrcode_img);
			if(!is_success){
				throw new Exception("二维码生成失败");
			}
			
			is_success=QRCodeUtils.composeQrcode(merchantsBean.getMerchants_name(),request.getSession().getServletContext()
					.getRealPath("/")+merchantsBean.getMerchants_img(), request.getSession().getServletContext()
					.getRealPath("/")+"/images/qrcode/business_goods/"+qrcode_img, request.getSession().getServletContext()
					.getRealPath("/")+"/images/qrcode/business_goods/"+qrcode_img);
			if(!is_success){
				throw new Exception("二维码合成失败");
			}
			
			int k = merchantsDao
					.updateMerchantDetail(new MerchantsBean().setMerchants_id(merchantsBean.getMerchants_id())
							.setQrcode_img("/images/qrcode/business_goods/"+qrcode_img));
			if (k <= 0) {
				throw new Exception("二维码更新失败");
			}
		}
		return num;
	}

	/**
	 * 修改商家详情
	 * 
	 * @param merchantsBean
	 * @return
	 */
	public int updateMerchantDetail(MerchantsBean merchantsBean) {
		if("0".equals(merchantsBean.getMerchants_state())){//商家下架 需要给所有商品下架
			goodsService.updateGoodsStateByMerchants(new GoodsBean().setMerchants_id(merchantsBean.getMerchants_id()+""));
		}
		return merchantsDao.updateMerchantDetail(merchantsBean);
	}

	/**
	 * 删除商家详情
	 * @param merchantsBean
	 * @return
	 */
	public int deleteMerchantDetail(MerchantsBean merchantsBean){
		return merchantsDao.deleteMerchantDetail(merchantsBean);
	}
		
}
