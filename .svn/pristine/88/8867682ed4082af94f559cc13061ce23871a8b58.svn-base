package tst.project.utils;

import java.util.HashMap;

import tst.project.bean.address.LocationBean;

public class QueryUtils {
	public static String postQuery(String url,HashMap<String,String> params) throws Exception {
		try {
			return new HttpRequest().postData(url, params, "utf-8").toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static LocationBean postForLocation(String addr){
		HashMap<String,String> map = new HashMap<String,String>();
		String ak = "GZElZ39DvuU9c4CY30YwaqzVgKtctxyf";
		String address = addr;
		String callback="showLocation";
		String output = "json";
		map.put("ak", ak);
		map.put("address", address);
		map.put("callback", callback);
		map.put("output", output);
		String data;
		try {
			data =  new HttpRequest().postData("http://api.map.baidu.com/geocoder/v2/", map, "utf-8").toString();
			if(data.contains(",\"msg\":")){
				return null;
			}
			String status = data.substring(data.indexOf("\"status\":")+ ("\"status\":").length(), data.indexOf(",\"result\""));
			System.out.println(status);
			String  lat = data.substring(data.indexOf("\"lat\":") 
                    + ("\"lat\":").length(), data.indexOf("},\"precise\""));
            String lng = data.substring(data.indexOf("\"lng\":") 
                    + ("\"lng\":").length(), data.indexOf(",\"lat\""));
            
            return new LocationBean(lng,lat);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
