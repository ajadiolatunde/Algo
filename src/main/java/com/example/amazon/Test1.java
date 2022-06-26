package com.example.amazon;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

public class Test1 {
    public static int getDev(Map<String, Integer> devEntries){
        List<Integer> entries = devEntries.entrySet().stream()
                .map(x->x.getValue())
                .collect(Collectors.toList());
        Comparator<Integer> collect = Comparator.naturalOrder();
        Collections.sort(entries,collect.reversed());
        return entries.get(0) - entries.get( entries.size()-1);
    }
    public static int getMaxFreqDeviation(String s, Set<Integer> deviations ) {
        for (int x=0;x<s.length();x++) {
            for (int g=x;g<s.length()+1;g++){
                String su =s.substring(x,g);
                System.out.println("---sub---"+su);
//                Map<String, Integer> map = Arrays.asList(su.split(""))
//                        .stream()
//                        .collect(Collectors.toMap(b -> b, b -> 1, Integer::sum));
                Map<String, Integer> map = Arrays.asList(su.split(""))
                        .stream()
                        .collect(Collectors.groupingBy(v->v,Collectors.summingInt(v->1)));
                if (map.entrySet().size()==1){
                    deviations.add(abs(0));
                }else {
                    int devcount = getDev(map);
                    deviations.add(abs(devcount));
                }
            }

        }
        return deviations.stream().collect(Collectors.toList()).get(deviations.size()-1);
    }

    public static void main(String[] args){
         String se = "abcaba";
        StringBuilder input1 = new StringBuilder();
        input1.append(se);
        String s = input1.reverse().toString();
        Set<Integer> deviations = new TreeSet<>();
        int ans = getMaxFreqDeviation(se,deviations);
        System.out.println(ans);
    }
}
