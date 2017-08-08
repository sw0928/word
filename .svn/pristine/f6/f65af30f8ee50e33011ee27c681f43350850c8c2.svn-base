package tst.project.webservice.interfaces;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.swing.internal.plaf.metal.resources.metal;

import tst.project.bean.goods.GoodsBean;
import tst.project.bean.goods.GoodsClassBean;
import tst.project.bean.home.ActivityBean;
import tst.project.bean.home.HomeGoodsBean;
import tst.project.bean.home.LabelBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.member.ShareBean;
import tst.project.page.PageBean;
import tst.project.service.interfaces.GoodsServiceI;
import tst.project.service.interfaces.HBRService;
import tst.project.service.interfaces.MemberService;
import tst.project.utils.HBRUtils;
import tst.project.utils.XmlUtils;
import tst.project.webservice.controller.BaseController;

/**
 * 何柏瑞特有的接口
 * 
 * @author shenjiabo
 *
 */
@Controller
@RequestMapping("/hbrInterfaces.api")
public class HBRInterfaces extends BaseController {

	@Resource
	HBRService hbrService;

	@Resource
	MemberService memberService;

	@Resource
	GoodsServiceI goodsServiceI;

	
	/**
	 * 储值卡消费记录
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getMemberStoredRecord", method = RequestMethod.POST)
	public void svcardDeal(MemberBean memberBean, GoodsBean goodsBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			MemberBean memberBean2 = memberService.verificationToken(memberBean);
			if (memberBean2 == null) {
				WritePending(response, "token failed");
				return;
			}
			if (memberBean2.getStored_code() == null || "".equals(memberBean2.getStored_code())) {
				WriteError(response, "您还未绑定储值卡");
				return;
			}
		} catch (Exception e) {
			WriteError(response, e.getMessage());
		}
	}
	
	
	/**
	 * 绑定储值卡
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "bindMemberStored", method = RequestMethod.POST)
	public void bindMemberStored(MemberBean memberBean, GoodsBean goodsBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			MemberBean memberBean2 = memberService.verificationToken(memberBean);
			if (memberBean2 == null) {
				WritePending(response, "token failed");
				return;
			}
			if (memberBean2.getStored_code() != null && !"".equals(memberBean2.getStored_code())) {
				WriteError(response, "您已绑定储值卡");
				return;
			}
			
			MemberBean memberBean3=hbrService.getMemberByStore(memberBean);
			if(memberBean3!=null){
				WriteError(response, "此储值卡已被绑定");
				return;
			}
			
			int num=hbrService.bindMemberStored(memberBean);
			if(num>0){
				WriteMsg(response, "绑定成功");
			}else{
				WriteError(response, "绑定失败");
			}
		} catch (Exception e) {
			WriteError(response, e.getMessage());
		}
	}

	/**
	 * 储值卡余额
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getMemberIntegral", method = RequestMethod.POST)
	public void getMemberIntegral(MemberBean memberBean, ShareBean shareBean, GoodsBean goodsBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberBean memberBean2 = memberService.verificationToken(memberBean);
		if (memberBean2 == null) {
			WritePending(response, "token failed");
			return;
		}

		String xml = "";
		xml = HBRUtils.getScore(memberBean2.getMember_code());

		String integral = XmlUtils.getValueByTagName(XmlUtils.getDocumentByXml(xml), "integral");
		WriteMsg(response, integral);
	}

	
	/**
	 * 储值卡余额
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getMemberStoredBalance", method = RequestMethod.POST)
	public void getMemberStoredBalance(MemberBean memberBean, ShareBean shareBean, GoodsBean goodsBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberBean memberBean2 = memberService.verificationToken(memberBean);
		if (memberBean2 == null) {
			WritePending(response, "token failed");
			return;
		}

		if ("".equals(memberBean2.getStored_code())) {
			WriteError(response, "还未绑定储值卡");
			return;
		}

		String xml = "";
		xml = HBRUtils.SvcardBalance(memberBean2.getStored_code());

		String total = XmlUtils.getValueByTagName(XmlUtils.getDocumentByXml(xml), "total");
		WriteMsg(response, total);
	}

	/**
	 * 首页商品（何柏瑞）
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertMemberShare", method = RequestMethod.POST)
	public void insertMemberShare(MemberBean memberBean, ShareBean shareBean, GoodsBean goodsBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}

		ShareBean shareBean2 = hbrService.getMemberShareByMemberIDAndGoodsID(shareBean);
		if (shareBean2 != null) {
			WriteError(response, "您已得过积分了哦");
			return;
		}

		GoodsBean goodsBean2 = goodsServiceI.getOneGoodsDetail(goodsBean);
		if (goodsBean2 == null) {
			WriteError(response, "该商品不存在");
			return;
		}

		if (!"1".equals(goodsBean2.getIs_share())) {
			WriteError(response, "该商品不可以分享得积分");
			return;
		}

		int num = hbrService.insertMemberShare(shareBean.setShare_integral(goodsBean2.getShare_integral()));
		if (num > 0) {
			WriteMsg(response, "分享得积分成功");
		} else {
			WriteError(response, "分享得积分失败");
		}
	}

	/**
	 * 可分享的商品列表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getShareGoodss", method = RequestMethod.POST)
	public void getShareGoodss(GoodsBean goodsBean, PageBean pageBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		WriteObject(response, hbrService.getShareGoodss(goodsBean, pageBean));
	}

	/**
	 * 首页商品（何柏瑞）
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getHomeGoods", method = RequestMethod.POST)
	public void getHomeGoods(HomeGoodsBean homeGoodsBean, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		WriteObject(response, hbrService.getHomeGoods(homeGoodsBean));
	}

	/**
	 * 首页标签（何柏瑞）
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getHomeLabels", method = RequestMethod.POST)
	public void getHomeLabels(LabelBean labelBean, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		WriteObject(response, hbrService.getHomeLabels(labelBean));
	}

	/**
	 * 首页活动（何柏瑞）
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getHomeActivitys", method = RequestMethod.POST)
	public void getHomeActivitys(ActivityBean activityBean, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		WriteObject(response, hbrService.getHomeActivitys(activityBean));
	}

	/**
	 * 首页分类（何柏瑞）
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getHomeClasss", method = RequestMethod.POST)
	public void getHomeClasss(GoodsBean goodsBean, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		WriteObject(response, hbrService.getHomeClasss(goodsBean));
	}

	/**
	 * 首页分类（何柏瑞）
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getHomeClasss2", method = RequestMethod.POST)
	public void getHomeClasss2(GoodsClassBean goodsClassBean, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		WriteObject(response, hbrService.getHomeClasss2(goodsClassBean));
	}
}
