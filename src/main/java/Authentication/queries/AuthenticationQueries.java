package Authentication.queries;

import java.sql.*;
import java.time.Instant;

import Authentication.moduls.User;
import Authentication.moduls.enums.UserType;

import global.CurrentUser;
import global.SqlConnection;

public class AuthenticationQueries {
	Connection con = null;

	public AuthenticationQueries() {
		con = SqlConnection.connect();
	}

	public boolean signIn(String username, String password) throws SQLException {
		PreparedStatement prepared = con.prepareStatement("select * from users where username=? and password=?");
		prepared.setString(1, username);
		prepared.setString(2, password);
		ResultSet r = prepared.executeQuery();
		if (r.next()) {
			CurrentUser.user = User.fromDB(r);
			return true;
		}
		return false;
	}

}
