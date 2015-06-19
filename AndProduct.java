import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AndProduct {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfTestCases = in.nextInt();
        for(int i=0;i<numberOfTestCases;i++)
            {
            BigInteger lowerBound = in.nextBigInteger();
            BigInteger upperBound = in.nextBigInteger();
            
            BigInteger res = lowerBound;
            while(upperBound.compareTo(lowerBound) > 0)
                {
                upperBound = upperBound.and(upperBound.subtract(BigInteger.valueOf(1)));
            }
            res = lowerBound.and(upperBound);
            System.out.println(res);
        }
    }
}