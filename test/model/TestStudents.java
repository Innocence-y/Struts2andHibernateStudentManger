package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import java.util.Date;

public class TestStudents {
	@Test
	public void testSchemaExport(){
		//创建配置对象
		Configuration configuration=new Configuration().configure();
		//创建服务注册对象
		ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		//创建SessionFactory
		SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		//创建session对象
		Session session=sessionFactory.getCurrentSession();
		//创建SchemaExport对象
		SchemaExport schemaExport=new SchemaExport(configuration);
		schemaExport.create(true,true);
//		Transaction transaction=session.beginTransaction();
//		Students students=new Students();
//		students.setSid("2");
//		students.setSname("we");
//		students.setAddress("we");
//		students.setAddress("ew");
//		students.setGender("nan");
//		transaction.commit();
	}
	@Test
	//添加测试数据
	public void testSaveStudents(){
		//创建配置对象
		Configuration configuration=new Configuration().configure();
		//创建服务注册对象
		ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		//创建SessionFactory
		SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		//创建session对象
		Session session=sessionFactory.getCurrentSession();
		//创建事物对象
		Transaction tx=session.beginTransaction();
		Students s1=new Students("05","闫文强","男",new Date(),"太原");
		Students s2=new Students("06","朱小龙","男",new Date(),"太原");
		Students s3=new Students("07","","男",new Date(),"太原");
		session.save(s1);
		session.save(s2);
		session.save(s3);
		tx.commit();
		sessionFactory.close();
	}
}
