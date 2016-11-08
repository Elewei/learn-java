/**
 * ʹ�����ַ��������߳�
 * ���裺
 * 
 */
 
 public class ThreadStart {
	 public static void main(String[] args) {
		 Runnable rb = new RunnableThread();
		 Thread rbt = new Thread(rb);
		 rbt.start();
		 
		 SubThread sub = new SubThread("SubThread");
		 sub.start();
	 }
 }
 
 class RunnableThread implements Runnable {
	 public void run() {
		 System.out.println("RunnableThread����");
	 }
 }
 
 class SubThread extends Thread {
	 
	 SubThread(String Name) {
		 super(Name);
	 }
	 
	 public void run() {
		 System.out.println("SubThread����");
	 }
 }