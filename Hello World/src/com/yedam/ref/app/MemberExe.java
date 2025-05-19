package com.yedam.ref.app;

import java.util.Scanner;

public class MemberExe {
	static Member[] user = null;

	public static void main(String[] args) {

		boolean run = true;
		Scanner scanner = new Scanner(System.in);

		System.out.print("등록할 회원 수를 입력하세요 >> ");
		int memberCount = Integer.parseInt(scanner.nextLine());
		user = new Member[memberCount];

		while (run) {
			System.out.println("---------------------------------------");
			System.out.println("1.회원추가 2.회원수정 3.회원삭제 4.회원조회 5.종료");
			System.out.println("---------------------------------------");
			System.out.print("선택>> ");
			int menu = Integer.parseInt(scanner.nextLine());

			if (menu == 1) {

				for (int i = 0; i < user.length; i++) {
					if (user[i] == null) {
						System.out.println("아이디 >>");
						String userid = scanner.nextLine();
						System.out.printf("이름 >>");
						String username = scanner.nextLine();
						System.out.printf("전화번호 >>");
						String tel = scanner.nextLine();
						System.out.printf("포인트 >>");
						int point = Integer.parseInt(scanner.nextLine());

						Member newMember = new Member();
						newMember.ID = userid;
						newMember.Name = username;
						newMember.Tel = tel;
						newMember.point = point;

						user[i] = newMember;
						System.out.println("회원이 추가되었습니다.");
						break;
					}
				}

			} else if (menu == 2) {
				// 회원 수정
				System.out.print("수정할 아이디>> ");
				String fixId = scanner.nextLine();

				for (int i = 0; i < user.length; i++) {
					if (user[i] != null && user[i].ID.equals(fixId)) {
						System.out.print("새 전화번호>> ");
						user[i].Tel = scanner.nextLine();
						System.out.println("전화번호가 수정되었습니다.");
						break;
					}
				}

			} else if (menu == 3) {

			} else if (menu == 4) {
				System.out.println("조회 할 이름>>");
				{
					String searchname = scanner.nextLine();
					for (int i = 0; i < user.length; i++) {
						if (user[i] != null && user[i].Name.equals(searchname)) {
							System.out.println("아이디: " + user[i].ID + ", 이름: " + user[i].Name + ", 전화번호: " + user[i].Tel
									+ ", 포인트: " + user[i].point);}				
					}
				}
			} else if (menu == 5) {
				run = false;
			}
		} // end of while

		System.out.println("프로그램 종료");
	}// end of main
}
