/**
 * 只有一个线程
 * 
 */

public class OnlyThread {
	public static void main(String[] args) {
		run();
	}
	
	public static void run() {
		for (int i=1; i< 10; i++) {
			for(int j=0; j<i; j++)
				System.out.print("*");
			System.out.println();
		}
	}
}

