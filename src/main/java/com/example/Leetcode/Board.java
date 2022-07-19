package com.example.Leetcode;

import org.jetbrains.annotations.NotNull;

public class Board {
    static boolean[][] visited;

    private static boolean exist(char[][] board,String word){
        int col = board[0].length;
        int row = board.length;
        visited = new boolean[row][col];
        for (int r =0;r<row;r++ ){
            for (int c =0;c<col;c++){
                if (word.charAt(0) == board[r][c] &&  search(board,word,0,r,c)){
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean search(char[][] board, @NotNull String word, int index, int rj, int cj){
        if (index == word.length() ) return true;
        if (rj<0 || rj>= board.length || cj<0 || cj>= board[0].length || visited[rj][cj] || word.charAt(index) != board[rj][cj])return false;
        visited[rj][cj] = true;
        if (search(board,word,index+1,rj-1,cj) ||
                search(board,word,index+1,rj+1,cj)||
                search(board,word,index+1,rj,cj+1) ||
                search(board,word,index+1,rj,cj-1))
            return true;

        visited[rj][cj] = false;

        return false;
    }

    public static void main(String[] args){
        char[][] ec =  {{'C','B','C','E'},{'S','F','S','S'},{'A','D','E','E'}};
        String e = "SADEE";
        System.out.println(exist(ec,e));
    }
}
