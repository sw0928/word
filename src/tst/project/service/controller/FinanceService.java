package tst.project.service.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.constraints.Pattern.Flag;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.bean.finance.CashApplyBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.merchants.MerchantsAccountBean;
import tst.project.bean.merchants.MerchantsBean;
import tst.project.dao.controller.FinanceDao;
import tst.project.page.PageBean;
import tst.project.service.interfaces.MemberService;
import tst.project.utils.NumberUtils;

@Service
@Transactional(rollbackFor = Exception.class)
public class FinanceService {
	@Resource
	FinanceDao financeDao;
	
	@Resource
	MemberServiceC memberServicec;
	
	@Resource
	MerchantsService merchantsService;
	/**
	 * 提现列表
	 * @param cashApplyBean
	 * @return
	 */
	public List<CashApplyBean> getCashApplys(CashApplyBean cashApplyBean,PageBean pageBean){
		List<CashApplyBean> cashApplyBeans=financeDao.getCashApplys(cashApplyBean,pageBean);
		if(cashApplyBeans != null){
			for (int i = 0; i < cashApplyBeans.size(); i++) {
				CashApplyBean cashApplyBean2=cashApplyBeans.get(i);
				if("merchants".equals(cashApplyBean2.getCash_type())){
					MerchantsBean  merchantsBean=merchantsService
							.getOneMerchantsDetail(new MerchantsBean().setMerchants_id(Integer.valueOf(cashApplyBean2.getMerchants_id())));
					cashApplyBean2.setMerchantsBean(merchantsBean);
				}else if("extend".equals(cashApplyBean2.getCash_type())){
					MerchantsAccountBean merchantsAccountBean=merchantsService
							.getOneMerchantsAccountByID(new MerchantsAccountBean().setMerchants_account_id(cashApplyBean2.getMerchants_account_id()));
					cashApplyBean2.setMerchantsAccountBean(merchantsAccountBean);
				}
			}
		}
		return cashApplyBeans;
	}
	/**
	 * 申请提现
	 * @param cashApplyBean
	 * @return
	 */
	public int applyCash(CashApplyBean cashApplyBean){
		return financeDao.applyCash(cashApplyBean);
	}
	
	/**
	 * 审核申请
	 * @param cashApplyBean
	 * @return
	 * @throws Exception 
	 */
	public int updateApplyState(CashApplyBean cashApplyBean) throws Exception{		
		CashApplyBean cashApplyBean2=financeDao.getOneApply(cashApplyBean);
		if("end".equals(cashApplyBean.getApply_state())&&"member".equals(cashApplyBean2.getCash_type())){
			MemberBean memberBean=memberServicec.
					getOneMemberDetail(new MemberBean().setMember_id(Integer.valueOf(cashApplyBean2.getMerchants_id())));
			double balance=NumberUtils.Double(memberBean.getBalance())-Float.valueOf(cashApplyBean2.getCash_price());
			if(balance<0){
				throw new Exception("余额不足");
			}
			int h=memberServicec.updateMemberDetail(new MemberBean()
					.setMember_id(Integer.valueOf(cashApplyBean2.getMerchants_id()))
					.setBalance(balance+""));
			if(h<=0){
				throw new Exception("用户余额更新失败");
			}
		}else if("end".equals(cashApplyBean.getApply_state())&&"merchants".equals(cashApplyBean2.getCash_type())){
			MerchantsBean merchantsBean=merchantsService
					.getOneMerchantsDetail(new MerchantsBean().setMerchants_id(Integer.valueOf(cashApplyBean2.getMerchants_id())));
			
			double balance=merchantsBean.getBalance()-Float.valueOf(cashApplyBean2.getCash_price());
			double used_balance=merchantsBean.getUsed_balance()+Float.valueOf(cashApplyBean2.getCash_price());

			if(balance<0){
				throw new Exception("余额不足");
			}
			
			int h=merchantsService.updateMerchantDetail(new MerchantsBean()
					.setMerchants_id(Integer.valueOf(cashApplyBean2.getMerchants_id()))
					.setBalance(balance)
					.setUsed_balance(used_balance));
			if(h<=0){
				throw new Exception("用户余额更新失败");
			}
		}else if("end".equals(cashApplyBean.getApply_state())&&"extand".equals(cashApplyBean2.getCash_type())){
			MerchantsAccountBean merchantsAccountBean=merchantsService
					.getOneMerchantsAccountByID(new MerchantsAccountBean()
							.setMerchants_account_id(Integer.valueOf(cashApplyBean.getMerchants_account_id())));
			
			double balance=merchantsAccountBean.getBalance()-Float.valueOf(cashApplyBean2.getCash_price());
			if(balance<0){
				throw new Exception("余额不足");
			}
			
			int h=merchantsService.updateMerchantsAccount(new MerchantsAccountBean()
					.setMerchants_account_id(Integer.valueOf(cashApplyBean2.getMerchants_account_id()))
					.setBalance(balance==0?-1:balance));
			
			if(h<=0){
				throw new Exception("用户余额更新失败");
			}
		}
		
		int num=financeDao.updateApplyState(cashApplyBean);
		if(num<=0){
			throw new Exception("状态更新失败");
		}
		return num;
	}
	/**
	 * 获得所有的提现申请
	 * @param cashApplyBean
	 * @param pageBean
	 * @return
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	public List<CashApplyBean> getAllCashApplys(CashApplyBean cashApplyBean,PageBean pageBean) throws NumberFormatException, Exception{
		List<CashApplyBean> cashApplyBeans=financeDao.getAllCashApplys(cashApplyBean,pageBean);
		if(cashApplyBeans != null){
			for (int i = 0; i < cashApplyBeans.size(); i++) {
				CashApplyBean cashApplyBean2=cashApplyBeans.get(i);
				if("merchants".equals(cashApplyBean2.getCash_type())){
					MerchantsBean  merchantsBean=merchantsService
							.getOneMerchantsDetail(new MerchantsBean().setMerchants_id(Integer.valueOf(cashApplyBean2.getMerchants_id())));
					cashApplyBean2.setMerchantsBean(merchantsBean);
				}else if("member".equals(cashApplyBean2.getCash_type())){
					MemberBean  memberBean=memberServicec
							.getOneMemberDetail(new MemberBean().setMember_id(Integer.valueOf(cashApplyBean2.getMerchants_id())));
					cashApplyBean2.setMemberBean(memberBean);
				}else if("extend".equals(cashApplyBean2.getCash_type())){
					MerchantsAccountBean merchantsAccountBean=merchantsService
							.getOneMerchantsAccountByID(new MerchantsAccountBean()
									.setMerchants_account_id(cashApplyBean2.getMerchants_account_id()));
					cashApplyBean2.setMerchantsAccountBean(merchantsAccountBean);
				}
			}
		}
		return cashApplyBeans;
		//return financeDao.getAllCashApplys(cashApplyBean, pageBean);
	}
	
	/**
	 * 获得所有的用户提现申请
	 * @param cashApplyBean
	 * @param pageBean
	 * @return
	 */
	public List<CashApplyBean> getAllCashApplysMember(CashApplyBean cashApplyBean,PageBean pageBean){
		return financeDao.getAllCashApplysMember(cashApplyBean, pageBean);
	}
	
	/**
	 * 获得所有的用户提现申请
	 * @param cashApplyBean
	 * @param pageBean
	 * @return
	 */
	public List<CashApplyBean> getAllCashApplysMemberZSSG(CashApplyBean cashApplyBean,PageBean pageBean){
		return financeDao.getAllCashApplysMemberZSSG(cashApplyBean, pageBean);
	}
}
