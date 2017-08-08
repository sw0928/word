package tst.project.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlipayUtils {

	/**
	 * 获得支付宝的 境外汇率
	 * @param partner 支付宝pid
	 * @param privateKey 私钥
	 * @param currency 货币种类
	 * @return
	 */
	public static double getAlipayRate(String partner,String privateKey,String currency){		
		try {
			Map<String, String> map=new HashMap<String, String>();
			map.put("service", "forex_rate_file");
			map.put("partner", partner);
			
			String wait_pay=AlipayUtils.createLinkString(map);//待签名字符串
			//String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAK5tBMN+bVcUJIaqikdHhGobdjQJPpfeEJLWK0egXawbQB6isRpG7fxl8Ydi/f+Rxcm8saFe5JCeDORBnlBDvBxIuF7Kq97M727TcX2eov248SjucCvs3G22VBNLblOBCj36+ut3ZPCZxb8WrfLR09Z1p6K6t3jvxdqAWYxaYh8jAgMBAAECgYBJENfnAIXS7VgjpTrJgxbfz+MjByBWQ6qTp+13UqEKoFuquaIQjNfSW+3iNcCKl0jQKiAKphJ+1gY2c5paqxUX3mLp6/1gNZMz5eHN8zr6wpwMJpIZsamLziKzFWOaBkQ/7k4ifxExSTgDd3yGDY1g1oMwOvNzByWWfdXlz7IvmQJBAOW1r78RxPbdpzQ/REy7cxU6Ux5uUkOO9BTIChS8EKUZOz729COBNN/5SgeNJXEdYAQJPCp4OUcxTVptC56k8fUCQQDCY48BY2YA5T0w5wwOUTtEyYZZI4U8GFFvDn24QHuOedNeELJW2TiACWFvQChEo/CEzzXR+2/wHbw3iQITReW3AkA7n8xNaRxaA7Cp5B4jWKiHgwseI/6gYJPEbSQIu8QKRqFVN56pNJl35WosyZtFYB2TDp6aW3hqnUZ5yUIx3JidAkEAqycLl7ZT7n/og7E63TRKkgM6JivvOH1U3gqNSPiFkWnUX+MlkvBJHfqkbla33c/WiqkDAzJ2WZ1kxiT8zcliOwJAShk02uup7qVg+VPbon/Ijd0QD7b0meaDjkxoiG2TDHnKS26FWWIK1PCeoM5ShPKe+5C6w8e4Hi3KMmxAhklNlw==";

			String sign=RSAUtils.sign(wait_pay, privateKey, "utf-8");
			map.put("sign",  URLEncoder.encode(sign, "utf-8"));
			map.put("sign_type", "RSA");
			String data=AlipayUtils.createLinkString(map);//最终字符串
			if(!"".equals(data)){//
				String result=HttpUtils
						.getDataByPost("https://mapi.alipay.com/gateway.do?"+data,null);	
				result.replace("\r\n", "").replace(" ", "");
				String rate=result.substring(result.indexOf(currency)+4,result.indexOf(currency)+12);
				return Double.valueOf(rate);
			}
			return -1;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}	
	}
	
	/**
	 * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
	 * 
	 * @param params
	 *            需要排序并参与字符拼接的参数组
	 * @return 拼接后字符串
	 */
	public static String createLinkString(Map<String, String> params) {

		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);

		String prestr = "";

		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = params.get(key);

			if (i == keys.size() - 1) {// 拼接时，不包括最后一个&字符
				prestr = prestr + key + "=" + value;
			} else {
				prestr = prestr + key + "=" + value + "&";
			}
		}

		return prestr;
	}

	/**
	 * 除去数组中的空值和签名参数
	 * 
	 * @param sArray
	 *            签名参数组
	 * @return 去掉空值与签名参数后的新签名参数组
	 */
	public static Map<String, String> paraFilter(Map<String, String> sArray) {

		Map<String, String> result = new HashMap<String, String>();

		if (sArray == null || sArray.size() <= 0) {
			return result;
		}

		for (String key : sArray.keySet()) {
			String value = sArray.get(key);
			if (value == null || value.equals("") || key.equalsIgnoreCase("sign")
					|| key.equalsIgnoreCase("sign_type")) {
				continue;
			}
			result.put(key, value);
		}
		return result;
	}
}
