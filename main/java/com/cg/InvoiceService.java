package com.cg;

public class InvoiceService {

	private static final int COST_PER_TIME = 1;
	private static final double MINIMUM_COST_PER_KILOMETRE = 10;
	private static final double MINIMUM_FARE = 5;
	private RideRepository rideRepository;

	public void setRideRepository(RideRepository rideRepository) {
		this.rideRepository = rideRepository;
	}
	
	public double calculateFare(double distance, int time) {
		double totalFare = distance * MINIMUM_COST_PER_KILOMETRE + time * COST_PER_TIME;
		return Math.max(totalFare, MINIMUM_FARE);
	}

	public InvoiceSummary calculateFare(Ride[] rides) {
		double totalFare = 0;
		for (Ride ride : rides)
			totalFare += ride.cabRide.calcCostOfCabRide(ride);
		return new InvoiceSummary(rides.length, totalFare);
	}

	public void addRides(String userId, Ride[] rides) {
	    rideRepository.addRides(userId, rides);
	}

	public InvoiceSummary getInvoiceSummary(String userId) {
		return this.calculateFare(rideRepository.getRides(userId));
	}

	public double calculateFare(String userId, Ride[] rides) {
		return 0;
	}
}
