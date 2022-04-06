package i160195_AP_Assignment2;

import i160195_AP_Assignment2.MyDate;

public class Flight {
	private String destination;
	private String origin;
	private boolean directFlight;
	private String via;
	private MyDate flightDate;
	private float fare;
	private int seatNum;
	private String airLine;
	
	//constructors
	//-->default constructor
	public Flight()
	{
		destination="\0";
		origin="\0";
		directFlight=false;
		via="\0";
		flightDate= new MyDate();
		fare=0;
		seatNum=0;
		airLine="\0";
	}
	//-->parameterized
	public Flight(String dest, String ori, boolean directF, String v, MyDate flDte, float fr, int seatN, String aLine)
	{
		destination=dest;
		origin=ori;
		directFlight=directF;
		via=v;
		flightDate= new MyDate();
		flightDate.setDay(flDte.getDay());
		flightDate.setMonth(flDte.getMonth());
		flightDate.setYear(flDte.getYear());
		fare=fr;
		seatNum=seatN;
		airLine=aLine;
	}
	
	//Getters&Setters
	//-->setters
	public void SetDest(String dest)
	{
		destination=dest;
	}
	public void SetOrigin(String ori)
	{
		origin=ori;
	}
	public void SetDirectF(boolean directF)
	{
		directFlight=directF;
	}
	public void SetVia(String v)
	{
		via=v;
	}
	public void SetFlightDate(MyDate flDte)
	{
		flightDate.setDate(flDte);
	}
	public void SetSeatNum(int seatN)
	{
		seatNum=seatN;
	}
	public void SetAirLine(String aLine)
	{
		this.airLine=aLine;
	}
	//-->getters
	public String GetDest()
	{
		return destination;
	}
	public String GetOrigin()
	{
		return origin;
	}
	public boolean GetDirectF()
	{
		return directFlight;
	}
	public String GetVia()
	{
		return via;
	}
	public MyDate GetFlightDate()
	{
		return flightDate;
	}
	public int GetSeatNum()
	{
		return seatNum;
	}
	public String GetAirLine()
	{
		return airLine;
	}
	public float GetFare()
	{
		return fare;
	}
	
	//FUNCTIONS
	public void DisplayFlightDetails()
	{
		System.out.println("From : "+origin+" --> To: "+destination+"              FARE: "+fare);
		if (directFlight==true)
			System.out.println("**DIRECT FLIGHT");
		else
			System.out.println("**VIA: "+via);
		System.out.print("Flight Date: ");
		flightDate.DisplayDate();
		
		System.out.println("Seat Number : "+seatNum);
		System.out.println("Airline : "+airLine);

	}
}

