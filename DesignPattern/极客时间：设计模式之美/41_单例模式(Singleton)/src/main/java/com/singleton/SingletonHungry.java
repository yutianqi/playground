package com.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 饿汉式
 *
 * @author y00290641
 * @since 2021/2/18
 */
public class SingletonHungry {

    private SingletonHungry() {}

    private final AtomicLong id = new AtomicLong();
    private static final SingletonHungry instance = new SingletonHungry();

    public static SingletonHungry getInstance() {
        return instance;
    }
    
    public long getId() {
        return id.incrementAndGet();
    }
}
