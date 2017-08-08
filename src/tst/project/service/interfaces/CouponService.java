package tst.project.service.interfaces;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.bean.member.CouponBean;
import tst.project.dao.interfaces.CouponDao;
import tst.project.page.PageBean;

@Service
@Transactional(rollbackFor = Exception.class)
public class CouponService {
	@Resource
	CouponDao couponDao;
	
	/**
	 * 单个优惠卷详情
	 * @return
	 */
	public CouponBean getOneCoupon(CouponBean couponBean){
		return couponDao.getOneCoupon(couponBean);
	}
	
	
	
	/**
	 * 可领取优惠卷列表
	 * @return
	 */
	public List<CouponBean> getReceiceCoupons(CouponBean couponBean){
		return couponDao.getReceiceCoupons(couponBean);
	}
	
	/**
	 * 可领取优惠卷列表
	 * @return
	 */
	public List<CouponBean> getReceiceCoupons(CouponBean couponBean,PageBean pageBean){
		return couponDao.getReceiceCoupons(couponBean,pageBean);
	}
	/**
	 * 用户领取优惠卷
	 * @return
	 */
	public int memberReceiveCoupon(CouponBean couponBean){
		return couponDao.memberReceiveCoupon(couponBean);
	}
	
	/**
	 * 获得用户领取的一张优惠卷
	 * @param couponBean
	 * @return
	 */
	public CouponBean getCouponByMemberIdAndCouponId(CouponBean couponBean){
		return couponDao.getCouponByMemberIdAndCouponId(couponBean);
	}
	/**
	 * 用户的优惠卷列表
	 * @param couponBean
	 * @return
	 */
	public List<CouponBean> getCoupons(CouponBean couponBean,PageBean pageBean){
		return couponDao.getCoupons(couponBean,pageBean);
	}
	
	/**
	 * 用户的优惠卷列表
	 * @param couponBean
	 * @return
	 */
	public Map getCouponsCount(CouponBean couponBean){
		return couponDao.getCouponsCount(couponBean);
	}
	/**
	 * 优惠卷用完 更新优惠卷状态
	 * @param couponBean
	 * @return
	 */	
	public int updateCouponState(CouponBean couponBean){
		return couponDao.updateCouponState(couponBean);
	}
	/**
	 * 获得用户使用的某张优惠券
	 * @param couponBean
	 * @return
	 */
	public CouponBean getCouponByMemberCouponId(CouponBean couponBean){
		return couponDao.getCouponByMemberCouponId(couponBean);
	}
}
