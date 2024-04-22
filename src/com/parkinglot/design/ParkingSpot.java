package com.parkinglot.design;

public class ParkingSpot {
	
	private Vehicle vehicle;
	private ParkingSpotType parkingSpotType;
	private Boolean free;
	
	
	ParkingSpot(ParkingSpotType parkingSpotType){
		this.parkingSpotType = parkingSpotType;
	}
	
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public ParkingSpotType getParkingSpotType() {
		return parkingSpotType;
	}
	public void setParkingSpotType(ParkingSpotType parkingSpotType) {
		this.parkingSpotType = parkingSpotType;
	}

	public Boolean getFree() {
		return free;
	}

	public void setFree(Boolean free) {
		this.free = free;
	}
	
	
	
	

}
