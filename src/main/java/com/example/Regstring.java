package com.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regstring {
    public static void main(String[] args){
        String test1 = "acc?7??sss?3rr1??????5";
        String test11 = "arrb6???4xxbl5???eee5";
        String text = "We are all doing 8???5t  for you";
        String str = text.replaceAll("\\w(?!o)","___");
        String str1 = text.replaceAll("(\\w)\\1\\1","___");
        String str3 = text.replaceAll("\\w(?!(\\w)\\1\\1)","___");
        String str4 = text.replaceAll("\\w(?!o)","___");
        Pattern pattern = Pattern.compile("(\\d.*?[?]{3}[a-z]*?\\d)");

        Matcher matcher = pattern.matcher(test11);
        //boolean find = matcher.find();
        if (matcher.find()){
            String gp = matcher.group(1).replaceAll("\\D","");
            int len = gp.length();
            String[] strs = gp.split("");
            for (int x = 0; x<len;x+=2){
                int first = Integer.valueOf(strs[x]);
                int second = Integer.valueOf(strs[x+1]);
                if (first+second != 10){
                    System.out.println("false");
                }else{
                    System.out.println("true");

                }

            }

            System.out.println(gp);
            System.out.println(strs.length);

            System.out.println("true");


        }else{
            System.out.println("false");

        }


        //System.out.println(test1.matches(".*((\\W)\\1\\1).*"));
    }
}
