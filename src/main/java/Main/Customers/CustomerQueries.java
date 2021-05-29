package Main.Customers;

import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import Main.Customers.Modules.Customer;
import global.SqlConnection;

public class CustomerQueries {
	Connection con = null;

	public CustomerQueries() {
		con = SqlConnection.connect();
	}

	public List<Customer> getCustomers() throws SQLException {
		List<Customer> customers = new ArrayList<>();
		ResultSet r = con.prepareStatement("select * from customers").executeQuery();
		while (r.next())
			customers.add(Customer.fromDB(r));
		return customers;
	}

	public Customer getCustomer(int id) throws SQLException {
		PreparedStatement prepared = con.prepareStatement("select * from customers where id='?'");
		prepared.setInt(1, id);
		ResultSet r = prepared.executeQuery();
		if (r.next())
			return Customer.fromDB(r);
		return null;
	}

	public void addNewCustomer(Customer c) throws SQLException {
		PreparedStatement prepared = con.prepareStatement(
				"INSERT INTO `customers`(`name`, `address`, `email`, `credit_card`, `created_at`, `updated_at`) VALUES ('?,?,?,?,?,?')");
		prepared.setString(1, c.getName());
		prepared.setString(2, c.getAddress());
		prepared.setString(3, c.getEmail());
		prepared.setInt(4, c.getCardNumber());
		prepared.setTimestamp(5, Timestamp.from(Instant.now()));
		prepared.setTimestamp(6, Timestamp.from(Instant.now()));
		prepared.executeUpdate();
		System.out.println("Customer added");
	}

	public void updateCustomer(Customer c) throws SQLException {
		PreparedStatement prepared = con.prepareStatement(
				"UPDATE `customers` SET `name`='?',`address`='?',`email`='?',`credit_card`='?',`updated_at`='?' WHERE id='?'");
		prepared.setString(1, c.getName());
		prepared.setString(2, c.getAddress());
		prepared.setString(3, c.getEmail());
		prepared.setInt(4, c.getCardNumber());
		prepared.setTimestamp(5, Timestamp.from(Instant.now()));
		prepared.setInt(6, c.getId());
		prepared.executeUpdate();
		System.out.println("Customer updated");
	}

	public void deleteCustomer(int id) throws SQLException {
		PreparedStatement prepared = con.prepareStatement("DELETE FROM `customers` WHERE id='?'");
		prepared.setInt(1, id);
		prepared.executeUpdate();
		System.out.println("Customer deleted");
	}
}
