package i160195_AP_Assignment2;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
import i160195_AP_Assignment2.Customer; 


public class Main {

	//private Customer customerDetails= new Customer();
	//private Flight[] FlightList;
	
	public static void main(String []args)
	{
		//Customer customerDetai;
		Customer customerDetails= new Customer();
		String []airLines= {"British Airways","Panam Airways","Etihad","Fly Emirates","PIA","Air Blue","Fly Canada"};
		boolean []directOrNot= {true,false};
		Flight []flightList=new Flight[30];
		Flight []flightsAvailable=new Flight[20];
		Flight flightSelected= new Flight();
		Available selectedAvailable= new Available();
		int []datesYear= {2021,2022,2023};
		String []locations= {"Islamabad","New York","Bangok","Abu Dhabi","Paris","Dublin","Moscow","London","Lahore","Chicago","Kuala Lumpur","Riyadh","Jeddah","Dubai","Muscat","Kuwait","Doha","Brasilia","Rome","Prague","Istanbul","Vienna","Budapest","Athens","Berlin","Tokyo","Madrid","Amsterdam","Cape town","Cairo","Alexandria","Khartoum","Tripoli","Tunis","Hong Kong","Sydney","Seoul"};
		
		//total locations and 2 corresponding random numbers to choose destination and origin for list of flights
		System.out.println("Number of total locations we have : "+locations.length+"\n");
		for(int i=0;i<flightList.length;i++)
		{
			//generating pair of random numbers to choose a pair of origin and destination to fill flights
			int randomNumOrigin = ThreadLocalRandom.current().nextInt(0, locations.length);
			int randomNumDest = ThreadLocalRandom.current().nextInt(0, locations.length);
			int randomNumAirlines= ThreadLocalRandom.current().nextInt(0,airLines.length);
			int randomNumDirect= ThreadLocalRandom.current().nextInt(0,directOrNot.length);
			int randomSeatNum= ThreadLocalRandom.current().nextInt(1,51);
			int randomYear= ThreadLocalRandom.current().nextInt(1,datesYear.length);
			int randomMonth= ThreadLocalRandom.current().nextInt(1,13);
			int randomDay=ThreadLocalRandom.current().nextInt(1,29);
			//float randomFare=ThreadLocalRandom.current().nextFloat(1100.5,8900.5);
			Random r = new Random();
			float randomFare=1000 + r.nextFloat() * (10000 - 1000);
			//MyDate tempObj= new MyDate(datesYear[randomYear],randomMonth,randomDay);
			MyDate tempObj=new MyDate();
			tempObj.setDay(randomDay);
			tempObj.setMonth(randomMonth);
			tempObj.setYear(datesYear[randomYear]);
			while(randomNumOrigin==randomNumDest)
			{
				randomNumDest = ThreadLocalRandom.current().nextInt(0, locations.length);
			}
			if(directOrNot[randomNumDirect]==true)
			{
				flightList[i] = new Flight(locations[randomNumDest],locations[randomNumOrigin],directOrNot[randomNumDirect],"\0",tempObj, randomFare, randomSeatNum, airLines[randomNumAirlines]);
			}
			else if(directOrNot[randomNumDirect]==false)
			{
				int randomNumVia = ThreadLocalRandom.current().nextInt(0, locations.length);
				flightList[i]=new Flight(locations[randomNumDest],locations[randomNumOrigin],directOrNot[randomNumDirect],locations[randomNumVia],tempObj,randomFare,randomSeatNum,airLines[randomNumAirlines]);
			}
			
		}
		
		System.out.println("********Flights available********\n");
		for(int i=0;i<flightList.length;i++)
		{
			flightList[i].DisplayFlightDetails();
			System.out.println("-----____________-----\n");
		}
		
		/*for(int i=0;i<locations.length;i++)
		{
			System.out.println(locations[i]+"\n");
		}*/
		while (true)
		{
			System.out.println("***** Flight Reservation System *****\n");
			System.out.println("To proceed to flight search and bookings please enter your details\n");
			System.out.println("Press 'Y' to proceed\nPress 'C' to exit");
			
			boolean yesOrNo=false;
			while(true)
			{
				Scanner scMain = new Scanner(System.in);
				char c = scMain.next().charAt(0);
				
				if(c == 'y' || c=='Y')
				{
					yesOrNo=true;
					break;
				}
				else if (c=='c' || c=='C')
				{
					yesOrNo=false;
					break;
				}
				else
				{
					System.out.print("Invalid input! Please try again\n");
				}
			}
			if(yesOrNo==false)
			{
				break;
			}
			else if (yesOrNo==true)
			{
				customerDetails.InputCustomerDetails();
				System.out.println("**** Customer Details ****\n");
				customerDetails.DisplayCustomerDetails();
				int availableFlightCount=0;
				System.out.println("Searching flights according to your preference....\n");
				for(int i=0, j=0;i<flightList.length;i++)
				{
					if(flightList[i].GetFlightDate()==customerDetails.GetFlightDate())
					{
						if(flightList[i].GetDest()==customerDetails.GetDest() && flightList[i].GetOrigin()==customerDetails.GetOrigin())
						{
							flightsAvailable[j]=flightList[i];
							j++;
							availableFlightCount++;
						}
						/*else
						{
							String ori=customerDetails.GetOrigin();
							String dest=customerDetails.GetDest();
							System.out.println("Sorry! No flights from "+ori+" to "+dest+" on this day.");
						}*/
					}
					/*else
					{
						System.out.println("Sorry! No flights available on your required date.");
					}*/
					
				}
				System.out.println("Available flights on your required date :\n");
				float lowest=10000000;
				int lowestFareIndex=0;
				for(int i=0;i<availableFlightCount;i++)
				{
					if(flightsAvailable[i].GetFare()<lowest)
					{
						lowest=flightsAvailable[i].GetFare();
						lowestFareIndex+=i;
					}
					System.out.println("-----"+(i+1)+"-----");
					flightsAvailable[i].DisplayFlightDetails();
				}
				selectedAvailable.setLowestFare(lowest);
				selectedAvailable.setDirectFlight(flightsAvailable[lowestFareIndex].GetDirectF());
				selectedAvailable.setFlightDate(flightsAvailable[lowestFareIndex].GetFlightDate());
				selectedAvailable.setSeatNum(flightsAvailable[lowestFareIndex].GetSeatNum());
				System.out.print("Please select one of the flights available\nPress number corresponding to flight to proceed\nPress 0 to exit\n");
				Scanner scCor=new Scanner(System.in);
				int dec= scCor.nextInt();
				while(dec<0 || dec >availableFlightCount)
				{
					System.out.println("Invalid input! Please try again");
				}
				System.out.println("Congratulations! The details of your flight will be displayed below");
				flightsAvailable[dec-1].DisplayFlightDetails();
				
				System.out.println("Wishing you safe travels! \nTo proceed to further bookings press Y\nTo exit press C");
				Scanner finalSC= new Scanner(System.in);
				char selector= finalSC.next().charAt(0);
				if(selector=='c' || selector=='C')
					break;
				while(selector!='y' || selector!='Y')
				{
					System.out.println("Invalid input! Please try again.");
				}
				
			}
		}
		
	}
}
