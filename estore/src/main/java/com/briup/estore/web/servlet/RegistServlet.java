package com.briup.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.ECustomer;
import com.briup.estore.common.exception.EstoreServiceException;
import com.briup.estore.sevice.IUserService;
import com.briup.estore.sevice.impl.UserServiceImpl;
/**
 * 	接收客户端发送的请求，调用业务代码执行业务处理
 * 	给客户端浏览器响应，
 * @author Mir Liu
 * 
 * regist.jsp---->registServlet
 *
 */
@WebServlet("/regist.do")
public class RegistServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");//避免post发送乱码
		resp.setCharacterEncoding("UTF-8");
		//1 请求参数
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String zip = req.getParameter("zip");
		String tel = req.getParameter("tel");
		String adres = req.getParameter("adres");
		String email = req.getParameter("email");
		//2.类型转换，数据封装
		ECustomer cus= new ECustomer();
		cus.setUsername(username);
		cus.setPassword(password);
		cus.setZip(zip);
		cus.setPhone(tel);
		cus.setAddress(adres);
		cus.setEmail(email);
		//3.调用业务方法，执行业务处理
		IUserService service=new UserServiceImpl();//获取业务对象
		try {
			boolean b = service.register(cus);
			//4.根据业务结果，跳转不同页面
			//成功跳转
			resp.sendRedirect("/estore/login.html");
		} catch (EstoreServiceException e) {
			e.printStackTrace();
			//失败跳回重新注册
			req.setAttribute("msg", e.getMessage());
			req.getRequestDispatcher("/regist.jsp").forward(req, resp);
		}
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
}
