package com.molruexception.observer.weather.subject;

import com.molruexception.observer.weather.observer.Observer;
import org.jetbrains.annotations.NotNull;

public interface Subject {

    void registerObserver(@NotNull Observer o);
    void removeObserver(@NotNull Observer o);
    void notifyObservers();

}
