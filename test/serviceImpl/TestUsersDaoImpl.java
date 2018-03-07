package serviceImpl;

import model.Users;
import org.junit.Assert;
import org.junit.Test;
import serviceImpl.impl.UsersDAOimpl;

public class TestUsersDaoImpl {
	@Test
	public void testUsersLogin(){
	Users users=new Users("1","1");
		UsersDAO uDao= new UsersDAOimpl();
		Assert.assertEquals(true,uDao.usersLogin(users));
	}
}
