package com.javaPlayground.algorithms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupWordsByLength {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Have", "fun", "with", "java", "collections", "si", "iar", "java");
        groupWordsByLength(list);
    }

    public static void groupWordsByLength(List<String> list) {

        Map<Integer, List<String>> results = list
                .stream()
                .collect(Collectors.groupingBy(String::length,
                        Collectors.mapping(Function.identity(), Collectors.toList())));

        System.out.println(results);
    }
}
