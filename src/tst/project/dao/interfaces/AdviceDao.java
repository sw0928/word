package tst.project.dao.interfaces;

import tst.project.bean.others.AdviceBean;
import tst.project.bean.others.AdviceImgBean;

public interface AdviceDao {
	/**
	 * 提交建议或者投诉
	 * @param adviceBean
	 * @return
	 */
	public int insertAdvice(AdviceBean adviceBean);
	
	/**
	 * 提交建议或者投诉的图片
	 * @param adviceBean
	 * @return
	 */
	public int insertAdviceImg(AdviceImgBean adviceImgBean);
}
