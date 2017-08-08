package tst.project.webservice.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.reflect.TypeToken;

import tst.project.bean.merchants.MerchantsAccountBean;
import tst.project.bean.merchants.MerchantsBean;
import tst.project.bean.system.DetailBean;
import tst.project.bean.system.ListBean;
import tst.project.bean.system.ListTypeBean;
import tst.project.bean.system.MoudleBean;
import tst.project.bean.system.RoleBean;
import tst.project.page.PageBean;
import tst.project.service.controller.SystemService;
import tst.project.utils.MD5Util;

/**
 * 系统权限管理
 * @author shenjiabo
 */
@Controller
@RequestMapping("/systemController.api")
public class SystemController extends BaseController{
	@Resource
	SystemService systemService;
	
	/**
	 * 添加列表所要展示的字段
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "saveRoleList", method = RequestMethod.POST)
	public void saveRoleList(MerchantsAccountBean merchantsAccountBean,ListBean listBean
			,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
	
		String role_id=request.getParameter("role_id");
		String json=request.getParameter("json");
		
		System.out.print(json+"===============================");
		
		List<ListBean> listBeans=new Gson().fromJson(json, new com.google.common.reflect.TypeToken<List<ListBean>>() {}.getType());
		int num=systemService.saveRoleList(listBeans,role_id);
		if(num>0){
			WriteMsg(response, "添加成功");
		}else{
			WriteError(response, "添加失败");
		}
	}
	
	
	
	/**
	 * 添加列表所要展示的字段
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertSystemDetailShow", method = RequestMethod.POST)
	public void insertSystemDetailShow(MerchantsAccountBean merchantsAccountBean,DetailBean detailBean
			,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
	
		int num=systemService.insertSystemDetailShow(detailBean);
		if(num>0){
			WriteMsg(response, "添加成功");
		}else{
			WriteError(response, "添加失败");
		}
	}
	
	/**
	 *修改列表所要展示的字段
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateSystemDetailShow", method = RequestMethod.POST)
	public void updateSystemDetailShow(MerchantsAccountBean merchantsAccountBean,DetailBean detailBean
			,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=systemService.updateSystemDetailShow(detailBean);
		if(num>0){
			WriteMsg(response, "修改成功");
		}else{
			WriteError(response, "修改失败");
		}
	}
	
	
	/**
	 * 删除列表所要展示的类型
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteSystemDetailShow", method = RequestMethod.POST)
	public void deleteSystemDetailShow(MerchantsAccountBean merchantsAccountBean,DetailBean detailBean
			,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=systemService.deleteSystemDetailShow(detailBean);
		if(num>0){
			WriteMsg(response, "删除成功");
		}else{
			WriteError(response, "删除失败");
		}
	}
	
	
	
	/**
	 * 添加列表所要展示的字段
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertSystemListShow", method = RequestMethod.POST)
	public void insertSystemListShow(MerchantsAccountBean merchantsAccountBean,ListBean listBean
			,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
	
		int num=systemService.insertSystemListShow(listBean);
		if(num>0){
			WriteMsg(response, "添加成功");
		}else{
			WriteError(response, "添加失败");
		}
	}
	
	/**
	 *修改列表所要展示的字段
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateSystemListShow", method = RequestMethod.POST)
	public void updateSystemListShow(MerchantsAccountBean merchantsAccountBean,ListBean listBean
			,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=systemService.updateSystemListShow(listBean);
		if(num>0){
			WriteMsg(response, "修改成功");
		}else{
			WriteError(response, "修改失败");
		}
	}
	
	
	/**
	 * 删除列表所要展示的类型
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteSystemListShow", method = RequestMethod.POST)
	public void deleteSystemListShow(MerchantsAccountBean merchantsAccountBean,ListBean listBean
			,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=systemService.deleteSystemListShow(listBean);
		if(num>0){
			WriteMsg(response, "删除成功");
		}else{
			WriteError(response, "删除失败");
		}
	}
	
	
	
	/**
	 * 获得详情页所要展示的字段
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getSystemDetailShows", method = RequestMethod.POST)
	public void getSystemDetailShows(MerchantsAccountBean merchantsAccountBean,DetailBean detailBean
			,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response,"{"+ StringUtils.join(systemService.getSystemDetailShows(detailBean).toArray(), ",")+"}");
	}
	/**
	 * 添加列表所要展示的字段
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertSystemListType", method = RequestMethod.POST)
	public void insertSystemListType(MerchantsAccountBean merchantsAccountBean,ListTypeBean listTypeBean
			,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		ListTypeBean listTypeBean2=systemService.getOneSystemListType(listTypeBean);
		if(listTypeBean2!=null){
			WriteError(response, "此键值已存在");
			return;
		}
		
		int num=systemService.insertSystemListType(listTypeBean);
		if(num>0){
			WriteMsg(response, "添加成功");
		}else{
			WriteError(response, "添加失败");
		}
	}
	
	/**
	 *修改列表所要展示的字段
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateSystemListType", method = RequestMethod.POST)
	public void updateSystemListType(MerchantsAccountBean merchantsAccountBean,ListTypeBean listTypeBean
			,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
//		ListTypeBean listTypeBean2=systemService.getOneSystemListType(listTypeBean);
//		if(listTypeBean2!=null){
//			WriteError(response, "此键值已存在");
//			return;
//		}
		
		int num=systemService.updateSystemListType(listTypeBean);
		if(num>0){
			WriteMsg(response, "修改成功");
		}else{
			WriteError(response, "修改失败");
		}
	}
	
	
	/**
	 * 删除列表所要展示的类型
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteSystemListType", method = RequestMethod.POST)
	public void deleteSystemListType(MerchantsAccountBean merchantsAccountBean,ListTypeBean listTypeBean
			,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=systemService.deleteSystemListType(listTypeBean);
		if(num>0){
			WriteMsg(response, "删除成功");
		}else{
			WriteError(response, "删除失败");
		}
	}
	/**
	 * 获得列表所要展示的字段
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getSystemListTypes", method = RequestMethod.POST)
	public void getSystemListTypes(MerchantsAccountBean merchantsAccountBean,ListTypeBean listTypeBean
			,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		WriteObject(response, systemService.getSystemListTypes(listTypeBean,pageBean),pageBean.getTotal());
	}
	
	/**
	 * 获得列表所要展示的字段
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getSystemListTypesNoPage", method = RequestMethod.POST)
	public void getSystemListTypesNoPage(MerchantsAccountBean merchantsAccountBean,ListTypeBean listTypeBean
			,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		WriteObject(response, systemService.getSystemListTypesNoPage(listTypeBean));
	}
	/**
	 * 获得列表所要展示的字段
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getSystemDetailShowsPage", method = RequestMethod.POST)
	public void getSystemDetailShows(MerchantsAccountBean merchantsAccountBean,DetailBean detailBean
			,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		WriteObject(response, systemService.getSystemDetailShowsPage(detailBean,pageBean),pageBean.getTotal());
	}
	
	/**
	 * 获得列表所要展示的字段
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getSystemListShowsPage", method = RequestMethod.POST)
	public void getSystemListShowsPage(MerchantsAccountBean merchantsAccountBean,ListBean listBean
			,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		WriteObject(response, systemService.getSystemListShowsPage(listBean,pageBean),pageBean.getTotal());
	}
	
	
	
	
	/**
	 * 获得列表所要展示的字段
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getSystemListShowsV2", method = RequestMethod.POST)
	public void getSystemListShowsV2(MerchantsAccountBean merchantsAccountBean,ListBean listBean
			,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		MerchantsAccountBean merchantsAccountBean2=systemService.verTokenV2(merchantsAccountBean);
		if(merchantsAccountBean2==null){
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, systemService.getSystemListShowsV2(listBean.setRole_id(merchantsAccountBean2.getRole_id())));
	}
	
	/**
	 * 获得列表所要展示的字段
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getSystemListShowsNoPage", method = RequestMethod.POST)
	public void getSystemListShowsNoPage(MerchantsAccountBean merchantsAccountBean,ListBean listBean
			,PageBean pageBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		WriteObject(response, systemService.getSystemListShowsNoPage(listBean));
	}
	
	/**
	 * 获得列表所要展示的字段
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getSystemListShows", method = RequestMethod.POST)
	public void getSystemListShows(MerchantsAccountBean merchantsAccountBean,ListBean listBean
			,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		WriteObject(response, systemService.getSystemListShows(listBean));
	}
	
	
	
	
	
	/**
	 * 获得所有模块列表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getAllMoudle", method = RequestMethod.POST)
	public void getAllMoudle(MerchantsAccountBean merchantsAccountBean,MoudleBean moudleBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		WriteObject(response, systemService.getAllMoudle(moudleBean));
	}
	
	/**
	 * 通过父ID 获得模块列表
	 * @param moudleBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getAllMoudleByParentId", method = RequestMethod.POST)
	public void getAllMoudleByParentId(MerchantsAccountBean merchantsAccountBean,MoudleBean moudleBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, systemService.getAllMoudleByParentId(moudleBean));
	}
	
	/**
	 * 删除模块
	 * @param moudleBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteMoudle", method = RequestMethod.POST)
	public void deleteMoudle(MerchantsAccountBean merchantsAccountBean,MoudleBean moudleBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=systemService.deleteMoudle(moudleBean);
		if(num>0){
			WriteMsg(response, "删除成功");
		}else{
			WriteError(response, "删除失败");
		}
	}
	
	/**
	 * 添加模块
	 * @param moudleBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertMoudle", method = RequestMethod.POST)
	public void insertMoudle(MerchantsAccountBean merchantsAccountBean,MoudleBean moudleBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		UUID uuid=UUID.randomUUID();
		int num=systemService.insertMoudle(moudleBean.setMoudle_uuid(uuid.toString()));
		if(num>0){
			WriteMsg(response, "添加成功");
		}else{
			WriteError(response, "添加失败");
		}
	}
	
	/**
	 * 修改模块
	 * @param moudleBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateMoudle", method = RequestMethod.POST)
	public void updateMoudle(MerchantsAccountBean merchantsAccountBean,MoudleBean moudleBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=systemService.updateMoudle(moudleBean);
		if(num>0){
			WriteMsg(response, "修改成功");
		}else{
			WriteError(response, "修改失败");
		}
	}
	
	
	/**
	 * 所有角色列表
	 * @param moudleBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getAllRole", method = RequestMethod.POST)
	public void getAllRole(MerchantsAccountBean merchantsAccountBean,RoleBean roleBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, systemService.getAllRole(roleBean));	
	}
	
	/**
	 * 添加角色
	 * @param roleBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertRole", method = RequestMethod.POST)
	public void insertRole(MerchantsAccountBean merchantsAccountBean,RoleBean roleBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=systemService.insertRole(roleBean);
		if(num>0){
			WriteMsg(response, "添加成功");
		}else{
			WriteError(response, "添加失败");
		}
	}
	/**
	 * 修改角色
	 * @param roleBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateRole", method = RequestMethod.POST)
	public void updateRole(MerchantsAccountBean merchantsAccountBean,RoleBean roleBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=systemService.updateRole(roleBean);
		if(num>0){
			WriteMsg(response, "修改成功");
		}else{
			WriteError(response, "修改失败");
		}
	}
	
	/**
	 * 删除角色
	 * @param roleBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteRole", method = RequestMethod.POST)
	public void deleteRole(MerchantsAccountBean merchantsAccountBean,RoleBean roleBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=systemService.deleteRole(roleBean);
		if(num>0){
			WriteMsg(response, "删除成功");
		}else{
			WriteError(response, "删除失败");
		}
	}
	
	/**
	 * 角色所拥有权限
	 * @param roleBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getAuthorityByRole", method = RequestMethod.POST)
	public void getAuthorityByRole(MerchantsAccountBean merchantsAccountBean,MoudleBean moudleBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, systemService.getAuthorityByRole(moudleBean.setParent_id("-1")));
	}
	/**
	 * 分配角色权限
	 * @param roleBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateRoleAuthority", method = RequestMethod.POST)
	public void updateRoleAuthority(MerchantsAccountBean merchantsAccountBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		String json=request.getParameter("json");
		MoudleBean moudleBean=new Gson().fromJson(json, MoudleBean.class);
		
		int num=systemService.updateRoleAuthority(moudleBean);
		if(num>0){
			WriteMsg(response, "修改成功");			
		}else{
			WriteError(response, "修改失败");			
		}
	}
	
	/**
	 * 系统所有账号
	 * @param roleBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "getMerchantsAccountSystem", method = RequestMethod.POST)
	public void getMerchantsAccountSystem(MerchantsAccountBean merchantsAccountBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		WriteObject(response, systemService.getMerchantsAccountSystem(merchantsAccountBean));
	}	
	
	/**
	 * 添加系统账号
	 * @param roleBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "insertMerchantsAccount", method = RequestMethod.POST)
	public void insertMerchantsAccount(MerchantsAccountBean merchantsAccountBean,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		MerchantsAccountBean merchantsAccountBean2=systemService.getMerchantsAccount(merchantsAccountBean);
		if(merchantsAccountBean2!=null){
			WriteError(response, "此账号已注册");
			return;
		}
		
		String pas=MD5Util.md5Encode(merchantsAccountBean.getPassword());
		int num=systemService.insertMerchantsAccount(merchantsAccountBean.setPassword(pas));
		
		if(num>0){
			WriteMsg(response, "添加成功");
		}else{
			WriteError(response, "添加失败");
		}
	}	
	
	/**
	 * 修改系统账号信息
	 * @param roleBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateMerchantsAccount", method = RequestMethod.POST)
	public void updateMerchantsAccount(MerchantsAccountBean merchantsAccountBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		String new_password=request.getParameter("new_password");
		String is_no_origin_password=request.getParameter("is_no_origin_password");//是否不需要原始密码
		String new_pas="";

		if("1".equals(is_no_origin_password)){
			new_pas=MD5Util.md5Encode(new_password);
		}else{
			String pas=MD5Util.md5Encode(merchantsAccountBean.getPassword());	
			if(new_password!=null){
				MerchantsAccountBean merchantsAccountBean2=systemService.getMerchantsAccountById(merchantsAccountBean);
				if(merchantsAccountBean2==null){
					WriteError(response, "此账号已被删除");
					return;
				}
				
				if(!merchantsAccountBean2.getPassword().equals(pas)){
					WriteError(response, "原密码错误");
					return; 
				}
				new_pas=MD5Util.md5Encode(new_password);
			}
		}
				
		int num=systemService.updateMerchantsAccount(merchantsAccountBean.setPassword(new_pas));
		if(num>0){
			WriteMsg(response, "修改成功");
		}else{
			WriteError(response, "修改失败");
		}
	}	
	
	/**
	 * 修改系统账号信息
	 * @param roleBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "updateMerchantsAccountDetail", method = RequestMethod.POST)
	public void updateMerchantsAccountDetail(MerchantsAccountBean merchantsAccountBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=systemService.updateMerchantsAccount(merchantsAccountBean);
		if(num>0){
			WriteMsg(response, "修改成功");
		}else{
			WriteError(response, "修改失败");
		}
	}	
	/**
	 * 修改系统账号
	 * @param roleBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "deleteMerchantsAccount", method = RequestMethod.POST)
	public void deleteMerchantsAccount(MerchantsAccountBean merchantsAccountBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(!systemService.verToken(merchantsAccountBean)){
			WritePending(response, "token failed");
			return;
		}
		
		int num=systemService.deleteMerchantsAccount(merchantsAccountBean);
		if(num>0){
			WriteMsg(response, "删除成功");
		}else{
			WriteError(response, "删除失败");
		}
	}	
	
	/**
	 * 系统账号登录
	 * @param roleBean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(params = "merchantsLogin", method = RequestMethod.POST)
	public void merchantsLogin(MerchantsAccountBean merchantsAccountBean,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String pas=MD5Util.md5Encode(merchantsAccountBean.getPassword());
		MerchantsAccountBean merchantsAccountBean2=systemService.merchantsLogin(merchantsAccountBean.setPassword(pas));
		if(merchantsAccountBean2==null){
			WriteError(response, "账号密码不匹配");
		}else{
			String uuid=UUID.randomUUID().toString();
			int num=systemService.updateToken(merchantsAccountBean2.setMerchants_token(uuid));
			if(num>0){
				WriteObject(response, merchantsAccountBean2.setMerchants_token(uuid));	
			}else{
				WriteError(response, "更新token失败");
			}
		}
	}

}
