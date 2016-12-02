为什么需要集合框架？

需求：

- 请做一个公司职员薪水管理系统，要求完成如下功能：
- 当有新员工时，将该员工加到管理系统
- 可以根据员工号，显示该员工的信息
- 可以显示所有员工信息
- 可以修改员工的薪水
- 当员工离职时，将该员工从管理系统中删除
- 可以按照薪水从低到高排序
- 可以统计员工的平均工资和最低最高工资

链表 或是 集合类

	//ClerkTest.java
	class ClerkTest {
		
		public static void main(String[] args) {
					
		}
	}

    //定义一个员工类
    class Clerk {
    	private String name;
    	private int age;
    	private float sal;
    
    	public Clerk(String name, int age, float sal) {
    		this.name = name;
    		this.age = age;
    		this.sal = sal;
    	}
		
		//生成get 与 set方法

    }
    
-----
	Collection
	├List
	│├LinkedList
	│├ArrayList
	│└Vector
	│　└Stack
	└|Set(HashSet)
	 |-(TreeSet)
	
	Map
	├Hashtable
	├HashMap
	└WeakHashMap

list结构的集合类：
ArrayList类， LinkedList, Vector, Stack

Map结构的集合类
HashMap, HashTable

Set结构的集合类
HashSet, TreeSet

Queue结构的集合
Queue接口

#List结构
##ArrayList
	
	import java.util
	
	//定义ArrayList对象
	ArrayList al = new ArrayList();
	//显示大小
	System.out.println("ArrayList大小"+al.size());
	//向al中加入数据（类型是Object）
	Clerk clerk1 = new Clerk("宋江"，"50",1000);
	Clerk clerk2 = new Clerk("吴用"，"40",2000);
	Clerk clerk3 = new Clerk("林冲"，"30",3000);
	//将clerk1加入到al中
	al.add(clerk1);
	System.out.println("ArrayList大小"+al.size());
	al.add(clerk2);
	System.out.println("ArrayList大小"+al.size());
	
	//如果访问al中对象（数据）
	Clerk temp = (Clerk) al.get(0);
	System.out.println("第一个人的名字是："+temp.getName);
	
	//遍历ArrayList
	for(int i=0; i<al.size(); i++) {
		Clerk temp = (Clerk) al.get(i);
		System.out.println("第一个人的名字是："+temp.getName);
	}
	
	//删除一个对象
	al.remove(1);
	

员工系统案例

//雇员类
class Emp {
	
	private String id;		//工号
	private String name;	//名字
	private float sal		//薪水

	public Emp(String id, String name, flaot sal) {
		this.id = id;
		this.name = name;
		float sal = sal;
	}
	
	//生成get 与 set 方法
	

}

//雇员管理类
class ManagerEmp {
	private ArrayList al = null;
	
	//构造函数的作用，初始化成员变量
	public ManagerEmp() {
		al = new ArrayList();
	}
	
	//加入员工
	public void addEmp(Emp emp) {
		al.add(emp);
	}
	
	//显示员工信息
	public void showEmp(String id) {
		for(int i=0; i<al.size(); i++) {
			Emp emp = (Emp) al.get(i);
			if(emp.getId().equals(id)) {
				System.out.println("id="+emp.getId());
				System.out.println("name="+emp.getName());
				System.out.println("sal="+emp.getSal());
			} else {
				System.out.println("该员工不存在");
			}
		}
	}
	
	//显示所有员工信息
	
	//修改员工薪水
	public void updateEmpSal(String id, float newSal) {
		for(int i=0; i<al.size(); i++) {
			Emp emp = (Emp) al.get(i);
			if(emp.getId.equals(id)) {
				emp.setSal(newSal);
			} else {
				System.out.println("未找到该员工");
			}
		}		
	}
	
	//删除员工
	public void delEmp(String id) {
		for(int i=0; i<al.size(); i++) {
			Emp emp = (Emp) al.get(i);
			if(emp.getId.equals(id)) {
				al.remove(i);
			}
		}
	}	
	
	
}
	

主函数进行测试

	ManagerEmp em = new ManagerEmp();
	
	BufferedReader br = new BufferedReader(new InputStreamReader());

	while(true) {
		System.out.println("请选择你要进行的操作：");
		System.out.println();
		
		String operType = br.readLine();
		
	}	
	

##LinkedList

LinkedList ll = new LinkedList();
Emp emp1 = new Emp("01","aa", 1.2f);
Emp emp2 = new Emp("02","aa", 1.2f);	

//把emp1加在链表的最前面,后加在前
ll.addFirst(emp1);
ll.addFirst(emp2);


##Vector

Vector vv = new Vector();
Emp emp = new Emp("01", "a", 1000f);
vv.add(emp);

for(int i=0; i<vv.size(); i++) {
	Emp emp = (Emp) vv.get(i);
}

**ArrayList 与 Vector的区别**

- ArrayList 与 Vector都是java集合类，都可以用来存放java对象
- Vector是同步的，这个类中的一些方法保证了Vector中的对象是线程安全的。而Arraylist是异步的，因此ArrayList则是异步的，因此ArrayList中的对象并不是线程安全的。
- 从内部实现机制来讲，ArrayList和Vector都是使用数组（Array）来控制集合中的对象，当向这两种元素增加元素的时候，如果元素的数目超出内部数组长度，它们都需要扩展内部数组长度，**Vector缺省情况下自动增长原来的一倍长度**，**ArrayList是原来的50%**，如果你要在集合中保存大量数据那么使用Vector有一些优势。

##Stack

Stack stack = new Stack();

#Map结构
##HashMap

//创建一个HashMap对象
HashMap hm = new HashMap();
Emp emp1 = new Emp("sn001","aa", 3.4f);
Emp emp2 = new Emp("sn002","bb", 5.6f);
Emp emp3 = new Emp("sn003","cc", 1.2f);

//将emp添加到hm
hm.put("sn001", emp1);
hm.put("sn002", emp2);
hm.put("sn003", emp3)

//HashMap如果添加相同的key，则会替换先前的对象

//查找,不需要遍历
if(hm.containsKey("sn002")) {
	System.out.println("有该员工");
	Emp emp=(Emp) hm.getObject("sn002");
	System.out.println("名字：" + emp.getName());
} else {
	System.out.println("没有");
}

//遍历HashMap所有的key和value
Iterator it = hm.keySet().iterator();  //迭代器
while(it.hasNext()) {
	//取出key值
	String key = it.next().toString();
	//通过key值取出value
	Emp emp = (Emp) hm.get(key);
	System.out.println(emp.getName());
	System.out.println(emp.getSal());
}






##HashTable

HashTable ht = new HashTable();


**HashMap 与 HashTable 区别**：  

- 两个都是java集合类，都可以用来存放java对象。  
- HashTable是基于陈旧的Dictionary类的，HashMap是1.2引进的Map接口的一个实现。  
- HashTable是同步的。这个类中的一些方法保证了HashTable中的对象是线程安全的。而HashMap是异步的，因此HashMap中的对象并不是线程安全的。因为同步的要求会影响执行的效率，如果你不需要线程安全的集合选择HashMap.  
- HashMap可以让你将空值作为一个表的条目的key或value，但HashTable是不能放入空值的。



- 如果要求线程安全，使得vector,HashTable
- 如果不要求线程安全，使用ArrayList,Linkedlist,HashMap
- 如果要求键值对，则使用HashMap,HashTable
- 如果数据量大，又要求线程安全Vector




