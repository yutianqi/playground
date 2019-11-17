package com.huawei.behavior.fly.impl;

import com.huawei.behavior.fly.FlyBehavior;

public class FlyNoWay implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("I cannot Flying");
    }
}
