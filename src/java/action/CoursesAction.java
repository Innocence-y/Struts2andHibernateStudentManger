package action;

import com.opensymphony.xwork2.ModelDriven;
import model.Courses;
import serviceImpl.CoursesDAO;
import serviceImpl.impl.CoursesDAOimpl;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

public class CoursesAction extends SuperAction implements ModelDriven<Courses> {
	private Courses courses=new Courses();
	private static final long serialVersionUID = 1L;
	@Override
	public Courses getModel() {
		this.courses.setCtime(new Date());
		return this.courses;
	}
	/**
	 * 查询所有选课信息
	 */
	public String query() {
		List<Courses> courses = null;
		CoursesDAO cDao = new CoursesDAOimpl();
		//HttpSession session = null;
		try {
			/*Students students = (Students) session.getAttribute("loginUserName");
			System.out.println("-----------"+students);
			Users user = (Users) session.getAttribute("loginUserName");
			System.out.println("-----------"+user);
			if (user.getTag().trim().equals("1")) {*/
				courses = cDao.queryALLCourses();
				System.out.println("查询所有课程");
				System.out.println("+++++++"+courses);
				session.setAttribute("courses_list", courses);
			/*} else {
				courses = cDao.queryCoursesBySid(user.getSid());
				session.setAttribute("courses_list", courses);
				System.out.println("通过学生id查询课程");
			}*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "query_success";
	}

	public String delete(){
		CoursesDAO cdao=new CoursesDAOimpl();
		HttpServletRequest request=null;
		Integer id=Integer.valueOf(request.getParameter("id"));
		cdao.delcourseBySid(id);
		return "delete_success";
	}

	public String add(){
		CoursesDAO cDao=new CoursesDAOimpl();
		cDao.addCourses(courses);
		return "add_success";
	}
}
