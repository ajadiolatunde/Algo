package com.example.Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Boards {
    private static boolean exist(char[][] board,String words,String start){
        //if (word.length()<1) return false;
        String word = words;
        String[] newstart = start.split("");
        int r = Integer.parseInt(newstart[0]);
        int c = Integer.parseInt(newstart[1]);
        int row_len = board.length;
        int col_len = board[0].length;
        boolean res = false;
        Stack<String> tJunctions = new Stack<String>();
        List<String>   word_coordList = new ArrayList<String>();



        for (int row=r;row<board.length;row++ ){
            for (int col=c;col<board[0].length;col++ ){
                    //Try right
                      char current = word.charAt(0);
                    if (current== board[row][col]) {
                        //Then check for tjunctions
                        int count_tjunctions =0;
                        boolean down = false,up = false,back = false,forward = false;
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
                            if (forward)tJunctions.add(row+""+col);
                            if (back)tJunctions.add(row+""+(col-2));
                            //Add current
                            word_coordList.add(r+""+c);
                            //Remove found char from word
                            word.replaceFirst(String.valueOf(current),"");
                            //Get next position fron stack;
                            String[] rc = tJunctions.pop().split("");
                            r = Integer.parseInt(rc[0]);
                            c= Integer.parseInt(rc[1]);


                            //No tjunctions
                        }else if (count_tjunctions == 1){
                            //Add current and move to next coord position
                            word_coordList.add(r+""+c);
                            if (up){
                                row -= 1;
                            }else if (down){
                                row +=1;
                            }else if (forward){
                               col = col;
                            }
                            else{
                                col -= 2;
                            }

                        }else{
                            // Nothing found
                            // Move to next tjunction
                        }

                    }



            }
        }
        return true;
    }

    public static void main(String[] args){
        char[][] ev  = {{'a','b'},{'c','d'}};
        String v = "aaabaacd";
        String w = v.replaceFirst("a","");
        System.out.println(w);
        //System.out.println(exist(ev,v,"00"));

    }
}
