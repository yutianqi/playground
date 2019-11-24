package com.huawei.behavior.quack.impl;

import com.huawei.behavior.quack.QuackBehavior;

public class NormalQuack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Quack");
    }

}
