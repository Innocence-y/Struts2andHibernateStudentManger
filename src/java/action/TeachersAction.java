package action;

import com.opensymphony.xwork2.ModelDriven;
import model.Teachers;
import serviceImpl.TeachersDAO;
import serviceImpl.impl.TeachersDAOimpl;

import java.util.List;

public class TeachersAction extends SuperAction implements ModelDriven<Teachers> {
	private Teachers teacher=new Teachers();
	@Override
	public Teachers getModel() {
		return this.teacher;
	}

	public String query()
	{
		List<Teachers> teacher=null;
		TeachersDAO tDao=new TeachersDAOimpl();
		try{
			/*Students student=(Students) session.getAttribute("loginStudent");
			Users user=(Users) session.getAttribute("loginUser");
			//System.out.println(user);
			//System.out.println(student);
			if(user.getTag().trim().equals("1")) {*/
				teacher=tDao.queryALLTeachers();
				session.setAttribute("teachers_list", teacher);
				return "query_success";
			/*} else {
				return "query_nosuccess";
			}*/
		}catch(Exception e){
			e.printStackTrace();
		}
		return "query_nosuccess";
	}
	/**
	 * 删除教师信息,并显示
	 */
	public String delete () {
		TeachersDAO tDao=new TeachersDAOimpl();
		//String sid=request.getParameter("id");////////////深究！
		Integer tid = Integer.valueOf(request.getParameter("tid"));
		tDao.delTeacherByTid(tid);
		return "delete_success";
	}

	/**
	 * 添加教师信息,并显示
	 */
	public String add(){
		TeachersDAO tDao=new TeachersDAOimpl();
		System.out.println(teacher);
		tDao.addTeachers(teacher);
		return "add_success";
	}

}
