package com.yedam;

import java.util.Scanner;

public class ObjectExe {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("년도를 입력하세요 >>> ");
        int year = scn.nextInt(); // 사용자에게 입력 받기
        
        if (Calendar.isLeapYear(year)) {
        	System.out.println(year+"윤년입니다.");
        }else {
        	System.out.println(year+"평년입니다");
        }

        // Calendar 클래스의 isLeapYear 메서드 호출
       
        scn.close(); // Scanner 자원 반납
    }
}