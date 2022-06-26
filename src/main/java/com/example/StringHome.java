package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringHome {
    public StringHome() {
    }
    public static void main(String[] args){
        String[] num = new String[] {"(1,2)", "(2,4)", "(5,7)", "(7,2)", "(9,5)"};
        Map<String, List<String>> map_parent = new HashMap<>();
        Map<String, List<String>> map_child = new HashMap<>();

        for (String x:num){
            String regex = "(\\d),(\\d)";
            Pattern pattern =  Pattern.compile(regex);
            Matcher matcher = pattern.matcher(x);
            //System.out.println(matcher.group().lines());

            while (matcher.find()){
                if (map_parent.containsKey(matcher.group(2))){
                    System.out.println("yes");
                    List<String> childlink = map_parent.get(matcher.group(2));
                    List<String> parentlink = map_parent.get(matcher.group(1));

                    childlink.add(matcher.group(1));
                    map_parent.put(matcher.group(2),childlink);

                    parentlink.add(matcher.group(2));
                    map_child.put(matcher.group(1),parentlink);
                    if (childlink.size()>2)return ;
                }else{
                    List<String> childlink = new ArrayList<>();
                    List<String> parentlink = new ArrayList<>();

                    childlink.add(matcher.group(1));
                    map_parent.put(matcher.group(2),childlink);
                    parentlink = new ArrayList<>();
                    parentlink.add(matcher.group(2));
                    map_child.put(matcher.group(1),parentlink);

                }

                System.out.println(matcher.group(2));
            }

        }
        System.out.println(map_parent.entrySet());
        System.out.println(map_child.entrySet());


    }
}
