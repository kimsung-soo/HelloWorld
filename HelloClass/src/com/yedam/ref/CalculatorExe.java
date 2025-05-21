package com.yedam.ref;

//실행클래스
public class CalculatorExe {
	
	public static void main(String[] args) {
		int a = 20, b = 30;
		
		//sum의 기능활용
		Calculator c1=new Calculator();
		c1.sum(a, b); //정적메소드. 클래스에 고정된 멤버로서 객체 생성하지 않고 사용할수 있는 필드와 메소드
		
		Calculator.sum(a,b);
		printStar();
		
//		CalculatorExe ce =new CalculatorExe();
//		ce.printStar();
	}
	
	static void printStar() {
		System.out.println("*");
	}
}
