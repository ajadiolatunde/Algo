package com.example.Toptal;

public class Test2 {
    public static String solution(int X) {
        int value = X;
        int  minutes = 60;
        int  hour = 60* minutes;
        int day = 24* hour;
        int week =  day * 7;
        int w,d,h,m,s,remain;

            if (value< minutes){
                return value+"s";
            }else if(value<hour){
                 m = value/minutes;
                 s = value % minutes;
                return m+"m"+s+"s";
            }else if(value < day){
                 h = value/hour;
                 m = (value -(h*hour))/minutes;
                 s =  (value -(h*hour))%minutes;
                return h+"h"+m+"m"+s+"s";

            }else if(value < week){
                 d = value/day;
                 remain = value -(d*day);
                 h = (remain)/hour;
                remain = remain - (h*hour);
                m =  remain /minutes;
                s = remain%minutes;
                return d+"d"+ h+"h"+m+"m"+s+"s";

            }else {
                w = value/week;
                remain = value -(w*week);
                d = remain/day;
                remain = remain - (d*day);
                h = remain/hour;
                remain = remain - (h*hour);
                m = remain/minutes;
                s = remain%minutes;
                return w+"w"+d+"d"+ h+"h"+m+"m"+s+"s";
            }

    }

    public static void main(String[] args){
       System.out.println( solution(100000));
    }
}
