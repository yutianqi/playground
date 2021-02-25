package com.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 懒汉式
 *
 * @author y00290641
 * @since 2021/2/18
 */
public class SingletonLazy {

    private SingletonLazy() {}

    private final AtomicLong id = new AtomicLong();
    private static SingletonLazy instance;

    public static synchronized SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }
    public long getId() {
        return id.incrementAndGet();
    }
}
