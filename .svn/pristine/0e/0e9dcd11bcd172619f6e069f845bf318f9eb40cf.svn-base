package tst.project.webservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

import tst.project.bean.ExcelBean;
import tst.project.bean.goods.GoodsBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.merchants.MerchantsAccountBean;
import tst.project.page.PageBean;
import tst.project.service.controller.MemberServiceC;
import tst.project.service.controller.SystemService;
import tst.project.utils.ExcelUtils;
import tst.project.utils.TimeUtils;

@Controller
@RequestMapping("/memberController.api")
public class MemberController extends BaseController {
	@Resource
	SystemService systemService;

	@Resource
	MemberServiceC memberServiceC;

	/**
	 * 解除储值卡
	 */

	@RequestMapping(params = "deleteMemberStored", method = RequestMethod.POST)
	public void deleteMemberStored(MerchantsAccountBean merchantsAccountBean, MemberBean memberBean,
			GoodsBean goodsBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			if (!systemService.verToken(merchantsAccountBean)) {
				WritePending(response, "token failed");
				return;
			}

			int num=memberServiceC.deleteMemberStored(memberBean);
			if(num>0){
				WriteMsg(response, "解绑成功");
			}else{
				WriteError(response, "解绑失败");
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
	@RequestMapping(params = "bindMemberStored", method = RequestMethod.POST)
	public void bindMemberStored(MerchantsAccountBean merchantsAccountBean, MemberBean memberBean, GoodsBean goodsBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {

			if (!systemService.verToken(merchantsAccountBean)) {
				WritePending(response, "token failed");
				return;
			}

			MemberBean memberBean2 = memberServiceC.getOneMemberDetail(memberBean);

			if (memberBean2.getStored_code() != null && !"".equals(memberBean2.getStored_code())) {
				WriteError(response, "您已绑定储值卡");
				return;
			}

			MemberBean memberBean3 = memberServiceC.getMemberByStore(memberBean);
			if (memberBean3 != null) {
				WriteError(response, "此储值卡已被绑定");
				return;
			}

			int num = memberServiceC.bindMemberStored(memberBean);
			if (num > 0) {
				WriteMsg(response, "绑定成功");
			} else {
				WriteError(response, "绑定失败");
			}
		} catch (Exception e) {
			WriteError(response, e.getMessage());
		}
	}

	/**
	 * 获得分销的用户列表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getDistributionMembers", method = RequestMethod.POST)
	public void getDistributionMembers(MerchantsAccountBean merchantsAccountBean, MemberBean memberBean,
			PageBean pageBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!systemService.verToken(merchantsAccountBean)) {
			WritePending(response, "token failed");
			return;
		}
		String user_id = request.getParameter("user_id");
		MemberBean memberBean2 = memberServiceC
				.getOneMemberDetailZSSG(new MemberBean().setMember_id(Integer.valueOf(user_id)));

		WriteObject(response, memberServiceC.getDistributionMembers(
				memberBean.setInvitation_code(memberBean2.getInvitation_code()), pageBean), pageBean.getTotal());
	}

	/**
	 * 修改用户图片信息
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateMemberImg", method = RequestMethod.POST)
	public void updateMemberImg(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String json = uploadFile(request, "/images/member/");
		if (json.equals("-1")) {
			WriteError(response, "文件不可为空");
		} else if (json.equals("-2")) {
			WriteError(response, "上传失败");
		} else {
			WriteMsg(response, json);
		}
	}

	/**
	 * 修改用户详情
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateMemberDetail", method = RequestMethod.POST)
	public void updateMemberDetail(MerchantsAccountBean merchantsAccountBean, MemberBean memberBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!systemService.verToken(merchantsAccountBean)) {
			WritePending(response, "token failed");
			return;
		}

		int num = memberServiceC.updateMemberDetail(memberBean);
		if (num > 0) {
			WriteMsg(response, "修改成功");
		} else {
			WriteMsg(response, "修改失败");
		}
	}
	
	/**
	 * 修改用户归属
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateMemberFill", method = RequestMethod.POST)
	public void updateMemberFill(MerchantsAccountBean merchantsAccountBean, MemberBean memberBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!systemService.verToken(merchantsAccountBean)) {
			WritePending(response, "token failed");
			return;
		}
		
		MemberBean memberBean2=memberServiceC.getMemberByMobile(memberBean.setMember_account(memberBean.getFill_member_account()));
		if(memberBean2==null){
			WriteError(response, "该账号不存在");
			return;
		}
		
		int num = memberServiceC.updateMemberDetail(memberBean.setFill_invitation_code(memberBean2.getInvitation_code()));
		if (num > 0) {
			WriteMsg(response, "修改成功");
		} else {
			WriteMsg(response, "修改失败");
		}
	}

	/**
	 * 单个用户详情
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getOneMemberDetail", method = RequestMethod.POST)
	public void getOneMemberDetail(MerchantsAccountBean merchantsAccountBean, MemberBean memberBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!systemService.verToken(merchantsAccountBean)) {
			WritePending(response, "token failed");
			return;
		}

		WriteObject(response, memberServiceC.getOneMemberDetail(memberBean));
	}

	/**
	 * 单个用户详情
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getOneMemberDetailZSSG", method = RequestMethod.POST)
	public void getOneMemberDetailZSSG(MerchantsAccountBean merchantsAccountBean, MemberBean memberBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!systemService.verToken(merchantsAccountBean)) {
			WritePending(response, "token failed");
			return;
		}

		WriteObject(response, memberServiceC.getOneMemberDetailZSSG(memberBean));
	}

	/**
	 * 获得所有普通用户信息
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getAllMembersCount", method = RequestMethod.POST)
	public void getAllMembersCount(MerchantsAccountBean merchantsAccountBean, MemberBean memberBean, PageBean pageBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!systemService.verToken(merchantsAccountBean)) {
			WritePending(response, "token failed");
			return;
		}

		WriteObject(response, memberServiceC.getAllMembersCount(memberBean));
	}
	
	/**
	 * 获得所有普通用户信息
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "exportMemberExcel", method = RequestMethod.POST)
	public void exportMemberExcel(MerchantsAccountBean merchantsAccountBean, MemberBean memberBean, PageBean pageBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!systemService.verToken(merchantsAccountBean)) {
			WritePending(response, "token failed");
			return;
		}
		
		String fileName=TimeUtils.getCurrentTime("yyyyMMddHHmmss")+".xls";
		
		List<ExcelBean> excelBeans=new ArrayList<ExcelBean>();
		excelBeans.add(new ExcelBean().setName("账号").setType("member_account"));
		excelBeans.add(new ExcelBean().setName("手机号").setType("phone"));
		excelBeans.add(new ExcelBean().setName("昵称").setType("nick_name"));
		excelBeans.add(new ExcelBean().setName("积分").setType("integral"));
		excelBeans.add(new ExcelBean().setName("分销级别").setType("member_level"));
		excelBeans.add(new ExcelBean().setName("一级").setType("fill_member_code1"));
		excelBeans.add(new ExcelBean().setName("二级").setType("fill_member_code2"));
		excelBeans.add(new ExcelBean().setName("注册时间").setType("create_time"));

		
		List<Map> maps= memberServiceC.exportMemberExcel(memberBean);
		
		System.out.println(new Gson().toJson(maps));
		boolean is_success=ExcelUtils.exportExcel2(request.getSession().getServletContext()
				.getRealPath("/")+"/excel/"+fileName, excelBeans,maps,response);
		if(is_success){
			WriteMsg(response, "/excel/"+fileName);
		}else{
			WriteError(response, "导出失败");
		}
	}

	/**
	 * 获得所有普通用户信息
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getAllMembers", method = RequestMethod.POST)
	public void getAllMembers(MerchantsAccountBean merchantsAccountBean, MemberBean memberBean, PageBean pageBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!systemService.verToken(merchantsAccountBean)) {
			WritePending(response, "token failed");
			return;
		}

		WriteObject(response, memberServiceC.getAllMembers(memberBean, pageBean), pageBean.getTotal());
	}

	/**
	 * 获得所有普通用户信息
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getAllMembersZSSG", method = RequestMethod.POST)
	public void getAllMembersZSSG(MerchantsAccountBean merchantsAccountBean, MemberBean memberBean, PageBean pageBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!systemService.verToken(merchantsAccountBean)) {
			WritePending(response, "token failed");
			return;
		}

		WriteObject(response, memberServiceC.getAllMembersZSSG(memberBean, pageBean), pageBean.getTotal());
	}
}
