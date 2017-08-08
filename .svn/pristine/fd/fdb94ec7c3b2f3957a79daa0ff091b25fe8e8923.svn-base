package tst.project.webservice.interfaces;

import java.util.UUID;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.w3c.dom.Document;

import com.google.gson.Gson;
import com.google.zxing.qrcode.encoder.QRCode;
import com.sun.corba.se.impl.protocol.giopmsgheaders.MessageBase;
import com.sun.swing.internal.plaf.basic.resources.basic;

import jxl.demo.XML;
import tst.project.bean.HostBean;
import tst.project.bean.finance.CashApplyBean;
import tst.project.bean.goods.GoodsBean;
import tst.project.bean.hx.HXSettingBean;
import tst.project.bean.member.BankBean;
import tst.project.bean.member.BillBean;
import tst.project.bean.member.IntegralBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.member.MessageBean;
import tst.project.bean.member.ShareBean;
import tst.project.bean.merchants.MerchantsBean;
import tst.project.bean.order.OrderProfitBean;
import tst.project.bean.others.CodeBean;
import tst.project.bean.others.PercentBean;
import tst.project.bean.others.QrcodeBean;
import tst.project.bean.wx.WXPubBean;
import tst.project.bean.wx.WXSetingBean;
import tst.project.page.PageBean;
import tst.project.service.interfaces.BankService;
import tst.project.service.interfaces.CodeService;
import tst.project.service.interfaces.MemberService;
import tst.project.service.interfaces.OthersService;
import tst.project.utils.CreateRandom;
import tst.project.utils.HBRUtils;
import tst.project.utils.HuanXinUtils;
import tst.project.utils.MD5Util;
import tst.project.utils.QRCodeUtils;
import tst.project.utils.TimeUtils;
import tst.project.utils.WXUtils;
import tst.project.utils.XmlUtils;
import tst.project.webservice.controller.BaseController;

@Controller
@RequestMapping("/memberInterfaces.api")
public class MemberInterfaces extends BaseController {
	@Resource
	MemberService memberService;

	@Resource
	CodeService codeService;

	@Resource
	OthersService othersService;

	@Resource
	BankService bankService;
	/**
	 * 删除系统给用户的消息列表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteMemberMsg", method = RequestMethod.POST)
	public void deleteMemberMsg(MemberBean memberBean, MessageBean messageBean,PageBean pageBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberBean memberBean2 = memberService.verificationToken(memberBean);
		if (memberBean2 == null) {
			WritePending(response, "token failed");
			return;
		}
		
		int num=memberService.deleteMemberMsg(messageBean);
		if(num>0){
			WriteMsg(response, "删除成功");
		}else{
			WriteError(response, "删除失败");
		}
	}
	
	/**
	 * 获得系统给用户的消息列表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getMemberMsgs", method = RequestMethod.POST)
	public void getMemberMsgs(MemberBean memberBean, MessageBean messageBean,PageBean pageBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberBean memberBean2 = memberService.verificationToken(memberBean);
		if (memberBean2 == null) {
			WritePending(response, "token failed");
			return;
		}

		WriteObject(response, memberService.getMemberMsgs(messageBean, pageBean),pageBean.getTotal());
	}


	/**
	 * 用户积分
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getUserIntegral", method = RequestMethod.POST)
	public void getUserIntegral(MemberBean memberBean, ShareBean shareBean, GoodsBean goodsBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberBean memberBean2 = memberService.verificationToken(memberBean);
		if (memberBean2 == null) {
			WritePending(response, "token failed");
			return;
		}

	
		WriteMsg(response, memberBean2.getIntegral());
	}

	/**
	 * 用户余额列表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getMemberBalanceRecord", method = RequestMethod.POST)
	public void getMemberBalanceRecord(MemberBean memberBean, BillBean billBean, PageBean pageBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}

		WriteObject(response, memberService.getMemberBalanceRecord(billBean, pageBean), pageBean.getTotal());
	}

	/**
	 * 用户信用额度
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getMemberTrustRecord", method = RequestMethod.POST)
	public void getMemberTrustRecord(MemberBean memberBean, BillBean billBean, PageBean pageBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}

		WriteObject(response, memberService.getMemberTrustRecord(billBean, pageBean), pageBean.getTotal());
	}

	/**
	 * 修改余额支付密码
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateMemberBalancePassword", method = RequestMethod.POST)
	public void updateMemberBalancePassword(MemberBean memberBean, CodeBean codeBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		MemberBean memberBean1 = memberService.verificationToken(memberBean);
		if (memberBean1 == null) {
			WritePending(response, "token failed");
			return;
		}

		if (codeService.getCodeBeanByMobileAndCode(
				codeBean.setMobile(memberBean.getMember_account()).setCode_type("balance_passwrod")
						.setCreate_time(TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss"))) == null) {
			WriteError(response, "此验证码已过期");
			return;
		}

		String pass = MD5Util.md5Encode(memberBean.getBalance_password());

		int num = memberService.updateMemberBalancePassword(memberBean.setBalance_password(pass));
		if (num > 0) {
			WriteMsg(response, "修改成功");
		} else {
			WriteError(response, "修改失败");
		}
	}

	/**
	 * 修改信用支付密码
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateMemberTrustPassword", method = RequestMethod.POST)
	public void updateMemberTrustPassword(MemberBean memberBean, CodeBean codeBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		MemberBean memberBean1 = memberService.verificationToken(memberBean);
		if (memberBean1 == null) {
			WritePending(response, "token failed");
			return;
		}

		if (codeService.getCodeBeanByMobileAndCode(
				codeBean.setMobile(memberBean.getMember_account()).setCode_type("trust_passwrod")
						.setCreate_time(TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss"))) == null) {
			WriteError(response, "此验证码已过期");
			return;
		}

		String pass = MD5Util.md5Encode(memberBean.getTrust_password());

		int num = memberService.updateMemberTrustPassword(memberBean.setTrust_password(pass));
		if (num > 0) {
			WriteMsg(response, "修改成功");
		} else {
			WriteError(response, "修改失败");
		}
	}

	/**
	 * 修改用户的归属
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateMemberAttach", method = RequestMethod.POST)
	public void updateMemberAttach(MemberBean memberBean, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		MemberBean memberBean1 = memberService.verificationToken(memberBean);
		if (memberBean1 == null) {
			WritePending(response, "token failed");
			return;
		}

		String attach_id = request.getParameter("attach_id");
		if (attach_id == null || attach_id.equals("")) {
			WriteError(response, "参数错误");
			return;
		}

		if (attach_id.equals(memberBean.getMember_id() + "")) {
			WriteError(response, "不可更改自己为归属");
			return;
		}

		MemberBean memberBean2 = memberService.getMemberByID(new MemberBean().setMember_id(Integer.valueOf(attach_id)));
		if (memberBean2 == null) {
			WriteError(response, "该会员不存在");
			return;
		}

		if (memberBean1.getInvitation_code().equals(memberBean2.getFill_invitation_code())) {
			WriteError(response, "不可让下级会员,做为自己的归属");
			return;
		}

		int num = memberService
				.updateMemberAttach(memberBean.setFill_invitation_code(memberBean2.getInvitation_code()));
		if (num > 0) {
			WriteMsg(response, "绑定成功");
		} else {
			WriteError(response, "绑定失败");
		}
	}

	/**
	 * 用户积分列表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getMemberIntegral", method = RequestMethod.POST)
	public void getMemberIntegral(MemberBean memberBean, IntegralBean integralBean, PageBean pageBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}

		WriteObject(response, memberService.getMemberIntegral(integralBean, pageBean), pageBean.getTotal());
	}

	/**
	 * 申请提现列表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getApplyCashs", method = RequestMethod.POST)
	public void getApplyCashs(MemberBean memberBean, CashApplyBean cashApplyBean, PageBean pageBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}
		WriteObject(response,
				memberService.getApplyCashs(cashApplyBean.setMerchants_id(memberBean.getMember_id() + ""), pageBean),
				pageBean.getTotal());
	}

	/**
	 * 申请提现
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "applyCash", method = RequestMethod.POST)
	public void applyCash(MemberBean memberBean, BankBean bankBean, CodeBean codeBean, CashApplyBean cashApplyBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		MemberBean memberBean2 = memberService.verificationToken(memberBean);
		if (memberBean2 == null) {
			WritePending(response, "token failed");
			return;
		}
		if (codeBean.getCode() != null) {
			if (codeService.getCodeBeanByMobileAndCode(
					codeBean.setMobile(memberBean2.getMember_account()).setCode_type("apply_cash")
							.setCreate_time(TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss"))) == null) {
				WriteError(response, "此验证码已过期");
				return;
			}

			if (memberBean2.getBalance_password() == null || "".equals(memberBean2.getBalance_password())) {
				WriteError(response, "请先设置支付密码");
				return;
			}

			if (!memberBean2.getBalance_password().equals(MD5Util.md5Encode(memberBean.getBalance_password()))) {
				WriteError(response, "支付密码错误");
				return;
			}
		}

		if (bankBean.getBank_id() != 0) {
			BankBean bankBean2 = bankService.getMemberDefaultBank(bankBean);
			if (bankBean2 == null) {
				WriteError(response, "银行卡不存在");
				return;
			}
			cashApplyBean.setMerchants_id(memberBean.getMember_id() + "").setCash_type("member")
					.setBrank_code(bankBean2.getBank_code()).setBrank_name(bankBean2.getBank_name())
					.setBrank_open_mobile(bankBean2.getBank_mobile()).setBrank_open_usr(bankBean.getBank_user_name())
					.setBrank_open_name(bankBean.getBank_open_name());
		}

		HostBean hostBean = othersService.getHost(new HostBean().setHost_type("1"));
		if ("fuzhuang".equals(hostBean.getCompany_name())) {
			CashApplyBean cashApplyBean2 = memberService
					.getLastApplyCash(cashApplyBean.setMerchants_id(memberBean.getMember_id() + ""));
			if (cashApplyBean2 != null) {
				if (TimeUtils.getDayCompareDate(TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss"),
						cashApplyBean2.getCreate_time(), "yyyy-MM-dd HH:mm:ss") <= 7) {
					WriteError(response, "7天内不可以重复申请");
					return;
				}
			}
		}

		int num = memberService.applyCash(cashApplyBean.setMerchants_id(memberBean.getMember_id() + ""));
		if (num > 0) {
			WriteMsg(response, "申请成功");
		} else {
			WriteError(response, "申请失败");
		}
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getOrderPorfit", method = RequestMethod.POST)
	public void getOrderPorfit(MemberBean memberBean, OrderProfitBean orderProfitBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}

		WriteObject(response, memberService.getOrderPorfit(orderProfitBean));
	}

	/**
	 * 会员申请（家纺）
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "applyMember", method = RequestMethod.POST)
	public void applyMember(MemberBean memberBean, CodeBean codeBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		MemberBean memberBean2 = memberService.verificationToken(memberBean);
		if (memberBean2 == null) {
			WritePending(response, "token failed");
			return;
		}

		if (codeService
				.getCodeBeanByMobileAndCode(codeBean.setMobile(memberBean.getPhone()).setCode_type("apply_member")
						.setCreate_time(TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss"))) == null) {
			WriteError(response, "此验证码已过期");
			return;
		}

		HostBean hostBean = othersService.getHost(new HostBean().setHost_type("1"));
		if (hostBean != null && hostBean.getCompany_name() != null && "hbr".equals(hostBean.getCompany_name())) {
			String xml = "";
			xml = HBRUtils.upInsider(memberBean.setMember_code(memberBean2.getMember_code()));
			// WriteOnlyMsg(response, xml);
		}

		int num = memberService.updateMemberDetailVip(memberBean);
		if (num > 0) {
			WriteMsg(response, "修改成功");
		} else {
			WriteError(response, "修改失败");
		}
	}


	/**
	 * 获得用户信息
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getMemberDetail", method = RequestMethod.POST)
	public void getMemberDetail(MemberBean memberBean, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}
		WriteObject(response, memberService.getMemberByID(memberBean));
	}

	/**
	 * 获得用户信息
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getMemberDetailZSSG", method = RequestMethod.POST)
	public void getMemberDetailZSSG(MemberBean memberBean, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (memberService.verificationTokenZSSG(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}

		WriteObject(response, memberService.getMemberByIDZSSG(memberBean));
	}

	/**
	 * 绑定手机号
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "memberBindMobile", method = RequestMethod.POST)
	public void memberBindMobile(MemberBean memberBean, CodeBean codeBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}

		if (codeService.getCodeBeanByMobileAndCode(codeBean.setMobile(memberBean.getMember_account())
				.setCode_type("bind_mobile").setCreate_time(TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss"))) == null) {
			WriteError(response, "此验证码已过期");
			return;
		}

		MemberBean memberBean2 = memberService.getMemberByMobile(memberBean);
		if (memberBean2 != null) {
			WriteError(response, "该手机号已注册过");
			return;
		}

		int num = memberService.memberBindMobile(memberBean, codeBean);
		if (num > 0) {

			WriteMsg(response, "绑定成功");
		} else {
			WriteError(response, "绑定失败");
		}
	}

	/**
	 * 绑定手机号
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "memberBindMobileZSSG", method = RequestMethod.POST)
	public void memberBindMobileZSSG(MemberBean memberBean, CodeBean codeBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// if(memberService.verificationTokenZSSG(memberBean)==null){
		// WritePending(response, "token failed");
		// return;
		// }

		if (codeService.getCodeBeanByMobileAndCode(codeBean.setMobile(memberBean.getMember_account())
				.setCode_type("bind_mobile").setCreate_time(TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss"))) == null) {
			WriteError(response, "此验证码已过期");
			return;
		}

		MemberBean memberBean2 = memberService.getMemberByMobileZSSG(memberBean);
		if (memberBean2 != null && memberBean2.getWx_pub_openid() != null
				&& !"".equals(memberBean2.getWx_pub_openid())) {
			WriteError(response, "该手机号已注册过");
			return;
		}

		MemberBean memberBean3 = memberService.getMemberByOpenidZSSG(memberBean);
		if (memberBean3 != null && memberBean3.getMobile_phone() != null && !"".equals(memberBean3.getMobile_phone())) {
			WriteError(response, "该微信号已绑定过手机");
			return;
		}

		int num = 0;
		if (memberBean2 == null && memberBean3 == null) {
			memberBean.setNick_name(memberBean.getNick_name() == null || "".equals(memberBean.getNick_name()) ? "..."
					: memberBean.getNick_name().replaceAll("[\ue000-\uefff]", "")
							.replaceAll("[\ud83c\udc00-\ud83c\udfff]", "").replaceAll("[\ud83d\udc00-\ud83d\udfff]", "")
							.replaceAll("[\u2600-\u27ff]", ""));
			memberBean.setUser_name(memberBean.getUser_name() == null || "".equals(memberBean.getUser_name()) ? "..."
					: memberBean.getUser_name().replaceAll("[\ue000-\uefff]", "")
							.replaceAll("[\ud83c\udc00-\ud83c\udfff]", "").replaceAll("[\ud83d\udc00-\ud83d\udfff]", "")
							.replaceAll("[\u2600-\u27ff]", ""));
			num = memberService.memberBindMobileZSSG(memberBean, codeBean);
		} else {
			num = memberService.memberBindMobileZSSG1(memberBean, codeBean);
		}

		if (num > 0) {
			WriteObject(response, memberService.wxPubMemberLoginZSSG(memberBean));
		} else {
			WriteError(response, "绑定失败");
		}
	}

	/**
	 * 忘记密码(手机号密码注册)
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "memberForgetPassword", method = RequestMethod.POST)
	public void memberForgetPassword(MemberBean memberBean, CodeBean codeBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		MemberBean memberBean2=memberService.getMemberByMobile(memberBean);
		if(memberBean2==null){
			WriteError(response, "亲！您还未注册哦!");
			return;
		}
		
		if(MD5Util.md5Encode(memberBean.getPassword()).equals(memberBean2.getPassword())){
			WriteError(response, "更改的密码!不可以和最近的密码相同哦！");
			return;
		}
		
		if (codeService.getCodeBeanByMobileAndCode(codeBean.setMobile(memberBean.getMember_account()).setCode_type("forget_passwrod")
						.setCreate_time(TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss"))) == null) {
			WriteError(response, "此验证码已过期");
			return;
		}

		int num = memberService.memberForgetPassword(memberBean, codeBean);
		if (num > 0) {
			WriteMsg(response, "修改成功");
		} else {
			WriteError(response, "修改失败");
		}
	}

	/**
	 * 用户注册
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "memberRegister", method = RequestMethod.POST)
	public void memberRegister(MemberBean memberBean, CodeBean codeBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (codeService.getCodeBeanByMobileAndCode(
				codeBean.setMobile(memberBean.getMember_account()).setCode_type("member_register")
						.setCreate_time(TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss"))) == null) {
			WriteError(response, "此验证码已过期");
			return;
		}

		if (memberService.getMemberByMobile(memberBean) != null) {
			WriteError(response, "该账号已注册过");
			return;
		}
		memberBean.setPhone(memberBean.getMember_account());
		memberBean.setIs_vip("0");

		String pass = MD5Util.md5Encode(memberBean.getPassword());
		String t = CreateRandom.createRandom(true, 6);

		HostBean hostBean = othersService.getHost(new HostBean().setHost_type("1"));

		memberBean.setNick_name(hostBean.getCompany_name() + CreateRandom.createRandom(true, 6));

		String qrcode_img = TimeUtils.getCurrentTime("yyyyMMddHHmmss") + ".png";

		String invitation_code = UUID.randomUUID().toString();

		QrcodeBean qrcodeBean = othersService.getQrcodeSetting(new QrcodeBean().setQrcode_type("member"));

		if (qrcodeBean != null) {
			boolean is_success = QRCodeUtils.CreateQrcode(request, "/images/qrcode/business_goods/" + qrcode_img,
					hostBean.getHost_url() + qrcodeBean.getQrcode_desc() + invitation_code);
			if (!is_success) {
				WriteError(response, "二维码注册失败!");
				return;
			}
		}

		if (hostBean != null && hostBean.getCompany_name() != null && "hbr".equals(hostBean.getCompany_name())) {
			String xml = "";
			xml = HBRUtils.registerMember(memberBean);

			String error = XmlUtils.getValueByTagName(XmlUtils.getDocumentByXml(xml), "error");
			if (error != null && !"".equals(error)) {
				//<result class="object"><e class="object"><success>系统中已存在该手机号:15026591112,注册的会员卡号信息,会员卡号为:15026591112,会员卡级别:普卡,但缺少必要的会员信息(手机号),请及时维护!</success></e></result>
				//<result class="object"><e class="object"><success>该手机号:15026592821,已注册会员信息,会员卡号为:22220101,会员用户姓名:101,会员卡级别:白金卡</success></e></result>
				//<result class="object"><e class="object"><success>该手机号:15026592837,已注册会员信息,会员卡号为:15026592837,会员用户姓名:娌堜匠,会员卡级别:普卡</success></e></result>
				//<result class="object"><e class="object"><success>该手机号:15026591113,已注册会员信息,会员卡号为:15026591113,会员用户姓名:,会员卡级别:普卡</success></e></result>
				//<result class="object"><e class="object"><success>注册成功！会员卡号:15026591114,储值卡卡号:15026591114</success></e></result>
				WriteError(response, error);
				return;
//				int index =error.indexOf("该手机号已绑定多个会员卡号");
//				if(index>=0){
//					String arr[] = error.substring("该手机号已绑定多个会员卡号     ".length(), error.length()).split(",");
//					String a[]=arr[0].split(":");
//					memberBean.setMember_code(a[0]);
//				}else{
//					WriteError(response, error);
//					return;
//				}
			} else {
				String success = XmlUtils.getValueByTagName(XmlUtils.getDocumentByXml(xml), "success");
				String arr[] = success.split(",");
				int index = arr[0].indexOf("注册成功！会员卡号:");
				if (index >= 0) {// 新会员注册
					String member_code = arr[0].substring("注册成功！会员卡号:".length(), arr[0].length());
					String stored_code = arr[1].substring("储值卡卡号:".length(), arr[1].length());
					memberBean.setMember_code(member_code);
					memberBean.setStored_code(stored_code);
					memberBean.setVip_level("vip_common");
					memberBean.setIs_vip("0");
				}else if(arr[0].indexOf("系统中已存在该手机号:")>=0){
					String member_code = arr[2].substring("会员卡号为:".length(), arr[2].length());
					memberBean.setMember_code(member_code);
					memberBean.setIs_vip("0");
					
					String vip_level=arr[3].substring("会员卡级别:".length(), arr[3].length());
					if("普卡".equals(vip_level)){
						vip_level="vip_common";
					}else if("银卡".equals(vip_level)){
						vip_level="vip_silver";
					}else if("金卡".equals(vip_level)){
						vip_level="vip_golden";
					}else if("白金卡".equals(vip_level)){
						vip_level="vip_platinum";
					}else if("至尊卡".equals(vip_level)){
						vip_level="vip_extreme";
					}else{
						vip_level="vip_common";
					}
					
					memberBean.setVip_level(vip_level);
				}else if(arr[0].indexOf("该手机号:")>=0){
					String member_code = arr[2].substring("会员卡号为:".length(), arr[2].length());
					memberBean.setReal_name(arr[3].substring("会员用户姓名:".length(), arr[3].length()));
					memberBean.setNick_name(arr[3].substring("会员用户姓名:".length(), arr[3].length()));
					memberBean.setPhone(memberBean.getMember_account());
					memberBean.setIs_vip("0");
					memberBean.setMember_code(member_code);
					
					String vip_level=arr[4].substring("会员卡级别:".length(), arr[4].length());
					if("普卡".equals(vip_level)){
						vip_level="vip_common";
					}else if("银卡".equals(vip_level)){
						vip_level="vip_silver";
					}else if("金卡".equals(vip_level)){
						vip_level="vip_golden";
					}else if("白金卡".equals(vip_level)){
						vip_level="vip_platinum";
					}else if("至尊卡".equals(vip_level)){
						vip_level="vip_extreme";
					}else{
						vip_level="vip_common";
					}

					memberBean.setVip_level(vip_level);
				} else {	
					WriteError(response, error);
					return;
				}
			}
		}
		
		HXSettingBean hxSettingBean=othersService.getHXSetting(new HXSettingBean());
		if (HuanXinUtils.registerOneUser(hxSettingBean,memberBean.getMember_account() + t, pass,
				memberBean.getMember_account() + t)) {

			int num = memberService.memberRegister(memberBean.setHx_account(memberBean.getMember_account() + t)
					.setHx_pass(pass).setHx_nick_name(memberBean.getMember_account() + t)
					.setInvitation_code(invitation_code).setQrcode_img("/images/qrcode/business_goods/" + qrcode_img),
					codeBean);

			if (num > 0) {
				MemberBean memberBean2 = memberService.getMemberByID(memberBean);
				WriteObject(response, memberBean2);
			} else {
				WriteError(response, "注册失败");
			}
		} else {
			WriteError(response, "环信聊天异常");
		}
	}

	/**
	 * 手机号登录
	 * 
	 * @param memberBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "memberLogin", method = RequestMethod.POST)
	public void memberLogin(MemberBean memberBean, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UUID uuid = UUID.randomUUID();
		MemberBean memberBean1 = memberService.memberLogin(memberBean.setMember_token(uuid.toString()));
		if (memberBean1 != null) {
			WriteObject(response, memberBean1);
		} else {
			WriteError(response, "用户名或者密码错误");
		}
	}

	/**
	 * 微信公众号登录
	 * 
	 * @param memberBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "wxPubMemberLogin", method = RequestMethod.POST)
	public void wxPubMemberLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String code = request.getParameter("code");
		String fill_invitation_code = request.getParameter("fill_invitation_code");
		WXSetingBean wxSetingBean = othersService.getWXSeting(new WXSetingBean().setWeixin_type("1"));

		WXPubBean wxPubBean = WXUtils.getWXUserInfo(wxSetingBean.getWeixin_appid(), wxSetingBean.getWeixin_secret(),
				code, request);
		if (wxPubBean == null) {
			WriteError(response, "微信code有误");
			return;
		}
		UUID uuid = UUID.randomUUID();
		MemberBean memberBean = new MemberBean().setWx_pub_openid(wxPubBean.getOpenid())
				.setNick_name(wxPubBean.getNickname()).setHead_path(wxPubBean.getHeadimgurl())
				.setMember_token(uuid.toString()).setFill_invitation_code(fill_invitation_code);

		MemberBean memberBean1 = memberService.wxPubMemberLogin(memberBean);
		if (memberBean1 != null) {
			int num = memberService.wxPubMemberUpdate(memberBean.setMember_token(uuid.toString()));
			MemberBean memberBean2 = memberService.wxPubMemberLogin(memberBean1);
			WriteObject(response, memberBean2);
		} else {

			QrcodeBean qrcodeBean = othersService.getQrcodeSetting(new QrcodeBean().setQrcode_type("member"));
			HostBean hostBean = othersService.getHost(new HostBean().setHost_type("1"));

			// boolean is_success=QRCodeUtils.CreateQrcode(request,
			// "/images/qrcode/business_goods/"+qrcode_img,
			// hostBean.getHost_url()+"hbrH5/register.html?"
			// + "fill_invitation_code="+invitation_code);
			String invitation_code = UUID.randomUUID().toString();
			String qrcode_img = TimeUtils.getCurrentTime("yyyyMMddHHmmss") + ".png";
			if (qrcodeBean != null) {

				boolean is_success = QRCodeUtils.CreateQrcode(request, "/images/qrcode/business_goods/" + qrcode_img,
						hostBean.getHost_url() + qrcodeBean.getQrcode_desc() + invitation_code);

				if (!is_success) {
					WriteError(response, "二维码注册失败!");
					return;
				}
			}
			int num = memberService.wxPubMemberRegister(memberBean.setMember_token(uuid.toString())
					.setInvitation_code(invitation_code).setQrcode_img("/images/qrcode/business_goods/" + qrcode_img));
			if (num > 0) {
				WriteObject(response, memberService.wxPubMemberLogin(memberBean.setMember_token(uuid.toString())));
			} else {
				WriteError(response, "注册失败");
			}
		}
	}

	/**
	 * 微信公众号登录
	 * 
	 * @param memberBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "wxPubMemberLoginZSSG", method = RequestMethod.POST)
	public void wxPubMemberLoginZSSG(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String code = request.getParameter("code");
		String fill_invitation_code = request.getParameter("fill_invitation_code");
		WXSetingBean wxSetingBean = othersService.getWXSeting(new WXSetingBean().setWeixin_type("1"));
		WXPubBean wxPubBean = WXUtils.getWXUserInfo(wxSetingBean.getWeixin_appid(), wxSetingBean.getWeixin_secret(),
				code, request);
		if (wxPubBean == null) {
			WriteError(response, "微信code有误");
			return;
		}
		UUID uuid = UUID.randomUUID();
		MemberBean memberBean = new MemberBean().setWx_pub_openid(wxPubBean.getOpenid())
				.setNick_name(wxPubBean.getNickname()).setUser_name(wxPubBean.getNickname())
				.setHead_path(wxPubBean.getHeadimgurl()).setHeadimg(wxPubBean.getHeadimgurl())
				.setMember_token(uuid.toString()).setFill_invitation_code(fill_invitation_code);
		MemberBean memberBean1 = memberService.wxPubMemberLoginZSSG(memberBean);
		if (memberBean1 != null) {
			WriteObject(response, memberBean1);
		} else {
			WriteObject(response, memberBean);
			// int
			// num=memberService.wxPubMemberRegisterZSSG(memberBean.setMember_token(uuid.toString()));
			// if(num>0){
			// WriteObject(response,
			// memberService.wxPubMemberLoginZSSG(memberBean.
			// setMember_token(uuid.toString())));
			// }else{
			// WriteError(response, "注册失败");
			// }
		}
	}

	/**
	 * 修改用户信息
	 * 
	 * @param memberBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateMemberDetail", method = RequestMethod.POST)
	public void updateMemberDetail(MemberBean memberBean, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}

		int num = memberService.updateMemberDetail(memberBean);
		if (num > 0) {
			WriteMsg(response, "修改成功");
		} else {
			WriteError(response, "修改失败");
		}
	}

	/**
	 * 上传商品图片
	 * 
	 * @param merchantsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "uploadMemberImg")
	public void uploadMemberImg(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String json = getObjectJson(request, "/images/member/");

		if (json.equals("-1")) {
			WriteError(response, "文件不可为空");
		} else if (json.equals("-2")) {
			WriteError(response, "上传失败");
		} else {
			MemberBean memberBean = new Gson().fromJson(json, MemberBean.class);
			if (memberService.verificationToken(memberBean) == null) {
				WritePending(response, "token failed");
				return;
			}

			int num = memberService.updateMemberDetail(memberBean);
			if (num > 0) {
				WriteMsg(response, memberBean.getHead_path());
			} else {
				WriteError(response, "入库失败");
			}
		}
	}
}
