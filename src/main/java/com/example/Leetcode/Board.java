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
        List<String> visited_location = new ArrayList<String>();
        List<String> next = Arrays.stream(word.split("")).collect(Collectors.toList());
        System.out.println(next);
        boolean found = false;
        boolean row_col_j = false;
        boolean col_up_j = false;
        boolean reset = false;
        String resetlocation = "";
        if (word.length()> board.length * board[0].length) return false;
        int mined_size_at_tjunction = 0;
        for(int r=0;r<board.length;r++){

            for(int c=0;c<board[0].length;c++){
                System.out.print(next);
                System.out.print(" ------------ ");
                System.out.println(visited_location);

                String current_location  = r+""+c;

                if (!visited_location.contains(current_location)){

                    char ch = board[r][c];
                    if (String.valueOf(ch).equals(next.get(0))){
                        if (next.size() ==1) {
                            found = true;
                            return found;
                        }
                        //Record T junction points for forward and down;
                        if (r+1<board.length && String.valueOf(board[r+1][c]).equals(next.get(1)) && c+1<board[0].length && String.valueOf(board[r][c+1]).equals(next.get(1))){
                            //Row and Column
                            if (!visited_location.contains(r+""+(c+1)) && !visited_location.contains((r+1)+""+c)) {
                                row_col_j = true;
                                mined_size_at_tjunction = visited_location.size() + 1;
                                System.out.println(mined_size_at_tjunction+"-row--lv-");

                            }
                        } else if (r>0 && String.valueOf(board[r-1][c]).equals(next.get(1)) && c+1<board[0].length && String.valueOf(board[r][c+1]).equals(next.get(1))){
                            //Column and Up
                            if (!visited_location.contains(r+""+(c+1)) && !visited_location.contains((r-1)+""+c)) {
                                col_up_j = true;
                                mined_size_at_tjunction = visited_location.size() + 1;
                            }
                        }

                        //Try Row
                        if (r+1<board.length && String.valueOf(board[r+1][c]).equals(next.get(1)) && !visited_location.contains((r+1)+""+c)){
                            //Add previous location
                            visited_location.add(r+""+c);
                            next.remove(0);
                            r = r+1;
                            c = c-1;

                            //Try column
                        }else if(c+1<board[0].length && String.valueOf(board[r][c+1]).equals(next.get(1))&& !visited_location.contains(r+""+(c+1))){
                            visited_location.add(r+""+c);
                            next.remove(0);
                           // c = c+;
                            //Try backward
                        }else if (c>0 && String.valueOf(board[r][c-1]).equals(next.get(1)) && !visited_location.contains(r+""+(c-1))){
                                visited_location.add(r+""+c);
                                next.remove(0);
                                c= c-2;
                        //Upward
                        }else if (r>0 && String.valueOf(board[r-1][c]).equals(next.get(1)) && !visited_location.contains((r-1)+""+c)){
                            visited_location.add(r+""+c);
                            next.remove(0);
                            r = r- 1;
                            c= c-1;


                        }else if (visited_location.size()>0){
                            //Start from last junction
                            System.out.println(visited_location+"-s--lv-");

                            if (row_col_j){
                                System.out.println(visited_location+"-r--lv-");

                                visited_location = visited_location.subList(0,mined_size_at_tjunction);
                                String[] nloc = visited_location.get(visited_location.size()-1).split("");
                                r = Integer.parseInt(nloc[0]);
                                c = Integer.parseInt(nloc[1]);
                                row_col_j = false;
                                next = Arrays.stream(word.split("")).collect(Collectors.toList());
                                next = next.subList(mined_size_at_tjunction+1,next.size());
                                mined_size_at_tjunction = 0;
                            }else if(col_up_j){
                                System.out.println(visited_location+"-c1--lv-"+mined_size_at_tjunction);

                                visited_location = visited_location.subList(0,mined_size_at_tjunction);
                                System.out.println(visited_location+"-c2--lv-");
                                String[] nloc = visited_location.get(visited_location.size()-1).split("");
                                r = Integer.parseInt(nloc[0])-1;
                                c = Integer.parseInt(nloc[1]);
                                col_up_j = false;
                                next = Arrays.stream(word.split("")).collect(Collectors.toList());
                                next = next.subList(mined_size_at_tjunction+1,next.size());
                                mined_size_at_tjunction = 0;
                            }
                            else{
                                //Clear out
                                System.out.println("Cleared ");
                                reset = true;
                                resetlocation =  visited_location.get(0);
                                String[] start_from  =resetlocation.split("");
                                r = Integer.parseInt(start_from[0]);
                                c = Integer.parseInt(start_from[1]);
                                visited_location.clear();
                                //visited_location.add(resetlocation);
                                next = Arrays.stream(word.split("")).collect(Collectors.toList());

                            }

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
        String w = "ASEENN";
        char[][] c= {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        String word = "ABCESEEEFS";
        char[][] j =  {{'b','a','b'},{'b','b','a'},{'b','b','b'}};
        String s = "ab";

       char[][] ww = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
      String d= "ABCEFSADEESE";

        char[][] ec =  {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String wc = "SEE";

        char[][] ev  = {{'a','b'},{'c','d'}};
        String v = "abcd";

        char[][] ba = {{'b','b','b','a','b','b'},{'b','a','b','b','a','a'},{'b','a','b','a','a','a'},{'a','a','a','a','b','a'},{'a','a','b','b','b','a'},{'a','a','b','b','a','a'}};
        String bas = "abbbbaabbbbb";


        System.out.println(exist(ba,bas));
    }
}
