package tst.project.utils;

import java.math.BigDecimal;

public class NumberUtils {
	
	public static Double Double(String value){
		return Double.valueOf(value==null||"".equals(value)?"0":value);
	}
	
	public static int Integer(String value){
		try{
		return Integer.valueOf(value==null||"".equals(value)?"0":value);
		}catch(Exception e){
			return -1;
		}
	}
	
	public static float Float(String value){
		return Float.valueOf(value==null||"".equals(value)?"0":value);
	}
	/**
	 * 保留2位小数
	 * @param value
	 * @param count
	 * @return
	 */
	public static double KeepDecimal(double value,int count){
		BigDecimal   bd   =   new   BigDecimal(value);   
		bd=bd.setScale(count,BigDecimal.ROUND_HALF_UP);   
		return bd.doubleValue();
	}
	
	/**
	 * 保留2位小数
	 * @param value
	 * @param count
	 * @return
	 */
	public static double KeepDecimal(String value,int count){
		BigDecimal   bd   =   new   BigDecimal(value);   
		bd=bd.setScale(count,BigDecimal.ROUND_HALF_UP);   
		return bd.doubleValue();
	}
	/**
	 * 保留2位小数
	 * @param value
	 * @param count
	 * @return
	 */
	public static int KeepDecimal(double value){
		BigDecimal   bd   =   new   BigDecimal(value);   
		bd=bd.setScale(0,BigDecimal.ROUND_HALF_UP);   
		return bd.intValue();
	}
	

	

	
	/**
	 * 保留2位小数
	 * @param value
	 * @param count
	 * @return
	 */
	public static int KeepDecimal(String value){
		BigDecimal   bd   =   new   BigDecimal(value);   
		bd=bd.setScale(0,BigDecimal.ROUND_HALF_UP);   
		return bd.intValue();
	}
}
