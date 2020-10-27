package com.briup.estore.bean;

import java.util.Collection;

/**
 * 	用来在内存中维护，一个用户的购物车 信息
 * @author Mir Liu
 *
 */

import java.util.HashMap;
import java.util.Map;

public class ShopingCar {
	private Map<Integer, EOrderline> car = new HashMap<>();
	/**
	 * 	添加到购物车的行为
	 * 
	 */
	public void add(EBook book, int num) {
		// 先判断图书信息是否存在
		EOrderline line = car.get(book.getId());
		if (line==null) {
			line = new EOrderline();
			line.setBook(book);
			line.setNum(num);
			car.put(book.getId(), line);
			
		}else {//如果存在，修改该项的购买数量
			line.setNum(line.getNum()+num);
		}
		
	}
	/**
	 * 	从购物车移除
	 */
	public void remove(Integer bookId) {
		car.remove(bookId);
	}
	/**
	 * 清空购物车
	 */
	public void clear() {
		car.clear();
	}
	/**
	 * 获取购物车商品总件数
	 */
	public int getCountNum() {
		int count=0;
		for(EOrderline line:car.values()) {
			count+=line.getNum();
		}
		return count;
	}
	/**
	 * 获取商品总价
	 */
	public double getTotal() {
		double total=0.0;
		for (EOrderline line:car.values()) {
			total+=line.getNum()*line.getBook().getPrice();
		}
		return total;
	}
	/**
	 * 	获取购物车商品列表
	 */
	public Collection<EOrderline> getItems(){
		return car.values();
	}
	
}
