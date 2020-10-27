package com.briup.estore.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.ECustomer;
import com.briup.estore.common.exception.EstoreServiceException;
import com.briup.estore.sevice.IUserService;
import com.briup.estore.sevice.impl.UserServiceImpl;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//响应乱码
		resp.setCharacterEncoding("UTF8");
		//html乱码
		resp.setContentType("text/html;charset=UTF-8");
		//请求乱码
		req.setCharacterEncoding("UTF8");
		//1.接收请求
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		//2.类型转换
		
		//3.调用业务请求，执行登陆逻辑
		IUserService service=new UserServiceImpl();
		try {
			ECustomer login = service.login(name, password);
			HttpSession session=req.getSession();
			session.setAttribute("cus", login);
			//成功进入首页
			//resp.sendRedirect("/index.do");
			
			req.getRequestDispatcher("/index.do").forward(req, resp);;
		} catch (EstoreServiceException e) {
			e.printStackTrace();
			//失败，回到登陆
			req.setAttribute("erro", e.getMessage());
			
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
		
		
	}
}
