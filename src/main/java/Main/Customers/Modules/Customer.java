package Main.Customers.Modules;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

public class Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String address;
	private String email;
	private int cardNumber;
	private Timestamp createdAt;
	private Timestamp updatedAt;

	public Customer(int id, String name, String address, String email, int cardNumber, Timestamp createdAt,
			Timestamp updatedAt) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.cardNumber = cardNumber;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	// used to make an object from the UI in the fromUI function
	public Customer(String name, String address, String email, int cardNumber) {
		this.name = name;
		this.address = address;
		this.email = email;
		this.cardNumber = cardNumber;
	}

	public static Customer fromDB(ResultSet r) throws SQLException {
		return new Customer(r.getInt("id"), r.getString("name"), r.getString("address"), r.getString("email"),
				r.getInt("credit_card"), r.getTimestamp("created_at"), r.getTimestamp("updated_at"));
	}

	public static Customer fromUI(HttpServletRequest request) {
		return new Customer((String) request.getAttribute("name"), (String) request.getAttribute("address"),
				(String) request.getAttribute("email"), Integer.valueOf((String) request.getAttribute("credit_card")));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
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

}
