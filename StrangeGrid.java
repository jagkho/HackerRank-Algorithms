import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class StrangeGrid {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
         Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int c = in.nextInt();
        //System.out.println(r+ " " + c);
        createGrid(r, c);
    }
    public static void createGrid(int r, int c)
        {
        try
            {
            long startValue = 0;
            if(r%2==0)
                {
                startValue = r/2-1;
                startValue = startValue*10 + 1;
                //System.out.println(startValue);
            }
            else
                {
                startValue = (r-1)/2;
                startValue = startValue*10;
                //System.out.println(startValue);
            }
            long rStart = startValue;
            long cStart = 0;
            for(int i=1;i<=r;i++)
                {
                cStart = rStart;
                for(int j=1;j<=5;j++)
                    {
                    //System.out.print(cStart + " ");
                    cStart+=2;
                    if(j==c) System.out.println(cStart-2);
                }
                //System.out.println();
                if(cStart%10==1) rStart = cStart-1;
                else rStart+=1;
                break;
            }
        }
        catch(Exception e)
            {
            throw e;
        }
    }
}