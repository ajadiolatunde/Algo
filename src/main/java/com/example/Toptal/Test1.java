package com.example.Toptal;

import java.util.Arrays;


public class Test1 {
    private static String[] Solution(String b,String[] a){
        double[] at = new double[a.length];
        final int[] count = {0};
        Arrays.stream(a).forEach(x->{
            at[count[0]] = Double.parseDouble(x);
            count[0]++;
         }
        );
        double s =Double.parseDouble(b);
        System.out.println(Arrays.toString(at));
        String[] sh = new String[at.length];

        for (int j =0;j<at.length;j++){
            double basevalue = Arrays.stream(Arrays.copyOfRange(at, j, at.length)).sum();
            double nd = s * (at[j]/basevalue);
            sh[j] = String.format("%.2f", nd);
            System.out.println(sh[j]+"-"+s+"--"+basevalue+"--"+at[j]);
            s -=  s * (at[j]/basevalue);
        }
        return sh;
    }
    public static void main(String[] args){
        String[] at1 = {"300.00","200.00","100.00"};
        String b= "300.01";
        String[] at2 = {"0.05","1.00"};
        String c= "1.00";
        String ans = Arrays.toString(Solution(c,at2));
        System.out.println(ans);


    }
}
