package com.example.Hackerrank;

public class Pagecount {
    private static int pgcountfromLeft(int pn,int sp){
        //Looking from left
        int x = 1;
        int count = 0;

        while (x<=pn){

            if (x ==1){
                if (sp==x){
                    System.out.println(count);
                    return count;
                }
            }else {
                if (sp==x || sp==x-1){
                    System.out.println(count);
                    return count;
                }
            }
            x+=2;
            count++;
        }
        System.out.println(count);
        return count;
    }

    private static int pgcountfromRight(int pn,int sp){
        //Looking from right
        int x = pn;
        boolean even = (pn%2 )==0;
        int count = 0;
        while (x<=pn){

            if (even ){
                if (sp==pn){
                    System.out.println(count);
                    return count;
                }
                even = false;
                x--;
            }else {
                if (sp==x || sp==x+1){
                    System.out.println(count);
                    return count;
                }
                x-=2;
            }
            count++;
        }
        System.out.println(count);
        return count;
    }
    public static void main(String[] args){
        //pgcountr(8,5);
    }
}
