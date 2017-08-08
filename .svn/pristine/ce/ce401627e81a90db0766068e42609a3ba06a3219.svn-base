package tst.project.utils;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.util.Hashtable;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class QRCodeUtils {
	/**
	 * 二维码和其他图片或者文字合成
	 * 
	 * @param desc
	 *            合成的文字
	 * @param compose_img
	 *            合成的图片
	 * @param qrcode
	 *            合成的二维码
	 */
	public static boolean composeQrcode(String desc, String compose_img, String qrcode, String out) {
		try {
			// 读取第一张图片
			File fileOne = new File(qrcode);
			BufferedImage ImageOneTemp = ImageIO.read(fileOne);

			BufferedImage ImageOne = modifyImageYe(ImageOneTemp, (desc == null || desc.equals("")) ? "整案科技" : desc, 150,
					20, 15,Color.BLACK);
			if (ImageOne == null) {
				return false;
			}
			int width = ImageOne.getWidth();// 图片宽度
			int height = ImageOne.getHeight();// 图片高度
			// 从图片中读取RGB
			int[] ImageArrayOne = new int[width * height];
			ImageArrayOne = ImageOne.getRGB(0, 0, width, height, ImageArrayOne, 0, width);

			// //对第二张图片做相同的处理
			// File fileTwo = new File(compose_img);
			// BufferedImage ImageTemp = ImageIO.read(fileTwo);
			// BufferedImage ImageTwo = resizeImg(ImageTemp,80,80);
			// int widthTwo = ImageTwo.getWidth();//图片宽度
			// int heightTwo = ImageTwo.getHeight();//图片高度
			// int[] ImageArrayTwo = new int[widthTwo*heightTwo];
			// ImageArrayTwo =
			// ImageTwo.getRGB(0,0,widthTwo,heightTwo,ImageArrayTwo,0,widthTwo);

			// 生成新图片
			BufferedImage ImageNew = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			ImageNew.setRGB(0, 0, width, height, ImageArrayOne, 0, width);// 设置左半部分的RGB
			// ImageNew.setRGB((width-widthTwo)/2,(height-heightTwo)/2,widthTwo,heightTwo,ImageArrayTwo,0,widthTwo);//设置右半部分的RGB
			File outFile = new File(out);
			ImageIO.write(ImageNew, "jpg", outFile);// 写图片
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage() + "============");
			return false;
		}

		return true;

	}

	
	/**
	 * 二维码和其他图片或者文字合成（顺手平 团购二维码）
	 * 
	 * @param desc
	 *            合成的文字
	 * @param compose_img
	 *            合成的图片
	 * @param qrcode
	 *            合成的二维码
	 */
	public static boolean composeQrcodeSSP(HttpServletRequest request,List<String> goods_names,String goods_price,String white_backgroup, 
			String goods_img,String fingerprint_img, String qrcode_img, String out) {
		try {
			// 读取第一张图片
			File fileOne = new File(request.getSession().getServletContext().getRealPath("/")+white_backgroup);
			BufferedImage ImageOneTemp = ImageIO.read(fileOne);
			
			BufferedImage ImageOne1 = ImageOneTemp;
			int value=910;
			for (int i = 0; i < goods_names.size(); i++) {
				String goods_name=goods_names.get(i);
				ImageOne1 = modifyImageYeNoCenter(ImageOne1,goods_name, 250,
						value, 40,Color.BLACK);
				value+=60;
			}
				
			BufferedImage ImageOne2 = modifyImageYeNoCenter(ImageOne1,goods_price, 250,
					value, 40,Color.RED);
					
			BufferedImage ImageOne = modifyImageYe(ImageOne2,"我刚发现了一个超级好货,赶紧和我一起拼团吧!", 559,
					160, 40,Color.BLACK);
			
			if (ImageOne == null) {
				return false;
			}	
			int width = ImageOne.getWidth();// 图片宽度
			int height = ImageOne.getHeight();// 图片高度
			// 从图片中读取RGB
			int[] ImageArrayOne = new int[width * height];
			ImageArrayOne = ImageOne.getRGB(0, 0, width, height, ImageArrayOne, 0, width);

			 //对第二张图片做相同的处理
			 File fileTwo = new File(request.getSession().getServletContext().getRealPath("/")+goods_img);
			 BufferedImage ImageTemp = ImageIO.read(fileTwo);
			 BufferedImage ImageTwo = resizeImg(ImageTemp,600,600);
			 int widthTwo = ImageTwo.getWidth();//图片宽度
			 int heightTwo = ImageTwo.getHeight();//图片高度
			 int[] ImageArrayTwo = new int[widthTwo*heightTwo];
			 ImageArrayTwo =ImageTwo.getRGB(0,0,widthTwo,heightTwo,ImageArrayTwo,0,widthTwo);

			 
			 File file3 = new File(request.getSession().getServletContext().getRealPath("/")+qrcode_img);
			 BufferedImage ImageTemp3 = ImageIO.read(file3);
			 BufferedImage Image3 = resizeImg(ImageTemp3,300,300);
			 int width3 = Image3.getWidth();//图片宽度
			 int height3 = Image3.getHeight();//图片高度
			 int[] ImageArray3 = new int[width3*height3];
			 ImageArray3 =Image3.getRGB(0,0,width3,height3,ImageArray3,0,width3);
			 
			 File file4 = new File(request.getSession().getServletContext().getRealPath("/")+fingerprint_img);
			 BufferedImage ImageTemp4 = ImageIO.read(file4);
			 BufferedImage Image4 = resizeImg(ImageTemp4,300,300);
			 int width4 = Image4.getWidth();//图片宽度
			 int height4 = Image4.getHeight();//图片高度
			 int[] ImageArray4 = new int[width4*height4];
			 ImageArray4 =Image4.getRGB(0,0,width4,height4,ImageArray4,0,width4);
			 
			 
			// 生成新图片
			BufferedImage ImageNew = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			ImageNew.setRGB(0, 0, width, height, ImageArrayOne, 0, width);// 设置左半部分的RGB
			ImageNew.setRGB((width-widthTwo)/2,250,widthTwo,heightTwo,ImageArrayTwo,0,widthTwo);//设置右半部分的RGB
			ImageNew.setRGB((width-width3)/2-170,1400,width3,height3,ImageArray3,0,width3);//设置右半部分的RGB
			ImageNew.setRGB((width-width4)/2+170,1400,width4,height4,ImageArray4,0,width4);//设置右半部分的RGB

			File outFile = new File(request.getSession().getServletContext().getRealPath("/")+out);
			ImageIO.write(ImageNew, "jpg", outFile);// 写图片
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage() + "============");
			return false;
		}

		return true;

	}

	/**
	 * 将源图片的BufferedImage对象生成缩略图
	 * 
	 * @param source
	 *            源图片的BufferedImage对象
	 * @param targetW
	 *            缩略图的宽
	 * @param targetH
	 *            缩略图的高
	 * @return
	 */
	public static BufferedImage resizeImg(BufferedImage source, int targetW, int targetH) {
		int type = source.getType();
		BufferedImage target = null;
		double sx = (double) targetW / source.getWidth();
		double sy = (double) targetH / source.getHeight();
		if (sx > sy) {
			sx = sy;
			targetW = (int) (sx * source.getWidth());
		} else {
			sy = sx;
			targetH = (int) (sy * source.getHeight());
		}

		if (type == BufferedImage.TYPE_CUSTOM) {
			ColorModel cm = source.getColorModel();
			WritableRaster raster = cm.createCompatibleWritableRaster(targetW, targetH);
			boolean alphaPremultiplied = cm.isAlphaPremultiplied();
			target = new BufferedImage(cm, raster, alphaPremultiplied, null);
		} else {
			target = new BufferedImage(targetW, targetH, type);
		}
		Graphics2D g = target.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.drawRenderedImage(source, AffineTransform.getScaleInstance(sx, sy));
		g.dispose();
		return target;
	}

	/**
	 * 修改图片,返回修改后的图片缓冲区（只输出一行文本）
	 */
	public static BufferedImage modifyImageYe(BufferedImage img, String desc, int width, int height, int fontsize,Color c) {
		try {
			Font font = new Font("宋体", Font.PLAIN, fontsize);
			int w = img.getWidth();
			int h = img.getHeight();
			Graphics2D g = img.createGraphics();
			g.setBackground(Color.WHITE);
			g.setColor(c);// 设置字体颜色
			if (font != null)
				g.setFont(font);
			// g.setStroke(new BasicStroke(1));
			drawString(g, desc, width, height);
			g.dispose();
		} catch (Exception e) {
			System.out.println(e.getMessage() + "===========------------");
			return null;
		}
		return img;
	}
	/**
	 * 修改图片,返回修改后的图片缓冲区（只输出一行文本）
	 */
	public static BufferedImage modifyImageYeNoCenter(BufferedImage img, String desc, int width, int height, int fontsize,Color c) {
		try {
			Font font = new Font("宋体", Font.PLAIN, fontsize);
			int w = img.getWidth();
			int h = img.getHeight();
			Graphics2D g = img.createGraphics();
			g.setBackground(Color.WHITE);
			g.setColor(c);// 设置字体颜色
			if (font != null)
				g.setFont(font);
			// g.setStroke(new BasicStroke(1));
			g.drawString(desc, width, height);
			g.dispose();
		} catch (Exception e) {
			System.out.println(e.getMessage() + "===========------------");
			return null;
		}
		return img;
	}
	
	public static void drawString(Graphics2D g, String str, int xPos, int yPos) {
		int strWidth = g.getFontMetrics().stringWidth(str);
		g.drawString(str, xPos-strWidth / 2, yPos);
	}

	public static Boolean CreateQrcode(HttpServletRequest request, String path, String desc) {
		try {
			int width = 300;
			int height = 300;
			String format = "png";
			Hashtable hints = new Hashtable();
			hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
			BitMatrix bitMatrix = new MultiFormatWriter().encode(desc, BarcodeFormat.QR_CODE, width, height, hints);
			File outputFile = new File(request.getSession().getServletContext().getRealPath("/") + path);
			MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);

			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
