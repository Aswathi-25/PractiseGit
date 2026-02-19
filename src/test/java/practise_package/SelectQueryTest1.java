package practise_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SelectQueryTest1 {
		
		    public static void main(String[] args) throws SQLException {

		        Driver driver1 = new Driver();
		        DriverManager.registerDriver(driver1);

		        Connection con = DriverManager.getConnection(
		                "jdbc:mysql://localhost:3307/practise",
		                "root",
		                "root"
		        );

		        Statement stmt = con.createStatement();
		        //SELECT * FROM emp WHERE name LIKE 'A%';
		        //SELECT * FROM emp ORDER BY name ASC;
		       // SELECT * FROM emp WHERE name='Aswathi' OR location='chennai';

		        String query = "SELECT * FROM emp WHERE location = 'blore';";

		        ResultSet rs = stmt.executeQuery(query);

		        while(rs.next()) {
		            System.out.println(
		                rs.getString(1) + " " +
		                rs.getString(2) + " " +
		                rs.getString(3)
		            );
		        }

		        con.close();
		    }
		}

	
