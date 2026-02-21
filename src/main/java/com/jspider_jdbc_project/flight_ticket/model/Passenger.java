package com.jspider_jdbc_project.flight_ticket.model;
public class Passenger
{
	private int id;
	private String name;
	private int age;
	private String destination;
	private String from;
	public Passenger (int id, String name, int age, String destination, String from)
	{
		this.id = id;
		this.name = name;
		this.age = age;
		this.destination = destination;
		this.from = from;
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
	public int getAge ()
	{
		return age;
	}
	public void setAge (int age)
	{
		this.age = age;
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
}