package tst.project.utils;

import java.security.Key;
import java.security.Security;

import javax.crypto.Cipher;
import javax.xml.namespace.QName;

import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

import tst.project.bean.member.MemberBean;
import tst.project.bean.order.OrderBean;

public class HBRUtils {
	
	/** 字符串默认键值 */
	private static String strDefaultKey = "national";

	/** 加密工具 */
	private Cipher encryptCipher = null;

	/** 解密工具 */
	private Cipher decryptCipher = null;

	/**
	 * 默认构造方法，使用默认密钥
	 * 
	 * @throws Exception
	 */
	public HBRUtils() throws Exception {
		this(strDefaultKey);
	}

	/**
	 * 指定密钥构造方法
	 * 
	 * @param strKey
	 *            指定的密钥
	 * @throws Exception
	 */
	public HBRUtils(String strKey) throws Exception {
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
		Key key = getKey(strKey.getBytes());

		encryptCipher = Cipher.getInstance("DES");
		encryptCipher.init(Cipher.ENCRYPT_MODE, key);

		decryptCipher = Cipher.getInstance("DES");
		decryptCipher.init(Cipher.DECRYPT_MODE, key);
	}
	
	/**
	 * 销售等增加积分(接口)/销售退货减少积分（接口）
	 * @throws Exception 
	 */
	public static String modifyIntegral(String member_code,String order_id,String integral,String type,String from) throws Exception{
		// 使用RPC方式调用WebService
				RPCServiceClient serviceClient = new RPCServiceClient();
				Options options = serviceClient.getOptions();
				// 指定调用WebService的URL
				EndpointReference targetEPR = new EndpointReference("http://120.55.86.143:8079/axis2/services/WebServices");
				options.setTo(targetEPR);
								
				String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
								+ "<root>"
									+ "<info>"
									+ "<INSIDERCARDNO>"+member_code+"</INSIDERCARDNO>"
									+ "<CREDATE>"+TimeUtils.getCurrentTime("yyyy-MM-dd")+"</CREDATE>"
									+ "<COMEFROM>"+from+"</COMEFROM>"
									+ "<SOURCEID>"+order_id+"</SOURCEID>"
									+ "<INTEGRAL>"+integral+"</INTEGRAL>"
									+ "<IDTYPE>"+type+"</IDTYPE>"
									+ "</info>"
								+ "</root>";
				
				HBRUtils des = new HBRUtils("shanghaihebairuiapp");
				String app = des.encrypt(xml);
				
				Object[] opAddEntryArgs = new Object[]{app};
				Class[] classes = new Class[]{String.class};
				QName opAddEntry = new QName("http://ws.apache.org/axis2","modifyIntegral");
				
				Object[] response = serviceClient.invokeBlocking(opAddEntry,opAddEntryArgs,classes);
				
				System.out.println("加密发送："+app);
				System.out.println("加密发送："+xml);

				String result = response[0].toString();
				System.out.println("直接返回："+result);
				String rnxml = des.decrypt(result);
				System.out.println("解密返回："+rnxml);
				return rnxml;
	}

	/**
	 * 储值卡余额
	 * @throws Exception 
	 */
	public static String SvcardBalance(String CardNo) throws Exception{
		// 使用RPC方式调用WebService
				RPCServiceClient serviceClient = new RPCServiceClient();
				Options options = serviceClient.getOptions();
				// 指定调用WebService的URL
				EndpointReference targetEPR = new EndpointReference("http://120.55.86.143:8079/axis2/services/WebServices");
				options.setTo(targetEPR);
								
				String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
								+ "<orders>"
									+ "<CARDNO>"+CardNo+"</CARDNO>"
								+ "</orders>";
				
				HBRUtils des = new HBRUtils("shanghaihebairuiapp");
				String app = des.encrypt(xml);
				System.out.println("加密发送："+app);
				 
				Object[] opAddEntryArgs = new Object[]{app};
				Class[] classes = new Class[]{String.class};
				QName opAddEntry = new QName("http://ws.apache.org/axis2","SvcardBalance");
				
				Object[] response = serviceClient.invokeBlocking(opAddEntry,opAddEntryArgs,classes);
				
				String result = response[0].toString();
				System.out.println("直接返回："+result);
				String rnxml = des.decrypt(result);
				System.out.println("解密返回："+rnxml);
				
				return rnxml;
	}

	/**
	 * 储值卡充值（接口）
	 * @throws Exception 
	 */
	public static void svcardPrepay(String CARDNO,String ADDMONEY) throws Exception{
		// 使用RPC方式调用WebService
				RPCServiceClient serviceClient = new RPCServiceClient();
				Options options = serviceClient.getOptions();
				// 指定调用WebService的URL
				EndpointReference targetEPR = new EndpointReference("http://120.55.86.143:8079/axis2/services/WebServices");
				options.setTo(targetEPR);
				
				String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
								+ "<orders>"
								+ "<CARDNO>"+CARDNO+"</CARDNO>"
								+ "<ADDMONEY>"+ADDMONEY+"</ADDMONEY>"
								+ "</orders>";
				
				HBRUtils des = new HBRUtils("shanghaihebairuiapp");
				String app = des.encrypt(xml);
				System.out.println("加密发送："+app);
				 
				Object[] opAddEntryArgs = new Object[]{app};
				Class[] classes = new Class[]{String.class};
				QName opAddEntry = new QName("http://ws.apache.org/axis2","SvcardPrepay");
				
				Object[] response = serviceClient.invokeBlocking(opAddEntry,opAddEntryArgs,classes);
				
				String result = response[0].toString();
				System.out.println("直接返回："+result);
				String rnxml = des.decrypt(result);
				System.out.println("解密返回："+rnxml);
	}
	
	/**
	 * 储值卡交易明细查询（接口）
	 * @throws Exception 
	 */
	public static void svcardDeal(String CARDNO) throws Exception{
		// 使用RPC方式调用WebService
				RPCServiceClient serviceClient = new RPCServiceClient();
				Options options = serviceClient.getOptions();
				// 指定调用WebService的URL
				EndpointReference targetEPR = new EndpointReference("http://120.55.86.143:8079/axis2/services/WebServices");
				options.setTo(targetEPR);
								
				String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
								+ "<orders>"
								+ "<CARDNO>"+CARDNO+"</CARDNO>"
								+ "</orders>";
				
				HBRUtils des = new HBRUtils("shanghaihebairuiapp");
				String app = des.encrypt(xml);
				System.out.println("加密发送："+app);
				 
				Object[] opAddEntryArgs = new Object[]{app};
				Class[] classes = new Class[]{String.class};
				QName opAddEntry = new QName("http://ws.apache.org/axis2","SvcardDeal");
				
				Object[] response = serviceClient.invokeBlocking(opAddEntry,opAddEntryArgs,classes);
				
				String result = response[0].toString();
				System.out.println("直接返回："+result);
				String rnxml = des.decrypt(result);
				System.out.println("解密返回："+rnxml);
	}
	

//	/**
//	 * 积分兑换使用（接口）
//	 * @throws Exception 
//	 */
//	public static String updateScore(String member_code,String order_id,String integral,String type,String from) throws Exception{
//		// 使用RPC方式调用WebService
//				RPCServiceClient serviceClient = new RPCServiceClient();
//				Options options = serviceClient.getOptions();
//				// 指定调用WebService的URL
//				EndpointReference targetEPR = new EndpointReference("http://120.55.86.143:8079/axis2/services/WebServices");
//				options.setTo(targetEPR);
//								
//				String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
//							+ "<root>"
//								+ "<info>"
//								+ "<INSIDERCARDNO>"+member_code+"</INSIDERCARDNO>"
//								+ "<CREDATE>"+TimeUtils.getCurrentTime("yyyy-MM-dd")+"</CREDATE>"
//								+ "<COMEFROM>"+from+"</COMEFROM>"
//								+ "<IDTYPE>"+type+"</IDTYPE>"
//								+ "<SOURCEID>"+order_id+"</SOURCEID>"
//								+ "<INTEGRAL>"+integral+"</INTEGRAL>"
//								+ "</info>"
//							+ "</root>";
//				
//				HBRUtils des = new HBRUtils("shanghaihebairuiapp");
//				String app = des.encrypt(xml);
//
//				 
//				Object[] opAddEntryArgs = new Object[]{app};
//				Class[] classes = new Class[]{String.class};
//				QName opAddEntry = new QName("http://ws.apache.org/axis2","UpdateScore");
//				
//				Object[] response = serviceClient.invokeBlocking(opAddEntry,opAddEntryArgs,classes);
//				
//				
//				System.out.println(xml);
//				System.out.println(app);
//				String result = response[0].toString();
//				System.out.println("直接返回："+result);
//				String rnxml = des.decrypt(result);
//				System.out.println("解密返回："+rnxml);
//				return rnxml;
//	}
//	
	/**
	 * 会员积分对账明细查询
	 * @throws Exception 
	 */
	public static void selectScore() throws Exception{
		// 使用RPC方式调用WebService
				RPCServiceClient serviceClient = new RPCServiceClient();
				Options options = serviceClient.getOptions();
				// 指定调用WebService的URL
				EndpointReference targetEPR = new EndpointReference("http://120.55.86.143:8079/axis2/services/WebServices");
				options.setTo(targetEPR);
								
				String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
								+ "<orders>"
								+ "<INSIDERCARDNO>15026592830</INSIDERCARDNO>"
								+ "</orders>";
				
				HBRUtils des = new HBRUtils("shanghaihebairuiapp");
				String app = des.encrypt(xml);
				System.out.println("加密发送："+app);
				 
				Object[] opAddEntryArgs = new Object[]{app};
				Class[] classes = new Class[]{String.class};
				QName opAddEntry = new QName("http://ws.apache.org/axis2","SelectScore");
				
				Object[] response = serviceClient.invokeBlocking(opAddEntry,opAddEntryArgs,classes);
				
				String result = response[0].toString();
				System.out.println("直接返回："+result);
				String rnxml = des.decrypt(result);
				System.out.println("解密返回："+rnxml);
	}
	
	/**
	 * 会员积分查询（接口）
	 * @throws Exception 
	 */
	public static String getScore(String member_code) throws Exception{
		// 使用RPC方式调用WebService
				RPCServiceClient serviceClient = new RPCServiceClient();
				Options options = serviceClient.getOptions();
				// 指定调用WebService的URL
				EndpointReference targetEPR = new EndpointReference("http://120.55.86.143:8079/axis2/services/WebServices");
				options.setTo(targetEPR);
								
				String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
								+ "<info>"
								+ "<INSIDERCARDNO>"+member_code+"</INSIDERCARDNO>"
								+ "</info>";
				
				HBRUtils des = new HBRUtils("shanghaihebairuiapp");
				String app = des.encrypt(xml);
				
				 
				Object[] opAddEntryArgs = new Object[]{app};
				Class[] classes = new Class[]{String.class};
				QName opAddEntry = new QName("http://ws.apache.org/axis2","GetScore");
				
				Object[] response = serviceClient.invokeBlocking(opAddEntry,opAddEntryArgs,classes);
				
				System.out.println("加密发送："+xml);
				System.out.println("加密发送："+app);
				String result = response[0].toString();
				System.out.println("直接返回："+result);
				String rnxml = des.decrypt(result);
				System.out.println("解密返回："+rnxml);
				return rnxml;
	}
	
	/**
	 * 存储卡退款
	 * @throws Exception 
	 */
	public static String refundOrder(String stored_code,String order_id,String money) throws Exception{
		// 使用RPC方式调用WebService
				RPCServiceClient serviceClient = new RPCServiceClient();
				Options options = serviceClient.getOptions();
				// 指定调用WebService的URL
				EndpointReference targetEPR = new EndpointReference("http://120.55.86.143:8079/axis2/services/WebServices");
				options.setTo(targetEPR);
				
				//String password=MD5Util.md5EncodeOrigin(psw);
				
				String xml = "<?xml version=" + "\"" + "1.0" + "\" encoding=" + "\""
						+ "UTF-8" + "\"" + "?>" + "<result class=" + "\"" + "object"
						+ "\"" + ">" + "<e class=" + "\"" + "object" + "\"" + ">"
						+ "<cardno>"+stored_code+"</cardno>" 
						//+ "<cardpwd>"+password+"</cardpwd>"
						+ "<old_appdocid>"+order_id+"</old_appdocid>"
						+ "<bakmoney>"+money+"</bakmoney>"
						+ "</e>" + "</result>";
				
				HBRUtils des = new HBRUtils("shanghaihebairuiapp");
				String app = des.encrypt(xml);
				 
				Object[] opAddEntryArgs = new Object[]{app};
				Class[] classes = new Class[]{String.class};
				QName opAddEntry = new QName("http://ws.apache.org/axis2","SvcardRefundData");
				
				Object[] response = serviceClient.invokeBlocking(opAddEntry,opAddEntryArgs,classes);

				System.out.println("加密发送："+app);

				System.out.println("直接返回："+xml);
				String result = response[0].toString();
				System.out.println("直接返回："+result);
				String rnxml = des.decrypt(result);
				System.out.println("解密返回："+rnxml);
				return rnxml;
	}
	
	/**
	 * 存储卡交易
	 * @throws Exception 
	 */
	public static String cardDealData(String stored_code,String psd,String order_ids,String money) throws Exception{
		// 使用RPC方式调用WebService
		RPCServiceClient serviceClient = new RPCServiceClient();
		Options options = serviceClient.getOptions();
		// 指定调用WebService的URL
		EndpointReference targetEPR = new EndpointReference("http://120.55.86.143:8079/axis2/services/WebServices");
		options.setTo(targetEPR);
		
		String password=MD5Util.md5EncodeOrigin(psd);
		
		String xml = "<?xml version=" + "\"" + "1.0" + "\" encoding=" + "\""
				+ "UTF-8" + "\"" + "?>" + "<result class=" + "\"" + "object"
				+ "\"" + ">" + "<e class=" + "\"" + "object" + "\"" + ">"
				+ "<cardno>"+stored_code+"</cardno>" 
				+ "<cardpwd>"+password+"</cardpwd>"
				+ "<appdocid>"+order_ids+"</appdocid>"
				+ "<realmoney>"+money+"</realmoney>"
				+ "</e>" + "</result>";
		
		HBRUtils des = new HBRUtils("shanghaihebairuiapp");
		String app = des.encrypt(xml);
		System.out.println("加密发送："+app);
		 
		Object[] opAddEntryArgs = new Object[]{app};
		Class[] classes = new Class[]{String.class};
		QName opAddEntry = new QName("http://ws.apache.org/axis2","SvcardDealData");
		
		Object[] response = serviceClient.invokeBlocking(opAddEntry,opAddEntryArgs,classes);
		
		String result = response[0].toString();
		System.out.println("直接返回："+result);
		String rnxml = des.decrypt(result);
		System.out.println("解密返回："+rnxml);
		return rnxml;
	}
	

	/**
	 * 存储卡开通
	 * @throws Exception 
	 */
	public static String cardBinding(MemberBean memberBean) throws Exception{
		// 使用RPC方式调用WebService
		RPCServiceClient serviceClient = new RPCServiceClient();
		Options options = serviceClient.getOptions();
		// 指定调用WebService的URL
		EndpointReference targetEPR = new EndpointReference("http://120.55.86.143:8079/axis2/services/WebServices");
		options.setTo(targetEPR);
		
		String password=MD5Util.md5EncodeOrigin(memberBean.getPassword());
		String xml = "<?xml version=" + "\"" + "1.0" + "\" encoding=" + "\""
				+ "UTF-8" + "\"" + "?>" + "<result class=" + "\"" + "object"
				+ "\"" + ">" + "<e class=" + "\"" + "object" + "\"" + ">"
				+ "<insidercardno>"+memberBean.getMember_code()+"</insidercardno>" 
				+ "<cardno>"+memberBean.getStored_code()+"</cardno>" 
				+ "<cardpwd>"+password+"</cardpwd>"
				+ "</e>" + "</result>";
		 
		
		HBRUtils des = new HBRUtils("shanghaihebairuiapp");
		String app = des.encrypt(xml);
		System.out.println("加密发送："+app);
		 
		Object[] opAddEntryArgs = new Object[]{app};
		Class[] classes = new Class[]{String.class};
		QName opAddEntry = new QName("http://ws.apache.org/axis2","SvcardOpenData");
		
		Object[] response = serviceClient.invokeBlocking(opAddEntry,opAddEntryArgs,classes);
		
		String result = response[0].toString();
		System.out.println("直接返回："+result);
		String rnxml = des.decrypt(result);
		System.out.println("解密返回："+rnxml);
		
		return rnxml;
	}
	
	
	/**
	 * 会员资料查询
	 * @throws Exception 
	 */
	public static String getInsiderInfo(String account) throws Exception{
		// 使用RPC方式调用WebService
		RPCServiceClient serviceClient = new RPCServiceClient();
		Options options = serviceClient.getOptions();
		// 指定调用WebService的URL
		EndpointReference targetEPR = new EndpointReference("http://120.55.86.143:8079/axis2/services/WebServices");
		options.setTo(targetEPR);
			
		System.out.println(account+"=====");
		String xml = "<?xml version=" + "\"" + "1.0" + "\" encoding=" + "\""
				+ "UTF-8" + "\"" + "?>" +"<info>"
				+ "<INSIDERCARDNO>"+account+"</INSIDERCARDNO>"
				+ "</info>";
		 
		HBRUtils des = new HBRUtils("shanghaihebairuiapp");
		String app = des.encrypt(xml);
		System.out.println("加密发送："+app);
		 
		Object[] opAddEntryArgs = new Object[]{app};
		Class[] classes = new Class[]{String.class};
		QName opAddEntry = new QName("http://ws.apache.org/axis2","getInsiderInfo");
		
		Object[] response = serviceClient.invokeBlocking(opAddEntry,opAddEntryArgs,classes);
		
		String result = response[0].toString();
		System.out.println("直接返回："+result);
		String rnxml = des.decrypt(result);
		System.out.println("解密返回："+rnxml);
		return rnxml;
	}
	
	/**
	 * 会员资料修改
	 * @throws Exception 
	 */
	public static String upInsider(MemberBean memberBean) throws Exception{
		// 使用RPC方式调用WebService
		RPCServiceClient serviceClient = new RPCServiceClient();
		Options options = serviceClient.getOptions();
		// 指定调用WebService的URL
		EndpointReference targetEPR = new EndpointReference("http://120.55.86.143:8079/axis2/services/WebServices");
		options.setTo(targetEPR);
				
		System.out.println(memberBean.getPhone()+"====="+memberBean.getNick_name()
		+"====="+memberBean.getCard_id()+"====="+memberBean.getMember_code()+"=====");
		String xml = "<?xml version=" + "\"" + "1.0" + "\" encoding=" + "\""
				+ "UTF-8" + "\"" + "?>" 
				+"<insiderinfo>"
				+ "<address>外高桥</address>"
				+ "<sex>"+("m".equals(memberBean.getSex())?"1":"2")+"</sex>"
				+ "<mobile>"+memberBean.getPhone()+"</mobile>"
				+ "<WEBUSERNAME>"+memberBean.getNick_name()+"</WEBUSERNAME>"
				+ "<IDCARD>"+memberBean.getCard_id()+"</IDCARD>"
				+ "<insidercardno>"+memberBean.getMember_code()+"</insidercardno>"
				+ "</insiderinfo>";
		 
		HBRUtils des = new HBRUtils("shanghaihebairuiapp");
		String app = des.encrypt(xml);
		System.out.println("加密发送："+app);
		 
		Object[] opAddEntryArgs = new Object[]{app};
		Class[] classes = new Class[]{String.class};
		QName opAddEntry = new QName("http://ws.apache.org/axis2","upInsider");
		
		Object[] response = serviceClient.invokeBlocking(opAddEntry,opAddEntryArgs,classes);
		
		String result = response[0].toString();
		System.out.println("直接返回："+result);
		String rnxml = des.decrypt(result);
		System.out.println("解密返回："+rnxml);
		
		System.out.println(app);
		return rnxml;
	}
	/**
	 * 注册会员
	 * @throws Exception 
	 */
	public static String registerMember(MemberBean memberBean) throws Exception{
		// 使用RPC方式调用WebService
				RPCServiceClient serviceClient = new RPCServiceClient();
				Options options = serviceClient.getOptions();
				// 指定调用WebService的URL
				EndpointReference targetEPR = new EndpointReference("http://120.55.86.143:8079/axis2/services/WebServices");
				options.setTo(targetEPR);
				String xml = "<?xml version=" + "\"" + "1.0" + "\" encoding=" + "\""
						+ "UTF-8" + "\"" + "?>" + "<result class=" + "\"" + "object"
						+ "\"" + ">" + "<e class=" + "\"" + "object" + "\"" + ">"
						//+ "<name>"+memberBean.getReal_name()+"</name>" 
						//+ "<sex>"+("m".equals(memberBean.getSex())?"1":"2")+"</sex>" 
						//+ "<age>"+TimeUtils.getAge(memberBean.getAge(), "yyyy-MM-dd")+"</age>"
						+ "<mobile>"+memberBean.getMember_account()+"</mobile>"
						//+ "<idcard>"+memberBean.getCard_id()+"</idcard>"
						//+ "<birthdate>"+memberBean.getAge()+"</birthdate>"
						//+ "<idcardtype>1</idcardtype>"
						+ "<credate>"+TimeUtils.getCurrentTime("yyyy-MM-dd")+"</credate>"
						+ "<homephone>"+memberBean.getMember_account()+"</homephone>" + "</e>" + "</result>";
				 
				HBRUtils des = new HBRUtils("shanghaihebairuiapp");
				String app = des.encrypt(xml);
				System.out.println("加密发送："+app);
				 
				Object[] opAddEntryArgs = new Object[]{app};
				Class[] classes = new Class[]{String.class};
				QName opAddEntry = new QName("http://ws.apache.org/axis2","ImpInsiderData");
				
				Object[] response = serviceClient.invokeBlocking(opAddEntry,opAddEntryArgs,classes);
				
				String result = response[0].toString();
				System.out.println("直接返回："+result);
				String rnxml = des.decrypt(result);
				System.out.println("解密返回："+rnxml);	
				return rnxml;
	}
	
	
	public static String byteArr2HexStr(byte[] arrB) throws Exception {
		int iLen = arrB.length;
		// 每个byte用两个字符才能表示，所以字符串的长度是数组长度的两倍
		StringBuffer sb = new StringBuffer(iLen * 2);
		for (int i = 0; i < iLen; i++) {
			int intTmp = arrB[i];
			// 把负数转换为正数
			while (intTmp < 0) {
				intTmp = intTmp + 256;
			}
			// 小于0F的数需要在前面补0
			if (intTmp < 16) {
				sb.append("0");
			}
			sb.append(Integer.toString(intTmp, 16));
		}
		return sb.toString();
	}

	public static byte[] hexStr2ByteArr(String strIn) throws Exception {
		byte[] arrB = strIn.getBytes();
		int iLen = arrB.length;

		// 两个字符表示一个字节，所以字节数组长度是字符串长度除以2
		byte[] arrOut = new byte[iLen / 2];
		for (int i = 0; i < iLen; i = i + 2) {
			String strTmp = new String(arrB, i, 2);
			arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
		}
		return arrOut;
	}

	/**
	 * 加密字节数组
	 * 
	 * @param arrB
	 *            需加密的字节数组
	 * @return 加密后的字节数组
	 * @throws Exception
	 */
	public byte[] encrypt(byte[] arrB) throws Exception {
		return encryptCipher.doFinal(arrB);
	}

	/**
	 * 加密字符串
	 * 
	 * @param strIn
	 *            需加密的字符串
	 * @return 加密后的字符串
	 * @throws Exception
	 */
	public String encrypt(String strIn) throws Exception {
		return byteArr2HexStr(encrypt(strIn.getBytes("gbk")));
	}

	/**
	 * 解密字节数组
	 * 
	 * @param arrB
	 *            需解密的字节数组
	 * @return 解密后的字节数组
	 * @throws Exception
	 */
	public byte[] decrypt(byte[] arrB) throws Exception {
		return decryptCipher.doFinal(arrB);
	}

	/**
	 * 解密字符串
	 * 
	 * @param strIn
	 *            需解密的字符串
	 * @return 解密后的字符串
	 * @throws Exception
	 */
	public String decrypt(String strIn) throws Exception {
		return new String(decrypt(hexStr2ByteArr(strIn)),"GBK");
	}

	private Key getKey(byte[] arrBTmp) throws Exception {
		// 创建一个空的8位字节数组（默认值为0）
		byte[] arrB = new byte[8];

		// 将原始字节数组转换为8位
		for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
			arrB[i] = arrBTmp[i];
		}

		// 生成密钥
		Key key = new javax.crypto.spec.SecretKeySpec(arrB, "DES");

		return key;
	}

}
