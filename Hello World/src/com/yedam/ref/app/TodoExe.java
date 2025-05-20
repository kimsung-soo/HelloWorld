package com.yedam.ref.app;

public class TodoExe {
	public static void main(String[] args) {
		int[][] numAry = new int[3][5]; //3행 5열짜리 배열, 즉 3x5 크기의 표
		// 임의의 숫자 생성.
		
		   
		for (int outer = 0; outer < numAry.length; outer++) {
			for (int inner = 0; inner < numAry[outer].length; inner++) {
				numAry[outer][inner] = (int) (Math.random() * 100); 
					
				System.out.printf(numAry[outer][inner]+"\t");
				System.out.println();
				
				 int sum = 0;
				
				for (int o = 0; o < numAry.length; o++ ) {
					for(int in = 0; in < numAry[o].length; in++) {
						sum += numAry[o] [in];
						
						double avg =(double) sum/numAry.length;
						System.out.printf("numAry[%d]의 평균은%.1f\n",o,avg );
					}
				}
			}
		}

	}
}//end of class