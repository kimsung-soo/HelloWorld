package com.yedam.inheritance;
/*
 * 추상클래스 (Animal):인스턴스 생성X
 *                   추상메소드
 * 자식클래스:Bird, Fish.
 */
public abstract class Animal {
	String kind; 
	
	public void breathe() {
		System.out.println("숨을 쉽니다.");
	}
	
	//추상메소드.:자식클래스에서 반드시 재정의를 해야한다.
	public abstract void sound();
}
