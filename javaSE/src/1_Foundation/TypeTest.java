/*
 * 作者：张启卫
 * 时间：2016年9月24号
 * 功能：数据类型转换
 */
 
 public class TypeTest{
	 public static void main(String[] args){
		 byte b=1;
		 short s=2;
		 char c='c';
		 int i=3;
		 long l=4;
		 float f=5.0f;
		 double d=6.0;
		 
		 System.out.println("变量b的值为：" + b);
		 System.out.println("变量s的值为：" + s);
		 System.out.println("变量c的值为：" + c);
		 System.out.println("变量i的值为：" + i);
		 System.out.println("变量l的值为：" + l);
		 System.out.println("变量f的值为：" + f);
		 System.out.println("变量d的值为：" + d);
		 
		 s=b;
		 i=c;
		 i=s;
		 l=i;
		 f=l;
		 d=f;
		 d=b;
		 d=f+d;
		 
		 System.out.println("变量b的值为：" + b);
		 System.out.println("变量s的值为：" + s);
		 System.out.println("变量c的值为：" + c);
		 System.out.println("变量i的值为：" + i);
		 System.out.println("变量l的值为：" + l);
		 System.out.println("变量f的值为：" + f);
		 System.out.println("变量d的值为：" + d);
		
		 
	 }
 }