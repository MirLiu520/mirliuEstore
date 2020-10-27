package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.ECustomer;
import com.briup.estore.bean.EOrder;
import com.briup.estore.bean.EOrderline;
import com.briup.estore.bean.ShopingCar;
import com.briup.estore.sevice.IOrderService;
import com.briup.estore.sevice.impl.OrderServiceImpl;

@WebServlet("/order/addOrder.do")
public class AddOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//订单-->用户 id,order_date,total
		//订单项--->shopCar,
		HttpSession session=req.getSession();
		ECustomer cus = (ECustomer) session.getAttribute("cus");
		//购物车中商品就是下订单的商品,所以先获取购物车信息
		ShopingCar shopcar=(ShopingCar)session.getAttribute("shopCar");
		EOrder order=new EOrder();
		order.setCustomerId(cus.getId());
		order.setOrderdate(new Date());
		order.setTotal(shopcar.getTotal());
		Collection<EOrderline> lines = shopcar.getItems();
		order.setLines(lines);//完整的订单数据
		//调用下订单的业务方法，将生成的订单信息插入数据库中
		IOrderService orderService=new OrderServiceImpl();
		try {
			orderService.saveOrder(order);
			shopcar.clear();
			req.getRequestDispatcher("/order/orderSure.jsp").forward(req, resp);
		}catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect(req.getContextPath()+"/order/confirm.jsp");
		}
		
	}
}
