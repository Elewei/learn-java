/*
 * ���ߣ�������
 * ʱ�䣺2016��9��24��
 * ����: �������
 * ����13195�����������5��7��13��29
 *  ��600851475143����������Ƕ��٣�
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
 