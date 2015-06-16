import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class IsFibo {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        try
            {
            Scanner in = new Scanner(System.in);
            int numberOfElements = in.nextInt();
            ArrayList<Long> list = new ArrayList<Long>();
            for(long i=0;i<numberOfElements;i++)
                {
                list.add(in.nextLong());
            }
            for(int i=0;i<numberOfElements;i++)
                {
                if(isFibonacciNumber(list.get(i))) System.out.println("IsFibo");
                else System.out.println("IsNotFibo");
            }
        }
        catch(Exception e)
            {
            System.out.println(e);
        }
    }
    public static boolean isFibonacciNumber(long val)
        {
        try
            {
            long count = 10;
            long a=0;
            long b=1;
            long c=0;
            for(long i=2;i<=count;i++)
                {
                c=a+b;
                a=b;
                b=c;
                if(c>val) return false;
                if(c==val) return true;
                if(c<val && i==count) count+=10;
            }
            return false;
        }
        catch(Exception e)
            {
            throw e;
        }
    }
}