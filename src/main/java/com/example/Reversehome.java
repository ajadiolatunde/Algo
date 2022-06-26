package com.example;

import java.nio.charset.StandardCharsets;

public class Reversehome {
    public static void main(String[] args){
        String text = "I Love Code";
        String reverse="";
        String out = new StringBuffer(text).reverse().toString();
       for (int x = 0;x <=text.length(); x++){
            reverse+= text.charAt(text.length()-x);
        }
        System.out.println(reverse);
        System.out.println(out);
        char[] cc = text.toCharArray();
        String out2 = new String(cc);

    }
}
