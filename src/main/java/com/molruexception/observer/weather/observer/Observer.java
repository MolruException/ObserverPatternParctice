package com.molruexception.observer.weather.observer;

import org.jetbrains.annotations.NotNull;

public interface Observer {

    void update(@NotNull Observer observer);

}
