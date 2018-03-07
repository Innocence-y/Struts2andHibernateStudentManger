package action;

import model.Users;
import org.apache.struts2.interceptor.validation.SkipValidation;
import serviceImpl.StudentsDAO;
import serviceImpl.UsersDAO;
import serviceImpl.impl.StudentsDAOimpl;
import serviceImpl.impl.UsersDAOimpl;

public class UsersAction extends SuperAction {

	private Users user=new Users();

	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String password;

	public String login(){

		System.out.println(username+password);
		user.setUsername(username);
		user.setPassword(password);

		UsersDAO uDao=new UsersDAOimpl();
		StudentsDAO sDao=new StudentsDAOimpl();
		System.out.println("--------------------");
		try{
			if(uDao.usersLogin(user)) {   //进不去、、、、、、、、、、
				System.out.println("888888888888888888");
				session.setAttribute("loginUserName",user.getUsername());
				return "login_success";
			} else{
				this.addFieldError("inputError", "用户名或者密码错误");
				return "login_false";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "login_false";
	}

	@SkipValidation
	public String logout() {
		if(session.getAttribute("loginUserName")!=null) {
			session.removeAttribute("loginUserName");
		}
		return "logout_success";
	}

	@Override
	public void validate() {
		try {
			if(user.getUsername().trim().equals(""))
			{
				this.addFieldError("UsernameError", "用户名不能为空");
			}
			if(user.getPassword().length()<3)
			{
				this.addFieldError("PasswordError", "密码不能少于3位");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

//	@Override
//	public Users getModel() {
//		return this.user;
//	}
}
