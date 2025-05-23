package com.yedam;

public class MyCalendar {
	
    public static void showMonth(int year, int month) {
        System.out.printf("%d년 %02d월\n", year, month);
        System.out.println("============================");

        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(year, month - 1, 1); 

        int startDay = cal.get(java.util.Calendar.DAY_OF_WEEK); // 요일
        int lastDate = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH); // 마지막 일자

        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        System.out.println("============================");

        for (int i = 1; i < startDay; i++) {
            System.out.printf("%4s", "");
        }

        for (int day = 1; day <= lastDate; day++) {
            System.out.printf("%4d", day);
            if ((startDay + day - 1) % 7 == 0) {
                System.out.println();
            }
        }

        System.out.println();
    }
}