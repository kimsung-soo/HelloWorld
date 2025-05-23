package com.yedam.api;

public class StringUtil {

    // 성별을 판별하는 메서드
    public static String getGender(String string) {
        string = string.replace(" ", "").replace("-", ""); // 하이픈, 공백 제거
        if (string.length() < 7) return "잘못된 입력";

        char sex = string.charAt(6);
        String result = "";

        switch (sex) {
            case '1': case '3': case '5':
                result = "남성";
                break;
            case '2': case '4': case '6':
                result = "여성";
                break;
            default:
                result = "알 수 없음";
        }

        return result;
    }

    // 확장자 추출
    public static String getExtName(String file) {
        return file.substring(file.lastIndexOf(".") + 1);
    }

    // 파일 이름만 추출
    public static String getFileName(String file) {
        int lastSlash = file.lastIndexOf("/");
        return file.substring(lastSlash + 1);
    }
}
