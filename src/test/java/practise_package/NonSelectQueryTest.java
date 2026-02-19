package practise_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQueryTest {
	public static void main(String[] args) throws SQLException {
		
		        DriverManager.registerDriver(new Driver());

		        Connection con = DriverManager.getConnection(
		            "jdbc:mysql://localhost:3307/practise",
		            "root",
		            "root"
		        );

		        Statement stmt = con.createStatement();

		        String query = "UPDATE emp SET location='Mumbai' WHERE name='Aswathi'";

		        int count = stmt.executeUpdate(query);

		        System.out.println(count + " row updated.");

		        con.close();
		    }
		}
