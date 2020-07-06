package com.pogorelov.rxjava;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class DelayOperator {

    public static void main(String[] args) {
        useDelayWithError();
    }

    private static void useDelay() {
        Observable.just(1, 2, 3, 4, 5)
                .delay(3000, TimeUnit.MILLISECONDS)
                .subscribe(System.out::println);
        pause(5000);
    }

    private static void useDelayWithError() {
        Observable.error(new Exception("error"))
                .delay(3000, TimeUnit.MILLISECONDS, true)
                .subscribe(System.out::println, error -> System.out.println(error.getMessage()),
                        () -> System.out.println("Completed"));
        pause(5000);
    }


    private static void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
