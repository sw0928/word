package tts.moudle.api.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import android.content.Context;
public class FileUtils {


	/**
	 * 读取assest内容
	 * @param context
	 * @param fileName
	 * @return
	 */
	public static String readAssets(Context context, String fileName)
	{
		InputStream is = null;
		String content = null;
		try
		{
			is = context.getAssets().open(fileName,0);
			if (is != null)
			{

				byte[] buffer = new byte[1024];
				ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
				while (true)
				{
					int readLength = is.read(buffer);
					if (readLength == -1) break;
					arrayOutputStream.write(buffer, 0, readLength);
				}
				is.close();
				arrayOutputStream.close();
				byte[] lens = arrayOutputStream.toByteArray();
				content = new String(lens);

			}
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
			content = null;
		}
		finally
		{
			try
			{
				if (is != null) is.close();
			}
			catch (IOException ioe)
			{
				ioe.printStackTrace();
			}
		}
		return content;
	}

	/**
	 * InputStream转化为byte[]
	 * 
	 * @param inStream
	 * @return
	 * @throws IOException
	 */
	public static final byte[] getBytesFromInputStream(InputStream inStream) throws IOException {
		ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
		byte[] buff = new byte[100];
		int rc = 0;
		while ((rc = inStream.read(buff, 0, 100)) > 0) {
			swapStream.write(buff, 0, rc);
		}
		byte[] in2b = swapStream.toByteArray();
		return in2b;
	}

	/**
	 * InputStream 转化为 File
	 * 
	 * @param ins
	 * @param file
	 * @return
	 */
	public static File getFileFromInputStream(InputStream ins, File file) {
		OutputStream os;
		try {
			os = new FileOutputStream(file);
			int bytesRead = 0;
			byte[] buffer = new byte[8192];
			while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
				os.write(buffer, 0, bytesRead);
			}
			os.close();
			ins.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return file;
	}

	/**
	 * 将字符串写入指定文件(当指定的父路径中文件夹不存在时，会最大限度去创建，以保证保存成功！)
	 * 
	 * @param res
	 *            原字符串
	 *            文件路径
	 * @return 成功标记
	 */
	public static File getFileFromString(String res, File distFile) {
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		try {
			if (!distFile.getParentFile().exists())
				distFile.getParentFile().mkdirs();
			bufferedReader = new BufferedReader(new StringReader(res));
			bufferedWriter = new BufferedWriter(new FileWriter(distFile));
			char buf[] = new char[1024]; // 字符缓冲区
			int len;
			while ((len = bufferedReader.read(buf)) != -1) {
				bufferedWriter.write(buf, 0, len);
			}
			bufferedWriter.flush();
			bufferedReader.close();
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return distFile;
	}

	/**
	 * 将字节存入文件中
	 * 
	 * @param file
	 * @param bytes
	 */
	public static void writeFileData(File file, byte[] bytes) {
		try {
			FileOutputStream fout = new FileOutputStream(file);
			fout.write(bytes);
			fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 将文件 存于私有文件下
	 * 
	 * @param fileName
	 *            文件名
	 * @param context
	 */
	public static void writeFileData(String fileName, byte[] bytes, Context context) {
		try {
			FileOutputStream fout = context.openFileOutput(fileName, context.MODE_PRIVATE);
			// OutputStreamWriter outWriter = new OutputStreamWriter(fout);
			fout.write(bytes);
			fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 打开指定文件，读取其数据，返回字节对象
	 * 
	 * @param fileName
	 * @return
	 */
	public static byte[] readFileData(String fileName, Context context) {
		byte[] buffer = null;
		try {
			FileInputStream fin = context.openFileInput(fileName);
			// 获取文件长度
			int lenght = fin.available();
			buffer = new byte[lenght];
			fin.read(buffer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return buffer;
	}

}
