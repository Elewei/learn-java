/*
 * ���ߣ�������
 * ʱ�䣺2016��9��24��
 * ���ܣ������ð�������㷨
 */
 
 public class MaopaoTest{
	 public static void main(String[] args){
		 int[] intarray={1,2,33,5,34,67,213,8};
		 
		 System.out.println("����ǰ�����ݣ�");
		 for(int i=0; i<intarray.length; i++)
			 System.out.print(intarray[i] + "  "); 
		 System.out.println();
		 
		 int temp;
		 for(int i=0; i<intarray.length; i++){
			 for(int j=i; j<intarray.length;j++){
				 if(intarray[j] < intarray[i]){
					 temp = intarray[i];
					 intarray[i] = intarray[j];
					 intarray[j] = temp;
				 }
			 }
		 }
		 
		 
	 }
 }