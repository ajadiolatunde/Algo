package com.example;

import java.util.*;
import java.util.stream.Collectors;

public class Musalaitem {
    public static void main(String[] args){
        List<List<String>> items = new ArrayList<List<String>>();
        items.add(Arrays.asList("p1", "1", "2"));
        items.add(Arrays.asList("p2", "4", "1"));
        items.add(Arrays.asList(new String[]{"p3", "3", "3"}));

        int sortbycolumn = 1;//0-2
        int orderby = 0;// 0 or 1
        int resultset = 0;
        switch (sortbycolumn){
            case 0:
                Comparator<List<String>> comparator = Comparator.comparing(j -> j.get(0));
                Collections.sort(items, comparator);
                break;
            case 1:
                Collections.sort(items, (o1, o2) -> o2.get(1).compareTo(o1.get(1)));

                break;
            case 2:
                break;
        }
        items.stream()
                .forEach(System.out::println);
        List<List<String>> kl = items.subList(0,2);
        List<String> output = new ArrayList<>();
        kl.stream()
                .forEach((o)->output.add(o.get(0)));

        System.out.println(output);

    }
}
