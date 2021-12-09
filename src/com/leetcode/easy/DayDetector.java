package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author prabhuddha.bhashitha
 * Derive the day of the week(Sunday,Monday...) from a given date 10-11-1978
 * 
 * Known date will be given as 01-01-1972 -> Sunday
 */
public class DayDetector {
	
	private static List<String> weekDayListForSolution = new ArrayList<String>();
	private static List<String> weekDayList = Arrays.asList("Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday");
	private static List<Integer> monthDateList = Arrays.asList(31,28,31,30,31,30,31,31,30,31,30,31);
	
	public static void main(String[] args) {
		
		//there are 3 program inputs 
		String givenDate 	= "01-01-1972";//1. Given date
		String givenWeekDay = "Sunday";//2. Given day of the week
		String date 		= "29-02-2020";//3. Question date
		
		//Re-order the days list as per the given day of the week
		int indexOfGivenWeekDay = weekDayList.indexOf(givenWeekDay);
		for(int i = indexOfGivenWeekDay; i<(indexOfGivenWeekDay+7);i++) {
			weekDayListForSolution.add(weekDayList.get(i %7));
		}
		
		//splitting date string by "-" so we have year, month and date
		String[] dateArr = givenDate.split("-");
		int day   = Integer.parseInt(dateArr[0]);
		int month = Integer.parseInt(dateArr[1]);
		int year  = Integer.parseInt(dateArr[2]);
		
		System.out.println("Answer : "+date + " is a " + getWeekDay(date,year,month,day));
	}
	
	/**
	 * 1. Calculate the number of days from the origin date to the given date
	 * 2. NumberOfDays % 7 -> 0, ==> it is the same week day as the given day
	 * @param date
	 * @return
	 */
	public static String getWeekDay(String date,int year1,int month1, int day1) {
		
	   String[] dateArr = date.split("-");
	   int day2 = Integer.parseInt(dateArr[0]);
	   int month2 = Integer.parseInt(dateArr[1]);
	   int year2 = Integer.parseInt(dateArr[2]);
	   System.out.println("Given date    = " +year1 +" "+month1+" "+ day1);
	   System.out.println("Question date = " +year2 +" "+month2+" "+ day2);
	   //number of days in whole years
	   int daysAsWholeYear = 0;
	   for(int i=year1;i<year2;i++) {
		   daysAsWholeYear += ((isLeapYear(i)) ? 366 : 365);
	   }
	   System.out.println("   DaysPassedAsWholeYear :" + daysAsWholeYear);
	   //number of days passed from origin year starting
	   int daysPassedInOriginYear = getPassedDaysInTheYear(year1,month1,(day1));
	   System.out.println("   DaysPassedInOriginYear :" + daysPassedInOriginYear);
	   //number of days passed in destination year
	   int daysPassedInDestYear = getPassedDaysInTheYear(year2,month2,day2-1);//here minus 1 because the destination date is not passed yet and should be excluded from the calculation
	   System.out.println("   DaysPassedInDestYear :" + daysPassedInDestYear);
	   //total days passed from the origin date
	   int totalDays = daysAsWholeYear - daysPassedInOriginYear +  daysPassedInDestYear;
	   
	   return weekDayListForSolution.get(totalDays % 7);
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
