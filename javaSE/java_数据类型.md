#数据类型
java一共有8种类型（4种整形，2种浮点类型，1种char,boolean）

整形
<table>
	<tr><td>类型</td><td>字节</td><td>范围</td></tr>
	<tr><td>int</td><td>4字节</td><td>-2^16 ~ 2^16-1 </td></tr>
	<tr><td>short</td><td>2字节</td><td>-32768~32767</td></tr>
	<tr><td>long</td><td>8字节</td><td>?</td></tr>
	<tr><td>byte</td><td>1字节</td><td>-128~127</td></tr>
</table>

浮点类型
<table>
	<tr><td>类型</td><td>字节</td><td>范围</td></tr>
	<tr><td>float</td><td>4字节</td><td>(有效位数6位)</td></tr>
	<tr><td>double</td><td>2字节</td><td>（有效位数15位）</td></tr>
</table>


	for(variable: collection)
		statement;

for each variable in collection

	//更简单的遍历程序
	a[]={2,3,5,7,11,13}
	system.out.println(Arrays.toString(a));


数组拷贝: Arrays.copyOf(数据名，数据长度) 方法


`int [] copiedLuckyNumbers = Arrays.copyOf(luckyNumber, luckyNumbers.length);`


数据排序： Arrays.sort()方法

