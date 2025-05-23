package com.yedam.api;

import java.util.HashSet;
import java.util.Set;


public class ObjectEXe {
	
	public static void main(String[] args) {
		//배열[여러건저장] => 컬렉션(1.List 2.Set 3.Map)
		int[] ary =new int[5]; //	정수 5개 저장 가능한 배열 생성
		//확장된 for
		for (int num:ary) {
			System.out.println(num);
		}
		/*
		 * | 배열 vs Set |
		|-------------|--------|
		| 크기 고정 | 크기 자유롭게 추가 가능 |
		| 중복 허용 | 중복 안 됨 |
		| 순서 보장 | 순서 없음 (무작위처럼 보임) |
		 */
		
		Set<Integer> set = new HashSet<Integer>(); //정수형 Set(중복 불가, 순서 없음) 생성
		set.add(10); //Set에 값 추가 (중복되면 무시됨)
		set.add(20);
		set.add(30);
		set.add(10);
		
		//선언하는 클래스 Member
		Set<Member> members = new HashSet<Member>(); //값이 같아야 된당.
		members.add(new Member("홍길동",10));
		members.add(new Member("김민석",12));
		members.add(new Member("홍길동",10));
		for(Member num :members) {			
			System.out.println(num.toString());
		}
		
		for(Integer num:set) {
			System.out.println(num);
		}
	}	
		
	public static void exe1() {
		int num1 =10, num2=20;
		System.out.println(num1==num2);
		
		String str1 = new String("Hello");
		String str2 = new String("Hello");
		System.out.println(str1.equals(str2));
		
		
		Member mem1 = new Member(); //인스턴스
		mem1.memberName ="홍길동";
		mem1.age=10;
		
		Member mem2 = new Member();//주소를 비교
		mem2.memberName ="홍길동";
		mem2.age=10;
		
		System.out.println(mem1.equals(mem2)); // Object class equals로 비교
	}
}
