import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SongOfPi {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfRecords = in.nextInt();
        in.nextLine();
        String pi = "3.1415926535897932384626433833";
        for(int i=0;i<numberOfRecords;i++)
            {
            String s = in.nextLine();
            if(isPiSong(s, pi)) System.out.println("It's a pi song.");
            else System.out.println("It's not a pi song.");
        }
    }
    public static boolean isPiSong(String s, String pi)
        {
        int piIndex = 0;
        int charCount = 0;
        
        for(int i=0;i<s.length();i++)
            {
            if(s.charAt(i)==' ') 
                {
                if(Character.getNumericValue(pi.charAt(piIndex)) == charCount)
                    {
                    piIndex+=1;
                    charCount = 0;
                }
                else if(pi.charAt(piIndex) == '.')
                    {
                    piIndex+=1;
                    i-=1;
                }
                else return false;            
            }
            else charCount+=1;
        }
        if(piIndex==1)
            {
            //System.out.println(charCount);
            if(Character.getNumericValue(pi.charAt(piIndex+1)) == charCount)
                return true;
            else return false;
        }
        if(Character.getNumericValue(pi.charAt(piIndex)) == charCount) return true;
        else return false;
    }
}