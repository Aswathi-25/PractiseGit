package practise_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SelectQueryTest {
	public static void main(String[] args) throws SQLException {
		

		//step1: create driver object
		Driver driver1 = new Driver();
		
		
		//step2: register driver
		DriverManager.registerDriver(driver1);
		
		
		//step3: get connection for database
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/practise", "root", "root");
		//step4: create statement
		Statement state = con.createStatement();
		String query = "select * from emp;";
		
		//step5: execute query
		ResultSet result = state.executeQuery(query);
		
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
		}
		//step6: close database connection
		con.close();
	}

}
