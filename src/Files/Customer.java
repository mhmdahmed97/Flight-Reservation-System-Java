package i160195_AP_Assignment2;

import java.time.LocalDate;
import java.time.Year;
import java.time.Month;
import java.time.*;
import java.util.Scanner;

public class Customer {

	private String name;
	//private String address;
	private char gender;
	private int age;
	private Address houseAddr;
	private String passportNum;
	private String planeType;
	private String destination;
	private String origin;
	private MyDate flightDate;
	
	//constructors
	//-->default
	public Customer()
	{
		name="\0";
		gender='\0';
		age=0;
		houseAddr = new Address();
		passportNum="\0";
		planeType="\0";
		destination="\0";
		origin="\0";
		flightDate= new MyDate();
	}
	//-->parameterized
	public Customer(String nm, char gndr,int ag, Address addr, String passpNum,String plType,String dest, String ori, MyDate flDte)
	{
		name=nm;
		
		gender=gndr;
		
		age=ag;
		
		houseAddr.setCity(addr.getCity());
		houseAddr.setHouseNum(addr.getHouseNum());
		houseAddr.SetStrtNm(addr.GetStrtNm());
		
		passportNum=passpNum;
		
		planeType=plType;
		
		destination=dest;
		
		origin=ori;
		
		flightDate.setDay(flDte.getDay());
		flightDate.setMonth(flDte.getMonth());
		flightDate.setYear(flDte.getYear());
		
		
	}
	
	//Setter&Getters
	//-->Setters
	public void SetName(String nm)
	{
		this.name=nm;
	}
	public void setGender(char gndr)
	{
		this.gender = gndr;
	}
	public void setAge(int ag)
	{
		this.age=ag;
	}
	
	public void setHouseAddr(Address addr)
	{
		houseAddr.setCity(addr.getCity());
		houseAddr.setHouseNum(addr.getHouseNum());
		houseAddr.SetStrtNm(addr.GetStrtNm());
	}
	public void setHouseAddr(String ct, int hNum, int strtNum)
	{
		houseAddr.setCity(ct);
		houseAddr.setHouseNum(hNum);
		houseAddr.SetStrtNm(strtNum);
	}
	
	public void setPassportNum(String passpNum)
	{
		this.passportNum=passpNum;
	}
	public void setPlaneType(String plType)
	{
		this.planeType=plType;
	}
	public void setDest(String dest)
	{
		this.destination=dest;
	}
	public void setOrigin(String ori)
	{
		this.origin= ori;
	}
	
	public void setFlightDate(MyDate flDte)
	{
		flightDate.setDay(flDte.getDay());
		flightDate.setMonth(flDte.getMonth());
		flightDate.setYear(flDte.getYear());
	}
	public void setFlightDate(int d, int mon, int yr)
	{
		flightDate.setDay(d);
		flightDate.setMonth(mon);
		flightDate.setYear(yr);
	}
	 //-->>Getters
	public String GetName()
	{
		return this.name;
	}
	public char GetGender()
	{
		return this.gender;
	}
	public int GetAge()
	{
		return this.age;
	}
	
	public Address GetHouseAddr()
	{
		return houseAddr;
	}
	public String GetPassportNum()
	{
		return this.passportNum;
	}
	public String GetPlaneType()
	{
		return this.planeType;
	}
	public String GetDest()
	{
		return this.destination;
	}
	public String GetOrigin()
	{
		return this.origin;
	}
	
	public MyDate GetFlightDate()
	{
		return flightDate;
	}
	
	//FUNCTIONS
	public void InputCustomerDetails() 
	{
		//Name
		System.out.println("Enter your name : ");
		Scanner sc0= new Scanner(System.in);
		String iName=sc0.nextLine();
		while(iName.length()<1)
		{
			System.out.println("Invalid input! Please try again!\n");
			iName=sc0.nextLine();
		}
		this.name=iName;
		System.out.println("\n");
		//sc0.close();
		//Gender
		System.out.println("Select gender (M/F) : ");
		while(true)
		{
			Scanner sc1 = new Scanner(System.in);
			char c = sc1.next().charAt(0);
			
			if(c == 'm' || c=='M')
			{
				this.gender=c;
				break;
			}
			
			
			else if (c=='f' || c=='F')
			{
				this.gender=c;
				break;
			}
			
			else
				System.out.print("Invalid input! Please try again\n");
			//sc1.close();
		}
		
		System.out.println("\n");
		
		
		//----city name
		System.out.println("Enter city of stay : ");
		Scanner scCity=new Scanner(System.in);
		String cityName=scCity.nextLine();
		this.houseAddr.setCity(cityName);
		//sc.close();y
		System.out.println("\n");
		
		//passport number
		System.out.println("Enter passport Number : ");
		Scanner sc2=new Scanner(System.in);
		String passNum= sc2.nextLine();
		while(passNum.length()!=9)
		{
			System.out.println("Invalid length of passport number! Please try again.\n");
			passNum=sc2.nextLine();
		}
		this.passportNum=passNum;
		
		System.out.println("\n");
		
		//plane type
		System.out.println("Enter preferred plane type \n1. Air bus \n2. Boeing \n3. Jumbo jet \n4. Turboprop \nJust enter the 1st character of the given options : ");
		while(true)
		{
			Scanner sc3 = new Scanner(System.in);
			char plType = sc3.next().charAt(0);
			
			if(plType == 'a' || plType=='A')
			{
				this.planeType="Air bus";
				break;
			}
			else if (plType=='b' || plType=='B')
			{
				this.planeType="Boeing";
				break;
			}
			else if(plType=='j'||plType=='J')
			{
				this.planeType="Jumbo jet";
				break;
			}
			else if (plType=='t'||plType=='T')
			{
				this.planeType="Turboprop";
				break;
			}
			else
			{
				System.out.print("Invalid input! Please try again\n");
			}
		}
		System.out.println("\n");
		
		//Destination
		System.out.println("Enter Destination : ");
		Scanner sc4= new Scanner(System.in);
		
		String dest=sc4.nextLine();
		while(dest.length()<1)
		{
			System.out.println("Invalid input! Please try again\n");
			dest=sc4.nextLine();
		}
		this.destination=dest;
		System.out.println("\n");
		
		//Origin
		System.out.println("Enter Origin : ");
		Scanner sc5= new Scanner(System.in);
		
		String ori=sc5.nextLine();
		while(ori.length()<1)
		{
			System.out.println("Invalid input! Please try again\n");
			ori=sc5.nextLine();
		}
		this.origin=ori;
		System.out.println("\n");
		
		//Age
		System.out.println("Enter your age : ");
		Scanner scAge= new Scanner(System.in);
		int inpAge= scAge.nextInt();
		while(inpAge<=0)
		{
			System.out.println("Invalid number for age! Please try again.\n");
			inpAge=scAge.nextInt();
		}
		while(inpAge>0 && inpAge<18)
		{
			System.out.println("Unfortunately you are too young to book a flight! Try again maybe? :( \n");
			inpAge=scAge.nextInt();
		}
		this.setAge(inpAge);
		//Address
		System.out.println("Your Address \nEnter Street Number : ");
		Scanner scInt= new Scanner(System.in);
		//----street number
		int strtNum= scInt.nextInt();
		while(strtNum<1)
		{
			System.out.println("Invalid street number! Please try again\n");
			strtNum= scInt.nextInt();
		}
		this.houseAddr.SetStrtNm(strtNum);
		System.out.println("streetNum\n");
		//----house number
		System.out.println("Enter house number : ");
		Scanner scInt2= new Scanner(System.in);
		int hNum= scInt2.nextInt();
		while(hNum<1)
		{
			System.out.println("Invalid house number! Please try again\n");
			hNum=scInt2.nextInt();
		}
		
		this.houseAddr.setHouseNum(hNum);
		System.out.println("\n");
		
		//flight date
		System.out.println("Enter Travel date\n");
		//------current Date
		LocalDate currentDate = LocalDate.now();
		//----year
		System.out.println("Enter year : ");
		Scanner scInt3=new Scanner(System.in);
		int fYear=scInt3.nextInt();
		int currYear=Year.now().getValue();
		while(fYear<currYear)
		{
			System.out.println("Invalid value for year! Please enter value >= "+currYear+"\n");
			fYear=scInt3.nextInt();
		}
		this.flightDate.setYear(fYear);
		System.out.println("\n");
		//----month
		System.out.println("Enter month number : ");
		Scanner scInt4=new Scanner(System.in);
		int fMonth=scInt4.nextInt();
		int currMonth= currentDate.getMonthValue();
		if(fMonth<currMonth && fYear>currYear)
		{
			this.flightDate.setMonth(fMonth);
		}
		while(fMonth<currMonth && fYear<=currYear)
		{
			System.out.println("Invalid value for month entered! Try again!\n");
			fMonth=scInt4.nextInt();
			currMonth= currentDate.getMonthValue();			
		}
		System.out.println("\n");
		//----day
		System.out.println("Enter day of Month : ");
		Scanner scInt5=new Scanner(System.in);
		int fDay=scInt5.nextInt();
		int currDay=currentDate.getDayOfMonth();
		if(fDay<currDay && fMonth>currMonth)
		{
			this.flightDate.setDay(fDay);
		}
		while(fDay<currDay && fMonth<=currMonth)
		{
			System.out.println("Invalid value for day entered! Try again!\n");
			fDay=scInt5.nextInt();
			currDay= currentDate.getDayOfMonth();
		}
		System.out.println("\n");
	}
	public void DisplayCustomerDetails()
	{
		System.out.println("Name : "+this.name+"\n");
		System.out.println("Gender : "+this.gender+"\n");
		System.out.println("Age : "+this.age+"\n");
		System.out.println("Address : ");
		this.houseAddr.DisplayAddress();
		System.out.println("\n");
		System.out.println("Passport Number : "+this.passportNum+"\n");
		System.out.println("***** Flight preferences *****"+"\n");
		System.out.println("Date of departure : ");
		this.flightDate.DisplayDate();
		System.out.println("\n");
		System.out.println("Origin : "+this.origin+"\n");
		System.out.println("Destination : "+this.destination+"\n");
		System.out.println("Plane Type : "+this.planeType+"\n");
		
	}
}

