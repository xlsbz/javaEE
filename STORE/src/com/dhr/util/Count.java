package com.dhr.util;
/**
 * 统计访问量
 * @author Mr DU
 *
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Count extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//定义大数
	public BigInteger bigNumber = null;

	public BigInteger loadCount(File file) throws FileNotFoundException {
		BigInteger bigNumber = null;//接收数据
		if (file.exists()) {
			Scanner scanner = new Scanner(new FileInputStream(file));
			if (scanner.hasNext()) {
				//如果存在这个文件就读取里面的数
				bigNumber = new BigInteger(scanner.next());
				scanner.close();
			} else {
				//如果不存在就创建一个大数并保持
				bigNumber = new BigInteger("0");
				save(file, bigNumber);
			}
		}
		return bigNumber;
	}

	// 保存
	public void save(File file, BigInteger bigNumber) {
		PrintWriter printWriter;
		try {
			printWriter = new PrintWriter(new FileOutputStream(file));
			printWriter.println(bigNumber);
			printWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void count(HttpServletRequest req) {
		HttpSession session = req.getSession();
		String path = "D:\\workspaceJavaEE\\STORE\\src\\count.txt";
		File file = new File(path);
		
			synchronized (this) {
				try {
					bigNumber = loadCount(file);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				bigNumber = bigNumber.add(new BigInteger("1"));// 在原本基础上加1
				save(file, bigNumber);
		session.setAttribute("count", bigNumber);
		}
	}
}
