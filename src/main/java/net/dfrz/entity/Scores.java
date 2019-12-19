package net.dfrz.entity;

public class Scores {
	
	private int id;
	private String math;
	private String stuID;
	
	public Scores() {
	}
	public Scores(int id, String math,String stuID) {
		super();
		this.id = id;
		this.math = math;
		this.stuID=stuID;
	}
	
	public String getStuID() {
		return stuID;
	}
	public void setStuID(String stuID) {
		this.stuID = stuID;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMath() {
		return math;
	}
	public void setMath(String math) {
		this.math = math;
	}
	
	

}
