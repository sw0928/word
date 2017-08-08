package tst.project.script;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.iwilley.b1ec2.api.B1EC2Client;
import com.iwilley.b1ec2.api.request.SalesOrderQueryRequest;
import com.iwilley.b1ec2.api.response.SalesOrderQueryResponse;
import com.iwilley.b1ec2.sample.Constants;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import tst.project.bean.order.BusinessProfitBean;
import tst.project.bean.order.OrderBean;
import tst.project.bean.order.OrderGoodsBean;
import tst.project.utils.JDBCUtils;

public class HBROrder {
	public static void main(String[] args) {
		String url = "jdbc:mysql://121.40.154.201:3306/shop_hbr";
		Connection conn=null;	
		String sql="select * from tst_order where order_state='wait_send' ";
		try {
			conn = JDBCUtils.startConn(conn,url);
			String json=JDBCUtils.queryArray(conn, sql);
			List<OrderBean> orderBeans=new Gson().fromJson(json, new TypeToken<List<OrderBean>>() {}.getType());
			if(orderBeans!=null){
				for (int i = 0; i < orderBeans.size(); i++) {
					OrderBean orderBean=orderBeans.get(i);
					B1EC2Client client = new B1EC2Client(Constants.URL, Constants.COMPANY,
							Constants.LOGIN_NAME, Constants.PASSWORD);
					int pageSize = 5;
					DateFormat format = new SimpleDateFormat(
							com.iwilley.b1ec2.api.Constants.DATE_TIME_FORMAT);
					SalesOrderQueryRequest request = new SalesOrderQueryRequest();
					request.setStartTime(format.parse("2010-04-20 00:00:00"));
					request.setEndTime(format.parse("2029-05-22 00:00:00"));
					request.setPageSize(pageSize);
					request.setShopId(4);		
					request.setShopOrderNo(orderBean.getOrder_no());
					SalesOrderQueryResponse response = client.execute(request);
					
					Map map=new Gson().fromJson(response.getBody(), Map.class);
					if(map!=null){
						if("1.0".equals(map.get("TotalResults").toString())){
							List<Map> maps=(List<Map>) map.get("SalesOrders");
							Map map2=maps.get(0);
							
							String ExpressTrackNo=map2.get("ExpressTrackNo")==null?"":map2.get("ExpressTrackNo").toString();
							if(ExpressTrackNo!=null&&!"".equals(ExpressTrackNo)){
								Map map3=(Map) map2.get("Express");
								String ExpressCode=map3.get("ExpressCode").toString();
								Statement st3=(Statement) conn.createStatement();					
								int num=st3.executeUpdate(" update tst_order set order_state='wait_receive'"
										+ ",logistics_pinyin=\""+ExpressCode+"\" ,logistics_no = \""+ExpressTrackNo+"\" "
										+ "where order_id="+orderBean.getOrder_id()+" ");
							}
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
