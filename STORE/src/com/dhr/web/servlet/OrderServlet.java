package com.dhr.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dhr.constant.Constant;
import com.dhr.service.OrderService;
import com.dhr.service.impl.OrderServiceImpl;
import com.dhr.util.BeanFactory;
import com.dhr.util.PaymentUtil;
import com.dhr.util.UUIDUtils;
import com.dhr.web.domain.Cart;
import com.dhr.web.domain.CartItem;
import com.dhr.web.domain.Order;
import com.dhr.web.domain.OrderItem;
import com.dhr.web.domain.PageBean;
import com.dhr.web.domain.Product;
import com.dhr.web.domain.User;
import com.dhr.web.servlet.baseservlet.BaseServlet;
/**
 * ����������
 * @author Mr DU
 *
 */
@WebServlet("/order")
public class OrderServlet extends BaseServlet{
	private static final long serialVersionUID = 1L;
	/**
	 * ���涩��
	 * @param req
	 * @param res
	 * @return
	 * 	private String oid;//�������
		private Date ordertime;//����ʱ��
		private double total;//�����ܽ��
		private Integer state;//����״̬
		private User user;//����:�û�  n:1 ��n��һ����һ��1��һ������
		private List<OrderItem> items = new ArrayList<>();//����:������  1:n  ��1��һ������Ҫ���Է�һ��n��һ���ļ���
	 * @throws Exception 
	 */
	public String saveOrder(HttpServletRequest req,HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();
		//0.��ȡ���session����
		Cart cart = (Cart) session.getAttribute("cart");
		User user = (User) session.getAttribute("user");
		try {
			//1.��Ҫʲô�ͷ�װʲô����
			Order order = new Order();
			order.setOid(UUIDUtils.getId());
			order.setOrdertime(new Date());
			order.setTotal(cart.getTotal());
			order.setState(Constant.ORDER_NO);
			order.setUser(user);
			//���������������Щ������
			for(CartItem ci : cart.getCartItems()) {
				OrderItem orderItem = new OrderItem();
				orderItem.setItemid(UUIDUtils.getId());
				orderItem.setCount(ci.getCount());
				orderItem.setSubtotal(ci.getSubtotal());
				orderItem.setProduct(ci.getProduct());
				orderItem.setOrder(order);
				//�Ѷ���������ݼ��뵽������
				order.getItems().add(orderItem);
			}
			//2.����service����ҵ��
			OrderService os = (OrderService) BeanFactory.getBean("OrderService");
			os.saveOrder(order);
			//3.��order���浽�Ự��,�ض���
			session.setAttribute("order", order);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg", "�Ự�ѹ���,��Ӷ���ʧ��,�����µ�¼");
			return "/jsp/msg.jsp";
		}
		res.sendRedirect(req.getContextPath()+"/jsp/order_info.jsp");
		//�����ɺ�������ﳵ����
		cart.clearCart();
		return null;
	}
	/**
	 * ȡ������
	 * @param req
	 * @param res
	 * @return
	 */
	public String deleteOrder(HttpServletRequest req,HttpServletResponse res) {
		try {
			//1.��ȡ������
			String oid = req.getParameter("oid");
			//2.����service����
			OrderService os = (OrderService) BeanFactory.getBean("OrderService");
			os.deleteOrder(oid);
			req.setAttribute("msg", "�������"+oid+"ȡ���ɹ�!");
		} catch (Exception e) {
			req.setAttribute("msg", "����ȡ��ʧ��!");
			e.printStackTrace();
		}
		//3.����ת��
		return "/jsp/msg.jsp";
	}
	/**
	 * ��ѯ�ҵ����ж���
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	public String findOrderByPage(HttpServletRequest req,HttpServletResponse res) throws Exception{
		try {
			//1.��ȡpageNumber,����pagesize,��ȡ��ǰ�û�id
			int pageNumber=1;
			int pageSize = 3;
			pageNumber = Integer.parseInt(req.getParameter("pageNumber"));
			String userid = (String)req.getSession().getAttribute("userid");
			//2.����pageBean
			PageBean<Order> pageBean = null;
			//3.����service����,����beanpage
			OrderService os = (OrderService) BeanFactory.getBean("OrderService");
			pageBean = os.findOrderByPage(pageNumber,pageSize,userid);
			//4.������������ת��
			req.setAttribute("pageBean", pageBean);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("msg", "��ȡ����ʧ��");
			return "/jsp/msg.jsp";
		}
		return "/jsp/order_list.jsp";
	}
	/**
	 * �鿴���鹺��
	 * ��ѯĳ������
	 * @param req
	 * @param res
	 * @return
	 * @throws IOException
	 */
	public String gotoOrder(HttpServletRequest req,HttpServletResponse res) throws IOException {
		try {
			//1.��ȡ����ID
			String oid = req.getParameter("oid");
			//2.���ݶ���ID��ѯ���������Ʒ��Ϣ
			OrderService os = (OrderService) BeanFactory.getBean("OrderService");
			Order order = os.getById(oid);
			//3.�Ѳ������order��������
			req.getSession().setAttribute("order", order);
		} catch (Exception e) {
			req.setAttribute("msg", "�µ�ʧ��!���µ�¼���Կ�");
			e.printStackTrace();
		}
		res.sendRedirect(req.getContextPath()+"/jsp/order_info.jsp");
		return null;
	}
	/**
	 * ȷ���ջ�
	 * @param req
	 * @param res
	 * @return
	 */
	public String sureOrder(HttpServletRequest req,HttpServletResponse res) {
		try {
			String oid = req.getParameter("oid");
			OrderService os = new OrderServiceImpl();
			Order order = new Order();
			order.setOid(oid);
			order.setState(3);
			os.updateOrder(order);
			req.setAttribute("msg", "�ջ��ɹ�,��ȥ���۰�!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/jsp/msg.jsp";
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * ֧������
	 * @param req
	 * @param res
	 * @return
	 */
	public String pay(HttpServletRequest request,HttpServletResponse respone) throws Exception{
		//���ܲ���
		String address=request.getParameter("address");
		String name=request.getParameter("name");
		String telephone=request.getParameter("telephone");
		String oid=request.getParameter("oid");
		//ͨ��id��ȡorder����
		OrderService os = (OrderService) BeanFactory.getBean("OrderService");
		Order order = os.getById(oid);
		//��ҳ�洫���Ĳ�����װ��order
		order.setAddress(address);
		order.setName(name);
		order.setTelephone(telephone);
		//����order����
		os.updateOrder(order);
		
		// ��֯����֧����˾��Ҫ��Щ����
		String pd_FrpId = request.getParameter("pd_FrpId");
		String p0_Cmd = "Buy";
		String p1_MerId = ResourceBundle.getBundle("merchantInfo").getString("p1_MerId");
		String p2_Order = oid;
		String p3_Amt = "0.01";
		String p4_Cur = "CNY";
		String p5_Pid = "";
		String p6_Pcat = "";
		String p7_Pdesc = "";
		// ֧���ɹ��ص���ַ ---- ������֧����˾����ʡ��û�����
		// ������֧�����Է�����ַ
		String p8_Url = ResourceBundle.getBundle("merchantInfo").getString("responseURL");
		String p9_SAF = "";
		String pa_MP = "";
		String pr_NeedResponse = "1";
		// ����hmac ��Ҫ��Կ
		String keyValue = ResourceBundle.getBundle("merchantInfo").getString("keyValue");
		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
				p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
				pd_FrpId, pr_NeedResponse, keyValue);
	
		//���͸�������
		StringBuffer sb = new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
		sb.append("p0_Cmd=").append(p0_Cmd).append("&");
		sb.append("p1_MerId=").append(p1_MerId).append("&");
		sb.append("p2_Order=").append(p2_Order).append("&");
		sb.append("p3_Amt=").append(p3_Amt).append("&");
		sb.append("p4_Cur=").append(p4_Cur).append("&");
		sb.append("p5_Pid=").append(p5_Pid).append("&");
		sb.append("p6_Pcat=").append(p6_Pcat).append("&");
		sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
		sb.append("p8_Url=").append(p8_Url).append("&");
		sb.append("p9_SAF=").append(p9_SAF).append("&");
		sb.append("pa_MP=").append(pa_MP).append("&");
		sb.append("pd_FrpId=").append(pd_FrpId).append("&");
		sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
		sb.append("hmac=").append(hmac);
		
		respone.sendRedirect(sb.toString());
		
		return null;
	}
	/**
	 * �ص���Ϣ
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public String callback(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String p1_MerId = request.getParameter("p1_MerId");
		String r0_Cmd = request.getParameter("r0_Cmd");
		String r1_Code = request.getParameter("r1_Code");
		String r2_TrxId = request.getParameter("r2_TrxId");
		String r3_Amt = request.getParameter("r3_Amt");
		String r4_Cur = request.getParameter("r4_Cur");
		String r5_Pid = request.getParameter("r5_Pid");
		String r6_Order = request.getParameter("r6_Order");
		String r7_Uid = request.getParameter("r7_Uid");
		String r8_MP = request.getParameter("r8_MP");
		String r9_BType = request.getParameter("r9_BType");
		String rb_BankId = request.getParameter("rb_BankId");
		String ro_BankOrderId = request.getParameter("ro_BankOrderId");
		String rp_PayDate = request.getParameter("rp_PayDate");
		String rq_CardNo = request.getParameter("rq_CardNo");
		String ru_Trxtime = request.getParameter("ru_Trxtime");
		// ���У�� --- �ж��ǲ���֧����˾֪ͨ��
		String hmac = request.getParameter("hmac");
		String keyValue = ResourceBundle.getBundle("merchantInfo").getString(
				"keyValue");

		// �Լ����������ݽ��м��� --- �Ƚ�֧����˾������hamc
		boolean isValid = PaymentUtil.verifyCallback(hmac, p1_MerId, r0_Cmd,
				r1_Code, r2_TrxId, r3_Amt, r4_Cur, r5_Pid, r6_Order, r7_Uid,
				r8_MP, r9_BType, keyValue);
		if (isValid) {
			// ��Ӧ������Ч
			if (r9_BType.equals("1")) {
				// ������ض���
				request.setAttribute("msg", "���Ķ�����Ϊ:"+r6_Order+",���Ϊ:"+r3_Amt+"�Ѿ�֧���ɹ�,�ȴ�����~~");
				
			} else if (r9_BType.equals("2")) {
				// ��������Ե� --- ֧����˾֪ͨ��
				System.out.println("����ɹ���222");
				// �޸Ķ���״̬ Ϊ�Ѹ���
				// �ظ�֧����˾
				response.getWriter().print("success");
			}
			
			//�޸Ķ���״̬
			OrderService os= (OrderService) BeanFactory.getBean("OrderService");
			Order order = os.getById(r6_Order);
			order.setState(1);
			os.updateOrder(order);
		} else {
			// ������Ч
			System.out.println("���ݱ��۸ģ�");
		}
		return "/jsp/msg.jsp";
		
	}
}
