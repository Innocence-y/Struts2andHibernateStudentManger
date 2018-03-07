package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class TestStudents2 {
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;

	@Before
	public void init(){
		//创建配置对象
		/**
		 * 没有configure()就会去classpath找hibernate.properties文件，有configure就去找hibernate.cfg.xml文件。
		 */
		Configuration configuration=new Configuration().configure();
		//创建服务注册对象
		ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		//创建会话工厂对象
		sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		//会话对象
		session =sessionFactory.openSession();
		//开启事务
		transaction=session.beginTransaction();
	}

	@After
	public void destory(){
		//提交事务
		transaction.commit();
		//关闭会话
		session.close();
		//关闭会话工厂
		sessionFactory.close();
	}

	@Test
	public void  testSaveStudents(){
		//生成学生对象
		Students students=new Students("9","张三丰","男",new Date(),"武当山");
		//保存对象进入数据库
		session.save(students);
	}
}
