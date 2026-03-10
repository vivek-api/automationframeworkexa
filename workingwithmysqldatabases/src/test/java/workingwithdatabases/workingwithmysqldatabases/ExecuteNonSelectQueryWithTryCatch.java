package workingwithdatabases.workingwithmysqldatabases;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class ExecuteNonSelectQueryWithTryCatch {
	
	/*
	 * Steps to perform operation with database mysql from java
	 *  1: load or register the database driver 
	 *  2: connect to the database 
	 *  3: create sql statement 
	 *  4: execute select query and get result 
	 *  5: close the connection
	 */
	
	Connection connection;
	@Test
	public void perform() throws SQLException {
		
		try {
		//1: load or register the mysql database driver using DriverManager class
		Driver driverRef=new Driver(); //from com.mysql.jdbs.driver
		DriverManager.registerDriver(driverRef);
		
		//2: connect to the database 
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","vivek");
		
		//3: create sql statement 
		Statement statement = connection.createStatement();
		//this gives statement object which allow us to execute the query
		
		//4: execute non select query and get result in integer 
			int result = statement.executeUpdate("update city SET Name='VIVEK' where id=1");
			System.out.println(result);//gives integer value to specify the execution is successful or not
		
		}catch(Exception e) {
			
		}finally {
		//5: close the connection
			connection.close();
		
		}
		
		
		
		
	}

}
