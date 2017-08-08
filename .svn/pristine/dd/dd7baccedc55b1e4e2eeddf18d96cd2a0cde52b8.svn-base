package tst.project.service.interfaces;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.constraints.Pattern.Flag;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tst.project.bean.distribution.DistributionBean;
import tst.project.bean.distribution.TotalDistributionBean;
import tst.project.bean.finance.CashApplyBean;
import tst.project.bean.goods.CardBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.order.OrderBean;
import tst.project.bean.others.PercentBean;
import tst.project.dao.interfaces.ZSSGDao;
import tst.project.page.PageBean;
import tst.project.utils.NumberUtils;
import tst.project.utils.TimeUtils;
@Service
@Transactional(rollbackFor = Exception.class)
public class ZSSGService {
	@Resource ZSSGDao zssgDao;
	
	@Resource
	OthersService othersService;
	
	@Resource
	MemberService memberService;
	
	@Resource
	OrderService orderService;
	
	/**
	 * 未获得佣金
	 * @param memberBean
	 * @param pageBean
	 * @return
	 */
	public List<DistributionBean> getUnDistributions(MemberBean memberBean,String type,PageBean pageBean){
		if("1".equals(type)){
			return zssgDao.getUnDistributions1(memberBean, pageBean);			
		}else{
			return zssgDao.getUnDistributions2(memberBean, pageBean);
		}
	}
	
	
	/**
	 * 未获得佣金
	 * @param memberBean
	 * @param pageBean
	 * @return
	 */
	public TotalDistributionBean getUnDistributionsCount(MemberBean memberBean,String type,PageBean pageBean){
		TotalDistributionBean totalDistributionBean=new TotalDistributionBean();
		float price=0;
		if("1".equals(type)){
			 price=zssgDao.getUnDistributionsCount1(memberBean);
		}else{
			price=zssgDao.getUnDistributionsCount2(memberBean);
		}
		totalDistributionBean.setTotal_price(price);
		totalDistributionBean.setDistributionBeans(getUnDistributions(memberBean,type,pageBean));			
		return totalDistributionBean;
	}
	
	/**
	 * 申请提现
	 * @return
	 */
	public List<CashApplyBean> getApplyCashs(CashApplyBean cashApplyBean,PageBean pageBean){
		return zssgDao.getApplyCashs(cashApplyBean,pageBean);
	}
	
	/**
	 * 申请提现
	 * @return
	 */
	public int applyCash(CashApplyBean cashApplyBean){
		return zssgDao.applyCash(cashApplyBean);
	}
	
	/**
	 * 用户的分销余额详情
	 * @param distributionBean
	 * @return
	 */
	public List<DistributionBean> getDistributions(DistributionBean distributionBean,PageBean pageBean){
		return zssgDao.getDistributions(distributionBean,pageBean);
	}
	
	public TotalDistributionBean getDistributionsCount(DistributionBean distributionBean,PageBean pageBean){
		TotalDistributionBean totalDistributionBean=new TotalDistributionBean();
		totalDistributionBean.setTotal_price(zssgDao.getDistributionsCount(distributionBean));
		totalDistributionBean.setDistributionBeans(getDistributions(distributionBean,pageBean));
		return totalDistributionBean;
	}
	/**
	 * 分销分钱
	 * @return
	 */
	public int insertDistribution(DistributionBean distributionBean){
		return zssgDao.insertDistribution(distributionBean);
	}
	/**
	 * 订单详情
	 * @param orderBean
	 * @return
	 */
	public OrderBean getOrderDetail(OrderBean orderBean){
		return zssgDao.getOrderDetail(orderBean);
	}
	/**
	 * svip下单
	 * @param orderBean
	 * @return
	 */
	public int insertOrder(OrderBean orderBean){
		String order_no=TimeUtils.getCurrentTime("yyyyMMddHHmmss");
		return zssgDao.insertOrder(orderBean.setOrder_no(order_no).setOrder_total_price("180"));
	}	
	/**
	 * 付款之后 更新订单状态
	 * @param orderBean
	 * @return
	 * @throws Exception 
	 */
	public int payOrder(CardBean cardBean) throws Exception{	
		PercentBean percentBean1=othersService.getPercent(new PercentBean().setPercent_type("vip1"));
		PercentBean percentBean2=othersService.getPercent(new PercentBean().setPercent_type("vip2"));
		
		MemberBean memberBean=memberService.getMemberByIDZSSG(new MemberBean().setMember_id(Integer.valueOf(cardBean.getMember_id())));
		float distribution_price1=0;
		float distribution_price2=0;
		
		if("goods".equals(cardBean.getCard_type())){//是商品分销 收费的
//			if(memberBean!=null){
//				if(!"".equals(memberBean.getFill_invitation_code())){//是别人推荐过来的
//					MemberBean memberBean2=memberService.getMemberByInvitation_codeZSSG(new MemberBean().
//							setInvitation_code(memberBean.getFill_invitation_code()));
//					if(memberBean2!=null){
//						distribution_price1=Float.valueOf(cardBean.getCard_price())*Float.valueOf(percentBean1.getPercent_value())/100;
//						int m=insertDistribution(new DistributionBean()
//								.setMember_id(memberBean2.getMember_id()+"")
//								.setDistribution_percent(percentBean1.getPercent_value())
//								.setDistribution_price(NumberUtils.KeepDecimal(distribution_price1, 2)+"")
//								.setDistribution_relation("vip1")
//								.setOrder_id(cardBean.getCard_code()+"")
//								.setDistribution_type("card")
//								.setUser_id(memberBean.getMember_id()+""));
//						if(m<=0){
//							throw new Exception("一级分配失败");
//						}
//						
//						
//						double price=Float.valueOf(memberBean2.getBalance())+NumberUtils.KeepDecimal(distribution_price1, 2);
//						int num=memberService.updateMemberDetailZSSG(new MemberBean()
//								.setMember_id(memberBean2.getMember_id())
//								.setBalance(price+""));
//						if(num<=0){
//							throw new Exception("用户更新失败");
//						}
//						
//						if(!"".equals(memberBean2.getFill_invitation_code())){//有二级分销的人
//							MemberBean memberBean3=memberService.getMemberByInvitation_codeZSSG(new MemberBean().
//									setInvitation_code(memberBean2.getFill_invitation_code()));
//							
//							if(memberBean3!=null){
//								distribution_price2=Float.valueOf(cardBean.getCard_price())*Float.valueOf(percentBean2.getPercent_value())/100;
//								int h=insertDistribution(new DistributionBean()
//										.setMember_id(memberBean3.getMember_id()+"")
//										.setDistribution_percent(percentBean2.getPercent_value())
//										.setDistribution_price(NumberUtils.KeepDecimal(distribution_price2, 2)+"")
//										.setDistribution_relation("vip2")
//										.setOrder_id(cardBean.getCard_code()+"")
//										.setDistribution_type("card")
//										.setUser_id(memberBean.getMember_id()+""));	
//								if(h<=0){
//									throw new Exception("二级分配失败");
//								}
//								
//								int hhh=memberService.updateMemberDetailZSSG(new MemberBean()
//										.setMember_id(memberBean3.getMember_id())
//										.setBalance((Float.valueOf(memberBean3.getBalance())+NumberUtils.KeepDecimal(distribution_price2, 2))+""));
//								if(hhh<=0){
//									throw new Exception("用户更新失败");
//								}
//							}	
//							
//							
//						}	
//					}
//					
//				}
//			}	
			
			float distribution_price=Float.valueOf(cardBean.getCard_price())-distribution_price1-distribution_price2;
			int h=insertDistribution(new DistributionBean()
					.setMember_id("-1")
					.setDistribution_percent("")
					.setDistribution_price(NumberUtils.KeepDecimal(distribution_price, 2)+"")
					.setDistribution_relation("-1")
					.setOrder_id(cardBean.getCard_code()+"")
					.setDistribution_type("card")
					.setUser_id(memberBean.getMember_id()+""));	
			if(h<=0){
				throw new Exception("平台分配失败");
			}
		}

		
		long vip_start_time=0;
		long vip_end_time=0;
		
		if(memberBean.getIndate()!=0&&memberBean.getIndate()*1000>System.currentTimeMillis()){//之前的vip还未过期			
			vip_start_time=memberBean.getCviptime();
			vip_end_time=TimeUtils.getMisDayAfter(new Date(memberBean.getIndate()*1000),
					Integer.valueOf(cardBean.getValid_time()))/1000;
		}else{
			vip_start_time=Long.parseLong(String.valueOf(System.currentTimeMillis()).toString().substring(0,10));
			vip_end_time=TimeUtils.getMisDayAfter(new Date(vip_start_time*1000), 
					Integer.valueOf(cardBean.getValid_time()))/1000;
		}
		
		int num=memberService.updateMemberDetailZSSG(new MemberBean()
				.setMember_id(memberBean.getMember_id())
				.setCviptime(vip_start_time)
				.setIndate(vip_end_time)
				.setIs_vip("1")
				.setUser_rank("11"));
	
		if(num<=0){
			throw new Exception("vip更新失败");
		}
		
	    num=zssgDao.updateCardState(cardBean);
	    if(num<=0){
			throw new Exception("卡状态更新失败");
		}
		return num;
	}

	/**
	 * 获得某个卡的详情
	 * @return
	 */
	public CardBean getCardDetail(CardBean cardBean){
		return zssgDao.getCardDetail(cardBean);
	}
	/**
	 * 更新卡的使用状态
	 * @return
	 */
	public int updateCardState(CardBean cardBean){
		return zssgDao.updateCardState(cardBean);
	}
	
	/**
	 * 付款之后 更新订单状态
	 * @param orderBean
	 * @return
	 * @throws Exception 
	 */
	public int payOrder(OrderBean orderBean) throws Exception{	
		PercentBean percentBean1=othersService.getPercent(new PercentBean().setPercent_type("vip1"));
		PercentBean percentBean2=othersService.getPercent(new PercentBean().setPercent_type("vip2"));
		
		MemberBean memberBean=memberService.getMemberByIDZSSG(new MemberBean().setMember_id(Integer.valueOf(orderBean.getMember_id())));
		float distribution_price1=0;
		float distribution_price2=0;
		
		if(memberBean!=null){
			if(!"".equals(memberBean.getFill_invitation_code())){//是别人推荐过来的
				MemberBean memberBean2=memberService.getMemberByInvitation_codeZSSG(new MemberBean().
						setInvitation_code(memberBean.getFill_invitation_code()));
				if(memberBean2!=null){
					distribution_price1=Float.valueOf(orderBean.getOrder_total_price())*Float.valueOf(percentBean1.getPercent_value())/100;
					int m=insertDistribution(new DistributionBean()
							.setMember_id(memberBean2.getMember_id()+"")
							.setDistribution_percent(percentBean1.getPercent_value())
							.setDistribution_price(NumberUtils.KeepDecimal(distribution_price1, 2)+"")
							.setDistribution_relation("vip1")
							.setOrder_id(orderBean.getOrder_id()+"")
							.setDistribution_type("order")
							.setUser_id(memberBean.getMember_id()+""));
					if(m<=0){
						throw new Exception("一级分配失败");
					}
					
					//throw new Exception(memberBean2.getMember_id()+"==="+Float.valueOf(memberBean2.getBalance())+NumberUtils.KeepDecimal(distribution_price1, 2));

					int hhh=memberService.updateMemberDetailZSSG(new MemberBean()
							.setMember_id(memberBean2.getMember_id())
							.setUser_money(memberBean2.getUser_money()+NumberUtils.KeepDecimal(distribution_price1, 2)));
					if(hhh<=0){
						throw new Exception("用户更新失败");
					}	
					
					if(!"".equals(memberBean2.getFill_invitation_code())){//有二级分销的人
						MemberBean memberBean3=memberService.getMemberByInvitation_codeZSSG(new MemberBean().
								setInvitation_code(memberBean2.getFill_invitation_code()));
					
						if(memberBean3!=null){
							distribution_price2=Float.valueOf(orderBean.getOrder_total_price())*Float.valueOf(percentBean2.getPercent_value())/100;
							int h=insertDistribution(new DistributionBean()
									.setMember_id(memberBean3.getMember_id()+"")
									.setDistribution_percent(percentBean2.getPercent_value())
									.setDistribution_price(NumberUtils.KeepDecimal(distribution_price2, 2)+"")
									.setDistribution_relation("vip2")
									.setOrder_id(orderBean.getOrder_id()+"")
									.setDistribution_type("order")
									.setUser_id(memberBean.getMember_id()+""));	
							if(h<=0){
								throw new Exception("二级分配失败");
							}
						
							int gggg=memberService.updateMemberDetailZSSG(new MemberBean()
									.setMember_id(memberBean3.getMember_id())
									.setUser_money(memberBean3.getUser_money()+NumberUtils.KeepDecimal(distribution_price2, 2)));
							if(gggg<=0){
								throw new Exception("用户更新失败");
							}
						}	
					}	
				}
				
			}
		}	
		
		float distribution_price=Float.valueOf(orderBean.getOrder_total_price())-distribution_price1-distribution_price2;
		int h=insertDistribution(new DistributionBean()
				.setMember_id("-1")
				.setDistribution_percent("")
				.setDistribution_price(NumberUtils.KeepDecimal(distribution_price, 2)+"")
				.setDistribution_relation("-1")
				.setOrder_id(orderBean.getOrder_id()+"")
				.setDistribution_type("order")
				.setUser_id(memberBean.getMember_id()+""));	
		if(h<=0){
			throw new Exception("平台分配失败");
		}
	
		long vip_start_time=0;
		long vip_end_time=0;
		
		if(memberBean.getIndate()!=0&&memberBean.getIndate()*1000>System.currentTimeMillis()){//之前的vip还未过期			
			vip_start_time=memberBean.getCviptime();
			vip_end_time=TimeUtils.getMisDayAfter(new Date(memberBean.getIndate()*1000),
					Integer.valueOf(orderBean.getValid_time()))/1000;
		}else{
			vip_start_time=Long.parseLong(String.valueOf(System.currentTimeMillis()).toString().substring(0,10));
			vip_end_time=TimeUtils.getMisDayAfter(new Date(vip_start_time*1000), 
					Integer.valueOf(orderBean.getValid_time()))/1000;
		}
		
		int num=memberService.updateMemberDetailZSSG(new MemberBean()
				.setMember_id(memberBean.getMember_id())
				.setCviptime(vip_start_time)
				.setIndate(vip_end_time)
				.setIs_vip("1")
				.setUser_rank("11"));
		
		if(num<=0){
			throw new Exception("vip更新失败");
		}
		return zssgDao.payOrder(orderBean);
	}

}
