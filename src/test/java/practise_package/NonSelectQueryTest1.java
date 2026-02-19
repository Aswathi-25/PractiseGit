package practise_package;
import java.sql.*;
import com.mysql.cj.jdbc.Driver;

public class NonSelectQueryTest1 {
	
	    public static void main(String[] args) throws Exception {

	        DriverManager.registerDriver(new Driver());

	        Connection con = DriverManager.getConnection(
	            "jdbc:mysql://localhost:3307/practise",
	            "root",
	            "root"
	        );

	        Statement stmt = con.createStatement();

	        String query = "INSERT INTO emp VALUES('Riya','Chennai','987')";

	        int count = stmt.executeUpdate(query);

	        System.out.println(count + " row updated.");

	        con.close();
	    }
	}



