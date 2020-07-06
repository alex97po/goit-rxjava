package com.pogorelov.rxjava;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;

public class SpecialObservable {

    public static void main(String[] args) {
        createCompletable();
    }

    private static void createSingle() {
        Single.just("Hello World").subscribe(System.out::println);
    }

    private static void createMaybe() {
        Maybe.empty().subscribe(new MaybeObserver<Object>() {

            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onSuccess(Object o) {
                System.out.println("ITEM");
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {
                System.out.println("Done");
            }
        });
    }

    private static void createCompletable() {
        Completable.fromSingle(Single.just("Hello World")).subscribe(() -> System.out.println("DONE"));
    }
}
