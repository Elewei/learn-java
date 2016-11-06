package thread;

/**
 * 
 * 程序功能：使用继承Thread类来实现
 *  该程序每隔1s在控制台输出hello,world
 *  当输出10次后，自动退出
 * 
 * @author David
 *
 */


public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建Cat类对象
		Cat cat = new Cat();
		
		//启动线程,会导致run函数的运行
		cat.start();
	}

}


class Cat extends Thread {
	int times = 0;
	
	//重写run函数
	public void run() {
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
