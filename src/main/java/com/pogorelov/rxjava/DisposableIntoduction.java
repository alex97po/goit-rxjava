package com.pogorelov.rxjava;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.ResourceObserver;

import java.util.concurrent.TimeUnit;

public class DisposableIntoduction {

    public static void main(String[] args) {
        handleDisposableInObserver();
    }

    private static void handleDisposable() {
        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS);
        Disposable disposable = observable.subscribe(System.out::println);
        pause(3000);
        disposable.dispose();
        pause(3000);
    }

    private static void handleDisposableInObserver() {
        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);
        Observer<Integer> observer = new Observer<>() {

            Disposable disposable;

            @Override
            public void onSubscribe(Disposable disposable) {
                this.disposable = disposable;
            }

            @Override
            public void onNext(Integer integer) {
                if (integer == 3) {
                    disposable.dispose();
                }
                System.out.println(integer);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        };
        observable.subscribe(observer);
    }

    private static void handleDisposableOutsideObserver() {
        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);
        ResourceObserver<Integer> observer = new ResourceObserver<>() {

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        };
        Disposable disposable = observable.subscribeWith(observer);
    }

    private static void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
