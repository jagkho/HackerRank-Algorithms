import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SherlockAndTheBeast {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        long numberOfTestCases = in.nextLong();
        for(int i=0;i<numberOfTestCases;i++)
            {
            long n = in.nextLong();
            if(n==1 || n==2) System.out.println("-1");
            else
                getDecentNumber(n);
        }
    }
    public static void getDecentNumber(long n)
        {
        try
            {
            long j=n;
            long maxFiveCount = 0;
            long maxThreeCount = 0;
            
            for(int i=0; i<=n;i+=3)
                {
                if(i%3==0)
                    {
                    if(j%5==0)
                        {
                        if(i>maxFiveCount) maxFiveCount = i;
                        maxThreeCount = n-maxFiveCount;
                    }
                }
                if(maxFiveCount==0 && maxThreeCount == 0) maxThreeCount = n-maxFiveCount;
                j=j-3;
            }
            if(maxFiveCount%3!=0 || maxThreeCount%5!=0)
                {
                System.out.print("-1");
            }
            else
                {
                StringBuffer sb = new StringBuffer();
                while(maxFiveCount!=0)
                    {
                    sb.append("5");
                    maxFiveCount-=1;
                }
                System.out.print(sb);
                sb=null;
                sb = new StringBuffer();
                while(maxThreeCount!=0)
                    {
                    sb.append("3");
                    maxThreeCount-=1;
                }
                System.out.print(sb);
            }
            System.out.println();
        }
        catch(Exception e )
            {
            throw e;
        }
    }
}