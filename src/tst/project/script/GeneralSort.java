package tst.project.script;

import java.util.List;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import tst.project.bean.goods.GoodsBean;
import tst.project.bean.order.BusinessProfitBean;
import tst.project.bean.order.OrderGoodsBean;
import tst.project.bean.others.PercentBean;
import tst.project.utils.JDBCUtils;
import tst.project.utils.NumberUtils;

/**
 * 综合排序
 * @author shenjiabo
 *
 */
public class GeneralSort {
	public static void main(String[] args) {
		String url = "jdbc:mysql://106.14.17.171:3306/shop_sw";
		Connection conn=null;	
		String sql=" select * from tst_goods where goods_type='2' and is_delete='0' ";
		
		String sort1=" select * from tst_percent where percent_type='sort1' ";
		String sort2=" select * from tst_percent where percent_type='sort2' ";
		String sort3=" select * from tst_percent where percent_type='sort3' ";
		try {
			conn = JDBCUtils.startConn(conn,url);
			String json=JDBCUtils.queryArray(conn, sql);

			List<GoodsBean> goodsBeans=new Gson().fromJson(json, new TypeToken<List<GoodsBean>>() {}.getType());
						
			String sortJson1=JDBCUtils.queryObject(conn, sort1);
			PercentBean percentBean1=new Gson().fromJson(sortJson1, PercentBean.class);
			
			String sortJson2=JDBCUtils.queryObject(conn, sort2);
			PercentBean percentBean2=new Gson().fromJson(sortJson2, PercentBean.class);
			
			String sortJson3=JDBCUtils.queryObject(conn, sort3);
			PercentBean percentBean3=new Gson().fromJson(sortJson3, PercentBean.class);
			if(goodsBeans!=null){
				for (int i = 0; i < goodsBeans.size(); i++) {
					GoodsBean goodsBean=goodsBeans.get(i);
					int sort=NumberUtils.KeepDecimal(NumberUtils.Float(goodsBean.getSort_price())
							*NumberUtils.Float(percentBean1.getPercent_value())
							+NumberUtils.Float(goodsBean.getSort_price())*NumberUtils.Float(percentBean2.getPercent_value())
							+NumberUtils.Float(goodsBean.getSort_price())*NumberUtils.Float(percentBean3.getPercent_value()));
					
					Statement st3=(Statement) conn.createStatement();					
					int num=st3.executeUpdate(" update tst_goods set sort="+sort+" "
							+ "where goods_id="+goodsBean.getGoods_id()+" ");
					if(num>0){
						
					}
				}
			}
			
			JDBCUtils.closeConn(null,null, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	
}
