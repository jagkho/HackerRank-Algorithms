import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AVeryBigSum {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        BigInteger sum = BigInteger.valueOf(0);
        for(int i=0;i<n;i++)
            {
            BigInteger bi = in.nextBigInteger();
            sum = sum.add(bi);
        }
        System.out.println(sum);
    }
}