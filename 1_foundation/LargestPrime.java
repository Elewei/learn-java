/*
 * 作者：张启卫
 * 时间：2016年9月24号
 * 功能: 最大公因数
 * 例如13195的最大公因数是5，7，13和29
 *  求600851475143的最大公因数是多少？
 */
 
 public class LargestPrime{
	 public static void main(String[] args){
		 int number = 13195;
		 int a[] = {};
		 int j=0;
		 

		 for(int i=1; i<=number; i++)
			if(number % i == 0){
				a[j++]=i;
				number = number / i;
			}	
			
		
	 
	 
 }
 