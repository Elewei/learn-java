/*
 * 作者：张启卫
 * 时间：2016年9月24号
 * 功能：了解强制类型转换
 */

public class Qiangzhi{
	public static void main(String[] args){
		int i=111;
		byte b=(byte)i;
		System.out.println("int 类型强制转换成byte后的值是：" + b);
		
		double d=111.222;
		int j=(int)d;
		System.out.println("double 类型强制转换成int后的值是：" + j);
	}
}