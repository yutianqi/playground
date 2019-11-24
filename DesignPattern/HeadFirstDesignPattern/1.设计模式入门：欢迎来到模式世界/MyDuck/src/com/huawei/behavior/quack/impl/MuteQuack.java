package com.huawei.behavior.quack.impl;

import com.huawei.behavior.quack.QuackBehavior;

public class MuteQuack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Silence");
    }

}
