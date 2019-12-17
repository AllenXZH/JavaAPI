package com.example.api.utils;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {

        AtomicInteger num = new AtomicInteger();

        Arrays.asList(4, 2, 3, 1, 5, 6, 7, 9, 8, 11, 1)

                .stream()

                .parallel()

                .collect(Collectors.groupingBy(x -> x % 10))

                .forEach((x, y) -> System.out.println(x + ":" + y + " -> " + (num.getAndIncrement())));


        String[] arr = new String[2];

        //Arrays.asList(arr).stream().forEach();
    }
}
