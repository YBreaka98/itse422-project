package com.UserManagement;

import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.Authentication.moduls.User;
import com.Authentication.moduls.enums.UserType;

import global.SqlConnection;

public class UserManagementQueries {
	Connection con = SqlConnection.connect();

	public List<User> getUsers() throws SQLException {
		List<User> users = new ArrayList<>();
		ResultSet r = con.prepareStatement("select * from users").executeQuery();
		while (r.next()) {
			users.add(User.fromDB(r));
		}
		return users;
	}

	public User getUser(int id) throws SQLException {
		String query = "select * FROM `users` WHERE `id`='?'";
		PreparedStatement prepared = con.prepareStatement(query);
		prepared.setInt(1, id);
		ResultSet r = prepared.executeQuery();
		if (r.next())
			return User.fromDB(r);
		else
			return null;
	}

	public void updateUser(String username, String password, UserType role, int id) throws SQLException {
		String query = "UPDATE `users` SET `username`='?',`password`='?',`role`='?',`updated_at`='?' WHERE `id`='?'";
		PreparedStatement prepared = con.prepareStatement(query);
		prepared.setString(1, username);
		prepared.setString(2, password);
		prepared.setString(3, role.toString());
		prepared.setTimestamp(4, Timestamp.from(Instant.now()));
		prepared.setInt(5, id);
		prepared.executeUpdate();
	}

	public void deleteUser(int id) throws SQLException {
		String query = "DELETE FROM `users` WHERE `id`='?'";
		PreparedStatement prepared = con.prepareStatement(query);
		prepared.setInt(1, id);
		prepared.executeUpdate();
	}

}
