package com.yedam.api;

import java.io.UnsupportedEncodingException;

public class exam {
	public static void main(String[] args) {
		
		test2();
	}

	public static void test1() {
		String strVar1 = new String("신민철");
		String strVar2 = "신민철";
		// strVar1: new 연산자로 만든 새로운 String 객체
		// strVar2: 문자열 리터럴로 만든 공유된 상수 문자열

		if (strVar1 == strVar2) {
			System.out.println("같은 String 객체를 참조");
		} else {
			System.out.println("다른 String 객체를 참조");
		}
		// String 클래스에서 equals()는 문자열 내용이 같은지 비교함
		if (strVar1.equals(strVar2)) {
			System.out.println("같은 문자열을 가짐");
		} else {
			System.out.println("다른 문자열을 가짐 ");
		}
	}

	//바이트로 배열
	public static void test2() {
		String str = "안녕하세요";
		
		//EUC-KR	옛날 방식, 한글 1글자 = 2바이트
		//UTF-8	요즘 표준, 한글 1글자 = 3바이트

		byte[] bytes1 = str.getBytes();
		System.out.println("bytes1.length:" + bytes1.length);
		String str1 = new String(bytes1);
		System.out.println("bytes1->String:" + str1);

		try {
			byte[] bytes2 = str.getBytes("EUC-KR");
			System.out.println("bytes2.length:" + bytes2.length);
			String str2 = new String(bytes2, "EUC-KR");
			System.out.println("bytes2->String:" + str2);

			byte[] bytes3 = str.getBytes("UTF-8");
			System.out.println("bytes3.length:" + bytes3.length);
			String str3 = new String(bytes3, "UTF-8");
			System.out.println("bytes3->String:" + str3);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
