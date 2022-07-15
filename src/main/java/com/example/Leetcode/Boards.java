package com.example.Leetcode;

import java.util.*;

public class Boards {
    private static boolean exist(char[][] board,String words){

        /**
         * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
         *
         * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
         * @param board
         * @param word
         * @return
         */
        String word = words;
        int row_len = board.length;
        int col_len = board[0].length;
        Stack<Map<String,String>> tJunctions = new Stack<>();
        List<String>   word_coordList = new ArrayList<>();
        String next_position="00";

        for (int row=0;row<board.length;row++ ){
            for (int col=0;col<board[0].length;col++ ){
                //Try right
                System.out.println(word);
                System.out.println(word_coordList);
                if (word.length()<=1){
                    word_coordList.add(row+""+col);
                    word = "";
                    break;
                }
                char current = word.charAt(0);

                if (current== board[row][col]) {
                        //Then check for tjunctions
                        int count_tjunctions =0;
                        boolean down = false,up = false,back = false,forward = false;
                        //for down
                        if (row+1<row_len && !word_coordList.contains((row+1)+""+col) && word.charAt(1) == board[row+1][col] ){
                            count_tjunctions++;
                            down = true;
                        }
                        //for up
                        if (row>0 && !word_coordList.contains((row-1)+""+col) && word.charAt(1) == board[row-1][col] ){
                            up = true;
                            count_tjunctions++;
                        }
                        //Forward or column
                        if (col+1<col_len && !word_coordList.contains(row+""+(col+1)) && word.charAt(1) == board[row][col+1] ){
                            forward = true;
                            count_tjunctions++;
                        }
                        //backward
                        if (col>0 && !word_coordList.contains(row+""+(col-1)) && word.charAt(1) == board[row][col-1] ){
                            back = true;
                            count_tjunctions++;
                        }
                        if (count_tjunctions>1){
                            System.out.println(row+" "+col+"----more tj--------"+count_tjunctions);

                            word =word.replaceFirst(String.valueOf(current),"");
                             if (up){
                                 Map<String,String> mup = new HashMap<>();
                                 mup.put(word,(row-1)+" "+(col-1));
                                 tJunctions.add(mup);
                             }
                            if (down){
                                Map<String,String> mdown = new HashMap<>();
                                mdown.put(word,(row+1)+" "+(col-1));
                                tJunctions.add(mdown);
                            }
                            if (forward){
                                Map<String,String> mforward = new HashMap<>();
                                mforward.put(word,row+" "+col);
                                tJunctions.add(mforward);
                            }
                            if (back){
                                Map<String,String> mback = new HashMap<>();
                                mback.put(word,row+" "+(col-2));
                                tJunctions.add(mback);
                            }

                            //Add current
                            word_coordList.add(row+""+col);
                            //Remove found char from word
                            //Get next position fron stack;
                            Map<String,String> mnext = tJunctions.pop();
                            String[] rc = mnext.values().iterator().next().split(" ");
                            //System.out.println(Arrays.toString(rc));
                            System.out.print("more tj-at  "+row+" "+col+"-----------"+count_tjunctions+"   selected  ");
                            row = Integer.parseInt(rc[0]);
                            col= Integer.parseInt(rc[1]);
                            System.out.println(row+""+(col+1));
                            //No tjunctions
                        }else if (count_tjunctions == 1){
                            //Add current and move to next coord position
                            //and readjust word_coordList to suit current position
                            word_coordList.add(row+""+col);
                            word = word.replaceFirst(String.valueOf(current),"");


                            if (up){
                                row -= 1;
                                col -= 1;
                            }else if (down){
                                row +=1;
                                col -= 1;
                            }else if (forward){
                               col = col;
                            }
                            else{
                                col -= 2;
                            }
                        }else{
                            // Nothing found
                            // Move to next tjunction
                            if (tJunctions.size()>0) {
                                Map<String, String> mnext = tJunctions.pop();
                                String coord = mnext.values().iterator().next();
                                String[] rc = coord.split(" ");
                                row = Integer.parseInt(rc[0]);
                                col = Integer.parseInt(rc[1]);
                                //Restore  word to point of this tjunction
                                word = mnext.keySet().iterator().next();
                                System.out.println(word_coordList+"----before");
                                word_coordList = word_coordList.subList(0,words.length()-word.length());
                                System.out.println(word_coordList+"--executed next--tj--------"+word+"----"+row+""+(col+1));

                            }else{
                                // Else move to defaut loop and start all over
                                if (word_coordList.size()>0){
                                    String[] next_rc = word_coordList.get(0).split("");
                                    row = Integer.parseInt(next_rc[0]);
                                    col = Integer.parseInt(next_rc[1]);;
                                }
                                word_coordList.clear();
                                word = words;


                                System.out.println("Nothing next ---------------"+row+""+col);
                            }
                        }
                    }
            }
        }
        System.out.println(word);
        return word.isEmpty();
    }

    public static void main(String[] args){
        char[][] ev  = {{'a','b'},{'c','d'}};
        String v = "abd";
        char[][] ba = {{'b','b','b','a','b','b'},{'b','a','b','b','a','a'},{'b','a','b','a','a','a'},{'a','a','a','a','b','a'},{'a','a','b','b','b','a'},{'a','a','b','b','a','a'}};
        String b = "abbbbaabbbbb";
        char[][] ec =  {{'A','B','C','E'},{'S','F','S','S'},{'A','D','E','E'}};
        String e = "ABFSADE";
        System.out.println(exist(ba,b));
//        String test = "1-1";
//        String[] result = test.split("-?");
//        System.out.println(Arrays.toString(result));

    }
}
