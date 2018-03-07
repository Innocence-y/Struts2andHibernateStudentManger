package serviceImpl;

import model.Courses;

import java.util.List;

public interface CoursesDAO {
	public List<Courses> queryALLCourses();

	public List<Courses> queryCoursesBySid(String sid);

	public boolean delcourseBySid(Integer id);

	public boolean addCourses(Courses course);
}
