package tst.project.script;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.Flags.Flag;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.pingplusplus.Pingpp;
import com.pingplusplus.model.Charge;
import com.pingplusplus.model.Refund;
import com.sun.org.apache.xpath.internal.operations.Or;

import tst.project.bean.distribution.DistributionBean;
import tst.project.bean.merchants.MerchantsAccountBean;
import tst.project.bean.order.BusinessProfitBean;
import tst.project.bean.order.OrderBean;
import tst.project.bean.order.OrderGoodsBean;
import tst.project.utils.JDBCUtils;

public class JFOrderProfit {
	
	public static void main(String[] args) {
		String url = "jdbc:mysql://127.0.0.1:3306/shop_jf";
		Connection conn=null;	
		String sql="select a.* from tst_order_goods as a inner join tst_order as b "
				+ "on a.order_id=b.order_id and (b.order_state='wait_assessment' or b.order_state='end') "
				+ "and TIMESTAMPDIFF(day,b.receive_time,now())>(select percent_value-1 from tst_percent where percent_type='profit')"
				+ "where a.is_profit='0'";
		try {
			conn = JDBCUtils.startConn(conn,url);
			String json=JDBCUtils.queryArray(conn, sql);
			List<OrderGoodsBean> orderGoodsBeans=new Gson().fromJson(json, new TypeToken<List<OrderGoodsBean>>() {}.getType());
			if(orderGoodsBeans!=null){
				for (int i = 0; i < orderGoodsBeans.size(); i++) {
					Statement st3=(Statement) conn.createStatement();					
					int num=st3.executeUpdate(" update tst_order_goods set is_profit='1' "
							+ "where order_goods_id="+orderGoodsBeans.get(i).getOrder_goods_id()+" ");
					if(num>0){
						num=st3.executeUpdate(" update tst_business_profit set profit_state='end' "
								+ "where order_goods_id="+orderGoodsBeans.get(i).getOrder_goods_id()+" ");
						if(num>0){
							String jsonaaa=JDBCUtils.queryArray(conn, "select * from tst_business_profit where order_goods_id="+orderGoodsBeans.get(i).getOrder_goods_id());
							List<BusinessProfitBean> businessProfitBeans=new Gson().fromJson(jsonaaa, 
									new TypeToken<List<BusinessProfitBean>>() {}.getType());
							if(businessProfitBeans!=null){
								for (int j = 0; j < businessProfitBeans.size(); j++) {
									BusinessProfitBean businessProfitBean=businessProfitBeans.get(j);
									if(businessProfitBean != null){
										if(businessProfitBean.getMerchants_account_id()!=0&&businessProfitBean.getMerchants_account_id()!=-1){
											double balance=businessProfitBean.getProfit_price();
											num=st3.executeUpdate(" update tst_merchants_account set balance = CONVERT(balance, double) + "+balance
													+" where merchants_account_id="+businessProfitBean.getMerchants_account_id());
											if(num<=0){
												throw new Exception(" 推广员余额更新失败 ");
											}
										}else if(businessProfitBean.getBusiness_id()!=0&&businessProfitBean.getBusiness_id()!=-1){
											double balance=businessProfitBean.getProfit_price();
											num=st3.executeUpdate(" update tst_merchants set balance = CONVERT(balance, double) + "+balance
													+" where merchants_id="+businessProfitBean.getBusiness_id());
											if(num<=0){
												throw new Exception(" 店铺余额更新失败 ");
											}
										}
									}
								}
							}
							
						}else{
						}	
					}
				}
			}
			
			JDBCUtils.closeConn(null,null, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	
}
