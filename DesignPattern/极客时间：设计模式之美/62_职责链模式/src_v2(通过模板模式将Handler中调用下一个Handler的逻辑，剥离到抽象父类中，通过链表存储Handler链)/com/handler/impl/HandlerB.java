/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.handler.impl;

import com.handler.Handler;

/**
 * xxx
 *
 * @author y00290641
 * @since 2021/2/18
 */
public class HandlerB extends Handler {

    @Override
    public boolean subHandle() {
        double random = Math.random();
        if (random > 0.5) {
            System.out.println("Handler B handled. " + random + " Succeed.");
            return true;
        }
        System.out.println("Handler B handled. " + random + " Failed.");
        return false;
    }
}
