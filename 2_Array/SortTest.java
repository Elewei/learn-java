/*
 * ���ߣ�������
 * ʱ�䣺2016��9��24��
 * ���ܣ�����ѡ�������㷨
 */
 
 public class SortTest{
	 public static void main(String[] args){
		 int[] intarray = {1,23,45,66,2,332,8,5};
		 int keyvalue;
		 int index;
		 int temp;
		 
		 System.out.println("����ǰ������Ԫ��");
		 for(int i : intarray){
			 System.out.print(i + " ");
		 }
		 System.out.println();
		 
		 //ѡ�������㷨
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
		
		 System.out.println("����������Ԫ��");
		 for(int i : intarray){
			 System.out.print(i + " ");
		 }		
	 }
 }