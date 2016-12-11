Hibernate 核心类与接口

<table>
	<tr><td colspan=3>Java SE/EE 应用</td></tr>
	<tr><td>Criteria</td><td>Query</td><td>Transaction</td></tr>
	<tr><td colspan=3>Session</td></tr>
	<tr><td colspan=3>Session Factory</td></tr>
	<tr><td colspan=3>Configuration</td></tr>
	<tr><td>hibernate.properties</td><td>hibernate.cfg.xml</td><td>*.hbm.xml</td></tr>
</table>
  

SessionFactory(会话工厂)
1. 缓存sql语句和某些数据
2. 在应用程序初始化的时候创建，是一个重量级的类，一般用单例模式保证一个应用中只需要一个SessionFactory实例。
3. 如果某个应用访问多个数据库，则要创建多个会话工厂实例，一般是一个数据库一个会话工厂实例。
4. 通过SessionFactory接口可以获得Session实例

//通过SessionFactory 获取Session的两个方法   
openSession()   每次都获得一个全新的session
getCurrnetSession()  获取和当前线程绑定的session

Configuration cf = new Configuration().configure();



###Query接口
通过query接口可以完成更加复杂的查询任务。

通过用户名来查询数据
	public static void main(String[] args) {
			// TODO Auto-generated method stub
			//使用hibernate完成crud操作，不使用service，直接测试
			
			//1. 创建Configuration,该对象读取hibernate.cfg.xml，并完成初始化
			Configuration configuration = new Configuration().configure(“hibernate.cfg.xml”);
			//2. SessionFactory 【这是一个会话工厂，是一个重量级的对象】
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			//3. 创建Session，相当于一次连接
			Session session = sessionFactory.openSession();
			//4. 开始一个事物
			Transaction transaction = null;
			
			try {
				transaction = session.beginTransaction();
				//添加一个雇员
				
				//获取Query引用， Employee不是表，而是domain引用
				Query query = session.createQuery(“from Employee where id=1”);
				//通过list方法获取结果
				List<Employee> list = query.list();
				for(Employee e: list) {
					System.out.println(e.getEmail() + “ “ + e.getName());
				}
				
				//提交
				transaction.commit();
			} catch (Exception e) {
				if(transaction != null) 
					transaction.rollback();
				throw new RuntimeException(e.getMessage());
			} finally {
				// TODO: handle finally clause
				//关闭
				session.close();
			}
		}
	

###Criteria接口
Criteria cri = session.createCriteria(Employee.class).setMaxResults(2);




