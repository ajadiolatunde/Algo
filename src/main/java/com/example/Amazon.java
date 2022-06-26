package com.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Amazon {
    //{adg124,adg133,adg141,adg212,adg241,adg321,adg314}
    public static void main(String[] ad){
        String as = "adg12";
        Pattern pattern = Pattern.compile("([a-z]+\\d)(\\d)(\\d)?");
        Matcher matcher = pattern.matcher(as);
        if (matcher.find()){
            System.out.println(matcher.group(3));

        }
    }
}
