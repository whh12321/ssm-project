# ssm-project

为了快速入门SSM架构，我在网上找到一个简单容易上手的项目进行实战训练。

整个项目用到的技术点有：

框架：SSM
数据库：MySQL
前端：HTML、JavaScript、jQuery、JSTL
WEB服务器：Tomcat
单元测试：JUnit
JSON解析工具：Jackson
开发工具：Eclipse
开发环境：Windows

一、准备
准备部分主要包括数据库建表、SSM框架的搭建启动。

1、数据库建表

2、SSM项目搭建与启动

（1）首先导入项目中可能用到的依赖包： 见WEB-INF/lib.

（2）web.xml： 见WEB-INF/web.xml.

（3）Spring容器配置文件：applicationContext.xml： 见src/applicationContext.xml.

（4）SpringMVC配置文件：springmvc.xml： 见src/springmvc.xml.

二、代码完成与测试
这一章主要完成数据库底层的CRUD和web界面代码实现与测试工作.

1、实现代码

CategoryMapper用来与Category.xml形成映射，执行的方法是数据库的CRUD操作；
CategoryService业务逻辑接口实现类中注入CategoryMapper；
CategoryServiceImpl业务逻辑实现类，一般写事务控制；
Controller：springMVC就是在这里发挥作用的；
pojo：实体类存放的位置；

思路为：
1. 首先浏览器上访问路径 /listCategory
2. tomcat根据web.xml上的配置信息，拦截到了/listCategory，并将其交由DispatcherServlet处理。
3. DispatcherServlet 根据springMVC的配置，将这次请求交由CategoryController类进行处理，所以需要进行这个类的实例化
4. 在实例化CategoryController的时候，注入CategoryServiceImpl。 (自动装配实现了CategoryService接口的的实例，只有CategoryServiceImpl实现了CategoryService接口，所以就会注入CategoryServiceImpl)
5. 在实例化CategoryServiceImpl的时候，又注入CategoryMapper
6. 根据ApplicationContext.xml中的配置信息，将CategoryMapper和Category.xml关联起来了。
7. 这样拿到了实例化好了的CategoryController,并调用 list 方法
8. 在list方法中，访问CategoryService,并获取数据，并把数据放在"cs"上，接着服务端跳转到listCategory.jsp去
9. 最后在listCategory.jsp 中显示数据

2、 PageHelper插件配置文件

见src/applicationContext.xml.

3、分页的代码实现
Page类用于存放分页信息；

4、在SSM中配置数据库连接池
替代原有的JDBC实现数据库的连接，新增Druid连接池

5、主要了解使用事务之前和使用事务之后的效果区别，以及分别使用注解和XML方式在SSM中配置事务，观察事务的回滚操作。


至此，我对SSM框架有了一个初步的了解，希望能够学习更加规范和全面的框架知识。
