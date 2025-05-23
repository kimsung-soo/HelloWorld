package com.yedam.api;

public class SystemExe {
	public static void main(String[] args) {

		long now = System.currentTimeMillis(); //// 현재 시스템 시간(1970년 1월 1일 이후 밀리초 기준)
		System.out.println(now);
		// 1747964984485 :약 20,229일 → 약 55.4년 를 몇일,몇시,몇분,몇초를 계산하는법
		// 60 * 60 * 24 => 1일 = 24시간 = 86400초
		// 60* 60 => 1시간 = 60분 = 3600초
		// 60=> 1분
		// 나머지가 초
		// 계산

		long time = 1747964906;
		long years = time / (60 * 60 * 24 * 365);

		long days = time % (60 * 60 * 24 * 365);
		days = days / (60 * 60 * 24);

		long hours = time % (60 * 60 * 24);
		hours = hours / (60 * 60);

		long minutes = time % (60 * 60);
		minutes = minutes / 60;

		long secs = time % 60;

		System.out.println(days + "일 " + hours + "시간 " + minutes + "분" + secs + "초");

	}

	public static void exe() {
		long start = System.nanoTime(); // System.currentTimeMillis();
		int sum = 0;
		for (int i = 0; i < 100000000; i++) {
			sum += i;
		}
		long end = System.nanoTime(); // System.currentTimeMillis();
		System.out.printf("합계 %d, 걸린시간 %d\n", sum, (end - start));
	}
}
