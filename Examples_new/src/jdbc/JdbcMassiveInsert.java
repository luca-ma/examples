package jdbc;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.JdbcUtils.DB_TYPE;

import org.postgresql.copy.CopyManager;
import org.postgresql.core.BaseConnection;

public class JdbcMassiveInsert {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

	// Database credentials
	static final String USER = "postgres";
	static final String PASS = "luca";

	static String deleteTableSQL = "DELETE FROM identitymanagement";
	static String insertTableSQL = "Insert into identitymanagement"
			+ "(domain, public, alias) VALUES" + "(?,?,?)";

	/**
	 * delete and insert a large set of rows s starting with an csv file
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Connection dbConn = null;
		Statement stmt = null;

		try {
			// getDB connection
			dbConn = JdbcUtils.getDbConnection(DB_TYPE.POSTGRESQL, DB_URL,
					USER, PASS);

			System.out.println("CONN OK ");

			// 1) Set auto commit as false. START Transaction
			dbConn.setAutoCommit(false);

			long iniTime = System.currentTimeMillis();
			// 2) DELETE rows
			System.out.println("delete all ROWS ....");
			PreparedStatement preparedStatementDel = dbConn
					.prepareStatement(deleteTableSQL);
			int deletedRows = preparedStatementDel.executeUpdate();
			long delTime = System.currentTimeMillis();
			System.out.println("Deleted: " + deletedRows + " Rows in:"
					+ (delTime - iniTime) + " msec");

			// --INSERT a fake Row to trigger a rollback
			// System.out.println("Inserting one  fake row....");
			// PreparedStatement preparedStatementIns = dbConn
			// .prepareStatement(insertTableSQL);
			//
			// preparedStatementIns.setString(23, "a@a.it");

			// 3) -- copy csv file rows in db
			CopyManager copyManager = new CopyManager((BaseConnection) dbConn);

			FileReader fileReader = new FileReader("prova.csv");
			long copyIn = copyManager.copyIn(
					"COPY identitymanagement FROM STDIN WITH DELIMITER ','",
					fileReader);

			long InsTime = System.currentTimeMillis();
			System.out.println("Inserted: " + copyIn + " Rows in:"
					+ (InsTime - delTime) + " msec");

			// 4) Commit data here.
			dbConn.commit();
			System.out.println("Commiting data here....in :"
					+ (InsTime - iniTime) + " msec.");

			// %) Set auto commit as false. END Transaction
			dbConn.setAutoCommit(true);

			// vacuum after delete
			long iniVac = System.currentTimeMillis();
			final Statement st2 = dbConn.createStatement();
			st2.executeUpdate("VACUUM FULL ANALYZE VERBOSE");
			System.out.println("executing vacuum in "
					+ (System.currentTimeMillis() - iniVac) + " msec.");

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
