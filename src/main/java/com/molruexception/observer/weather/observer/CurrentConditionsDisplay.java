package com.molruexception.observer.weather.observer;

import com.molruexception.observer.weather.subject.Subject;
import com.molruexception.observer.weather.subject.TimedWeatherData;
import org.jetbrains.annotations.NotNull;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    private String measuredTime;
    private Subject subject;

    public CurrentConditionsDisplay(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(@NotNull Subject subject) {
        if (subject instanceof TimedWeatherData timedWeatherData) {
            this.temperature = timedWeatherData.getTemperature();
            this.humidity = timedWeatherData.getHumidity();
            this.measuredTime = timedWeatherData.getMeasuredTime();
            display();
        }
    }

    @Override
    public void display() {
        System.out.printf(
                "[%s] Current conditions: %fF degrees and %f%% humidity%n",
                measuredTime, temperature, humidity
        );
    }

}
