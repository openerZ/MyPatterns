package com.zmh.creational.singleton;

public class DoubleCheck {

    public static void main(String[] args) {
        SingletonDoubleCheck i1 = SingletonDoubleCheck.getInstance();
        SingletonDoubleCheck i2 = SingletonDoubleCheck.getInstance();
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i2==i1);
    }
}

/**
 * 双重检查创建单列
 */
class SingletonDoubleCheck{

    //1.私有构造方法
    private SingletonDoubleCheck(){}

    //声明以私有静态volatie修饰的单例
    private static volatile SingletonDoubleCheck singleton ;

    //对公共方法进行双重检查
    public static synchronized SingletonDoubleCheck getInstance(){
        if (singleton==null){
            synchronized (SingletonDoubleCheck.class){
                if(singleton==null){
                    singleton = new SingletonDoubleCheck();
                }
            }
        }

        return singleton;
    }
}