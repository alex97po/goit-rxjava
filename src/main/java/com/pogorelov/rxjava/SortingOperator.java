package com.pogorelov.rxjava;

import io.reactivex.Observable;

import java.math.BigDecimal;
import java.util.Comparator;

public class SortingOperator {

    public static void main(String[] args) {
        useSortedWithNonComparator();
    }

    private static void useSorted() {
        Observable.just(3, 5, 2, 4, 1)
                .sorted()
                .subscribe(System.out::println);
    }

    private static void useSortedWithComparator() {
        Observable.just(3, 5, 2, 4, 1)
                .sorted(Comparator.reverseOrder())
                .subscribe(System.out::println);
    }

    private static void useSortedWithNonComparator() {
        Observable.just("foo", "john", "bar")
                .sorted(Comparator.comparingInt(String::length))
                .subscribe(System.out::println);
    }
}
