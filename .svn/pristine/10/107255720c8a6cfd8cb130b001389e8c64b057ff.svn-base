package tst.project.service.interfaces;

import tst.project.bean.member.MemberBean;
import tst.project.bean.order.BusinessProfitBean;
import tst.project.bean.order.OrderGoodsBean;
import tst.project.bean.others.PercentBean;
import tst.project.dao.interfaces.OrderDao;
import tst.project.utils.NumberUtils;

public class JFUtils {
	public static void insertProfit(OrderGoodsBean orderGoodsBean,MemberBean memberBean,double total_price,OthersService othersService,OrderDao orderDao) throws Exception{
		int num=-1;
		
		if(orderGoodsBean.getBusiness_id()!=null&&!"-1".equals(orderGoodsBean.getBusiness_id())){//此次购买的商户分成
			//float profit_price=Float.valueOf(orderGoodsBean.getGoods_price())*orderGoodsBean.getGoods_num();
			PercentBean percentBean2 = othersService.getPercent(new PercentBean().setPercent_type("merchants1"));
			double profit_price=NumberUtils.KeepDecimal(Float.valueOf(percentBean2.getPercent_value())*total_price/100, 2);	

			num=orderDao.insertBusinessProfit(new BusinessProfitBean()
					.setMember_id(memberBean.getMember_id())
					.setBusiness_id(Integer.valueOf(orderGoodsBean.getBusiness_id()))
					.setProfit_state("wait_pay")
					.setOrder_goods_id(orderGoodsBean.getOrder_goods_id())
					.setProfit_price(profit_price)
					.setProfit_type("1")
					.setPercent_value(percentBean2.getPercent_value()));
							
			if(num<0){
				throw new Exception("收益分配失败");
			}
			if(orderGoodsBean.getMerchants_account_id()!=null&&!"-1".equals(orderGoodsBean.getMerchants_account_id())){//推广员
				PercentBean percentBeanExtand = othersService.getPercent(new PercentBean().setPercent_type("extand"));
				if(percentBeanExtand!=null){
					double profit_priceExtand=NumberUtils
							.KeepDecimal(Float.valueOf(percentBeanExtand.getPercent_value())*total_price/100, 2);
					num=orderDao.insertBusinessProfit(new BusinessProfitBean()
							.setMember_id(memberBean.getMember_id())
							.setBusiness_id(Integer.valueOf(orderGoodsBean.getBusiness_id()))
							.setProfit_state("wait_pay")
							.setOrder_goods_id(orderGoodsBean.getOrder_goods_id())
							.setProfit_price(profit_priceExtand)
							.setProfit_type("3")
							.setPercent_value(percentBeanExtand.getPercent_value())
							.setMerchants_account_id(Integer.valueOf(orderGoodsBean.getMerchants_account_id())));
					if(num<0){
						throw new Exception("收益分配失败");
					}	
				}		
			}
							
			if(memberBean.getBusiness_id()!=null
					&&!orderGoodsBean.getBusiness_id().equals(memberBean.getBusiness_id())
					&&!"-1".equals(memberBean.getBusiness_id())){//如果用户归属店铺 不是当前店铺 则需要给归属店铺分成
				
				PercentBean percentBean3 = othersService.getPercent(new PercentBean().setPercent_type("merchants2"));
				double profit_price2=NumberUtils.KeepDecimal(Float.valueOf(percentBean3.getPercent_value())*total_price/100, 2);
				
				num=orderDao.insertBusinessProfit(new BusinessProfitBean()
						.setMember_id(memberBean.getMember_id())
						.setBusiness_id(Integer.valueOf(memberBean.getBusiness_id()))
						.setProfit_state("wait_pay")
						.setOrder_goods_id(orderGoodsBean.getOrder_goods_id())
						.setProfit_price(profit_price2)
						.setProfit_type("2")
						.setPercent_value(percentBean3.getPercent_value()));
				if(num<0){
					throw new Exception("收益分配失败");
				}
				
				if(memberBean.getMerchants_account_id()!=null&&!"-1".equals(memberBean.getMerchants_account_id())){//推广员
					PercentBean percentBeanExtand = othersService.getPercent(new PercentBean().setPercent_type("extand"));
					if(percentBeanExtand!=null){
						double profit_priceExtand=NumberUtils
								.KeepDecimal(Float.valueOf(percentBeanExtand.getPercent_value())*total_price/100, 2);
						num=orderDao.insertBusinessProfit(new BusinessProfitBean()
								.setMember_id(memberBean.getMember_id())
								.setBusiness_id(Integer.valueOf(memberBean.getBusiness_id()))
								.setProfit_state("wait_pay")
								.setOrder_goods_id(orderGoodsBean.getOrder_goods_id())
								.setProfit_price(profit_priceExtand)
								.setProfit_type("3")
								.setPercent_value(percentBeanExtand.getPercent_value())
								.setMerchants_account_id(Integer.valueOf(memberBean.getMerchants_account_id())));
						if(num<0){
							throw new Exception("收益分配失败");
						}	
					}		
				}
			}
		}else{//分成
			PercentBean percentBean3 = othersService.getPercent(new PercentBean().setPercent_type("merchants2"));
			if(percentBean3!=null){
				double profit_price2=NumberUtils.KeepDecimal(Float.valueOf(percentBean3.getPercent_value())*total_price/100, 2);
				
				if(memberBean.getBusiness_id()!=null&&!"-1".equals(memberBean.getBusiness_id())){//需要给归属店铺分成
					num=orderDao.insertBusinessProfit(new BusinessProfitBean()
							.setMember_id(memberBean.getMember_id())
							.setBusiness_id(Integer.valueOf(memberBean.getBusiness_id()))
							.setProfit_state("wait_pay")
							.setOrder_goods_id(orderGoodsBean.getOrder_goods_id())
							.setProfit_price(profit_price2)
							.setProfit_type("2")
							.setPercent_value(percentBean3.getPercent_value()));
					if(num<0){
						throw new Exception("收益分配失败");
					}
					
					if(memberBean.getMerchants_account_id()!=null&&!"-1".equals(memberBean.getMerchants_account_id())){//推广员
						PercentBean percentBeanExtand = othersService.getPercent(new PercentBean().setPercent_type("extand"));
						if(percentBeanExtand!=null){
							double profit_priceExtand=NumberUtils
									.KeepDecimal(Float.valueOf(percentBeanExtand.getPercent_value())*total_price/100, 2);
							num=orderDao.insertBusinessProfit(new BusinessProfitBean()
									.setMember_id(memberBean.getMember_id())
									.setBusiness_id(Integer.valueOf(memberBean.getBusiness_id()))
									.setProfit_state("wait_pay")
									.setOrder_goods_id(orderGoodsBean.getOrder_goods_id())
									.setProfit_price(profit_priceExtand)
									.setProfit_type("3")
									.setPercent_value(percentBeanExtand.getPercent_value())
									.setMerchants_account_id(Integer.valueOf(memberBean.getMerchants_account_id())));
							if(num<0){
								throw new Exception("收益分配失败");
							}	
						}		
					}
				}
			}		
		}						
	}
}
