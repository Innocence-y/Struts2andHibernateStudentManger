package serviceImpl.impl;

import db.MyhibernateSessionFactory;
import model.Teachers;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import serviceImpl.TeachersDAO;

import java.util.List;

public class TeachersDAOimpl implements TeachersDAO {
	@Override
	public List<Teachers> queryALLTeachers() {
		List<Teachers> list=null;
		Transaction tx=null;
		String hql="";
		try {
			Session session= MyhibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			hql="from Teachers";
			Query query=session.createQuery(hql);
			list=query.list();
			tx.commit();
			return list;
		}catch (Exception e){
			e.printStackTrace();
			return list;
		}finally{
			if(tx!=null){
				tx=null;
			}
		}
	}

	@Override
	public boolean delTeacherByTid(Integer tid) {
		Transaction tx=null;
		try {
			Session session=MyhibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			Teachers teacher=(Teachers)session.get(Teachers.class, tid);
			session.delete(teacher);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return false;
		} finally{
			if(tx!=null) {
				tx=null;
			}
		}
	}

	@Override
	public boolean addTeachers(Teachers teacher) {
		Transaction tx=null;
		try {
			Session session=MyhibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			session.save(teacher);
			tx.commit();
			return true;
		 } catch (Exception e) {
			e.printStackTrace();
			return false;
		 } finally {
			if(tx!=null){
				tx=null;
			}
		}
	}
}
