package tst.project.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;

import com.google.gson.Gson;

import tst.project.bean.wx.WXPubBean;

public class HttpUtils {
	public static String getRemortIP(HttpServletRequest request) {
		if (request.getHeader("x-forwarded-for") == null) {
			return request.getRemoteAddr();
		}
		return request.getHeader("x-forwarded-for");
	}

	/**
	 * post请求数据
	 * 
	 * @return
	 */
	public static String getDataByPost(String Url, NameValuePair[] nameValuePairs) {
		return getDataByPost(Url, nameValuePairs, "ISO-8859-1");
	}
	
	public static String testPost(String urlStr,String xmlInfo) {  
        HttpClient httpclient = new HttpClient();  
        PostMethod post = new PostMethod(urlStr);  
        String info = null;  
        try {  
                RequestEntity entity = new StringRequestEntity(xmlInfo, "text/plain","utf-8");  
                post.setRequestEntity(entity);  
                httpclient.executeMethod(post);  
                int code = post.getStatusCode();  
                if (code == HttpStatus.SC_OK)  
                    info = post.getResponseBodyAsString();  //接口返回的信息  
        } catch (Exception ex) {  
                ex.printStackTrace();  
                info=ex.getMessage();
        } finally {  
                post.releaseConnection();  
        }  
        return info;
    }  
	/**
	 * 发送xml数据请求到server端
	 * 
	 * @param url
	 *            xml请求数据地址
	 * @param xmlString
	 *            发送的xml数据流
	 * @return null发送失败，否则返回响应内容
	 */
	@SuppressWarnings("deprecation")
	public static String post(String url, String xmlString) {
		// 关闭
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
		System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");
		System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.commons.httpclient", "stdout");

		// 创建httpclient工具对象
		HttpClient client = new HttpClient();
		// 创建post请求方法
		PostMethod myPost = new PostMethod(url);
		// 设置请求超时时间
		client.setConnectionTimeout(300 * 1000);
		String responseString = null;
		try {
			// 设置请求头部类型
			myPost.setRequestHeader("Content-Type", "text/xml");
			myPost.setRequestHeader("charset", "utf-8");

			// 设置请求体，即xml文本内容，注：这里写了两种方式，一种是直接获取xml内容字符串，一种是读取xml文件以流的形式
			myPost.setRequestBody(xmlString);

			// InputStream
			// body=this.getClass().getResourceAsStream("/"+xmlFileName);
			// myPost.setRequestBody(body);
			// myPost.setRequestEntity(new
			// StringRequestEntity(xmlString,"text/xml","utf-8"));
			int statusCode = client.executeMethod(myPost);
			if (statusCode == HttpStatus.SC_OK) {
				BufferedInputStream bis = new BufferedInputStream(myPost.getResponseBodyAsStream());
				byte[] bytes = new byte[1024];
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				int count = 0;
				while ((count = bis.read(bytes)) != -1) {
					bos.write(bytes, 0, count);
				}
				byte[] strByte = bos.toByteArray();
				responseString = new String(strByte, 0, strByte.length, "utf-8");
				bos.close();
				bis.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
		myPost.releaseConnection();
		return responseString;
	}

	/**
	 * post请求数据
	 * 
	 * @return
	 */
	public static String getDataByPost(String Url, NameValuePair[] nameValuePairs, String charset) {
		try {
			HttpClient client = new HttpClient();
			PostMethod post = new PostMethod(Url);
			post.setRequestHeader("Content-type", "application/x-www-form-urlencoded;charset=" + charset);
			if (nameValuePairs != null) {
				post.setRequestBody(nameValuePairs);
			}
			int statu = client.executeMethod(post);
			String str = post.getResponseBodyAsString();
			if (statu == 200) {
				return str;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
		return "";
	}

	/**
	 * json请求数据
	 * 
	 * @param add_url
	 * @param json
	 * @return
	 */
	public static String getDataByJson(String add_url, String json) {
		try {
			URL url = new URL(add_url);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			//connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");  
			connection.connect();
			DataOutputStream out = new DataOutputStream(connection.getOutputStream());

			out.write(json.getBytes("UTF-8"));
			out.flush();
			out.close();

			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String lines;
			StringBuffer sbf = new StringBuffer();
			while ((lines = reader.readLine()) != null) {
				lines = new String(lines.getBytes(), "utf-8");
				sbf.append(lines);
			}
			reader.close(); // 断开连接
			connection.disconnect();
			return sbf.toString();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "-1";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "-2";
		}
	}

	public static boolean downloadFile(String urlString, String filename) {
		try {
			// 构造URL
			URL url = new URL(urlString);
			// 打开连接
			URLConnection con = url.openConnection();
			// 输入流
			InputStream is = con.getInputStream();
			// 1K的数据缓冲
			byte[] bs = new byte[1024];
			// 读取到的数据长度
			int len;
			// 输出的文件流
			OutputStream os = new FileOutputStream(filename);
			// 开始读取
			while ((len = is.read(bs)) != -1) {
				os.write(bs, 0, len);
			}
			// 完毕，关闭所有链接
			os.close();
			is.close();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
