package com.example.collection;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Amazontest1 {

    public static List<String> process(){
        List<String> iterms = Arrays.asList("33 44 234","22 44 567","33 22 778","23 23 567","23 44 567");
        List<String> newitem = new ArrayList<String>();
         iterms.stream().forEach(x->{
            String[] mk =  x.split(" ");
            if (mk[0].equals(mk[1])){
                newitem.add(mk[0]);
            }else{
                newitem.add(mk[0]);
                newitem.add(mk[1]);
            }
         });
         System.out.println(newitem);
         Map<String, Long> map = newitem.stream().collect(Collectors.groupingBy(x->x,Collectors.counting()))
                         .entrySet().stream().filter(x->x.getValue()<=2)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        List<String> lk =   map.keySet().stream().collect(Collectors.toList());
         List<Integer> bk =  lk.stream().map(Integer::new).collect(Collectors.toList());

         Collections.sort(bk);
         lk = bk.stream().map(String::valueOf).collect(Collectors.toList());
        System.out.println(lk);



         return newitem;

    }

    public static List<String> processLogs(List<String> logs, int threshold) {
        Map<String,Long> map = logs.stream().map(log ->log.split(" ")[1])
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                        .entrySet().stream().filter(x->x.getValue()<=2)
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        System.out.println(map.entrySet());


        // Write your code here

        return map.keySet().stream().collect(Collectors.toList());
    }

    public static void main(String[] args){
        process();
    }
}
