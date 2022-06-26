package com.example.collection;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class curlybraces {
      public static void main(String[] args){
          String curl = "((())(())(((()))";
          Map<String,Integer> mapl = new HashMap<>();
          Stream<String> stringStream = curl.codePoints()
                  .mapToObj((x)->String.valueOf((char)x));
          List<String> stringList = stringStream.collect(Collectors.toList());
          //stringList.sort((Comparator.reverseOrder()));
          //stringList.stream()
          //                .forEach(x->mapl.put(x,mapl.getOrDefault(x,0)+1));
          Map<String, Long> counted = stringList.stream()
                  .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
                  //.collect(Collectors.groupingBy(t->t, Collectors.counting()));
          System.out.println(counted.entrySet());


      }
}
