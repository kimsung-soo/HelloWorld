package com.yedam.ref;

//*
//* 2차원 배열
//* intAry [2][3]
//*

public class ArrayExe2 {
    public static void main(String[] args) {
        // 2차원 배열 선언과 동시에 값 초기화 (중괄호 안에 배열이 2개 들어있음)
        // intAry[0] = {17,22,31,55}; => 첫 번째 행, 요소 4개
        // intAry[1] = {28,38,12};    => 두 번째 행, 요소 3개
        int[][] intAry = {{17,22,31,55}, {28,38,12}};
        
        // intAry[0] = {17,22,31}; intAry[0][0] = 17 intAry[0][1] = 22
        // intAry[1] = {28,38,12}; intAry[1][0] = 28 intAry[1][1] = 38
        // ↑ 위에 주석은 배열 안 값들을 설명한 것 (행과 열 위치)

        // intAry[0][2] = 44; => 0행 2열 값을 44로 바꿔줌 (원래는 31이었음)
        intAry[0][2] = 44;
        
        // 2중 for문을 사용해서 배열의 모든 값을 출력함
        for (int outer = 0; outer < intAry.length; outer++) {
            // intAry.length = 행의 개수 (여기선 2)
            for (int inner = 0; inner < intAry[outer].length; inner++) {
                // intAry[outer].length = 각 행의 열 개수
                // 예: intAry[0].length는 4, intAry[1].length는 3
                System.out.printf(" intAry[%d][%d] =>%d\n ", outer, inner, intAry[outer][inner]);
            }
        }

        // 정방행열(같은 수와 행과 열을 말한다 ex:3*3)
        // => 정방형 배열은 각 행마다 열의 개수가 같다는 뜻
        // 예: 3행 4열 배열이면 모든 행에 열이 4개씩 있음

        //[3][4], new int[5]
        // => [3][4]는 3행 4열짜리 배열을 만든다는 뜻
        int[][] ary2 = new int[3][4]; // 3행 4열의 2차원 배열 생성

        // (int)(Math.random()*100)+1;
        // => Math.random()은 0.0 이상 1.0 미만의 숫자 생성
        // => *100 하면 0 ~ 99.999... → 정수로 만들고 +1 하면 1~100 범위가 됨

        int sum = 0; // ary2[1] 행(두 번째 행)의 값들을 더할 변수

        // ary2 배열에 무작위 숫자 채우기
        for (int o = 0; o < ary2.length; o++) {
            for (int i = 0; i < ary2[o].length; i++) {
                ary2[o][i] = (int)(Math.random() * 100) + 1; // 1~100 숫자 저장

                // ary2[1]인 경우에만 합.
                // => 두 번째 행일 때만 sum에 더함 (o == 1은 두 번째 행이라는 뜻)
                if (o == 1) {
                    sum += ary2[o][i]; // sum = sum + ary2[o][i];
                }

                // 현재 위치의 숫자 출력
                System.out.printf("ary2[%d][%d] =>%d\n ", o, i, ary2[o][i]);
            }
        }

        // 두 번째 행(ary2[1])의 숫자들의 합 출력
        System.out.printf("ary2[1] 요소의 합: %d \n", sum);
    } // end of main

} // end of class
