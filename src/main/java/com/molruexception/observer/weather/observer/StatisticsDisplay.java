package com.molruexception.observer.weather.observer;

import com.molruexception.observer.weather.subject.Subject;
import com.molruexception.observer.weather.subject.WeatherData;
import org.jetbrains.annotations.NotNull;

public class StatisticsDisplay implements Observer, DisplayElement {

    private float maxTemp = 0.0f;
    private float minTemp = 200;
    private float tempSum= 0.0f;
    private int numReadings;
    private Subject subject;

    public StatisticsDisplay(@NotNull Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(@NotNull Subject subject) {
        if (subject instanceof WeatherData weatherData) {
            final float temp = weatherData.getTemperature();
            tempSum += temp;
            numReadings++;

            if (temp > maxTemp) {
                maxTemp = temp;
            }
            else if (temp < minTemp) {
                minTemp = temp;
            }

            display();
        }
    }

    @Override
    public void display() {
        System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings)
                + "/" + maxTemp + "/" + minTemp);
    }

}
