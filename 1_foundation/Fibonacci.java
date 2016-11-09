/*
 * 作者：张启卫
 * 时间：2016年9月24号
 * 功能: Fibonacci 数列： 1，2，3，5，8，13，21...
 * 求出400万以内所有偶数的和
 */

public class Fibonacci {
	public static void main(String[] args){
		int a = 1;
		int b = 2;
		int c = a + b;
		int sum = 2;
		
		while(c < 4000000){
			a = b;
			b = c;
			c = a + b;
			if(c % 2 == 0) sum += c;
		}
		
		System.out.println("和为：" +sum);
		
	}
}