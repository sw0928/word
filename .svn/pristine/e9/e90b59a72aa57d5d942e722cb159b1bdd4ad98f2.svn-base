package tst.project.dao.controller;

import java.util.List;

import tst.project.bean.distribution.DistributionBean;
import tst.project.bean.distribution.TotalDistributionBean;
import tst.project.bean.goods.CardBean;
import tst.project.bean.member.MemberBean;
import tst.project.page.PageBean;

public interface DistributionDao {
	/**
	 * 平台统计
	 * @param memberBean
	 * @return
	 */
	public DistributionBean exportAllDistributon1(DistributionBean distributionBean);
	/**
	 * 平台统计
	 * @param memberBean
	 * @return
	 */
	public List<Object> exportAllDistributon(DistributionBean distributionBean);
	
	/**
	 * vip用户导出
	 * @param memberBean
	 * @return
	 */
	public List<Object> exportDistributionsExcel(MemberBean memberBean);
	
	/**
	 * 不是未vip用户导出
	 * @param memberBean
	 * @return
	 */
	public List<Object> exportUnDistributionsExcel(MemberBean memberBean);
	
	public TotalDistributionBean getTotalDistributionsCount(TotalDistributionBean totalDistributionBean);
	/**
	 * 平台未获得佣金
	 * @param memberBean
	 * @param pageBean
	 * @return
	 */
	public TotalDistributionBean getTotalUnDistributionsCount(TotalDistributionBean totalDistributionBean);
	
	/**
	 * 未获得佣金
	 * @param memberBean
	 * @param pageBean
	 * @return
	 */
	public List<DistributionBean> getUnDistributions1(MemberBean memberBean,PageBean pageBean);
	
	public List<Object> exportUnDistributions1(MemberBean memberBean);
	public List<Object> exportUnDistributions2(MemberBean memberBean);
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
	public TotalDistributionBean getUnDistributionsCount1(MemberBean memberBean);
	
	/**
	 * 未获得佣金数
	 * @param memberBean
	 * @param pageBean
	 * @return
	 */
	public TotalDistributionBean getUnDistributionsCount2(MemberBean memberBean);
	
	public List<Object> exportDistributions1(MemberBean memberBean);
	public List<Object> exportDistributions2(MemberBean memberBean);
	/**
	 * 用户的分销余额详情
	 * @param distributionBean
	 * @return
	 */
	public List<DistributionBean> getDistributions(DistributionBean distributionBean,PageBean pageBean);
	
	public float getDistributionsCount(DistributionBean distributionBean);

	/**
	 * 收益列表
	 * @param distributionBean
	 * @return
	 */
	public List<DistributionBean> getProfits(DistributionBean distributionBean,PageBean pageBean);
	
	/**
	 * 获得分销卡列表
	 * @return
	 */
	public List<CardBean> getCardGoodss(CardBean cardBean,PageBean pageBean);
	
	/**
	 * 删除分销卡（特殊商品）
	 * @param cardBean
	 * @return
	 */
	public int deleteCardGoods(CardBean cardBean);
	
	/**
	 * 添加分销卡（特殊商品）
	 * @param cardBean
	 * @return
	 */
	public int insertCardGoods(CardBean cardBean);
}
