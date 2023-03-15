package com.molruexception.observer.weather.subject;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimedWeatherData extends WeatherData {

    private String measuredTime;

    @Override
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.measuredTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul")).format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
        super.setMeasurements(temperature, humidity, pressure);
    }

    public String getMeasuredTime() {
        return measuredTime;
    }

}
