package tst.project.service.interfaces;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.bean.others.CodeBean;
import tst.project.bean.others.VerificationBean;
import tst.project.dao.interfaces.CodeDao;
@Service
@Transactional(rollbackFor = Exception.class)
public class CodeService {
	@Resource
	CodeDao codeDao;
	
	/**
	 * 短信平台设置
	 * @param verificationBean
	 * @return
	 */
	public VerificationBean getVerificationSetting(VerificationBean verificationBean){
		return codeDao.getVerificationSetting(verificationBean);
	}
	
	/**
	 * 根据验证码获得验证信息
	 * @return
	 */
	public CodeBean getCodeBeanByMobile(CodeBean codeBean){
		return codeDao.getCodeBeanByMobile(codeBean);
	}
	
	/**
	 * 添加新的验证码
	 * @param codeBean
	 * @return
	 */
	public int insertCode(CodeBean codeBean){
		return codeDao.insertCode(codeBean);
	}
	
	/**
	 * 根据手机号和验证码获得验证码信息
	 * @param codeBean
	 * @return
	 */
	public CodeBean getCodeBeanByMobileAndCode(CodeBean codeBean){
		return codeDao.getCodeBeanByMobileAndCode(codeBean);
	}
	
	/**
	 * 验证码使用完后 删除
	 * @param codeBean
	 * @return
	 */
	public int deleteCodeByMobileAndCode(CodeBean codeBean){
		return codeDao.deleteCodeByMobileAndCode(codeBean);
	}
}
