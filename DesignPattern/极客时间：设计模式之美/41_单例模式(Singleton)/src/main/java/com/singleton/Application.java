/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Application
 *
 * @author y00290641
 * @since 2021/2/18
 */
public class Application {
    public static void main(String[] args) {
        int size = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(size);
        for (int i = 0; i < size; i++) {
            final int tmp = i;
            executorService.execute(new Runnable() {
                public void run() {
                    System.out.println("" + tmp + " " + SingletonEnum.INSTANCE.getId());
                }
            });
        }
        executorService.shutdown();
    }
}
