package tst.project.bean.address;

import java.util.List;

public class LocationBean {  
	private static double EARTH_RADIUS = 6378.137;  
	private int id;
	private String lat;
	private String lng;
	public LocationBean(){}
	
	public int getId() {
		return id;
	}

	public LocationBean setId(int id) {
		this.id = id;
		return this;
	}

	public String getLat() {
		return lat;
	}
	public LocationBean setLat(String lat) {
		this.lat = lat;
		return this;
	}
	public String getLng() {
		return lng;
	}
	public LocationBean setLng(String lng) {
		this.lng = lng;
		return this;
	}
	public LocationBean(String lng,String lat) {
		super();
		this.lat = lat;
		this.lng = lng;
	}
	public static double compare(LocationBean loc1,LocationBean loc2){
		return getDistance(Double.valueOf(loc1.getLat()),Double.valueOf(loc1.getLng()),Double.valueOf(loc2.getLat()),Double.valueOf(loc2.getLng()));
	}
	public static double getDistance(double lat1, double lng1, double lat2,  
            double lng2) {  
		double radLat1 = rad(lat1);  
		double radLat2 = rad(lat2);  
		double a = radLat1 - radLat2;  
		double b = rad(lng1) - rad(lng2);  
		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)  
		+ Math.cos(radLat1) * Math.cos(radLat2)  
		* Math.pow(Math.sin(b / 2), 2)));  
		s = s * EARTH_RADIUS;  
		s = Math.round(s * 10000d) / 10000d;  
		s = s*1000;  
		return s;  
	}  
	private static double rad(double d) {  
        return d * Math.PI / 180.0;  
    }  
	public static int getNearestPlaceIndex(LocationBean target,List<LocationBean> locationBeans){
		int chooseedIndex =0;
		double minDist =0;
		for(int index=0;index<locationBeans.size();index++){
			LocationBean bean = locationBeans.get(index);
			double dist = getDistance(Double.valueOf(target.getLat()),Double.valueOf(target.getLng()),Double.valueOf(bean.getLat()),Double.valueOf(bean.getLng()));
			if(index==0){
				minDist = dist;
			}else{
				if(dist<minDist){
					minDist=dist;
					chooseedIndex=index;
				}
			}
		}
		return chooseedIndex;
	}
}
