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
 * ����Ա�ϼ���Ʒ---->ֱ�Ӽ̳�HttpServlet
 * @author Mr DU
 *
 */
@WebServlet("/AdminAddProductServlet")
public class AdminAddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * ��Ϊ���������ݲ���ʹ��request��ȡ.����ֱ��ʹ��jar���ķ�ʽ
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//ɾ����������file���ͺ�������������������map����װproduct
			Map<String, Object> map = new HashMap<>();
			//1.�����ļ����
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//2.�����ļ��ϴ����Ķ���
			ServletFileUpload fileUpload = new ServletFileUpload(factory);
			//3.ִ��parseRequest��������������list����
			List<FileItem> items = fileUpload.parseRequest(request);
			//4.����list����
			for(FileItem fi:items) {
				//4.1���ÿһ������������ֵ
				String key = fi.getFieldName();
				//4.2�������ͨ����
				if(fi.isFormField()) {
					map.put(key, fi.getString("utf-8"));
				}else {
					//��ȡ�ļ�����
					String name = fi.getName();
					//�����ʵ����
					String realname = UploadFileUtils.getRealName(name);
					//��������
					String uuidname = UploadFileUtils.UUIDName(realname);
					//���һ�����Ŀ¼
					String dir = UploadFileUtils.dir();
					//�����
					InputStream is = fi.getInputStream();
					//��ȡproduct��ʵ·��
					String productPath = getServletContext().getRealPath("/products");
					//�����ļ�
					File file = new File(productPath+dir);
					//�ж��ļ����Ƿ����
					if(!file.exists()) {
						file.mkdirs();
					}
					FileOutputStream os = new FileOutputStream(new File(file,uuidname));
					//�Կ���
					IOUtils.copy(is, os);
					os.close();
					is.close();
					//ɾ����ʱ�ļ�
					fi.delete();
					//��װ��map
					map.put(key, "products"+dir+"/"+uuidname);
				}
				
			}
			
			//��װproduct
			Product product = new Product();
			//�ֶ�������������
			map.put("pid", UUIDUtils.getId());
			map.put("pdate",new Date());
			map.put("pflag", Constant.IS_FLAG);
			//ʹ��beanutils��װproduct����������
			BeanUtils.populate(product, map);
			//�ֶ�����category
			Category category = new Category();
			category.setCid((String)map.get("cid"));
			product.setCategory(category);
			//����service
			ProductService ps = new ProductServiceImpl();
			ps.save(product);
			//�ض���
			response.sendRedirect(request.getContextPath()+"/adminproduct?method=findAllProduct&pageNumber=1");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
