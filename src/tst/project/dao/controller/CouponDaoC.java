package tst.project.dao.controller;

import java.util.List;
import java.util.Map;

import tst.project.bean.member.CouponBean;
import tst.project.page.PageBean;

public interface CouponDaoC {
	/**
	 * 统计优惠卷
	 * @param couponBean
	 * @return
	 */
	public Map getCouponCount(CouponBean couponBean);
	public int allocationAllCoupon(CouponBean couponBean);
	/**
	 * 分配优惠卷
	 * @param couponBean
	 * @return
	 */
	public int allocationCoupon(CouponBean couponBean);
	/**
	 * 
	 * @param couponBean
	 * @return
	 */
	public CouponBean getCouponByMemberIdAndCouponId(CouponBean couponBean);
	/**
	 * 
	 * @return
	 */
	public CouponBean getOneCoupon(CouponBean couponBean);
	
	/**
	 * 添加优惠卷
	 * @param couponBean
	 * @return
	 */
	public int insertCoupon(CouponBean couponBean);
	
	/**
	 * 修改优惠卷
	 * @param couponBean
	 * @return
	 */
	public int updateCoupon(CouponBean couponBean);
	
	/**
	 * 删除优惠卷
	 * @param couponBean
	 * @return
	 */
	public int deleteCoupon(CouponBean couponBean);
	
	/**
	 * 更新优惠卷状态
	 * @param couponBean
	 * @return
	 */
	public int updateCouponState(CouponBean couponBean);
	
	/**
	 * 优惠卷列表
	 * @param couponBean
	 * @param pageBean
	 * @return
	 */
	public List<CouponBean> getCoupons(CouponBean couponBean,PageBean pageBean);

}
