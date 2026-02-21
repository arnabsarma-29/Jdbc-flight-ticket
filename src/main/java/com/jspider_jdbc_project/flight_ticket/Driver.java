package com.jspider_jdbc_project.flight_ticket;
import java.time.LocalTime;
import java.util.Scanner;
import com.jspider_jdbc_project.flight_ticket.dao.Dao;
import com.jspider_jdbc_project.flight_ticket.model.Flight;
import com.jspider_jdbc_project.flight_ticket.model.Passenger;
import com.jspider_jdbc_project.flight_ticket.model.Payment;
public class Driver
{
	public static void main (String [] args)
	{
		Scanner scn = new Scanner (System.in);
		boolean flag = true;
		while (flag)
		{
			System.out.println ("1. Passenger");
			System.out.println ("2. Flight");
			System.out.println ("3. Payment");
			System.out.println ("4. Ticket");
			System.out.println ("0. Exit");
			System.out.print ("Input: ");
			int in = scn.nextInt ();
			switch (in)
			{
				case 0:
					flag = false;
					System.out.println ("Program Terminated");
					break;
				case 1:
					System.out.println ("Enter Passenger Details :-");
					System.out.print ("Id: ");
					int id = scn.nextInt ();
					scn.nextLine ();
					System.out.print ("Name: ");
					String name = scn.nextLine ();
					System.out.print ("Age: ");
					int age = scn.nextInt ();
					scn.nextLine ();
					System.out.print ("From: ");
					String from = scn.nextLine ();
					System.out.print ("Destination: ");
					String destination = scn.nextLine ();
					Passenger passenger = new Passenger (id, name, age, destination, from);
					Dao.addPassengerDetails (passenger);
					break;
				case 2:
					System.out.println ("Enter Flight Details :-");
					System.out.print ("Id: ");
					id = scn.nextInt ();
					scn.nextLine ();
					System.out.print ("Name: ");
					name = scn.nextLine ();
					System.out.print ("Destination: ");
					destination = scn.nextLine ();
					System.out.print ("From: ");
					from = scn.nextLine ();
					System.out.print ("Departure Time (HH:mm): ");
					LocalTime depTime = LocalTime.parse (scn.nextLine ());
					System.out.print ("Arrival Time (HH:mm): ");
					LocalTime arrTime = LocalTime.parse (scn.nextLine ());
					Flight flight = new Flight (id, name, destination, from, depTime, arrTime);
					Dao.addFlightDetails (flight);
					break;
				case 3:
					System.out.println ("Enter Payment Details :-");
					System.out.print ("Id: ");
					id = scn.nextInt ();
					scn.nextLine ();
					System.out.print ("Name: ");
					name = scn.nextLine ();
					System.out.print ("Amount: ");
					int amount = scn.nextInt ();
					scn.nextLine ();
					Payment payment = new Payment (id, name, amount);
					Dao.addPaymentDetails (payment);
					break;
				case 4:
					System.out.print (Dao.isTicket ());
					break;
				default:
					System.out.println ("Invalid Choice");
			}
		}
		scn.close ();
	}
}