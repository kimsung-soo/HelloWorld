package com.yedam.condition;

import java.util.Scanner;

public class LoopExe {
	public static void main(String[] args) {

		test1();
		// "가위(1)","바위(2)","보(3)",
		// 1,2,3 <==> 가위(1), 바위(2), 보(3) , 종료 (4)
		// "You Win", "You Lost",same
	}

	public static void test1() {
		Scanner scn = new Scanner(System.in);

		while (true) {
			System.out.println("1.가위 2.바위 3.보 4.종료 중 하나를 고르시오");
			int user = Integer.parseInt(scn.nextLine());

			if (user == 4) {
				System.out.println("게임을 종료합니다.");
				break;
			}else if  (user<1 || user>4) {
                System.out.println("1~4사이에서 고르시오");
                continue;
            }
			
			int com = (int) (1 + Math.random() * 3);

			if (user > com) {
				System.out.println("You Win");
			} else if (user < com) {
				System.out.println("You Lost");
			} else {
				System.out.println("Same");
			}
		}
	}
	
	

	public static void test() {

		// while vs. do .. while
		boolean run = false;

//		while (run) {     // 조건이 참일 때만 실행
//			System.out.println("while문");
//		}

		//// 코드에서 run이 false이기 때문에 while문이라는 문장은 절대 실행되지 않습니다.
//		
		do { //// 조건이 false라도 무조건 한 번은 실행됩니다.

			System.out.println("while문");
			run = !run;
		} while (run); // run의 값을 true <-> false로 토글(toggle)함

		System.out.println("end of prog");

	}
}