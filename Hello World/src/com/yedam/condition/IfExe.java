package com.yedam.condition;

import java.util.Scanner;

public class IfExe {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int randomValue = (int) (Math.random() * 1000) + 1; 
        int count = 0;

        
        while (true) {
            System.out.print("1~1000 사이의 숫자를 입력하세요: ");
            int userInput = Integer.parseInt(scn.nextLine());

            if (userInput < 1 || userInput > 1000) {
                System.out.println("1~1000까지 숫자를 입력하세요.");
                continue;
            }

            count++;

            
            if (randomValue < userInput) {
                System.out.println("입력값보다 작습니다.");
            } else if (randomValue > userInput) {
                System.out.println("입력값보다 큽니다.");
            } else {
                System.out.println("정답입니다! 시도 횟수는 " + count + "번입니다.");
                break;
            }
        }

       
    }



	public static void test() {
		int score = 85;

		// if(절) 조건문

		// if. java 안에서는 조건식을 () 안에 넣어야 된다.
//		if (score >= 90) {
//			System.out.println("A학점");
//		} else if (score >= 80) {
//			System.out.println("B학점");
//		} else if (score >= 70) {
//			System.out.println("C학점");
//		} else {
//			System.out.println("불합격");
//		}

		// switch(절) 조건문

		score = score / 10;
		switch (score) {
		case 10:
		case 9:
			System.out.println("A학점");
			break;
		case 8:
			System.out.println("B학점");
			break;
		case 7:
			System.out.println("C학점");
			break;
		default:
			System.out.println("불합격");
		}// end of switch
	}
}
