package tst.project.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import tst.project.bean.ExcelBean;

public class ExcelUtils {
	
	public final static boolean exportExcel2(String fileName, List<ExcelBean> dataBeans, List<Map> maps,HttpServletResponse response) {
		String result = "系统提示：Excel文件导出成功！";
		// 以下开始输出到EXCEL
		try {
//			// 定义输出流，以便打开保存对话框______________________begin
//			OutputStream os = response.getOutputStream();// 取得输出流
//			response.reset();// 清空输出流
//			response.setHeader("Content-disposition",
//					"attachment; filename=" + new String(fileName.getBytes("utf8"), "utf8"));
//			// 设定输出文件头
//			response.setContentType("application/msexcel");// 定义输出类型
//			// 定义输出流，以便打开保存对话框_______________________end

			OutputStream os=new FileOutputStream(fileName);
			
			/** **********创建工作簿************ */
			WritableWorkbook workbook = jxl.Workbook.createWorkbook(os);

			/** **********创建工作表************ */

			WritableSheet sheet = workbook.createSheet("Sheet1", 0);

			/** **********设置纵横打印（默认为纵打）、打印纸***************** */
			jxl.SheetSettings sheetset = sheet.getSettings();
			sheetset.setProtected(false);

			/** ************设置单元格字体************** */
			WritableFont NormalFont = new WritableFont(WritableFont.ARIAL, 10);
			WritableFont BoldFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);

			/** ************以下设置三种单元格样式，灵活备用************ */
			// 用于标题居中
			WritableCellFormat wcf_center = new WritableCellFormat(BoldFont);
			wcf_center.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
			wcf_center.setVerticalAlignment(VerticalAlignment.CENTRE); // 文字垂直对齐
			wcf_center.setAlignment(Alignment.CENTRE); // 文字水平对齐
			wcf_center.setWrap(false); // 文字是否换行

			// 用于正文居左
			WritableCellFormat wcf_left = new WritableCellFormat(NormalFont);
			wcf_left.setBorder(Border.NONE, BorderLineStyle.THIN); // 线条
			wcf_left.setVerticalAlignment(VerticalAlignment.CENTRE); // 文字垂直对齐
			wcf_left.setAlignment(Alignment.LEFT); // 文字水平对齐
			wcf_left.setWrap(false); // 文字是否换行

			/** ***************以下是EXCEL开头大标题，暂时省略********************* */
			// sheet.mergeCells(0, 0, colWidth, 0);
			// sheet.addCell(new Label(0, 0, "XX报表", wcf_center));
			/** ***************以下是EXCEL第一行列标题********************* */
			for (int i = 0; i < dataBeans.size(); i++) {
				sheet.addCell(new Label(i, 0, dataBeans.get(i).getName(), wcf_center));
			}
			/** ***************以下是EXCEL正文数据********************* */
			int i = 1;
			for (Map map : maps) {
				for (int j = 0; j < dataBeans.size(); j++) {
					try{
						sheet.addCell(new Label(j, i, map.get(dataBeans.get(j).getType()).toString(), wcf_left));
					} catch(Exception e){
						sheet.addCell(new Label(j, i, "", wcf_left));
					}
				}
				i++;
			}
			/** **********将以上缓存中的内容写到EXCEL文件中******** */
			workbook.write();
			/** *********关闭文件************* */
			workbook.close();
			
			return true;

		} catch (Exception e) {
			result = "系统提示：Excel文件导出失败，原因：" + e.toString();
			System.out.println(result);
			e.printStackTrace();
			return false;
		}
	}

	public final static boolean exportExcel(String fileName, List<ExcelBean> dataBeans, List<Object> listContent,HttpServletResponse response) {
		String result = "系统提示：Excel文件导出成功！";
		// 以下开始输出到EXCEL
		try {
//			// 定义输出流，以便打开保存对话框______________________begin
//			OutputStream os = response.getOutputStream();// 取得输出流
//			response.reset();// 清空输出流
//			response.setHeader("Content-disposition",
//					"attachment; filename=" + new String(fileName.getBytes("utf8"), "utf8"));
//			// 设定输出文件头
//			response.setContentType("application/msexcel");// 定义输出类型
//			// 定义输出流，以便打开保存对话框_______________________end

			OutputStream os=new FileOutputStream(fileName);
			
			/** **********创建工作簿************ */
			WritableWorkbook workbook = jxl.Workbook.createWorkbook(os);

			/** **********创建工作表************ */

			WritableSheet sheet = workbook.createSheet("Sheet1", 0);

			/** **********设置纵横打印（默认为纵打）、打印纸***************** */
			jxl.SheetSettings sheetset = sheet.getSettings();
			sheetset.setProtected(false);

			/** ************设置单元格字体************** */
			WritableFont NormalFont = new WritableFont(WritableFont.ARIAL, 10);
			WritableFont BoldFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);

			/** ************以下设置三种单元格样式，灵活备用************ */
			// 用于标题居中
			WritableCellFormat wcf_center = new WritableCellFormat(BoldFont);
			wcf_center.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
			wcf_center.setVerticalAlignment(VerticalAlignment.CENTRE); // 文字垂直对齐
			wcf_center.setAlignment(Alignment.CENTRE); // 文字水平对齐
			wcf_center.setWrap(false); // 文字是否换行

			// 用于正文居左
			WritableCellFormat wcf_left = new WritableCellFormat(NormalFont);
			wcf_left.setBorder(Border.NONE, BorderLineStyle.THIN); // 线条
			wcf_left.setVerticalAlignment(VerticalAlignment.CENTRE); // 文字垂直对齐
			wcf_left.setAlignment(Alignment.LEFT); // 文字水平对齐
			wcf_left.setWrap(false); // 文字是否换行

			/** ***************以下是EXCEL开头大标题，暂时省略********************* */
			// sheet.mergeCells(0, 0, colWidth, 0);
			// sheet.addCell(new Label(0, 0, "XX报表", wcf_center));
			/** ***************以下是EXCEL第一行列标题********************* */
			for (int i = 0; i < dataBeans.size(); i++) {
				sheet.addCell(new Label(i, 0, dataBeans.get(i).getName(), wcf_center));
			}
			/** ***************以下是EXCEL正文数据********************* */
			int i = 1;
			for (Object obj : listContent) {
				for (int j = 0; j < dataBeans.size(); j++) {
					Field field= obj.getClass().getDeclaredField(dataBeans.get(j).getType());
					if(field!=null){
						field.setAccessible(true);
						Object va = field.get(obj);
						if (va == null) {
							va = "";
						}
						sheet.addCell(new Label(j, i, va.toString(), wcf_left));
					}
				}
				i++;
			}
			/** **********将以上缓存中的内容写到EXCEL文件中******** */
			workbook.write();
			/** *********关闭文件************* */
			workbook.close();
			
			return true;

		} catch (Exception e) {
			result = "系统提示：Excel文件导出失败，原因：" + e.toString();
			System.out.println(result);
			e.printStackTrace();
			return false;
		}
	}

	// 判断excel版本
	static Workbook openWorkbook(InputStream in, String filename) throws IOException {
		Workbook wb = null;
		if (filename.endsWith(".xlsx")) {
			wb = new XSSFWorkbook(in);// Excel 2007
		} else {
			wb = new HSSFWorkbook(in);// Excel 2003
		}
		return wb;
	}

	// 商品excle
	public static String readExcel(String fileName) throws Exception {
		String json = "[";
		InputStream in = new FileInputStream(fileName);
		Workbook wb = openWorkbook(in, fileName);
		Sheet sheet = (Sheet) wb.getSheetAt(0);
		Row row = null;

		int totalRows = sheet.getPhysicalNumberOfRows();
		int totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
		// 循环行Row
		for (int i = 1; i < totalRows; i++) {
			System.out.println(i+"----====================");

			row = sheet.getRow(i);
			
			if(row.getCell(0)==null||"".equals(row.getCell(0).toString().trim())){
				break;
			}
			
			String row_json = "{";
			for (int j = 0; j < totalCells; j++) {

				//Cell cell = row.getCell(j);
				//System.out.println(cell);
				if (i > 1) {// 非第一行 和 第二行
					row_json += "\"" + getValueXssf(sheet.getRow(1).getCell(j)) + "\":\"" + getValueXssf(row.getCell(j)) + "\"";
					if (j < totalCells - 1) {// 倒数第二列不加逗号
						row_json += ",";
					}
				}
			}
			
			row_json += "}";
			if (i > 1) {
				json += row_json;
				//if (i < totalRows - 1) {// 倒数第二行 不加逗号
					json += ",";
				//}
			}
			
		}
		json=json.substring(0,json.length()-1);
		json += "]";

		return json;
	}

	// 解决excel类型问题，获得数值
	public String getValueHssf(Cell cell) {
		String value = "";
		if (null == cell) {
			return value;
		}
		switch (cell.getCellType()) {
		// 数值型
		case Cell.CELL_TYPE_NUMERIC:
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				// 如果是date类型则 ，获取该cell的date值
				Date date = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				value = format.format(date);
				;
			} else {// 纯数字
				BigDecimal big = new BigDecimal(cell.getNumericCellValue());
				value = big.toString();
				// 解决1234.0 去掉后面的.0
				if (null != value && !"".equals(value.trim())) {
					String[] item = value.split("[.]");
					if (1 < item.length && "0".equals(item[1])) {
						value = item[0];
					}
				}
			}
			break;
		// 字符串类型
		case Cell.CELL_TYPE_STRING:
			value = cell.getStringCellValue().toString();
			break;
		// 公式类型
		case Cell.CELL_TYPE_FORMULA:
			// 读公式计算值
			value = String.valueOf(cell.getNumericCellValue());
			if (value.equals("NaN")) {// 如果获取的数据值为非法值,则转换为获取字符串
				value = cell.getStringCellValue().toString();
			}
			break;
		// 布尔类型
		case Cell.CELL_TYPE_BOOLEAN:
			value = " " + cell.getBooleanCellValue();
			break;
		// 空值
		case Cell.CELL_TYPE_BLANK:
			value = "";
			break;
		// 故障
		case Cell.CELL_TYPE_ERROR:
			value = "";
			break;
		default:
			value = cell.getStringCellValue().toString();
		}
		if ("null".endsWith(value.trim())) {
			value = "";
		}
		return value;
	}

	// 解决excel类型问题，获得数值 03版
	public static String getValueXssf(Cell cell) {
		String value = "";
		if (null == cell) {
			return value;
		}
		switch (cell.getCellType()) {
		// 数值型
		case Cell.CELL_TYPE_NUMERIC:
			if (XSSFDateUtil.isCellDateFormatted(cell)) {
				// 如果是date类型则 ，获取该cell的date值
				Date date = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				value = format.format(date);
				;
			} else {// 纯数字
				BigDecimal big = new BigDecimal(cell.getNumericCellValue());
				value = big.toString();
				// 解决1234.0 去掉后面的.0
				if (null != value && !"".equals(value.trim())) {
					String[] item = value.split("[.]");
					if (1 < item.length && "0".equals(item[1])) {
						value = item[0];
					}
				}
			}
			break;
		// 字符串类型
		case Cell.CELL_TYPE_STRING:
			value = cell.getStringCellValue().toString();
			break;
		// 公式类型
		case Cell.CELL_TYPE_FORMULA:
			// 读公式计算值
			value = String.valueOf(cell.getNumericCellValue());
			if (value.equals("NaN")) {// 如果获取的数据值为非法值,则转换为获取字符串
				value = cell.getStringCellValue().toString();
			}
			break;
		// 布尔类型
		case Cell.CELL_TYPE_BOOLEAN:
			value = " " + cell.getBooleanCellValue();
			break;
		// 空值
		case Cell.CELL_TYPE_BLANK:
			value = "";
			break;
		// 故障
		case Cell.CELL_TYPE_ERROR:
			value = "";
			break;
		default:
			value = cell.getStringCellValue().toString();
		}
		if ("null".endsWith(value.trim())) {
			value = "";
		}
		return value;
	}

	// 07版 date类型
	public static class XSSFDateUtil extends DateUtil {
		protected static int absoluteDay(Calendar cal, boolean use1904windowing) {
			return DateUtil.absoluteDay(cal, use1904windowing);
		}
	}
}
