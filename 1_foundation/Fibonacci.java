/*
 * ���ߣ�������
 * ʱ�䣺2016��9��24��
 * ����: Fibonacci ���У� 1��2��3��5��8��13��21...
 * ���400����������ż���ĺ�
 */

public class Fibonacci {
	public static void main(String[] args){
		int a = 1;
		int b = 2;
		int c = a + b;
		int sum = 2;
		
		while(c < 4000000){
			a = b;
			b = c;
			c = a + b;
			if(c % 2 == 0) sum += c;
		}
		
		System.out.println("��Ϊ��" +sum);
		
	}
}