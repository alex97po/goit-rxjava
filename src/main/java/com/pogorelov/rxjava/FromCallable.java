package com.pogorelov.rxjava;

import io.reactivex.Observable;

public class FromCallable {

    public static void main(String[] args) {
        Observable<Integer> observable = Observable.fromCallable(FromCallable::getNumber);
        observable.subscribe(System.out::println, error -> System.out.println("ERROR!!! " + error.getMessage()));
    }

    private static int getNumber() {
        System.out.println("Generating value");
        return 1 / 0;
    }
}
