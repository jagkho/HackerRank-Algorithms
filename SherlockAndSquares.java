import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SherlockAndSquares {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfTestCases = in.nextInt();
        HashMap<BigInteger, Boolean> seenValues = new HashMap<BigInteger, Boolean>();
        for(int i=0;i<numberOfTestCases;i++)
            {
            Integer squareCount = 0;
            BigInteger a = in.nextBigInteger();
            BigInteger b = in.nextBigInteger();
            for(;a.compareTo(b)<=0;a=a.add(BigInteger.valueOf(1)))
                {
                //2, 3, 7 or 8 
                if(!a.mod(BigInteger.valueOf(10)).equals(BigInteger.valueOf(2)) &&                   !a.mod(BigInteger.valueOf(10)).equals(BigInteger.valueOf(3)) && !a.mod(BigInteger.valueOf(10)).equals(BigInteger.valueOf(7)) && !a.mod(BigInteger.valueOf(10)).equals(BigInteger.valueOf(8)))
                    {
                    BigDecimal root = getSquareRoot(a);
                    BigDecimal square = root.multiply(root);
                    BigDecimal difference = square.subtract(new BigDecimal(a));
                    if(seenValues.containsKey(a))
                        {
                        Boolean bool = seenValues.get(a);
                        //System.out.println(a + " " + bool);
                        if(bool) squareCount+=1;
                    }
                    else
                        {
                        if(difference.compareTo(BigDecimal.valueOf(0)) == -1)
                            {
                            difference = difference.multiply(BigDecimal.valueOf(-1));
                        }
                        if(difference.compareTo(BigDecimal.valueOf(0)) <= 0.0000000000001)
                            {
                            //System.out.println(a);
                            seenValues.put(a, true);
                            squareCount+=1;
                        }
                        else
                            {
                            seenValues.put(a, false);
                        }
                    }
                }
            }
            System.out.println(squareCount);
            squareCount = 0;
        }
    }
    public static BigDecimal getSquareRoot(BigInteger bi)
        {
        try
            {
            BigDecimal begin = BigDecimal.valueOf(0);
            BigDecimal end = new BigDecimal(bi);
            BigDecimal diff = end.subtract(begin);
            BigDecimal bd = begin.add(end);
            BigDecimal mid = bd.divide(BigDecimal.valueOf(2));
            
            while(diff.compareTo(BigDecimal.valueOf(0.0000000000001))>=0)
                {
                bd = begin.add(end);
                mid = bd.divide(BigDecimal.valueOf(2));
                BigDecimal potentialRootsSquare = mid.multiply(mid);
                if(potentialRootsSquare.compareTo(new BigDecimal(bi)) == 0) return mid;
                else if(potentialRootsSquare.compareTo(new BigDecimal(bi))>0) 
                    {
                    end = mid;
                }
                else if(potentialRootsSquare.compareTo(new BigDecimal(bi))<0)
                    {
                    begin = mid;
                }
                diff = end.subtract(begin);
            }
            mid = mid.setScale(10, RoundingMode.HALF_EVEN);
            //mid = mid.setScale(10, RoundingMode.CEILING);
            return mid;
        }
        catch(Exception e)
            {
            throw e;
        }
    }
}