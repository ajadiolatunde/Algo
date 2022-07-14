package com.example.Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Boards {
    private static boolean exist(char[][] board,String word,String start,List<String> visited_location){
        //if (word.length()<1) return false;
        String[] newstart = start.split("");
        int r = Integer.parseInt(newstart[0]);
        int c = Integer.parseInt(newstart[1]);
        int row_len = board.length;
        int col_len = board[0].length;
        boolean res = false;
        Stack<String> tJunctions = new Stack<String>();
        List<String>   word_coordList = new ArrayList<String>();
        boolean down = false,up = false,back = false,forward = false;


        for (int row=r;row<board.length;row++ ){
            for (int col=c;col<board[0].length;col++ ){
                    //Try right
                      char current = word.charAt(0);
                    if (current== board[row][col]) {
                        //Then check for tjunctions
                        int count_tjunctions =0;
                        //for down
                        if (row+1<row_len && !word_coordList.contains((r+1)+""+c) && word.charAt(1) == board[row+1][col] ){
                            count_tjunctions++;
                            down = true;
                        }
                        //for up
                        if (row>0 && !word_coordList.contains((r-1)+""+c) && word.charAt(1) == board[row-1][col] ){
                            up = true;
                            count_tjunctions++;
                        }
                        //Forward or column
                        if (col+1<col_len && !word_coordList.contains((r)+""+c+1) && word.charAt(1) == board[row][col+1] ){
                            forward = true;
                            count_tjunctions++;
                        }
                        //backward
                        if (col>0 && !word_coordList.contains((r)+""+c+1) && word.charAt(1) == board[row][col-1] ){
                            back = true;
                            count_tjunctions++;
                        }
                        if (count_tjunctions>1){
                             if (up)tJunctions.add((row-1)+""+col);
                            if (down)tJunctions.add((row+1)+""+col);
                            if (forward)tJunctions.add(row+""+(col+1));
                            if (back)tJunctions.add(row+""+(col-1));


                        }

                    }



            }
        }
        return true;
    }

    public static void main(String[] args){
        char[][] ev  = {{'a','b'},{'c','d'}};
        String v = "abcd";
        System.out.println(exist(ev,v,"00",new ArrayList<>()));

    }
}
