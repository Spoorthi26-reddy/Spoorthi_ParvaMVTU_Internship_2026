package com.static_final;
enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY
}

public class Test {
    public static void main(String[] args) {
        Day today = Day.MONDAY;

        System.out.println(today);
    }
}
