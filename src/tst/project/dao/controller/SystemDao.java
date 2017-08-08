package tst.project.dao.controller;

import java.util.List;

import tst.project.bean.merchants.MerchantsAccountBean;
import tst.project.bean.system.DetailBean;
import tst.project.bean.system.ListBean;
import tst.project.bean.system.ListTypeBean;
import tst.project.bean.system.MoudleBean;
import tst.project.bean.system.RoleBean;
import tst.project.page.PageBean;

public interface SystemDao {
	 public int deleteRoleList(ListBean listBean);
	 
	 public int saveRoleList(List<ListBean> listBeans);
	 
	/**
	 * 添加列表
	 * @param listTypeBean
	 * @return
	 */
	public int insertSystemDetailShow(DetailBean detailBean);
	
	/**
	 * 修改列表
	 * @param listTypeBean
	 * @return
	 */
	public int updateSystemDetailShow(DetailBean detailBean);
	
	/**
	 * 删除列表
	 * @param listTypeBean
	 * @return
	 */
	public int deleteSystemDetailShow(DetailBean detailBean);
	
	/**
	 * 添加列表
	 * @param listTypeBean
	 * @return
	 */
	public int insertSystemListShow(ListBean listBean);
	
	/**
	 * 修改列表
	 * @param listTypeBean
	 * @return
	 */
	public int updateSystemListShow(ListBean listBean);
	/**
	 * 删除列表
	 * @param listTypeBean
	 * @return
	 */
	public int deleteSystemListShow(ListBean listBean);
	
	
	
	/**
	 * 单个列表类型
	 * @param listTypeBean
	 * @return
	 */
	public ListTypeBean getOneSystemListType(ListTypeBean listTypeBean);
	/**
	 * 添加列表类型
	 * @param listTypeBean
	 * @return
	 */
	public int insertSystemListType(ListTypeBean listTypeBean);
	/**
	 * 修改列表类型
	 * @param listTypeBean
	 * @return
	 */
	public int updateSystemListType(ListTypeBean listTypeBean);
	/**
	 * 删除列表类型
	 * @param listTypeBean
	 * @return
	 */
	public int deleteSystemListType(ListTypeBean listTypeBean);
	/**
	 * 获得详情页所要展示的字段
	 * @param detailBean
	 * @return
	 */
	public List<String> getSystemDetailShows(DetailBean detailBean);
	
	/**
	 * 获得列表索要展示的类型列表
	 * @param listBean
	 * @return
	 */
	public List<ListBean> getSystemListTypes(ListTypeBean listTypeBean,PageBean pageBean);
	/**
	 * 获得列表索要展示的类型列表
	 * @param listBean
	 * @return
	 */
	public List<ListBean> getSystemListTypesNoPage(ListTypeBean listTypeBean);
	/**
	 * 获得列表索要展示的字段
	 * @param listBean
	 * @return
	 */
	public List<ListBean> getSystemListShowsPage(ListBean listBean,PageBean pageBean);
	public List<ListBean> getSystemListShowsNoPage(ListBean listBean);
	
	public List<ListBean> getSystemListShowsV2(ListBean listBean);
	/**
	 * 获得详情所要展示的字段
	 * @param detailBean
	 * @param pageBean
	 * @return
	 */
	public List<DetailBean> getSystemDetailShowsPage(DetailBean detailBean,PageBean pageBean);
	/**
	 * 获得列表索要展示的字段
	 * @param listBean
	 * @return
	 */
	public List<ListBean> getSystemListShows(ListBean listBean);
	
	public List<MoudleBean> getAllMoudle(MoudleBean moudleBean);
	
	//通过模块父Id获得用户可管理模块
	public List<MoudleBean> getAllMoudleByParentId(MoudleBean moudleBean);
	
	/**
	 * 删除模块
	 * @param moudleBean
	 * @return
	 */
	public int deleteMoudle(MoudleBean moudleBean);
	
	/**
	 * 添加模块
	 * @param moudleBean
	 * @return
	 */
	public int insertMoudle(MoudleBean moudleBean);
	
	/**
	 * 修改模块
	 * @param moudleBean
	 * @return
	 */
	public int updateMoudle(MoudleBean moudleBean);
	
	/**
	 * 所有角色
	 * @return
	 */
	public List<RoleBean> getAllRole(RoleBean roleBean);
	
	/**
	 * 添加角色
	 * @param roleBean
	 * @return
	 */
	public int insertRole(RoleBean roleBean);
	
	/**
	 * 修改角色
	 * @param roleBean
	 * @return
	 */
	public int updateRole(RoleBean roleBean);
	
	/**
	 * 删除角色
	 * @param roleBean
	 * @return
	 */
	public int deleteRole(RoleBean roleBean);
	
	/**
	 * 获得角色拥有权限
	 * @param moudleBean
	 * @return
	 */
	public List<MoudleBean> getAuthorityByRole(MoudleBean moudleBean);
	
	/**
	 * 分配角色权限
	 * @param moudleBean
	 * @return
	 */
	public int updateRoleAuthority(MoudleBean moudleBean);
	
	/**
	 * 添加角色权限
	 * @param moudleBean
	 * @return
	 */
	public int insertRoleAuthority(MoudleBean moudleBean);
	
	/**
	 * 所有系统账号
	 * @param merchantsBean
	 * @return
	 */
	public List<MerchantsAccountBean> getMerchantsAccountSystem(MerchantsAccountBean merchantsAccountBean);
	
	/**
	 * 获得单个系统账号
	 * @param merchantsBean
	 * @return
	 */
	public MerchantsAccountBean getMerchantsAccount(MerchantsAccountBean merchantsAccountBean);
		
	/**
	 * 通过Id获得单个系统账号
	 * @param merchantsBean
	 * @return
	 */
	public MerchantsAccountBean getMerchantsAccountById(MerchantsAccountBean merchantsAccountBean);
	/**
	 * 添加系统账号
	 * @param merchantsBean
	 * @return
	 */
	public int insertMerchantsAccount(MerchantsAccountBean merchantsAccountBean);
	
	/**
	 * 修改系统账号
	 * @param merchantsBean
	 * @return
	 */
	public int updateMerchantsAccount(MerchantsAccountBean merchantsAccountBean);
	
	/**
	 * 删除系统账号
	 * @param merchantsBean
	 * @return
	 */
	public int deleteMerchantsAccount(MerchantsAccountBean merchantsAccountBean);
	
	/**
	 * 系统账号登录
	 * @param merchantsBean
	 * @return
	 */
	public MerchantsAccountBean merchantsLogin(MerchantsAccountBean merchantsAccountBean);
	/**
	 * 登录修改token
	 * @return
	 */
	public int updateToken(MerchantsAccountBean merchantsAccountBean);
	
	/**
	 * 验证token
	 * @param merchantsBean
	 * @return
	 */
	public MerchantsAccountBean verToken(MerchantsAccountBean merchantsAccountBean);
}
