package com.user.model;

public class student_details {
	
	private int roll_no;
	private String s_name;
	private String branch;
	private String semester;
	private String book_id;
    private String issue_date;
	private String return_date;
	public student_details() {
		super();
		// TODO Auto-generated constructor stub
	}
	public student_details(int roll_no, String s_name, String branch, String semester, String book_id, String issue_date2,
			String return_date2) {
		super();
		this.roll_no = roll_no;
		this.s_name = s_name;
		this.branch = branch;
		this.semester = semester;
		this.book_id = book_id;
		this.issue_date = issue_date2;
		this.return_date = return_date2;
	}
	public int getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public String getIssue_date() {
		return issue_date;
	}
	public void setIssue_date(String issue_date) {
		this.issue_date = issue_date;
	}
	public String getReturn_date() {
		return return_date;
	}
	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}
	@Override
	public String toString() {
		return "Student_Details [roll_no=" + roll_no + ", s_name=" + s_name + ", branch=" + branch + "]";
	}
	
	

}
