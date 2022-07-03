package com.example.Hackerrank;

public class TimeConversion {
    public static String timeConversion(String s) {
        String cate = s.substring(8,s.length());
        String res = s.substring(0,8);
        int hour =  Integer.valueOf(s.substring(0,2));
        String time = "";
        switch (cate){
            case "AM":
                if (hour==12){
                    String nk = "";
                    int lhour = hour-12;
                    if (lhour<10){
                        nk="0"+lhour;
                    }else{
                        nk = String.valueOf(lhour);
                    }
                    time = nk+s.substring(2,8);
                }else{
                    time = s.substring(0,8);
                }
                break;
            case "PM":
                if (hour<12){
                    int lhour = hour+12;

                    time = lhour +s.substring(2,8);
                }else{
                    time = s.substring(0,8);
                }
                break;
        }

        return time;


    }

    public static  void main(String[] args){
        String time = "07:05:45PM";
        System.out.println(timeConversion(time));
    }
}
