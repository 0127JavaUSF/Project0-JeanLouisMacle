package com.revature.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.pages.Page;

public class CredentialsDAO {
	/* UNIQUE CONSTRAINT sets on the username. Returns the clientid */
	public int retrieveCredentials(String username) {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "SELECT clientId FROM client WHERE username=?;";
		int clientId=0;//not null constraint on the cientId
		String password;
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();
			/* UNIQUE CONSTRAINT sets on the username; only one result in the resultset */
			while(result.next())
			{
				clientId = result.getInt("clientId");		
				Page.clientId = clientId;
				
			}		
			
			//password set to not null
			sql ="SELECT PASSWORD FROM confdata WHERE clientId=?;";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, clientId);
			result = statement.executeQuery();
			while (result.next())
			{
				password = result.getString("password");	
				Page.username = username;
				Page.password = password;
				return clientId;
			}
			
			
		}
		catch(SQLException e)
		{		
			e.printStackTrace();
		}
		return 0;
	}

	
}
