package i160195_AP_Assignment2;

import java.time.LocalDate;
import java.time.Month;

public class MyDate {

    private int day;
    private int month;
    private int year;
    private LocalDate currdate = LocalDate.now();

    // default constructor to record account creation date
    public MyDate() {
        day=0;
        month=0;
        year=0;
    }
    
    public MyDate(int yr,int mon,int d)
    {
    	this.day=d;
    	this.month=mon;
    	this.year=yr;
    }
    
    //parameterized constructors
   
    public void setDay(int d) {
        day = d;
    }

    public void setMonth(int mon) {
        month = mon;
    }

    public void setYear(int yr) {
        year = yr;
    }

    // getters to allow read only access
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void DisplayDate() {
        System.out.println(day + "/" + month + "/" + year);
    }
    
    public void setDate(MyDate dte)
    {
    	this.day=dte.getDay();
    	this.month=dte.getMonth();
    	this.year=dte.getYear();
    	
    }
}
