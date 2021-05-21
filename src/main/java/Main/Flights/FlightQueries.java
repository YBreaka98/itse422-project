package Main.Flights;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import Main.Flights.Modules.*;
import global.SqlConnection;

public class FlightQueries {
	Connection con = SqlConnection.connect();

	public List<Flight> getFlights() throws SQLException {
		List<Flight> flights = new ArrayList<>();
		ResultSet r = con.prepareStatement("select * from flight").executeQuery();
		while (r.next())
			flights.add(Flight.fromDB(r));
		return flights;
	}

	public Flight getFlight(int id) throws SQLException {
		PreparedStatement prepared = con.prepareStatement("select * from flight where id='?'");
		prepared.setInt(1, id);
		ResultSet r = prepared.executeQuery();
		if (r.next())
			return Flight.fromDB(r);
		return null;
	}

	public void addNewFlight(String airlineCode, int flightNumber, String departureLocation, Date departureDayOfTheWeek,
			String arrivalLocation, Date arrivalDayOfTheWeel, double businessCost, double ecenomyCost,
			int businessSeats, int ecenomySeats, String status, Timestamp createdAt, Timestamp updatedAt)
			throws SQLException {
		PreparedStatement prepared = con.prepareStatement(
				"INSERT INTO `flight`(`airline_code`, `flight_number`, `departure_location`, `departure_day_of_the_week`,"
						+ " `arrival_location`, `arrival_day_of_the_week`, `business_cost`, `economy_cost`, `business_seats`, `economy_seats`, "
						+ "`status`, `created_at`, `updated_at`) VALUES ('?,?,?,?,?,?,?,?,?,?,?,?,?')");
		prepared.setString(1, airlineCode);
		prepared.setInt(2, flightNumber);
		prepared.setString(3, departureLocation);
		prepared.setDate(4, departureDayOfTheWeek);
		prepared.setString(5, arrivalLocation);
		prepared.setDate(6, arrivalDayOfTheWeel);
		prepared.setDouble(7, businessCost);
		prepared.setDouble(8, ecenomyCost);
		prepared.setInt(9, businessSeats);
		prepared.setInt(10, ecenomySeats);
		prepared.setString(11, status);
		prepared.setTimestamp(12, createdAt);
		prepared.setTimestamp(13, updatedAt);
		prepared.executeUpdate();
		System.out.println("flight added");
	}

	public void updateFlight(int id, String airlineCode, int flightNumber, String departureLocation,
			Date departureDayOfTheWeek, String arrivalLocation, Date arrivalDayOfTheWeel, double businessCost,
			double ecenomyCost, int businessSeats, int ecenomySeats, String status, Timestamp createdAt,
			Timestamp updatedAt) throws SQLException {
		PreparedStatement prepared = con
				.prepareStatement("UPDATE `flight` SET `airline_code`='?',`flight_number`='?',`departure_location`='?',"
						+ "`departure_day_of_the_week`='?',`arrival_location`='?',`arrival_day_of_the_week`='?',`business_cost`='?',`economy_cost`='?',"
						+ "`business_seats`='?',`economy_seats`='?',`status`='?',`created_at`='?',`updated_at`='?' WHERE id='?'");
		prepared.setString(1, airlineCode);
		prepared.setInt(2, flightNumber);
		prepared.setString(3, departureLocation);
		prepared.setDate(4, departureDayOfTheWeek);
		prepared.setString(5, arrivalLocation);
		prepared.setDate(6, arrivalDayOfTheWeel);
		prepared.setDouble(7, businessCost);
		prepared.setDouble(8, ecenomyCost);
		prepared.setInt(9, businessSeats);
		prepared.setInt(10, ecenomySeats);
		prepared.setString(11, status);
		prepared.setTimestamp(12, createdAt);
		prepared.setTimestamp(13, updatedAt);
		prepared.setInt(14, id);
		prepared.executeUpdate();
		System.out.println("flight updated");
	}

	public void deleteFlight(int id) throws SQLException {
		PreparedStatement prepared = con.prepareStatement("DELETE FROM `flight` WHERE id='?'");
		prepared.setInt(1, id);
		prepared.executeUpdate();
		System.out.println("flight deleted");
	}

}
