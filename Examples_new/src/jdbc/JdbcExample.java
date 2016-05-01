package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.JdbcUtils.DB_TYPE;

/**
 * JDBC example with postgresql
 * 
 * --> example of delete and insert --> verify that with setAutoCommit == false
 * Rollback works properly (NO with seet autocommit == true)
 * 
 * @author l
 * 
 */
public class JdbcExample {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

	// Database credentials
	static final String USER = "postgres";
	static final String PASS = "luca";

	static String insertTableSQL = "Insert into identitymanagement"
			+ "(domain, public, alias) VALUES" + "(?,?,?)";
	static String deleteTableSQL = "DELETE FROM identitymanagement";

	public static void main(String[] args) {

		Connection dbConn = null;
		Statement stmt = null;
		try {

			// getDB connection
			dbConn = JdbcUtils.getDbConnection(DB_TYPE.POSTGRESQL, DB_URL,
					USER, PASS);

			// 1) Set auto commit as false.
			dbConn.setAutoCommit(true);

			// 2) -- DELETE all rows
			System.out.println("delete all ROWS ....");
			PreparedStatement preparedStatementDel = dbConn
					.prepareStatement(deleteTableSQL);
			int deletedRows = preparedStatementDel.executeUpdate();
			System.out.println("Deleted: " + deletedRows + " Rows");

			// 2) --INSERT a row into table
			System.out.println("Inserting one row....");
			PreparedStatement preparedStatementIns = dbConn
					.prepareStatement(insertTableSQL);

			preparedStatementIns.setInt(1, 13);
			preparedStatementIns.setString(2, "2");
			preparedStatementIns.setString(3, "b@b.it");
			preparedStatementIns.setString(23, "a@a.it");
			int insertedRows = preparedStatementIns.executeUpdate();
			System.out.println("ADD: " + insertedRows + " Rows");

			// 6) Commit data here.
			System.out.println("Commiting data here....");
			dbConn.commit();

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
			// If there is an error then rollback the changes.
			System.out.println("Rolling back data here....");
			try {
				if (dbConn != null)
					dbConn.rollback();
			} catch (SQLException se2) {
				se2.printStackTrace();
			}// end try

		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (dbConn != null)
					dbConn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try

	}
}
