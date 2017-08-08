package tst.project.script;

import java.util.List;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import tst.project.bean.merchants.MerchantsBean;
import tst.project.bean.order.BusinessProfitBean;
import tst.project.bean.order.OrderBean;
import tst.project.bean.order.OrderGoodsBean;
import tst.project.bean.others.PercentBean;
import tst.project.utils.JDBCUtils;
import tst.project.utils.NumberUtils;

public class MerchantsOrderProfit {
	public static void main(String[] args) {
		String url = "jdbc:mysql://127.0.0.1:3306/shop_ssp";
		Connection conn = null;
		String sql = "select a.* from tst_order as a " + "where (a.is_profit='0' or a.is_profit is null) "
				+ "and FIND_IN_SET(a.order_state,'wait_assessment,end') "
				+ "and TIMESTAMPDIFF(day,a.receive_time,now())>(select percent_value-1 from tst_percent where percent_type='profit')";
		try {
			conn = JDBCUtils.startConn(conn, url);
			String json = JDBCUtils.queryArray(conn, sql);
			List<OrderBean> orderBeans = new Gson().fromJson(json, new TypeToken<List<OrderBean>>() {
			}.getType());
			if (orderBeans != null) {
				for (int i = 0; i < orderBeans.size(); i++) {
					OrderBean orderBean = orderBeans.get(i);
					
					Statement st3 = (Statement) conn.createStatement();
					int num = st3.executeUpdate(
							" update tst_order set is_profit='1' " + "where order_id=" + orderBean.getOrder_id() + " ");
					if (num > 0) {
						String jsonaaa = JDBCUtils.queryObject(conn,
								" select * from tst_merchants where merchants_id=" + orderBean.getMerchants_id());
						MerchantsBean merchantsBean = new Gson().fromJson(jsonaaa, MerchantsBean.class);
						
						String percentJson = JDBCUtils.queryObject(conn," select percent_value from tst_percent where percent_type='order' ");
						PercentBean percentBean=new Gson().fromJson(percentJson, PercentBean.class);
												
						if (merchantsBean != null&&percentBean!=null) {
							double balance = Double.valueOf(orderBean.getOrder_total_price())-NumberUtils.
									KeepDecimal(Float.valueOf(orderBean.getOrder_total_price())*Float.valueOf(percentBean.getPercent_value())/100, 2);
							
							num = st3.executeUpdate(" update tst_merchants set balance = CONVERT(balance, double) + "
									+ balance + " where merchants_id =" + orderBean.getMerchants_id());
							if (num <= 0) {
								throw new Exception(" 余额更新失败 ");
							}
						} else {
						}
					}
				}
			}

			JDBCUtils.closeConn(null, null, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
