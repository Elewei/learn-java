package thread;

/**
 * 
 * 程序功能：使用runable接口来实现
 *  该程序每隔1s在控制台输出hello,world
 *  当输出10次后，自动退出
 * 
 * @author David
 *
 */

public class Hello2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog = new Dog();
		
		//创建一个线程对象 
		Thread t = new Thread(dog);
		t.start();
	}

}

class Dog implements Runnable {
	int times = 0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			//休眠1秒,Thread.sleep 单位为毫秒
			//sleep会使该线进入阻塞状态，且释放系统资源
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			times++;
			System.out.println("Hello World"+times);
			if(times == 10) {
				break;	//退出
			}	
		}
	}	
}
