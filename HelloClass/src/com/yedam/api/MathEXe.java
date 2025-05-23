package com.yedam.api;

public class MathEXe {
	public static void main(String[] args) {
		System.out.println(Math.abs(-100)); //절대값
		
		System.out.println(Math.floor(12.3)); //버림값
		System.out.println(Math.ceil(12.3)); //올림값
		System.out.println(Math.round(12.3)); //반올림
		
		//크기비교
		System.out.println(Math.max(Math.ceil(12.3), Math.round(12.3)));
	}
}
