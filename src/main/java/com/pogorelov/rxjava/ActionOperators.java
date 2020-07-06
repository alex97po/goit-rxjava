package com.pogorelov.rxjava;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.single.SingleUsing;

public class ActionOperators {

    public static void main(String[] args) {
        exDoOnDispose();

    }

    private static void exDoOnSubscribe() {
        Observable.just(1, 2, 3, 4, 5)
                .doOnSubscribe(disposable -> System.out.println("Subscribed"))
                .subscribe(System.out::println);
    }

    private static void exDoOnNext() {
        Observable.just(1, 2, 3, 4, 5)
                .doOnNext(integer -> System.out.println("Next: " + integer))
                .subscribe(System.out::println);
    }

    private static void exDoOnComplete() {
        Observable.just(1, 2, 3, 4, 5)
                .doOnComplete(() -> System.out.println("Completed"))
                .subscribe(System.out::println);
    }

    private static void exDoFinally() {
        Observable.just(1, 2, 3, 4, 5)
                .doFinally(() -> System.out.println("Finally"))
                .subscribe(System.out::println, System.out::println, () -> System.out.println("Completed"));
    }

    private static void exDoOnDispose() {
        Observable.just(1, 2, 3, 4, 5)
                .doOnDispose(() -> System.out.println("Disposed"))
                .doOnSubscribe(disposable -> disposable.dispose())
                .subscribe(System.out::println, System.out::println, () -> System.out.println("Completed"));
    }
}
