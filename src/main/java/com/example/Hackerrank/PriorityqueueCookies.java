package com.example.Hackerrank;

import java.util.*;
import java.util.stream.Collectors;

public class PriorityqueueCookies {
    /**
     * Jesse loves cookies and wants the sweetness of some cookies to be greater than value k
     *
     * . To do this, two cookies with the least sweetness are repeatedly mixed. This creates a special combined cookie with:
     *
     * sweetness =(1×
     * Least sweet cookie +2× 2nd least sweet cookie).
     * @param k
     * @param A
     * @return
     */
    public static int cookies(int k, List<Integer> A) {
        // Write your code here
        PriorityQueue<Integer> b = new PriorityQueue<>();
        b.addAll(A);
        if (b.size()<2)return -1;

        int count =0;
        while(b.peek()<k){
            if (b.size()>=2){
                int f = b.poll();
                int s = b.poll();

                b.add(f+s*2);
                count++;
            }else{
                break;
            }
        }
        if (b.peek()<k) return -1;
        System.out.println(count);
        return count;
    }
    public static void main(String[] args){
        List<Integer> list = List.of(2,7,3,6,4,6).stream().collect(Collectors.toList());
        List<Integer> list2 = Arrays.asList(1,2,3,9,10,12);

        System.out.println(list2);
        cookies(7,list2);
    }
}

