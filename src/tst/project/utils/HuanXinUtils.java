package tst.project.utils;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.google.gson.Gson;

import tst.project.bean.hx.HXBean;
import tst.project.bean.hx.HXSettingBean;

/**
 * 环信各类操作
 * @author sjb
 *
 */
public class HuanXinUtils {
	private static String url="https://a1.easemob.com/";
//	private static String id="362594500";
//	private static String name="igg";
//	
//	private static String client_id="YXA68eXfIAg9EeaRLz9Wm2HQmg";
//	private static String client_secret="YXA6913YVmvLfUx6jOHrvtwLkHxd4Sc";
//	private static String token="YWMtxo-fZAhqEea-pi902mgMZwAAAVVyPluHYkl4VZDEBvdGGWNQsMXskqVJx6g";
	/**
	 * 查询所有用户
	 */
	public static String getAllUsers(String id,String name,String token) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client
				.target(url+id+"/"+name+"/users");		
		Response response = target
				.request()
				.accept(MediaType.APPLICATION_JSON)
				.header("Authorization","Bearer	"+token)
				.get();
		String value = response.readEntity(String.class);
		response.close(); //关闭连接
		
		HXBean hxBean=new Gson().fromJson(value, HXBean.class);
		if(hxBean.getError()==null){
			return value;
		}
		if(hxBean.getError()!=null&&hxBean.getError().equals("unauthorized")){//token失效
			return "-1";
		}
		
		return "-2";
	}
	
	/**
	 * 注册一个用户
	 */
	public static boolean registerOneUser(HXSettingBean hxSettingBean,String username,String password,String nickname){
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(url+hxSettingBean.getId()+"/"+hxSettingBean.getName()+"/users");
		Response response = target.request().buildPost(Entity.entity("{\"username\":\""+username+"\",\"password\":\""+password+"\",\"nickname\":\""+nickname+"\"}", MediaType.APPLICATION_JSON)).invoke();
		response.accepted().header("Content-Type", "application/json");
		String value = response.readEntity(String.class);
		response.close(); // 关闭连接	

		HXBean hxBean=new Gson().fromJson(value, HXBean.class);
		if(hxBean.getError()==null){
			return true;
		}
		return false;
	}
	
	/**
	 * 获取token
	 */
	public static String getToken(String id,String name,String token,String client_id,String client_secret) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(url+id+"/"+name+"/token");
		Response response = target.request().buildPost(Entity.entity("{ \"grant_type\": \"client_credentials\", \"client_id\": \""+client_id+"\",\"client_secret\": \""+client_secret+"\"}", MediaType.APPLICATION_JSON)).invoke();
		response.accepted().header("Content-Type", "application/json");
		String value = response.readEntity(String.class);
		response.close(); // 关闭连接	
		
		HXBean hxBean=new Gson().fromJson(value, HXBean.class);
		if(hxBean.getError()==null){
			token=hxBean.getAccess_token();
		}else{
			return "-1";
		}
		
		return value;
	}
	
	/**
	 * 根据时间获得聊天记录
	 * @param time 毫秒数
	 * @return
	 */
	public static String getChatRecord(String id,String name,String token,String time){
		Client client = ClientBuilder.newClient();
		WebTarget target = null;
		target = client
					.target(url+id+"/"+name+"/chatmessages?ql=select+*+where+timestamp%26gt%3b"+time);		
		Response response = target
				.request()
				.header("Authorization","Bearer "+token)
				.get();
		String value = response.readEntity(String.class);
		response.close(); //关闭连接
		
		HXBean hxBean=new Gson().fromJson(value, HXBean.class);
		if(hxBean.getError()==null){
			return value;
		}
		
		if(hxBean.getError()!=null&&hxBean.getError().equals("query_token")){//token失效
			return "-1";
		}
		
		return value;
	}
}
