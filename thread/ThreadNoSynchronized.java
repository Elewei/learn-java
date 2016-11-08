/**
 * 功能：理解线程同步与异步
 * 此程序为线程异步
 * 
 */
 
public class ThreadNoSynchronized {
	public static void main(String[] args) {
		
		ShareData oshare = new ShareData();
		
		ThreadDemo td1 = new ThreadDemo("Thread1", oshare);
		ThreadDemo td2 = new ThreadDemo("Thread2", oshare);
		td1.start();
		td2.start();
	}
}
 
class ShareData {
	public static String szData = "";
}

class ThreadDemo extends Thread {
	private ShareData oShare;
	ThreadDemo() {}
	
	ThreadDemo(String szName, ShareData oShare) {
		super(szName);
		this.oShare = oShare;
	}
	
	public void run() {
		for(int i=0; i<5; i++) {
			if(this.getName().equals("Thread1")) {
				oShare.szData = "这是第1个线程";
				
				try {
					Thread.sleep((int)Math.random() * 100);
				} 
				catch(InterruptedException e) {
					System.out.println(this.getName() + ":" + oShare.szData);
				} 
				
				System.out.println(this.getName() + ":" + oShare.szData);
			
			else if(this.getName().equals("Thread2")) {
					oShare.szData = "这是第2个线程";
				}try {
					Thread.sleep((int)Math.random() * 100);
				} catch(InterruptedException e) {
				}
				
				System.out.println(this.getName() + ":" + oShare.szData);
			}
		}
	}
}