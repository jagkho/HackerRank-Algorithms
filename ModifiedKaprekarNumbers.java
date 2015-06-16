import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ModifiedKaprekarNumbers {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int low = in.nextInt();
        int high = in.nextInt();
        int foundCount = 0;
        
        for(int i=low; i<=high; i++)
            {
            if(isKaprekar(i)) 
                {
                foundCount+=1;
                if(i!=high)
                    {
                    System.out.print(i + " ");  
                }
                else
                    System.out.print(i); 
            }
        }
        if(foundCount==0)
            {
            System.out.println("INVALID RANGE");
        }
    }
    public static boolean isKaprekar(int i)
        {
        long squaredNumber = (long)Math.pow(i,2);
        if(splitExists(i, squaredNumber) || (i==1))
            return true;
        return false;
    }
    public static boolean splitExists(int num, long squaredNumber)
        {
        String snum = Long.toString(squaredNumber);
        for(int i=0;i<snum.length();i++)
            {
            if(tryParseInt(snum.substring(0, i)) && tryParseInt(snum.substring(i)))
                {
                Long first = Long.parseLong(snum.substring(0, i));
                Long second = Long.parseLong(snum.substring(i));
                if((first+second) == num && first!=0 && second!=0 && Math.abs(snum.substring(0, i).length()-snum.substring(i).length())<=1)
                    return true;
            }
        }
        return false;
    }
    public static boolean tryParseInt(String value)
        {
        try
            {
            Long.parseLong(value);  
            return true;  
        }
        catch(NumberFormatException e)
            {
            return false;
        }
    }
}