package tst.project.webservice.interfaces;

import java.sql.Time;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.mail.handlers.message_rfc822;

import sun.net.www.content.text.plain;
import tst.project.bean.activity.ActivityBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.picture.PictureBean;
import tst.project.bean.picture.PictureVoteBean;
import tst.project.page.PageBean;
import tst.project.service.interfaces.MemberService;
import tst.project.service.interfaces.PictureService;
import tst.project.utils.TimeUtils;
import tst.project.webservice.controller.BaseController;

@Controller
@RequestMapping("/pictureInterfaces.api")
public class PictureInterfaces extends BaseController{
	@Resource
	PictureService pictureService;
	
	@Resource
	MemberService memberService;
	

	/**
	 * 投票晒图
	 * @param memberBean
	 * @param pictureBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "votePicture", method = RequestMethod.POST)
	public void votePicture(MemberBean memberBean,PictureVoteBean pictureVoteBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}
		
		PictureVoteBean pictureVoteBean2=pictureService.getVotePicture(pictureVoteBean);
		if(pictureVoteBean2!=null){
			WriteError(response, "非常感谢,您已投过票");
			return;
		}
		
		int num=pictureService.votePicture(pictureVoteBean);
		if(num>0){
			WriteMsg(response, "投票成功");
		}else{
			WriteError(response, "投票失败");
		}
	}
	
	@RequestMapping(params = "getPictures", method = RequestMethod.POST)
	public void getPictures(MemberBean memberBean,PictureBean pictureBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		
		WriteObject(response, pictureService.getPictures(pictureBean,pageBean),pageBean.getTotal());
	}
	/**
	 * 上周优选
	 * @param memberBean
	 * @param pictureBean
	 * @param pageBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getLastWeekPictures", method = RequestMethod.POST)
	public void getLastWeekPictures(MemberBean memberBean,PictureBean pictureBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		System.out.println(TimeUtils.getLastWeekBegin("yyyy-MM-dd")+"==="+TimeUtils.getLastWeekEnd("yyyy-MM-dd"));
		WriteObject(response, pictureService.getLastWeekPictures(pictureBean
				.setStart_time(TimeUtils.getLastWeekBegin("yyyy-MM-dd"))
				.setEnd_time(TimeUtils.getLastWeekEnd("yyyy-MM-dd")+" 23:59:59"),
				pageBean),pageBean.getTotal());
	}
	
	@RequestMapping(params = "getMemberPictures", method = RequestMethod.POST)
	public void getMemberPictures(MemberBean memberBean,PictureBean pictureBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, pictureService.getMemberPictures(pictureBean,pageBean),pageBean.getTotal());
	}
	
	
	@RequestMapping(params = "insertPicture", method = RequestMethod.POST)
	public void insertPicture(MemberBean memberBean,PictureBean pictureBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}
		
		String imgs=request.getParameter("imgs");
		int num=pictureService.insertPicture(pictureBean,imgs!=null?imgs.split(","):null);
		if(num>0){
			WriteMsg(response, "晒图成功");
		}else{
			WriteError(response, "晒图失败");
		}
	}
}
