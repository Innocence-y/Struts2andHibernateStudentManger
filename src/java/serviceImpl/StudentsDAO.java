package serviceImpl;

import model.Students;

import java.util.List;
//学生的业务逻辑接口
public interface StudentsDAO {
		//查询所有学生资料
	public List<Students> queryALLstudents();
		//查询单个学生资料
	public Students querystudentsBySid(String sid);
		//添加学生资料
	public boolean addStudents(Students s);
		//修改学生资料
	public boolean updatestudent(Students s);
		//删除学生资料
	public boolean delstudentBySid(String sid);
}
