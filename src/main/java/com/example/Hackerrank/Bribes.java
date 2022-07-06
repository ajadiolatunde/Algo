package com.example.Hackerrank;

import java.awt.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


/**
 *
 * @author Olatunde
 *
 * It's New Year's Day and everyone's in line for the Wonderland rollercoaster ride!
 *
 * There are n people queued up, and each person wears a sticker indicating their initial
 * position in the queue (i.e.: 1, 2, ..., n-1, n) with the first number denoting
 * the frontmost position).
 *
 * Any person in the queue can bribe the person directly in front of them to swap positions.
 * If two people swap positions, they still wear the same sticker denoting their original
 * place in line. One person can bribe at most two other persons.
 *
 * That is to say, if n=8 and Person 5 bribes Person 4, the queue will look like this:
 * 1, 2, 3, 5, 4, 6, 7, 8.
 *
 * Fascinated by this chaotic queue, you decide you must know the minimum number of
 * bribes that took place to get the queue into its current state!
 *
 * Note: Each Person X wears sticker X, meaning they were initially the Xth person in queue.
 *
 * Input format
 * The first line contains an integer, T, denoting the number of test cases.
 * Each test case is comprised of two lines; the first line has n (an integer indicating
 * the number of people in the queue), and the second line has n space-separated
 * integers describing the final state of the queue.
 *
 * Constraints
 * 1<=T<=10
 * 1<=n<=10^5
 *
 * Output format
 * Print an integer denoting the minimum number of bribes needed to get the queue
 * into its final state; print Too chaotic if the state is invalid (requires Person X
 * to bribe more than 2 people).
 *
 */

public class Bribes {
    public static void minimumBribes(List<Integer> l) {
        int total_swap = 0;
        boolean quaotic = false;
        int[] q = l.stream().mapToInt(Integer::valueOf).toArray();
        for (int x=q.length;x>=1;x--) {
            if (quaotic)break;
            int item_swap = 0;
            for (int y=x-1;y>=0;y--) {
                if (x==q[y]){
                   break;
                }
               if(x==q[y-1]) {
                    item_swap+= 1;
                    q[y-1] = q[y];
                    q[y] =x;
                    break;
                } else if (x == q[y-2]) {
                   item_swap+= 2;
                   q[y-2] = q[y-1];
                   q[y-1] = q[y];
                   q[y] =x;
                   break;
               } else{
                    quaotic = true;
                    break;
                }
            }

            total_swap+= item_swap;
        }
        if (quaotic){
            System.out.println("Too chaotic");
        }else{
            System.out.println(total_swap);
        }

    }


    public static void main(String[] args){
        List<Integer> kf = List.of(1 ,2 ,5, 3, 7, 8, 6 ,4);
        List<Integer> f = List.of(2 ,1 ,5, 3,4);
        minimumBribes(f);
    }
}
//Slower version of minimumBribes
class b{
    public static void minimumBribes(List<Integer> l) {
        int total_swap = 0;
        boolean quaotic = false;
        int[] q = l.stream().mapToInt(Integer::valueOf).toArray();
        for (int x=0;x<q.length;x++) {
            if (quaotic)break;
            int item_swap = 0;
            for (int y=x+1;y<q.length;y++) {
                if (q[x]>q[y]){
                    item_swap++;
                }
                if (item_swap>2){
                    quaotic = true;
                    break;
                }
            }
            total_swap+= item_swap;

        }
        if (quaotic){
            System.out.println("Too chaotic");
        }else{
            System.out.println(total_swap);
        }

    }

}
