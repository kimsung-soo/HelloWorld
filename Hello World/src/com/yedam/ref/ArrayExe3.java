package com.yedam.ref;

/*
 * 배열+기본타입: 정수,실수
 * 배열 + 참조타입(클래스): 학생이름, 점수
 * → 배열 안에 기본값(int, double)뿐 아니라 객체(Student)도 넣을 수 있다는 말
 */
public class ArrayExe3 {

	static Student[] stdAry; // Student 객체들을 담을 배열 변수 선언

	public static void main(String[] args) {
		init(); //

		int sum = 0;  // 총점 저장 변수
		double max = 0;  // 최고점 저장 변수
//		String maxName = "";
		Student maxStd = new Student(); // **인스턴스 생성
		// → 최고점수를 가진 학생의 정보를 저장할 빈 학생 객체 생성

		// 배열의 값을 출력
		for (int i = 0; i < stdAry.length; i++) {
			// 학생의 이름과 점수를 출력
			System.out.printf("이름:%s 점수:%d \n", stdAry[i].studentName, stdAry[i].score);
			sum += stdAry[i].score; // 총점 계산

			
			if (stdAry[i].height > max) { // 가장큰키, 키큰학생							
				max = stdAry[i].height;
				
				// 최고점 학생 정보
				maxStd.studentName = stdAry[i].studentName;
				maxStd.score = stdAry[i].score;
				maxStd.height = stdAry[i].height;
				maxStd.gender = stdAry[i].gender;
			}
		}

		// 평균 계산 (1.0을 곱해서 정수 나눗셈을 실수 나눗셈으로 바꿈)
		double avg = 1.0 * sum / stdAry.length; // 평균을 구하는 공식.
		// 출력 포맷 설정 (%.2f는 소수 둘째자리까지 출력)
		String strFmt = "키큰학생:%s, 점수:%d, 키:%.1f 평균:%.2f";

		// 최고점 학생 정보와 평균 출력
		System.out.printf(strFmt, maxStd.studentName, maxStd.score,maxStd.height, avg);
	}

	public static void init() { // stuAry 샘플데이터 담는 용도.

		// 각각의 학생 인스턴스를 생성하고 이름과 점수 입력
		Student s1 = new Student(); // 인스턴스 생성.
		s1.studentName = "홍길동";
		s1.score = 80;
		s1.height =170.8;
		s1.gender=Gender.MALE; //"남자 "Man"
		
		Student s2 = new Student();// 인스턴스 생성.
		s2.studentName = "김민t서";
		s2.score = 85;
		s2.height =165.7;
		s2.gender=Gender.FEMALE; 

		Student s3 = new Student();// 인스턴스 생성.
		s3.studentName = "박철민";
		s3.score = 90;
		s3.height =180.3;
		s3.gender=Gender.MALE;
		// stdAry 배열에 3명의 학생을 한꺼번에 넣음
		stdAry = new Student[] { s1, s2, s3 }; // 선언+대입을 동시에 할 때만 OK
		// → new Student[] { ... } 는 배열을 만드는 방식이에요!
	}

	public static void test() {
		// 홍길동, 80
		int num1 = 90; // 그냥 정수 변수 하나 만들어 놓은 것 (여기선 안 씀)

		Student s1 = new Student(); // 인스턴스 생성.
		s1.studentName = "홍길동";
		s1.score = 80;

		// 김민규,85
		Student s2 = new Student();
		s2.studentName = "김민규";
		s2.score = 85;

		// 홍길동의 점수를 90점으로 변경을 하겠습니다.
		s1.score = 90; // 위에서 만든 s1 점수를 변경

		// 학생정보를 김민규와 홍길동을 한번에 담는 방법
		// 학생정보를 배열에 저장
		Student[] students = { s1, s2 };
		students[0].studentName = "홍길도";
		// students[0] == s1

		System.out.printf("이름: %s 점수:%d\n ", s1.studentName, s1.score);

	}// end if test
}// end of class