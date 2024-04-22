package com.parkinglot.design;

public class MainClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ParkingLot parking = new ParkingLot(2, 2, 2);
		
		
		Vehicle truck = new Vehicle(VehicleType.TRUCK);
		
		parking.park(truck);
		parking.unpark(truck);
	}

}
