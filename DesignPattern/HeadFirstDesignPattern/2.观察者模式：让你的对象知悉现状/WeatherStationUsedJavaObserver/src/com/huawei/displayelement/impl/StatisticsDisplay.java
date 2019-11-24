package com.huawei.displayelement.impl;

import com.huawei.displayelement.DisplayElement;
import com.huawei.subject.Subject;
import com.huawei.subject.impl.WeatherData;

import java.util.Observable;
import java.util.Observer;

public class StatisticsDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    private float pressure;
    private Observable observable;

    public StatisticsDisplay(Observable weatherData) {
        // 保存对Subject的引用，方便注册和取消注册
        this.observable = weatherData;
        // 直接将当前对象注册为weatherData主题的观察者
        weatherData.addObserver(this);
    }

    public void update(Observable obs, Object ags) {
        if (obs instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) obs;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            this.pressure = weatherData.getPressure();
            display();

        }
    }

    public void display() {
        System.out.println("--->  Statistics  <---\r\nTemperature:" + temperature + "F\r\nHumidity: " + humidity +
                "\r\nPressure: " + pressure + "\r\n\r\n");
    }


}
