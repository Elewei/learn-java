/*
 * 作者：张启卫
 * 时间：2016年9月24号
 * 功能：数组选择排序算法
 */
 
 public class SortTest{
	 public static void main(String[] args){
		 int[] intarray = {1,23,45,66,2,332,8,5};
		 int keyvalue;
		 int index;
		 int temp;
		 
		 System.out.println("排序前的数组元素");
		 for(int i : intarray){
			 System.out.print(i + " ");
		 }
		 System.out.println();
		 
		 //选择排序算法
		 for(int i = 0; i < intarray.length; i++){
			 index = i;
			 keyvalue = intarray[i];
			 
			 for(int j=i+1; j < intarray.length; j++){
				 if(intarray[j] < keyvalue){
					 index = j;
					 keyvalue = intarray[j];
				 }
			 }
			  temp = intarray[i];
			  intarray[i] = intarray[index];
			  intarray[index] = temp;
		 }
		
		 System.out.println("排序后的数组元素");
		 for(int i : intarray){
			 System.out.print(i + " ");
		 }		
	 }
 }