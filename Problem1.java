/*
 * ���ߣ�������
 * ʱ�䣺2016��9��24��
 * ����: ��һ�����ڣ��ҳ�3��5�ı�����������͡�
 * ���磺10�����У�3��5��6��9 ��͵�23
 * ��1000�����ܹ���3��5���������ĺ�
 */
 
 public class Problem1 {
	 public static void main(String[] args){
		 int value = 1000;
		 int sum = 0;
		 for(int i=1; i<value; i++){
			 if((i%3==0) || (i%5==0)) sum += i;
		 }
		 System.out.println("1000���ڵĺ�Ϊ��" + sum);
	 }
 }