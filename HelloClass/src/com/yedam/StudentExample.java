package com.yedam;
/*
 * 실행클래스
 */

public class StudentExample {
	public static void main(String[] args) {
		// 클래스|| 변수 || 인스턴스 생성.(객체)
		Student student = new Student();  //new Student() 생성자를 의미한다                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
//		student.studentNo = 1001;
		student.setStudentNo (1001);
//		student.studentName = "홍길동";
		student.setStudentName ("홍길동");
//		student.engScore=80; //속성값에 대입		
		student.setEngScore(80);//메소드의 매개값
//		student.mathScore=85;
		student.setMathScore(85);
		student.study();
		student.introduce();
		System.out.println("이름: "+ student.getStudentName() 
						+", 영어: "+ student.getEngScore() 
						+", 수학: "+student. getMathScore());

		Student student2 = new Student(1002 ,"김민규");
//		student2.studentNo = 1002;
//		student2.studentName = "김민규";
//		student2.engScore=-50;
		student2.setEngScore(-50);
//		student2.mathScore=-80;
		student2.setMathScore(-80);
		student2.study();
		student2.introduce();
		
		student.setStudentName("박민규");
		student2.introduce();
	}

}
