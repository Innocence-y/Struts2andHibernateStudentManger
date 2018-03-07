package serviceImpl;

import model.Courses;
import org.junit.Assert;
import org.junit.Test;
import serviceImpl.impl.CoursesDAOimpl;

import java.util.Date;
import java.util.List;

public class TestCoursesDaoImpl {
	@Test
	public void testAddCourses(){
		Courses courses=new Courses();
		courses.setCid("000003");
		courses.setCtime(new Date());
		courses.setCname("数学");
		courses.setFac("2321");
		courses.setSid("423");
		courses.setTname("李老师");
		CoursesDAO coursesDAO=new CoursesDAOimpl();
		Assert.assertEquals(true,coursesDAO.addCourses(courses));
	}

	@Test
	public void testDeleteCourse(){
		CoursesDAO coursesDAO=new CoursesDAOimpl();
		coursesDAO.delcourseBySid(2);
	}

	@Test
	public void testQueryCourse(){
		CoursesDAO coursesDAO=new CoursesDAOimpl();

		List<Courses> courses=  coursesDAO.queryALLCourses();
		System.out.println("测试类"+courses);
	}
}
