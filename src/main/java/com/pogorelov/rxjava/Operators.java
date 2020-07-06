package com.pogorelov.rxjava;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Operators {

    public static void main(String[] args) {
        useScanWithInitValue();
    }

    private static void mapOperator() {
        Observable.just(1, 2, 3, 4, 5)
                .map(item -> item * 2)
                .subscribe(System.out::println);
    }

    private static void mapOperatorReturnsDifferentData() {
        Observable.just(1, 2, 3, 4, 5)
                .map(item -> "Hello world")
                .subscribe(System.out::println);
    }

    private static void filterOperator() {
        Observable.just(1, 2, 3, 4, 5)
                .filter(item -> item % 2 == 0)
                .subscribe(System.out::println);
    }

    private static void combineMapAndFilter() {
        Observable.just(1, 2, 3, 4, 5)
                .filter(item -> item % 2 == 0)
                .map(item -> item * 2)
                .subscribe(System.out::println);
    }

    private static void takeOperator() {
        Observable.just(1, 2, 3, 4, 5)
                .take(2)
                .subscribe(System.out::println);
    }

    private static void takeWithInterval() {
        Observable.interval(300, TimeUnit.MILLISECONDS)
                .take(2, TimeUnit.SECONDS)
                .subscribe(System.out::println, System.out::println, () -> System.out.println("Completed"));
        pause(5000);
    }

    private static void takeWhileOperator() {
        Observable.just(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)
                .takeWhile(integer -> integer <= 3)
                .subscribe(System.out::println);
    }

    private static void skipOperator() {
        Observable.just(1, 2, 3, 4, 5)
                .skip(2)
                .subscribe(System.out::println);
    }

    private static void skipWhileOperator() {
        Observable.just(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)
                .skipWhile(integer -> integer <= 3)
                .subscribe(System.out::println);
    }

    private static void distinctOperator() {
        Observable.just(1, 1, 2, 2, 3, 3, 4, 5, 1, 2)
                .distinct()
                .subscribe(System.out::println);
    }

    private static void distinctWithKeySelectorOperator() {
        Observable.just("foo", "fool", "super", "foss", "foil")
                .distinct(String::length)
                .subscribe(System.out::println);
    }

    private static void distinctUntilChangedOperator() {
        Observable.just(1, 1, 2, 2, 3, 3, 4, 5, 1, 2)
                .distinctUntilChanged()
                .subscribe(System.out::println);
    }

    private static void distinctUntilChangedWithKeySelectorOperator() {
        Observable.just("foo", "fool", "super", "foss", "foil")
                .distinctUntilChanged(String::length)
                .subscribe(System.out::println);
    }

    private static void useDefaultIfEmpty() {
        Observable.just(1, 2, 3, 4, 5)
                .filter(integer -> integer > 10)
                .defaultIfEmpty(100)
                .subscribe(System.out::println);
    }

    private static void useSwitchIfEmpty() {
        Observable.just(1, 2, 3, 4, 11)
                .filter(integer -> integer > 10)
                .switchIfEmpty(Observable.just(6, 7, 8, 9, 10))
                .subscribe(System.out::println);
    }

    private static void useRepeat() {
        Observable.just(1, 2, 3, 4, 5)
                .repeat(3)
                .subscribe(System.out::println);
    }

    private static void useScan() {
        Observable.just(1, 2, 3, 4, 5)
                .scan(Integer::sum)
                .subscribe(System.out::println);
    }

    private static void useScanWithInitValue() {
        Observable.just(1, 2, 3, 4, 5)
                .scan(10, Integer::sum)
                .subscribe(System.out::println);
    }

    private static void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
