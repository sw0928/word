package tst.project.utils;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.dom4j.DocumentHelper;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XmlUtils {
	/**
	 * map转成xml
	 * 
	 * @param arr
	 * @return
	 */
	public static String ArrayToXml(Map<String, String> arr) {
		String xml = "<xml>";

		Iterator<Entry<String, String>> iter = arr.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<String, String> entry = iter.next();
			String key = entry.getKey();
			String val = entry.getValue();
			xml += "<" + key + ">" + val + "</" + key + ">";
		}

		xml += "</xml>";
		return xml;
	}

	public static Document getDocumentByXml(String xml){
		try{
			StringReader sr = new StringReader(xml); 
			InputSource is = new InputSource(sr); 
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
			DocumentBuilder builder=factory.newDocumentBuilder(); 
			Document doc = builder.parse(is);
			
			//Document document = (Document) DocumentHelper.parseText(xml); 
			return doc;
		}catch(Exception e){
			return null;
		}
	}
	public static String getValueByTagName(Document doc, String tagName) {
		if (doc == null) {
			return "";
		}
		NodeList pl = doc.getElementsByTagName(tagName);
		if (pl != null && pl.getLength() > 0) {
			return pl.item(0).getTextContent();
		}
		return "";
	}

	// XML转字符串 原样取出
	public static String getXmlString(Document doc) {
		TransformerFactory tf = TransformerFactory.newInstance();
		try {
			Transformer t = tf.newTransformer();
			t.setOutputProperty(OutputKeys.ENCODING, "UTF-8");// 解决中文问题，试过用GBK不行
			t.setOutputProperty(OutputKeys.METHOD, "html");
			t.setOutputProperty(OutputKeys.VERSION, "4.0");
			t.setOutputProperty(OutputKeys.INDENT, "no");
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			t.transform(new DOMSource(doc), new StreamResult(bos));
			return bos.toString();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		return "";
	}
}
