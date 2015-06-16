import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AlternatingCharacters {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfTestCases = in.nextInt();
        for(int i=0;i<numberOfTestCases;i++)
            {
            int deletions = 0;
            String s = in.next();
            Character lastSeenCharacter = s.charAt(0);
            for(int j=1; j<s.length(); j++)
                {
                if(s.charAt(j)==lastSeenCharacter) deletions+=1;
                else lastSeenCharacter = s.charAt(j);
            }
            System.out.println(deletions);
        }
    }
}