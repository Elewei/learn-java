package collection;

import java.util.*;
import java.io.*;

/**
 * 功能：实现一个职员薪水管理系统，要求完成如下功能：
 *  1. 当有新员工时，将该员工加入到管理系统
 *  2. 可以根据员工号，显示该员工信息
 *  3. 可以显示所有员工信息
 *  4. 可以修改员工薪水
 *  5. 当员工离职时，将该员工从管理系统中删除
 *  6. 可以按照薪水从低到高顺序排序
 *  7. 可以统计员工的平均工资和最低和最高工资
 * 
 * 实现步骤：
 *  1. 定义员工类
 *    
 *    
 *     
 *  2. 定义员工管理类
 * @author David
 *
 */

public class ArrayListTest  {
	public static void main(String[] args) throws Exception {
		
		//创建员工管理类对象
		StuffManage st = new StuffManage();
		
		// java io 流
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		//简易菜单
		while(true) {
			System.out.println("请选择你要进行的操作：");
			System.out.println("1. 增加新员工");
			System.out.println("2. 查找显示相应员工信息");
			System.out.println("3. 显示所有员工信息");
			System.out.println("4. 修改员工薪水");
			System.out.println("5. 删除员工");
			System.out.println("6. 按员工薪水从低到高排序");
			System.out.println("7. 退出系统");
			
			String operType = br.readLine();
			
			if (operType.equals("1")) {
				System.out.println("请输入员工编号：");
				String number = br.readLine();
				System.out.println("请输入员工姓名：");
				String name = br.readLine();
				System.out.println("请输入员工薪水：");
				float salary = Float.parseFloat(br.readLine());
				
				Stuff stuff = new Stuff(number, name, salary);
				st.addStuff(stuff);
				
			} else if (operType.equals("2")) {
				
				System.out.println("请输入员工编号：");
				String number = br.readLine();
				
				st.showStuff(number);
				
				
			} else if(operType.equals("3")) {
				st.showAllStuff();
			} else if (operType.equals("4")) {
				
			} else if (operType.equals("5")) {
				
			}else if(operType.equals("7")) {
				System.exit(0);
			}
			
		}
	}
}

/**
 * 员工类：
 *  有三个属性
 *  工号
 *  姓名
 *  薪水
 */
class Stuff {
	
	private String number;	//员工工号
	private String name;	//员工名字
	private float salary;	//员工薪水
	
	//构造函数
	public Stuff(String number, String name, float salary) {
		this.number = number;
		this.name = name;
		this.salary = salary;
	}
	
	//set && get 方法
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}
}

/**
 * 员工管理类
 * 
 * 有这些方法：
 *  1. 增加新员工
 *  2. 根据工号显示员工相关信息
 *  3. 显示所有员工信息
 *  4. 更新员工薪水
 *  5. 删除某个员工
 *  6. 薪水从低到高排序
 *  7. 统计员工最低、最高、平均工资
 *  
 * @author David
 *
 */
class StuffManage {
	
	private ArrayList stu = null;
	
	//构造函数初始化数据
	public StuffManage() {
		stu = new ArrayList();
	}
	
	//1. 加入员工
	public void addStuff (Stuff stuff) {
		stu.add(stuff);
		System.out.println("员工成功加入进系统");
		System.out.println(" ");
	}
	
	//2. 根据工号显示员工相关信息
	public void showStuff(String number) {
		
		//遍历整个ArrayList
		for(int i=0; i<stu.size(); i++) {
			//取出stuff员工数据
			Stuff stu1 = (Stuff)stu.get(i);
			
			//比较工号
			if(stu1.getNumber().equals(number)) {
				System.out.println("找到该员工，信息为：");
				System.out.println("工号="+number);
				System.out.println("姓名="+stu1.getName());
				System.out.println("薪水="+stu1.getSalary());
			}
		}
	}
	
	//3. 显示所有员工信息
	public void showAllStuff() {
		for(int i=0; i<stu.size(); i++) {
			Stuff stu1 = (Stuff)stu.get(i);
			
			System.out.println("工号="+stu1.getNumber());
			System.out.println("姓名="+stu1.getName());
			System.out.println("薪水="+stu1.getSalary());
		}
	}
	
	//4. 修改员工薪水
	public void setSalary(String number, float salary) {
		
		for(int i=0; i<stu.size(); i++) {
			Stuff stu1 = (Stuff)stu.get(i);
			
			if(stu1.getNumber().equals(number)) {
				stu1.setSalary(salary);
				System.out.println("找到员工且更新成功");
			}
		}
	}
	
	//5. 删除某个员工
	public void delStuff(String number) {
		for(int i=0; i<stu.size(); i++) {
			Stuff stu1 = (Stuff)stu.get(i);
			
			if(stu1.getNumber().equals(number)) {
				stu.remove(i);
			}
		}
	}
	
	
}























