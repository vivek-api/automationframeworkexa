package workingwithdatabases.workingwithmysqldatabases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class ExecuteNonSelectQueryExample2 {
	Connection connections;
	@Test
	public void sample2() throws SQLException {
		
		try {
		Driver driverRef = new Driver();// this step is not mandatory in newer versions
		DriverManager.registerDriver(driverRef);// this step is newer versions
		connections = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "vivek");
		Statement statement = connections.createStatement();
		int result = statement.executeUpdate("update actor SET first_name='PENELOPE',last_name='GUINESS' where actor_id=1");
		//displaying after updating
		ResultSet result1 = statement.executeQuery("select * from actor");
		// to print column names also
		ResultSetMetaData metaData = result1.getMetaData();
		int columnCount = metaData.getColumnCount();

		for (int i = 1; i <= columnCount; i++) {
			System.out.printf("%-15s", metaData.getColumnName(i));
		}
		System.out.println();

		while (result1.next()) {
			for (int i = 1; i <= columnCount; i++) {
				System.out.printf("%-15s", result1.getString(i));
			}
			System.out.println();
		
		}
		}catch(Exception e) {
			
		}
		finally {
			connections.close();
		}

	}

}
