package com.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Robotlocation {

    private static String getValidity(String[] args){
        // check equality in numbers
        //
        Arrays.asList(args).stream()
                .map(x->x.replace("0",""))
                .map(x->x.length())
                .collect(Collectors.toList())
                .forEach(System.out::println);
        Comparator<Map<String, Long>> comparator = (stringLongMap, t1) -> t1.values().stream().findFirst().get().compareTo(stringLongMap.values().stream().findFirst().get());
        List<Map<String, Long>> list= Arrays.asList(args).stream()
                .map(word -> word.codePoints().mapToObj(Character::toString).collect(Collectors.groupingBy(x->x,Collectors.counting())))
                .collect(Collectors.toList());
        System.out.println(list);
        Collections.sort(list,comparator);
        System.out.println(list);

        List<String> index0 = Arrays.asList(args[0].split(""));
        List<String> index1 = Arrays.asList(args[1].split(""));
        Long count_ones_index0 = index0.stream()
                .filter(i -> i.contains("1"))
                .count();
        Long count_ones_index1 = index1.stream()
                .filter(i -> i.contains("1"))
                .count();
        if (index0.size()!=index1.size())return "invalid";
        if (count_ones_index0!=count_ones_index1) return "invalid";
        //check location of
        int count = 0;
        List<Integer> mappedlocations = new ArrayList<>();
        for (int x=0;x<index0.size();x++){
            if (index0.get(x).equals("1")){
                //boundry check
                if (x==0) {
                    if (index1.get(x).equals("1") ){
                        count++;
                        mappedlocations.add(x);
                    } else if(index1.get(x+1).equals("1")){
                        count++;
                        mappedlocations.add(x);
                    }
                 //last boundry
                }else{
                    //last index
                    if (x+1== index1.size()){
                        if (index1.get(x).equals("1")&& !mappedlocations.contains(x)){
                            count++;
                            mappedlocations.add(x);
                        }else{
                            if (index1.get(x-1).equals("1")&& !mappedlocations.contains(x-1)){

                                count++;
                                mappedlocations.add(x);
                            }
                        }
                    }else{
                        if (index1.get(x-1).equals("1")&& !mappedlocations.contains(x)){
                            count++;
                            mappedlocations.add(x);
                        }else if(index1.get(x).equals("1")&& !mappedlocations.contains(x+1)){
                            count++;
                            mappedlocations.add(x);
                        }else{
                            if (index1.get(x+1).equals("1")&& !mappedlocations.contains(x)){
                                count++;
                                mappedlocations.add(x);
                            }
                        }
                    }
                }
            }
        }


        System.out.println(count);
        return (count==count_ones_index0)?"valid":"invalid";
    }

    public static void main(String[] args) {
        String[]  data1 = new String[]{"1001","0110"};
        String[]  data2 = new String[]{"10101","01110"};
        String[]  data3 = new String[]{"10110","11100"};
        String[]  data4 = new String[]{"10101","11100"};
        String[]  data5 = new String[]{"101011","11100"};


        System.out.println( getValidity(data5));
    }
}
