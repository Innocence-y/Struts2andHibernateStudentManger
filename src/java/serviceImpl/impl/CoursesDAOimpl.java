package serviceImpl.impl;

import db.MyhibernateSessionFactory;
import model.Courses;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import serviceImpl.CoursesDAO;

import java.util.List;

public class CoursesDAOimpl implements CoursesDAO{
	@Override
	public List<Courses> queryALLCourses() {
		List<Courses> list=null;
		Transaction tx=null;
		String hql="";
		try {
			Session session= MyhibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			hql="from Courses ";
			Query query=session.createQuery(hql);
			list=query.list();
			tx.commit();
			System.out.println("list="+list);
			return list;
		}catch (Exception e){
			e.printStackTrace();
			return list;
		} finally {
			if (tx!=null){
				tx=null;
			}
		}
	}


	@Override
	public List<Courses> queryCoursesBySid(String sid) {
		Transaction tx=null;
		String hql="";
		List<Courses> course=null;
		try {
			Session session=MyhibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			hql="from Courses where SID=?";
			Query query=session.createQuery(hql);
			query.setParameter(0,sid);
			course=query.list();
			tx.commit();
			return course;
		}catch (Exception e){
			e.printStackTrace();
			tx.commit();
		}finally {
			if(tx!=null) {
				tx=null;
			}
		}
		return course;
	}
	@Override
	public boolean delcourseBySid(Integer id) {
		Transaction tx=null;
		try {
			Session session=MyhibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			Courses course=(Courses)session.get(Courses.class, id);
			session.delete(course);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return false;
		} finally {
			if(tx!=null) {
				tx=null;
			}
		}
	}


	@Override
	public boolean addCourses(Courses course) {
		Transaction tx=null;
		try {
			Session session=MyhibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			session.save(course);
			tx.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if(tx!=null)
			{
				tx=null;
			}
		}
	}
}
