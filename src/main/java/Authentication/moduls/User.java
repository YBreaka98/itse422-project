package Authentication.moduls;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import Authentication.moduls.enums.UserType;
import java.io.Serializable;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String userName;
	private String password;
	private UserType role;
	private Timestamp createdAt;
	private Timestamp updatedAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getRole() {
		return role;
	}

	public void setRole(UserType role) {
		this.role = role;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User(int id, String userName, String password, UserType role, Timestamp createdAt, Timestamp updatedAt) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public static User fromDB(ResultSet r) throws SQLException {
		return new User(r.getInt("id"), r.getString("username"), r.getString("password"),
				UserType.valueOf(r.getString("role")), r.getTimestamp("created_at"), r.getTimestamp("updated_at"));
	}
}
