package com.huawei.duck;

import com.huawei.behavior.fly.impl.FlyWithWings;
import com.huawei.behavior.quack.impl.NormalQuack;

public class MallardDuck extends Duck {

    public MallardDuck() {
        quackBehavior = new NormalQuack();
        flyBehavior = new FlyWithWings();
    }

    public void display() {
        System.out.println("I'm a real Mallard duck.");
    }

}
