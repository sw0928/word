package tst.project.utils;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import tst.project.bean.address.LocationBean;

public class BaiduUtils {
	
	/**
	 * 根据地址 获取 经纬度
	 */
	public static LocationBean getLLByAddress(String address){
		address=URLEncoder.encode(address==null?"":address);
		String result=HttpUtils
				.getDataByPost("http://api.map.baidu.com/geocoder/v2/?"
						+ "address="+address+"&output=json&ak=gK3TmwbFfAoL1h9V0NtC1bmH9v0nc52A", null);
		
		Map map=new Gson().fromJson(result, Map.class);
		Map map2=new HashMap();
		if("0.0".equals(map.get("status").toString())){
			Map map1=(Map) map.get("result");
			map2=(Map) map1.get("location");
			LocationBean locationBean=new Gson().fromJson(new Gson().toJson(map2), LocationBean.class);
			return locationBean;
		}else{
			return null;
		}
	}
}
