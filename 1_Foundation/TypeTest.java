/*
 * ���ߣ�������
 * ʱ�䣺2016��9��24��
 * ���ܣ���������ת��
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
		 
		 System.out.println("����b��ֵΪ��" + b);
		 System.out.println("����s��ֵΪ��" + s);
		 System.out.println("����c��ֵΪ��" + c);
		 System.out.println("����i��ֵΪ��" + i);
		 System.out.println("����l��ֵΪ��" + l);
		 System.out.println("����f��ֵΪ��" + f);
		 System.out.println("����d��ֵΪ��" + d);
		 
		 s=b;
		 i=c;
		 i=s;
		 l=i;
		 f=l;
		 d=f;
		 d=b;
		 d=f+d;
		 
		 System.out.println("����b��ֵΪ��" + b);
		 System.out.println("����s��ֵΪ��" + s);
		 System.out.println("����c��ֵΪ��" + c);
		 System.out.println("����i��ֵΪ��" + i);
		 System.out.println("����l��ֵΪ��" + l);
		 System.out.println("����f��ֵΪ��" + f);
		 System.out.println("����d��ֵΪ��" + d);
		
		 
	 }
 }