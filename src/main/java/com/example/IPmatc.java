package com.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPmatc {
    public static void main(String[] args){
//        Scanner scan = new Scanner(System.in);
//        String name = scan.nextLine();
        String name = "00.12.123.123";
        System.out.println(name);
        Pattern pattern = Pattern.compile("(([0-9]{1,3})\\.){3}\\d{3}$");
        Matcher matches = pattern.matcher(name);
        if (matches.find()){
            System.out.println(matches.group());

            System.out.println("true");

        }else{
            System.out.println("false");

        }
    }
}
