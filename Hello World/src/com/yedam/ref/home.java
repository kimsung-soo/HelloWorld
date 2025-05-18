package com.yedam.ref;

import java.util.Scanner;

public class home {

	public static void main(String[] args) {
		test1();

	}// end of main

	public static void test1() {

		boolean run = true;
		int studentNUm = 0;
		int[] scores = null;
		Scanner scanner = new Scanner(System.in);

		while (run) {
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("1.학생수| 2.점수입력| 3. 점수리스트| 4.분석 | 5.종료");
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("선택> ");

			int selectNO = Integer.parseInt(scanner.nextLine());

			if (selectNO == 1) {
				System.out.println("학생수:");
				studentNUm = Integer.parseInt(scanner.nextLine()); // 학생수 를 저장
				scores = new int[studentNUm]; // 입력한 학생의 수 만큼 점수 저장

			} else if (selectNO == 2) {
				for (int i = 0; i < scores.length; i++) {
					System.out.println("scores[" + i + "]");
					scores[i] = Integer.parseInt(scanner.nextLine()); // 점수를 저장
				}

			} else if (selectNO == 3) {
				for (int i = 0; i < scores.length; i++) {
					System.out.println("scores[" + i + "] = " + scores[i]);
				}

			} else if (selectNO == 4) {
				int max =0;
				int sum =0;
				
				for(int i = 0; i < scores.length; i++) {
					if (scores[i] < max); {
					    max = scores[i]; 
					    }				
					sum += scores[i];					
					}
				double avg = (double) sum / scores.length;
				System.out.println("최고 점수:" + max);
				System.out.println("평균 점수:" + avg);
				}

			 else if (selectNO == 5) {
				run = false;
			}

		}

	System.out.println("프로그램 종료");

}

}
