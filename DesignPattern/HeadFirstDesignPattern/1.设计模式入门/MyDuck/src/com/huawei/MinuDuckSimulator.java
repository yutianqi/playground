package com.huawei;

import com.huawei.duck.Duck;
import com.huawei.duck.MallardDuck;

public class MinuDuckSimulator {

    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.display();
        mallard.performFly();
        mallard.performQuack();

    }


}
