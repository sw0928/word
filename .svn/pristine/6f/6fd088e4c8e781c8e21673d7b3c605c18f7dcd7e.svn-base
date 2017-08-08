package tst.project.dao.interfaces;

import java.util.List;

import tst.project.bean.member.SignBean;
import tst.project.bean.member.SignStatisticsBean;

public interface SignDao {
	/**
	 * 当月签到列表
	 * @param signBean
	 * @return
	 */
	public List<SignBean> getMonthSigns(SignBean signBean);
	/**
	 * 签到列表
	 * @param signBean
	 * @return
	 */
	public List<SignBean> getSigns(SignBean signBean);
	/**
	 * 用户签到
	 * @param signBean
	 * @return
	 */
	public int insertSign(SignBean signBean);
	/**
	 * 当月签到统计
	 * @param signBean
	 * @return
	 */
	public SignStatisticsBean getMonthSignStatistics(SignBean signBean);
	/**
	 * 当天的签到信息
	 * @param signBean
	 * @return
	 */
	public SignBean getSignToday(SignBean signBean);
}
