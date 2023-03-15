package com.molruexception.observer.weather.observer;

import com.molruexception.observer.weather.subject.Subject;
import org.jetbrains.annotations.NotNull;

public interface Observer {

    void update(@NotNull Subject subject);

}
