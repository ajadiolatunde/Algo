package com.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Node {
    public static class Node1 implements Serializable {
        int value;
        Node1 left,right;

        public Node1(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }

    }
    public static Node1 node;

    public static Node1 insertNode(Node1 current, int value){
        node = current;
        if (node == null) {
            node = new Node1(value);
            System.out.println("-----1----");
        }else {
            System.out.println("-----2----");

            if (node.value <= value){
                System.out.println("-----3l----");

                if (node.left == null) {
                    node.left = new Node1(value);
                }else{
                    insertNode(node.left,value);
                }
            }else{
                System.out.println("-----3r----");

                if (node.right == null) {
                    node.right = new Node1(value);
                }else{
                    insertNode(node.right,value);
                }
            }

        }

      return node;
    }
    static List<Integer> list = new ArrayList<>();
    static int count = 0;
    public static int countTrees(Node1 node){
        if (node != null ){
            list.add(node.value);
            System.out.println("node ---");
            count += 1;
            if (node.left != null){
                countTrees(node.left);
            }
            if (node.right != null){
                countTrees(node.right);
            }
        }else {
            return 0;
        }

        return count;
    }
    public static void main(String[] args){
        Node1 root = new Node1(45);
        insertNode(root,3);
        insertNode(root,10);
        insertNode(root,20);
        insertNode(root,40);
        insertNode(root,60);
        insertNode(root,31);
        insertNode(root,50);
        insertNode(root,25);
        insertNode(root,49);
        insertNode(root,70);

        System.out.println("Count----"+countTrees(root));



    }
}
