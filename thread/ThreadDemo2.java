/**
 * ʹ��Runnable�ӿ�ʵ�ִ����߳�
 * ���裺
 *  1. ����һ��ʵ��Runnable�ӿڵ��࣬������дrun����
 *  2. ����һ��ThreadType��ʵ��
 *  3. ͨ��Runnableʵ������һ���̶߳���
 *  4. ͨ������Thread�����start()���������߳�
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