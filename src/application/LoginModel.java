package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {
	Connection connection;
	public LoginModel()
	{
		connection=Sqliteconnection.connector();
		if(connection==null)
			System.exit(1);
	}
	public boolean isValidLogin(String username,String password) throws SQLException
	{
		System.out.println(username);
		System.out.println(password);
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String query="SELECT * FROM Login WHERE username = ? AND password = ?";
			try {
			pstmt=connection.prepareStatement(query);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs= pstmt.executeQuery();
			System.out.println("rs");
					if(rs.next()) {
						return true;
					}
					System.out.println("Invalid....");
			return false;		
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			rs.close();
		}
	}
	public boolean isDbconnected() {
		// TODO Auto-generated method stub
		try
		{
			return !connection.isClosed();
		}	catch(Exception e)
		{
		return false;
	}
}}
