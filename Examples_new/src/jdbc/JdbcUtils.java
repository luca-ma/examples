package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {

	public static enum DB_TYPE {
		POSTGRESQL,
		MYSQL,
		ORACLE
	};

	public static Connection getDbConnection(DB_TYPE dbtype, String db_url,
			String user, String passwd) throws ClassNotFoundException,
			SQLException {

		// 1) LOAD JDBC correct driver
		switch (dbtype) {

		case POSTGRESQL:
			Class.forName("org.postgresql.Driver");
			break;
		default:
			System.out.println("usupported DB:" + dbtype);
			return null;
		}

		// 2) Open a JDBC connection
		System.out.println("Connecting to database...");
		Connection conn = DriverManager.getConnection(db_url, user, passwd);
		System.out.println("OK connected to database...");
		return conn;
	}

}
