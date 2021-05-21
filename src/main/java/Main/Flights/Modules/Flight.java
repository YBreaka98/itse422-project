package Main.Flights.Modules;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class Flight implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String airlineCode;
	private int flightNumber;
	private String departureLocation;
	private Date departureDayOfTheWeek;
	private String arrivalLocation;
	private Date arrivalDayOfTheWeek;
	private double businessCost;
	private double economyCost;
	private int businessSeats;
	private int economySeats;
	private String status;
	private Timestamp createdAt;
	private Timestamp updatedAt;

	public Flight(int id, String airlineCode, int flightNumber, String departureLocation, Date departureDayOfTheWeek,
			String arrivalLocation, Date arrivalDayOfTheWeek, double businessCost, double economyCost,
			int businessSeats, int economySeats, String status, Timestamp createdAt, Timestamp updatedAt) {
		this.id = id;
		this.airlineCode = airlineCode;
		this.flightNumber = flightNumber;
		this.departureLocation = departureLocation;
		this.departureDayOfTheWeek = departureDayOfTheWeek;
		this.arrivalLocation = arrivalLocation;
		this.arrivalDayOfTheWeek = arrivalDayOfTheWeek;
		this.businessCost = businessCost;
		this.economyCost = economyCost;
		this.businessSeats = businessSeats;
		this.economySeats = economySeats;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public static Flight fromDB(ResultSet r) throws SQLException {
		return new Flight(r.getInt("id"), r.getString("airline_code"), r.getInt("flight_number"),
				r.getString("departure_location"), r.getDate("departure_day_of_the_week"),
				r.getString("arrival_location"), r.getDate("arrival_day_of_the_week"), r.getDouble("business_cost"),
				r.getDouble("economy_cost"), r.getInt("business_seats"), r.getInt("economy_seats"),
				r.getString("status"), r.getTimestamp("created_at"), r.getTimestamp("updated_at"));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAirlineCode() {
		return airlineCode;
	}

	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getDepartureLocation() {
		return departureLocation;
	}

	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}

	public Date getDepartureDayOfTheWeek() {
		return departureDayOfTheWeek;
	}

	public void setDepartureDayOfTheWeek(Date departureDayOfTheWeek) {
		this.departureDayOfTheWeek = departureDayOfTheWeek;
	}

	public String getArrivalLocation() {
		return arrivalLocation;
	}

	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}

	public Date getArrivalDayOfTheWeek() {
		return arrivalDayOfTheWeek;
	}

	public void setArrivalDayOfTheWeek(Date arrivalDayOfTheWeek) {
		this.arrivalDayOfTheWeek = arrivalDayOfTheWeek;
	}

	public double getBusinessCost() {
		return businessCost;
	}

	public void setBusinessCost(double businessCost) {
		this.businessCost = businessCost;
	}

	public double getEconomyCost() {
		return economyCost;
	}

	public void setEconomyCost(double economyCost) {
		this.economyCost = economyCost;
	}

	public int getBusinessSeats() {
		return businessSeats;
	}

	public void setBusinessSeats(int businessSeats) {
		this.businessSeats = businessSeats;
	}

	public int getEconomySeats() {
		return economySeats;
	}

	public void setEconomySeats(int economySeats) {
		this.economySeats = economySeats;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
