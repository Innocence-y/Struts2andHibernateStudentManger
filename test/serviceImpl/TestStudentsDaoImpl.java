package serviceImpl;

import model.Students;
import org.junit.Assert;
import org.junit.Test;
import serviceImpl.impl.StudentsDAOimpl;

import java.util.Date;
import java.util.List;

public class TestStudentsDaoImpl {
	@Test
	public void testQueryAllStudents(){
		StudentsDAO sdao=new StudentsDAOimpl();
		List<Students> list=sdao.queryALLstudents();
		for (int i = 0; i <list.size() ; i++) {
			System.out.println(list.get(i));
		}
	}

	/*@Test
	public void testGetNewId(){
		StudentsDAO sdao=new StudentsDAOimpl();
		System.out.println(sdao.getNewId());
	}*/
	@Test
	public void testAddStudents(){
		Students s=new Students();
		s.setSname("ywq");
		s.setGender("nan");
		s.setBirthday(new Date());
		s.setAddress("shanxi");
		StudentsDAO sDao=new StudentsDAOimpl();
		Assert.assertEquals(true,sDao.addStudents(s));
	}
}
