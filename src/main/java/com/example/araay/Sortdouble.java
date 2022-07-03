package com.example.araay;

import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Sortdouble {
    public static void main(String[] args) {
        List<Double> testList = new ArrayList<>();
        AtomicInteger gh = new AtomicInteger(6);
        Semaphore semaphore = new Semaphore(3);
        testList.add(0.5);

        System.out.println(gh.incrementAndGet());
        testList.add(0.2);
        testList.add(0.9);
        testList.add(0.1);
        testList.add(0.1);
        System.out.println(testList);
        Collections.reverse(testList);
        testList.sort(Comparator.reverseOrder());
        System.out.println(testList);
        Queue<Integer> myqueue =  new LinkedList<>();;
        Scanner scanner = new Scanner(System.in);
        int count  = 0;
        int queries = Integer.parseInt(scanner.nextLine());
        while (count<queries){
            System.out.print("Read next value--: ");
            String input = scanner.nextLine();
            String[] inputs = input.split(" ");

            if (inputs.length>1){
                myqueue.add(Integer.parseInt(inputs[1]));
            }else{
                switch (inputs[0]){
                    case "2":
                        myqueue.remove();
                        break;
                    case "3":
                        System.out.println(myqueue.peek());

                }
            }
            count++;
        }


    }
}
 