package com.example.entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class Rider {

    @Id
    @Indexed(unique=true)
    private String riderID; // Primary Key

	private String name;
    private String contactInformation;
    private String vehicleNumber;
    private String vehicleType;
    private int seatsAvailable;
    private String startingPoint;
    private String destination;
    private String date;
	private String startTime;
	private boolean airConditioner;
	private boolean music;

    public Rider() {
        // Default constructor
    }

    public Rider(String riderID, String name, String contactInformation, String vehicleNumber, String vehicleType,
			int seatsAvailable, String startingPoint, String destination, String date, String startTime,
			boolean airConditoner, boolean music) {
		super();
		this.riderID = riderID;
		this.name = name;
		this.contactInformation = contactInformation;
		this.vehicleNumber = vehicleNumber;
		this.vehicleType = vehicleType;
		this.seatsAvailable = seatsAvailable;
		this.startingPoint = startingPoint;
		this.destination = destination;
		this.date = date;
		this.startTime = startTime;
		this.airConditioner = airConditoner;
		this.music = music;
	}

    // Getters and setters

    public String getRiderID() {
        return riderID;
    }

    public void setRiderID(String riderID) {
        this.riderID = riderID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(String startingPoint) {
        this.startingPoint = startingPoint;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
    
    public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    
    public boolean isAirConditioner() {
		return airConditioner;
	}

	public void setAirConditioner(boolean airConditioner) {
		this.airConditioner = airConditioner;
	}

	public boolean isMusic() {
		return music;
	}

	public void setMusic(boolean music) {
		this.music = music;
	}
}
