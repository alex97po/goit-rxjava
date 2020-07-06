package com.pogorelov.rxjava;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public class ColdAndHotObservable {

    public static void main(String[] args) {
        createHotObservable();
    }

    private static void createColdObservable() {
        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);
        observable.subscribe(item -> System.out.println("Observer 1: " + item));
        pause(3000);
        observable.subscribe(item -> System.out.println("Observer 2: " + item));
    }

    private static void createHotObservable() {
        ConnectableObservable<Integer> observable = Observable.just(1, 2, 3, 4, 5).publish();
        observable.subscribe(item -> System.out.println("Observer 1: " + item));
        observable.connect();
        observable.subscribe(item -> System.out.println("Observer 2: " + item));
    }

    private static void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
