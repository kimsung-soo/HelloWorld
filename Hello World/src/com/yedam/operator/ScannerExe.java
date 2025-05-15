package com.yedam.operator;

import java.util.Scanner; //외부에서 제공되는 Scanner 클래스를 Java 
							//프로그램에서 사용할 수 있게 "가져오는(import)" 선언입니다.

public class ScannerExe {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in); // 사용자 입력을 위한 Scanner 객체 생성
		int balance = 0; // 계좌의 금액.
		// 조건 10만원을 초과(x), 마이너스 금액(x)

		while (true) { // 무한 루프 → 종료 조건을 만나기 전까지 계속 반복 (break) (while 반복문)
			System.out.println("1.입금 2.출금 3.잔액 4.종료");
			// Integer.parseInt("30"); =>문자열을 정수 30으로 바꿔주는 메소드
			int menu = Integer.parseInt(scn.nextLine());

			if (menu == 1) {
				System.out.println("입금액을 입력>>");
				// 입금기능구현.
				int sum = Integer.parseInt(scn.nextLine());
				if (balance + sum >= 100000) {

					System.out.println(balance + "이 출금 되었습니다.");
				} else
					balance += sum;
				{
					System.out.println(sum + "이 입금 되었습니다.");
				}
				

			} else if (menu == 2) {
				System.out.println("출금액을 입력>>");
				// 출금기능 구현.
				int out = Integer.parseInt(scn.nextLine());
				if (balance < out) {
					System.out.println("잔액이 부족합니다.");
				} else {
					balance -= out;
					System.out.println(out + "이 출금 되었습니다.");
				}
				
				
			} else if (menu == 3) {
				System.out.println("현재잔액>>");

				System.out.println(balance + "이 현재 잔액입니다.");
				
				
			} else if (menu == 4) {
				System.out.println("프로그램을 종료합니다.");
				break;
				
			} else  {
				System.out.println("1~4번 중에 선택하세요");
			}
			
		} // end of while.
		System.out.println("end of prog.");
	}// end of main
}
