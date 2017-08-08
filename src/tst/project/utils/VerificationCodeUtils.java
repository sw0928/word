/**
 * 
 */
package tst.project.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import tst.project.bean.others.CodeBean;
import tst.project.bean.others.VerificationBean;

/**
 * @author sjb
 * 
 */
public class VerificationCodeUtils {


	public static CodeBean sendCode(VerificationBean verificationBean,CodeBean codeBean) throws Exception {
		// 产生随机验证码
		try {
			String format = "yyyy-MM-dd HH:mm:ss";
			String time = TimeUtils.getCurrentTime(format);
			Date date = TimeUtils.getDateFromTime(format, time);
			codeBean.setCreate_time(time);
			codeBean.setEffective_time(TimeUtils.getTimeMinuteAfter(format, date,verificationBean.getEffective_time()));
			String Url = verificationBean.getVerification_url();
			HttpClient client = new HttpClient();
			PostMethod post = new PostMethod(Url);
			post.setRequestHeader("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			NameValuePair userid = new NameValuePair("userid", "");
			NameValuePair account = new NameValuePair(verificationBean.getKey_account(), verificationBean.getVerification_account());
			NameValuePair password = new NameValuePair(verificationBean.getKey_password(), verificationBean.getVerification_password());
			NameValuePair mobile = new NameValuePair(verificationBean.getKey_mobile(), codeBean.getMobile());
			NameValuePair content = new NameValuePair(verificationBean.getKey_content(), codeBean.getCode_desc());
			NameValuePair id = new NameValuePair(verificationBean.getKey_userid(), verificationBean.getVerification_userid());
			NameValuePair sendTime = new NameValuePair("sendTime", codeBean.getCreate_time());
			NameValuePair extno = new NameValuePair("extno", "");
			
			post.setRequestBody(new NameValuePair[] { userid, account, password, mobile, content,id, sendTime, extno });
			int statu = client.executeMethod(post);
			System.out.println("statu=" + statu);
			String str = post.getResponseBodyAsString();
			System.out.println(str);
			if (statu == 200) {
				return codeBean;
			} else {
				return null;
			}

			// return codeBean;
			/*
			 * // 将字符转化为XML Document doc = DocumentHelper.parseText(str); //
			 * 获取根节点 Element rootElt = doc.getRootElement(); // 获取根节点下的子节点的值
			 * String returnstatus = rootElt.elementText("returnstatus").trim();
			 * String message = rootElt.elementText("message").trim(); String
			 * remainpoint = rootElt.elementText("remainpoint").trim(); String
			 * taskID = rootElt.elementText("taskID").trim(); String
			 * successCounts = rootElt.elementText("successCounts").trim();
			 * 
			 * System.out.println("返回状态为：" + returnstatus);
			 * System.out.println("返回信息提示：" + message);
			 * System.out.println("返回余额：" + remainpoint);
			 * System.out.println("返回任务批次：" + taskID);
			 * System.out.println("返回成功条数：" + successCounts);
			 */
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
