package com.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 饿汉式
 *
 * @author y00290641
 * @since 2021/2/18
 */
public enum SingletonEnum {

    INSTANCE;

    private SingletonEnum() {}

    private final AtomicLong id = new AtomicLong();

    public long getId() {
        return id.incrementAndGet();
    }
}
