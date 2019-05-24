package com.dhr.web.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dhr.web.servlet.baseservlet.BaseServlet;

/**
 * 验证码工具
 * 
 * @author Mr DU
 */
@WebServlet("/code")
public class CodeServlet extends BaseServlet{
	private static final long serialVersionUID = 1L;

	public String code(HttpServletRequest req, HttpServletResponse res)  {
		int width = 80;
		int height = 30;
		// 1.创建图片
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// 2.获取图片
		Graphics2D g = (Graphics2D) image.getGraphics();
		// 3.绘制背景色
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, width, height);
		// 4.描框
		g.setColor(Color.gray);
		g.drawRect(0, 0, width - 2, height - 2);
		// 5.输出验证码内容
		g.setColor(Color.RED);
		g.setFont(new Font(null, Font.BOLD, 20));
		String msg = "";// session保存
		Random random = new Random();
		String number = "ABCDEFGHIJKLMNOPQRSTUVWZYZ0123456789";
		int x = 5;
		for (int i = 0; i < 4; i++) {
			int index = random.nextInt(number.length());
			String count = String.valueOf(number.charAt(index));
			msg += count;
			g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
			g.drawString(count, x, 21);
			x += 20;
		}
		// 6.绘制干扰线
		g.setColor(Color.gray);
		for (int i = 0; i < 6; i++) {
			int x1 = random.nextInt(width);
			int x2 = random.nextInt(width);
			int y1 = random.nextInt(height);
			int y2 = random.nextInt(height);
			g.drawLine(x1, y1, x2, y2);
		}
		g.dispose();
		res.setContentType("image/jpeg");
		try {
			ImageIO.write(image, "jpg",res.getOutputStream());
			//每次把验证码给session
			req.getSession().setAttribute("code", msg);
		}  catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 生成随机数
	 * 
	 * @return
	 */
	public static String makeNumber() {
		Random random = new Random();
		String number = "ABCDEFGHIJKLMNOPQRSTUVWZYZ0123456789";
		char[] cnumber = number.toCharArray();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			sb.append(cnumber[random.nextInt(number.length())]);
		}
		String num = sb.toString();
		return num;
	}

}
