package com.briup.estore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.EBook;
import com.briup.estore.common.exception.EstoreServiceException;
import com.briup.estore.sevice.IBookViewService;
import com.briup.estore.sevice.impl.BookViewServiceImpl;

@WebServlet("/view.do")
public class ViewBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int bookId = Integer.parseInt(req.getParameter("bookId"));
		System.out.println("-----id:"+bookId+"------");
		IBookViewService service=new BookViewServiceImpl();
		try {
			EBook eBook = service.selectBook(bookId);
			req.setAttribute("Book", eBook);
			System.out.println(eBook);
			req.getRequestDispatcher("viewBook.jsp").forward(req, resp);
		} catch (EstoreServiceException e) {
			e.printStackTrace();
		}
		
	}
}
