/**
 * 使用派生Thread类创建一个td线程
 * 步骤：
 *  1. 创建一个新的线程类，继承Thread类并覆盖Thread类的run()方法
 *  2. 创建一个线程类的对象，调用start()方法 
 */
 
 public class ThreadDemo1 extends Thread {
	 public static void main(String[] args) {
		 ThreadDemo1 td1 = new ThreadDemo1();
		 ThreadDemo1 td2 = new ThreadDemo1();
		 ThreadDemo1 td3 = new ThreadDemo1();
		 td1.start();
		 td2.start();
		 td3.start();
	 }
	 
	 ThreadDemo1() {
		 
	 }
	 
	 ThreadDemo1(String szName) {
		 super(szName);
	 }
	 
	 public void run() {
		 for (int i=1; i< 10; i++) {
			for(int j=0; j<i; j++)
				System.out.print("*");
			System.out.println();
	 }
	}
 }