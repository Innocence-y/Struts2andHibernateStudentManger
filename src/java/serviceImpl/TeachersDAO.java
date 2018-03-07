package serviceImpl;

import model.Teachers;

import java.util.List;

public interface TeachersDAO {

	public List<Teachers> queryALLTeachers();

	public boolean delTeacherByTid(Integer tid);

	public boolean addTeachers(Teachers teacher);
}
