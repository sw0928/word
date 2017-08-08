package tst.project.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Calendar;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import tst.project.bean.others.HtmlStyleBean;

public class HtmlUtils {
	public static boolean writeHtml(HttpServletRequest request, String fileName, String desc) {
		return writeHtml(request, fileName, desc, true);
	}

	public static String Html2Text(String inputString) {
		String htmlStr = inputString; // 含html标签的字符串
		String textStr = "";
		java.util.regex.Pattern p_script;
		java.util.regex.Matcher m_script;
		java.util.regex.Pattern p_style;
		java.util.regex.Matcher m_style;
		java.util.regex.Pattern p_html;
		java.util.regex.Matcher m_html;

		try {
			String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
																										// }
			String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
																									// }
			String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式

			p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
			m_script = p_script.matcher(htmlStr);
			htmlStr = m_script.replaceAll(""); // 过滤script标签

			p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
			m_style = p_style.matcher(htmlStr);
			htmlStr = m_style.replaceAll(""); // 过滤style标签

			p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
			m_html = p_html.matcher(htmlStr);
			htmlStr = m_html.replaceAll(""); // 过滤html标签

			textStr = htmlStr;

		} catch (Exception e) {
			System.err.println("Html2Text: " + e.getMessage());
		}

		return textStr;// 返回文本字符串
	}

	public static String readHtml(HttpServletRequest request, String fileName) {
		try {
			String basePath = request.getSession().getServletContext().getRealPath("/");

			// 模板路径
			String filePath = basePath + "/" + fileName;
			System.out.print(filePath);
			String templateContent = "";
			FileInputStream fileinputstream = new FileInputStream(filePath);// 读取模板文件
			int lenght = fileinputstream.available();
			byte bytes[] = new byte[lenght];
			fileinputstream.read(bytes);
			fileinputstream.close();
			templateContent = new String(bytes);

			return templateContent;
		} catch (Exception e) {
			System.out.print(e.toString());
			return "";
		}
	}

	public static boolean writeHtml(HttpServletRequest request, String fileName, String desc,
			HtmlStyleBean htmlStyleBean) {
		try {
			String basePath = request.getSession().getServletContext().getRealPath("/");
			// 模板路径
			String filePath = basePath + "/" + fileName;
			FileOutputStream fileoutputstream = new FileOutputStream(filePath);// 建立文件输出流

			OutputStreamWriter writer = new OutputStreamWriter(fileoutputstream, "utf-8");
			String style = "";

			if (htmlStyleBean == null) {
				style = desc;
			} else {
				style = htmlStyleBean.getStyle_desc();
				int start = desc.indexOf("<tst>");
				int end = desc.indexOf("</tst>");

				if (start > 0 && end > 0) {
					style = style.replace("[desc]", desc.substring(start + 5, end));
				} else {
					style = style.replace("[desc]", desc);
				}
			}
			byte tag_bytes[] = style.getBytes();

			fileoutputstream.write(tag_bytes);

			writer.flush();
			fileoutputstream.close();
			writer.close();

			return true;
		} catch (Exception e) {
			System.out.print(e.toString());
			return false;
		}
	}

	public static boolean writeHtml(HttpServletRequest request, String fileName, String desc, boolean is_style) {
		try {
			String basePath = request.getSession().getServletContext().getRealPath("/");
			// 模板路径
			String filePath = basePath + "/" + fileName;
			FileOutputStream fileoutputstream = new FileOutputStream(filePath);// 建立文件输出流

			OutputStreamWriter writer = new OutputStreamWriter(fileoutputstream, "utf-8");
			String a = "<!DOCTYPE html><html>" + "<head>" + "<title>about_our.html</title>"
					+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"
					+ "<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">"
					+ "<meta http-equiv=\"description\" content=\"this is my page\">"
					+ "<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\">";

			if (is_style) {
				a += "<style type=\"text/css\">" + "img{width:100% !important;height:auto !important;}"
						+ "p{line-height: 0;margin: 0}" + "</style>";
			}
			a += "</head><body>";
			byte tag_bytes[] = (a + desc + "</body></html>").getBytes();

			fileoutputstream.write(tag_bytes);

			writer.flush();
			fileoutputstream.close();
			writer.close();

			return true;
		} catch (Exception e) {
			System.out.print(e.toString());
			return false;
		}
	}

	public static String html(HttpServletRequest request, String src) {
		try {
			String basePath = request.getSession().getServletContext().getRealPath("/");

			// 模板路径
			String filePath = basePath + "/MileageBudget.html";
			System.out.print(filePath);
			String templateContent = "";
			FileInputStream fileinputstream = new FileInputStream(filePath);// 读取模板文件
			int lenght = fileinputstream.available();
			byte bytes[] = new byte[lenght];
			fileinputstream.read(bytes);
			fileinputstream.close();
			templateContent = new String(bytes);
			templateContent = templateContent.replaceAll("####src####", src);
			// 根据时间得文件名
			Calendar calendar = Calendar.getInstance();
			String filename = "MileageBudget_" + String.valueOf(calendar.getTimeInMillis()) + ".html";
			filename = "/" + filename;// 生成的html文件保存路径。
			String path = "/html/MileageBudget";
			File file = new File(basePath + path);
			if (!file.exists()) {
				file.mkdirs();
			}
			FileOutputStream fileoutputstream = new FileOutputStream(basePath + path + filename);// 建立文件输出流
			OutputStreamWriter writer = new OutputStreamWriter(fileoutputstream, "UTF-8");
			writer.append(templateContent);
			/*
			 * byte tag_bytes[] = templateContent.getBytes();
			 * fileoutputstream.write(tag_bytes);
			 */
			writer.flush();
			fileoutputstream.close();
			writer.close();

			return path + filename;
		} catch (Exception e) {
			System.out.print(e.toString());
			return "";
		}
	}
}
