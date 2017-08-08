package tst.project.dao.interfaces;

import java.util.List;

import tst.project.bean.distribution.DistributionBean;
import tst.project.bean.distribution.TotalDistributionBean;
import tst.project.bean.finance.CashApplyBean;
import tst.project.bean.goods.CardBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.order.OrderBean;
import tst.project.page.PageBean;

public interface ZSSGDao {
	/**
	 * 未获得佣金
	 * @param memberBean
	 * @param pageBean
	 * @return
	 */
	public List<DistributionBean> getUnDistributions1(MemberBean memberBean,PageBean pageBean);
	
	
	/**
	 * 未获得佣金
	 * @param memberBean
	 * @param pageBean
	 * @return
	 */
	public List<DistributionBean> getUnDistributions2(MemberBean memberBean,PageBean pageBean);
	
	
	/**
	 * 未获得佣金数
	 * @param memberBean
	 * @param pageBean
	 * @return
	 */
	public float getUnDistributionsCount1(MemberBean memberBean);
	
	/**
	 * 未获得佣金数
	 * @param memberBean
	 * @param pageBean
	 * @return
	 */
	public float getUnDistributionsCount2(MemberBean memberBean);
	
	
	/**
	 * 申请提现
	 * @return
	 */
	public List<CashApplyBean> getApplyCashs(CashApplyBean cashApplyBean,PageBean pageBean);
	
	/**
	 * 申请提现
	 * @return
	 */
	public int applyCash(CashApplyBean cashApplyBean);
	
	/**
	 * 用户的分销余额详情
	 * @param distributionBean
	 * @return
	 */
	public List<DistributionBean> getDistributions(DistributionBean distributionBean,PageBean pageBean);
	
	public float getDistributionsCount(DistributionBean distributionBean);
	
	/**
	 * 获得某个卡的详情
	 * @return
	 */
	public CardBean getCardDetail(CardBean cardBean);
	
	/**
	 * 更新卡的使用状态
	 * @return
	 */
	public int updateCardState(CardBean cardBean);
	/**
	 * 分销分钱
	 * @return
	 */
	public int insertDistribution(DistributionBean distributionBean);
	/**
	 * 订单详情
	 * @param orderBean
	 * @return
	 */
	public OrderBean getOrderDetail(OrderBean orderBean);
	
	/**
	 * svip下单
	 * @param orderBean
	 * @return
	 */
	public int insertOrder(OrderBean orderBean);

	/**
	 * 付款之后 更新订单状态
	 * @param orderBean
	 * @return
	 */
	public int payOrder(OrderBean orderBean);
	
}
