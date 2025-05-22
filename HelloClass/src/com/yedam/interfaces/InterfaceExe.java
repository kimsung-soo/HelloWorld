package com.yedam.interfaces;

public class InterfaceExe {
    public static void main(String[] args) {
        // 인터페이스 타입으로 구현 객체를 참조
        RemoteControl rc = new Television();
        rc.turnOn();
        rc.turnOff();

        // Radio 객체도 인터페이스 타입으로 참조
        rc = new Radio();
        rc.turnOn();
        rc.turnOff();
    }
}
