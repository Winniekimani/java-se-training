package com.systechafrika.part4.utildate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class WorkingWithNewDateTime {
    public static void main(String[] args) {

        //workingWithLocalDate();
        //workingWithLocalDateTime();
        workingWithLocalTime();
       
    }
    private static void workingWithLocalTime() {
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        LocalTime startTime =LocalTime.of(8, 30, 40);
         System.out.println(startTime);

         LocalTime endTime= startTime.plusHours(2).plusMinutes(20);
         System.out.println(endTime);
        

    }
    private static void workingWithLocalDateTime(){
        LocalDateTime localDateTime= LocalDateTime.now();
        System.out.println(localDateTime);

        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ISO_DATE_TIME;
        System.out.println(dateTimeFormatter.format(localDateTime));

    }
    private static void workingWithLocalDate(){

         //?local date,local time and localdatetime are immutable
        //immutable unless reassigned
        LocalDate todayDate = LocalDate.now();
        System.out.println(todayDate);

        //System.out.println(todayDate.plusDays(5));//this will print plus five days from today

        todayDate.plusDays(5);
        System.out.println(todayDate);//this will print todays date because we didnt reassign the value of todas date above
        System.out.println(todayDate.plusMonths(12));
        System.out.println(todayDate.plusYears(5));



        String somestring ="some string";
        //somestring.replaceAll("some", "");
        System.out.println(somestring.replaceAll("some", ""));//tis will prrint string

        System.out.println(LocalDate.of(1998, 6, 20));
        System.out.println(LocalDate.of(1998, Month.APRIL, 20));
        

    }
    
}
