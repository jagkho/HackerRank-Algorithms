import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ManasaAndStones {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfTestCases = in.nextInt();
        for(int i=0;i<numberOfTestCases;i++)
            {
            int numberOfStones = in.nextInt();
            int originala = in.nextInt();
            int originalb = in.nextInt();
            int a = Math.min(originala, originalb);
            int b = Math.max(originala, originalb);
            Integer current = a * numberOfStones;
            int max = b * numberOfStones;
            int difference = b - a;
            if(a == b){
                numberOfStones-=1;
                current = a * numberOfStones;
                System.out.println(current);
            }
            else{
                StringBuilder ansString = new StringBuilder();
                while(current < max){
                    Integer res = current-a;
                    ansString.append(res.toString() + " ");
                    current += difference;
                }
                System.out.println(ansString);
            }
        }
    }
}