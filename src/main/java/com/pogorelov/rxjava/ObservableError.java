package com.pogorelov.rxjava;

import io.reactivex.Observable;

public class ObservableError {

    public static void main(String[] args) {
        throwExceptionUsingCallable();
    }

    private static void throwException() {
        Observable observable = Observable.error(new RuntimeException("An exception"));
        observable.subscribe(System.out::println, error -> System.out.println("Error 1: " + error.hashCode()));
        observable.subscribe(System.out::println, error -> System.out.println("Error 2: " + error.hashCode()));
    }

    private static void throwExceptionUsingCallable() {
        Observable observable = Observable.error(() -> {
            System.out.println("New exception created");
            return new Exception("An exception");
        });
        observable.subscribe(System.out::println, error -> System.out.println("Error 1: " + error.hashCode()));
        observable.subscribe(System.out::println, error -> System.out.println("Error 2: " + error.hashCode()));
    }
}
