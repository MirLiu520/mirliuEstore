package com.briup.estore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.EBook;
import com.briup.estore.bean.ShopingCar;
import com.briup.estore.common.exception.EstoreServiceException;
import com.briup.estore.common.utils.BeanFactory;
import com.briup.estore.sevice.IBookViewService;
import com.briup.estore.sevice.IShopCarService;
import com.briup.estore.sevice.impl.BookViewServiceImpl;
import com.briup.estore.sevice.impl.ShopCarServiceImpl;

@WebServlet("/addcar.do")
public class AddCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int bookId = Integer.parseInt(req.getParameter("bookId"));
		int num = Integer.parseInt(req.getParameter("num"));
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("shopCar");
		ShopingCar car = null;
		if (obj==null) {
			car = new ShopingCar();
			session.setAttribute("shopCar", car);
		}else {
			car = (ShopingCar) obj;
		}
		//添加到购物车的逻辑代码调用
		IShopCarService shopCarService =new ShopCarServiceImpl();
		try {
			shopCarService.addShopCar(car, bookId, num);
		} catch (EstoreServiceException e) {
			e.printStackTrace();
		}
		
		//操作完成后统一回到returnUrl所指定的地址
		String returnurl = req.getParameter("returnUrl");
		resp.sendRedirect(req.getContextPath()+"/"+returnurl);
		
		
		
//		IBookViewService service = new BookViewServiceImpl();
//		try {
//			EBook eBook = service.selectBook(bookId);
//			ShopingCar shopingCar = new ShopingCar();
//			shopingCar.add(eBook, num);
//			session.setAttribute("Book", eBook);
//			session.setAttribute("bookId", bookId);
//			session.setAttribute("num", num);
//			session.setAttribute("shopcar", shopingCar);
//			resp.sendRedirect("shopCar.jsp");
//		} catch (EstoreServiceException e) {
//			e.printStackTrace();
//		}
//		Object obj = session.getAttribute("shopCar");
//		ShopingCar car=null;
//		if(obj==null) {
//			car=new ShopingCar();
//			session.setAttribute("shopcar", car);
//		}else {
//			car=(ShopingCar) obj;
//		}
//		IShopCarService shopCarService=BeanFactory.getBean();

	}
}
