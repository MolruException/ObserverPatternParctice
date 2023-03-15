package com.molruexception.observer;

import com.molruexception.observer.weather.observer.CurrentConditionsDisplay;
import com.molruexception.observer.weather.observer.Observer;
import com.molruexception.observer.weather.subject.TimedWeatherData;

import java.util.Timer;
import java.util.TimerTask;

public class WeatherStation {

    private static float temperature = 80.0f;
    private static float humidity = 65.0f;
    private static float pressure = 30.0f;

    public static void main(String[] args) {

        // Create Subject
        final TimedWeatherData subject = new TimedWeatherData();

        // Create Observer and register to Subject
        final Observer observer = new CurrentConditionsDisplay(subject);

        // Setup Scheduler
        final Timer scheduler = new Timer();
        final TimerTask task = new TimerTask() {
            @Override
            public void run() {
                temperature += Math.random() * 0.1;
                humidity += Math.random() * 0.1;
                pressure += Math.random() * 0.1;
                subject.setMeasurements(temperature, humidity, pressure);
            }
        };

        // Start Scheduler
        scheduler.schedule(task, 0, 1000);
    }

}
