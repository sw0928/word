package tst.project.dao.interfaces;

import tst.project.bean.others.CodeBean;
import tst.project.bean.others.VerificationBean;

public interface CodeDao {
	
	/**
	 * 短信平台设置
	 * @param verificationBean
	 * @return
	 */
	public VerificationBean getVerificationSetting(VerificationBean verificationBean);
	
	/**
	 * 根据验证码获得验证信息
	 * @return
	 */
	public CodeBean getCodeBeanByMobile(CodeBean codeBean);
	
	/**
	 * 添加新的验证码
	 * @param codeBean
	 * @return
	 */
	public int insertCode(CodeBean codeBean);
	
	/**
	 * 根据手机号和验证码获得验证码信息
	 * @param codeBean
	 * @return
	 */
	public CodeBean getCodeBeanByMobileAndCode(CodeBean codeBean);
	
	/**
	 * 验证码使用完后 删除
	 * @param codeBean
	 * @return
	 */
	public int deleteCodeByMobileAndCode(CodeBean codeBean);
}
