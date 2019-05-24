package com.dhr.web.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import com.dhr.constant.Constant;
import com.dhr.service.ProductService;
import com.dhr.service.impl.ProductServiceImpl;
import com.dhr.util.UUIDUtils;
import com.dhr.util.UploadFileUtils;
import com.dhr.web.domain.Category;
import com.dhr.web.domain.Product;
/**
 * 管理员上架商品---->直接继承HttpServlet
 * @author Mr DU
 *
 */
@WebServlet("/AdminAddProductServlet")
public class AdminAddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * 因为传来的数据不能使用request获取.所有直接使用jar包的方式
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//删除的数据由file类型和其他类型组成这里采用map来封装product
			Map<String, Object> map = new HashMap<>();
			//1.创建文件项工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//2.创建文件上传核心对象
			ServletFileUpload fileUpload = new ServletFileUpload(factory);
			//3.执行parseRequest获得请求参数返回list集合
			List<FileItem> items = fileUpload.parseRequest(request);
			//4.遍历list集合
			for(FileItem fi:items) {
				//4.1获得每一个参数的属性值
				String key = fi.getFieldName();
				//4.2如果是普通类型
				if(fi.isFormField()) {
					map.put(key, fi.getString("utf-8"));
				}else {
					//获取文件名称
					String name = fi.getName();
					//获得真实名称
					String realname = UploadFileUtils.getRealName(name);
					//获得随机名
					String uuidname = UploadFileUtils.UUIDName(realname);
					//获得一个随机目录
					String dir = UploadFileUtils.dir();
					//获得流
					InputStream is = fi.getInputStream();
					//获取product真实路径
					String productPath = getServletContext().getRealPath("/products");
					//创建文件
					File file = new File(productPath+dir);
					//判断文件夹是否存在
					if(!file.exists()) {
						file.mkdirs();
					}
					FileOutputStream os = new FileOutputStream(new File(file,uuidname));
					//对拷流
					IOUtils.copy(is, os);
					os.close();
					is.close();
					//删除临时文件
					fi.delete();
					//封装到map
					map.put(key, "products"+dir+"/"+uuidname);
				}
				
			}
			
			//封装product
			Product product = new Product();
			//手动设置其他数据
			map.put("pid", UUIDUtils.getId());
			map.put("pdate",new Date());
			map.put("pflag", Constant.IS_FLAG);
			//使用beanutils封装product和其他参数
			BeanUtils.populate(product, map);
			//手动设置category
			Category category = new Category();
			category.setCid((String)map.get("cid"));
			product.setCategory(category);
			//调用service
			ProductService ps = new ProductServiceImpl();
			ps.save(product);
			//重定向
			response.sendRedirect(request.getContextPath()+"/adminproduct?method=findAllProduct&pageNumber=1");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
