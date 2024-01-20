package com.example.entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class Passenger {

    @Id
    @Indexed(unique=true)
    private String passengerID; // Primary Key

	private String name;
    private String phoneNo;
    private String pickupLocation;
    private String dropoffLocation;
    private String date;
	private String pickupTime;
	private boolean airConditoner;
	private boolean music;

    public Passenger() {
        // Default constructor
    }

    public Passenger(String passengerID, String name, String phoneNo, String pickupLocation, String dropoffLocation,
			String date, String pickupTime, boolean airConditoner, boolean music) {
		super();
		this.passengerID = passengerID;
		this.name = name;
		this.phoneNo = phoneNo;
		this.pickupLocation = pickupLocation;
		this.dropoffLocation = dropoffLocation;
		this.date = date;
		this.pickupTime = pickupTime;
		this.airConditoner = airConditoner;
		this.music = music;
	}


    // Getters and setters

    public String getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(String passengerID) {
        this.passengerID = passengerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDropoffLocation() {
        return dropoffLocation;
    }

    public void setDropoffLocation(String dropoffLocation) {
        this.dropoffLocation = dropoffLocation;
    }
    public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
    public String getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(String pickupTime) {
        this.pickupTime = pickupTime;
    }
    
    public boolean isAirConditoner() {
		return airConditoner;
	}

	public void setAirConditoner(boolean airConditoner) {
		this.airConditoner = airConditoner;
	}
	
	public boolean isMusic() {
		return music;
	}

	public void setMusic(boolean music) {
		this.music = music;
	}

}
