package tst.project.dao.controller;

import java.util.List;
import java.util.Map;

import tst.project.bean.member.MemberBean;
import tst.project.page.PageBean;

public interface MemberDaoC {
	
	/**
	 * 根据手机号获得用户信息
	 * @return
	 */
	public MemberBean getMemberByMobile(MemberBean memberBean);
	
	/**
	 * 根据储值卡号 获得用户信息
	 * @param memberBean
	 * @return
	 */
	public MemberBean getMemberByStore(MemberBean memberBean);
	/**
	 * 清除储值卡
	 * @param memberBean
	 * @return
	 */
	public int deleteMemberStored(MemberBean memberBean);
	
	/**
	 * 获得分销的用户列表
	 * @param memberBean
	 * @return
	 */
	public List<MemberBean> getDistributionMembers(MemberBean memberBean,PageBean pageBean);
	
	/**
	 * 修改用户详情
	 * @param memberBean
	 * @return
	 */
	public int updateMemberDetail(MemberBean memberBean);
	/**
	 * 修改用户详情
	 * @param memberBean
	 * @return
	 */
	public int updateMemberDetailZSSG(MemberBean memberBean);
	/**
	 * 单个用户详情
	 * @return
	 */
	public MemberBean getOneMemberDetail(MemberBean memberBean);
	

	/**
	 * 单个用户详情
	 * @return
	 */
	public MemberBean getOneMemberDetailZSSG(MemberBean memberBean);
	
	/**
	 * 导出用户信息
	 * @param memberBean
	 * @return
	 */
	public List<Map> exportMemberExcel(MemberBean memberBean);
	
	/**
	 * 获得所有普通用户信息
	 * @param memberBean
	 * @return
	 */
	public List<MemberBean> getAllMembers(MemberBean memberBean,PageBean pageBean);
	
	public Map getAllMembersCount(MemberBean memberBean);
	
	
	/**
	 * 获得所有普通用户信息
	 * @param memberBean
	 * @param pageBean
	 * @return
	 */
	public List<MemberBean> getAllMembersZSSG(MemberBean memberBean,PageBean pageBean);
	
}
