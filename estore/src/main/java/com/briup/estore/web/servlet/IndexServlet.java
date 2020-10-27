package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.EBook;
import com.briup.estore.bean.ECategory;
import com.briup.estore.common.exception.EstoreServiceException;
import com.briup.estore.sevice.IBookService;
import com.briup.estore.sevice.ICategoryService;
import com.briup.estore.sevice.impl.BookServiceImpl;
import com.briup.estore.sevice.impl.CategoryServiceImpl;

@WebServlet("/index.do")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ICategoryService categoryService = new CategoryServiceImpl();
		IBookService book = new BookServiceImpl();
		try {
			List<ECategory> list = categoryService.getAllCategery();
			req.setAttribute("category", list);
			List<EBook> allBook = book.getAllBook();
			req.setAttribute("allBook", allBook);
		} catch (EstoreServiceException e1) {
			e1.printStackTrace();
		}
		String name = req.getParameter("name");
		System.out.println("用户：" + name + "----登陆-----------------");
		req.setAttribute("name", name);
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
