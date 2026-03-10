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

public class ExecuteSelectQueryExample2 {
	Connection connections;
	@Test
	public void sample2() throws SQLException {
		
		try {
		Driver driverRef = new Driver();// this step is not mandatory in newer versions
		DriverManager.registerDriver(driverRef);// this step is newer versions
		connections = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "vivek");
		Statement statement = connections.createStatement();
		ResultSet result = statement.executeQuery("select * from actor");
		// to print column names also
		ResultSetMetaData metaData = result.getMetaData();
		int columnCount = metaData.getColumnCount();

		for (int i = 1; i <= columnCount; i++) {
			System.out.printf("%-15s", metaData.getColumnName(i));
		}
		System.out.println();

		while (result.next()) {
			for (int i = 1; i <= columnCount; i++) {
				System.out.printf("%-15s", result.getString(i));
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
