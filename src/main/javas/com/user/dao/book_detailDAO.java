package com.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.user.model.book_details;
import com.user.model.student_details;

public class book_detailDAO {
	private static final String INSERT_USER_SQL="INSERT INTO users"+"(B_name,Author,Publiser,edition) VALUES "+"(?,?,?,?);";
	private static final String SELECT_USER_BY_ID="SELECT * FROM book_details WHERE book_id=?;";
	private static final String SELECT_ALL_USERS="SELECT * FROM book_details;";
	private static final String DELETE_USERS_SQL="DELETE FROM book_details WHERE book_id=?;";
	public book_detailDAO() {
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
	public void insertuser(book_details user)
	{
		book_detailDAO dao=new book_detailDAO();
		
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(INSERT_USER_SQL);
			preparedStatement.setString(1, user.getB_name());
			preparedStatement.setString(2, user.getAuthor());
			preparedStatement.setString(3, user.getPublisher());
			preparedStatement.setString(4, user.getEdition());
			
			
			
			preparedStatement.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public book_details selectUser(int book_id)
	{
		book_details user=new book_details();
		book_detailDAO dao=new book_detailDAO();
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(SELECT_USER_BY_ID);
			preparedStatement.setInt(1,book_id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				user.setBook_id(book_id);
				user.setB_name(resultSet.getString("b_name"));
				user.setAuthor(resultSet.getString("author"));
				user.setPublisher(resultSet.getString("publisher"));
				user.setEdition(resultSet.getString("edition"));
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	public List<book_details> selectAllbook_details()
	{
		List<book_details> user=new ArrayList<book_details>();
	    book_detailDAO dao=new book_detailDAO();
		
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_USERS);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				int book_id=resultSet.getInt("book_id");
				String B_name=resultSet.getString("B_name");
				String Author=resultSet.getString("Author");
				String Publisher=resultSet.getString("Publisher");
				String edition=resultSet.getString("edition");
				
				
				
				
				user.add(new student_details(book_id,B_name,Author,Publisher,edition,));
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	public boolean deleteUser(int book_id)
	{
		boolean status=false;
		book_detailDAO dao=new book_detailDAO();
		
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(DELETE_USERS_SQL);
			preparedStatement.setInt(1,book_id);
			
			status=preparedStatement.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	
	
	}


}
