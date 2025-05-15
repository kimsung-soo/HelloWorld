package com.yedam;

import java.util.Scanner;

public class JSExe {

	// main ctrl + space
	public static void main(String[] args) {
		int num1 = 30;
		int num2 = 30; 
//		System.out.println(num1 == num2);

		String str1 = new String("Hello");
		String str2 = new String("Hello");
//		System.out.println(str1);
//		System.out.println(str2);

//		System.out.println(str1.equals(str2));

		// "30" vs .30 문자와 숫자 비교
		String str3 = "30";
		int num3 = 30;
//		System.out.println(str3.equals(" " + num3));
		int num4 = Integer.parseInt(str3); // 문자열 숫자
//		System.out.println(num3 == num4); // 30 vs ."30" *> 30변경
		// 비교 연산자 중 문자열을 비교할때는 equals 를 사용해야된다.

//		test2();// 평균 구하기 소수점 자리 까지
//		test3();// 스캐너 사용 
//		test4();
		test5();
	}// end of main
	
	
	public static void test5() {
		//printf ("형식문자열", 값1,값2... 괄호 안의 첫번째 문자열 형식대로 출력한다.) 
		//println 괄호 안의 내용을 출력하고 행을 바꾼다)	
		//%s 뒤에 오는 문자열을 받아 온다. %d는 뒤에 오는 정수를 받아 온다. (소수점은 f)
		// \t : tab(탭) \n: 줄바꿈
		System.out.printf("%s %d\t", "문자",30);
		System.out.println("문자");
		//홍길동,100, 23.9
		System.out.printf("%s %d %.1f\n", "홍길동",100,23.9);
		
		System.out.printf("%s\n", "안녕하세요.이름은 김성수 입니다.");
		System.out.printf("%s %d%s\n","나이는 만",30,"세입니다");
		System.out.printf("%s %.1f%s", "몸무게는",80.1,"입니다.");
	} 
	 

	public static void test4() {
		Scanner scn = new Scanner(System.in); // 사용자 입력을 위한 Scanner 생성
		String str = "친구 목록은 "; // 누적할 문자열의 시작 부분 (변수선언)
		
		while (true) {
			System.out.println("친구이름 입력. 종료하려면 quit>>");
			String msg = scn.nextLine(); // 사용자 입력 한 줄을 받음

			if (msg.equals("quit")) { // 입력이 "quit"이면
				str += "입니다"; // 문장을 마무리
				break; // 반복 종료
			}

			str += msg + ", "; // 이름을 누적하고 쉼표로 구분 (변수 누적)
			System.out.println("입력한 값은 " + msg); // 입력된 이름을 출력
		}

		System.out.println(str); // 최종 친구 목록
	

}// end of test4.

	public static void test3() {
		// 사용자의 입렵값을 읽어들이기
		Scanner scn = new Scanner(System.in);// scanner 변수 알아보기
		int sum = 0;
		for (int i = 1; i <= 3; i++) {
			System.out.println("학생의 점수 입력>>");
			String value = scn.nextLine(); // 입력값을 문자열형태로 반환.
			int score = Integer.parseInt(value);
			sum += score;
		}
		double avg = sum / 3.0;
		avg = Math.round(avg * 100) / 100.0; // math.round 는 반올림 해주는것
		System.out.println("합계:" + sum + "평균" + avg);

	}// end of test3

	public static void test2() {
		// 변경된 부분.
		// 아무내용이나 .....
		// 임의의 수를 생성.30~100사이의 임의의 값 생성
		// 평균: 173.0*1.0/5.0 =>34.654
		// 1 <= x < 11

		int sum = 0;
		for (int i = 1; i <= 5; i++) {
			int result = (int) (Math.random() * 71) + 30;
			System.out.println(result);
			sum += result;
		}
		double avg = sum / 7.0;
		avg = Math.round(avg * 100) / 100.0;
		System.out.println("합계:" + sum + "평균" + avg);

//		System.out.println(Math.round(23.678 * 100)/100.0);
	} // end of test2.

	public static void test() {
		int sum = 0;
		// 1~10 까지의 누적하는 반복문 생성.
		for (int i = 1; i <= 10; i++) {
			// 홀수만 변수주기
			if (i % 2 == 1) {
				sum += i;
			}
		}
		System.out.println("결과" + sum);
	}// end of test

}// end of class(JSExe)
