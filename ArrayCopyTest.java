/*
 * ���ߣ�������
 * ʱ�䣺2016��9��24��
 * ���ܣ�ѧϰjava����ĸ���
 */

public class ArrayCopyTest {
	public static void main(String[] args){
		//��������
		int[] array1 = {1,2,3};
		int[] array2 = {4,5,6};
		
		System.out.println("��������ĳ�ʼֵΪ��");
		for(int i=0; i<array1.length; i++)
			System.out.println("array1["+i+"]=" + array1[i]);
		for(int i=0; i<array2.length; i++)
			System.out.println("array2["+i+"]=" + array2[i]);
		
		//��array2��ֵ��array1
		array1 = array2;
		
		System.out.println("��ִ������ĸ��ƺ����������ֵ��");
		for(int i=0; i<array1.length; i++)
			System.out.println("array1["+i+"]=" + array1[i]);
		for(int i=0; i<array2.length; i++)
			System.out.println("array2["+i+"]=" + array2[i]);
		
		System.out.println("��array2��һ��Ԫ�ظı䣺");
		array2[2]=8;
		System.out.println("array2[2]=" + array2[2]);
		System.out.println("array1[2]=" + array1[2]);
	}
}