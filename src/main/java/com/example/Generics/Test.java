package com.example.Generics;

import java.io.Serializable;
import java.util.Set;

public class Test {
    private static <B extends String> void getName(B t){
        System.out.println(t);
    }
    private static <B extends String> B getNames(B t){
        return t;
    }
    private static <B extends String & Serializable , Set> B betNames(B t){
        return t;
    }
    public static void main(String[] args)  {
        try {
            Make jk = new Make<>(1);
            jk.print();

        }catch (Exception e){
            //throw new Exception("Not accrpted"+e.getMessage());
        }
        getName("String");
    }
}
class Make<T>{
    T t;
    public Make(T t) {
        this.t = t;
    }

    public void print()  {
        //if (t.getClass() == String.class){
            Integer.parseInt((String) t);
    }

}
