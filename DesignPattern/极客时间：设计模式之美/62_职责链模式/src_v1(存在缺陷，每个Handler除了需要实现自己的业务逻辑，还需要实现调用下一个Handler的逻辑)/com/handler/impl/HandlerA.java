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
public class HandlerA extends Handler {

    @Override
    public void handle() {
        double random = Math.random();
        if (random > 0.5) {
            // 处理成功，结束
            System.out.println("Handler A handled. " + random + " Succeed.");
            return;
        }
        // 处理失败，继续调用下一个handler
        System.out.println("Handler A handled. " + random + " Failed.");
        if (successor != null) {
            this.successor.handle();
        }
    }
}
