package com.yedam.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.NoSuchElementException;
import java.util.Scanner;

//writer
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StreamExe2 {
	public static void main(String[] args) {
		Scanner scanner = null; // try 밖에서 미리 선언!

		try {
			scanner = new Scanner(new File("c:/temp/writer.txt")); // 파일 열기
			while (scanner.hasNextLine()) { // 더 읽을 줄이 있을 때만 읽기
				String data = scanner.nextLine(); // 한 줄 읽기
				//홍길동 70 ,
				String[] strAry = data.split(" "); //구분자를 기준으로 배열
				System.out.println(strAry[0] + ","+strAry[1]); // 읽은 줄 출력
			}
		} catch (Exception e) {
//			e.printStackTrace(); // 파일을 못 찾았을 때 오류 출력
		} finally {
				scanner.close(); // 
			}
		System.out.println("end of prog"); // 프로그램 종료 메시지
		}//end of main



//입력
	public static void read() {
		// char기반의 입력스트림.
		try {
			Reader reader = new FileReader("c:/temp/writer.txt");
			while (true) {

				int data = reader.read();
				if (data == -1) {
					break;
				}
				System.out.print((char) data);
			}
			reader.close();
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

// 출력
	public static void write() {
		// char기반의 출력스트림.
		try {
			Writer wr = new FileWriter("c:/temp/writer.txt");
			wr.write('A');
			wr.write('B');
			wr.write('C');
			wr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
