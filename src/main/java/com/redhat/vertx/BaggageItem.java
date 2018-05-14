package com.redhat.vertx;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BaggageItem {
	private String id, passengerId;
	private String weight, flightNumber, from, to, departureDateAndTime, airline;

					
	public BaggageItem(String id, String passengerId, String weight, String flightNumber, String from, String to, String departureDateAndTime,
			String airline) {
		super();
		this.id = id;
		this.passengerId = passengerId;
		this.weight = weight;
		this.flightNumber = flightNumber;
		this.from = from;
		this.to = to;
		this.departureDateAndTime = departureDateAndTime;
		this.airline = airline;
	}


	public String getId() {
		return id;
	}


	public String getWeight() {
		return weight;
	}


	public String getFlightNumber() {
		return flightNumber;
	}


	public String getFrom() {
		return from;
	}


	public String getTo() {
		return to;
	}


	public String getDepartureDateAndTime() {
		return departureDateAndTime;
	}


	public String getAirline() {
		return airline;
	}


	public String getPassengerId() {
		return passengerId;
	}



	
	
	
}
