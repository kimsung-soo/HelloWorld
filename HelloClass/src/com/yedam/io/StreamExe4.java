package com.yedam.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
 * 객체 입출력 스트림
 * 기본타입 - 참조타입
 * int num =10;
 * Member member =new Member();
 * 직렬화(Serialization) : 갹체 ->기본
 * 역직렬화(Deserialization) : 기본 ->객체 
 * Serializable 인터페이스 구현 클래스.
 */
class product implements Serializable{
	String prodCode;

	public product(String prodCode) {
		this.prodCode = prodCode;
	}
}

public class StreamExe4 {
	public static void main(String[] args) {

		try {
			//기본 -> 객체.
			InputStream is =new FileInputStream("c:/temp/object.db");
			ObjectInputStream ois = new ObjectInputStream(is);
			
			List<product> list = (List<product>) ois.readObject(); //ClassNotFoundException
			for(product product : list) {
				System.out.println("상품코드: " + product.prodCode);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("end of prog");
	}
	
	static void serial() { // 객체 ->출력스트림.
		List<product> list = new ArrayList<>();
		list.add(new product("P001"));
		list.add(new product("P002"));

		try {
			OutputStream os = new FileOutputStream("c:/temp/object.db");
			//객체 입출력 보조 스트림
			ObjectOutputStream oos = new ObjectOutputStream(os);
			
			oos.writeObject(list); //객체 -> 기본
			oos.close();
			os.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
