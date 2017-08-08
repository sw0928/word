package tst.project.dao.controller;

import java.util.List;
import java.util.Map;

import tst.project.bean.member.MemberBean;
import tst.project.bean.merchants.MerchantsAccountBean;
import tst.project.bean.merchants.MerchantsBean;
import tst.project.bean.merchants.MerchantsDescImgBean;
import tst.project.bean.merchants.MerchantsImgBean;
import tst.project.bean.merchants.MerchantsLabelBean;
import tst.project.bean.merchants.QualificationBean;
import tst.project.page.PageBean;

public interface MerchantsDao {
	
	public int insertMerchantsDescImg(MerchantsDescImgBean merchantsDescImgBean);
	
	public int updateMerchantsDescImg(MerchantsDescImgBean merchantsDescImgBean);
	
	public int deleteMerchantsDescImg(MerchantsDescImgBean merchantsDescImgBean);
	
	public List<MerchantsDescImgBean> getMerchantsDescImgs(MerchantsDescImgBean merchantsDescImgBean);
	
	public int deleteMerchants(MerchantsBean merchantsBean);
	
	/**
	 * 店铺粉丝
	 * @return
	 */
	public List<MemberBean> getBusinessFollower(MerchantsAccountBean merchantsAccountBean,PageBean pageBean);
	
	/**
	 * 店铺的推广员详情
	 * @param merchantsAccountBean
	 * @return
	 */
	public List<MerchantsAccountBean> getBusinessExtensionDetail(MerchantsAccountBean merchantsAccountBean);
	
	/**
	 * 店铺的推广员列表
	 * @param merchantsAccountBean
	 * @return
	 */
	public List<MerchantsAccountBean> getBusinessExtensions(MerchantsAccountBean merchantsAccountBean,PageBean pageBean);
	
	/**
	 * 删除商家账号
	 * @param merchantsAccountBean
	 * @return
	 */
	public int deleteMerchantsAccount(MerchantsAccountBean merchantsAccountBean);
	
	/**
	 * 删除商家关联账号
	 * @return
	 */
	public int deleteMerchantsRelationAccount(MerchantsAccountBean merchantsAccountBean);
	
	
	/**
	 * 设置账号默认
	 * @param merchantsAccountBean
	 * @return
	 */
	public int setMerchantsAccountDefault(MerchantsAccountBean merchantsAccountBean);
	/**
	 * 修改商家账号密码
	 * @param merchantsAccountBean
	 * @return
	 */
	public int updateMerchantsAccount(MerchantsAccountBean merchantsAccountBean);
	
	/**
	 * 修改商家账号详情
	 * @param merchantsAccountBean
	 * @return
	 */
	public int updateMerchantsAccountDetail(MerchantsAccountBean merchantsAccountBean);
	
	
	/**
	 * 添加商家账号
	 * @param merchantsAccountBean
	 * @return
	 */
	public int insertMerchantsAccount(MerchantsAccountBean merchantsAccountBean);

	
	/**
	 * 账号和商家关联起来
	 * @param merchantsAccountBean
	 * @return
	 */
	public int insertMerchantsRelationAccount(MerchantsAccountBean merchantsAccountBean);
	/**
	 * 获得商家的账号信息
	 * @return
	 */
	public List<MerchantsAccountBean> getMerchantsAccounts(MerchantsAccountBean merchantsAccountBean);
	

	/**
	 * 获得商家单个账号信息
	 * @return
	 */
	public MerchantsAccountBean getOneMerchantsAccount(MerchantsAccountBean merchantsAccountBean);
	
	/**
	 * 获得商家单个账号信息
	 * @return
	 */
	public MerchantsAccountBean getOneMerchantsAccountByID(MerchantsAccountBean merchantsAccountBean);
	
	/**
	 * 审核用户申请
	 * @return
	 */
	public int auditingApplyMerchants(MerchantsBean merchantsBean);
	
	/**
	 * 单个标签资质
	 * @param qualificationBean
	 * @return
	 */
	public QualificationBean getOneMerchantsLabelQualification(QualificationBean qualificationBean);
	/**
	 *  删除标签资质
	 * @param qualificationBean
	 * @return
	 */
	public int deleteLabelQualification(QualificationBean qualificationBean);
	
	/**
	 *  添加标签资质
	 * @param qualificationBean
	 * @return
	 */
	public int insertLabelQualification(QualificationBean qualificationBean);
	
	/**
	 * 获得所有标签资质
	 * @param qualificationBean
	 * @return
	 */
	public List<QualificationBean> getMerchantsLabelQualifications(QualificationBean qualificationBean);
	
	
	/**
	 * 添加商家资质
	 * @param merchantsLabelBean
	 * @return
	 */
	public int insertMerchantsQualification(QualificationBean qualificationBean);
	
	/**
	 * 修改商家资质
	 * @param merchantsLabelBean
	 * @return
	 */
	public int updateMerchantsQualification(QualificationBean qualificationBean);
	
	/**
	 * 删除商家资质
	 * @param merchantsLabelBean
	 * @return
	 */
	public int deleteMerchantsQualification(QualificationBean qualificationBean);
	
	/**
	 * 获得所有商家资质
	 * @param merchantsLabelBean
	 * @return
	 */
	public List<QualificationBean> getAllMerchantsQualification(QualificationBean qualificationBean);
	
	/**
	 * 添加商家分类
	 * @param merchantsLabelBean
	 * @return
	 */
	public int insertMerchantsLabel(MerchantsLabelBean merchantsLabelBean);
	
	/**
	 * 修改商家分类
	 * @param merchantsLabelBean
	 * @return
	 */
	public int updateMerchantsLabel(MerchantsLabelBean merchantsLabelBean);
	
	/**
	 * 删除商家分类
	 * @param merchantsLabelBean
	 * @return
	 */
	public int deleteMerchantsLabel(MerchantsLabelBean merchantsLabelBean);
	
	/**
	 * 获得所有商家标签
	 * @param merchantsLabelBean
	 * @return
	 */
	public List<MerchantsLabelBean> getAllMerchantsLabel(MerchantsLabelBean merchantsLabelBean);
	
	
	/**
	 * 默认店铺
	 * @param merchantsBean
	 * @return
	 */
	public MerchantsBean getMerchantsDefault(MerchantsBean merchantsBean);
	
	/**
	 * 获得店铺的客户
	 * @return
	 */
	public List<MemberBean> getBusinessMembers(MemberBean memberBean,PageBean pageBean);
	
	/**
	 * 设置店铺列表默认
	 * @return
	 */
	public int setMerchantsDefault(MerchantsBean merchantsBean);
	
	/**
	 * 获得账号的店铺列表
	 * @return
	 */
	public List<MerchantsBean> getMerchantsByAccount(MerchantsBean merchantsBean,PageBean pageBean);
	
	/**
	 * 单个商家信息详情
	 * @param merchantsBean
	 * @return
	 */
	public MerchantsBean getOneMerchantsDetail(MerchantsBean merchantsBean);
	
	/**
	 * 商家的资质图片
	 * @param merchantsImgBean
	 * @return
	 */
	public List<MerchantsImgBean> getMerchantsImgs(MerchantsImgBean merchantsImgBean);
	
	public List<MerchantsLabelBean> getLabels(Map<String, Object> params);
	/**
	 * 所有商家信息
	 * @param merchantsBean
	 * @return
	 */
	public List<MerchantsBean> getAllMerchants(MerchantsBean merchantsBean,PageBean pageBean);
	
	/**
	 * 所有商家信息
	 * @param merchantsBean
	 * @return
	 */
	public List<String> getMerchantsQrCode(MerchantsBean merchantsBean);
	/**
	 * 所有商家信息 不分页
	 * @param merchantsBean
	 * @return
	 */
	public List<MerchantsBean> getAllMerchantsNopage(MerchantsBean merchantsBean);
	/**
	 * 所有商家信息账号信息 不分页
	 * 
	 * @param merchantsBean
	 * @return
	 */
	public List<MerchantsBean> getAllMerchantsAccountNopage(MerchantsAccountBean merchantsAccountBean);
	/**
	 * 添加商家详情
	 * @param merchantsBean
	 * @return
	 */
	public int insertMerchantDetail(MerchantsBean merchantsBean);
	
	/**
	 * 修改商家详情
	 * @param merchantsBean
	 * @return
	 */
	public int updateMerchantDetail(MerchantsBean merchantsBean);
	
	/**
	 * 删除商家详情
	 * @param merchantsBean
	 * @return
	 */
	public int deleteMerchantDetail(MerchantsBean merchantsBean);
}
