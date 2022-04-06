package i160195_AP_Assignment2;

public class Address {

	private int streetNumber;
	private int houseNum;
	private String cityName;
	
	public Address()
	{
		streetNumber=0;
		houseNum=0;
		cityName="\0";
	}
	
	public Address(int strtN, int hNum, String city)
	{
		streetNumber=strtN;
		houseNum=hNum;
		cityName=city;
	}
	
	public int GetStrtNm()
	{
		return streetNumber;
	}
	
	public int getHouseNum()
	{
		return houseNum;
	}
	public String getCity()
	{
		return cityName;
	}
	
	public void SetStrtNm(int strtN)
	{
		streetNumber=strtN;
	}
	
	public void setHouseNum(int hNum)
	{
		houseNum=hNum;
	}
	public void setCity(String city)
	{
		cityName=city;
	}
	
	public void DisplayAddress()
	{
		System.out.println("House num "+this.houseNum+", street "+this.streetNumber+", "+this.cityName);
	}
}

