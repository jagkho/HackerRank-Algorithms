import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MakeItAnagram {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        StringBuffer a = new StringBuffer();
        StringBuffer b = new StringBuffer();
        String s1 = a.append(in.next()).toString();
        String s2 = b.append(in.next()).toString();
        
        LinkedHashMap<Character, Integer> firstStringMap = new LinkedHashMap<Character, Integer>();
        for(int i=0;i<s1.length();i++)
            {
            if(!firstStringMap.containsKey(s1.charAt(i)))
                {
                firstStringMap.put(s1.charAt(i), 1);
            }
            else
                {
                int value = firstStringMap.get(s1.charAt(i));
                firstStringMap.put(s1.charAt(i), value+1);
            }
        }
       
        StringBuffer residualString1 = new StringBuffer();
        int deletions = 0;
        for(int i=0;i<s2.length();i++)
            {
            if(!firstStringMap.containsKey(s2.charAt(i)))
                {
                deletions+=1;
            }
            else 
                residualString1.append(s2.charAt(i));
        }
        
        LinkedHashMap<Character, Integer> secondStringMap = new LinkedHashMap<Character, Integer>();
        for(int i=0;i<s2.length();i++)
            {
            if(!secondStringMap.containsKey(s2.charAt(i)))
                {
                secondStringMap.put(s2.charAt(i), 1);
            }
            else
                {
                int value = secondStringMap.get(s2.charAt(i));
                secondStringMap.put(s2.charAt(i), value+1);
            }
        } 
        
        StringBuffer residualString2 = new StringBuffer();
        for(int i=0;i<s1.length();i++)
            {
            if(!secondStringMap.containsKey(s1.charAt(i)))
                {
                deletions+=1;
            }
            else 
                residualString2.append(s1.charAt(i));
        }
        
        if(residualString1.length()!=residualString2.length())
            {
            if(residualString1.length()>residualString2.length())
                {
                Iterator<Character> keySetIteratorSm = firstStringMap.keySet().iterator();
                while(keySetIteratorSm.hasNext())
                    {
                    Character key = keySetIteratorSm.next();
                    int val1 = firstStringMap.get(key);
                    int val2 = 0;
                    if(secondStringMap.containsKey(key))
                        {
                        val2 = secondStringMap.get(key);
                        deletions+=Math.abs(val1-val2);
                    }
                }
            }
            else
                {
                Iterator<Character> keySetIteratorSm = secondStringMap.keySet().iterator();
                while(keySetIteratorSm.hasNext())
                    {
                    Character key = keySetIteratorSm.next();
                    int val1 = secondStringMap.get(key);
                    int val2 = 0;
                    if(firstStringMap.containsKey(key))
                        {
                        val2 = firstStringMap.get(key);
                        deletions+=Math.abs(val1-val2);
                    }
                }
            }
        }
        else
            {
            Iterator<Character> keySetIteratorSm = secondStringMap.keySet().iterator();
            while(keySetIteratorSm.hasNext())
                {
                Character key = keySetIteratorSm.next();
                int val1 = secondStringMap.get(key);
                int val2=0;
                if(firstStringMap.containsKey(key))
                    {
                    val2 = firstStringMap.get(key);
                    deletions+=Math.abs(val1-val2);
                }
            }
        }
        System.out.println(deletions);
    }
}