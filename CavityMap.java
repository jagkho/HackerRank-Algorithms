import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CavityMap {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][n];
        int cc = n;
        
        for(int i=0;i<n;i++)
            {
            BigInteger val = in.nextBigInteger();
            while(!BigInteger.ZERO.equals(val))
                {
                cc-=1;
                Long tenValVar = new Long(10L);
                arr[i][cc] = val.mod(BigInteger.valueOf(tenValVar)).intValue();
                val = val.divide(BigInteger.valueOf(tenValVar));
            }
            cc=n;
        }
        
        for(int i=0;i<n;i++)
            {
            for(int j=0;j<n;j++)
                {
                if(i!=0 && j!=0 && i!=n-1 && j!=n-1)
                    {
                    if(arr[i-1][j]<arr[i][j] && arr[i+1][j]<arr[i][j] 
                       && arr[i][j+1]<arr[i][j] && arr[i][j-1]<arr[i][j])
                        {
                        System.out.print("X");
                    }
                    else
                        {
                        System.out.print(arr[i][j]);
                    }
                }
                else
                    {
                    System.out.print(arr[i][j]);
                }
            }
            System.out.println();
        }
    }
}