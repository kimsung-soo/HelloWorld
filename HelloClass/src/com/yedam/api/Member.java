package com.yedam.api;

public class Member extends Object {
	String memberName;
	int age;

	public Member() {
	}

	public Member(String memberName, int age) {
		this.memberName = memberName;
		this.age = age;
	}

	@Override
	public int hashCode() {
		return age;

	}

	// 이름,나이 =>같으면 논리적으로 동등한건지 체크.
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member) { // 매개값의 유형이 Member 임.
			Member member = (Member) obj; // 케스팅
			return this.memberName == member.memberName && this.age == member.age;
		}

		return false;
	}

	public String toString() {
		return "이름: " + memberName + ", 나이:" + age;

	}
}
