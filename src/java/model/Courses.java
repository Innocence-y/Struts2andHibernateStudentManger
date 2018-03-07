package model;

import java.util.Date;

public class Courses {
	private Integer id;
	private String cid;//课程号
	private String cname;//课程名称
	private String sid;//学号
	private Date ctime;//选课时间
	private String tname;//教师姓名
	private String fac;//院系

	public Courses() {
	}

	public Courses(Integer id, String cid, String cname, String sid, Date ctime, String tname, String fac) {
		this.id = id;
		this.cid = cid;
		this.cname = cname;
		this.sid = sid;
		this.ctime = ctime;
		this.tname = tname;
		this.fac = fac;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getFac() {
		return fac;
	}

	public void setFac(String fac) {
		this.fac = fac;
	}

	@Override
	public String toString() {
		return "Courses{" +
				"id=" + id +
				", cid='" + cid + '\'' +
				", cname='" + cname + '\'' +
				", sid='" + sid + '\'' +
				", ctime=" + ctime +
				", tname='" + tname + '\'' +
				", fac='" + fac + '\'' +
				'}';
	}
}
