package com.elewei.service;

public class UserService {
	private String name;
	
	private ByService byService;
	
	public ByService getByService() {
		return byService;
	}

	public void setByService(ByService byService) {
		this.byService = byService;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void sayHello() {
		System.out.println("Hello " + name);
		byService.sayBye();
	}
	
}
