package com.molruexception.observer.weather.subject;

import com.google.common.collect.Lists;
import com.molruexception.observer.weather.observer.Observer;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class WeatherData implements Subject {

    private final List<Observer> observers = Lists.newArrayList();
    private boolean changed = false;

    private float temperature;
    private float humidity;
    private float pressure;

    @Override
    public void registerObserver(@NotNull Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(@NotNull Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        if (changed) {
            observers.forEach(observer -> observer.update(this));
            changed = false;
        }
    }

    private void measurementsChanged() {
        changed = true;
        notifyObservers();
    }


    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

}
