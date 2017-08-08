package tst.project.service.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.bean.goods.GoodsBean;
import tst.project.bean.merchants.MerchantsAccountBean;
import tst.project.bean.merchants.MerchantsBean;
import tst.project.bean.system.DetailBean;
import tst.project.bean.system.ListBean;
import tst.project.bean.system.ListTypeBean;
import tst.project.bean.system.MoudleBean;
import tst.project.bean.system.RoleBean;
import tst.project.dao.controller.SystemDao;
import tst.project.page.PageBean;

@Service
@Transactional(rollbackFor = Exception.class)
public class SystemService {
	@Resource
	SystemDao systemDao;
	
	 public int saveRoleList(List<ListBean> listBeans,String role_id){
		 int num=systemDao.deleteRoleList(new ListBean().setRole_id(role_id));
		 List<ListBean> listBeans2=new ArrayList<ListBean>();
		 if(listBeans!=null){
			 for (int i = 0; i < listBeans.size(); i++) {
				 ListBean listBean=listBeans.get(i);
				 if("1".equals(listBean.getList_state())){
					 listBean.setRole_id(role_id);
					 listBeans2.add(listBean);
				 }
			}
		 }
		 num=systemDao.saveRoleList(listBeans2);
		 return 1;
	 }
	
	/**
	 * 添加列表
	 * @param listTypeBean
	 * @return
	 */
	public int insertSystemDetailShow(DetailBean detailBean){
		return systemDao.insertSystemDetailShow(detailBean);
	}
	
	/**
	 * 修改列表
	 * @param listTypeBean
	 * @return
	 */
	public int updateSystemDetailShow(DetailBean detailBean){
		return systemDao.updateSystemDetailShow(detailBean);
	}
	
	/**
	 * 删除列表
	 * @param listTypeBean
	 * @return
	 */
	public int deleteSystemDetailShow(DetailBean detailBean){
		return systemDao.deleteSystemDetailShow(detailBean);
	}
	
	
	/**
	 * 添加列表
	 * @param listTypeBean
	 * @return
	 */
	public int insertSystemListShow(ListBean listBean){
		return systemDao.insertSystemListShow(listBean);
	}
	
	/**
	 * 修改列表
	 * @param listTypeBean
	 * @return
	 */
	public int updateSystemListShow(ListBean listBean){
		return systemDao.updateSystemListShow(listBean);
	}
	
	/**
	 * 删除列表
	 * @param listTypeBean
	 * @return
	 */
	public int deleteSystemListShow(ListBean listBean){
		return systemDao.deleteSystemListShow(listBean);
	}
	
	
	/**
	 * 单个列表类型
	 * @param listTypeBean
	 * @return
	 */
	public ListTypeBean getOneSystemListType(ListTypeBean listTypeBean){
		return systemDao.getOneSystemListType(listTypeBean);
	}
	/**
	 * 添加列表类型
	 * @param listTypeBean
	 * @return
	 */
	public int insertSystemListType(ListTypeBean listTypeBean){
		return systemDao.insertSystemListType(listTypeBean);
	}
	
	/**
	 * 修改列表类型
	 * @param listTypeBean
	 * @return
	 */
	public int updateSystemListType(ListTypeBean listTypeBean){
		return systemDao.updateSystemListType(listTypeBean);
	}
	
	/**
	 * 删除列表类型
	 * @param listTypeBean
	 * @return
	 */
	public int deleteSystemListType(ListTypeBean listTypeBean){
		return systemDao.deleteSystemListType(listTypeBean);
	}
	
	/**
	 * 获得详情页所要展示的字段
	 * @param detailBean
	 * @return
	 */
	public List<String> getSystemDetailShows(DetailBean detailBean){
		return systemDao.getSystemDetailShows(detailBean);
	}
	/**
	 * 获得列表索要展示的类型列表
	 * @param listBean
	 * @return
	 */
	public List<ListBean> getSystemListTypes(ListTypeBean listTypeBean,PageBean pageBean){
		return systemDao.getSystemListTypes(listTypeBean, pageBean);
	}
	
	/**
	 * 获得列表索要展示的类型列表
	 * @param listBean
	 * @return
	 */
	public List<ListBean> getSystemListTypesNoPage(ListTypeBean listTypeBean){
		return systemDao.getSystemListTypesNoPage(listTypeBean);
	}
	/**
	 * 获得列表索要展示的字段
	 * @param listBean
	 * @return
	 */
	public List<ListBean> getSystemListShowsPage(ListBean listBean,PageBean pageBean){
		return systemDao.getSystemListShowsPage(listBean,pageBean);
	}
	
	public List<ListBean> getSystemListShowsV2(ListBean listBean){
		return systemDao.getSystemListShowsV2(listBean);
	}
	
	public List<ListBean> getSystemListShowsNoPage(ListBean listBean){
		return systemDao.getSystemListShowsNoPage(listBean);
	}
	/**
	 * 获得详情所要展示的字段
	 * @param detailBean
	 * @param pageBean
	 * @return
	 */
	public List<DetailBean> getSystemDetailShowsPage(DetailBean detailBean,PageBean pageBean){
		return systemDao.getSystemDetailShowsPage(detailBean, pageBean);
	}
	/**
	 * 获得列表索要展示的字段
	 * @param listBean
	 * @return
	 */
	public List<ListBean> getSystemListShows(ListBean listBean){
		return systemDao.getSystemListShows(listBean);
	}
	
	// 获得用户可管理模块
	public List<MoudleBean> getAllMoudle(MoudleBean moudleBean) {
		List<MoudleBean> moudleBeans = systemDao.getAllMoudle(moudleBean);
		for (int i = 0; i < moudleBeans.size(); i++) {
			if (moudleBeans.get(i).getIs_end().equals("0")) {
				moudleBeans.get(i)
						.setMenuBeans(getAllMoudle(moudleBean.setParent_id(moudleBeans.get(i).getMoudle_id() + "")));
			}
			// List<MoudleBean>
			// moudleBeans1=systemDao.getAllMoudle(moudleBean.setParent_id(moudleBeans.get(i).getMoudle_id()+""));
			// moudleBeans.get(i).setMenuBeans(moudleBeans1);
		}
		return moudleBeans;
	}

	// 获得用户可管理模块
	public List<MoudleBean> getAllMoudleByParentId(MoudleBean moudleBean) {
		return systemDao.getAllMoudleByParentId(moudleBean);
	}

	/**
	 * 删除模块
	 * 
	 * @param moudleBean
	 * @return
	 */
	public int deleteMoudle(MoudleBean moudleBean) {
		return systemDao.deleteMoudle(moudleBean);
	}

	/**
	 * 添加模块
	 * 
	 * @param moudleBean
	 * @return
	 */
	public int insertMoudle(MoudleBean moudleBean) {
		return systemDao.insertMoudle(moudleBean);
	}

	/**
	 * 修改模块
	 * 
	 * @param moudleBean
	 * @return
	 */
	public int updateMoudle(MoudleBean moudleBean) {
		return systemDao.updateMoudle(moudleBean);
	}

	/**
	 * 所有角色
	 * 
	 * @return
	 */
	public List<RoleBean> getAllRole(RoleBean roleBean) {
		return systemDao.getAllRole(roleBean);
	}

	/**
	 * 添加角色
	 * 
	 * @param roleBean
	 * @return
	 */
	public int insertRole(RoleBean roleBean) {
		return systemDao.insertRole(roleBean);
	}

	/**
	 * 修改角色
	 * 
	 * @param roleBean
	 * @return
	 */
	public int updateRole(RoleBean roleBean) {
		return systemDao.updateRole(roleBean);
	}

	/**
	 * 删除角色
	 * 
	 * @param roleBean
	 * @return
	 */
	public int deleteRole(RoleBean roleBean) {
		return systemDao.deleteRole(roleBean);
	}

	/**
	 * 获得角色拥有权限
	 * 
	 * @param moudleBean
	 * @return
	 */
	public List<MoudleBean> getAuthorityByRole(MoudleBean moudleBean) {
		List<MoudleBean> moudleBeans = systemDao.getAuthorityByRole(moudleBean);
		for (int i = 0; i < moudleBeans.size(); i++) {
			List<MoudleBean> menuBeans = systemDao
					.getAuthorityByRole(moudleBean.setParent_id(moudleBeans.get(i).getMoudle_id() + ""));
			
			for (int j = 0; j < menuBeans.size(); j++) {
				List<MoudleBean> menuBeans3 = systemDao
						.getAuthorityByRole(moudleBean.setParent_id(menuBeans.get(j).getMoudle_id() + ""));
				menuBeans.get(j).setMenuBeans(menuBeans3);
			}
			moudleBeans.get(i).setMenuBeans(menuBeans);
		}
		return moudleBeans;
	}

	/**
	 * 分配角色权限
	 * 
	 * @param moudleBean
	 * @return
	 * @throws Exception
	 */
	public int updateRoleAuthority(MoudleBean moudleBean) throws Exception {
		systemDao.updateRoleAuthority(moudleBean);
		if(moudleBean.getIs_authority().equals("1")){
			int m = systemDao.insertRoleAuthority(moudleBean);
			if(m<=0){
				return -1;
			}
		}
		List<MoudleBean> moudleBeans = moudleBean.getMenuBeans();
		if (moudleBeans != null && moudleBeans.size() > 0) {
			insertMoudleBeans(moudleBean, moudleBeans);
		}
		return 1;
	}

	public int insertMoudleBeans(MoudleBean moudleBean, List<MoudleBean> moudleBeans) throws Exception {
		for (int i = 0; i < moudleBeans.size(); i++) {
			List<MoudleBean> menuBeans = moudleBeans.get(i).getMenuBeans();
			if (menuBeans != null && menuBeans.size() > 0) {
				insertMoudleBeans(moudleBean.setMoudle_id(moudleBeans.get(i).getMoudle_id()), menuBeans);
			}
			if (moudleBeans.get(i).getIs_authority().equals("1")) {
				int k = systemDao.insertRoleAuthority(moudleBeans.get(i));
				if (k < 0) {
					throw new Exception("权限添加失败");
				}
			}
		}
		return 1;
	}

	/**
	 * 所有系统账号
	 * 
	 * @param merchantsBean
	 * @return
	 */
	public List<MerchantsAccountBean> getMerchantsAccountSystem(MerchantsAccountBean merchantsAccountBean) {
		return systemDao.getMerchantsAccountSystem(merchantsAccountBean);
	}

	/**
	 * 获得单个系统账号
	 * 
	 * @param merchantsBean
	 * @return
	 */
	public MerchantsAccountBean getMerchantsAccount(MerchantsAccountBean merchantsAccountBean) {
		return systemDao.getMerchantsAccount(merchantsAccountBean);
	}
	/**
	 * 通过Id获得单个系统账号
	 * @param merchantsBean
	 * @return
	 */
	public MerchantsAccountBean getMerchantsAccountById(MerchantsAccountBean merchantsAccountBean){
		return systemDao.getMerchantsAccountById(merchantsAccountBean);
	}
	/**
	 * 添加系统账号
	 * 
	 * @param merchantsBean
	 * @return
	 */
	public int insertMerchantsAccount(MerchantsAccountBean merchantsAccountBean) {
		return systemDao.insertMerchantsAccount(merchantsAccountBean);
	}

	/**
	 * 修改系统账号
	 * 
	 * @param merchantsBean
	 * @return
	 */
	public int updateMerchantsAccount(MerchantsAccountBean merchantsAccountBean) {
		return systemDao.updateMerchantsAccount(merchantsAccountBean);
	}

	/**
	 * 删除系统账号
	 * 
	 * @param merchantsBean
	 * @return
	 */
	public int deleteMerchantsAccount(MerchantsAccountBean merchantsAccountBean) {
		return systemDao.deleteMerchantsAccount(merchantsAccountBean);
	}

	/**
	 * 系统账号登录
	 * 
	 * @param merchantsBean
	 * @return
	 */
	public MerchantsAccountBean merchantsLogin(MerchantsAccountBean merchantsAccountBean) {
		return systemDao.merchantsLogin(merchantsAccountBean);
	}

	/**
	 * 登录修改token
	 * 
	 * @return
	 */
	public int updateToken(MerchantsAccountBean merchantsAccountBean) {
		return systemDao.updateToken(merchantsAccountBean);
	}

	/**
	 * 验证token
	 * 
	 * @param merchantsBean
	 * @return
	 */
	public boolean verToken(MerchantsAccountBean merchantsAccountBean) {
		if (systemDao.verToken(merchantsAccountBean) == null) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * 验证token
	 * 
	 * @param merchantsBean
	 * @return
	 */
	public MerchantsAccountBean verTokenV2(MerchantsAccountBean merchantsAccountBean) {
		return systemDao.verToken(merchantsAccountBean);
	}
}
