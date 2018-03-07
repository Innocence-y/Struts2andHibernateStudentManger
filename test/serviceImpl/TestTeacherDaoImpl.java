package serviceImpl;

import model.Teachers;
import org.junit.Assert;
import org.junit.Test;
import serviceImpl.impl.TeachersDAOimpl;

import java.util.Date;
import java.util.List;

public class TestTeacherDaoImpl {
	@Test
	public void addTeacherTest(){
		Teachers teachers=new Teachers();
		teachers.setAddress("中北大学");
		teachers.setTid(1234);
		teachers.setFac("2345");
		teachers.setTtime(new Date());
		teachers.setTname("王老师");
		TeachersDAO teachersDAO=new TeachersDAOimpl();
		Assert.assertEquals(true,teachersDAO.addTeachers(teachers));
	}
	@Test
	public  void queryTeacherTest(){
		TeachersDAO teachersDAO=new TeachersDAOimpl();
		List<Teachers> teachers=teachersDAO.queryALLTeachers();
		System.out.println("老师的测试类"+teachers);
	}

	@Test
	public void delTeacherTest(){
		TeachersDAO teachersDAO = new TeachersDAOimpl();
		teachersDAO.delTeacherByTid(1234);
	}


}
