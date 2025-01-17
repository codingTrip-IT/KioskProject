package com.example.kiosk.level6.model;

public enum User {
    VETERAN(1,10),
    SOILDER(2,5),
    STUDENT(3,3),
    GENERAL(4,0);

    //값을 저장할 필드(인스턴스 변수)
    private final int value;
    private final double discountRate;

    //생성자
    User(int value, double discountRate) {
        this.value = value;
        this.discountRate = discountRate;
    }

    //getter 메서드
    public int getValue(){return value;}

    public double getDiscountRate() {
        return discountRate;
    }

    // enum의 값이 매개변수와 같으면 enum의 값을 리턴합니다.
    public static User findByVal(int value) {
        User[] values = User.values();
        for (User v : values) {
            if (value ==v.value) {
                return v;
            }
        }
        throw new IllegalStateException("잘못된 번호입니다.");
    }
}
