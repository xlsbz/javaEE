package cn.dhr.web.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Writer;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.prism.Image;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.IO;

import cn.dhr.web.baseservlet.BaseSerlvet;

/**
 * 验证码
 * @author Mr DU
 *
 */
@WebServlet("/code")
public class CodeServlet extends BaseSerlvet{
	private static final long serialVersionUID = 1L;
	/**
	 * 验证码
	 * @param req
	 * @param res
	 * @return
	 */
	public String code(HttpServletRequest req,HttpServletResponse res) {
		int width = 80;
		int height = 30;
		//1.创建图片缓冲区
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//2.获得图片画笔
		Graphics2D g = (Graphics2D)image.getGraphics();
		//3.填充颜色
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, width, height);
		//4.填充边框
		g.setColor(Color.gray);
		g.drawRect(0, 0, width-2, height-2);
		//5.随机数
		g.setColor(Color.red);
		g.setFont(new Font(null, Font.BOLD, 20));
		String msg = "";//session使用
		String number = "1234567890qazwsxedcrfvtgbyhnujmikolp";
		Random random = new Random();
		int x=5;
		char[] num = number.toCharArray();
		for(int i=0;i<4;i++) {
			String text = String.valueOf(num[random.nextInt(number.length())]);
			msg += text;
			g.setColor(new Color(random.nextInt(255), random.nextInt(255),random.nextInt(255)));
			g.drawString(text, x, 20);
			x+=20;
		}
		//6.随机线
		g.setColor(Color.blue);
		for(int i=0;i<6;i++) {
			int x1 = random.nextInt(width);
			int x2 = random.nextInt(width);
			int y1 = random.nextInt(height);
			int y2 = random.nextInt(height);
			g.drawLine(x1, y1, x2, y2);
		}
		g.dispose();
		//7.输出
		res.setContentType("image/jpeg");
		try {
			ImageIO.write(image, "jpg", res.getOutputStream());
			//设置session
			req.getSession().setAttribute("code", msg);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
