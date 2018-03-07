package serviceImpl;

import model.Users;
//用户登录逻辑接口
public interface UsersDAO {
		//用户登录方法
	public boolean usersLogin(Users user);

	public boolean queryStudents(Users user);

	public Users queryUsers(String username);

	public void save(Users users);
}
