package tst.project.service.controller;

import java.sql.Time;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.bean.member.CouponBean;
import tst.project.bean.member.MemberBean;
import tst.project.dao.controller.CouponDaoC;
import tst.project.page.PageBean;
import tst.project.utils.NumberUtils;
import tst.project.utils.TimeUtils;

@Service
@Transactional(rollbackFor = Exception.class)
public class CouponServiceC {
	@Resource
	CouponDaoC couponDaoC;
	
	@Resource
	MemberServiceC memberServiceC;
	
	/**
	 * 统计优惠卷
	 * @param couponBean
	 * @return
	 */
	public Map getCouponCount(CouponBean couponBean){
		return couponDaoC.getCouponCount(couponBean);
	}
	
	public int allocationAllCoupon(CouponBean couponBean) throws Exception{
		CouponBean couponBean2=couponDaoC.getOneCoupon(couponBean);
		if(couponBean2==null){
			throw new Exception("该优惠卷已过期或删除!");
		}
		
		int day=NumberUtils.Integer(couponBean2.getValid_day());
		String start_time=TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss");
		String end_time=TimeUtils.getTimeDayAfter("yyyy-MM-dd HH:mm:ss", start_time, day);
		int num=couponDaoC
				.allocationAllCoupon(couponBean.setStart_time(start_time)
											.setEnd_time(end_time));
		return num;
	}
	
	/**
	 * 分配优惠卷
	 * @param couponBean
	 * @param mobile
	 * @return
	 * @throws Exception 
	 */
	public int allocationCoupon(CouponBean couponBean,String[] mobile) throws Exception{
		CouponBean couponBean2=couponDaoC.getOneCoupon(couponBean);
		if(couponBean2==null){
			throw new Exception("该优惠卷已过期或删除!");
		}
		for (int i = 0; i < mobile.length; i++) {
			MemberBean memberBean=memberServiceC
					.getMemberByMobile(new MemberBean().setMember_account(mobile[i]));
			if(memberBean==null){
				throw new Exception(mobile[i]+"该账号不存在");
			}
			
			CouponBean couponBean3=couponDaoC.getCouponByMemberIdAndCouponId(couponBean.setMember_id(memberBean.getMember_id()+""));
			if(couponBean3!=null){
				throw new Exception(mobile[i]+"该账号已拥有该优惠卷");
			}
			
			int day=NumberUtils.Integer(couponBean2.getValid_day());
			String start_time=TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss");
			String end_time=TimeUtils.getTimeDayAfter("yyyy-MM-dd HH:mm:ss", start_time, day);
			int num=couponDaoC
					.allocationCoupon(couponBean.setMember_id(memberBean.getMember_id()+"")
												.setStart_time(start_time)
												.setEnd_time(end_time));
			if(num<=0){
				throw new Exception(mobile[i]+"该账号分配失败!");
			}
		}
		return 1;
	}
	/**
	 * 添加优惠卷
	 * @param couponBean
	 * @return
	 */
	public int insertCoupon(CouponBean couponBean){
		return couponDaoC.insertCoupon(couponBean);
	}
	
	/**
	 * 修改优惠卷
	 * @param couponBean
	 * @return
	 */
	public int updateCoupon(CouponBean couponBean){
		return couponDaoC.updateCoupon(couponBean);
	}
	
	
	/**
	 * 删除优惠卷
	 * @param couponBean
	 * @return
	 */
	public int deleteCoupon(CouponBean couponBean){
		return couponDaoC.deleteCoupon(couponBean);
	}
	
	/**
	 * 更新优惠卷状态
	 * @param couponBean
	 * @return
	 */
	public int updateCouponState(CouponBean couponBean){
		return couponDaoC.updateCouponState(couponBean);
	}
	
	/**
	 * 获得优惠卷列表
	 * @param couponBean
	 * @return
	 */
	public List<CouponBean> getCoupons(CouponBean couponBean,PageBean pageBean){
		return couponDaoC.getCoupons(couponBean, pageBean);
	}
}
