package tst.project.webservice.interfaces;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;import com.google.common.reflect.TypeToInstanceMap;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import tst.project.bean.goods.GoodsBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.merchants.MerchantsBean;
import tst.project.bean.merchants.MerchantsImgBean;
import tst.project.bean.merchants.MerchantsLabelBean;
import tst.project.bean.merchants.QualificationBean;
import tst.project.page.PageBean;
import tst.project.service.interfaces.MemberService;
import tst.project.service.interfaces.MerchantsServiceI;
import tst.project.webservice.controller.BaseController;

@Controller
@RequestMapping("/merchantsInterfaces.api")
public class MerchantsInterfaces extends BaseController{
	@Resource
	MerchantsServiceI merchantsServiceI;
	
	@Resource
	MemberService memberService;

	/**
	 * 店铺的分类列表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getMerchantsClass", method = RequestMethod.POST)
	public void getMerchantsClass(GoodsBean goodsBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		String level=request.getParameter("level");
		WriteObject(response, merchantsServiceI.getMerchantsClass(goodsBean,level));
	}
	
	/**
	 * 店铺的分类列表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getMerchantsClasss", method = RequestMethod.POST)
	public void getMerchantsClasss(GoodsBean goodsBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		WriteObject(response, merchantsServiceI.getMerchantsClasss(goodsBean));
	}
	
	/**
	 * 搜索店铺列表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "searchMerchants", method = RequestMethod.POST)
	public void searchMerchants(MerchantsBean merchantsBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		WriteObject(response, merchantsServiceI.searchMerchants(merchantsBean,pageBean),pageBean.getTotal());
	}
	
	
	/**
	 * 获得商家所有需要的资质证明
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getAllQualifications", method = RequestMethod.POST)
	public void getAllQualifications(QualificationBean qualificationBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		WriteObject(response, merchantsServiceI.getAllQualifications(qualificationBean));
	}
	
	/**
	 * 单个商家详情
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getOneMerchantsDetail", method = RequestMethod.POST)
	public void getOneMerchantsDetail(MerchantsBean merchantsBean,
			MemberBean memberBean,HttpServletRequest request,HttpServletResponse response) throws Exception {
		if(memberBean.getBusiness_id()!=null&&!memberBean.getBusiness_id().equals("-1")){
			MemberBean memberBean2=memberService.getMemberByID(memberBean);
			if(memberBean2!=null){
				if(memberBean2.getBusiness_id()==null||memberBean2.getBusiness_id().equals("-1")){
					int num=memberService.updateMemberBusiness(memberBean);
					if(num<=0){
						WriteError(response, "查询失败");
						return;
					}
				}
			}
		}
		WriteObject(response, merchantsServiceI.getOneMerchantsDetail(merchantsBean));
	}
	
	/**
	 * 单个商家的商品列表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getMerchantsGoodss", method = RequestMethod.POST)
	public void getMerchantsGoodss(GoodsBean goodsBean,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		WriteObject(response, merchantsServiceI.getMerchantsGoodss(goodsBean,pageBean),pageBean.getTotal());
	}
	
	/**
	 * 获得商家可能含有的标签
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getMerchantsLabels", method = RequestMethod.POST)
	public void getMerchantsLabels(MerchantsLabelBean merchantsLabelBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		WriteObject(response, merchantsServiceI.getMerchantsLabels(merchantsLabelBean));
	}
	
	/**
	 * 上传商家的一些图片资料
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "uploadMerchantsImg", method = RequestMethod.POST)
	public void uploadMerchantsImg(HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		String json=uploadFile(request, "/images/merchants/");
		if(json.equals("-1")){
			WriteError(response, "文件不可为空");
		}else if(json.equals("-2")){
			WriteError(response, "上传失败");	
		}else{
			WriteMsg(response, json);
		}
	}
	@RequestMapping(params = "getMerchantsByMember", method = RequestMethod.POST)
	public void getMerchantsByMember(MerchantsBean merchantsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {	
		MerchantsBean merchantsBean2=merchantsServiceI.getMerchantsByMember(merchantsBean);
		WriteObject(response, merchantsBean2);
	}
	/**
	 * 商家申请入驻
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "applyMerchants", method = RequestMethod.POST)
	public void applyMerchants(MerchantsBean merchantsBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {	

		MerchantsBean merchantsBean2=merchantsServiceI.getMerchantsByMember(merchantsBean);
		if(merchantsBean2!=null&&merchantsBean2.getApply_state().equals("0")){
			WriteError(response, "您已经提交过，正在审核");
			return;
		}
		if(merchantsBean2!=null&&merchantsBean2.getApply_state().equals("1")){
			WriteError(response, "您已经提交过，审核成功，等待平台联系");
			return;
		}
		
		if(merchantsBean2!=null&&merchantsBean2.getApply_state().equals("2")){//被拒绝后 重新填写
			String json=request.getParameter("json");
			List<MerchantsImgBean> merchantsImgBeans=new Gson().fromJson(json, new TypeToken<List<MerchantsImgBean>>(){}.getType());
					
			String label_ids=request.getParameter("label_ids");
			int num=merchantsServiceI.updateApplyMerchants(merchantsBean.
					setMerchants_id(merchantsBean2.getMerchants_id()).
					setMerchants_state("0").setApply_state("0"), 
					merchantsImgBeans,label_ids);
			if(num>0){
				WriteMsg(response, "修改成功");
			}else{
				WriteError(response, "修改失败");
			}
		}else if(merchantsBean2==null){//从未提交过
			String json=request.getParameter("json");
			List<MerchantsImgBean> merchantsImgBeans=new Gson().fromJson(json, new TypeToken<List<MerchantsImgBean>>(){}.getType());
					
			String label_ids=request.getParameter("label_ids");
			int num=merchantsServiceI.applyMerchants(merchantsBean.
					setMerchants_state("0").setApply_state("0"), 
					merchantsImgBeans,label_ids);
			if(num>0){
				WriteMsg(response, "申请成功");
			}else{
				WriteError(response, "申请失败");
			}
		}
	}
}
