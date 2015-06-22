import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ExtraLongFactorials {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        Integer n = in.nextInt();
        if(n!=0)
            {
            BigInteger fact = BigInteger.valueOf(1);
            for(int i=1;i<=n;i++)
                {
                fact = fact.multiply(BigInteger.valueOf(i));
            }
            System.out.println(fact); 
        }
        else
            System.out.println(n);
    }
}