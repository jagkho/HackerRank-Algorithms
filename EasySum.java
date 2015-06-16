import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class EasySum {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfTestCases = in.nextInt();
        for(int i=0;i<numberOfTestCases;i++)
            {
            Long n = in.nextLong();
            Long m = in.nextLong();
            Long sum = getEasySum(n, m);
            System.out.println(sum);
        }
    }
    public static long getEasySum(long n, long m)
        {
        try
            {
            /*long sum = 0;
            for(long i=1; i<=n; i++)
                {
                sum+=i%m;
            }*/
            long quotient = n/m;
            long remainder = n%m;
            long sum = (m-1)*m/2;
                
            return sum*quotient + remainder*(remainder+1)/2;
        }
        catch(Exception e)
            {
            throw e;
        }
    }
}