import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CounterGame {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfTestCases = in.nextInt();
        for(int i=0;i<numberOfTestCases;i++)
            {
            BigInteger num = in.nextBigInteger();
            Character currentTurn = 'R';
            Character nextTurn = 'L';
            if(num.equals(BigInteger.valueOf(1))) System.out.println("Richard");
            else
                {
                while(!num.equals(BigInteger.valueOf(1)))
                    {
                    Character temp = currentTurn;
                    currentTurn = nextTurn;
                    nextTurn = temp;
                    if(isPowerOfTwo(num))
                        {
                        num=num.divide(BigInteger.valueOf(2));
                    }
                    else
                        {
                        BigInteger bi = getLargestPowerOfTwo(num);
                        num = num.subtract(bi);
                    }
                }
                if(currentTurn == 'R')
                    {
                    System.out.println("Richard");
                }
                else
                    System.out.println("Louise");
            }
        }
    }
    public static boolean isPowerOfTwo(BigInteger num)
        {
        return BigInteger.valueOf(0).equals(num.and(num.subtract(BigInteger.valueOf(1))));
    }
    public static BigInteger getLargestPowerOfTwo(BigInteger num)
        {
        int exp = 0;
        while(true)
            {
            if(BigInteger.valueOf(2).pow(exp).compareTo(num)==-1)
                {
                exp+=1;
            }
            else 
                {
                break;
            }
        }
        return BigInteger.valueOf(2).pow(exp-1);
    }
}