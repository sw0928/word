package tst.project.webservice.interfaces;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tst.project.bean.member.BankBean;
import tst.project.bean.member.MemberBean;
import tst.project.page.PageBean;
import tst.project.service.interfaces.BankService;
import tst.project.service.interfaces.MemberService;
import tst.project.webservice.controller.BaseController;

@Controller
@RequestMapping("/bankInterfaces.api")
public class BankInterfaces extends BaseController{
	@Resource
	MemberService memberService;
	
	@Resource
	BankService bankService;
	
	/**
	 * 银行卡列表
	 * @param memberBean
	 * @param bankBean
	 * @param pageBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getMemberBanks", method = RequestMethod.POST)
	public void getMemberBanks(MemberBean memberBean,BankBean bankBean,PageBean pageBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}

		WriteObject(response, bankService.getMemberBanks(bankBean,pageBean));
	}
	
	
	/**
	 * 用户添加银行卡信息
	 * @param memberBean
	 * @param bankBean
	 * @param pageBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertMemberBank", method = RequestMethod.POST)
	public void insertMemberBank(MemberBean memberBean,BankBean bankBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}

		int num=bankService.insertMemberBank(bankBean);
		if(num>0){
			WriteMsg(response, "添加成功");
		}else{
			WriteError(response, "添加失败");
		}
	}
	
	/**
	 * 用户修改银行卡信息
	 * @param memberBean
	 * @param bankBean
	 * @param pageBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateMemberBank", method = RequestMethod.POST)
	public void updateMemberBank(MemberBean memberBean,BankBean bankBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}

		int num=bankService.updateMemberBank(bankBean);
		if(num>0){
			WriteMsg(response, "修改成功");
		}else{
			WriteError(response, "修改失败");
		}
	}
	
	/**
	 * 用户设置银行卡默认
	 * @param memberBean
	 * @param bankBean
	 * @param pageBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateMemberDefaultBank", method = RequestMethod.POST)
	public void updateMemberDefaultBank(MemberBean memberBean,BankBean bankBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}

		int num=bankService.updateMemberDefaultBank(bankBean);
		if(num>0){
			WriteMsg(response, "设置成功");
		}else{
			WriteError(response, "设置失败");
		}
	}
	
	
	/**
	 * 用户删除银行卡
	 * @param memberBean
	 * @param bankBean
	 * @param pageBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteMemberBank", method = RequestMethod.POST)
	public void deleteMemberBank(MemberBean memberBean,BankBean bankBean, HttpServletRequest request,
			HttpServletResponse response)  {
		try{
			if (memberService.verificationToken(memberBean) == null) {
				WritePending(response, "token failed");
				return;
			}
			
			int num=bankService.deleteMemberBank(bankBean);
			if(num>0){
				WriteMsg(response, "删除成功");
			}else{
				WriteError(response, "删除失败");
			}
		}catch(Exception e){
			WriteError(response, e.getMessage());
		}
	}
	
	/**
	 * 用户获得默认银行卡
	 * @param memberBean
	 * @param bankBean
	 * @param pageBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getMemberDefaultBank", method = RequestMethod.POST)
	public void getMemberDefaultBank(MemberBean memberBean,BankBean bankBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}

		WriteObject(response,bankService.getMemberDefaultBank(bankBean));
	}
}
