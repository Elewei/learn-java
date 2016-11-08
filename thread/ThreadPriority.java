/**
 * 功能：理解线程调试中优先级
 * 步骤：
 * 
 */
 
 import java.util.*;
 
 
 public class ThreadPriority {
	 public static void main(String[] args) {
		 
		 //用Thread类的子类创建线程
		 InheritThread rtd = new InheritThread();
		 rtd.setPriority(1);
		 rtd.start();
		 
		 //用Runnalbe接口类的对象创建线程
		 Runnable r = new RunnableThread();
		 Thread rt = new Thread(r);
		 rt.setPriority(10);
		 rt.start();
	 }
 }
 
 
class InheritThread extends Thread {
	
	public void run() {
		System.out.println("InheritThread is running...");
		for(int i=0; i<10; i++) {
			System.out.println("InheritThread:i="+i);
			try {
				Thread.sleep((int)Math.random() * 1000);
			} catch(InterruptedException e) {
				
			}		
		}
	
	}

}
 
class RunnableThread implements Runnable {
	//自定义线程的run()方法
	public void run() {
		System.out.println("RunnableThread is running...");
		for(int i=0; i<10; i++)
			System.out.println("RunnalbeThread: i="+i);
		try {
			Thread.sleep((int)Math.random() * 1000);
		} catch(InterruptedException e) {
			
		}
	}
}