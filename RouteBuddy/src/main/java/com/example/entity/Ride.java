package com.example.entity;

import org.springframework.data.annotation.Id;

public class Ride {

    @Id
    private String rideID; // Primary Key
    
    private String riderName; // Foreign Key referencing Rider Table
    private String passengerName; // Foreign Key referencing Passenger Table
    private String ridercontact;
    private String passengercontact;
    private String date;
    private String time;
    private String startingLocation;
    private String destination;
    private String started;


	public Ride() {
        // Default constructor
    }


	public Ride(String rideID, String riderName, String passengerName, String ridercontact, String passengercontact,
			String date, String time, String startingLocation, String destination, String started) {
		super();
		this.rideID = rideID;
		this.riderName = riderName;
		this.passengerName = passengerName;
		this.ridercontact = ridercontact;
		this.passengercontact = passengercontact;
		this.date = date;
		this.time = time;
		this.startingLocation = startingLocation;
		this.destination = destination;
		this.started=started;
	}
    

    public String getRideID() {
		return rideID;
	}

	public void setRideID(String rideID) {
		this.rideID = rideID;
	}

	public String getRiderName() {
		return riderName;
	}

	public void setRiderName(String riderName) {
		this.riderName = riderName;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getRidercontact() {
		return ridercontact;
	}

	public void setRidercontact(String ridercontact) {
		this.ridercontact = ridercontact;
	}

	public String getPassengercontact() {
		return passengercontact;
	}

	public void setPassengercontact(String passengercontact) {
		this.passengercontact = passengercontact;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getStartingLocation() {
		return startingLocation;
	}

	public void setStartingLocation(String startingLocation) {
		this.startingLocation = startingLocation;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getStarted() {
		return started;
	}


	public void setStarted(String started) {
		this.started = started;
	}
}
