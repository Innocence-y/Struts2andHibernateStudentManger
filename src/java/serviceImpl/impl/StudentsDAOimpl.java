package serviceImpl.impl;

import db.MyhibernateSessionFactory;
import model.Students;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import serviceImpl.StudentsDAO;

import java.util.List;
//实现业务逻辑接口的实现类
public class StudentsDAOimpl implements StudentsDAO {

	//生成学生编号
	 private  String getNewId(){
		Transaction tx=null;
		String hql="";
		String sid=null;
		try {
			Session session=MyhibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			hql="select max(sid) from Students ";
			Query query=session.createQuery(hql);
			sid=(String) query.uniqueResult();
			if(sid==null||sid.equals("")) {
				//给个默认编号
				sid="s000001";
			}
			else {
				String temp=sid.substring(1);//取后5位
				int i=Integer.parseInt(temp);//转成数字
				i++;
				//再还原为字符串
				temp=String.valueOf(i);
				int len=temp.length();
				//凑够5位
				for(int j=0;j<5-len;j++) {
					temp="0"+temp;
				}
				sid="s"+temp;
			}
			tx.commit();
			return sid;
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
		}
		finally
		{
			if(tx!=null)
			{
				tx=null;
			}
		}
		return sid;
	}


	@Override
	//查询所有学生资料
	public List<Students> queryALLstudents() {
		List<Students> list=null;
		Transaction tx=null;
		String hql="";
		try {
			System.out.println("查询所有学生");
			Session session= MyhibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			hql="from Students ";
			Query query=session.createQuery(hql);
			list=query.list();
			tx.commit();
			return list;
		}
		catch (Exception e) {
			e.printStackTrace();
			return list;
		} finally {
			if(tx!=null) {
				tx=null;
			}
		}
	}

	@Override
	public Students querystudentsBySid(String sid) {
		Transaction tx=null;
		String hql="";
		Students s=null;
		try {
			Session session=MyhibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			/*hql="from Students where SID=? ";
			Query query=session.createQuery(hql);
			query.setParameter(0, sid);
			students=(model.Students) query.uniqueResult();*/
			s=(Students)session.get(Students.class,sid);
			tx.commit();
			return s;

		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
		} finally {
			if(tx!=null)
			{
				tx=null;
			}
		}
		return s;
	}


	@Override
	public boolean addStudents(Students s) {
		s.setSid(getNewId());
		Transaction tx=null;
		try {
			Session session=MyhibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			session.save(s);
			tx.commit();
			return true;
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}finally {
			if (tx!=null){
				tx=null;
			}
		}
	}

	@Override
	public boolean updatestudent(Students s) {
		Transaction tx=null;
		String hql="";
		try {
			Session session=MyhibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			session.update(s);
			tx.commit();
			return true;

		} catch (Exception e)
		{
			e.printStackTrace();
			tx.commit();

		}
		finally
		{
			if(tx!=null)
			{
				tx=null;
			}
		}
		return true;
	}

	@Override
	public boolean delstudentBySid(String sid) {
		Transaction tx=null;
		try {
			Session session=MyhibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			Students students=(Students)session.get(Students.class, sid);
			session.delete(students);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return false;
		}
		finally {
			if(tx!=null)
			{
				tx=null;
			}
		}
	}

}
