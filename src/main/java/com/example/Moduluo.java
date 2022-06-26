package com.example;

import java.awt.*;
import java.util.ArrayList;

public class Moduluo {
    public static void main(String[] argg){
        String[] alll =new String[]{"(1,2)", "(2,4)", "(5,7)", "(7,2)", "(9,5)"};
        for (String x:alll){
            char[] cc = x.toCharArray();
            System.out.println(cc);

            String[] list = new String(cc)
                    .replace("(","")
                    .replace(")","").split(",");
            System.out.println(list[1]);

        }

    }
}
