package com.leetcode.easy;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author prabhuddha.bhashitha
 * Derive the day of the week(Sunday,Monday...) for a given date e.g. 10-11-1978
 * 
 * Known date will be given as 01-01-1972 -> Sunday
 */
public class DayDetector {
	
	private static List<String> weekDayList = Arrays.asList("Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday");
	private static List<Integer> monthDateList = Arrays.asList(31,28,31,30,31,30,31,31,30,31,30,31);
	
	public static void main(String[] args) {
		
		//there are 3 program inputs 
		String date1 		= "1972-01-01";//1. Given date
		String givenWeekDay = "Sunday";//2. Given day of the week
		String date2 		= "2020-02-29";//3. Question date
		
		//Re-arrange the days list as per the given day of the week
		int indexOfGivenWeekDay = weekDayList.indexOf(givenWeekDay);
		
		for(int i = 0; i < indexOfGivenWeekDay;i++) {
			String temp = weekDayList.get(0);
			for(int j=0;j<weekDayList.size();j++) {
				if(j==weekDayList.size()-1) {
					weekDayList.set(j, temp);
				}else {
					weekDayList.set(j, weekDayList.get(j+1));
				}
			}
		}
		System.out.println("Re arranged weekDayList" +weekDayList);
		
		//Method 1
		System.out.println("Method 1 : Answer : "+date2 + " is " + getWeekDay(date1,date2));
		
		//Method 2
		System.out.println("Method 2 : Answer : "+date2 + " is " + getWeekDayWithJDK8Code(date1,date2));
	}
	
	/**
	 * 1. Calculate the number of days from the origin date to the given date
	 * 2. NumberOfDays % 7 -> 0, ==> it is the same week day as the given day
	 * @param date
	 * @return
	 */
	public static String getWeekDay(String date1,String date2) {
		
	    String[] dateArr = date1.split("-");
		int year1   = Integer.parseInt(dateArr[0]);
		int month1 	= Integer.parseInt(dateArr[1]);
		int day1  	= Integer.parseInt(dateArr[2]);
		   
		dateArr = date2.split("-");
		int year2  	= Integer.parseInt(dateArr[0]);
		int month2 	= Integer.parseInt(dateArr[1]);
		int day2  	= Integer.parseInt(dateArr[2]);
	   
		System.out.println(String.format("Given date :%s, Question Date :%s", date1,date2));
		//number of days in whole years
		int daysAsWholeYear = 0;
		for(int i=year1;i<year2;i++) {
		   daysAsWholeYear += ((isLeapYear(i)) ? 366 : 365);
		}
		//number of days passed from origin year starting
		int daysPassedInOriginYear = getPassedDaysInTheYear(year1,month1,(day1));
		//number of days passed in destination year
		int daysPassedInDestYear = getPassedDaysInTheYear(year2,month2,day2-1);//here minus 1 because the destination date is not passed yet and should be excluded from the calculation
		//total days passed from the origin date
		int totalDays = daysAsWholeYear - daysPassedInOriginYear +  daysPassedInDestYear;
		System.out.println(String.format("DaysPassedAsWholeYear :%s, DaysPassedInOriginYear :%s, DaysPassedInDestYear :%s, Total Days :%s",daysAsWholeYear,daysPassedInOriginYear,daysPassedInDestYear,totalDays));
		return weekDayList.get(totalDays % 7);
	}
	
	public static String getWeekDayWithJDK8Code(String date1,String date2) {
	   LocalDate dateBefore = LocalDate.parse(date1);
	   LocalDate dateAfter 	= LocalDate.parse(date2);
	   int totalDays = (int)ChronoUnit.DAYS.between(dateBefore, dateAfter);
		//calculating number of days in between
	   return weekDayList.get((totalDays-1) % 7);
	}
	
	public static boolean isLeapYear(int year) {
		return (((year % 4 == 0) && (year % 100!= 0)) || (year%400 == 0));
	}
	
	public static int getPassedDaysInTheYear(int year,int month,int days) {
		int destMonthDays =0;
		if(month > 1) {
			boolean destinationLeapYear = isLeapYear(year);
			int i =1;
			while(i < month) {
				if(i==2 && destinationLeapYear) {
					destMonthDays += 29;
				 }else {
					 destMonthDays += monthDateList.get(i-1);
				 }
				++i;
			}
		}
		return destMonthDays + days;
	}
	
	
	
}
