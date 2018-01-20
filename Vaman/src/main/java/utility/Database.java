package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Database {
	public static Connection con;
	public static Statement stmt;
	public static ResultSet rs;
	
	
	public static void dbConnectionOpen() throws Exception {
    String dbUrl = Utility.getProperty("src/main/java/objectProperty/database.properties","dbUrl");
    String dbUsername=Utility.getProperty("src/main/java/objectProperty/database.properties","dbUsername");
    String dbPassword=Utility.getProperty("src/main/java/objectProperty/database.properties","dbPassword");
    String dbClass=Utility.getProperty("src/main/java/objectProperty/database.properties","dbClass");
    Class.forName(dbClass);
    con = DriverManager.getConnection (dbUrl,dbUsername,dbPassword);
    System.out.println ("Connection Successful");
  
	}

	
	
	public static void dbconnectionClose() throws SQLException {
	    con.close();
	    System.out.println ("Connection Closed");
	}
	
}
