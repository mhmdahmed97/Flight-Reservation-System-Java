package i160195_AP_Assignment2;

import i160195_AP_Assignment2.Customer;
import i160195_AP_Assignment2.MyDate;

public class Available  {
	
	private float lowestFare;
	private boolean directFlight;
	private MyDate flightDate;
	private int seatNum;
	
	public Available() 
	{
		lowestFare=0;
		directFlight=false;
		flightDate=new MyDate();
		seatNum=0;
	}
	
	public Available(float lstFare,boolean dFlight, MyDate fDate, int sNum)
	{
		lowestFare=lstFare;
		directFlight=dFlight;
		flightDate=fDate;
		seatNum=sNum;
	}
	
	//setters 
	public void setLowestFare(float lFare)
	{
		lowestFare=lFare;
	}
	public void setDirectFlight(boolean dFlight) 
	{
		directFlight=dFlight;
	}
	public void setFlightDate(MyDate fDate)
	{
		flightDate.setDate(fDate);
	}
	public void setSeatNum(int sNum)
	{
		seatNum=sNum;
	}
	
	//getters
	public float getLowestFare() {
		return lowestFare;
	}
	public boolean getDirectFlight()
	{
		return directFlight;
	}
	public MyDate getFlightDate()
	{
		return flightDate;
	}
	public int getSeatNum()
	{
		return seatNum;
	}
	
	public void DisplayAvailableFlights() 
	{
		System.out.println("*** Details of available flight ***\n");
		System.out.println("Lowest fare : "+lowestFare+"\n");
		System.out.println("Date : ");
		flightDate.DisplayDate();
		System.out.println("\n");
		System.out.println();
		if(directFlight==true)
			System.out.println("Direct flight : Yes\n");
		else
			System.out.println("Direct flight : No\n");
		System.out.println("Seat Number : "+seatNum+"\n");
	}
	
}
