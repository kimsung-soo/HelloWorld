package com.yedam.collection;

import java.util.ArrayList;
import java.util.List;

import com.yedam.member.Member;
/*
 * 인덱스를 사용해서 객체를 관리
 * 순서를 가지고 
 */



public class ListExe {
	public static void main(String[] args) {
		List<Student> numbers = new ArrayList<>();

		// 점수 10개 생성
		for (int i = 1; i <= 10; i++) {
			int score = (int) (Math.random() * 91) + 10; // 10~100
			numbers.add(new Student(1000 + i, score));
		}

		// 점수 출력
		for (Student s : numbers) {
			System.out.println("점수: " + s.getScore());
		}

		// 합계 및 평균 계산
		int sum = 0;
		for (int i = 0; i < numbers.size(); i++) {
			sum += numbers.get(i).getScore();
		}
		double avg = 1.0 * sum / numbers.size();

		// 출력
		System.out.printf("점수의 합: %d, 평균: %.1f\n", sum, avg);
	}


	

	public static void exe2() {
		List<Member> members = new ArrayList<>();
		Member member = new Member("김홍동", 20);
		members.add(new Member("홍길동", 10));
		members.add(member);
		members.add(new Member("김홍도", 30));

		// 삭제
		members.remove(member);

		String search = "김홍동";
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).memberName.equals(search)) {
				members.remove(i);
			}
		}

		for (int i = 0; i < members.size(); i++) {
			System.out.println(members.get(i).toString());
		}
	}

	public static void exe1() {
		// int[] ary ={10,20,30.4}
		// 인터페이스 -구현클래스
		List<String> list = new ArrayList<String>();
		list.add("10");
		list.add(new String("Hello"));

		list.add(1, "20"); // 1 = 위치지정

		// 삭제
		list.remove(0);

		// 변경
		list.set(1, "world");

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		for (Object item : list) {
			System.out.println(item);
		}
	}

}
