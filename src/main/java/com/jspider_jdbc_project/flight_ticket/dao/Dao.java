package com.jspider_jdbc_project.flight_ticket.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import com.jspider_jdbc_project.flight_ticket.database.Db_Connection;
import com.jspider_jdbc_project.flight_ticket.model.Flight;
import com.jspider_jdbc_project.flight_ticket.model.Passenger;
import com.jspider_jdbc_project.flight_ticket.model.Payment;
public class Dao
{
	private static Connection con;
	private static Savepoint passengerSP;
	private static boolean paymentStatus = false;
	static
	{
		try
		{
			con = Db_Connection.getConnection ();
			con.setAutoCommit (false);
			System.out.println ("Connection established !");
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace ();
		}
	}
	public static void addPassengerDetails (Passenger passenger)
	{
		String sql = "insert into passenger values (?, ?, ?, ?, ?)";
		try (PreparedStatement ps = con.prepareStatement(sql))
		{
			ps.setInt (1, passenger.getId ());
			ps.setString (2, passenger.getName ());
			ps.setInt (3, passenger.getAge ());
			ps.setString (4, passenger.getFrom ());
			ps.setString (5, passenger.getDestination ());
			ps.executeUpdate ();
			passengerSP = con.setSavepoint ();
			System.out.println ("Passenger Inserted");
		}
		catch (SQLException e)
		{
			e.printStackTrace ();
		}
	}
	public static void addFlightDetails (Flight flight)
	{
		String sql = "insert into flight values (?, ?, ?, ?, ?, ?)";
		try (PreparedStatement ps = con.prepareStatement (sql))
		{
			ps.setInt (1, flight.getId ());
			ps.setString (2, flight.getName ());
			ps.setString (3, flight.getDestination ());
			ps.setString (4, flight.getFrom ());
			ps.setObject (5, flight.getDepartureTime ());
			ps.setObject (6, flight.getArrivalTime ());
			ps.executeUpdate ();
			System.out.println ("Flight inserted");
		}
		catch (SQLException e)
		{
			e.printStackTrace ();
		}
	}
	public static void addPaymentDetails (Payment payment)
	{
		String sql = "insert into payment values (?, ?, ?)";
		try (PreparedStatement ps = con.prepareStatement (sql))
		{
			ps.setInt (1, payment.getId ());
			ps.setString (2, payment.getName ());
			ps.setInt (3, payment.getAmount ());
			ps.executeUpdate ();
			paymentStatus = true;
			System.out.println ("Payment inserted");
		}
		catch (SQLException e)
		{
			e.printStackTrace ();
		}
	}
	public static String isTicket ()
	{
		try
		{
			if (paymentStatus)
			{
				con.commit ();
				return "Ticket Is Generated";
			}
			else
			{
				con.rollback (passengerSP);
				con.commit ();
				return "Ticket Is Not Generated";
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace ();
			return "Transaction Failed";
		}
	}
}