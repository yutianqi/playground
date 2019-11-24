package com.huawei.subject;


import java.util.Observer;

public interface Subject {
    // 注册观察者
    public void registerObserver(Observer o);

    // 删除观察者观察者
    public void removeObserver(Observer o);

    // 通知观察者
    public void notifyObservers();
}
