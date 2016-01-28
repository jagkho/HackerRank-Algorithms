package algorithms;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TimeInWords {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int h = in.nextInt();
        int m = in.nextInt();
        String[] hour = {"zero","one","two","three","four","five","six","seven","eight","nine", "ten","eleven","twelve","thirteen","fourteen","fifteen"};
        String[] tens = {"zero","teen","twenty","thirty","forty","fifty"};
        if(m==0) System.out.println(hour[h] + " o' clock");
        else if(m==30) System.out.println("half past " + hour[h]);
        else{
            if(m==1) System.out.println(hour[m] + " minute past " + hour[h]);
            else if(m>1 && m<30){
                if(m<15) System.out.println(hour[m] + " minutes past " + hour[h]);
                else if(m==15) System.out.println("quarter past " + hour[h]);
                else if(m>15 && m<20){
                    int minuteOnes = m%10;
                    System.out.println(hour[minuteOnes] + tens[1] + " minutes past " + hour[h]);
                }
                else{
                    int minuteTens = m/10;
                    int minuteOnes = m%10;
                    if(minuteOnes==0)
                        System.out.println(tens[minuteTens] + " minutes past " + hour[h]);
                    else System.out.println(tens[minuteTens] + " " + hour[minuteOnes] + " minutes past " + hour[h]);
                }
            }
            else if(m>30){
                int remainingMinutes = 60-m;
                if(remainingMinutes == 1) System.out.println(hour[remainingMinutes] + " minute to " + hour[h+1]);
                else if(remainingMinutes == 15) System.out.println("quarter to " + hour[h+1]);
                else if(remainingMinutes>1 && remainingMinutes<15) 
                    System.out.println(hour[remainingMinutes] + " minutes to " + hour[h+1]);
                else{
                    int minuteTens = remainingMinutes/10;
                    int minuteOnes = remainingMinutes%10;
                    if(minuteOnes == 0)
                        System.out.println(tens[minuteTens] + " minutes to " + hour[h+1]);
                    else 
                        System.out.println(tens[minuteTens] + " " + hour[minuteOnes] + " minutes to " + hour[h+1]);
                }
            }
        }
    }
}
