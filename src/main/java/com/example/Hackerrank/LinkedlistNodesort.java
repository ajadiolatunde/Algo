package com.example.Hackerrank;


import java.util.*;

import static javax.swing.UIManager.get;

class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;

    public SinglyLinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedlistNodesort {

    private static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode merge = head1;

        while (merge.next != null) {
                 merge = merge.next;;
        }
        merge.next = head2;
        // Generate list
        ArrayList<Integer> list = new ArrayList<>();
        while (head1 != null){
            list.add(head1.data);
            head1 = head1.next;
        }
        Collections.sort(list,Comparator.comparingInt(integer -> integer));
        System.out.println(list);
        for (int c=0;c<list.size();c++){
            if (head1 == null) {
                head1 = new SinglyLinkedListNode(list.get(c));
            }else{
                SinglyLinkedListNode last = head1;
                while(last.next != null){
                    last = last.next;
                }
                last.next = new SinglyLinkedListNode(list.get(c));;

            }

        }

        return head1;
    }

    public static void main(String[] args){
        SinglyLinkedListNode one = new SinglyLinkedListNode(1);

        SinglyLinkedListNode three = new SinglyLinkedListNode(3);

        SinglyLinkedListNode seven = new SinglyLinkedListNode(7);

        three.next = seven;
        one.next = three;

        SinglyLinkedListNode two = new SinglyLinkedListNode(2);

        SinglyLinkedListNode four = new SinglyLinkedListNode(4);

        SinglyLinkedListNode five = new SinglyLinkedListNode(5);
        two.next = four;
        four.next = five;
        five.next = null;

        SinglyLinkedListNode result =  mergeLists(one,two);
        while( result != null){
            System.out.println(result.data);
            result = result.next;

        }


    }
}



