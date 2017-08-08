package tst.project.dao.interfaces;

import java.util.List;
import java.util.Map;

import tst.project.bean.distribution.DistributionBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.order.OrderBean;
import tst.project.page.PageBean;

public interface DistributionDaoI {
	
	/**
	 * 分销下 会员列表统计
	 * @param memberBean
	 * @return
	 */
	public Map getDistributionMembersCount(MemberBean memberBean);
	
	/**
	 * 分销下 会员列表
	 * @param memberBean
	 * @return
	 */
	public List<MemberBean> getDistributionMembers(MemberBean memberBean,PageBean pageBean);
	
	/**
	 * 分销下 订单列表
	 * @param memberBean
	 * @return
	 */
	public List<OrderBean> getDistributionOrders(DistributionBean distributionBean,PageBean pageBean);
}
