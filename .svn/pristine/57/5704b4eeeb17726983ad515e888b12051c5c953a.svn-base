package tst.project.webservice.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import tst.project.bean.goods.BusinessGoodsBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.merchants.MerchantsAccountBean;
import tst.project.bean.merchants.MerchantsBean;
import tst.project.bean.merchants.MerchantsDescImgBean;
import tst.project.bean.merchants.MerchantsLabelBean;
import tst.project.bean.merchants.QualificationBean;
import tst.project.page.PageBean;
import tst.project.service.controller.MerchantsService;
import tst.project.service.controller.SystemService;
import tst.project.utils.FileUtils;
import tst.project.utils.MD5Util;
import tst.project.utils.TimeUtils;

/**
 * 供应商管理
 * 
 * @author shenjiabo
 *
 */
@Controller
@RequestMapping("/merchantsController.api")
public class MerchantsController extends BaseController {
	@Resource
	SystemService systemService;

	@Resource
	MerchantsService merchantsService;
	
	/**
	 * 修改商家账号信息
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getMerchantsDescImgs", method = RequestMethod.POST)
	public void getMerchantsDescImgs(MerchantsAccountBean merchantsAccountBean,
			MerchantsDescImgBean merchantsDescImgBean,
			HttpServletRequest request,
			HttpServletResponse response) {
		try {
			if (!systemService.verToken(merchantsAccountBean)) {
				WritePending(response, "token failed");
				return;
			}

			WriteObject(response,merchantsService.getMerchantsDescImgs(merchantsDescImgBean));
		} catch (Exception e) {
			WriteError(response, e.getMessage());
		}
	}
	
	/**
	 * 修改商家账号信息
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertMerchantsDescImg", method = RequestMethod.POST)
	public void insertMerchantsDescImg(MerchantsAccountBean merchantsAccountBean,
			MerchantsDescImgBean merchantsDescImgBean,
			HttpServletRequest request,
			HttpServletResponse response) {
		try {
			if (!systemService.verToken(merchantsAccountBean)) {
				WritePending(response, "token failed");
				return;
			}

			int num=merchantsService.insertMerchantsDescImg(merchantsDescImgBean);
			if(num>0){
				WriteMsg(response, "添加成功");
			}else{
				WriteError(response, "添加失败");
			}
		} catch (Exception e) {
			WriteError(response, e.getMessage());
		}
	}
	/**
	 * 修改商家账号信息
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateMerchantsDescImg", method = RequestMethod.POST)
	public void updateMerchantsDescImg(MerchantsAccountBean merchantsAccountBean,
			MerchantsDescImgBean merchantsDescImgBean,
			HttpServletRequest request,
			HttpServletResponse response) {
		try {
			if (!systemService.verToken(merchantsAccountBean)) {
				WritePending(response, "token failed");
				return;
			}

			int num=merchantsService.updateMerchantsDescImg(merchantsDescImgBean);
			if(num>0){
				WriteMsg(response, "修改成功");
			}else{
				WriteError(response, "修改失败");
			}
		} catch (Exception e) {
			WriteError(response, e.getMessage());
		}
	}
	/**
	 * 修改商家账号信息
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteMerchantsDescImg", method = RequestMethod.POST)
	public void deleteMerchantsDescImg(MerchantsAccountBean merchantsAccountBean,
			MerchantsDescImgBean merchantsDescImgBean,
			HttpServletRequest request,
			HttpServletResponse response) {
		try {
			if (!systemService.verToken(merchantsAccountBean)) {
				WritePending(response, "token failed");
				return;
			}

			int num=merchantsService.deleteMerchantsDescImg(merchantsDescImgBean);
			if(num>0){
				WriteMsg(response, "删除成功");
			}else{
				WriteError(response, "删除失败");
			}
		} catch (Exception e) {
			WriteError(response, e.getMessage());
		}
	}
	
	
	
	/**
	 * 修改商家账号信息
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteMerchants", method = RequestMethod.POST)
	public void deleteMerchants(MerchantsAccountBean merchantsAccountBean,
			MerchantsBean merchantsBean,
			HttpServletRequest request,
			HttpServletResponse response) {
		try {
			if (!systemService.verToken(merchantsAccountBean)) {
				WritePending(response, "token failed");
				return;
			}

			int num=merchantsService.deleteMerchants(merchantsBean);
			if(num>0){
				WriteMsg(response, "删除成功");
			}else{
				WriteError(response, "删除失败");
			}
		} catch (Exception e) {
			WriteError(response, e.getMessage());
		}
	}
	/**
	 * 修改商家账号信息
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateMerchantsAccountDetail", method = RequestMethod.POST)
	public void updateMerchantsAccountDetail(MerchantsAccountBean merchantsAccountBean,
			PageBean pageBean,
			HttpServletRequest request,
			HttpServletResponse response) {
		try {
			if (!systemService.verToken(merchantsAccountBean)) {
				WritePending(response, "token failed");
				return;
			}

			int num=merchantsService.updateMerchantsAccountDetail(merchantsAccountBean);
			if(num>0){
				WriteMsg(response, "修改成功");
			}else{
				WriteError(response, "修改失败");
			}
		} catch (Exception e) {
			WriteError(response, e.getMessage());
		}
	}
	
	
	
	/**
	 * 店铺的粉丝列表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getBusinessFollower", method = RequestMethod.POST)
	public void getBusinessFollower(MerchantsAccountBean merchantsAccountBean,
			PageBean pageBean,
			HttpServletRequest request,
			HttpServletResponse response) {
		try {
			if (!systemService.verToken(merchantsAccountBean)) {
				WritePending(response, "token failed");
				return;
			}

			WriteObject(response, merchantsService.getBusinessFollower(merchantsAccountBean,pageBean),pageBean.getTotal());
		} catch (Exception e) {
			WriteError(response, e.getMessage());
		}
	}
	
	/**
	 * 店铺的推广员详情
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getBusinessExtensionDetail", method = RequestMethod.POST)
	public void getBusinessExtensionDetail(MerchantsAccountBean merchantsAccountBean,
			PageBean pageBean,
			HttpServletRequest request,
			HttpServletResponse response) {
		try {
			if (!systemService.verToken(merchantsAccountBean)) {
				WritePending(response, "token failed");
				return;
			}

			WriteObject(response, merchantsService.getBusinessExtensionDetail(merchantsAccountBean));
		} catch (Exception e) {
			WriteError(response, e.getMessage());
		}
	}

	
	/**
	 * 店铺的推广员列表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getBusinessExtensions", method = RequestMethod.POST)
	public void getBusinessExtensions(MerchantsAccountBean merchantsAccountBean,
			PageBean pageBean,
			HttpServletRequest request,
			HttpServletResponse response) {
		try {
			if (!systemService.verToken(merchantsAccountBean)) {
				WritePending(response, "token failed");
				return;
			}

			WriteObject(response, merchantsService.getBusinessExtensions(merchantsAccountBean,pageBean),pageBean.getTotal());
		} catch (Exception e) {
			WriteError(response, e.getMessage());
		}
	}

	
	
	/**
	 * 删除商家账号
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteMerchantsAccount", method = RequestMethod.POST)
	public void deleteMerchantsAccount(MerchantsAccountBean merchantsAccountBean, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			if (!systemService.verToken(merchantsAccountBean)) {
				WritePending(response, "token failed");
				return;
			}

			int num = merchantsService.deleteMerchantsAccount(merchantsAccountBean);
			if (num > 0) {
				WriteMsg(response, "删除成功");
			} else {
				WriteError(response, "删除失败");
			}
		} catch (Exception e) {
			WriteError(response, e.getMessage());
		}
	}

	/**
	 * 修改商家账号
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateMerchantsAccount", method = RequestMethod.POST)
	public void updateMerchantsAccount(MerchantsAccountBean merchantsAccountBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (!systemService.verToken(merchantsAccountBean)) {
			WritePending(response, "token failed");
			return;
		}

		String pas = MD5Util.md5Encode(merchantsAccountBean.getPassword());
		int num = merchantsService.updateMerchantsAccount(merchantsAccountBean.setPassword(pas));
		if (num > 0) {
			WriteMsg(response, "修改成功");
		} else {
			WriteError(response, "修改失败");
		}
	}

	/**
	 * 添加商家账号
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertMerchantsAccount", method = RequestMethod.POST)
	public void insertMerchantsAccount(MerchantsAccountBean merchantsAccountBean, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			if (!systemService.verToken(merchantsAccountBean)) {
				WritePending(response, "token failed");
				return;
			}

			String pas = MD5Util.md5Encode(merchantsAccountBean.getPassword());

			MerchantsAccountBean merchantsAccountBean2 = systemService
					.getMerchantsAccount(merchantsAccountBean.setPassword(pas));
			if (merchantsAccountBean2 != null) {
				WriteError(response, "此账号已注册");
				return;
			}

			int num = merchantsService.insertMerchantsAccount(merchantsAccountBean.setPassword(pas),request);
			if (num > 0) {
				WriteMsg(response, "添加成功");
			} else {
				WriteError(response, "添加失败");
			}
		} catch (Exception e) {
			WriteError(response, e.getMessage());
		}
	}

	/**
	 * 获得商家的账号信息
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getMerchantsAccounts", method = RequestMethod.POST)
	public void getMerchantsAccounts(MerchantsAccountBean merchantsAccountBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (!systemService.verToken(merchantsAccountBean)) {
			WritePending(response, "token failed");
			return;
		}

		WriteObject(response, merchantsService.getMerchantsAccounts(merchantsAccountBean));
	}

	/**
	 * 审核用户申请
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "auditingApplyMerchants", method = RequestMethod.POST)
	public void auditingApplyMerchants(MerchantsAccountBean merchantsAccountBean, MerchantsBean merchantsBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!systemService.verToken(merchantsAccountBean)) {
			WritePending(response, "token failed");
			return;
		}

		int num = merchantsService.auditingApplyMerchants(merchantsBean);
		if (num > 0) {
			WriteMsg(response, "操作成功");
		} else {
			WriteError(response, "操作失败");
		}
	}

	/**
	 * 添加标签资质
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteLabelQualification", method = RequestMethod.POST)
	public void deleteLabelQualification(MerchantsAccountBean merchantsAccountBean, QualificationBean qualificationBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!systemService.verToken(merchantsAccountBean)) {
			WritePending(response, "token failed");
			return;
		}

		int num = merchantsService.deleteLabelQualification(qualificationBean);
		if (num > 0) {
			WriteMsg(response, "删除成功");
		} else {
			WriteError(response, "删除失败");
		}
	}

	/**
	 * 添加标签资质
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertLabelQualification", method = RequestMethod.POST)
	public void insertLabelQualification(MerchantsAccountBean merchantsAccountBean, QualificationBean qualificationBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!systemService.verToken(merchantsAccountBean)) {
			WritePending(response, "token failed");
			return;
		}
		QualificationBean qualificationBean2 = merchantsService.getOneMerchantsLabelQualification(qualificationBean);
		if (qualificationBean2 != null) {
			WriteError(response, "此资质已添加");
			return;
		}

		int num = merchantsService.insertLabelQualification(qualificationBean);
		if (num > 0) {
			WriteMsg(response, "添加成功");
		} else {
			WriteError(response, "添加失败");
		}
	}

	/**
	 * 获得所有标签资质
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getMerchantsLabelQualifications", method = RequestMethod.POST)
	public void getMerchantsLabelQualifications(MerchantsAccountBean merchantsAccountBean,
			QualificationBean qualificationBean, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (!systemService.verToken(merchantsAccountBean)) {
			WritePending(response, "token failed");
			return;
		}

		WriteObject(response, merchantsService.getMerchantsLabelQualifications(qualificationBean));
	}

	/**
	 * 添加商家资质
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertMerchantsQualification", method = RequestMethod.POST)
	public void insertMerchantsLabel(MerchantsAccountBean merchantsAccountBean, QualificationBean qualificationBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!systemService.verToken(merchantsAccountBean)) {
			WritePending(response, "token failed");
			return;
		}

		int num = merchantsService.insertMerchantsQualification(qualificationBean);
		if (num > 0) {
			WriteMsg(response, "添加成功");
		} else {
			WriteError(response, "添加失败");
		}
	}

	/**
	 * 修改商家资质
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateMerchantsQualification", method = RequestMethod.POST)
	public void updateMerchantsQualification(MerchantsAccountBean merchantsAccountBean,
			QualificationBean qualificationBean, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (!systemService.verToken(merchantsAccountBean)) {
			WritePending(response, "token failed");
			return;
		}

		int num = merchantsService.updateMerchantsQualification(qualificationBean);
		if (num > 0) {
			WriteMsg(response, "修改成功");
		} else {
			WriteError(response, "修改失败");
		}
	}

	/**
	 * 删除商家资质
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteMerchantsQualification", method = RequestMethod.POST)
	public void deleteMerchantsQualification(MerchantsAccountBean merchantsAccountBean,
			QualificationBean qualificationBean, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (!systemService.verToken(merchantsAccountBean)) {
			WritePending(response, "token failed");
			return;
		}

		int num = merchantsService.deleteMerchantsQualification(qualificationBean);
		if (num > 0) {
			WriteMsg(response, "删除成功");
		} else {
			WriteError(response, "删除失败");
		}
	}

	/**
	 * 获得所有商家资质
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getAllMerchantsQualification", method = RequestMethod.POST)
	public void getAllMerchantsQualification(MerchantsAccountBean merchantsAccountBean,
			QualificationBean qualificationBean, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (!systemService.verToken(merchantsAccountBean)) {
			WritePending(response, "token failed");
			return;
		}

		WriteObject(response, merchantsService.getAllMerchantsQualification(qualificationBean));
	}

	/**
	 * 添加商家标签
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertMerchantsLabel", method = RequestMethod.POST)
	public void insertMerchantsLabel(MerchantsAccountBean merchantsAccountBean, MerchantsLabelBean merchantsLabelBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!systemService.verToken(merchantsAccountBean)) {
			WritePending(response, "token failed");
			return;
		}

		int num = merchantsService.insertMerchantsLabel(merchantsLabelBean);
		if (num > 0) {
			WriteMsg(response, "添加成功");
		} else {
			WriteError(response, "添加失败");
		}
	}

	/**
	 * 修改商家标签
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateMerchantsLabel", method = RequestMethod.POST)
	public void updateMerchantsLabel(MerchantsAccountBean merchantsAccountBean, MerchantsLabelBean merchantsLabelBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!systemService.verToken(merchantsAccountBean)) {
			WritePending(response, "token failed");
			return;
		}

		int num = merchantsService.updateMerchantsLabel(merchantsLabelBean);
		if (num > 0) {
			WriteMsg(response, "修改成功");
		} else {
			WriteError(response, "修改失败");
		}
	}

	/**
	 * 删除商家标签
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteMerchantsLabel", method = RequestMethod.POST)
	public void deleteMerchantsLabel(MerchantsAccountBean merchantsAccountBean, MerchantsLabelBean merchantsLabelBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!systemService.verToken(merchantsAccountBean)) {
			WritePending(response, "token failed");
			return;
		}

		int num = merchantsService.deleteMerchantsLabel(merchantsLabelBean);
		if (num > 0) {
			WriteMsg(response, "删除成功");
		} else {
			WriteError(response, "删除失败");
		}
	}

	/**
	 * 获得所有商家标签
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getAllMerchantsLabel", method = RequestMethod.POST)
	public void getAllMerchantsLabel(MerchantsAccountBean merchantsAccountBean, MerchantsLabelBean merchantsLabelBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!systemService.verToken(merchantsAccountBean)) {
			WritePending(response, "token failed");
			return;
		}

		WriteObject(response, merchantsService.getAllMerchantsLabel(merchantsLabelBean));
	}

	/**
	 * 获得店铺详情
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getOneMerchantsDetail", method = RequestMethod.POST)
	public void getOneMerchantsDetail(MerchantsAccountBean merchantsAccountBean, MerchantsBean merchantsBean,
			PageBean pageBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!systemService.verToken(merchantsAccountBean)) {
			WritePending(response, "token failed");
			return;
		}

		WriteObject(response, merchantsService.getOneMerchantsDetail(merchantsBean));
	}

	/**
	 * 获得默认店铺详情
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getMerchantsDefault", method = RequestMethod.POST)
	public void getMerchantsDefault(MerchantsAccountBean merchantsAccountBean, MerchantsBean merchantsBean,
			PageBean pageBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!systemService.verToken(merchantsAccountBean)) {
			WritePending(response, "token failed");
			return;
		}

		WriteObject(response, merchantsService.getMerchantsDefault(merchantsBean));
	}

	/**
	 * 获得店铺的客户
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getBusinessMembers", method = RequestMethod.POST)
	public void getBusinessMembers(MerchantsAccountBean merchantsAccountBean, MemberBean memberBean, PageBean pageBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!systemService.verToken(merchantsAccountBean)) {
			WritePending(response, "token failed");
			return;
		}

		WriteObject(response, merchantsService.getBusinessMembers(memberBean, pageBean), pageBean.getTotal());
	}

	/**
	 * 设置店铺列表默认
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "setMerchantsDefault", method = RequestMethod.POST)
	public void setMerchantsDefault(MerchantsAccountBean merchantsAccountBean, MerchantsBean merchantsBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!systemService.verToken(merchantsAccountBean)) {
			WritePending(response, "token failed");
			return;
		}

		int num = merchantsService.setMerchantsDefault(merchantsBean);
		if (num > 0) {
			WriteMsg(response, "设置成功");
		} else {
			WriteError(response, "设置失败");
		}
	}

	/**
	 * 上传广告图片
	 * 
	 * @param merchantsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "uploadMerchantsImg")
	public void uploadBannerImg(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String json = uploadFile(request, "/images/merchants/");
		if (json.equals("-1")) {
			WriteError(response, "文件不可为空");
		} else if (json.equals("-2")) {
			WriteError(response, "上传失败");
		} else {
			WriteMsg(response, json);
		}
	}

	/**
	 * 获得账号的店铺列表
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getMerchantsByAccount", method = RequestMethod.POST)
	public void getMerchantsByAccount(MerchantsAccountBean merchantsAccountBean, MerchantsBean merchantsBean,
			PageBean pageBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!systemService.verToken(merchantsAccountBean)) {
			WritePending(response, "token failed");
			return;
		}

		WriteObject(response, merchantsService.getMerchantsByAccount(merchantsBean, pageBean), pageBean.getTotal());
	}

	/**
	 * 获得所有商家
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getAllMerchants", method = RequestMethod.POST)
	public void getAllMerchants(MerchantsAccountBean merchantsAccountBean, MerchantsBean merchantsBean,
			PageBean pageBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!systemService.verToken(merchantsAccountBean)) {
			WritePending(response, "token failed");
			return;
		}

		WriteObject(response, merchantsService.getAllMerchants(merchantsBean, pageBean), pageBean.getTotal());
	}

	/**
	 * 获得所有商家 不分页
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getAllMerchantsNopage", method = RequestMethod.POST)
	public void getAllMerchantsNopage(MerchantsAccountBean merchantsAccountBean, MerchantsBean merchantsBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!systemService.verToken(merchantsAccountBean)) {
			WritePending(response, "token failed");
			return;
		}

		WriteObject(response, merchantsService.getAllMerchantsNopage(merchantsBean));
	}
	/**
	 * 获得所有商家账号
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getAllMerchantsAccountNopage", method = RequestMethod.POST)
	public void getAllMerchantsAccountNopage(MerchantsAccountBean merchantsAccountBean, MerchantsBean merchantsBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!systemService.verToken(merchantsAccountBean)) {
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, merchantsService.getAllMerchantsAccountNopage(merchantsAccountBean));
	}

	/**
	 * 导出商家 二维码
	 * 
	 * @param merchantsAccountBean
	 * @param businessGoodsBean
	 * @param pageBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "downloadMerchantsQrCode")
	public void downloadMerchantsQrCode(MerchantsAccountBean merchantsAccountBean, BusinessGoodsBean businessGoodsBean,
			MerchantsBean merchantsBean, PageBean pageBean, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (!systemService.verToken(merchantsAccountBean)) {
			WritePending(response, "token failed");
			return;
		}

		List<String> paths = merchantsService.getMerchantsQrCode(merchantsBean);
		if (paths == null || paths.size() <= 0) {
			WriteError(response, "暂无任何二维码");
			return;
		}
		String out = TimeUtils.getCurrentTime("yyyyMMddHHmmss") + ".zip";
		boolean is_success = FileUtils.packZip(paths,
				request.getSession().getServletContext().getRealPath("/") + "/images/qrcode/business/" + out,
				request);
		if (is_success) {
			WriteMsg(response, "/images/qrcode/business/" + out);
		} else {
			WriteError(response, "下载失败");
		}
	}

	/**
	 * 添加商家详情
	 * 
	 * @param merchantsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertMerchantDetailJSON", method = RequestMethod.POST)
	public void insertMerchantDetailJSON(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		if (!systemService.verToken(merchantsAccountBean)) {
//			WritePending(response, "token failed");
//			return;
//		}
		String json=request.getParameter("json");
		List<MerchantsBean> merchantsBeans=new Gson().fromJson(json, new TypeToken<List<MerchantsBean>>() {}.getType());
		for (int i = 0; i < merchantsBeans.size(); i++) {
			MerchantsBean merchantsBean=merchantsBeans.get(i);
			int num = merchantsService.insertMerchantDetail(request, merchantsBean);
			if (num > 0) {
				WriteObject(response, "添加成功");
			} else {
				WriteObject(response, "添加失败");
			}	
		}	
		
	}

	
	
	/**
	 * 添加商家详情
	 * 
	 * @param merchantsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertMerchantDetail", method = RequestMethod.POST)
	public void insertMerchantDetail(MerchantsAccountBean merchantsAccountBean, MerchantsBean merchantsBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!systemService.verToken(merchantsAccountBean)) {
			WritePending(response, "token failed");
			return;
		}

		int num = merchantsService.insertMerchantDetail(request, merchantsBean);
		if (num > 0) {
			WriteObject(response, "添加成功");
		} else {
			WriteObject(response, "添加失败");
		}
	}

	/**
	 * 修改商家详情
	 * 
	 * @param merchantsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateMerchantDetail", method = RequestMethod.POST)
	public void updateMerchantDetail(MerchantsAccountBean merchantsAccountBean, MerchantsBean merchantsBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!systemService.verToken(merchantsAccountBean)) {
			WritePending(response, "token failed");
			return;
		}
		int num = merchantsService.updateMerchantDetail(merchantsBean);
		if (num > 0) {
			WriteMsg(response, "修改成功");
		} else {
			WriteError(response, "修改失败");
		}
	}
	
	/**
	 * 修改商家详情
	 * 
	 * @param merchantsBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteMerchantDetail", method = RequestMethod.POST)
	public void deleteMerchantDetail(MerchantsAccountBean merchantsAccountBean, MerchantsBean merchantsBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!systemService.verToken(merchantsAccountBean)) {
			WritePending(response, "token failed");
			return;
		}
		int num = merchantsService.deleteMerchantDetail(merchantsBean);
		if (num > 0) {
			WriteMsg(response, "删除成功");
		} else {
			WriteError(response, "删除失败");
		}
	}
}
