package com.example.maps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Musala {
    private static void sortNew(List<List<String>> newList) {
        newList.stream()
                .sorted(Comparator.comparing(x->Integer.valueOf(x.get(2)),Comparator.reverseOrder()))
                .collect(Collectors.toList())
                .forEach(System.out::println);
//        [p2, 4, 1]
//        [p1, 1, 2]
//        [p3, 3, 3]

    }
    public static void main(String[] args){
        List<List<String>> items = new ArrayList<List<String>>();
        items.add(Arrays.asList("p1", "1", "213"));
        items.add(Arrays.asList("p2", "4", "100"));
        items.add(Arrays.asList("p2", "9", "1"));
        items.add(Arrays.asList("p2", "6", "300"));
        items.add(Arrays.asList("p2", "2", "1"));
        items.add(Arrays.asList(new String[]{"p3", "3", "3"}));
        var ade = items.subList(2,8);
        sortNew(items);

    }
}
