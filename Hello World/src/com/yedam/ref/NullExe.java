package com.yedam.ref;

public class NullExe {
	public static void main(String[] args) {
		String str1 = "홍길동"; // 참조변수 1
		String str2 = null; // 참조변수 2

		/// NullPointerException (참조변수가 null 상태에서 존재하지 않는 갱체의 데이터나 메소드 사용할경우 발생)
//		System.out.println(str2.toString());

		// 정수를 담을수 있는 배열
		int num1 = 10;
		int[] ary = { 10, 20, 30  };
		System.out.printf("ary배열의 크기 %d\n", ary.length);

		int[] intAry; // 변수 선언
		// new 키워드를 이용해 크기 3짜리 정수형 배열을 생성하고, 값을 {40, 50, 60}으로 초기화함.
		intAry = new int[] { 40, 50, 60  };
		/// 첫번째 위치의 40 =>400으로 변경
		intAry[0] = 400;

		// 인덱스 3 => 4번째 위치
//		intAry[3] = 10;  //배열의 크기가 3이라서 4번째에 위치에는 값이 오지 않는다. (에러 발생**)
		intAry[2] = 10;

		// for 반복문
		for (int i = 0; i < 3; i++) {
			System.out.printf("[%d]번째의 값: %d\n", i, intAry[i]);
		}
		
		//배열은 선언하면 크기가 고정이 된다.  
		//크기를 변경할려고 하면 선언을 새로 해야 된다.
		intAry =new int[5];
		intAry[0] =40;
		intAry[1] =50;
		intAry[2] =60;
		intAry[3] =70;
		intAry[4] =80;
		
		for (int i = 0; i < intAry.length; i++) {
			System.out.printf("intAry[%d]번째의 값: %d\n", i, intAry[i]);
		}
		
		//배열선언:double 값을 담는 배열 dblAry
		//10.2, 23,2 34,5
		
	
		
		double[] dblAry;
		dblAry = new double[3];
		dblAry[0] = 10.2;
		dblAry[1] = 23.2;
		dblAry[2] = 34.5;
		
			for	(int i = 0; i <dblAry.length; i++){
			System.out.printf("[%d]번째의 값: %.1f\n", i, dblAry[i]);
		}
		
			String[] strAry= new String[10];        //{"Hellow", "World"};
			for	(int i = 0; i <strAry.length; i++){
				System.out.printf("strAry [%d]번째의 값: %s\n", i, strAry[i]);
			}
	}
}
