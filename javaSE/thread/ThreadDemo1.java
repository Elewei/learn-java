/**
 * ʹ������Thread�ഴ��һ��td�߳�
 * ���裺
 *  1. ����һ���µ��߳��࣬�̳�Thread�ಢ����Thread���run()����
 *  2. ����һ���߳���Ķ��󣬵���start()���� 
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