package com.yedam;
/*
 * 라이브러리 클래스.
 */
public class Student {
	//필드(속성)
	private int studentNo;  //학생 전화번호
	private String studentName; //학생이름
	private double height;
	private int engScore; //영어점수
	private int mathScore; //수학점수
	
	//생성자(객체:instance의 초기화)
	public Student() {   //클래스 이름
		// 매개값이 없는 생성자 => 기본생성자.
		// 컴파일러가 생성.
	}
	
	 public Student(int studentNo,String studentName) {
		 this.studentNo= studentNo; //첫번째 매개값은 학생번호 할당
		 this.studentName=studentName;//첫번째 매개값은 학생이름 할당
	 }
	
	 public Student(int studentNo,int engScore,int mathScore) {
		 
		 this.studentNo =studentNo;
		 this.engScore  =engScore;
		 this.mathScore =mathScore;
	 }
	 
	//메소드(기능)
	void study() {
		System.out.println("공부를 합니다.");
	}
	void introduce() {
		System.out.printf("학번은 %d 이고 이름은 %s\n", studentNo,studentName);
	}
	
//영어,수학점수
	void setEngScore(int engScore) {
		if (engScore <0 ||engScore >100) {
			return;
		}
		this.engScore = engScore;
		
	}void setMathScore(int mathScore){
		if (mathScore <0 || mathScore >100) {
			return;
		}
		this.mathScore = mathScore;
	}	
		int getMathScore() {
			return mathScore;
		}
		int getEngScore() {
			return engScore;
		
//학생명 학번 set:설정 get:가져오는
	}void setStudentName(String studentName){
		this.studentName = studentName;
		
	}void setStudentNo(int studentNo ) {
		this.studentNo =studentNo;
	}
	int getStudentNo() {
		return studentNo;
	}
	String getStudentName() {
		return studentName;
	}
}
		
