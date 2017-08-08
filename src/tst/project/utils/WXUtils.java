package tst.project.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import com.google.gson.Gson;

import tst.project.bean.wx.WXBean;
import tst.project.bean.wx.WXPayBean;
import tst.project.bean.wx.WXPubBean;

public class WXUtils {

	/**
	 * 设置微信菜单
	 * @return
	 */
	public static boolean settingMenu(String access_token,String json){
		try {
			String Url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + access_token;
			String result = HttpUtils.getDataByJson(Url,json);
			WXBean wxBean=new Gson().fromJson(result, WXBean.class);
			if("ok".equals(wxBean.getErrmsg())){
				return true;
			}else{
				System.out.println("参数："+json);
				System.out.println("错误信息："+wxBean.getErrmsg());
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 微信支付 MD5签名
	 * @throws Exception 
	 */
	public static WXPayBean wxMD5Sign(String appId,String key,String packageStr) throws Exception{
		String signType="MD5";
		String nonceStr=CreateRandom.createRandom(false, 32);
		long timeStamp = Long.parseLong(String.valueOf(System.currentTimeMillis()).toString().substring(0, 10));
		
		String wait_sign="appId="+appId+"&nonceStr="+nonceStr+"&package="
				+packageStr+"&signType="+signType+"&timeStamp="+timeStamp
				+"&key="+key;
		
		String paySign=MD5Util.md5EncodeOrigin(wait_sign).toUpperCase();
		
		WXPayBean wxPayBean=new WXPayBean();
		wxPayBean.setAppId(appId);
		wxPayBean.setNonceStr(nonceStr);
		wxPayBean.setPackageStr(packageStr);
		wxPayBean.setSignType(signType);
		wxPayBean.setTimeStamp(timeStamp+"");
		wxPayBean.setPaySign(paySign);
		
		return wxPayBean;
	}
	
	public static String getQrcode(String access_token,String content) {
		try {
			String Url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=" + access_token;
			String result = HttpUtils.getDataByJson(Url,
					"{\"action_name\": \"QR_LIMIT_STR_SCENE\", \"action_info\":"
					+ " {\"scene\": {\"scene_str\": \""+content+"\"}}}");
			if (!result.equals("-1") && !result.equals("-2")) {
				try {
					WXBean wxBean = new Gson().fromJson(result, WXBean.class);
					String url = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=" +wxBean.getTicket();
					
					return url;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return "-1";
				}
			}else{
				return result;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "-1";
		}
	}

	public static String getJsapi(String access_token) {
		try {
			String Url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + access_token
					+ "&type=jsapi";
			HttpClient client = new HttpClient();
			PostMethod post = new PostMethod(Url);
			post.setRequestHeader("Content-type", "application/x-www-form-urlencoded;charset=ISO-8859-1");
			post.setRequestBody(new NameValuePair[] {});
			int statu = client.executeMethod(post);
			String str = post.getResponseBodyAsString();
			if (statu == 200) {
				WXPubBean wxBean = new Gson().fromJson(str, WXPubBean.class);
				if (wxBean.getErrcode().equals("0")) {
					return wxBean.getTicket();
				} else {
					return "";
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
		return "";
	}

	public static String getAccess_token(String appid, String secret) {
		try {
			String Url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential" + "&appid=" + appid
					+ "&secret=" + secret;
			HttpClient client = new HttpClient();
			PostMethod post = new PostMethod(Url);
			post.setRequestHeader("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			post.setRequestBody(new NameValuePair[] {});
			int statu = client.executeMethod(post);
			String str = post.getResponseBodyAsString();
			if (statu == 200) {
				WXPubBean wxBean = new Gson().fromJson(str, WXPubBean.class);
				if (wxBean.getErrcode() == null) {
					return wxBean.getAccess_token();
				} else {
					return "";
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
		return "";
	}

	/**
	 * 微信公众号 根据code获得用户的信息
	 * 
	 * @param code
	 *            时效性是5分钟
	 */
	public static WXPubBean getWXUserInfo(String appid, String secret, String code, HttpServletRequest request) {
		try {
			String Url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appid+"&secret="+secret+ "&code=" + code + "&grant_type=authorization_code";
			HttpClient client = new HttpClient();
			PostMethod post = new PostMethod(Url);
			post.setRequestBody(new NameValuePair[] {});
			//GetMethod get = new GetMethod(Url);	
			int statu = client.executeMethod(post);
			String str = post.getResponseBodyAsString();
			if (statu == 200) {
				WXPubBean wxBean = new Gson().fromJson(str, WXPubBean.class);
				String result = getUserInfoByOenid(wxBean.getAccess_token(), wxBean.getOpenid());
				if (!result.equals("")) {
					WXPubBean wxPubBean = new Gson().fromJson(result, WXPubBean.class);
					if (wxPubBean.getErrcode() == null) {
						// String
						// filename=TimeUtils.getCurrentTime("yyyyMMddHHmmss")+".png";
						// boolean
						// is_success=HttpUtils.downloadFile(wxPubBean.getHeadimgurl(),
						// request.getSession().getServletContext()
						// .getRealPath("/")+"/images/member/"+filename);
						// if(is_success){
						wxPubBean.setNickname(wxPubBean.getNickname().replaceAll("[\ue000-\uefff]", "...")
								.replaceAll("[\ud83c\udc00-\ud83c\udfff]", "...")
								.replaceAll("[\ud83d\udc00-\ud83d\udfff]", "...").replaceAll("[\u2600-\u27ff]", "..."));
						// return
						// wxPubBean.setHeadimgurl("/images/member/"+filename);
						return wxPubBean;
						// }
						// return null;
					} else {
						return null;
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}

	public static String getUserInfoByOenid(String ACCESS_TOKEN, String openID) {
		try {
			String Url = "https://api.weixin.qq.com/sns/userinfo?access_token=" + ACCESS_TOKEN + "&openid=" + openID
					+ "&lang=zh_CN";
			HttpClient client = new HttpClient();
			PostMethod post = new PostMethod(Url);

			post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");

			post.setRequestHeader("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			post.setRequestBody(new NameValuePair[] {});

			int statu = client.executeMethod(post);
			String str = post.getResponseBodyAsString();

			if (statu == 200) {
				return str;
			} else {
				return "";
			}
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
}
