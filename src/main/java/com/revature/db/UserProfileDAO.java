package com.revature.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserProfileDAO {
	
	public UserProfile getProfile(int id) {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "SELECT clientId, firstName, lastName,email, username FROM Client WHERE clientId=?";
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
				return new UserProfile(clientId,firstName,lastName,email,username);				
			}
		} catch (SQLException e) {		
			e.printStackTrace();
		}		
		return null;
		
	}

}
