package com.systechafrika.part4.utildate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class WorkingWithUtilDate {
    public static void main(String[] args) {
    
    
       Date date = new Date();
        System.out.println(date);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 2);
        System.out.println(calendar.getTime());

        try (Scanner scanner= new Scanner(System.in)){
            System.out.println("Enter date");
            String dateString=scanner.nextLine();
            DateFormat df = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date tommorowDate = df.parse(dateString);
            //System.out.println(df.format(tommorowDate));
            

            DateFormat df2= new  SimpleDateFormat("yyyy-MM-dd");
            System.out.println(df2.format(tommorowDate));

        } catch (Exception e) {
            System.out.println(e.getMessage());
            ;
        }
    }
}
