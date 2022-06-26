package com.example.collection;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Rduplicate {
    public static void main(String[] args){
        String all = "ereeeertrttt";
        char[] kl = all.toCharArray();
        List<String> list = new ArrayList<>();
        for (char x:kl) {
            list.add((String.valueOf(x)));
        }
//        Stream<String> sd= list.stream()
//                .distinct();
//        System.out.println(sd.collect(Collectors.toList()));
        Set<String> sd= list.stream()
                .collect(Collectors.toSet());
        System.out.println(sd.stream().collect(Collectors.joining("")));
        System.out.println(sd.stream().sorted().collect(Collectors.toList()));
        List<Integer> values = Arrays.asList( 5, 0, 0, 2 );
        int occurrences = Collections.frequency(values, 0);

        System.out.println("occurrences of zero is " + occurrences);

    }
}
