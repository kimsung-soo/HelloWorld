package com.yedam.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// 🔽 com.yedam 패키지 안의 MyCalendar를 import
import com.yedam.MyCalendar;

public class CalendarExe {

    public static void main(String[] args) {
        makeCalendar(2025, 5);  
    }

    public static void makeCalendar(int year, int month) {
        MyCalendar.showMonth(year, month); 
    }

    public static void date() {
        Date today = new Date();
        System.out.println("기본 출력: " + today.toString());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일 HH시:mm분:ss초");
        String timeStr = sdf.format(today);
        System.out.println(timeStr);

        try {
            today = sdf.parse("2025-08-01 09:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(today);
    }

    public static void cal() {
        Calendar now = Calendar.getInstance();

        now.set(2025, 0, 1);
        now.set(Calendar.YEAR, 2024);

        int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);
        switch (dayOfWeek) {
            case 1: System.out.println("일요일"); break;
            case 2: System.out.println("월요일"); break;
            case 3: System.out.println("화요일"); break;
        }

        System.out.printf("년도: %d, 월: %d, 날짜: %d, 말일: %d\n",
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH) + 1,
                now.get(Calendar.DATE),
                now.getActualMaximum(Calendar.DATE));
    }
}
