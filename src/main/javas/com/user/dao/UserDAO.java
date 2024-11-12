package com.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.user.model.User;

public class UserDAO {
	private String jdbcURL="jdbc:mysql://localhost:30006/userappdb";
	private String jdbcUserName="root";
	private String jdbcPassword="root";
	
	private static final String INSERT_USER_SQL="INSERT INTO users"+"(uname,email,passwd) VALUES "+"(?,?,?);";
	private static final String SELECT_USER_BY_ID="SELECT * FROM USERS WHERE ID=?;";
	private static final String SELECT_ALL_USERS="SELECT * FROM USERS;";
	private static final String DELETE_USERS_SQL="DELETE FROM USERS WHERE ID=?;";
	private static final String UPDATE_USERS_SQL="UPDATE USER SET UNAME=?, EMAIL=?, PASSWD=? WHERE ID=?; ";
	public UserDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Connection getConnection()
	{
		Connection connection=null;
		
		try
		{
			Class.forName("com.mysql.cj.jbdc.Driver");
			connection=DriverManager.getConnection(jdbcURL, DELETE_USERS_SQL, jdbcPassword)
		}
		catch(SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return connection;
	}
	
	public void insertuser(User user)
	{
		UserDAO dao=new UserDAO();
		
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(INSERT_USER_SQL);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPasswd());
			
			preparedStatement.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public User selectUser(int id)
	{
		User user=new User();
		UserDAO dao=new UserDAO();
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(SELECT_USER_BY_ID);
			preparedStatement.setInt(1,id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				user.setId(id);
				user.setName(resultSet.getString("uname"));
				user.setEmail(resultSet.getString("email"));
				user.setPasswd(resultSet.getString("passwd"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public List<User> selectAllUser()
	{
		List<User> user=new ArrayList<User>();
		UserDAO dao=new UserDAO();
		
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_USERS);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				int id=resultSet.getInt("id");
				String uname=resultSet.getString("uname");
				String email=resultSet.getString("email");
				String passwd=resultSet.getString("passwd");
				
				user.add(new User(id,uname,email,passwd));
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	public boolean deleteUser(int id)
	{
		boolean status=false;
		UserDAO dao=new UserDAO();
		
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(DELETE_USERS_SQL);
			preparedStatement.setInt(1,id);
			
			status=preparedStatement.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
		
	}
	

}

	


