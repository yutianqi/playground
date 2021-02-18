/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.handler;

import com.handler.impl.HandlerA;
import com.handler.impl.HandlerB;

/**
 * xxx
 *
 * @author y00290641
 * @since 2021/2/18
 */
public class Application {

    public static void main(String[] args) {
        HandlerChain handlerChain = new HandlerChain();
        handlerChain.addHandler(new HandlerA());
        handlerChain.addHandler(new HandlerB());
        handlerChain.handle();
    }
}
