/*
 * 作者：张启卫
 * 时间：2016年9月24号
 * 功能：测试布尔类型,默认为false
 */

public class BooleanTest{
	static boolean zhangsan;
	static boolean lisi=true;
	
	public static void main(String[] args){
		System.out.println("张三：" + zhangsan);
		System.out.println("李四：" +lisi);
		
		if(zhangsan){
			System.out.println("张三有时间..");
		}
		if(lisi){
			System.out.println("李四有时间..");
		}
	}
}
 
 