package com.example.maps;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Findfrequency {
    public static void sortString(){
        String[] fg = new String[]{"ade1","2","100","ade100","ade3","ade300","ade13"};
        Comparator<String> nm = (String::compareTo);
        Arrays.sort(fg, nm.reversed());
        System.out.println(Arrays.asList(fg));
    }

    public static void getFrecL(){
        List<List<String>> list = new ArrayList<>();
        Comparator<List<String>> compare = Comparator.comparing(strings -> strings.get(2));
        Collections.sort(list,compare.reversed());
    }
    public static void getFrec(){
        List<Integer> nums = Arrays.asList(1,2,3,6,100,100,100,100,100,7,3,5,8,3,6,6,2,5,2,5,6,3,6,5,3,5,7);
        Map<Integer, Integer> mpa = new TreeMap<>(Comparator.naturalOrder());
         int  maxe = 0;
        for (int x=0;x<nums.size();x++) {
            mpa.put(nums.get(x), mpa.getOrDefault(nums.get(x), 0) + 1);
            if (mpa.get(nums.get(x)) > maxe) {
                maxe = mpa.get(nums.get(x));
            }
        }

       // System.out.println(mpa.g);



    }
    public static void getFre(){
        List<Integer> num = Arrays.asList(1,2,3,6,100,100,100,100,100,7,3,5,8,3,6,6,2,5,2,5,6,3,6,5,3,5,7);
        Map<Integer, Long> mk = num.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        Long max = mk.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                                .get().getValue();

        Map<Integer, Long> kl =  mk.entrySet().stream()
                .filter(x->x.getValue()==max)
                .limit(3)
                .sorted(Comparator.comparing(Map.Entry::getKey))
                //.collect(Collectors.toMap(e->e.getKey(),e->e.getValue()));
                        .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(oldV,newV)->oldV,LinkedHashMap::new));
       System.out.println(kl);

    }
    public static void main(String[] args){
        sortString();
    }
}
