package com.yedam;

//crtl +shft+f =정렬
public class HelloJava {
	public static void main(String[] args) {
	// int(정수), double(실수), boolean(참 거짓)
	int num1 =10; //변수를 초기화.
	double num2 =20; // 자동형변환(promotion)
	
	num1 = (int) num2; //강제형변환(casting)
	
	int num3 = 100; 
	double num4 = 200;
	double result = (double) num3 + num4;
	System.out.println("결과는" + result);
	
	//20 + 30 = 50
	System.out.println("결과는" + (20 + 30));
	//문자를 넣으면 결과는2030으로 표시 된다.
	//문자를 넣지 않으면 50.0으로 표시 된다.  같은 데이터 타입으로 연산을 해줘야된다. ()을 쳐줘야 된다.
	
	}
}
