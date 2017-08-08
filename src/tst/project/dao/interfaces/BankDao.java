package tst.project.dao.interfaces;

import java.util.List;

import tst.project.bean.member.BankBean;
import tst.project.page.PageBean;

public interface BankDao {
	/**
	 * 银行卡列表
	 * @param bankBean
	 * @param pageBean
	 * @return
	 */
	public BankBean getOneMemberBank(BankBean bankBean);
	
	/**
	 * 用户银行卡列表
	 * @param bankBean
	 * @param pageBean
	 * @return
	 */
	public List<BankBean> getMemberBanks(BankBean bankBean,PageBean pageBean);
	
	/**
	 * 用户添加银行卡信息
	 * @param bankBean
	 * @return
	 */
	public int insertMemberBank(BankBean bankBean);
	
	/**
	 * 用户更新银行卡信息
	 * @param bankBean
	 * @return
	 */
	public int updateMemberBank(BankBean bankBean);
	
	
	/**
	 * 用户设置默认银行卡
	 * @param bankBean
	 * @return
	 */
	public int updateMemberDefaultBank(BankBean bankBean);
	
	
	/**
	 * 用户删除银行卡
	 * @param bankBean
	 * @return
	 */
	public int deleteMemberBank(BankBean bankBean);
	
	/**
	 * 用户默认银行卡
	 * @param bankBean
	 * @return
	 */
	public BankBean getMemberDefaultBank(BankBean bankBean);
}
