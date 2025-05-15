package com.yedam.operator;

public class OperatorExe {

	public static void main(String[] args) {
		// test()
		// test1();
		// test2();
		// test3();
		// test4();
		test5();
	}

	public static void test5() {
		String pass = "";
		int score = (int) (Math.random() * 100);

//		if(score >= 80) {
//			pass = "우수";
//		}else {
//		if (score >= 60)
//			pass = "합격";
//		} else {
//		if(score >=20)
//		pass = "불합격"; 
//		 else {
//				pass = "불합격"; 

		// if절 => 대채할 삼항연잔자로 변경하는법 ▼▼
		pass = (score >= 80) ? "우수" : (score >= 60) ? "합격" : (score >= 20) ? "불합격" : "불불합격";
		System.out.printf("%d점은 %s\n", score, pass);
	}

	// "월" 정보를 입력하면 "공란" 반환하는 메소드. getSpace() (객체 안에 있는 함수를 메소드 라고 한다.)
	public static int getSpace(int month) {
		int space = 0;
		if (month == 3) { // 3월달이면 공백을 6칸 주고 시작한다.
			space = 6;
		} else if (month == 4) {// 4월달이면 공백을 2칸 주고 시작한다.
			space = 2;
		} else if (month == 5) {// 5월달이면 공백을 4칸 주고 시작한다.
			space = 4;
		} else if (month == 7) {// 7월달이면 공백을 2칸 주고 시작한다.
			space = 2;
		}
		return space; // int 값을 반환 한다.
	}// end of getSpace.

	// "월" 정보를 입력하면 말일을 알려주는 메소드 getLastDate(월)
	public static int getLastDate(int month) {
		int lastDate = 31;
		switch (month) {
		case 2:
			lastDate = 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			lastDate = 30;
			break;
		}
		return lastDate;
	}// end of getLastDate.

	public static void test4() {

		int mon = 7; // 월정보 입력란
		System.out.println("  Sun MON Tue Wed Thu Fri Sat");

		// 빈공간 출력 //3월달이면 공백을 6칸 주고 시작한다.(getSpace)
		int space = getSpace(mon); // (공백이 주는 변수)
		int lastDate = getLastDate(mon);
		// space = 2 → 1일이 화요일에 시작한다는 뜻입니다. ( getSpace 메소드 확인)
		// lastDate = 31 → 달력에서 1일부터 31일까지 출력하겠다는 의미.

		for (int s = 1; s <= space; s++) {
			System.out.printf("%4s", "");
		}
		// 1일이 시작되기 전 요일 자리를 공백으로 채움
		// "%4s"는 4칸 폭으로 출력하라는 의미 → 각 날짜 또는 빈칸이 가로로 정렬되게 도와줌

		// 날짜출력
		for (int day = 1; day <= lastDate; day++) {
			System.out.printf("%4d", day); // 4개의 공간___을 보여준다.

			if ((day + space) % 7 == 0) { // 나머지가 7일때 마다 줄바꿈 한다.
				System.out.println();
				// (day + space) % 7 == 0 은 "한 줄에 7개 날짜가 채워졌을 때"를 의미합니다.
				// space만큼 앞에 빈칸이 있기 때문에, 총 날짜 수는 day + space로 판단해야 맞습니다.
				// % 7 == 0 → 일주일이 다 차면 줄바꿈

			}
		}
	}

	public static void test3() {
		boolean isTrue = true;
		for (int i = 1; i <= 10; i++) {
			if (isTrue) {
				System.out.printf("i의 값은 %d\n", i);
			}
			isTrue = !isTrue; // 토글 (on -> off , off->on)
		}

	}

	public static void test2() {
		int num1 = 10;
		int num2 = 20;

		int result = ++num1 + num2++;
		// 증강연산자를 num 앞에 or 뒤에 붙여보기.
		// 앞에 있으면 +하기 전에 증가 / 뒤에 있으면 +하고 난 후 증가
		// %s 뒤에 오는 문자열을 받아 온다. %d는 뒤에 오는 정수를 받아 온다.
		System.out.printf("num1 =>%d, num => %d, reslut =>%d%n", num1, num2, result);

		// ! 부정 연산자. !가 부정연산자라서 true 결과 값이 나오지 않는다.
		boolean isTrue = true;
		if (!isTrue) {
			System.out.println("참입니다.");
		}
		// == 같다는 부정은 !=, > 크다의부정값은 <=, >= 작다의부정은 <
		if ((result != 30)) {
			System.out.println("\nresult 는 30보다 작거나 같다.");
		}

		if (!(--num1 > 10 || num2 < 20)) {
			System.out.printf("num1	 => %d", num1);
		}
	}

	// 연습2. byte,shot,long,int,char =>정수 타입
	public static void test1() {
		byte num1 = 10;
		byte num2 = 20;
		// byte sum = num1 + num2; 오류가 뜬다. 연산의 기본이 정수라서 int로 해줘야 된다.
		byte sum = (byte) (num1 + num2); // 정수연산의 기본은 int.
		System.out.println(sum);

		long num3 = 1000000000L; // L =>long 형태의 데이터타입
		long num4 = 100L;
		// System.out.println(Long.MAX_VALUE); //Long 형태의 데이터 최대 값을 표현.
		System.out.println(Integer.MAX_VALUE);// 2147483647

	}

	// 연습1.
	public static void test() {
		// 증가,감소 연산자 (++ --)
		// byte = 정수형 데이터 타입 중 가장 작은 크기 1바이트 (범위는 -128 ~ 127)
		byte num1 = -128;
		num1 = 127;
		num1++;
		// byte는 -128~127 범위의 값을 가짐 ,127 + 1 → 오버플로우 → -128이 됨
		System.out.println(num1);

		char ch1 = 'A'; // 문자 'A'는 정수 65
		ch1 = 66; // 유니코드 정수 66 → 문자 'B'
		ch1 = '가'; // 유니코드 44032 → '가'
		ch1 = 'A';
		ch1 = 'a';
		ch1 = '가';
		ch1 = 0x29D7;
		System.out.println((int) ch1); // 문자 'A'의 유니코드 정수 값 출력: 65

		for (int i = 1; i <= 26; i++) {
			System.out.println(ch1++);
		}
	}
}
