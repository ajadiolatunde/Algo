package com.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class oladfd {
    public static void main(String[] argds){
        String s = "()))";
        Pattern pattern = Pattern.compile("([)])");
        Matcher matcher = pattern.matcher(s);
        Pattern pattern1 = Pattern.compile("([)])");
        Matcher matcher2 = pattern1.matcher(s);
        int count1 = 0;
        int count2 = 0;
        while (matcher.find()){
            count2++;
            System.out.println(matcher.group());
        }
        while (matcher2.find()){
            count1++;
           // System.out.println(matcher.group());
        }

        System.out.println();

    }
}
