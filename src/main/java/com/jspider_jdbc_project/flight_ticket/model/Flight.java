package com.jspider_jdbc_project.flight_ticket.model;
import java.time.LocalTime;
public class Flight
{
	private int id;
	private String name;
	private String destination;
	private String from;
	private LocalTime departureTime;
	private LocalTime arrivalTime;
	public Flight (int id, String name, String destination, String from, LocalTime departureTime, LocalTime arrivalTime)
	{
		this.id = id;
		this.name = name;
		this.destination = destination;
		this.from = from;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}
	public int getId ()
	{
		return id;
	}
	public void setId (int id)
	{
		this.id = id;
	}
	public String getName ()
	{
		return name;
	}
	public void setName (String name)
	{
		this.name = name;
	}
	public String getDestination ()
	{
		return destination;
	}
	public void setDestination (String destination)
	{
		this.destination = destination;
	}
	public String getFrom ()
	{
		return from;
	}
	public void setFrom (String from)
	{
		this.from = from;
	}
	public LocalTime getDepartureTime ()
	{
		return departureTime;
	}
	public void setDepartureTime (LocalTime departureTime)
	{
		this.departureTime = departureTime;
	}
	public LocalTime getArrivalTime ()
	{
		return arrivalTime;
	}
	public void setArrivalTime (LocalTime arrivalTime)
	{
		this.arrivalTime = arrivalTime;
	}
}