package com.zmh.creational.builder;

public class TextBuider {

    public static void main(String[] args) {

        Phone build = new Phone.PhoneBuilder()
                .descri("小米新手机")
                .length(18)
                .name("小米8")
                .size(20)
                .type("水桶机")
                .build();

        System.out.println(build);

    }
}
