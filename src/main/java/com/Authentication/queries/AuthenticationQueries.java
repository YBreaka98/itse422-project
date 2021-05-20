package com.Authentication.queries;

import java.sql.*;
import java.time.Instant;

import com.Authentication.moduls.User;
import com.Authentication.moduls.enums.UserType;

import global.CurrentUser;
import global.SqlConnection;

public class AuthenticationQueries {
	Connection con = SqlConnection.connect();

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

	public void addNewUser(String username, String password, UserType role) throws SQLException {
		String query = "INSERT INTO `users`(`username`, `password`, `role`, `created_at`, `updated_at`) VALUES (`?,?,?,?,?`)";
		PreparedStatement prepared = con.prepareStatement(query);
		prepared.setString(1, username);
		prepared.setString(2, password);
		prepared.setString(3, role.toString());
		prepared.setTimestamp(4, Timestamp.from(Instant.now()));
		prepared.setTimestamp(5, Timestamp.from(Instant.now()));
		prepared.executeUpdate();
	}

}
