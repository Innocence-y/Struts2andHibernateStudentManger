package serviceImpl;

import model.Courses;
import model.Students;
import org.junit.Test;
import serviceImpl.impl.CoursesDAOimpl;
import serviceImpl.impl.StudentsDAOimpl;

import java.util.List;

public class TestServiceImpl {
	@Test
	public void Test(){
		String str="s00001";
		StudentsDAO sDao=new StudentsDAOimpl();
		Students students=sDao.querystudentsBySid(str);
		System.out.println(students);
	}
	@Test
	public  void TestQueryCourses(){
		CoursesDAO coursesDAO=new CoursesDAOimpl();
		List<Courses> courses=coursesDAO.queryALLCourses();
		System.out.println(courses);
	}

}
