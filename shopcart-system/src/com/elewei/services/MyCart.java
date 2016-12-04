package com.elewei.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.elewei.domain.*;

public class MyCart {
	
	static HashMap<String,Books> hm = new HashMap<String,Books>();
	
	//添加书
	public void addBook(String id) {
		if(hm.containsKey(id)) {
			//hm已经有这本书了
			Books book = hm.get(id);
			int shoppingNum = book.getShoppingNum();
			book.setShoppingNum(shoppingNum+1);
		} else {
			hm.put(id, new BooksService().getBookById(id));
		}
		
	}
	
	
	//删除书
	public void delBook(String bookid) {
		hm.remove(bookid);
	}
	
	//显示购物车中所有商品
	public static ArrayList showMyCart() {
		
		ArrayList al = new ArrayList();
		
		//遍历HashMap
		Iterator iterator = hm.keySet().iterator();
		while(iterator.hasNext()) {
			//取出key
			String key = (String) iterator.next();
			//取出Books
			Books book = hm.get(key);
			al.add(book);
		}
		return al;
	}
	
	//更新书
	public static void updateBook(String bookid, String nums) {
		//取出ID对应的book
		Books book = hm.get(bookid);
		book.setShoppingNum(Integer.parseInt(nums));
		
	}
	
	//清空书，清空购物车
	public static void clearBook() {
		hm.clear();
	}
	
	//显示购物车的总价格
	public static float getTotalPrice() {
		float totalPrice = 0.0f;
		
		//得到总价格
		ArrayList al = new ArrayList();
		
		Iterator iterator = hm.keySet().iterator();
		while(iterator.hasNext()) {
			String key = (String) iterator.next();
			Books book = hm.get(key);
			totalPrice += book.getPrice() * book.getShoppingNum();
		}
		
		return totalPrice;
	}
	
	
	
	
}
