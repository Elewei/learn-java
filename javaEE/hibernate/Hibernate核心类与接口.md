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








