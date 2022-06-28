package com.example.collection;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class curlybraces {
      public static void main(String[] args){
          String curl = "((())(())(((()))";

          Map<String, Integer> counted = new HashMap<>();
          Arrays.asList(curl.split("")).forEach(
                  x->{
                      counted.put(x,counted.getOrDefault(x,0)+1);
                  }
          );
          System.out.println(counted.entrySet());
           Map<String,Integer> li =  counted.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue))
                           .collect(Collectors.toMap(x->x.getKey(),x->x.getValue(),(pre,nex)->pre,LinkedHashMap::new));
          System.out.println(li);




      }
}
