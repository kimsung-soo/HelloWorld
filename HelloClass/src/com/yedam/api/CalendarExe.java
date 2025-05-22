package com.yedam.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarExe {

	public static void main(String[] args) {
		
	}

	// 달력
	public static void makeCalendar(int year, int month) {
		MyCalendar.showMonth(2025, 5);
	}

	public static void date() {
		Date today = new Date();
		// 날짜를 문자열로 출력
		System.out.println("기본 출력: " + today.toString());

		// 날짜 포맷 변경해서 출력
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일 HH시:mm분:ss초"); // String ->Date로 변경
		String timeStr = sdf.format(today); // Date ->String.
		System.out.println(timeStr);
		// 2025년05월12일 13:22:38

		try {
			today = sdf.parse("2025-08-01 09:00:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(today);
	}

	public static void cal() {
		// Calendar 클래스 사용
		Calendar now = Calendar.getInstance();

		now.set(2025, 0, 1); // 2025년 1월 1일로 설정
		now.set(Calendar.YEAR, 2024); // 연도만 다시 2024로 변경됨

		// 요일 확인
		int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);
		switch (dayOfWeek) {
		case 1:
			System.out.println("일요일");
			break;
		case 2:
			System.out.println("월요일");
			break;
		case 3:
			System.out.println("화요일");
			break;
		}

		System.out.printf("년도: %d, 월: %d, 날짜: %d, 말일: %d\n", now.get(Calendar.YEAR), now.get(Calendar.MONTH) + 1, // Calendar.MONTH는
																													// 0부터
																													// 시작하므로
																													// +1
				now.get(Calendar.DATE), now.getActualMaximum(Calendar.DATE)); // 해당 월의 마지막 날짜
	}
}
