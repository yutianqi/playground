package com.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 双重校验
 *
 * @author y00290641
 * @since 2021/2/18
 */
public class SingletonDoubleCheck {

    private SingletonDoubleCheck() {
    }

    private final AtomicLong id = new AtomicLong();

    private volatile static SingletonDoubleCheck instance;

    public static SingletonDoubleCheck getInstance() {
        if (instance == null) {
            synchronized (SingletonDoubleCheck.class) {
                if (instance == null) {
                    instance = new SingletonDoubleCheck();
                    return instance;
                }
            }
        }
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }

}
