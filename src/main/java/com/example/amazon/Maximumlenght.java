package com.example.amazon;

import java.util.*;

public class Maximumlenght {
    //Maximum lenght substring with higher frequency;
    public static void main(String[] args){
        String data = "acdacdacdddac";
        String ans = getMaxfrec(data);
        System.out.println(ans);

    }

    private static String getMaxfrec(String data) {
        Map<String, Integer> map = new HashMap<>();
        for (int x=0;x<data.length();x++){
            for (int g=x+1;g<data.length()+1;g++){
                String sub = data.substring(x,g);
                map.put(sub,map.getOrDefault(sub,0)+1);
            }
        }
        System.out.println( map.entrySet().stream().max (Comparator.comparingInt(Map.Entry::getValue)).get().getKey());
        List<Map.Entry<String, Integer> > list = new LinkedList<>(map.entrySet());
        list.sort((y,x)->x.getValue().compareTo(y.getValue()));
        return list.get(0).getKey();
    }

}
