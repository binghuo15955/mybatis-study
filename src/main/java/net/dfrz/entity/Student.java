package net.dfrz.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Student implements Serializable 
{
	/**
	 * 序列化设置for二级缓存
	 */
	private static final long serialVersionUID = 1L;
	private String stuID;
	private String name;
	private Date birthday;
	private String sex;
	
	private Set<Scores> scoresSet;
	
	public Student() {
		scoresSet = new HashSet<Scores>();
	}
	public Student(String stuID, String name, Date birthday, String sex) {
		this();
		this.stuID = stuID;
		this.name = name;
		this.birthday = birthday;
		this.sex = sex;
	}
	
	public Set<Scores> getScoresSet() {
		return scoresSet;
	}
	public void setScoresSet(Set<Scores> scoresSet) {
		this.scoresSet = scoresSet;
	}
	public String getStuID() {
		return stuID;
	}
	public void setStuID(String stuID) {
		this.stuID = stuID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
}
