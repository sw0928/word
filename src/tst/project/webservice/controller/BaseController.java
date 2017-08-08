package tst.project.webservice.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import tst.project.bean.BaseBean;
import tst.project.bean.others.HtmlStyleBean;

public class BaseController {
	public void WriteOnlyMsg(HttpServletResponse response, String msg) {
		response.addHeader("Access-Control-Allow-Origin","*");
		try {
			response.setHeader("Content-Type", "text/html;charset=UTF-8");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void WriteMsg(HttpServletResponse response, String message) {
		response.addHeader("Access-Control-Allow-Origin","*");
		try {
			response.setHeader("Content-Type", "text/html;charset=UTF-8");
			response.setCharacterEncoding("utf-8");
			BaseBean baseBean = new BaseBean();
			baseBean.setStatus("ok");
			baseBean.setObject(message);

			String msg = new Gson().toJson(baseBean);
			response.getWriter().write(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void WriteObject(HttpServletResponse response, Object object, int total) {
		try {
			response.addHeader("Access-Control-Allow-Origin","*");
			response.setHeader("Content-Type", "text/html;charset=UTF-8");
			response.setCharacterEncoding("utf-8");
			BaseBean baseBean = new BaseBean();
			baseBean.setStatus("ok");
			baseBean.setObject(object);
			baseBean.setTotal(total);
			Gson gson = new GsonBuilder().serializeNulls().create();
			//Gson gson = new GsonBuilder().registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory<String>()).create();
			String msg = gson.toJson(baseBean);
			response.getWriter().write(msg.replace("Bean\":null", "Bean\":{}").
					replace("Beans\":null", "Beans\":[]").replace(":null", ":\"\""));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void WriteObject(HttpServletResponse response, Object object) {
		response.addHeader("Access-Control-Allow-Origin","*");
		try {
			if(object==null){
				object=new Object();
			}
			response.setHeader("Content-Type", "text/html;charset=UTF-8");
			response.setCharacterEncoding("utf-8");
			BaseBean baseBean = new BaseBean();
			baseBean.setStatus("ok");
			baseBean.setObject(object);
			Gson gson = new GsonBuilder().serializeNulls().create();
			//Gson gson = new GsonBuilder().registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory<String>()).create();
			String msg = gson.toJson(baseBean);
			response.getWriter().write(msg.replace("Bean\":null", "Bean\":{}").replace("Beans\":null", "Beans\":[]").replace(":null", ":\"\""));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void WriteError(HttpServletResponse response, String error) {
		response.addHeader("Access-Control-Allow-Origin","*");
		try {
			response.setHeader("Content-Type", "text/html;charset=UTF-8");
			response.setCharacterEncoding("utf-8");
			BaseBean baseBean = new BaseBean();
			baseBean.setStatus("error");
			baseBean.setError(error);

			Gson gson = new GsonBuilder().serializeNulls().create();
			String msg = gson.toJson(baseBean);
			response.getWriter().write(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void WritePending(HttpServletResponse response, String error) {
		response.addHeader("Access-Control-Allow-Origin","*");
		try {
			response.setHeader("Content-Type", "text/html;charset=UTF-8");
			response.setCharacterEncoding("utf-8");
			BaseBean baseBean = new BaseBean();
			baseBean.setStatus("pending");
			baseBean.setError(error);
			String msg = new Gson().toJson(baseBean);
			response.getWriter().write(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	/**
	 * 处理含有图片的接口 返回所有字段的json
	 * 
	 * @param request
	 * @param response
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public String getObjectJson(HttpServletRequest request, String path) throws Exception {
		String json = "{";
		try {
			request.setCharacterEncoding("utf-8");
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setHeaderEncoding("UTF-8");

			List<FileItem> items;
			items = upload.parseRequest(request);
			for (FileItem item : items) {
				if (item.isFormField()) {
					String key = item.getFieldName();
					String value = item.getString("utf-8");
					json += "\"" + key + "\":" + "\"" + value + "\",";
				} else {
					String key = item.getFieldName();
					String value = item.getName();
					long fileLen = item.getSize();
					String mimeType = item.getContentType();
					String fileName = System.currentTimeMillis()
							+ value.substring(value.lastIndexOf('.'),value.length()).toLowerCase();
					String basePath = request.getSession().getServletContext().getRealPath("/");

					File f = new File(basePath + path);
					if (!f.exists()) {
						f.mkdirs();
					}

					item.write(new File(basePath + path + "/" + fileName));

					json += "\"" + key + "\":" + "\"" + path + "\\" + fileName
							+ "\",";
				}
			}

		} catch (FileUploadException e) {
			e.printStackTrace();
			return "-1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "-2";
		}
		return json.substring(0, json.length() - 1) + "}";
	}

	/**
	 * 处理含有图片数组的接口 返回所有字段的json
	 * 
	 * @param request
	 * @param response
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public HashMap<String,Object> getJsonWithImgs(HttpServletRequest request, String path) throws Exception {
		HashMap<String,Object> mapString=new HashMap<String,Object>() ;
		List<String> mapFile=new ArrayList<String>();
		
		HashMap<String,Object> result=new HashMap<String,Object>() ;

		try {
			request.setCharacterEncoding("utf-8");
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setHeaderEncoding("UTF-8");

			List<FileItem> items;
			items = upload.parseRequest(request);
			for (FileItem item : items) {
				if (item.isFormField()) {
					String key = item.getFieldName();
					String value = item.getString("utf-8");
					mapString.put(key, value);
				} else {
					String key = item.getFieldName();
					String value = item.getName();
					long fileLen = item.getSize();
					String mimeType = item.getContentType();
					String fileName = System.currentTimeMillis()
							+  value.substring(value.lastIndexOf('.'),value.length()).toLowerCase();
					String basePath = request.getSession().getServletContext()
							.getRealPath("/");

					File f = new File(basePath + path);
					if (!f.exists()) {
						f.mkdirs();
					}

					item.write(new File(basePath + path + "/" + fileName));
					mapFile.add(path + "/" + fileName);
				}
			}

		} catch (FileUploadException e) {
			e.printStackTrace();
			result.put("result", "failed");
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("result", "failed");
			return result;
		}
		
		result.put("string", new Gson().toJson(mapString));
		result.put("file",mapFile);
		result.put("result", "ok");
		return result;
	}

	
	public String uploadFile(HttpServletRequest request, String path){
		try {
			request.setCharacterEncoding("utf-8");
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setHeaderEncoding("UTF-8");

			List<FileItem> items;
			items = upload.parseRequest(request);
			for (FileItem item : items) {
				if (item.isFormField()) {
					String key = item.getFieldName();
					String value = item.getString("utf-8");
				} else {
					String key = item.getFieldName();
					String value = item.getName();
					long fileLen = item.getSize();
					String mimeType = item.getContentType();
					String fileName = System.currentTimeMillis()
							+ value.substring(value.lastIndexOf('.'),
									value.length()).toLowerCase();
					String basePath = request.getSession().getServletContext()
							.getRealPath("/");

					File f = new File(basePath + path);
					if (!f.exists()) {
						f.mkdirs();
					}

					item.write(new File(basePath + path + "/" + fileName));
					return path+"/"+fileName;
				}
			}

		} catch (FileUploadException e) {
			e.printStackTrace();
			return "-1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
		return "-2";
	}
	
	public String readJSONString(HttpServletRequest request){
        StringBuffer json = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while((line = reader.readLine()) != null) {
                json.append(line);
            }
        }
        catch(Exception e) {
            System.out.println(e.toString());
        }
        return json.toString();
    }
	
	public  String readHtml(HttpServletRequest request,String fileName) {
		try {
			String basePath = request.getSession().getServletContext()
					.getRealPath("/");
			// 模板路径
			String filePath = basePath + "/"+fileName;
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

	
	public  boolean writeHtml(HttpServletRequest request,String fileName,String desc,HtmlStyleBean htmlStyleBean) {
		try {
			String basePath = request.getSession().getServletContext()
					.getRealPath("/");
			// 模板路径
			String filePath = basePath + "/"+fileName;
			FileOutputStream fileoutputstream = new FileOutputStream(filePath);// 建立文件输出流
			
			OutputStreamWriter writer = new OutputStreamWriter(
					fileoutputstream, "utf-8");
			String style="";

			if(htmlStyleBean==null){
				style=desc;
			}else{
				style=htmlStyleBean.getStyle_desc();
				int start=desc.indexOf("<tst>");
				int end=desc.indexOf("</tst>");
				
				if(start>0&&end>0){
					style=style.replace("[desc]", desc.substring(start+5,end));
				}else{
					style=style.replace("[desc]", desc);
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
	
	
}
