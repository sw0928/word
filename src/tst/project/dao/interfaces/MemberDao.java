package tst.project.dao.interfaces;

import java.util.List;

import com.sun.corba.se.impl.protocol.giopmsgheaders.MessageBase;

import tst.project.bean.finance.CashApplyBean;
import tst.project.bean.member.BillBean;
import tst.project.bean.member.IntegralBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.member.MessageBean;
import tst.project.bean.order.OrderProfitBean;
import tst.project.page.PageBean;

public interface MemberDao {

	/**
	 * 删除用户消息
	 * @return
	 */
	public int deleteMemberMsg(MessageBean messageBase);
	/**
	 * 用户消息
	 * @param memberBean
	 * @return
	 */
	public List<MessageBase> getMemberMsgs(MessageBean messageBean,PageBean pageBean);
	
	/**
	 * 修改自己的用户余额支付密码
	 * @return
	 */
	public int updateMemberBalancePassword(MemberBean memberBean);
	
	/**
	 * 修改自己的用户信用支付密码
	 * @return
	 */
	public int updateMemberTrustPassword(MemberBean memberBean);
	
	/**
	 * 修改用户的归属
	 * @return
	 */
	public int updateMemberAttach(MemberBean memberBean);
	
	/**
	 * 添加用户积分详情
	 * @param integralBean
	 * @return
	 */
	public int insertMemberIntegral(IntegralBean integralBean);
	
	/**
	 * 用户余额记录
	 * @param billBean
	 * @param pageBean
	 * @return
	 */
	public List<BillBean> getMemberBalanceRecord(BillBean billBean,PageBean pageBean);
	
	/**
	 * 用户余额记录
	 * @param billBean
	 * @param pageBean
	 * @return
	 */
	public List<BillBean> getMemberTrustRecord(BillBean billBean,PageBean pageBean);
	/**
	 * 用户积分使用情况
	 * @return
	 */
	public List<IntegralBean> getMemberIntegral(IntegralBean integralBean,PageBean pageBean);
	
	/**
	 * 申请提现列表
	 * @return
	 */
	public List<CashApplyBean> getApplyCashs(CashApplyBean cashApplyBean,PageBean pageBean);
	
	/**
	 * 最近的一次申请提现
	 * @return
	 */
	public CashApplyBean getLastApplyCash(CashApplyBean cashApplyBean);
	
	/**
	 * 申请提现
	 * @return
	 */
	public int applyCash(CashApplyBean cashApplyBean);
	
	/**
	 * 用户订单分成收益
	 * @param orderProfitBean
	 * @return
	 */
	public List<OrderProfitBean> getOrderPorfit(OrderProfitBean orderProfitBean);

	/**
	 * 更新用户归属 家纺
	 * @return
	 */
	public int updateMemberBusiness(MemberBean memberBean);
	/**
	 * 验证用户token
	 * @param memberBean
	 * @return
	 */
	public MemberBean verificationToken(MemberBean memberBean);
	
	/**
	 * 验证用户token
	 * @param memberBean
	 * @return
	 */
	public MemberBean verificationTokenZSSG(MemberBean memberBean);
	
	/**
	 * 绑定手机号
	 * @param memberBean
	 * @param codeBean
	 * @return
	 */
	public int memberBindMobile(MemberBean memberBean);
	
	/**
	 * 绑定手机号
	 * @param memberBean
	 * @param codeBean
	 * @return
	 */
	public int memberBindMobileZSSG(MemberBean memberBean);
	
	/**
	 * 忘记密码
	 * @return
	 */
	public int memberForgetPassword(MemberBean memberBean);
	
	/**
	 * 用户注册
	 * @return
	 */
	public int memberRegister(MemberBean memberBean);
		
	/**
	 * 通过手机号 获得用户信息
	 * 
	 * @param memberBean
	 * @return
	 */
	public MemberBean getMemberByMobile(MemberBean memberBean);
	/**
	 * 通过手机号 获得用户信息
	 * 
	 * @param memberBean
	 * @return
	 */
	public MemberBean getMemberByMobileZSSG(MemberBean memberBean) ;
	/**
	 * 通过用户ID 获得用户信息
	 * 
	 * @param memberBean
	 * @return
	 */
	public MemberBean getMemberByID(MemberBean memberBean) ;

	/**
	 * 通过用户ID 获得用户信息
	 * 
	 * @param memberBean
	 * @return
	 */
	public MemberBean getMemberByIDZSSG(MemberBean memberBean) ;
	
	/**
	 * 通过用户ID 获得用户信息
	 * 
	 * @param memberBean
	 * @return
	 */
	public MemberBean getMemberByOpenidZSSG(MemberBean memberBean);
	
	/**
	 * 通过用户邀请码 获得用户信息
	 * 
	 * @param memberBean
	 * @return
	 */
	public MemberBean getMemberByInvitation_code(MemberBean memberBean);
	
	/**
	 * 通过用户邀请码 获得用户信息
	 * 
	 * @param memberBean
	 * @return
	 */
	public MemberBean getMemberByInvitation_codeZSSG(MemberBean memberBean) ;
	/**
	 * 用户登录
	 * @param memberBean
	 * @return
	 */
	public MemberBean memberLogin(MemberBean memberBean);
	
	/**
	 * 用户登录需要更新token
	 * @param memberBean
	 * @return
	 */
	public int updateMemberToken(MemberBean memberBean);
	
	
	/**
	 * 微信公众号登录
	 * @return
	 */
	public MemberBean wxPubMemberLogin(MemberBean memberBean);
	
	/**
	 * 微信公众号登录
	 * @return
	 */
	public MemberBean wxPubMemberLoginZSSG(MemberBean memberBean);
	
	/**
	 * 微信公众号注册
	 * @param memberBean
	 * @return
	 */
	public int wxPubMemberRegister(MemberBean memberBean);
	/**
	 * 微信公众号 更新
	 * @param memberBean
	 * @return
	 */
	public int wxPubMemberUpdate(MemberBean memberBean);
	/**
	 * 微信公众号注册
	 * @param memberBean
	 * @return
	 */
	public int wxPubMemberRegisterZSSG(MemberBean memberBean);
	/**
	 * 修改用户信息
	 * @param memberBean
	 * @return
	 */
	public int updateMemberDetail(MemberBean memberBean);
	/**
	 * 完善资料变vip
	 * @return
	 */
	public int updateMemberDetailVip(MemberBean memberBean);
	
	/**
	 * 修改用户信息
	 * @param memberBean
	 * @return
	 */
	public int updateMemberDetailZSSG(MemberBean memberBean);
}
