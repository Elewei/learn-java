/*
 * 作者：张启卫
 * 时间：2016年9月24号
 * 功能：学习java数组
 */
 
 public class ArrayTest{
	 public static void main(String[] args){
		 byte[] byteArray = new byte[1];
		 char[] charArray = new char[1];
		 int[] intArray = new int[1];
		 long[] longArray = new long[1];
		 float[] floatArray = new float[1];
		 double[] doubleArray = new double[1];
		 
		 System.out.println("byte 类型的默认值为："+ byteArray[0]);
		 System.out.println("char 类型的默认值为："+ charArray[0]);
		 System.out.println("int 类型的默认值为："+ intArray[0]);
		 System.out.println("long 类型的默认值为："+ longArray[0]);
		 System.out.println("float 类型的默认值为："+ floatArray[0]);
		 System.out.println("double 类型的默认值为："+ doubleArray[0]);
		 
		 //数组的初始化,首先创建数组，后赋值
		 int array1[] = new int[]{1,2,3,4,5,6};
		 
		 //将值赋值给一个创建好了的数组
		 int array[]={1,2,3,4,5,5};
		 
		 int[] array = new int[5];
		 array[0] = 1;
		 array[1] = 2;
		 array[2] = 3;
		 array[3] = 4;
		 
	 }
 }