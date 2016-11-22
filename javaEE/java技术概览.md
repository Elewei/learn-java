#J2EE的十三种技术（规范）  

##Java数据库连接（JDBC） 
JDBC API以一个统一的方式访问各种数据库。与ODBC类似，JDBC将开发者和私有数据库之间的问题隔离开来。由于它建立在Java上，因此JDBC可以提供平台无关的数据库访问。

JDBC定义了4种不同的驱动，具体来说，包括有：

* **类型1：JDBC-ODBC桥**  
	在JDBC刚产生时，JDBC-ODBC桥是非常有用的。通过它，开发者可以使用JDBC来访问一个ODBC数据源。缺点是，它需要在客户机器上安装有一个ODBC驱动，该机器通常是应该运行微软Windows系统的。使用这一类的驱动器，你就会失去JDBC平台无关的好处。此外，ODBV驱动器需要客户端的管理。

* **类型2：JDBC-native驱动桥**  
	JDBC-native驱动桥提供了一个建筑在本地数据库驱动上的JDBC接口--没有使用ODBC。JDBC驱动将标准的JDBC调用转变为对数据库API的本地调用。使用类型2的驱动也会失去JDBC平台无关性的好处，并且需要安装客户端的本地代码。
　　
* **类型3：JDBC-network桥**  
	JDBC-network桥不需要客户端的数据库驱动。它们使用网络-服务器中层来访问一个数据库。这会引出诸如负载均衡、连接池等技术，数据缓冲也是可能的。由于类型3的驱动通常可带来相对小的下载时间，它是平台无关的，并且不需要客户端的安装和管理，因此很适合用作Internet的应用。
　　
* **类型4：纯Java驱动**  
	类型4使用纯Java数据库驱动来提供直接的数据库访问。由于类型4驱动运行在客户端，并且直接访问数据库，因此运行在这个模式暗示要使用一个两层的体系。要在一个n层的体系中使用类型4的驱动，可以通过一个包含有数据访问代码的EJB，并且让该EJB为它的客户提供一个数据库无关的服务。

##Java命名和目录接口（Java Naming and Directory Interface，JNDI） 

JNDI是Java Naming and Directory Interface 的简写，中意为：Java命名及目录接口，它是为了对高级网络应用开发中的使用的目录基础结构的访问。实际上这个目录是一个特殊的数据库，提供了对存储数据的快速访问，不象传统的目录服务访问方式-你必须提供不同的API接口去访问不同的目录服务（如：LDAP，NIS，ADS等），而它提供了一种标准的API来访问类型不同的目录。据说，使用完整的SDK可以开发那些JNDI还不支持的目录服务提供者。
   
JNDI是J2EE的一个API，提供了一套标准的接口，以定位用户、机器、网络、对象、以及服务。例如，你可以使用JNDI来定位内部网中的一台打印机，你也可以使用它来定位Java对象或连接到一个数据库。JNDI可以用于EJB、RMI-IIOP、JDBC中。它是网络查找定位的标准方法。　　JNDI API被用来访问命名和目录服务。它提供一个相容的模式来访问和操作企业范围大的资源，例如一个应用服务器中的DNS、LDAP、本地文件系统或者对象。
　　
在JNDI中，一个目录结构中的每一个节点被称为context。每一个JNDI的名字都是与一个context相对的，没有一个绝对名字的概念。一个应用可以使用InitialContext类来得到它的第一个context：
　　　
Context ctx = new InitialContext();
　　
通过这个初始的context，应用就可以经过目录树定位到需要的资源或者对象。例如，假定你已经在WebLogic Server中配置了一个EJB，并且在myApp.myEJB中绑定了home接口。EJB的客户端，在得到这样一个初始的context后，然后就可以使用以下的代码来定位到home接口：
　　　
MyEJBHome home = ctx.lookup( "myApp.myEJB" );

一旦你得到你所需对象的一个引用--在这个例子中，就是EJB的home接口--然后你可以调用它上面的方法。为了在一个context中查找到一个对象，JNDI还提供方法可以做到：
　　插入或者绑定一个对象到一个context中。在你配置一个EJB时，这是非常有效的方法；
　　从一个context中移去一个对象
　　列出一个context中的所有对象
　　创建和删除subcontexts

##企业Java Beans（Enterprise Java Beans，EJB） 

J2EE其中一个引人注目的技术是EJB。它提供了一个架构来开发和配置到客户端的分布式商业逻辑，因此可以明显减少开发扩展性、高度复杂企业应用的难度。EJB规范定义了EJB组件应该如何及何时与它们的容器交互。由容器来负责提供普通的服务，例如目录服务、事务管理、安全、资源池和容错。
　
EJB规范定义了三类基本的bean：
  会话beans（session beans）：会话beans为业务流程建模，由于他们通常表示执行某个动作，因此可以把它们当作是动词。这个执行的动作可以是任何事情，例如增加数量，访问数据库，调用其它系统，调用其它企业Bean。我们可以举出很多的例子，包括一个计价引擎，一个工作流引擎，一个目录引擎，一个信用卡认证中心，或一个网上证券交易引擎。
　
实体beans（Entity beans）：这是持久保存数据的代表--典型的是存储在数据库中--因此在服务器崩溃后数据仍然存在。多个客户端可以使用EJB来表示同样的数据。实体beans为企业数据建模，由于它们表示数据对象（就是缓存数据库信息的Java对象），因此可以把它们当作名词。实体beans的例子包括一种产品，一项订单，一个雇员，一张信用卡，或一支股票。会话beans典型的方式是通过实体beans来实现业务目标的，例如一个证券交易引擎（会话beans）处理股票（实体beans）。
    Message-Driven beans：Message-Driven beans也表示动作，这一点上它类似于会话beans。它们之间的不同点在于你只能够通过发送消息给Message-Driven beans的方式来调用它们。Message-Driven beans的例子包括了接受股票交易消息的beans，信用认证消息，或工作流消息。这些Message-Driven beans也可以调用其它的企业beans。
    接着，我们讨论无状态和有状态
　　无状态的beans（Stateless beans）：这是一个单一使用的服务，不维护任何的状态，在服务器崩溃时也不再存在，而且生存期也相对地短。例如，一个无状态的session bean可能用作执行温度转换。
　　有状态的bean：它提供了一个传统的与客户端交互的方法，存储客户端的状态。在线购物车就是这样一个有状态session ean的典型例子。有状态session beans在服务器崩溃时也不再存在，而且生存期也相对地短，并且每个实例只可以用在一个单一的线程中。

##JavaServer Pages (JSPs) 
或许你已经对微软的Active Server Pages (ASPs)非常熟悉；JSP也是类似的技术，不过它是平台无关的。它们都是设计来帮助web内容开发者使用相对较少的代码就可以创建动态的网页。web设计者即使不懂得编程，也可以使用JSP来创建动态的网页。JavaServer Page是HTML代码和Java代码的混合。在客户请求页面的时候，服务器就会处理Java代码，然后返回HTML页面给浏览器。
　　
你可以也听过JHTML，它是一个旧的标准，现在已经被JSP取代了。WebLogic Server不但支持JSP，还支持JHTML。不过，在默认设置下，WebLogic Server是不支持JSP的（对于5.1版本）。你必须编辑weblogic.properties来激活web服务器，对于JSPServlet来说，也是这样。

##Java servlets 

servlets提供的功能大部分JSP相同，它采用的是一个有点不同的方法。JSP中大部分是HTML代码，其中只有少量的Java代码，而servlets则相反，它完全使用Java编写，并且产生HTML代码。

servlet是一个在服务器上运行的Java小程序，它可以扩展Web服务器的功能。这些服务器端的应用可以在被请求时动态执行，与传统Web服务器上的CGI Perl脚本差不多。CGI脚本和servlet的一个主要不同是：CGI脚本对于每次请求都启动一个全新的进程--需要额外的系统开销--而servlet的执行只要在servlet引擎内启动一个独立的线程就性了。因此Servlet的扩展性也更好。

在开发servlet时，你通常都要扩展javax.servlet.http.HttpServlet类，并且覆盖它的一些方法。感兴趣的方法包括有：
　　
* service(): 作为command-specific方法的一个调度程序  
* doGet(): 处理来自一个客户的HTTP GET请求  
* doPost(): 处理来自一个客户的HTTP POST请求  
    
还有一些其它的方法来处理不同类型的HTTP请求--可参考HttpServlet API的文本来得到更多相关的信息。

##Java IDL/CORBA 
　　通过Java的IDL支持，开发者可以将Java与CORBA集成。他们可以创建能配置在一个CORBA ORB中的Java对象，也可以创建作为配置在其它ORB内的CORBA对象客户端的Java类。对于通过Java将你的新应用和以前的系统集成，后者提供了一个另外的方法。

##Java事务体系（JTA）/Java事务服务（JTS）
　　JTA定义了一个标准的API，应用可以通过它来访问事务监控器。
　　JTS是CORBA OTS事务监控器的一个基本实现。JTS指定了一个事务管理器的实现（Transaction Manager），这个管理器在一个高级别上支持Java事务API（JTA）规范，并且在一个低级别上实现了OMG OTS规范的Java映射。一个JTS事务管理器为应用服务器、资源管理器、standalone应用和通信资源管理器提供事务服务。

##JavaMail和JavaBeans激活架构（JavaBeans Activation Framework，JAF） 
　　JavaMail是一个用来访问邮件服务器的API。JavaMail API提供了一套抽象类来模型化一个邮件系统。支持SMTP和IMAP服务器。
　　JavaMail通过使用JavaBeans Activation Framework (JAF) 来处理MIME加密的邮件附件。MIME字节流和Java对象间可以互相转化。大多数的应用无需要直接使用JAF。

##Java信使服务（Java Messaging Service，JMS）
　　JMS是一个用来和面向信息的中层通信的API。它不但支持点对点的域，也支持发布/订阅域，并且提供对担保信息传送、事务信息传送、持久信息和durable subscribers的支持。对于将你的应用和以前的backend系统集成，JMS提供了另外一个方法。

##扩展标记语言（Extensible Markup Language，XML） 
XML是一个用来定义其它标记语言的的语言。它可被用作商业之间的数据共享。XML的发展是与Java分开的；不过，它的目标和Java类似，都是为了与平台无关。通过将Java与XML结合，你可以得到一个完全平台无关的解决方案。多个公司都为在Java和XML间开发一个紧密的集成而工作。具体的信息，可浏览Sun站点的Java-XML部分（http://java.sun.com/xml），以及IBM的developerWorks的XML Zone部分。

##Struts+Spring+Hibernate（ssh）

现有的java技术:

* Java基础（面向对象，集合，界面，线程，文件，网络）  
* JDBC（java的数据库编程）(Oracle / mysql / sqlserver)
* Web网页设计(Html, css, javascript)
* xml
* Servlet
* Jsp=html + java片段 + jsp语法 + js

B/S:
* 开发成本低
* 管理维护简单
* 对用户培训费用低
* 安全性不足
* 客户端不能随心变化，受浏览器限制

Web服务器:
* JBoss
* WebLogic
* Tomcat
