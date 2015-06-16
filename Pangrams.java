import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Pangrams {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        StringBuffer formString = new StringBuffer();
        while(in.hasNext())
            {
            formString.append(in.next());
        }

        String s = formString.toString().toLowerCase();
        boolean[] arr = new boolean[256];
        for(int i=0;i<arr.length;i++)
            {
            arr[i] = false;
        }
        
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<s.length();i++)
            {
            int ascii = (int)s.charAt(i);
            if((ascii>=97 && ascii<=122) || s.charAt(i) == ' ')
                {
                if(!arr[ascii] && s.charAt(i) != ' ')
                    {
                    arr[ascii] = true;
                }
            }
        }
        for(int i=0;i<arr.length;i++)
            {
            if(!arr[i])
                {
                if(i>=97 && i<=122)
                    {
                    sb.append(Character.toString((char)i));
                }
            }
        }

        if(sb.length()==0) System.out.println("pangram");
        else System.out.println("not pangram");
    }
}