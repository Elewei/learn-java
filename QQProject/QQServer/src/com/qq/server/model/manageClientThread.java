package com.qq.server.model;

import java.util.*;

public class manageClientThread {
	public static HashMap hm = new HashMap<String , SertoClientThread>();
	
	//向hm中添加一个客户端通讯线程
	public static void addClientThread(String uid, SertoClientThread ct) {
		hm.put(uid, ct);
	}
	
	public static SertoClientThread getClientThread(String uid) {
		return (SertoClientThread)hm.get(uid);
	}
	
}
