package com.example.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Board {
    /**
     * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
     *
     * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
     * @param board
     * @param word
     * @return
     */
    private static boolean exist(char[][] board,String word){
        List<String> mined_location = new ArrayList<String>();
        List<String> next = Arrays.stream(word.split("")).collect(Collectors.toList());
        System.out.println(next);
        boolean found = false;
        for(int r=0;r<board.length;r++){
            if (found)break;
            for(int c=0;c<board[0].length;c++){
                if (found)break;
                String current_location  = r+""+c;
                if (!mined_location.contains(current_location)){
                    char ch = board[r][c];
                    if (String.valueOf(ch).equals(next.get(0))){
                        if (next.size() ==1) {
                            found = true;
                            break;
                        }
                        //Try Row
                        if (r+1<board.length && String.valueOf(board[r+1][c]).equals(next.get(1))){
                            //Add previous location
                            mined_location.add(r+""+c);
                            next.remove(0);
                            r = r+1;
                            c = c-1;
                            //Try column
                        }else if(c+1<board[0].length && String.valueOf(board[r][c+1]).equals(next.get(1))){
                            mined_location.add(r+""+c);
                            next.remove(0);
                           // c = c+;
                            //Try backward
                        }else if (c>0 && String.valueOf(board[r][c-1]).equals(next.get(1))){
                                mined_location.add(r+""+c);
                                next.remove(0);
                                c= c-2;
                        //Upward
                        }else if (r>0 && String.valueOf(board[r-1][c]).equals(next.get(1))){
                            mined_location.add(r+""+c);
                            next.remove(0);
                            r = r- 1;
                            c= c-1;

                        }else if (mined_location.size()>0){
                            //Start all over
                            String[] start_from  = mined_location.get(0).split("");
                            r = Integer.parseInt(start_from[0]);
                            c = Integer.parseInt(start_from[1]);
                            mined_location.clear();
                            next = Arrays.stream(word.split("")).collect(Collectors.toList());
                            next.remove(0);
                        }
                    }

                }
            }
        }
        System.out.println(next);
        return found;
    }
    public static void main(String[] args){
        char[][] b = {{'A','S','C'},{'S','E','R'},{'A','E','Y'},{'N','N','Y'}};
       System.out.println(exist(b,"A"));
    }
}
