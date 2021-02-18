/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.handler;

/**
 * xxx
 *
 * @author y00290641
 * @since 2021/2/18
 */
public class HandlerChain {
    private Handler headHandler = null;
    private Handler tailHandler = null;


    public void addHandler(Handler handler) {
        handler.setSuccessor(null);
        if (headHandler == null) {
            headHandler = handler;
            tailHandler = handler;
            return;
        }
        tailHandler.setSuccessor(handler);
        tailHandler = headHandler;
    }

    public void handle() {
        if (headHandler != null) {
            headHandler.handle();
        }
    }

}
