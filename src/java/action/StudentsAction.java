package action;

import com.opensymphony.xwork2.ModelDriven;
import model.Students;
import serviceImpl.StudentsDAO;
import serviceImpl.impl.StudentsDAOimpl;

import java.text.SimpleDateFormat;
import java.util.List;

public class StudentsAction extends SuperAction implements ModelDriven<Students>{
	private Students students=new Students();
	@Override
	public Students getModel() {
		return this.students;
	}
	/**
	 * 显示全部学生
	 */
	public String query(){
		System.out.println("111111111111111111");
		StudentsDAO sDao=new StudentsDAOimpl();
		List<Students> list=sDao.queryALLstudents();
		if (list!=null&&list.size()>0){
			//放到session中
			System.out.println("执行SQL语句");
			session.setAttribute("student_list",list);
			System.out.println(list);
		}
		return "query_success";
	}

	/**
	 * 删除学生，并显示
	 */
	public String delete(){
		StudentsDAO sDao=new StudentsDAOimpl();
		String sid=request.getParameter("sid");
		sDao.delstudentBySid(sid);
		return "delete_success";
	}

	/**
	 * 添加学生，并展示
	 */

	public String add()
	{
		StudentsDAO sDao=new StudentsDAOimpl();
		sDao.addStudents(students);
		return "add_success";
	}

	/**
	 *
	 *
	 */

	public String modify(){
		String sid=request.getParameter("sid");
		StudentsDAO sDao=new StudentsDAOimpl();
		Students s=sDao.querystudentsBySid(sid);
		//保存在会话中
		session.setAttribute("modify_students",s);
		return "modify_success";
	}

	public String save() throws Exception{
		Students s=new Students();
		s.setSid(request.getParameter("sid"));
		s.setSname(request.getParameter("sname"));
		s.setGender(request.getParameter("gender"));
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		s.setBirthday(sdf.parse(request.getParameter("birthday")));
		s.setAddress(request.getParameter("address"));
		StudentsDAO sDao=new StudentsDAOimpl();
		sDao.updatestudent(s);
		return "save_success";
	}


	public String queryById(){
		Students students=new Students();
		StudentsDAO studentsDAO=new StudentsDAOimpl();
		students=studentsDAO.querystudentsBySid(request.getParameter("sid"));
		session.setAttribute("students_one",students);
		System.out.println(students);
		return "queryById_success";
	}

}
