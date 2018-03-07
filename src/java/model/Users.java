package model;

public class Users {
	private Integer uid;
	private String username;
	private String password;
	public Users() {
	}

	public Users(String username, String password) {
		this.username = username;
		this.password = password;
	}

//	public Users(String uid, String username, String password, String sid, String tag) {
//		this.uid = uid;
//		this.username = username;
//		this.password = password;
//		this.sid = sid;
//		this.tag = tag;
//	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

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




}
