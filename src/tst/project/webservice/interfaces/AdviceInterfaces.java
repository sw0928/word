package tst.project.webservice.interfaces;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import tst.project.bean.member.MemberBean;
import tst.project.bean.others.AdviceBean;
import tst.project.service.interfaces.AdviceService;
import tst.project.service.interfaces.MemberService;
import tst.project.webservice.controller.BaseController;

@Controller
@RequestMapping("/adviceInterfaces.api")
public class AdviceInterfaces extends BaseController {
	@Resource
	AdviceService adviceService;

	@Resource
	MemberService memberService;

	/**
	 * 提交建议或者投诉
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertAdvice", method = RequestMethod.POST)
	public void insertAdvice(HttpServletRequest request, HttpServletResponse response) {
		try {
			HashMap<String, Object> maps = getJsonWithImgs(request, "/images/advice");
			if (maps.get("result").equals("failed")) {
				WriteError(response, "上传失败");
				return;
			}

			MemberBean memberBean = new Gson().fromJson(maps.get("string").toString(), MemberBean.class);
			AdviceBean adviceBean = new Gson().fromJson(maps.get("string").toString(), AdviceBean.class);
			List<String> mapFiles = (List<String>) maps.get("file");

			if (memberService.verificationToken(memberBean) == null) {
				WritePending(response, "token failed");
				return;
			}

			int num = adviceService.insertAdvice(adviceBean, mapFiles);
			if (num >= 0) {
				WriteObject(response, "感谢您的宝贵意见!");
			} else {
				WriteError(response, "哎呀!太遗憾了,我们没能成功收到您的宝贵意见!");
			}
		} catch (Exception e) {
			WriteError(response, e.getMessage().toString());
		}
	}
	/**
	 * 提交建议或者投诉
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertAdviceWithPath", method = RequestMethod.POST)
	public void insertAdvice(AdviceBean adviceBean,MemberBean memberBean,HttpServletRequest request, HttpServletResponse response) {
		try {
			if (memberService.verificationToken(memberBean) == null) {
				WritePending(response, "token failed");
				return;
			}
			
			String advice_imgs=request.getParameter("advice_imgs");
			int num = adviceService.insertAdvice(adviceBean,advice_imgs);
			if (num >= 0) {
				WriteObject(response, "感谢您的宝贵意见!");
			} else {
				WriteError(response, "哎呀!太遗憾了,我们没能成功收到您的宝贵意见!");
			}
		} catch (Exception e) {
			WriteError(response, e.getMessage().toString());
		}
	}

	/**
	 * 上传意见图片
	 * @param merchantsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "uploadAdviceImg")
	public void uploadAdviceImg(HttpServletRequest request,
			HttpServletResponse response) throws Exception{	
		String json=uploadFile(request, "/images/advice/");
		if(json.equals("-1")){
			WriteError(response, "文件不可为空");
		}else if(json.equals("-2")){
			WriteError(response, "上传失败");	
		}else{
			WriteMsg(response, json);
		}
	}
	
}
