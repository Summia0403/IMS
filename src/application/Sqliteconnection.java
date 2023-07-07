package application;

import java.sql.Connection;
import java.sql.DriverManager;

public class Sqliteconnection {
	public static Connection connector() {
		try{ 
			Connection con= DriverManager.getConnection("jdbc:sqlite:Inventory.db");
			return con;
		}
		catch(Exception e) {
			return null;
		}

	}
}

