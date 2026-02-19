package Generic_Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtils {

	Connection conn = null;
	ResultSet result = null;

	/**
	 * This method is sued to make a connection to the dB
	 * 
	 * @author Aswathi
	 * @throws SQLException
	 */
	public void connectToDB() throws SQLException {

		// register the database
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);

		// get connection for database
		conn = DriverManager.getConnection(IPathConstants.dbURL, IPathConstants.dbUsername, IPathConstants.dbPassword);

	}

	/**
	 * This method is used to create a statement, execute a query and return the
	 * result
	 * 
	 * @author Aswathi
	 * @param query
	 * @return
	 * @throws SQLException
	 */
	public ResultSet executeQuery(String query) throws SQLException {
		// create statement
		Statement state = conn.createStatement();

		// execute query
		result = state.executeQuery(query);

		return result;

	}

	/**
	 * This method is used to update the query , store in result and return the
	 * value
	 * 
	 * @author Aswathi
	 * @param query
	 * @return
	 * @throws SQLException
	 */
	public int updateQuery(String query) throws SQLException {
		// create statement
		Statement state = conn.createStatement();

		// execute query
		int res = state.executeUpdate(query);

		return res;

	}

	/**
	 * This method is used to close the database connection
	 * 
	 * @author Aswathi
	 * @throws SQLException
	 */
	public void disconnectDB() throws SQLException {
		// close database connection
		conn.close();
	}

}
