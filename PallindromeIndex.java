import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PallindromeIndex {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfTestCases = in.nextInt();
        
        for(int i=0;i<numberOfTestCases;i++)
            {
            LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
            String s = in.next();
            //System.out.println(s);
            for(int j=0;j<s.length();j++)
            {
                if(!map.containsKey(s.charAt(j)))
                    {
                    map.put(s.charAt(j), 1);
                }
                else
                    {
                    int value = map.get(s.charAt(j));
                    map.put(s.charAt(j), value+1);
                }
            }
            if(s.length()%2!=0)
                {
                //System.out.println(s.length());
                Character oddCountChar = null;
                Iterator<Character> keySetIteratorS = map.keySet().iterator();
                while(keySetIteratorS.hasNext())
                    {
                     Character key = keySetIteratorS.next();
                     if(map.get(key)%2!=0) oddCountChar = key;
                     //System.out.println("key: " + key + " value: " + map.get(key));
                }
                if(isPallindrome(s))
                    {
                    System.out.println("-1");
                }
                else
                    {
                    for(int k=0;k<s.length();k++)
                        {
                          if(s.charAt(k) == oddCountChar)
                              {
                               if(makesPallindrome(s, k))
                                   {
                                   System.out.println(k);
                                   break;
                               }
                          }
                    }
                }
            }
            else
                {
                //System.out.println(s.length());
                if(isPallindrome(s))
                    {
                    System.out.println("-1");
                }
                else
                    {
                    boolean foundIndex = false;
                    if(makesPallindrome(s, s.length()/2+1) && !foundIndex)
                        {
                        System.out.println(s.length()/2+1);
                        foundIndex = true;
                    }
                    else if(makesPallindrome(s, s.length()/2) && !foundIndex)
                        {
                        System.out.println(s.length()/2); 
                        foundIndex = true;
                    }
                    else if(makesPallindrome(s, s.length()/2 -1) && !foundIndex)
                        {
                        System.out.println(s.length()/2 -1);
                        foundIndex = true;
                    }
                }
            }
        }
    }
    public static boolean makesPallindrome(String s, Integer index)
        {
        StringBuilder s1 = new StringBuilder(removeCharAt(s, index));
        return s1.toString().equals(s1.reverse().toString());
    }
    public static String removeCharAt(String s, int pos) {
      return s.substring(0, pos) + s.substring(pos + 1);
   }
    public static boolean isPallindrome(String s)
        {
        StringBuilder s1 = new StringBuilder(s);
        return s1.toString().equals(s1.reverse().toString());
    }
}
