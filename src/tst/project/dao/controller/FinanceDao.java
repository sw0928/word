package tst.project.dao.controller;

import java.util.List;

import tst.project.bean.finance.CashApplyBean;
import tst.project.page.PageBean;

public interface FinanceDao {
	/**
	 * 提现列表
	 * @param cashApplyBean
	 * @return
	 */
	public List<CashApplyBean> getCashApplys(CashApplyBean cashApplyBean,PageBean pageBean);
	
	/**
	 * 申请提现
	 * @param cashApplyBean
	 * @return
	 */
	public int applyCash(CashApplyBean cashApplyBean);
	
	/**
	 * 一个申请信息
	 * @param cashApplyBean
	 * @return
	 */
	public CashApplyBean getOneApply(CashApplyBean cashApplyBean);
	/**
	 * 审核申请
	 * @param cashApplyBean
	 * @return
	 */
	public int updateApplyState(CashApplyBean cashApplyBean);
	
	/**
	 * 获得所有的提现申请
	 * @param cashApplyBean
	 * @param pageBean
	 * @return
	 */
	public List<CashApplyBean> getAllCashApplys(CashApplyBean cashApplyBean,PageBean pageBean);
	
	/**
	 * 获得所有的用户提现申请
	 * @param cashApplyBean
	 * @param pageBean
	 * @return
	 */
	public List<CashApplyBean> getAllCashApplysMember(CashApplyBean cashApplyBean,PageBean pageBean);
	
	/**
	 * 获得所有的用户提现申请
	 * @param cashApplyBean
	 * @param pageBean
	 * @return
	 */
	public List<CashApplyBean> getAllCashApplysMemberZSSG(CashApplyBean cashApplyBean,PageBean pageBean);	
}

