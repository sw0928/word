package tst.project.service.interfaces;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.bean.member.BankBean;
import tst.project.dao.interfaces.BankDao;
import tst.project.page.PageBean;

@Service
@Transactional(rollbackFor = Exception.class)
public class BankService {
	@Resource
	BankDao bankDao;
	
	/**
	 * 银行卡列表
	 * @param bankBean
	 * @param pageBean
	 * @return
	 */
	public BankBean getOneMemberBank(BankBean bankBean){
		return bankDao.getOneMemberBank(bankBean);
	}
	
	/**
	 * 银行卡列表
	 * @param bankBean
	 * @param pageBean
	 * @return
	 */
	public List<BankBean> getMemberBanks(BankBean bankBean,PageBean pageBean){
		return bankDao.getMemberBanks(bankBean, pageBean);
	}
	
	
	/**
	 * 用户添加银行卡信息
	 * @param bankBean
	 * @return
	 */
	public int insertMemberBank(BankBean bankBean){
		BankBean bankBean2=getMemberDefaultBank(bankBean);
		if(bankBean2==null){
			bankBean.setIs_default("1");
		}else{
			bankBean.setIs_default("0");
		}
		return bankDao.insertMemberBank(bankBean);
	}
	
	/**
	 * 用户更新银行卡信息
	 * @param bankBean
	 * @return
	 */
	public int updateMemberBank(BankBean bankBean){
		return bankDao.updateMemberBank(bankBean);
	}
	
	
	/**
	 * 用户设置默认银行卡
	 * @param bankBean
	 * @return
	 */
	public int updateMemberDefaultBank(BankBean bankBean){
		return bankDao.updateMemberDefaultBank(bankBean);
	}
	
	
	/**
	 * 用户删除银行卡
	 * @param bankBean
	 * @return
	 * @throws Exception 
	 */
	public int deleteMemberBank(BankBean bankBean) throws Exception{
		int num=bankDao.deleteMemberBank(bankBean);
		if(num>0){
			BankBean bankBean2=getMemberDefaultBank(bankBean);
			if(bankBean2==null){//删除完 没有默认银行卡了
				List<BankBean> bankBeans=getMemberBanks(bankBean,new PageBean());
				if(bankBeans!=null&&bankBeans.size()>0){//还有银行卡
					int h=updateMemberDefaultBank(bankBeans.get(0));
					if(h<=0){
						throw new Exception("设置随机银行卡失败");
					}
				}
			}
		}
		return num;
	}
	
	/**
	 * 用户默认银行卡
	 * @param bankBean
	 * @return
	 */
	public BankBean getMemberDefaultBank(BankBean bankBean){
		return bankDao.getMemberDefaultBank(bankBean);
	}
}
