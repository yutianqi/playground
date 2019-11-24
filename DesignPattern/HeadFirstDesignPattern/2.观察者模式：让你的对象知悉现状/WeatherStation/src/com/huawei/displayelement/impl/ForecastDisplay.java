package com.huawei.displayelement.impl;

import com.huawei.displayelement.DisplayElement;
import com.huawei.observer.Observer;
import com.huawei.subject.Subject;

public class ForecastDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    private float pressure;
    private Subject weatherData;

    public ForecastDisplay(Subject weatherData) {
        // 保存对Subject的引用，方便注册和取消注册
        this.weatherData = weatherData;
        // 直接将当前对象注册为weatherData主题的观察者
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;

        display();
    }

    @Override
    public void display() {
        System.out.println("--->  Forecast  <---\r\nTemperature:" + temperature + "F\r\nHumidity: " + humidity +
                "\r\nPressure: " + pressure + "\r\n\r\n");
    }


}
