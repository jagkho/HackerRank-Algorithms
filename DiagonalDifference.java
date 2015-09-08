package algorithms;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DiagonalDifference {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][n];
        
        for(int i=0;i<n;i++)
            {
            for(int j=0;j<n;j++)
                {
                arr[i][j] = in.nextInt();
            }
        }
        long sum1=0;long sum2=0;
        for(int i=0;i<n;i++)
            {
            for(int j=0;j<n;j++)
                {
                if(i==j)
                    sum1+=arr[i][j];
            }
        }
        int j=n-1;
        for(int i=0;i<n;i++)
            {
            sum2+=arr[i][j];
            j-=1;
        }
        System.out.println(Math.abs(sum1-sum2));
    }
}
