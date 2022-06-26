package com.example;

import java.util.*;

public class LinkedNode {
    Node head;
    static class Node{
        int value;
        Node next;
        Node(int value){
            this.value= value;
            this.next= null;
        }
    }
    public static void main(String[] args) {
        LinkedNode linkedList = new LinkedNode();
        linkedList.head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        linkedList.head.next = node2;
        node2.next = node3;
        node3.next = node4;

        Node n = linkedList.head;
        System.out.println("----" + n);
        Stack<Node> list = new Stack<>();
        while (n != null) {

            System.out.println(n.value);
            list.add(0, n);
            n = n.next;

        }

        Node pre = null;
        LinkedNode relink = new LinkedNode();
        relink.head = new Node(list.get(0).value);

        List<Integer> my = new ArrayList<>(Arrays.asList(5, 1, 2, 4));
        my.forEach(System.out::println);
        for (int x=0;x<my.size();x++){
           if (x!=my.size()-1) {
               if (my.get(x) > my.get(x + 1)) {
                   int temp = my.get(x);
                   my.set(x, my.get(x + 1));
                   my.set(x + 1, temp);
               }
           }

        }
        my.forEach(System.out::println);



    }
}
