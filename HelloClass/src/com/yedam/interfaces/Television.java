package com.yedam.interfaces;

/*
 * Television 클래스는 RemoteControl 인터페이스를 구현하는 클래스
 */
public class Television implements RemoteControl {

    @Override
    public void turnOn() {
        System.out.println("티비를 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("티비를 끕니다.");
    }
}
