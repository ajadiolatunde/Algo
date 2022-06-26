package com.example.collection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

public class Compareee {

    @NoArgsConstructor
    @Data
    @Builder
    @AllArgsConstructor
    private static class student implements Comparator<String> {
        String name;
        int age;

        @Override
        public int compare(String s, String t1) {
            return s.compareTo(t1);
        }

        @Override
        public String toString() {
            return "student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
    public static void main (String[] args){
//        List<student> list = new ArrayList<>();
//        list.add(student.builder().age(4).name("semilore").build());
//        list.sort(Comparator.comparing(student -> student.name));
//        System.out.println(list);
    }
}
