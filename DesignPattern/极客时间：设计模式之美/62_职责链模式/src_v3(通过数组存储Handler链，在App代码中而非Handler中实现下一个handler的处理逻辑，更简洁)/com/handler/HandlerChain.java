/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.handler;

import java.util.ArrayList;
import java.util.List;

/**
 * xxx
 *
 * @author y00290641
 * @since 2021/2/18
 */
public class HandlerChain {

    private final List<Handler> handlerChain = new ArrayList<>();

    public void addHandler(Handler handler) {
        handlerChain.add(handler);
    }

    public void handle() {
        for (Handler handler : handlerChain) {
            if (handler.subHandle()) {
                break;
            }
        }
    }

}
