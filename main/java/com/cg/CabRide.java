package com.cg;

public enum CabRide {
	NORMAL(10.0, 1.0, 5.0),PREMIUM(15.0, 2.0, 20.0);

	private double costPerKm;
	private double costPerMin;
	private double minFare;

	CabRide(double costPerKm, double costPerMin, double minFare) {
		this.costPerKm = costPerKm;
		this.costPerMin = costPerMin;
		this.minFare = minFare;
	}
	
	public double calcCostOfCabRide(Ride ride) {
		double rideCost = ride.distance*costPerKm + ride.time*costPerMin;
		return Math.max(minFare, rideCost);
	}
}
