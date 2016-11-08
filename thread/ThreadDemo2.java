/**
 * 使用Runnable接口实现创建线程
 * 步骤：
 *  1. 创建一个实现Runnable接口的类，并且重写run方法
 *  2. 创建一个ThreadType的实例
 *  3. 通过Runnable实例创建一个线程对象
 *  4. 通过调用Thread对象的start()方法启动线程
 */
 
 class ThreadDemo2 implements Runnable {
	 public static void main(String[] args) {
		 Runnable rb1 = new ThreadDemo2();
		 Runnable rb2 = new ThreadDemo2();
		 Runnable rb3 = new ThreadDemo2();
		 Thread td1 = new Thread(rb1);
		 Thread td2 = new Thread(rb2);
		 Thread td3 = new Thread(rb3);
		 td1.start();
		 td2.start();
		 td3.start();
	 }
	 
	 public void run() {
		 for (int i=1; i< 10; i++) {
			for(int j=0; j<i; j++)
				System.out.print("*");
			System.out.println();		 
	 }
	}
 }