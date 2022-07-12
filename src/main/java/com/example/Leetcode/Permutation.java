package com.example.Leetcode;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Permutation {

    /**
     * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
     * @param
     * @return
     */

    public static void main(String[] args){
        int[] p = {1,2,3};

       System.out.println( permutest(p));
    }

    public static  List<List<Integer>> permutest(int[] nums) {
        Map<Queue<Integer>,Set<Integer>> map = new HashMap<>();
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int len = nums.length;

        if (len<2){
            List<Integer> list1 = new ArrayList();
            list1.add(nums[0]);
            List<List<Integer>> list2 = new ArrayList();
            list2.add(list1);
            return list2;
        }
        while (len>1){
            //check first run
            if (map.keySet().size()==0){
                for (int i:nums){
                    Set<Integer> values = new HashSet<>();
                    values.addAll(list);
                    values.remove(i);
                    Queue<Integer> nw = new LinkedList<>();
                    nw.add(i);
                    map.put(nw,values);
                }
                len = map.values().iterator().next().size();
            }else{
                //Subsequent run until length of values is 1;
                Iterator<Queue<Integer>> keys = map.keySet().iterator();
                Map<Queue<Integer>,Set<Integer>> newMap = new HashMap<>();
                while (keys.hasNext()){
                    Queue<Integer> k = keys.next();
                    Set<Integer>  v = map.get(k);
                    for (int j:v){
                        Set<Integer> values = new HashSet<>();
                        values.addAll(v);
                        values.remove(j);
                        k.add(j);
                        newMap.put(k, values);
                    }
                }
                map = newMap;
                len = map.values().iterator().next().size();
                System.out.println(map.entrySet());
            }
        }
        List<List<Integer>> result = map.entrySet().stream()
                .map(x->{
                    List<Integer> keylist = new ArrayList<Integer>(x.getKey());
                    int valuelist = x.getValue().iterator().next();
                    keylist.add(valuelist);
                    return keylist;
                }).collect(Collectors.toList());
        System.out.println(map.entrySet().size());

        return result;

    }

    public static  List<List<Integer>> permutes(int[] nums) {
        Map<String,Set<Integer>> map = new HashMap<>();
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int len = nums.length;

        if (len<2){
            List<Integer> list1 = new ArrayList();
            list1.add(nums[0]);
            List<List<Integer>> list2 = new ArrayList();
            list2.add(list1);
            return list2;
        }
        while (len>1){
            //check first run
            if (map.keySet().size()==0){
                for (int i:nums){
                    Set<Integer> values = new HashSet<>();
                    values.addAll(list);
                    values.remove(i);
                    map.put(String.valueOf(i),values);
                }
                len = map.values().iterator().next().size();
            }else{
                //Subsequent run until length of values is 1;
                Iterator<String> keys = map.keySet().iterator();
                Map<String,Set<Integer>> newMap = new HashMap<>();
                while (keys.hasNext()){
                    String k = keys.next();
                    Set<Integer>  v = map.get(k);
                    for (int j:v){
                        Set<Integer> values = new HashSet<>();
                        values.addAll(v);
                        values.remove(j);
                        newMap.put(k+" "+j, values);
                    }
                }
                map = newMap;
                len = map.values().iterator().next().size();
                System.out.println(map.entrySet());
            }
        }
        List<List<Integer>> result = map.entrySet().stream()
                .map(x->{
                    List<Integer> keylist = Arrays.stream( x.getKey().split(" ")).map(Integer::valueOf).collect(Collectors.toList());
                    int valuelist = x.getValue().iterator().next();
                    keylist.add(valuelist);
                    return keylist;
                }).collect(Collectors.toList());
        System.out.println(map.entrySet().size());

        return result;

    }
}
