package com.example.Hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Balancedbracket {

    /**
     * A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].
     *
     * Two brackets are considered to be a matched pair if the an
     * opening bracket (i.e., (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or }) of the
     * exact same type. There are three types of matched pairs of brackets: [], {}, and ().
     *
     * A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. For example, {[(])} is not balanced because the contents in between { and } are not balanced. The pair of square brackets encloses a single, unbalanced opening bracket, (,
     * and the pair of parentheses encloses a single, unbalanced closing square bracket, ].
     * @param s
     * @return
     */
    public static String isBalanced(String s) {
        String cl = "(";
        String cr = ")";
        String bl = "[";
        String br = "]";
        String vl = "{";
        String vr = "}";
        String[] sk = s.split("");
        if (s.length()%2 != 0)return "NO";
        int location = 0;
        List<String> st = new ArrayList<>();
        st.addAll(Arrays.asList(sk));
         while(location<st.size()-1 ){

             if (st.get(location).equals(cl) && st.get(location+1).equals(cr)){
                 st.remove(location);
                 st.remove(location);
                 location = 0;


             }else if(st.get(location).equals(bl) && st.get(location+1).equals(br)){
                st.remove(location);
                st.remove(location);
                location = 0;

            }else if(st.get(location).equals(vl) && st.get(location+1).equals(vr)){
                st.remove(location);
                st.remove(location);
                location = 0;
            }else{
                location++;
            }
        }
        System.out.println(String.join("", st));
         return (st.size()>=1)?"NO":"YES";
        // Write your code here

    }
    public static void main(String[] args){
         String pl = "{[()]}";
         String p2 = "()[]";
         System.out.println(p2.length());
         System.out.println( isBalanced(p2));

    }
}
