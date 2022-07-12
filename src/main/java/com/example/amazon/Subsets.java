package com.example.amazon;

import javax.swing.text.html.HTMLDocument;
import java.util.*;
import java.util.stream.Collectors;

public class Subsets {
    /**
     * Leetcode 78
     * @param nums
     * @return List<List<Integer>>
     */
    public static List<List<Integer>> subsets(int[] nums) {
        Map<Queue<Integer>,List<Integer>> map = new HashMap();
        //Arrays.sort(nums);
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        boolean map_values_len = true;
        while (map_values_len) {
            map_values_len = false;
            if (map.entrySet().isEmpty()){
                for (int x = 0; x < list.size(); x++){
                    Queue<Integer> key = new LinkedList<>();
                    key.add(list.get(x));
                    List<Integer> value = new ArrayList<>(list.subList(x+1,list.size()));
                    if (value.size()>0) map_values_len = true;
                    map.put(key, value);
                }
            }else{
                Iterator<Queue<Integer>> keys = map.keySet().iterator();
                Map<Queue<Integer>,List<Integer>> newmap = new HashMap();
                while (keys.hasNext()){
                    Queue<Integer> key = keys.next();
                    List<Integer> values = map.get(key);
                    if (values.size()>0){
                        //Empty the parent
                        newmap.put(key,new ArrayList<>());
                        //iterate values to create parentkey&child key and rest as values
                        for (int v= 0;v<values.size();v++){
                            Queue<Integer> q = new LinkedList<>();
                            q.addAll(key);
                            q.add(values.get(v));
                            List<Integer> newValue = new ArrayList<>();
                            newValue.addAll(values.subList(v+1,values.size()));
                            newmap.put(q,newValue);
                            if (newValue.size()>0) map_values_len = true;
                        }
                    }
                }
                map.putAll(newmap);
            }
        }
        List<List<Integer>> array = new ArrayList<>();
        map.entrySet().stream().forEach(entry -> array.add(new ArrayList<>(entry.getKey())));
        array.add(new ArrayList<>());
        return array;

    }

    public static void main(String[] args){
        int[] nm = {1,2,3,4};
        System.out.println(subsets(nm));
    }
}
