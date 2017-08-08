package tst.project.script;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.pingplusplus.Pingpp;
import com.pingplusplus.model.Charge;
import com.pingplusplus.model.Refund;

import tst.project.utils.JDBCUtils;
import tst.project.utils.TimeUtils;

/**
 * 定时改价
 * @author shenjiabo
 *
 */
public class TimingUpdateGoodsPrice {
	public static void main(final String[] args) throws Exception {
		
		String modify_time1=args[0].substring(0, 10);
		String modify_time2=args[0].substring(10, 18);
		final String modify_time=modify_time1+" "+modify_time2;
		
		long minutes=TimeUtils.getMinCompareDate(modify_time, TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd HH:mm:ss");
		
		final ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

		Runnable runnable = new Runnable() {
			public void run() {	
				try {
					Connection conn=null;	
					String url = "jdbc:mysql://121.40.154.201:3306/shop_hbr";
					String sql="select * from tst_goods_timing where  modify_time = \""+modify_time+"\" and is_delete ='0' and timing_state='1' ";

					conn = JDBCUtils.startConn(conn,url);
					Statement st = (Statement) conn.createStatement();// 创建sql执行对象
					ResultSet rs = (ResultSet) st.executeQuery(sql);// 执行sql语句并返回结果集	
					while(rs.next()) { 
						System.out.println(rs.getString("goods_sku"));
					    Statement st3=(Statement) conn.createStatement();
						int num=st3.executeUpdate(" update tst_goods set goods_now_price="+rs.getString("goods_new_price")+" where goods_sku = "+rs.getString("goods_sku")+" ");
					}  
					JDBCUtils.closeConn(rs,st, conn);
					service.shutdown();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		// 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
		service.scheduleAtFixedRate(runnable, minutes, 100000, TimeUnit.MINUTES);
	}
}
