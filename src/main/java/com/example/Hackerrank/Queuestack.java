package com.example.Hackerrank;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Queuestack {
    public static void main(String[] args){
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
