/**
 * ���ܣ�����̵߳��������ȼ�
 * ���裺
 * 
 */
 
 import java.util.*;
 
 
 public class ThreadPriority {
	 public static void main(String[] args) {
		 
		 //��Thread������ഴ���߳�
		 InheritThread rtd = new InheritThread();
		 rtd.setPriority(1);
		 rtd.start();
		 
		 //��Runnalbe�ӿ���Ķ��󴴽��߳�
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
	//�Զ����̵߳�run()����
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