package com.pogorelov.rxjava;

import io.reactivex.Observable;

public class EmptyVsNever {

    public static void main(String[] args) {
        createObservableUsingNever();
    }

    private static void createObservableUsingEmpty() {
        Observable observable = Observable.empty();
        observable.subscribe(item -> System.out.println("ITEM: " + item), System.out::println, () -> System.out.println("COMPLETED"));
    }

    private static void createObservableUsingNever() {
        Observable observable = Observable.never();
        observable.subscribe(System.out::println, System.out::println, () -> System.out.println("Completed"));
        pause(3000);
    }

    private static void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
