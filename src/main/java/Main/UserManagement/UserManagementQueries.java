package Main.UserManagement;

import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import Authentication.moduls.User;
import Authentication.moduls.enums.UserType;

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

	public void addNewUser(User u) throws SQLException {
		String query = "INSERT INTO `users`(`username`, `password`, `role`, `created_at`, `updated_at`) VALUES (`?,?,?,?,?`)";
		PreparedStatement prepared = con.prepareStatement(query);
		prepared.setString(1, u.getUserName());
		prepared.setString(2, u.getPassword());
		prepared.setString(3, u.getRole().toString());
		prepared.setTimestamp(4, Timestamp.from(Instant.now()));
		prepared.setTimestamp(5, Timestamp.from(Instant.now()));
		prepared.executeUpdate();
	}

	public void updateUser(User u) throws SQLException {
		String query = "UPDATE `users` SET `username`='?',`password`='?',`role`='?',`updated_at`='?' WHERE `id`='?'";
		PreparedStatement prepared = con.prepareStatement(query);
		prepared.setString(1, u.getUserName());
		prepared.setString(2, u.getPassword());
		prepared.setString(3, u.getRole().toString());
		prepared.setTimestamp(4, Timestamp.from(Instant.now()));
		prepared.setInt(5, u.getId());
		prepared.executeUpdate();
	}

	public void deleteUser(int id) throws SQLException {
		String query = "DELETE FROM `users` WHERE `id`='?'";
		PreparedStatement prepared = con.prepareStatement(query);
		prepared.setInt(1, id);
		prepared.executeUpdate();
	}

}
