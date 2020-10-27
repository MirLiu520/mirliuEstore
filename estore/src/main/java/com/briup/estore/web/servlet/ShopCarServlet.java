package com.briup.estore.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.EBook;
import com.briup.estore.bean.ShopingCar;

@WebServlet("/shopcar.do")
public class ShopCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String book = req.getParameter("allBook");
		System.out.println("bookId:"+book);
		
		ShopingCar shopingCar=new ShopingCar();
		
		req.getRequestDispatcher("shopCar.jsp").forward(req, resp);
		
	}
}
