package serviceImpl.impl;

import db.MyhibernateSessionFactory;
import model.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import serviceImpl.UsersDAO;

import java.util.Calendar;
import java.util.List;

public class UsersDAOimpl implements UsersDAO  {
	@Override
	public boolean usersLogin(Users user) {
		//事物对象
		Transaction tx=null;
		String hql="";
		try {
			Session session= MyhibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			//Users为model中的类，而不是数据库中的表
			hql="from Users where username=? and password=? ";
			Query query=session.createQuery(hql);
			query.setParameter(0, user.getUsername());
			query.setParameter(1, user.getPassword());
			List list =query.list();
			tx.commit();//提交事务
			if(list.size()>0) {
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if(tx!=null) {
				//tx.commit();
				tx=null;
			}
		}
	}

	@Override
	public boolean queryStudents(Users user) {
		Transaction tx=null;
		String hql="";
		try {
			Session session=MyhibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			//Users为model中的类，而不是数据库中的表
			hql="from Users where username=? and password=? ";
			Query query=session.createQuery(hql);
			query.setParameter(0, user.getUsername());
			query.setParameter(1, user.getPassword());
			List list =query.list();
			tx.commit();//提交事务
			if(list.size()>0) {
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if(tx!=null) {
				//tx.commit();
				tx=null;
			}
		}
	}

	@Override
	public Users queryUsers(String username) {
		Transaction tx = null;
		String hql = "";
		Users user = null;
		try {
			Session session = MyhibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			//Users为model中的类，而不是数据库中的表
			hql = "from Users where USERNAME=? ";
			Query query = session.createQuery(hql);
			query.setParameter(0, username);
			user = (Users) query.uniqueResult();
			tx.commit();//提交事务
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (tx != null) {
				//tx.commit();
				tx = null;
			}
		}
		return user;
	}

	@Override
	public void save(Users users) {
		Transaction tx = null;
		String hql = "";
		try {
			Session session = MyhibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.save(users);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (tx != null) {
				//tx.commit();
				tx = null;
			}
		}
	}
}
