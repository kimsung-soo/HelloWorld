package com.yedam;

public class Calendar {
    static void showMonth() { 
    	
    	
        int mon = 5;
        System.out.println("2025년 05월");
        System.out.println("============================");
        int startDay = 4;  
        int lastDate = 31; 
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        System.out.println("============================");

      
        for (int i = 0; i < startDay; i++) {
            System.out.printf("%4s", "");
        }

        for (int day = 1; day <= lastDate; day++) {
            System.out.printf("%4d", day);
            
            if ((day + startDay) % 7 == 0) {
                System.out.println(); 
            }
        }
        System.out.println(); // 마지막 줄 줄바꿈
    }

    public static void main(String[] args) {
        showMonth();
    }
}
