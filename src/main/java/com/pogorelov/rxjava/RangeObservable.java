package com.pogorelov.rxjava;

import io.reactivex.Observable;

public class RangeObservable {

    private static int start = 1, count = 10;

    public static void main(String[] args) {
        Observable<Integer> observable = Observable.defer(() -> Observable.range(start, count));
        observable.subscribe(item -> System.out.println("Observer 1: " + item));
        count = 3;
        observable.subscribe(item -> System.out.println("Observer 2: " + item));
    }
}
