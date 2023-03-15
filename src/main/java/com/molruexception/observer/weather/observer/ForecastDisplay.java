package com.molruexception.observer.weather.observer;

import com.molruexception.observer.weather.subject.Subject;
import com.molruexception.observer.weather.subject.WeatherData;
import org.jetbrains.annotations.NotNull;

public class ForecastDisplay implements Observer, DisplayElement {

    private float currentPressure = 29.92f;
    private float lastPressure;
    private final Subject subject;

    public ForecastDisplay(@NotNull Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(@NotNull Subject subject) {
        if (subject instanceof WeatherData weatherData) {
            lastPressure = currentPressure;
            currentPressure = weatherData.getPressure();
            display();
        }
    }

    @Override
    public void display() {
        System.out.print("Forecast: ");
        if (currentPressure > lastPressure) {
            System.out.println("Improving weather on the way!");
        } else if (currentPressure == lastPressure) {
            System.out.println("More of the same");
        } else if (currentPressure < lastPressure) {
            System.out.println("Watch out for cooler, rainy weather");
        }
    }

}
