package com.pogorelov.rxjava;

import io.reactivex.Observable;

public class ContainsOperator {

    public static void main(String[] args) {
        containsWithNotPrimitives();
    }

    private static void containsWithPrimitives() {
        Observable.just(1, 2, 198, 4, 5)
                .contains(198)
                .subscribe(System.out::println);
    }

    private static void containsWithNotPrimitives() {
        User user = new User("test");
        Observable.just(user)
                .contains(new User("test"))
                .subscribe(System.out::println);
    }

    static class User {
        String name;

        User(String name) {
            this.name = name;
        }
    }
}
