package com.yedam.api;

public class StringTest {
    public static void main(String[] args) {
        test1();
        test2();
    }

    // 파일 확장자와 파일 이름 추출
    public static void test1() {
        String[] files = {
            "c:/temp/orange.jpg",
            "d:/storage/test/grape.jpeg",
            "d:/img/melon.png"
        };

        for (int i = 0; i < files.length; i++) {
            String ext = StringUtil.getExtName(files[i]);
            String name = StringUtil.getFileName(files[i]);
            System.out.printf("파일명: %s, 확장자: %s\n", name, ext);
        }
    }

    // 성별 판별
    public static void test2() {
        String[] samples = {
            "9503061234567",
            "990603 2345678",
            "030502-3456789"
        };

        for (int i = 0; i < samples.length; i++) {
            String gender = StringUtil.getGender(samples[i]);
            System.out.printf("%s는 %s입니다.\n", samples[i], gender);
        }
    }
}
