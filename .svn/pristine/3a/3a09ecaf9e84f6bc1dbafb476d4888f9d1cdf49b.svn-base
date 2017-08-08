package tst.project.webservice.interfaces;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

import tst.project.bean.collection.CollectionBean;
import tst.project.bean.member.MemberBean;
import tst.project.page.PageBean;
import tst.project.service.interfaces.CollectionService;
import tst.project.service.interfaces.MemberService;
import tst.project.webservice.controller.BaseController;

@Controller
@RequestMapping("/collectionInterfaces.api")
public class CollectionInterface extends BaseController {
	@Resource
	MemberService memberService;

	@Resource
	CollectionService collectionService;

	@RequestMapping(params = "insertCollection", method = RequestMethod.POST)
	public void addCollection(MemberBean memberBean, CollectionBean collectionBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}
		
		if(collectionBean.getRelation_id()==null||collectionBean.getRelation_id().equals("")){
			WriteError(response, "未传任何需要收藏的物品");
			return;
		}

		CollectionBean collectionBean2 = collectionService.getCollectionBySearch(collectionBean);
		if (collectionBean2 != null && collectionBean2.getIs_delete().equals("0")) {
			WriteError(response, "已收藏");
			return;
		}

		if (collectionBean2 != null && collectionBean2.getIs_delete().equals("1")) {
			int num = collectionService.updateCollectionState(collectionBean2.setIs_delete("0"));
			if (num > 0) {
				WriteMsg(response, collectionBean2.getCollection_id() + "");
			} else {
				WriteError(response, "收藏失败");
			}
		} else {
			int num = collectionService.insertCollection(collectionBean);
			if (num > 0) {
				WriteMsg(response, collectionBean.getCollection_id() + "");
			} else {
				WriteError(response, "收藏失败");
			}
		}
	}

	@RequestMapping(params = "cancelCollection", method = RequestMethod.POST)
	public void cancelCollection(MemberBean memberBean, CollectionBean collectionBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}
		int num = collectionService.updateCollectionState(collectionBean.setIs_delete("1"));
		if (num > 0) {
			WriteMsg(response, "取消成功");
		} else {
			WriteError(response, "取消失败");
		}

	}

	@RequestMapping(params = "cancelAllCollection", method = RequestMethod.POST)
	public void cancelAllCollection(MemberBean memberBean, HttpServletRequest request, HttpServletResponse response) {
		try {
			if (memberService.verificationToken(memberBean) == null) {
				WritePending(response, "token failed");
				return;
			}
			String collection_ids = request.getParameter("collection_ids");
			if (collection_ids == null) {
				WriteError(response, "未传任何收藏id");
				return;
			}
			int num = collectionService.cancelAllCollection(memberBean.getMember_id()+"",collection_ids.split(","));
			if (num > 0) {
				WriteMsg(response, "取消成功");
			} else {
				WriteError(response, "取消失败");
			}
		} catch (Exception e) {
			WriteError(response, e.getMessage().toString());
		}
	}

	@RequestMapping(params = "getCollection", method = RequestMethod.POST)
	public void getCollection(MemberBean memberBean, CollectionBean collectionBean, PageBean pageBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (memberService.verificationToken(memberBean) == null) {
			WritePending(response, "token failed");
			return;
		}

		WriteObject(response, collectionService.getCollection(collectionBean, pageBean),pageBean.getTotal());
	}
}
