package com.huawei.duck;

import com.huawei.behavior.fly.FlyBehavior;
import com.huawei.behavior.quack.QuackBehavior;

public abstract class Duck {


    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck() {
    }

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void swim() {
        System.out.println("All ducks float, even decoys.");
    }

    public abstract void display();

}
