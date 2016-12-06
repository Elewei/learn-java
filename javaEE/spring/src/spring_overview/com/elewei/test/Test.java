package com.elewei.test;
import com.elewei.service.UserService;
import com.elewei.util.ApplicationContextUtil;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		UserService userService = (UserService) ac.getBean("userService");
//		userService.sayHello();
		
//		ByService byService = (ByService) ac.getBean("byService");
//		byService.sayBye();
		
		((UserService)ApplicationContextUtil.getApplicationContextUtil().getBean("userService")).sayHello();;
		
	}

}
