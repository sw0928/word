package tst.project.webservice.interfaces;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.w3c.dom.Document;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import tst.project.bean.HostBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.others.CodeBean;
import tst.project.bean.others.HtmlBean;
import tst.project.bean.others.MsgBean;
import tst.project.bean.others.PercentBean;
import tst.project.bean.others.VerificationBean;
import tst.project.bean.wx.WXBean;
import tst.project.bean.wx.WXSetingBean;
import tst.project.service.interfaces.CodeService;
import tst.project.service.interfaces.MemberService;
import tst.project.service.interfaces.OthersService;
import tst.project.utils.CreateRandom;
import tst.project.utils.JDBCUtils;
import tst.project.utils.Sha1Utils;
import tst.project.utils.TimeUtils;
import tst.project.utils.VerificationCodeUtils;
import tst.project.utils.WXUtils;
import tst.project.utils.XmlUtils;
import tst.project.webservice.controller.BaseController;

@Controller
@RequestMapping("/othersInterfaces.api")
public class OthersInterfaces extends BaseController {
	@Resource
	MemberService memberService;

	@Resource
	CodeService codeService;

	@Resource
	OthersService othersService;

	/**
	 * 接受微信带参数的回调
	 * 
	 * @param percentBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "test1")
	public void test1(HttpServletRequest request, HttpServletResponse response) throws Exception {
		WriteObject(response, WXUtils.wxMD5Sign("wx0bb583c2e89057d8", "4c6e02c0bc38b3557a27e552789c30e1", "order_id=10"));
	}

	/**
	 * 接受微信带参数的回调
	 * 
	 * @param percentBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "receiveWxQrcode")
	public void receiveWxQrcode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// String signature=request.getParameter("signature");
		// String timestamp=request.getParameter("timestamp");
		// String nonce=request.getParameter("nonce");
		String echostr = request.getParameter("echostr");

		// String
		// wait_sign="nonce="+nonce+"&timestamp="+timestamp+"&token=jiafang";
		// String sign=Sha1Utils.sha1(wait_sign);
		// writeHtml(request,"/html/others/protocols.html",
		// signature+"==="+sign);
		// if(signature.equals(sign)){
		// WriteOnlyMsg(response, echostr);
		// }
		//
		WriteOnlyMsg(response, "");// 一定要先返回空字符串 要不然微信5秒会断开

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(request.getInputStream());
		// String a=getXmlString(doc);
		String FromUserName = XmlUtils.getValueByTagName(doc, "FromUserName");
		String MsgType = XmlUtils.getValueByTagName(doc, "MsgType");
		String Event = XmlUtils.getValueByTagName(doc, "Event");
		String EventKey = XmlUtils.getValueByTagName(doc, "EventKey");// 自定义参数

		writeHtml(request, "/html/others/protocols.html", FromUserName + "======" + EventKey, null);
		if (EventKey != null && EventKey.length() > 0) {
			String[] params = EventKey.split("&");
			String[] wx_type = params[0].split("=");
			if ("merchants_extend".equals(wx_type[1])) {// 推广员二维码
				String[] business_id = params[1].split("=");
				String[] merchants_account_id = params[2].split("=");

				MemberBean memberBean2 = memberService
						.wxPubMemberLogin(new MemberBean().setWx_pub_openid(FromUserName));
				if (memberBean2 == null) {
					memberService.wxPubMemberRegister(new MemberBean().setWx_pub_openid(FromUserName));
					memberBean2 = memberService.wxPubMemberLogin(new MemberBean().setWx_pub_openid(FromUserName));
				}

				if (memberBean2.getBusiness_id() == null || memberBean2.getBusiness_id().equals("-1")) {
					int num = memberService.updateMemberBusiness(memberBean2.setBusiness_id(business_id[1])
							.setMerchants_account_id(merchants_account_id[1]));
					if (num <= 0) {
						WriteError(response, "查询失败");
						return;
					}
				}

				HostBean hostBean = othersService.getHost(new HostBean().setHost_type("1"));

				//String url = hostBean.getHost_url() + "weixinhome/index.html#/saoma?" + "business_id=" + business_id[1]+ "&merchants_account_id=" + merchants_account_id[1];
				String url =hostBean.getHost_url()+"weixinhome/index.html";
				String msg = "欢迎关注微馨家!快到商店逛逛吧!"+ url;
				WriteOnlyMsg(response,
						"<xml>" + "<ToUserName><![CDATA[" + FromUserName + "]]></ToUserName>"
								+ "<FromUserName><![CDATA[WEEHOME-VIP]]></FromUserName>" + "<CreateTime>"
								+ System.currentTimeMillis() + "</CreateTime>" + "<MsgType><![CDATA[text]]></MsgType>"
								+ "<Content><![CDATA[" + msg + "]]></Content></xml>");
			} else if ("business".equals(wx_type[1])) {
				String[] business_id = params[1].split("=");
				String[] merchants_id = params[2].split("=");
				String[] goods_id = params[3].split("=");

				MemberBean memberBean2 = memberService
						.wxPubMemberLogin(new MemberBean().setWx_pub_openid(FromUserName));
				if (memberBean2 == null) {
					memberService.wxPubMemberRegister(new MemberBean().setWx_pub_openid(FromUserName));
					memberBean2 = memberService.wxPubMemberLogin(new MemberBean().setWx_pub_openid(FromUserName));
				}

				if (memberBean2.getBusiness_id() == null || memberBean2.getBusiness_id().equals("-1")) {
					int num = memberService.updateMemberBusiness(memberBean2.setBusiness_id(business_id[1]));
					if (num <= 0) {
						WriteError(response, "查询失败");
						return;
					}
				}

				HostBean hostBean = othersService.getHost(new HostBean().setHost_type("1"));

				//String url = hostBean.getHost_url() + "weixinhome/index.html#/shop_xq?" + "list=" + goods_id[1]+ "&dp_id=" + merchants_id[1] + "&business_id=" + business_id[1];
				String url =hostBean.getHost_url()+"weixinhome/index.html";
				String msg = "欢迎关注微馨家!快到商店逛逛吧!" + url;
				WriteOnlyMsg(response,
						"<xml>" + "<ToUserName><![CDATA[" + FromUserName + "]]></ToUserName>"
								+ "<FromUserName><![CDATA[WEEHOME-VIP]]></FromUserName>" + "<CreateTime>"
								+ System.currentTimeMillis() + "</CreateTime>" + "<MsgType><![CDATA[text]]></MsgType>"
								+ "<Content><![CDATA[" + msg + "]]></Content></xml>");
			} else if ("merchants".equals(wx_type[1])) {
				HostBean hostBean = othersService.getHost(new HostBean().setHost_type("1"));

				String[] business_id = params[1].split("=");

				MemberBean memberBean2 = memberService
						.wxPubMemberLogin(new MemberBean().setWx_pub_openid(FromUserName));
				if (memberBean2 == null) {
					memberService.wxPubMemberRegister(new MemberBean().setWx_pub_openid(FromUserName));
					memberBean2 = memberService.wxPubMemberLogin(new MemberBean().setWx_pub_openid(FromUserName));
				}

				if (memberBean2.getBusiness_id() == null || memberBean2.getBusiness_id().equals("-1")) {
					int num = memberService.updateMemberBusiness(memberBean2.setBusiness_id(business_id[1]));
					if (num <= 0) {
						WriteError(response, "查询失败");
						return;
					}
				}

				//String url = hostBean.getHost_url() + "weixinhome/index.html#/saoma?" + "business_id=" + business_id[1];
				String url =hostBean.getHost_url()+"weixinhome/index.html";
				String msg = "欢迎关注微馨家!快到商店逛逛吧!"+url;
				WriteOnlyMsg(response,
						"<xml>" + "<ToUserName><![CDATA[" + FromUserName + "]]></ToUserName>"
								+ "<FromUserName><![CDATA[WEEHOME-VIP]]></FromUserName>" + "<CreateTime>"
								+ System.currentTimeMillis() + "</CreateTime>" + "<MsgType><![CDATA[text]]></MsgType>"
								+ "<Content><![CDATA[" + msg + "]]></Content></xml>");
			}
		}

	}

	/**
	 * 获得微信带参数二维码
	 * 
	 * @param percentBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getWxQrcode", method = RequestMethod.POST)
	public void getWxQrcode(HttpServletRequest request, HttpServletResponse response) throws Exception {

		WXSetingBean wxSetingBean = othersService.getWXSeting(new WXSetingBean().setWeixin_type("1"));

		String access_token = WXUtils.getAccess_token(wxSetingBean.getWeixin_appid(), wxSetingBean.getWeixin_secret());

		String result = WXUtils.getQrcode(access_token,
				"wx_type=business&business_id=101&merchants_id=39&goods_id=1083");

		WriteObject(response, result);
	}

	/**
	 * 获得微信分享权限
	 * 
	 * @param percentBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getWxAutho", method = RequestMethod.POST)
	public void getWxAutho(PercentBean percentBean, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WXSetingBean wxSetingBean = othersService.getWXSeting(new WXSetingBean().setWeixin_type("2"));
		String url = request.getParameter("url");
		String access_token = WXUtils.getAccess_token(wxSetingBean.getWeixin_appid(), wxSetingBean.getWeixin_secret());
		String jsapi_ticket = WXUtils.getJsapi(access_token);
		String nonceStr = CreateRandom.createRandom(false, 16);
		long timestamp = Long.parseLong(String.valueOf(System.currentTimeMillis()).toString().substring(0, 10));
		WXBean wxBean = new WXBean();
		wxBean.setJsapi_ticket(jsapi_ticket);
		wxBean.setAppId(wxSetingBean.getWeixin_appid());
		wxBean.setNonceStr(nonceStr);
		wxBean.setTimestamp(timestamp + "");
		String sign = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + nonceStr + "&timestamp=" + timestamp + "&url="
				+ url;
		// Map<String, Object> map = new HashMap<String, Object>();
		// map.put("jsapi_ticket", jsapi_ticket);
		// map.put("timestamp", timestamp);
		// map.put("url", url);
		wxBean.setSignature(Sha1Utils.sha1(sign));
		WriteObject(response, wxBean);
	}
	
	@RequestMapping(params = "getHost", method = RequestMethod.POST)
	public void getHost(PercentBean percentBean, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WriteObject(response, othersService.getHost(new HostBean().setHost_type("1")));
	}
	
	@RequestMapping(params = "getPercent", method = RequestMethod.POST)
	public void getPercent(PercentBean percentBean, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WriteObject(response, othersService.getPercent(percentBean));
	}
	@RequestMapping(params = "getPercents", method = RequestMethod.POST)
	public void getPercents(PercentBean percentBean, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WriteObject(response, othersService.getPercents(percentBean));
	}
	
	@RequestMapping(params = "getSystemMsgs", method = RequestMethod.POST)
	public void getSystemMsgs(MemberBean memberBean, MsgBean masgBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		MemberBean memberBean2 = memberService.verificationToken(memberBean);
		if (memberBean2 == null) {
			WritePending(response, "token failed");
			return;
		}

		List<MsgBean> msgBeans = new ArrayList<MsgBean>();
		if ("1".equals(memberBean2.getIs_remind_group())) {
			List<MsgBean> msgBeans2 = othersService.getGroupSystemMsgs(masgBean);
			if (msgBeans2 != null) {
				msgBeans.addAll(msgBeans2);
			}
		}

		if ("1".equals(memberBean2.getIs_remind_pre())) {
			List<MsgBean> msgBeans2 = othersService.getPreSystemMsgs(masgBean);
			if (msgBeans2 != null) {
				msgBeans.addAll(msgBeans2);
			}
		}

		WriteObject(response, msgBeans);
	}

	/**
	 * 获得html内容
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getHtmls", method = RequestMethod.POST)
	public void getHtmls(HtmlBean htmlBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
		WriteObject(response, othersService.getHtmls(htmlBean.setParent_id("-1"),request.getParameter("level")));
	}
	/**
	 * 获得html内容
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getHtmlByParent", method = RequestMethod.POST)
	public void getHtmlByParent(HtmlBean htmlBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
		WriteObject(response, othersService.getHtmls(htmlBean,request.getParameter("level")));
	}
	
	/**
	 * 获得html内容
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getHtmlDesc", method = RequestMethod.POST)
	public void getHtmlDesc(CodeBean codeBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url=request.getParameter("url");
		HtmlBean htmlBean=othersService
					.getHtml(new HtmlBean().setHtml_code(url));
		if(htmlBean!=null){
			url=htmlBean.getHtml_url();
		}
		String desc=readHtml(request, url);
		
		int start=desc.indexOf("<tst>");
		int end=desc.indexOf("</tst>");

		if(start>0&&end>0){
			desc=desc.substring(start+5,end);
		}
		
		WriteOnlyMsg(response, desc);
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "sendCode", method = RequestMethod.POST)
	public void sendCode(CodeBean codeBean, HttpServletRequest request, HttpServletResponse response) throws Exception {

		String code = CreateRandom.createRandom(true, 6);

		if (codeService.getCodeBeanByMobile(
				codeBean.setCreate_time(TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss"))) != null) {
			WriteError(response, "上一个验证码还未过期");
			return;
		}
		VerificationBean verificationBean = codeService.getVerificationSetting(new VerificationBean());

		CodeBean codeBean1 = VerificationCodeUtils.sendCode(verificationBean,
				codeBean.setCode(code).setCode_desc(verificationBean.getVerification_content().replace("tst_code", code)));
		// .setCode_desc("您的验证码是：【"+code+"】,请不要把验证码泄露给其他人,验证码有效期为10分钟，中视尚购感谢您的支持！"));
		// .setCode_desc("【"+Host.company+"】您的验证码:"+code+",请不要把验证码泄露给其他人,验证码有效期为"+Host.effective_time+"分钟"));
		if (codeBean1 != null) {
			int num = codeService.insertCode(codeBean1);
			if (num > 0) {
				WriteMsg(response, codeBean1.getCode());
			} else {
				WriteError(response, "发送失败");
			}
		} else {
			WriteError(response, "发送失败");
		}
	}
}
