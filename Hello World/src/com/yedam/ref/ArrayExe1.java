package com.yedam.ref;

public class ArrayExe1 {

	public static void main(String[] args) {
		//math.random 활용해서 10점부터~100 점 사이의 점수을 생성.
		//학생 10명의 점수를 생성해서 학생점수의 평균을 구하고 최고점수 구하기.
		// scoreAry 변수명 활용하기.
		test4();
	}//end of main
	
	public static void test4() {
	    
	    // 10명의 학생 점수를 저장할 정수 배열 생성
	    int[] ScoreAry = new int[10];
	    
	    // 총점을 저장할 변수 초기화 (저장할 공간을 만들기)
	    int sum = 0;

	    // 배열에 10명의 점수를 난수로 생성하여 저장하고 출력
	    for (int i = 0; i < ScoreAry.length; i++) {
	        // 10부터 100까지의 난수를 생성하여 점수로 저장
	        ScoreAry[i] = (int) (Math.random() * 91) + 10;
	        
	        // 생성된 점수를 총합에 더함
	        sum += ScoreAry[i];
	        
	        // 각 학생의 점수를 출력
	        System.out.printf("%d번째 학생의 점수: %d\n", i, ScoreAry[i]);
	    }

	    // 최대값을 저장할 변수 초기화
	    int max = 0;

	    // 배열을 순회하면서 최대값 찾기
	    for (int j = 0; j < ScoreAry.length; j++) {
	        // 현재 max보다 배열의 요소가 크면 max를 해당 값으로 갱신
	        if (max < ScoreAry[j]) {
	            max = ScoreAry[j];
	        }
	    }

	    // 최대값 출력
	    System.out.printf("최대값은 %d\n", max);

	    // 평균값 계산 및 출력
	    int avg = 0;
	    avg = sum / ScoreAry.length;  // 정수 나눗셈이므로 소수점 이하는 버려짐
	    System.out.printf("평균 값: %d", avg);
	}

				

	
	
	
	
	
	
	
	
	
	
	
	public static void test3() {
		int[] intAry = { 10, 17, 22, 31, 55, 24 };
		int  temp =0;
		
		// 정렬 시도
        // 바깥쪽 반복문: 배열 전체를 여러 번 반복해서 비교 (총 n-1번 반복)
		for(int j=0; j <intAry.length -1; j++)
		for(int i =0; i<intAry.length -1; i++) {
			//큰값 기준으로 위치 변경
		if(intAry[0] < intAry[i+1]) {
			temp = intAry[i];
			intAry[0] =intAry[i + 1];
			intAry[i+1] =temp;
			}
		} 
		
		//출력
		for (int i =0; i<intAry.length; i++) {
			System.out.printf("i: %d, 값:%d\n",i ,intAry[i]);
		}
		
		//최고값.
		int max =0;
		for (int i =0; i<intAry.length; i++) {
			//max와 배열요소를 비교. 큰값을 max에 저장.
			 if (max < intAry[i]) {
				 max =intAry[i];
			 }
		}
		System.out.printf("최대값은 %d\n",max);
		
		if(max !=0) {
		return;
		}
		
		
		
		//합
		int sum = 0;
		int cnt = 0; //횟수
		//for (int i = 0; i < intAry.length; i += 2) {
		for (int i = 0; i < intAry.length; i++) {
			if(intAry[i] % 2 ==0) {				
				sum += intAry[i];
				cnt++;
				System.out.printf("sum: %d, i: %d, 값: %d\n", sum, i, intAry[i]);
			}

		}
		double avg = sum / cnt;
	System.out.printf("평균: %.1f",avg);
		
	}// end of test3

	public static void test() {
		// 3,4,5,6중에 선택

		// 3번문제

		while (true) {
			int num1 = (int) (Math.random() * 6) + 1;
			int num2 = (int) (Math.random() * 6) + 1;

			System.out.print(num1);
			System.out.println(num2);

			if (num1 + num2 == 5) {
				break;
			}

		} // end while
		System.out.println("end of prog.");

	}// end of test

	public static void test1() {

		// 바깥쪽 for문: 줄 수를 나타냄 (총 6줄, i는 0부터 5까지)
		for (int i = 0; i <= 5; i++) {

			// 안쪽 for문: 각 줄에서 출력할 '*' 개수 (j는 0부터 i보다 작을 때까지)
			for (int j = 0; j < i; j++) {
				System.out.print("*"); // 별 하나 출력 (줄바꿈 없이)
			}

			// 안쪽 for문이 끝나고 나면 줄바꿈 (다음 줄로 이동)
			System.out.println("");
		}

		// 모든 줄 출력이 끝난 후 프로그램 종료 메시지 출력
		System.out.println("end of prog.");
	} // end of test1

	public static void test2() {
		// 6번 문제: 오른쪽 정렬된 삼각형 출력

		// 바깥쪽 반복문: 총 4줄 출력
		for (int outer = 1; outer <= 4; outer++) {

			// 안쪽 반복문: 한 줄당 4개의 칸 처리
			for (int inner = 1; inner <= 4; inner++) {

				// 두 인덱스의 합이 5 이상이면 '*' 출력
				if (outer + inner >= 5) {
					System.out.print("*");
				} else {
					// 그렇지 않으면 공백(스페이스) 출력
					System.out.print(" ");
				}
			}

			// 줄바꿈
			System.out.println();
		}
	}

}// end of class
