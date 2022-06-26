package com.example.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ammazoncode {
    public static void printall(List<String> kl){
        List<List<String>> newkl = new ArrayList<>();
        for (String jk:kl){
            String[] mk= jk.split("");
            List<String> lp = Arrays.asList(mk);
            newkl.add(lp);
        }
//        List<List<String>> newkl = kl.stream().map(word -> word.codePoints().mapToObj(Character::toString).collect(Collectors.toList()))
//                .collect(Collectors.toList());
       // newkl.stream().forEach(System.out::println);
        int count=0;
        for (int r=0;r<newkl.size();r++){
            for (int c=0;c<newkl.get(0).size();c++){
                System.out.println(newkl.get(r).get(c));
                if (r==c && newkl.get(r).get(c).equals("1")){
                    count++;
                }
            }

        }
        System.out.println("count---"+count);
    }
    public static void main(String[] args){
        List<String> kl = Arrays.asList("10000","01000","00100","00010","00001");

        printall( kl);
    }
}
