package com.pogorelov.rxjava;

import io.reactivex.Observable;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class ErrorHandling {

    public static void main(String[] args) {
        exRetryUntil();
    }

    private static void exDoOnError() {
        Observable.error(new Exception("This is an example error"))
                .doOnError(error -> System.out.println("Error: " + error.getMessage()))
                .subscribe(System.out::println,
                        error -> System.out.println("Subscribed  error: " + error.getMessage()),
                        () -> System.out.println("Completed"));
    }

    private static void exOnErrorResumeNext() {
        Observable.error(new Exception("This is an example error"))
                .onErrorResumeNext(Observable.just(1, 2, 3, 4, 5))
                .subscribe(System.out::println,
                        error -> System.out.println("Subscribed  error: " + error.getMessage()),
                        () -> System.out.println("Completed"));
    }

    private static void exOnErrorReturn() {
        Observable.error(new IOException("This is an example error"))
                .onErrorReturn(error -> {
                    if (error instanceof IOException) {
                        return 0;
                    } else return 1;
                })
                .subscribe(System.out::println,
                        error -> System.out.println("Subscribed  error: " + error.getMessage()),
                        () -> System.out.println("Completed"));
    }

    private static void exOnErrorReturnItem() {
        Observable.error(new IOException("This is an example error"))
                .onErrorReturnItem("Hello World")
                .subscribe(System.out::println,
                        error -> System.out.println("Subscribed  error: " + error.getMessage()),
                        () -> System.out.println("Completed"));
    }

    private static void retryWithPredicate() {
        Observable.error(new IOException("This is an example error"))
                .retry(error -> {
                    if (error instanceof IOException) {
                        System.out.println("retrying");
                        return true;
                    } else return false;
                })
                .subscribe(System.out::println,
                        error -> System.out.println("Subscribed  error: " + error.getMessage()),
                        () -> System.out.println("Completed"));
    }

    private static void exRetry() {
        Observable.error(new IOException("This is an example error"))
                .retry(3)
                .subscribe(System.out::println,
                        error -> System.out.println("Subscribed  error: " + error.getMessage()),
                        () -> System.out.println("Completed"));
    }

    private static void exRetryUntil() {
        AtomicInteger atomicInteger = new AtomicInteger();
        Observable.error(new IOException("This is an example error"))
                .doOnError(error -> {
                    System.out.println(atomicInteger.get());
                    atomicInteger.getAndIncrement();
                })
                .retryUntil(() -> {
                    System.out.println("Retrying");
                    return atomicInteger.get() >= 3;
                })
                .subscribe(System.out::println,
                        error -> System.out.println("Subscribed  error: " + error.getMessage()),
                        () -> System.out.println("Completed"));
    }
}
