package action;

import com.opensymphony.xwork2.ActionSupport;
import model.Users;
import serviceImpl.UsersDAO;
import serviceImpl.impl.UsersDAOimpl;

import javax.servlet.http.HttpServletRequest;

/**
 * 描述:用户注册
 *
 * @author 闫文强
 * @create 2017-11-27 18:23
 */
public class RegistAction extends ActionSupport{
	protected HttpServletRequest request;//请求对象
	private String username;
	private String password;

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

	public void validate(){
		if (username==null||username.length()==0){
			addFieldError("userName", "用户名不能为空!");
		}else if(this.getPassword()==null||this.getPassword().length()==0){
			addFieldError("password","密码不能为空");
		}
	}

	public String save(){
		UsersDAO usersDAO=new UsersDAOimpl();
		if (username==null||username.length()==0){
			return "input";
		}else if(password==null||password.length()==0){
			return "input";
		}else {
			Users users = new Users();
//			String username = request.getParameter("username");
//			String password = request.getParameter("password");
			users.setUsername(username);
			users.setPassword(password);
			System.out.println(users.getUsername());
			System.out.println(users.getPassword());
			usersDAO.save(users);
			return "save_success";
		}
	}
}