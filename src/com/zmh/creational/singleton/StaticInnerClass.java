package com.zmh.creational.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 使用静态内部类
 */
public class StaticInnerClass {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        //通过反序列化破坏单列模式
        /*ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("destory_singleton"));
        oos.writeObject(instance);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("destory_singleton")));
        Singleton01 instance2 = (Singleton01) ois.readObject();*/

        Singleton01 instance = Singleton01.getInstance();
        //通过反射破坏单例模式
        Class<Singleton01> s1 = Singleton01.class;
        Constructor<Singleton01> constructor = s1.getDeclaredConstructor();
        constructor.setAccessible(true); //打开构造器的权限
        Singleton01 instance2 = constructor.newInstance();


        System.out.println(instance);
        System.out.println(instance2);
        System.out.println(instance == instance2);
    }
}


class Singleton01 implements Serializable {

    //构造私有化，外部不能通过new关键字创建
    private Singleton01() throws Exception {
        //添加防止反射调用的校验
        if (SingletonInner.INSTANCE != null) {
            throw new RuntimeException("单列构造器禁止反射调用");
        }
    }

    //在静态内部类中创建单例类
    private static class SingletonInner {
        private static Singleton01 INSTANCE;

        static {
            try {
                INSTANCE = new Singleton01();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //对外提供的静态公有方法
    public static Singleton01 getInstance() {
        return SingletonInner.INSTANCE;
    }

    //防止序列化破坏单例模式
    private Object readResolve() {
        return getInstance();
    }
}
