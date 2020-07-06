package com.pogorelov.rxjava;

import io.reactivex.Observable;

import java.util.List;

public class Main {

    //Observable
    //Observer
    //Operator

    //Observable:
    //hot
    //cold
    //connectable

    //Just like observable
    //Single - 1 time (onSuccess, onError)
    //Maybe - -//- onComplete
    //Completable - onError, onComplete

    public static void main(String[] args) {
//        createObservableWithJust();
//        createObservableFromIterable();
        createObservableUsingCreate();
    }

    private static void createObservableWithJust() {
        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);
        observable.subscribe(System.out::println);
    }

    private static void createObservableFromIterable() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        Observable<Integer> observable = Observable.fromIterable(list);
        observable.subscribe(System.out::println);
    }

    private static void createObservableUsingCreate() {
        Observable<Integer> observable = Observable.create(integerEmitter -> {
           integerEmitter.onNext(1);
           integerEmitter.onNext(2);
           integerEmitter.onNext(3);
           integerEmitter.onNext(4);
           integerEmitter.onNext(5);
           integerEmitter.onComplete();
        });
        observable.subscribe(System.out::println, System.out::println, () -> System.out.println("Completed"));
    }
}
