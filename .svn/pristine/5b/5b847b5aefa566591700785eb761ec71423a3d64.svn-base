package tst.project.utils;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class JDBCUtils {
	public static Connection startConn(Connection conn,String url) {
		// 填入数据库的用户名跟密码
		String username = "root";
		String password = "Zha54321";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			System.out.println("连接数据库时出现错误");
		}
		return conn;
	}
	
	public static String queryObject(Connection conn,String sql) throws SQLException{
		Statement st=null;
		ResultSet rs = null;
		try {
			st = (Statement) conn.createStatement();
			rs = (ResultSet) st.executeQuery(sql);// 执行sql语句并返回结果集	
			ResultSetMetaData rsmd = rs.getMetaData();
			int count=rsmd.getColumnCount();
			String json="";
			while(rs.next()) {  
				json="{";
				for(int i=0;i<count;i++){
					String name=rsmd.getColumnName(i+1);
					json+="\""+name+"\":";
					if(rs.getString(name)==null){
						json+=rs.getString(name);
					}else{
						json+="\""+rs.getString(name)+"\"";
					}
					if(i<count-1){
						json+=",";
					}
				}
				json+="}";
				
			}
	
			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			
			return json;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
		}// 创建sql执行对象
		return "";
	}

	
	public static String queryArray(Connection conn,String sql) throws SQLException{
		Statement st=null;
		ResultSet rs = null;
		try {
			st = (Statement) conn.createStatement();
			rs = (ResultSet) st.executeQuery(sql);// 执行sql语句并返回结果集	
			ResultSetMetaData rsmd = rs.getMetaData();
			int count=rsmd.getColumnCount();
			String json="[";
			String json1="";
			while(rs.next()) {  
				json1="{";
				for(int i=0;i<count;i++){
					String name=rsmd.getColumnName(i+1);
					json1+="\""+name+"\":";
					if(rs.getString(name)==null){
						json1+=rs.getString(name);
					}else{
						json1+="\""+rs.getString(name)+"\"";
					}
					if(i<count-1){
						json1+=",";
					}
				}
				json1+="}";
				
				json+=json1+",";
			}
			json=json.substring(0,json.length()-1);
			if(json.length()>0){
				json+="]";
			}

			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			
			return json;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
		}// 创建sql执行对象
		return "";
	}

	public static void closeConn(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch
			System.out.println("关闭数据库的时候发生错误!");
		}
	}

	public static void closeConn(Statement stmt, Connection conn) {
		try {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("关闭数据库的时候发生错误!");
		}
	}
}
