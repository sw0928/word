package tst.project.script;

import java.util.List;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import tst.project.bean.distribution.DistributionBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.merchants.MerchantsBean;
import tst.project.bean.order.OrderBean;
import tst.project.bean.others.PercentBean;
import tst.project.utils.JDBCUtils;
import tst.project.utils.NumberUtils;

public class HJDistributionProfit {
	public static void main(String[] args) {
		String url = "jdbc:mysql://139.196.178.64:3306/shop_hj";
		Connection conn = null;
		String sql = "select b.* from tst_order as a "
				+ "inner join tst_order_distribution as b on a.order_id=b.order_id "
				+ "and (b.is_profit='0' or b.is_profit is null) "
				+ "where  FIND_IN_SET(a.order_state,'wait_assessment,end') "
				+ "and TIMESTAMPDIFF(day,a.receive_time,now())>(select percent_value-1 from tst_percent where percent_type='profit')";
		try {
			conn = JDBCUtils.startConn(conn, url);
			String json = JDBCUtils.queryArray(conn, sql);
			List<DistributionBean> distributionBeans = new Gson().fromJson(json, new TypeToken<List<DistributionBean>>() {
			}.getType());

			if (distributionBeans != null) {
				for (int i = 0; i < distributionBeans.size(); i++) {
					DistributionBean distributionBean = distributionBeans.get(i);
					
					Statement st3 = (Statement) conn.createStatement();
					int num = st3.executeUpdate(" update tst_order_distribution set is_profit='1',distribution_state='end' " 
								+ "where distribution_id =" + distributionBean.getDistribution_id() + " ");
					if (num > 0) {
						String jsonaaa = JDBCUtils.queryObject(conn,
								" select * from tst_member where member_id=" + distributionBean.getMember_id());
						MemberBean memberBean = new Gson().fromJson(jsonaaa, MemberBean.class);

						if (memberBean != null&&memberBean!=null) {
							double balance = Double.valueOf(memberBean.getBalance())+NumberUtils.
									KeepDecimal(Float.valueOf(distributionBean.getDistribution_price()), 2);
							
							num = st3.executeUpdate(" update tst_member set balance = "+ balance 
									+ " where member_id =" + memberBean.getMember_id());
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
