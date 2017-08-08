package tst.project.service.interfaces;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.bean.distribution.DistributionBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.order.OrderBean;
import tst.project.dao.interfaces.DistributionDaoI;
import tst.project.page.PageBean;

@Service
@Transactional(rollbackFor = Exception.class)
public class DistributionServiceI {
	@Resource
	DistributionDaoI distributionDaoI;
	
	/**
	 * 分销下 会员列表统计
	 * @param memberBean
	 * @return
	 */
	public Map getDistributionMembersCount(MemberBean memberBean){
		return distributionDaoI.getDistributionMembersCount(memberBean);
	}
	/**
	 * 分销下 会员列表
	 * @param memberBean
	 * @return
	 */
	public List<MemberBean> getDistributionMembers(MemberBean memberBean,PageBean pageBean){
		return distributionDaoI.getDistributionMembers(memberBean, pageBean);
	}
	
	/**
	 * 分销下 订单列表
	 * @param memberBean
	 * @return
	 */
	public List<OrderBean> getDistributionOrders(DistributionBean distributionBean,PageBean pageBean){
		return distributionDaoI.getDistributionOrders(distributionBean, pageBean);
	}
}
