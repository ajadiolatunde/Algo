package com.example.Hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Chocoloate {
    /**
     * Two children, Lily and Ron, want to share a chocolate bar. Each of the squares has an integer on it.
     *
     * Lily decides to share a contiguous segment of the bar selected such that:
     *
     *     The length of the segment matches Ron's birth month, and,
     *     The sum of the integers on the squares is equal to his birth day.
     *
     * Determine how many ways she can divide the chocolate.
     *
     * Example
     *
     *
     * Lily wants to find segments summing to Ron's birth day, with a length equalling his birth month, . In this case, there are two segments meeting her criteria: and
     *
     * .
     *
     * Function Description
     *
     * Complete the birthday function in the editor below.
     *
     * birthday has the following parameter(s):
     *
     *     int s[n]: the numbers on each of the squares of chocolate
     *     int d: Ron's birth day
     *     int m: Ron's birth month
     *
     * Returns
     *
     *     int: the number of ways the bar can be divided
     * @param s
     * @param d
     * @param m
     * @return
     */
    public static int birthday(List<Integer> s, int d, int m) {
        int count=0;
        if (s.size()== m){
            if (s.get(0)==d) return 1;
        }
        for(int x=0;x<s.size()-m+1;x++){
            List<Integer> sum = s.subList(x,x+m);
            int kl = sum.stream().mapToInt(Integer::intValue).sum();
            if (kl == d){
                System.out.println(sum);
                count++;
            }
        }
        System.out.println(count);
        return count ;

    }
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>(List.of(2, 5, 1, 3, 4 ,4, 3 ,5, 1, 1, 2 ,1, 4 ,1 ,3 ,3, 4, 2 ,1));
        int d = 18;
        int m = 7;
        birthday(list,d,m);
        String l= "1-1-23";
        String[] kl = l.split("(-\\d)");
        Consumer<String> con = System.out::println;
        Arrays.stream(kl).forEach(con);
        System.out.println("-----");

    }
}
