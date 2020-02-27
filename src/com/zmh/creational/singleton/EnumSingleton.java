package com.zmh.creational.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class EnumSingleton {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Singleton i1 = Singleton.INSTANCE;
//        Singleton i2 = Singleton.INSTANCE;
        Class<Singleton> aClass = Singleton.class;
        Constructor<Singleton> declaredConstructor = aClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Singleton i3 = declaredConstructor.newInstance();
        System.out.println(i1==i3);

    }
}

enum Singleton {
    INSTANCE;

    public void sayOK() {
        System.out.println("Hello");
    }
}
