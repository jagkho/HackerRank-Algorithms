import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.HashSet;
import java.util.Set;

public class GameOfThrones1 {

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        String inputString = myScan.nextLine();
       
        String ans;
        // Assign ans a value of YES or NO, depending on whether or not inputString satisfies the required condition
        ans = getAnswer(inputString);
        System.out.println(ans);
        myScan.close();
    }
    public static String getAnswer(String s)
        {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        for(int i=0;i<s.length();i++)
            {
            if(!map.containsKey(s.charAt(i)))
                {
                map.put(s.charAt(i), 1);
            }
            else
                {
                int value = map.get(s.charAt(i));
                map.put(s.charAt(i), value+1);
            }
        }
        
        int oddCount = 0;
        int evenCount = 0;
        Iterator<Character> keySetIteratorS = map.keySet().iterator();
        while(keySetIteratorS.hasNext()){
        Character key = keySetIteratorS.next();
        if(map.get(key)%2==0) evenCount+=1;
        else oddCount+=1;
        //System.out.println("key: " + key + " value: " + map.get(key));
        }
        if(s.length()%2==0)
            {
            if(oddCount==0) return "YES";
            else return "NO";
        }
        else
            {
            if(oddCount==1) return "YES";
            else return "NO";
        }
    }
}
