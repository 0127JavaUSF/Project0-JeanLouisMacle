package com.revature.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.pages.Page;

public class UserProfileDAO {
	
	public int getProfile(int id) {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "SELECT clientId, firstName, lastName,email, username FROM Client WHERE clientId=?";
		int profileIsNotNull = 0;
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1,id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				int clientId = result.getInt("clientId");
				String firstName = result.getString("firstName");
				String lastName = result.getString("lastName");
				String email = result.getString("email");
				String username = result.getString("username");				
				Page.setUserProfile(new UserProfile(clientId,firstName,lastName,email,username));	
				profileIsNotNull = 1;
			}
		} 
		catch (SQLException e) {		
			e.printStackTrace();
		}			
		if (!profileIsNotNull) System.err.println("The program failed to save the user profile");
		return profileIsNotNull;
	}
	//Stores username and client id
	public int setUserName(String userName) {
		Connection connection = ConnectionUtil.getConnection();
		String sql ="INSERT INTO client (username) VALUES (?) RETURNING clientId;";
		ResultSet result;
		int clientId;
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1,userName);
			result = statement.executeQuery();		
			while (result.next()) {
				clientId = result.getInt("clientId");
				Page.clientId = clientId;
				System.out.println("Client id: "+clientId);
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int setPassword(int clientId, String password) {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "INSERT INTO confdata (clientid ,PASSWORD) VALUES (?,crypt(?,gen_salt('bf')));";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1,clientId);
			statement.setString(2,password);
			return statement.executeUpdate();	
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	
	public int getClientIdFromPasswordAndHash(String password, String hash) {
		int clientId=0;
		Connection connection = ConnectionUtil.getConnection();
		String sql ="SELECT clientId FROM confdata WHERE password = crypt(?, ?);";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1,password);
			statement.setString(2,hash);
			ResultSet result =  statement.executeQuery();
			if (result.next()) {
				clientId = result.getInt("clientId");			
			}
			return clientId;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return 0;
	}
}
	
