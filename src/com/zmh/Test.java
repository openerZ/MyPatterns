package com.zmh;

public class Test {

    public static void main(String[] args) {

        int a=034;  //0开头的数字表示的八进制 只能取0-7
        int b=0111;
        int c = 0xaa; //0x开头表示16进制 只能取0-f
        System.out.println(a);
        System.out.println(b);
        System.out.println(1+8+64);
        System.out.println(c);
    }
}


class A{
    A (int i){
        System.out.println("我是A");
    }

    public static int a=5;
    static void play(){
        System.out.println("我是A的静态方法");
    }


}

class B extends A{
    B(){
        super(2);
        System.out.println("我是B");
    }
}

class C{
    public final int a;

    //空白final可以在声明的时候不赋值，但是必须在每个构造器中赋值
    //以保证在使用前初始化
    private final B b;

    public C(int i){
        a=i;
        b=new B();
    }

    public C(){
        a=2;
        b=new B();
    }


}