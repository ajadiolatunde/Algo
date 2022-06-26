package com.example.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class Bitmapholes {
    private static int getNumber(List<String> arrays) {
        int count = 0;
        int col_len = arrays.get(0).length();
        int row_len = arrays.size();
        System.out.println(col_len + " " + row_len);
        List<String> cordinates = new ArrayList<>();
        boolean found = false;
        for (int r=0;r<row_len;r++){
            for (int c=0;c<col_len;c++){
                char current = arrays.get(r).charAt(c);
                if (String.valueOf(current).equals("0")){
                    //check column
                    for (int x=c+1;x<col_len;x++){
                        if (String.valueOf(arrays.get(r).charAt(x)).equals("0")){
                            if (!cordinates.contains(r+""+x)){
                                cordinates.add(r+""+x);
                                found= true;
                            }

                        }else{
                            break;
                        }
                    }
                    if (found){
                        if (!cordinates.contains(r+""+c))cordinates.add(r+""+c);
                        count++;
                    }
                    found = false;
                    //check row
                    for (int x=r+1;x<row_len;x++){
                        if (String.valueOf(arrays.get(x).charAt(c)).equals("0")){
                            if (!cordinates.contains(x+""+c)){
                                cordinates.add(x+""+c);
                                found= true;
                            }

                        }else{
                            break;
                        }
                    }
                    if (found){
                        if (!cordinates.contains(r+""+c)) cordinates.add(r+""+c);
                        count++;
                    }
                    found = false;
                }
            }
        }
        System.out.println(cordinates);
        System.out.println(count);
        return count;
    }
    public static void main(String[] args){
        List<String> arrays5 = Arrays.asList("01111", "01001", "00001", "11110");//return is 4
        List<String> arrays3 = Arrays.asList("01111", "01101", "00001", "11110");//return is 3
        List<String> arrays2 = Arrays.asList("01111", "01101", "00011", "11110");//return is 2

        assertEquals(getNumber(arrays3),3);
        assertEquals(getNumber(arrays5),5);
        assertEquals(getNumber(arrays2),3);

    }
}
