package tst.project.service.interfaces;

import tst.project.bean.distribution.DistributionBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.order.OrderBean;
import tst.project.bean.others.PercentBean;
import tst.project.dao.interfaces.OrderDao;
import tst.project.utils.NumberUtils;

public class DistributionUtils {
	public static void insertProfit(MemberBean memberBean, OrderBean orderBean, MemberService memberService,
			OthersService othersService, OrderDao orderDao) throws Exception {
		int num = -1;
		if (!"".equals(memberBean.getFill_invitation_code())) {// 别人邀请来的
			MemberBean memberBean2 = memberService.getMemberByInvitation_code(
					new MemberBean().setInvitation_code(memberBean.getFill_invitation_code()));
			if (memberBean2 != null) {
				PercentBean percentBean2 = othersService.getPercent(new PercentBean().setPercent_type("distribution1"));
				if(percentBean2!=null){
					num = orderDao.insertDistribution(new DistributionBean().setMember_id(memberBean2.getMember_id() + "")
							.setDistribution_percent(percentBean2.getPercent_value())
							.setDistribution_price(NumberUtils.KeepDecimal(Float.valueOf(orderBean.getOrder_total_price())*Float.valueOf(percentBean2.getPercent_value())/100, 2)+"")
							.setDistribution_relation("distribution1").setOrder_id(orderBean.getOrder_id() + "")
							.setDistribution_type("order").setUser_id(memberBean.getMember_id() + "")
							.setDistribution_state("wait_pay"));
					if (num <= 0) {
						throw new Exception("1级入库失败");
					}
				}
				if (!"".equals(memberBean2.getFill_invitation_code())) {
					MemberBean memberBean3 = memberService.getMemberByInvitation_code(
							new MemberBean().setInvitation_code(memberBean2.getFill_invitation_code()));
					if (memberBean3 != null&&"1".equals(memberBean3.getMember_level())) {
						PercentBean percentBean3 = othersService
								.getPercent(new PercentBean().setPercent_type("distribution2"));
						if (percentBean3 != null) {
							num = orderDao.insertDistribution(new DistributionBean()
									.setMember_id(memberBean3.getMember_id() + "")
									.setDistribution_percent(percentBean3.getPercent_value())
									.setDistribution_price(NumberUtils.KeepDecimal(Float.valueOf(orderBean.getOrder_total_price())*Float.valueOf(percentBean3.getPercent_value())/100,2)+"")
									.setDistribution_relation("distribution2").setOrder_id(orderBean.getOrder_id() + "")
									.setDistribution_type("order").setUser_id(memberBean.getMember_id() + "")
									.setDistribution_state("wait_pay"));
							if (num <= 0) {
								throw new Exception("2级入库失败");
							}
						}

					}
				}
			}

		}
	}

}
