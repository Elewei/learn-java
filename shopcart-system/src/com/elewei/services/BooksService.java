package com.elewei.services;

import com.elewei.domain.Books;
import com.elewei.utils.*;
import java.util.ArrayList;

//这是处理与books表相关的业务
public class BooksService {
	//得到所有的书籍信息
	public ArrayList getAllBook() {
		
		String sql = "select * from books where 1=?";
		String paras[] = {"1"};
		ArrayList al = new SqlHelper().executeQuery(sql, paras);
		
		ArrayList<Books> newAl = new ArrayList<Books>();
		
		//二次业务封装
		for(int i=0; i<al.size(); i++) {
			Object obj[] = (Object[]) al.get(i);
			Books book = new Books();
			book.setBookid(Integer.parseInt(obj[0].toString()));
			book.setBookname(obj[1].toString());
			book.setAuthor(obj[2].toString());
			book.setPublishHouse(obj[3].toString());
			book.setPrice(Float.parseFloat(obj[4].toString()));
			book.setBooknum(Integer.parseInt(obj[5].toString()));
			
			newAl.add(book);
		}
		
		return newAl;
	}
	
	//根据书的编号返回一个Bookbean
	public Books getBookById(String id) {
		Books book = new Books();
		String sql = "select * from books where bookid=?";
		String paras[] = {id};
		ArrayList al = new SqlHelper().executeQuery(sql, paras);
		
		if(al.size() == 1) {
			Object [] obj = (Object []) al.get(0);
			book.setBookid(Integer.parseInt(obj[0].toString()));
			book.setBookname(obj[1].toString());
			book.setAuthor(obj[2].toString());
			book.setPublishHouse(obj[3].toString());
			book.setPrice(Float.parseFloat(obj[4].toString()));
			book.setBooknum(Integer.parseInt(obj[5].toString()));
		}
		
		return book;
	}
	
	
}
