package com.yedam.collection.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberExe {
    public static void main(String[] args) {
        boolean run = true;
        List<Member> members = new ArrayList<>();  // ← 오타 수정

        Scanner scn = new Scanner(System.in);

        while (run) {
            System.out.println("--------------------------------------------");
            System.out.println("1.추가 2.수정 3.삭제 4.조회 5.종료");
            System.out.println("--------------------------------------------");
            System.out.print("선택>> ");

            int selectNo = Integer.parseInt(scn.nextLine());

            switch (selectNo) {
                case 1: // 추가
                    System.out.print("아이디를 입력>> ");
                    String id = scn.nextLine();
                    System.out.print("이름를 입력>> ");
                    String name = scn.nextLine();
                    System.out.print("전화번호를 입력>> ");
                    String telNo = scn.nextLine();
                    System.out.print("포인트를 입력>> ");
                    int point = Integer.parseInt(scn.nextLine());

                    members.add(new Member(id, name, telNo, point));
                    System.out.println("등록완료.");
                    break;

                case 2: // 수정
                    System.out.print("아이디를 입력>> ");
                    id = scn.nextLine();
                    System.out.print("전화번호를 입력>> ");
                    telNo = scn.nextLine();

                    boolean found = false;
                    for (Member mem : members) {
                        if (mem.getMemberId().equals(id)) {
                            mem.setPhone(telNo);
                            System.out.println("수정완료.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("해당 아이디를 찾을 수 없습니다.");
                    }
                    break;

                case 3: // 삭제
                    System.out.print("아이디를 입력>> ");
                    id = scn.nextLine();

                    Member toRemove = null;
                    for (Member mem : members) {
                        if (mem.getMemberId().equals(id)) {
                            toRemove = mem;
                            break;
                        }
                    }
                    if (toRemove != null) {
                        members.remove(toRemove);
                        System.out.println("삭제완료.");
                    } else {
                        System.out.println("해당 아이디를 찾을 수 없습니다.");
                    }
                    break;

                case 4: // 조회
                    System.out.print("이름를 입력>> ");
                    name = scn.nextLine();

                    System.out.printf("%-10s %-5s %-15s\n", "UserId", "회원명", "TelNo");
                    for (Member mem : members) {
                        if (name.equals("") || mem.getMemberName().equals(name)) {
                            System.out.printf("%-10s %-5s %-15s\n",
                                    mem.getMemberId(), mem.getMemberName(), mem.getPhone());
                        }
                    }
                    break;

                case 5: // 종료
                    run = false;
                    break;

                default:
                    System.out.println("메뉴를 다시 선택하세요.");
            }
        }

        System.out.println("*** end of prog ***");
        scn.close();
    }
}
