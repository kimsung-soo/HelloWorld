package com.yedam.interfaces;

/*
 * 인터페이스: 필드(상수), 메서드(추상 메서드)
 */
public interface RemoteControl {
    int MAX_VOLUME = 10; // 인터페이스 상수는 public static final 자동 적용

    // 추상 메서드 (public abstract 생략 가능)
    void turnOn();
    void turnOff();
}
