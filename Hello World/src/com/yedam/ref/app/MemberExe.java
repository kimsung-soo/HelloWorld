package com.yedam.ref.app;

import java.util.Scanner; // 사용자 키보드 입력을 받기 위해 필요한 클래스

// 회원 관리 프로그램 시작
public class MemberExe {
    public static void main(String[] args) {
        boolean run = true; // 프로그램을 계속 실행할지 여부를 저장하는 변수
        Member[] members = new Member[10]; // 최대 10명의 회원 정보를 저장할 배열

        Scanner scn = new Scanner(System.in); // 키보드 입력을 받을 준비

        while (run) { // run이 true일 동안 계속 반복 (메뉴 계속 보여주기)
            // 메뉴 출력
            System.out.println("--------------------------------------------");
            System.out.println("1.추가 2.수정 3.삭제 4.조회 5.종료");
            System.out.println("--------------------------------------------");
            System.out.print("선택>> ");

            int selectNo = Integer.parseInt(scn.nextLine()); // 메뉴 번호 입력받기 (문자열 → 숫자)

            switch (selectNo) {
                case 1: // ▶ 1. 회원 추가
                    System.out.print("아이디를 입력>> ");
                    String id = scn.nextLine(); // 사용자로부터 아이디 입력받음
                    System.out.print("이름를 입력>> ");
                    String name = scn.nextLine(); // 이름 입력받음
                    System.out.print("전화번호를 입력>> ");
                    String telNo = scn.nextLine(); // 전화번호 입력받음
                    System.out.print("포인트를 입력>> ");
                    int point = Integer.parseInt(scn.nextLine()); // 포인트 입력받음

                    // 새로운 회원 정보를 담을 객체 생성
                    Member member = new Member();
                    member.ID = id; // 아이디 저장
                    member.Name = name; // 이름 저장
                    member.Tel = telNo; // 전화번호 저장
                    member.point = point; // 포인트 저장

                    // members 배열에 빈 자리(null)를 찾아서 회원 추가
                    for (int i = 0; i < members.length; i++) {
                        if (members[i] == null) { // 비어있는 칸 찾기
                            members[i] = member; // 그 자리에 회원 정보 넣기
                            System.out.println("등록완료.");
                            break; // 추가했으면 반복 중단
                        }
                    }
                    break;

                case 2: // ▶ 2. 회원 전화번호 수정
                    System.out.print("아이디를 입력>> ");
                    id = scn.nextLine(); // 수정할 회원의 아이디 입력
                    System.out.print("전화번호를 입력>> ");
                    telNo = scn.nextLine(); // 새로운 전화번호 입력

                    // 배열에서 해당 아이디를 가진 회원을 찾아서 전화번호 수정
                    for (int i = 0; i < members.length; i++) {
                        if (members[i] != null) { // null이 아닌 회원만 검사
                            if (members[i].ID.equals(id)) { // 아이디가 일치하면
                                members[i].Tel = telNo; // 전화번호 수정
                                System.out.println("수정완료.");
                            }
                        }
                    }
                    break;

                case 3: // ▶ 3. 회원 삭제
                    System.out.print("아이디를 입력>> ");
                    id = scn.nextLine(); // 삭제할 회원의 아이디 입력

                    // 해당 아이디를 가진 회원을 null로 만들어 삭제
                    for (int i = 0; i < members.length; i++) {
                        if (members[i] != null) {
                            if (members[i].ID.equals(id)) {
                                members[i] = null; // 배열에서 해당 회원 제거
                                System.out.println("삭제완료.");
                            }
                        }
                    }
                    break;

                case 4: // ▶ 4. 회원 조회
                    System.out.print("이름를 입력>> ");
                    name = scn.nextLine(); // 조회할 이름 입력

                    // 출력 헤더
                    System.out.printf("%-10s %-5s %-15s\n", "UserId", "회원명", "TelNo");

                    // 배열 전체를 돌며 이름이 일치하는 회원 정보 출력
                    for (int i = 0; i < members.length; i++) {
                        if (members[i] != null &&
                            (name.equals("") || name.equals(members[i].Name))) {
                            // 이름이 일치하거나, 이름이 비어 있으면 출력 (전체 조회)
                            System.out.printf("%-10s %-5s %-15s\n",
                                    members[i].ID,
                                    members[i].Name,
                                    members[i].Tel);
                        }
                    }
                    break;

                case 5: // ▶ 5. 종료
                    run = false; // while문을 빠져나가게 하기 위해 false로 설정
                    break;

                default: // 그 외 잘못된 숫자 입력 시
                    System.out.println("메뉴를 다시 선택하세요.");
            } // end of switch
        } // end of while

        System.out.println("*** end of prog ***"); // 프로그램 종료 메시지
    } // end of main
}
