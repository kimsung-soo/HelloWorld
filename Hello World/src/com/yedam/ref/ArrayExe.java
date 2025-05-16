package com.yedam.ref;

import java.util.Scanner;

public class ArrayExe {
    public static void main(String[] args) {
        // strAry();
        // deleteAry();
        friendApp();
    }

    public static void friendApp() {
        Scanner scn = new Scanner(System.in);
        String[] friendAry = new String[10]; // 담는곳

        boolean run = true;
        while (run) {
            System.out.println("1.추가 2.목록 3.삭제 4.종료");
            int menu = Integer.parseInt(scn.nextLine()); // 메뉴를 선택하겠다는 의미.

            switch (menu) {
                case 1:
                    System.out.println("이름을 입력>> ");
                    String name = scn.nextLine(); // 배열에 추가하는 방법.

                    for (int i = 0; i < friendAry.length; i++) {
                        if (friendAry[i] == null) {
                            friendAry[i] = name;
                            System.out.println("추가되었습니다.");
                            break;
                        }
                        
                    }
                           break;
                

                case 2: // 목록
                    for (int i = 0; i < friendAry.length; i++) {
                        if (friendAry[i] != null) {
                            System.out.printf("[%d]번째 이름: %s\n", i + 1, friendAry[i]);
                        }
                    }
                    break;

                case 3:
                    System.out.println("삭제 목록>>");
                    String delet = scn.nextLine();

                    for (int i = 0; i < friendAry.length; i++) {
                        if (friendAry[i] != null && friendAry[i].equals(delet)) {
                            friendAry[i] = null;
                        } else {
                            System.out.println("찾는 이름이 없습니다.");
                        }
                        break;
                    }
                    break;

                case 4:
                    run = false;
                    System.out.println("프로그램을 종료합니다.");
                    break;
            }
        }
        System.out.println("end of prog");
    }

    public static void deleteAry() {
        Scanner scn = new Scanner(System.in);
        String[] stringAry = new String[10];
        stringAry[0] = "홍길동";
        stringAry[1] = "김친구";
        stringAry[2] = "김태완";
        stringAry[3] = "김태희";

        System.out.println("삭제할 친구 이름 >>");
        String name = scn.nextLine();

        for (int i = 0; i < stringAry.length; i++) {
            if (stringAry[i] != null && stringAry[i].equals(name)) {
                stringAry[i] = null;
            }
        }

        for (int i = 0; i < stringAry.length; i++) {
            if (stringAry[i] != null) {
                System.out.printf("stringAry [%d]번째의 값: %s\n", i, stringAry[i]);
            }
        }

        System.out.println("end of prog");
    }

    public static void strAry() {
        Scanner scn = new Scanner(System.in);
        String[] stringAry = new String[10];

        while (true) {
            System.out.println("이름을 입력>> ");
            String name = scn.nextLine();

            if (name.equals("quit")) {
                break;
            }

            for (int i = 0; i < stringAry.length; i++) {
                if (stringAry[i] == null) {
                    stringAry[i] = name;
                    System.out.println("입력성공.");
                    break;
                }
            }
        }

        for (int i = 0; i < stringAry.length; i++) {
            if (stringAry[i] != null) {
                System.out.printf("stringAry [%d]번째의 값: %s\n", i, stringAry[i]);
            }
        }

        System.out.println("end of prog");
    }
}
