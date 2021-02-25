package com.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 饿汉式
 *
 * @author y00290641
 * @since 2021/2/18
 */
public class SingletonStaticInnerClass {

    private SingletonStaticInnerClass() {}

    private final AtomicLong id = new AtomicLong();

    /**
     * 当外部类SingletonStaticInnerClass被加载的时候，并不会创建SingletonHolder的实例对象
     * 只有当调用getInstance的时候，SingletonHolder才会被加载，才会创建instance
     */
    private static class SingletonHolder {
        private static final SingletonStaticInnerClass instance = new SingletonStaticInnerClass();
    }

    public static SingletonStaticInnerClass getInstance() {
        return SingletonHolder.instance;
    }
    
    public long getId() {
        return id.incrementAndGet();
    }
}
