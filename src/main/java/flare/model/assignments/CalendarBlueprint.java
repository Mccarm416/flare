package flare.model.assignments;

public class CalendarBlueprint { 

	int day;
	int month;
	int year;
	int daysInMonth;
	int startDay;
	
	public CalendarBlueprint(int day, int month, int year, int daysInMonth, int startDay){
		this.day = day;
		this.month = month;
		this.year = year;
		this.daysInMonth = daysInMonth;
		this.startDay = startDay;
	}
	
	public int getDay(){
		return day;
	}
	
	public void setDay(int day){
		this.day = day;
	}
	
	public int getMonth(){
		return month;
	}
	
	public void setMonth(int month){
		this.month = month;
		
	}
	
	public int getYear(){
		return year;
	}
	
	public void setYear(int year){
		this.year = year;
	}
	
	public int getDaysInMonth(){
		return daysInMonth;
	}
	
	public void setDaysInMonth(int daysInMonth){
		this.daysInMonth = daysInMonth;
	}
	
	public int getStartDay(){
		return startDay;
	}
	
	public void setStartDay(int startDay){
		this.startDay = startDay;
	}
	
	public String getMonthName(){
        String monthName;
        switch (month) {
            case 1:  
            	monthName = "January";
                break;
            case 2:  
            	monthName = "February";
                break;
            case 3: 
            	monthName = "March";
                break;
            case 4:  
            	monthName = "April";
                break;
            case 5:  
            	monthName = "May";
                break;
            case 6:  
            	monthName = "June";
                break;
            case 7:  
            	monthName = "July";
                break;
            case 8:  
            	monthName = "August";
                break;
            case 9:  
            	monthName = "September";
                break;
            case 10: 
            	monthName = "October"; 
            	break;
            case 11: 
            	monthName = "November";
            	break;
            case 12: 
            	monthName = "December";
            	break;
            default: 
            	monthName = "Month";
            	break;
        }
        return monthName;
	}
	
	
	
	
    public static int StartDayOfMonth(int month, int day, int year) {
    	//returns the starting day of that month. 
        int y = year - (14 - month) / 12;
        int x = y + y/4 - y/100 + y/400;
        int m = month + 12 * ((14 - month) / 12) - 2;
        int d = (day + x + (31*m)/12) % 7;
        return d;
    }

   
    public static boolean isLeapYear(int year) {
    	 // return true if the year is a leap year
        if  ((year % 4 == 0) && (year % 100 != 0)) {
        	return true;
        }
        if  (year % 400 == 0) {
        	return true;
        }	
        return false;
    }

    public static void Test() {
    	//change main into reg method that takes the month and year. 
    	
       int month = 2;    //month (Jan = 1, Dec = 12)
        int year = 2018;     

        //months[1] = January .... months[12] = December. MIGHT HAVE TO CHANGE TO REMOVE BLANK SPACE
        String[] months = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        // days[i] = number of days in each month 
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        
        if (month == 2 && isLeapYear(year)) {
        	//check for leap year
        	days[month] = 29;
        }
        	
        
        // print calendar header
        System.out.println("   " + months[month] + " " + year);
        System.out.println(" S  M Tu  W Th  F  S");

        // starting day
        int startDay = StartDayOfMonth(month, 1, year);

        // print the calendar, will be in jsp. pass the days[month] to build and start Day
        
  
        for (int i = 0; i < startDay; i++)
        	 System.out.print("   ");
        for (int i = 1; i <= days[month]; i++) {
        	 System.out.printf("%2d ", i);
            if (((i + startDay) % 7 == 0) || (i == days[month]))  
            	System.out.println();
        }

    }
}
