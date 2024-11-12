package com.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.user.model.student_details;

public class student_detailDAO {
	
	private static final String INSERT_USER_SQL="INSERT INTO users"+"(s_name,branch,semester,book_id,issue_date,return_date) VALUES "+"(?,?,?,?,?,?,?);";
	private static final String SELECT_USER_BY_ID="SELECT * FROM student_details WHERE roll_no=?;";
	private static final String SELECT_ALL_USERS="SELECT * FROM student_details;";
	private static final String DELETE_USERS_SQL="DELETE FROM student_details WHERE roll_no=?;";
	public student_detailDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Connection getConnection()
	{
		Connection connection=null;
		
		try
		{
			Class.forName("com.mysql.cj.jbdc.Driver");
			
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return connection;
	}
	public void insertuser(student_details user)
	{
		student_detailDAO dao=new student_detailDAO();
		
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(INSERT_USER_SQL);
			preparedStatement.setString(1, user.getS_name());
			preparedStatement.setString(2, user.getBranch());
			preparedStatement.setString(3, user.getSemester());
			preparedStatement.setString(4, user.getBook_id());
			preparedStatement.setDate(5, user.getIssue_date());
			preparedStatement.setDate(6, user.getReturn_date());
			
			
			preparedStatement.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public student_details selectUser(int roll_no)
	{
		student_details user=new student_details();
		student_detailDAO dao=new student_detailDAO();
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(SELECT_USER_BY_ID);
			preparedStatement.setInt(1,roll_no);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				user.setRoll_no(roll_no);
				user.setS_name(resultSet.getString("S_name"));
				user.setBranch(resultSet.getString("Branch"));
				user.setSemester(resultSet.getString("Semester"));
				user.setBook_id(resultSet.getString("Book_id"));
				user.setIssue_date(resultSet.getDate("Issue_date"));
				user.setReturn_date(resultSet.getDate("Return_date"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	public List<student_details> selectAllstudent_details()
	{
		List<student_details> user=new ArrayList<student_details>();
	    student_detailDAO dao=new student_detailDAO();
		
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_USERS);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				int roll_no=resultSet.getInt("roll_no");
				String S_name=resultSet.getString("S_name");
				String branch=resultSet.getString("branch");
				String semester=resultSet.getString("semester");
				String book_id=resultSet.getString("bokk_id");
				String issue_date=resultSet.getString("issue_date");
				String return_date=resultSet.getString("return_date");
				
				
				
				user.add(new student_details(roll_no,S_name,branch,semester,book_id,issue_date,return_date));
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public boolean deleteUser(int roll_no)
	{
		boolean status=false;
		student_detailDAO dao=new student_detailDAO();
		
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(DELETE_USERS_SQL);
			preparedStatement.setInt(1,roll_no);
			
			status=preparedStatement.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	
	
	}



}
