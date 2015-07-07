import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FindDigits {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i=0;i<n;i++)
            {
            int count=0 ;
            long num = in.nextLong();
            long originalNumber = num;
            while(num!=0)
                {
                int digit = (int)num%10;
                if(digit!=0 && originalNumber%digit==0) count+=1;
                num = num/10;
            }
            System.out.println(count);
        }
    }
}