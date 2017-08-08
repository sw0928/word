package tst.project.service.interfaces;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.corba.se.impl.protocol.giopmsgheaders.MessageBase;

import tst.project.bean.HostBean;
import tst.project.bean.finance.CashApplyBean;
import tst.project.bean.member.BillBean;
import tst.project.bean.member.IntegralBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.member.MessageBean;
import tst.project.bean.merchants.MerchantsBean;
import tst.project.bean.order.OrderProfitBean;
import tst.project.bean.others.CodeBean;
import tst.project.bean.others.PercentBean;
import tst.project.dao.interfaces.MemberDao;
import tst.project.page.PageBean;
import tst.project.utils.HBRUtils;
import tst.project.utils.MD5Util;
import tst.project.utils.XmlUtils;

@Service
@Transactional(rollbackFor = Exception.class)
public class MemberService {
	@Resource
	MemberDao memberDao;

	@Resource
	CodeService codeService;

	@Resource
	OthersService othersService;
	

	
	/**
	 * 删除用户消息
	 * @return
	 */
	public int deleteMemberMsg(MessageBean messageBase){
		return memberDao.deleteMemberMsg(messageBase);
	}
	
	/**
	 * 用户消息
	 * @param memberBean
	 * @return
	 */
	public List<MessageBase> getMemberMsgs(MessageBean messageBase,PageBean pageBean){
		return memberDao.getMemberMsgs(messageBase, pageBean);
	}
	
	/**
	 * 修改自己的用户余额支付密码
	 * @return
	 */
	public int updateMemberBalancePassword(MemberBean memberBean){
		return memberDao.updateMemberBalancePassword(memberBean);
	}
	
	/**
	 * 修改自己的用户信用支付密码
	 * @return
	 */
	public int updateMemberTrustPassword(MemberBean memberBean){
		return memberDao.updateMemberTrustPassword(memberBean);
	}
	
	/**
	 * 修改用户的归属
	 * @return
	 */
	public int updateMemberAttach(MemberBean memberBean){
		return memberDao.updateMemberAttach(memberBean);
	}
	
	/**
	 * 添加用户积分详情
	 * @param integralBean
	 * @return
	 */
	public int insertMemberIntegral(IntegralBean integralBean){
		return memberDao.insertMemberIntegral(integralBean);
	}

	/**
	 * 用户余额记录
	 * @param billBean
	 * @param pageBean
	 * @return
	 */
	public List<BillBean> getMemberBalanceRecord(BillBean billBean,PageBean pageBean){
		return memberDao.getMemberBalanceRecord(billBean, pageBean);
	}
	

	/**
	 * 用户余额记录
	 * @param billBean
	 * @param pageBean
	 * @return
	 */
	public List<BillBean> getMemberTrustRecord(BillBean billBean,PageBean pageBean){
		return memberDao.getMemberTrustRecord(billBean, pageBean);
	}
	
	/**
	 * 用户积分使用情况
	 * @return
	 */
	public List<IntegralBean> getMemberIntegral(IntegralBean integralBean,PageBean pageBean){
		return memberDao.getMemberIntegral(integralBean, pageBean);
	}
	
	/**
	 * 申请提现列表
	 * @return
	 */
	public List<CashApplyBean> getApplyCashs(CashApplyBean cashApplyBean,PageBean pageBean){
		return memberDao.getApplyCashs(cashApplyBean,pageBean);
	}
	
	/**
	 * 最近的一次申请提现
	 * @return
	 */
	public CashApplyBean getLastApplyCash(CashApplyBean cashApplyBean){
		return memberDao.getLastApplyCash(cashApplyBean);
	}
	/**
	 * 申请提现
	 * @return
	 */
	public int applyCash(CashApplyBean cashApplyBean){
		return memberDao.applyCash(cashApplyBean);
	}
	
	/**
	 * 用户订单分成收益
	 * @param orderProfitBean
	 * @return
	 */
	public List<OrderProfitBean> getOrderPorfit(OrderProfitBean orderProfitBean){
		return memberDao.getOrderPorfit(orderProfitBean);
	}
	/**
	 * 更新用户归属 家纺
	 * 
	 * @return
	 */
	public int updateMemberBusiness(MemberBean memberBean) {
		return memberDao.updateMemberBusiness(memberBean);
	}

	/**
	 * 验证用户token
	 * 
	 * @param memberBean
	 * @return
	 */
	public MemberBean verificationToken(MemberBean memberBean) {
		return memberDao.verificationToken(memberBean);
	}

	/**
	 * 绑定手机号
	 * 
	 * @param memberBean
	 * @param codeBean
	 * @return
	 */
	public int memberBindMobile(MemberBean memberBean, CodeBean codeBean) {
		try {
			if(memberBean.getPassword()!=null&&!memberBean.getPassword().equals("")){
				memberBean.setPassword(MD5Util.md5Encode(memberBean.getPassword()));				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}

		int num = memberDao.memberBindMobile(memberBean);
		if (num > 0) {
			codeService.deleteCodeByMobileAndCode(codeBean);
		}
		return num;
	}

	/**
	 * 绑定手机号
	 * 
	 * @param memberBean
	 * @param codeBean
	 * @return
	 * @throws Exception
	 */
	public int memberBindMobileZSSG(MemberBean memberBean, CodeBean codeBean) throws Exception {
		memberBean.setPassword(MD5Util.md5EncodeOrigin(memberBean.getPassword()));
		UUID uuid = UUID.randomUUID();
		int num = wxPubMemberRegisterZSSG(memberBean.setMember_token(uuid.toString()));
		if (num > 0){
			codeService.deleteCodeByMobileAndCode(codeBean);
		}
//		
//		memberBean.setPassword(MD5Util.md5EncodeOrigin(memberBean.getPassword()));
//		int num = memberDao.memberBindMobileZSSG(memberBean);
//		if (num > 0) {
//			codeService.deleteCodeByMobileAndCode(codeBean);
//		} else {
//			throw new Exception("绑定失败");
//		}
		return num;
	}
	/**
	 * 绑定手机号
	 * 
	 * @param memberBean
	 * @param codeBean
	 * @return
	 * @throws Exception
	 */
	public int memberBindMobileZSSG1(MemberBean memberBean, CodeBean codeBean) throws Exception {
		int num =memberDao.memberBindMobileZSSG(memberBean);
		if (num > 0){
			codeService.deleteCodeByMobileAndCode(codeBean);
		}
		return num;
	}
	/**
	 * 忘记密码
	 * 
	 * @return
	 */
	public int memberForgetPassword(MemberBean memberBean, CodeBean codeBean) {
		try {
			memberBean.setPassword(MD5Util.md5Encode(memberBean.getPassword()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		int num = memberDao.memberForgetPassword(memberBean);
		if (num > 0) {
			codeService.deleteCodeByMobileAndCode(codeBean);
		}
		return num;
	}

	/**
	 * 用户注册
	 * 
	 * @return
	 * @throws Exception 
	 */
	public int memberRegister(MemberBean memberBean, CodeBean codeBean) throws Exception {
		try {
			memberBean.setPassword(MD5Util.md5Encode(memberBean.getPassword()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		PercentBean percentBean=othersService.getPercent(new PercentBean().setPercent_type("register"));
		if(percentBean!=null){
			memberBean.setIntegral(percentBean.getPercent_value());
			HostBean hostBean=othersService.getHost(new HostBean().setHost_type("1"));
			if("hbr".equals(hostBean.getCompany_name())){
				String xml = HBRUtils.modifyIntegral(memberBean.getMember_code(),"register"+ memberBean.getMember_account(),
						percentBean.getPercent_value() + "", "1","22");
				String error = XmlUtils.getValueByTagName(XmlUtils.getDocumentByXml(xml), "error");
				if (error != null && !"".equals(error)) {
					throw new Exception(error);
				}
			}
		}
		
		int num = memberDao.memberRegister(memberBean);
		if (num > 0) {
			codeService.deleteCodeByMobileAndCode(codeBean);
		}
		return num;
	}

	/**
	 * 通过手机号 获得用户信息
	 * 
	 * @param memberBean
	 * @return
	 */
	public MemberBean getMemberByMobile(MemberBean memberBean) {
		return memberDao.getMemberByMobile(memberBean);
	}

	/**
	 * 通过手机号 获得用户信息
	 * 
	 * @param memberBean
	 * @return
	 */
	public MemberBean getMemberByMobileZSSG(MemberBean memberBean) {
		return memberDao.getMemberByMobileZSSG(memberBean);
	}

	/**
	 * 通过用户邀请码 获得用户信息
	 * 
	 * @param memberBean
	 * @return
	 */
	public MemberBean getMemberByInvitation_code(MemberBean memberBean) {
		return memberDao.getMemberByInvitation_code(memberBean);
	}

	/**
	 * 通过用户邀请码 获得用户信息
	 * 
	 * @param memberBean
	 * @return
	 */
	public MemberBean getMemberByInvitation_codeZSSG(MemberBean memberBean) {
		return memberDao.getMemberByInvitation_codeZSSG(memberBean);
	}


	/**
	 * 通过用户ID 获得用户信息
	 * 
	 * @param memberBean
	 * @return
	 */
	public MemberBean getMemberByID(MemberBean memberBean) {
		return memberDao.getMemberByID(memberBean);
	}

	/**
	 * 通过用户ID 获得用户信息
	 * 
	 * @param memberBean
	 * @return
	 */
	public MemberBean getMemberByIDZSSG(MemberBean memberBean) {
		return memberDao.getMemberByIDZSSG(memberBean);
	}
	/**
	 * 通过用户ID 获得用户信息
	 * 
	 * @param memberBean
	 * @return
	 */
	public MemberBean getMemberByOpenidZSSG(MemberBean memberBean){
		return memberDao.getMemberByOpenidZSSG(memberBean);
	}

	/**
	 * 用户登录
	 * 
	 * @param memberBean
	 * @return
	 * @throws Exception
	 */
	public MemberBean memberLogin(MemberBean memberBean) {
		MemberBean memberBean1 = null;
		try {
			memberBean.setPassword(MD5Util.md5Encode(memberBean.getPassword()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		int num = memberDao.updateMemberToken(memberBean);
		if (num > 0) {
			memberBean1 = memberDao.memberLogin(memberBean);
		} else {
			return null;
		}
		return memberBean1;
	}

	/**
	 * 验证用户token
	 * 
	 * @param memberBean
	 * @return
	 */
	public MemberBean verificationTokenZSSG(MemberBean memberBean) {
		return memberDao.verificationTokenZSSG(memberBean);
	}

	/**
	 * 微信公众号登录
	 * 
	 * @return
	 */
	public MemberBean wxPubMemberLoginZSSG(MemberBean memberBean) {
		return memberDao.wxPubMemberLoginZSSG(memberBean);
	}

	/**
	 * 微信公众号登录
	 * 
	 * @return
	 */
	public MemberBean wxPubMemberLogin(MemberBean memberBean) {
		return memberDao.wxPubMemberLogin(memberBean);
	}

	/**
	 * 微信公众号注册
	 * 
	 * @param memberBean
	 * @return
	 */
	public int wxPubMemberRegister(MemberBean memberBean) {
		return memberDao.wxPubMemberRegister(memberBean);
	}

	/**
	 * 微信公众号 更新
	 * @param memberBean
	 * @return
	 */
	public int wxPubMemberUpdate(MemberBean memberBean){
		return memberDao.wxPubMemberUpdate(memberBean);
	}
	/**
	 * 微信公众号注册
	 * 
	 * @param memberBean
	 * @return
	 */
	public int wxPubMemberRegisterZSSG(MemberBean memberBean) {
		return memberDao.wxPubMemberRegisterZSSG(memberBean);
	}

	/**
	 * 修改用户信息
	 * 
	 * @param memberBean
	 * @return
	 */
	public int updateMemberDetail(MemberBean memberBean) {
		return memberDao.updateMemberDetail(memberBean);
	}

	/**
	 * 完善资料变vip
	 * @return
	 */
	public int updateMemberDetailVip(MemberBean memberBean){
		return memberDao.updateMemberDetailVip(memberBean);
	}
	/**
	 * 修改用户信息
	 * 
	 * @param memberBean
	 * @return
	 */
	public int updateMemberDetailZSSG(MemberBean memberBean) {
		return memberDao.updateMemberDetailZSSG(memberBean);
	}

}
