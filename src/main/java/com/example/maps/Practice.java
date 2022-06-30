package com.example.maps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Practice {
    public static void main(String[] args){
        int mk[] = {2,3,4,1,3,2,4,5,6};
        List<Integer> kl = Arrays.stream(mk).boxed().collect(Collectors.toList());
        kl.remove(1);

        System.out.println();



    }
}
