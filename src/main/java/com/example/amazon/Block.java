package com.example.amazon;

import java.util.Arrays;

public class Block {
    private static int[][] store ;

    private static void getNearestBlock(String[][] block,String[] items,int startIndex){
        int row = block.length;
        int col = block[0].length;
        int count = 0;
        if (startIndex+1<0||startIndex >row){
            System.out.println("Failed");
        }else{
            //check left
            for (String item : items) {

                boolean stop = false;
                for (int i = startIndex; i >= 0; i--) {
                    if (stop)break;
                    for (int c=0;c<col; c++) {
                        if (item.equals(block[i][c])) {
                            store[startIndex][count] = Math.min(startIndex-i, store[startIndex][count]);
                            stop = true;
                            break;
                        }
                    }

                }
                count++;
            }
            //check right
            count = 0;
            for (String item : items) {
                boolean stop = false;

                for (int i=startIndex;i<row;i++) {
                    if (stop)break;
                    for (int c=0;c<col;c++){
                        if (item.equals(block[i][c])) {
                            store[startIndex][count] = Math.min(i-startIndex, store[startIndex][count]);
                            stop = true;
                            break;
                        }
                    }

                }
                count++;
            }

        }

    }

    private static  int getBlock(String[][] block,String[] items,int startIndex){
        while (startIndex<block.length){

            getNearestBlock(block,items,startIndex++);

        }
        Arrays.stream(store).forEach(a->System.out.println(Arrays.toString(a)));
        return 1;
    }


    public  static void main(String[] args){
        String[] item = {"rest","yam","church","cake","book"};
        String[][] blocks = {{"rest","hospital","yam","cake"},{"school","bike","church","cake"},{"rice","beans","car","cake"},{"rice","beans","church","girl"},{"pool","beans","yam","milk"},{"rice","beans","yam","hospital"},{"school","friends","yam","cake"}};
        store = new int[blocks.length][item.length];
        Arrays.stream(store).forEach(a -> Arrays.fill(a, blocks.length));
        getBlock(blocks,item,0);
    }
}
