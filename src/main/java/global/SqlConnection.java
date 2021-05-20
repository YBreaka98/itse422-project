package global;

import java.sql.*;

public class SqlConnection {
	private SqlConnection() {
	}

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/itse422";
	private static final String USER = "root";
	private static final String PASS = "1";
	private static Connection conn = null;

	public static Connection connect() {
		if (conn != null)
			return conn;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			return conn;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}

	}
}
