package com.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {



    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        SingletonEnum s=SingletonEnum.getInstance();
        SingletonEnum sUsual=SingletonEnum.getInstance();
        Constructor<SingletonEnum> constructor=SingletonEnum.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        SingletonEnum sReflection=constructor.newInstance();
        System.out.println(s+"\n"+sUsual+"\n"+sReflection);
        System.out.println("正常情况下，实例化两个实例是否相同："+(s==sUsual));
        System.out.println("通过反射攻击单例模式情况下，实例化两个实例是否相同："+(s==sReflection));
    }
}
