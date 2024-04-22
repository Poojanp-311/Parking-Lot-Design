package com.parkinglot.design;
import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
	
	List<CompactSpot> compactList = new ArrayList<>();
	List<LargeSpot> largeList = new ArrayList<>();
	List<BikeSpot> bikeList = new ArrayList<>();
	
	
	int freeCompactSpace;
	int freeLargeSpace;
	int freeBikeSpace;
	
	public ParkingLot(int freeCompactSpace, int freeLargeSpace, int freeBikeSpace) {
		this.freeCompactSpace = freeCompactSpace;
		this.freeLargeSpace = freeLargeSpace;
		this.freeBikeSpace = freeBikeSpace;
	}
	
	public void park(Vehicle vehicle) {
		
		System.out.println("we are about to park our vehicle " + vehicle.getVehicleType());
		
		if(vehicle.getVehicleType().equals(VehicleType.TRUCK)) {
			if(freeLargeSpace>0) {
				parkeLargeVehicle(vehicle);
			}else {
				System.out.println("Sorry the large space is not empty");
			}
		}else if(vehicle.getVehicleType().equals(VehicleType.CAR)) {
			if(freeCompactSpace>0) {
				parkeCompactVehicle(vehicle);
			}else if(freeLargeSpace>0) {
				parkeLargeVehicle(vehicle);
			}
			else {
				System.out.println("Sorry the compact space is not empty");
			}
		}else if(vehicle.getVehicleType().equals(VehicleType.BIKE)) {
			if(freeBikeSpace>0) {
				parkeBikeVehicle(vehicle);
			}else if(freeCompactSpace>0) {
				parkeCompactVehicle(vehicle);
			}else if(freeLargeSpace>0) {
				parkeLargeVehicle(vehicle);
			}
			else {
				System.out.println("Sorry the bike space is not empty");
			}
		}
	}
	
	public void parkeLargeVehicle(Vehicle vehicle) {
		LargeSpot large = new LargeSpot(ParkingSpotType.LARGE);
		large.setFree(false);
		large.setVehicle(vehicle);
		vehicle.setParkingSpot(large);
		
		largeList.add(large);
		System.out.println("successfully parke large vehicle " + vehicle.getVehicleType());
		freeLargeSpace--;
	}
	
	public void parkeCompactVehicle(Vehicle vehicle) {
		CompactSpot compact = new CompactSpot(ParkingSpotType.COMPACT);
		compact.setFree(false);
		compact.setVehicle(vehicle);
		vehicle.setParkingSpot(compact);
		
		compactList.add(compact);
		System.out.println("successfully parke compact vehicle " + vehicle.getVehicleType());
		freeCompactSpace--;
	}
	
	public void parkeBikeVehicle(Vehicle vehicle) {
		BikeSpot bike = new BikeSpot(ParkingSpotType.BIKE);
		bike.setFree(false);
		bike.setVehicle(vehicle);
		vehicle.setParkingSpot(bike);
		
		bikeList.add(bike);
		System.out.println("successfully parke bike vehicle " + vehicle.getVehicleType());
		freeBikeSpace--;
		
	}
	
	
	public void unpark(Vehicle vehicle) {
		
		System.out.println("we are about to unpark our vehicle");
		ParkingSpot parkingSpot = vehicle.getParkingSpot();
		parkingSpot.setFree(true);
		
		if(vehicle.getVehicleType().equals(VehicleType.TRUCK)) {
			if(largeList.remove(parkingSpot)) {
				freeLargeSpace++;
				System.out.println("Vehicle removed succesfully");
			}else {
				System.out.println("No vehicle is present in this spot");
			}
			
		}else if(vehicle.getVehicleType().equals(VehicleType.CAR)) {
			if(compactList.remove(parkingSpot)) {
				freeCompactSpace++;
				System.out.println("Vehicle removed succesfully");
			}else {
				System.out.println("No vehicle is present in this spot");
			}
			
		}else if(vehicle.getVehicleType().equals(VehicleType.BIKE)) {
			if(bikeList.remove(parkingSpot)) {
				freeBikeSpace++;
				System.out.println("Vehicle removed succesfully");
			}else {
				System.out.println("No vehicle is present in this spot");
			}
			
		}
				
		
	}
	
	

}
