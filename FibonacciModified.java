import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FibonacciModified {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        Integer a = in.nextInt();
        Integer b = in.nextInt();
        Integer n = in.nextInt();
        //System.out.println(a+ " " + b + " " + n);
        System.out.println(calculateNthTerm(a, b, n));
    }
    public static BigInteger calculateNthTerm(Integer a, Integer b, Integer n)
        {
        try
            {
            BigInteger c = BigInteger.valueOf(0);
            BigInteger la = BigInteger.valueOf(a);
            BigInteger lb = BigInteger.valueOf(b);
          
            for(int i=3;i<=n;i++)
                {
                c = la.add(lb.pow(2));
                la = lb;
                lb = c;
                //System.out.println(c);
            }
            return c;
        }
        catch(Exception e)
            {
            throw e;
        }
    }
}