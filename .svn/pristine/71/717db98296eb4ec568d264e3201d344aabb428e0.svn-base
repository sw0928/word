package tst.project.utils;

import java.math.BigDecimal;

import tst.project.bean.address.LocationBean;

public class DistanceUtils {
	 /** 
     * 基于googleMap中的算法得到两经纬度之间的距离,计算精度与谷歌地图的距离精度差不多，相差范围在0.2米以下 
     * @param lon1 第一点的精度 
     * @param lat1 第一点的纬度 
     * @param lon2 第二点的精度 
     * @param lat3 第二点的纬度 
     * @return 返回的距离，单位km 
     * */  
    public static double GetDistance(LocationBean locationBean, LocationBean locationBean2)  
    {  
    	Double lon1 = NumberUtils.Double(locationBean.getLng());
		Double lat1 = NumberUtils.Double(locationBean.getLat());
		Double lon2 = NumberUtils.Double(locationBean2.getLng());
		Double lat2 = NumberUtils.Double(locationBean2.getLat());
		
       double radLat1 = rad(lat1);  
       double radLat2 = rad(lat2);  
       double a = radLat1 - radLat2;  
       double b = rad(lon1) - rad(lon2);  
       double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2)+Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));  
       s = s * 6378137;  
       //s = Math.round(s * 10000) / 10000;  
       return s;  
    }
	 /** 
     * 基于googleMap中的算法得到两经纬度之间的距离,计算精度与谷歌地图的距离精度差不多，相差范围在0.2米以下 
     * @param lon1 第一点的精度 
     * @param lat1 第一点的纬度 
     * @param lon2 第二点的精度 
     * @param lat3 第二点的纬度 
     * @return 返回的距离，单位km 
     * */  
    public static double GetDistance(double lon1,double lat1,double lon2, double lat2)  
    {  
       double radLat1 = rad(lat1);  
       double radLat2 = rad(lat2);  
       double a = radLat1 - radLat2;  
       double b = rad(lon1) - rad(lon2);  
       double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2)+Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));  
       s = s * 6378137;  
       //s = Math.round(s * 10000) / 10000;  
       return s;  
    }
    private static double rad(double d)  
    {  
       return d * Math.PI / 180.0;  
    }  
    
	/**
	 * 根据经纬度计算距离
	 */
	public static String Distan(LocationBean locationBean, LocationBean locationBean2) {
		try {
			Double long1 = NumberUtils.Double(locationBean.getLng());
			Double lat1 = NumberUtils.Double(locationBean.getLat());
			Double long2 = NumberUtils.Double(locationBean2.getLng());
			Double lat2 = NumberUtils.Double(locationBean2.getLat());
			
			System.out.println(long1+"==="+lat1+"===="+long2+"==="+lat2);
			if(long1==0||lat1==0||long2==0||lat2==0){
				return "-1";
			}
			// 计算距离
			double a, b, R;
			R = 6378137; // 地球半径
			lat1 = lat1 * Math.PI / 180.0;
			lat2 = lat2 * Math.PI / 180.0;
			a = lat1 - lat2;
			b = (long1 - long2) * Math.PI / 180.0;
			double d;
			double sa2, sb2;
			sa2 = Math.sin(a / 2.0);
			sb2 = Math.sin(b / 2.0);
			d = 2 * R * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat1) * Math.cos(lat2) * sb2 * sb2))/1000;
		    
			BigDecimal bd = new BigDecimal(NumberUtils.KeepDecimal(d, 2));
			String str = bd.toPlainString();
			return str;
		} catch (Exception e) {
			return "0";
		}
	}

	/**
	 * 根据经纬度计算距离
	 */
	public static double Distan(Double long1, Double lat1, Double long2, Double lat2) throws Exception {
		// 计算距离
		double a, b, R;
		R = 6378137; // 地球半径
		lat1 = lat1 * Math.PI / 180.0;
		lat2 = lat2 * Math.PI / 180.0;
		a = lat1 - lat2;
		b = (long1 - long2) * Math.PI / 180.0;
		double d;
		double sa2, sb2;
		sa2 = Math.sin(a / 2.0);
		sb2 = Math.sin(b / 2.0);
		d = 2 * R * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat1) * Math.cos(lat2) * sb2 * sb2));
		return d;
	}
}
