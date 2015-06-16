import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class GemStones {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfTestCases = in.nextInt();
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        String s = in.next();
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
            
        LinkedHashMap<Character, Integer> bufferMap = null;
        for(int i=1;i<numberOfTestCases;i++)
            {
            s = in.next();
            bufferMap = new LinkedHashMap<Character, Integer>();
            for(int j=0;j<s.length();j++)
                {
                if(map.containsKey(s.charAt(j)))
                    {
                    if(!bufferMap.containsKey(s.charAt(j)))
                        {
                        bufferMap.put(s.charAt(j), 1);
                    }
                    else
                        {
                        int value = bufferMap.get(s.charAt(j));
                        bufferMap.put(s.charAt(j), value+1);
                    }
                }
            }
            map = bufferMap;
        }
        System.out.println(bufferMap.size());
    }
}