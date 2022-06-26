package com.example;

import java.util.*;
import java.util.stream.Collectors;

public class Blocks {
    private static boolean isfilled(Map<String,Integer> map,int sizes){
        long count =map.entrySet()
                .stream()
                .count();
        return count==sizes;
    }

    private static List<List<Integer>> recursiveFind(int b, List<Map<String, String>> blocks, List<List<Integer>> counter,boolean direction){
        if (direction){
            if (b==blocks.size()){
                //System.out.println("--F-"+b+"---"+counter);
            return counter;}
        }else{
            if (b<0) {
                //System.out.println("-B--"+b+"---"+counter);
                return counter;}
        }
        String[] needs = new String[]{"gym", "rest", "bake"};
        Map<String, Integer> distancesLocation = new HashMap<>();
        for (int x=b;x<blocks.size();x++){
            System.out.println("--x--"+x+"----"+blocks.get(x));
            Map<String, String> map = blocks.get(x);
            //Find needs for each block
            for (String need: needs){
                String value = map.get(need);
                if (value.equals("true")) {
                    if(!distancesLocation.containsKey(need)) {
                        distancesLocation.put(need,x);
                        System.out.println("block "+b+" --"+need+" ---"+map.get(need));
                    }
                }
            }

            if (distancesLocation.size()>needs.length) break;

        }
        //System.out.println(distancesLocation.entrySet());

        List<Integer> kl = distancesLocation.entrySet().stream()
                        .map(x->x.getValue()-b)
                        .collect(Collectors.toList());
        if (direction) counter.add(kl);
        if (!direction) counter.add(0,kl);

        //System.out.println("---"+b+"---"+counter);
        if (direction) {
            recursiveFind(b + 1, blocks, counter, true);
        }else{
            recursiveFind( b-1, blocks, counter, false);

        }

        return counter;
    }

    private static void getNumBlocks() {
        List<Map<String, String>> blocks = new ArrayList<Map<String, String>>();
        //Assuming gym,rest,bake
        Map<String, String> item = new HashMap<>();
        item.put("gym", "true");
        item.put("rest", "false");
        item.put("bake", "false");

        Map<String, String> item2 = new HashMap<>();
        item2.put("gym", "false");
        item2.put("rest", "true");
        item2.put("bake", "true");

        Map<String, String> item3 = new HashMap<>();
        item3.put("gym", "false");
        item3.put("rest", "true");
        item3.put("bake", "false");
        Map<String, String> item4 = new HashMap<>();
        item4.put("gym", "true");
        item4.put("rest", "true");
        item4.put("bake", "false");
        Map<String, String> item5 = new HashMap<>();
        item5.put("gym", "false");
        item5.put("rest", "false");
        item5.put("bake", "true");
        Map<String, String> item6 = new HashMap<>();
        item6.put("gym", "true");
        item6.put("rest", "false");
        item6.put("bake", "true");
        Map<String, String> item7 = new HashMap<>();
        item7.put("gym", "false");
        item7.put("rest", "true");
        item7.put("bake", "true");
        blocks.add(item);
        blocks.add(item2);
        blocks.add(item3);
        blocks.add(item4);
        blocks.add(item5);
        blocks.add(item6);
        blocks.add(item7);

        List<List<Integer>> forwardblockdistance = new ArrayList<>();
        List<List<Integer>> backwardblockdistance = new ArrayList<>();

        //recursiveFind(0,blocks,forwardblockdistance,true);
        recursiveFind(blocks.size()-1,blocks,backwardblockdistance,false);

        System.out.println("--f----"+forwardblockdistance);
        System.out.println("--b----"+backwardblockdistance);



    }

    public static void main(String[] args){
           getNumBlocks();
    }
}
