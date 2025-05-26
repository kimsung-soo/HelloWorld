package com.yedam.collection;

public class Student {
	private int studendNo; // 1001.1002.1003....1010
	private int score;
	//constructor
	public Student(int studendNo, int score) {
		this.studendNo = studendNo;
		this.score = score;
	}
	//getter.
	public int getScore() {
		return score;
	}
	public int getstudendNo() {
		return studendNo;
	}
	public void setScore(int score) {
		this.score =score;
	}
}
