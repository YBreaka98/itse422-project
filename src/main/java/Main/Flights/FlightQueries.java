package Main.Flights;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import Main.Flights.Modules.*;
import global.SqlConnection;

public class FlightQueries {
	Connection con = null;

	public FlightQueries() {
		con = SqlConnection.connect();
	}

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

	public void addNewFlight(Flight f) throws SQLException {
		PreparedStatement prepared = con.prepareStatement(
				"INSERT INTO `flight`(`airline_code`, `flight_number`, `departure_location`, `departure_day_of_the_week`,"
						+ " `arrival_location`, `arrival_day_of_the_week`, `business_cost`, `economy_cost`, `business_seats`, `economy_seats`, "
						+ "`status`, `created_at`, `updated_at`) VALUES ('?,?,?,?,?,?,?,?,?,?,?,?,?')");
		prepared.setString(1, f.getAirlineCode());
		prepared.setInt(2, f.getFlightNumber());
		prepared.setString(3, f.getDepartureLocation());
		prepared.setDate(4, (Date) f.getDepartureDayOfTheWeek());
		prepared.setString(5, f.getArrivalLocation());
		prepared.setDate(6, (Date) f.getArrivalDayOfTheWeek());
		prepared.setDouble(7, f.getBusinessCost());
		prepared.setDouble(8, f.getEconomyCost());
		prepared.setInt(9, f.getBusinessSeats());
		prepared.setInt(10, f.getEconomySeats());
		prepared.setString(11, f.getStatus());
		prepared.setTimestamp(12, Timestamp.from(Instant.now()));
		prepared.setTimestamp(13, Timestamp.from(Instant.now()));
		prepared.executeUpdate();
		System.out.println("flight added");
	}

	public void updateFlight(Flight f) throws SQLException {
		PreparedStatement prepared = con
				.prepareStatement("UPDATE `flight` SET `airline_code`='?',`flight_number`='?',`departure_location`='?',"
						+ "`departure_day_of_the_week`='?',`arrival_location`='?',`arrival_day_of_the_week`='?',`business_cost`='?',`economy_cost`='?',"
						+ "`business_seats`='?',`economy_seats`='?',`status`='?',`updated_at`='?' WHERE id='?'");
		prepared.setString(1, f.getAirlineCode());
		prepared.setInt(2, f.getFlightNumber());
		prepared.setString(3, f.getDepartureLocation());
		prepared.setDate(4, (Date) f.getDepartureDayOfTheWeek());
		prepared.setString(5, f.getArrivalLocation());
		prepared.setDate(6, (Date) f.getArrivalDayOfTheWeek());
		prepared.setDouble(7, f.getBusinessCost());
		prepared.setDouble(8, f.getEconomyCost());
		prepared.setInt(9, f.getBusinessSeats());
		prepared.setInt(10, f.getEconomySeats());
		prepared.setString(11, f.getStatus());
		prepared.setTimestamp(12, Timestamp.from(Instant.now()));
		prepared.setInt(14, f.getId());
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
