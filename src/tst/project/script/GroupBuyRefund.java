package tst.project.script;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.pingplusplus.Pingpp;
import com.pingplusplus.model.Charge;
import com.pingplusplus.model.Refund;

import tst.project.bean.order.OrderBean;
import tst.project.utils.JDBCUtils;
import tst.project.utils.NumberUtils;
import org.apache.commons.codec.binary.Base64;
/**
 * 团购失败退款
 * 
 * @author shenjiabo
 *
 */
public class GroupBuyRefund {
	
	public String getPath(){
		return getClass().getResource("/").getFile().toString()+"/rsa_private_key.pem";
	}
	public static void main(String[] args) {
		Connection conn=null;	
		String url = "jdbc:mysql://127.0.0.1:3306/shop_ssp";
		String sql="select a.* from tst_group_buy as a "
				+ "inner join tst_group_buy_member as b "
				+ "on a.member_group_buy_id=b.member_group_buy_id "
				+ "and b.is_delete='0' and now()>b.end_time "
				+ "inner join tst_group_buy_goods as c "
				+ "on b.goods_group_buy_id=c.goods_group_buy_id "
				+ "and c.is_delete='0' and  CONVERT(c.group_buy_need_people,double)>CONVERT(b.group_buy_now_people,double) "
				+ "where a.group_buy_state='wait_send'";
		try {
			conn = JDBCUtils.startConn(conn,url);
			Statement st = (Statement) conn.createStatement();// 创建sql执行对象
			ResultSet rs = (ResultSet) st.executeQuery(sql);// 执行sql语句并返回结果集	
			while(rs.next()) {  				
			    
			    Statement st3=(Statement) conn.createStatement();
				  //System.out.println(rs.getString("group_buy_id")+"---"+rs.getString("order_id"));

				  //System.out.println(num+"==="+h);
				
				Statement st2=(Statement) conn.createStatement();
				ResultSet rs2=(ResultSet) st2.executeQuery("select * from tst_order where order_id = "+rs.getString("order_id")+" ");
				while(rs2.next()) {  					
					try{
						Pingpp.apiKey = "sk_live_vLu9eDuXH0mDy1SerT5mLe9C";
						Pingpp.privateKeyPath = new GroupBuyRefund().getPath();			
						
						Charge ch = Charge.retrieve(rs2.getString("order_pay_no"));//ch_id 是已付款的订单号
					    Map<String, Object> refundMap = new HashMap<String, Object>();
					    refundMap.put("amount", NumberUtils.Float(rs2.getString("order_actual_price"))*100);//rs2.getString("order_total_price")*100
					    refundMap.put("description", "退款");
					    Refund re = ch.getRefunds().create(refundMap);	
					    						
						int num=st3.executeUpdate(" update tst_group_buy set group_buy_state='refund' where group_buy_id = "+rs.getString("group_buy_id")+" ");
						int h=st3.executeUpdate(" update tst_order set order_state='cancel' where order_id="+rs.getString("order_id")+" ");
					}catch(Exception e){
						
					}
				}
		}  
			JDBCUtils.closeConn(rs,st, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	
	public void a(){
		
	}
}
