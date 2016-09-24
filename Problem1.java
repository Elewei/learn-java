/*
 * 作者：张启卫
 * 时间：2016年9月24号
 * 功能: 在一定数内，找出3或5的倍数的数，求和。
 * 例如：10以内有，3，5，6，9 求和得23
 * 求1000以内能够被3或5整除的数的和
 */
 
 public class Problem1 {
	 public static void main(String[] args){
		 int value = 1000;
		 int sum = 0;
		 for(int i=1; i<value; i++){
			 if((i%3==0) || (i%5==0)) sum += i;
		 }
		 System.out.println("1000以内的和为：" + sum);
	 }
 }