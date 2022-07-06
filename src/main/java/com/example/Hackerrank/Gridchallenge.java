package com.example.Hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Gridchallenge {
    /**
     *Given a square grid of characters in the range ascii[a-z], rearrange elements of each row alphabetically, ascending. Determine if the columns are also in ascending alphabetical order, top to bottom. Return YES if they are or NO if they are not.
     *
     * Example
     *
     * The grid is illustrated below.
     *
     * a b c
     * a d e
     * e f g
     *
     * The rows are already in alphabetical order. The columns a a e, b d f and c e g are also in alphabetical order, so the answer would be YES. Only elements within the same row can be rearranged. They cannot be moved to a different row.
     *
     * Function Description
     *
     * Complete the gridChallenge function in the editor below.
     *
     * gridChallenge has the following parameter(s):
     *
     *     string grid[n]: an array of strings
     *
     * Returns
     *
     *     string: either YES or NO
     *
     * Input Format
     *
     * The first line contains
     *
     * , the number of testcases.
     *
     * Each of the next
     * sets of lines are described as follows:
     * - The first line contains , the number of rows and columns in the grid.
     * - The next lines contains a string of length
     *
     * Constraints
     *
     *
     *
     * Each string consists of lowercase letters in the range ascii[a-z]
     *
     */
    public static String gridChallenge(List<String> grid) {
        List<char[]> kj = new ArrayList<>();
        grid.stream().map(x->{
            char[] c = x.toCharArray();
            Arrays.sort(c);
            kj.add(c);

            return new String(c);
        } ).collect(Collectors.toList());


        for (int c = 0; c < kj.get(0).length;c++){
            List<Character> nm = new ArrayList<>();
            for (char[] chars : kj) {
                nm.add(chars[c]);

            }
            boolean sorted = nm.stream().sorted().collect(Collectors.toList()).equals(nm);
            if (!sorted) return "NO";

        }
        System.out.println(kj);
        return "YES";

    }


    public static void main(String[] args){
        List<String> data = List.of( "fghij", "olmkn","ebacd", "trpqs", "xywuv");
        List<String> d1 = List.of("kc","iu");
        List<String> d2 = List.of("uxf" , "vof","hmp");

        System.out.println(gridChallenge(d1));
    }
}
