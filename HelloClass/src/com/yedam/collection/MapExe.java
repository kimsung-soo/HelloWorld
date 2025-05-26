package com.yedam.collection;
/*
 * Map 컬렉션
 * {키:값} 추가.
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//학생 (이름,점수)
class Student2 {
	private String studentName;
	private int score;

	// 생성자
	public Student2(String studentName, int score) {
		this.studentName = studentName;
		this.score = score;
	}
	//haschCode, equals. => 이름, 점수 같으면 동등객체
	@Override
	public int hashCode() {
		return score;	
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student2) {
			Student2 std =(Student2) obj;
			return this.studentName.equals(std.getStudentName())
					&& this.score == std.getScore();
		}
		return false;
	}

	// getter
	public String getStudentName() {
		return studentName;
	}

	public int getScore() {
		return score;
	}
}

public class MapExe {
	public static void main(String[] args) {
		// 반, 학생
		Map<Student2, String> map;
		map = new HashMap<Student2, String>();

		map.put(new Student2("홍길동", 70), "1반");
		map.put(new Student2("김민규", 80), "2반");

		map.put(new Student2("박철승", 75), "1반");
		map.put(new Student2("최성철", 85), "2반");

		// 반복문
		String keyword = "홍길동";
		int score = 70;
		//객체를 비교연산자(==)로 비교할 경유 false;
		System.out.println(new Student2(keyword,score) == new Student2(keyword,score));
						
			if(map.containsKey(new Student2(keyword,score))) {				
				System.out.println("반: "+ map.get(new Student2(keyword,score)));
			}
			
		}
		
		
		
		
	//	Set<Student2> set = map.keySet();
		// for(Student2 std : set) {
		// }
//		Iterator<Student2> iter = set.iterator();
//		while (iter.hasNext()) {
//			Student2 std = iter.next(); // 획득
//			if(std.getStudentName().equals(keyword)) {
//				System.out.println("점수: "+std.getScore());
//				//score,이름
//				String cls =map.get(std);
//				System.out.printf("이름: %s, 점수: %d, 반: %s\n" , std.getStudentName(),std.getScore(),cls);
//			}
//		}
//	}

	public static void exe2() {
		// Map<String,String>
		Map<String, String> loginMap = new HashMap<String, String>();

		// map에 값 추가하기 (아이디, 비밀번호)
		loginMap.put("user01", "1111");
		loginMap.put("user02", "2222");
		loginMap.put("user03", "3333");

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("아이디를 입력>>");
			String id = scanner.nextLine(); // 사용자로부터 아이디 입력 받기
			System.out.println("비밀변호를 입력>>");
			String pw = scanner.nextLine(); // 사용자로부터 비밀번호 입력 받기

			if (loginMap.containsKey(id)) { // 키가 존재 => 아이디가 존재하면
				// 아이디 있음 → 비밀번호 체크
				if (loginMap.get(id).equals(pw)) { // 비밀번호도 맞는지 확인
					System.out.println("로그인 되었습니다.");
					break; // 로그인 성공 시 반복 종료
				} else {
					System.out.println("입력하신 비밀번호가 일치하지 않습니다..");
				}
			} else {
				System.out.println("입력하신 아이디가 없습니다");
			}
		} // end of while

		// 자바 객체(map) → JSON 문자열로 출력
		Gson gson1 = new GsonBuilder().setPrettyPrinting().create();
		String json1 = gson1.toJson(loginMap); // 아이디 비번 map을 JSON으로 변환
		System.out.println(json1); // JSON 형태 출력

		// Map이라는 자료통 만들기!
		// <String, Integer>는 (문자 : 숫자) 형태로 저장하겠다는 뜻!
		Map<String, Integer> scoreMap = new HashMap<String, Integer>();

		// map에 값 추가하기
		scoreMap.put("홍길동", 80); // "홍길동" 이름에 80점 저장
		scoreMap.put("김민수", 70); // "김민수" 이름에 70점 저장
		scoreMap.put("홍길동", 85); // "홍길동" 이름에 85점 저장 → 기존 값 80이 85로 덮어쓰기 됨!
		scoreMap.put("박철민", 95); // "박철민" 이름에 95점 저장

		// 자바 객체(map) -> JSON 문자열 출력
		Gson gson2 = new GsonBuilder().setPrettyPrinting().create();
		String json2 = gson2.toJson(scoreMap);
		System.out.println(json2); // JSON 출력

		// scoreMap.remove("홍길동"); // 삭제. → 주석 풀면 "홍길동" 데이터가 지워짐

		Integer score = scoreMap.get("김민수"); // score 변수에 70이 저장됨
		score = scoreMap.get("홍길동"); // 중복은 되지 않는다 → 마지막에 넣은 85가 저장되어 있음
		System.out.println(score); // 출력: 85

		// 반복
		Set<String> keyset = scoreMap.keySet();
		// map 안에 있는 모든 키(이름들)만 모아서 Set으로 만듦

		// 반복자(Iterator) 만들기
		Iterator<String> iter = keyset.iterator();
		// 키 목록에서 하나씩 꺼낼 수 있는 도구

		// 반복문 시작: 키가 더 있으면 계속 반복
		while (iter.hasNext()) {
			String key = iter.next(); // 다음 키 꺼냄
			Integer value = scoreMap.get(key); // 키에 해당하는 값(점수) 가져오기
			System.out.printf("키:%s , 값:%d\n", key, value);
		}

		// {키: 값} 쌍 전체를 Entry 형태로 반환
		Set<Entry<String, Integer>> entryset = scoreMap.entrySet();
		Iterator<Entry<String, Integer>> iter2 = entryset.iterator();
		while (iter2.hasNext()) {
			Entry<String, Integer> entry = iter2.next();
			System.out.printf("키:%s , 값:%d\n", entry.getKey(), entry.getValue());
		}

	} // end of main
} // end of class