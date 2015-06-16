import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Encryption {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        String s = in.next();
        //System.out.println(s);
        Integer length = getStringLengthWithoutSpaces(s);
        Integer r = (int)Math.floor(Math.sqrt(length));
        Integer c = (int)Math.ceil(Math.sqrt(length));
        if(r*c<length) r+=1;
        //System.out.println(r + " " + c);
        char[][] res = getResultMatrix(r, c, s);
        printResult(r, c, res);
    }
    public static void printResult(Integer r, Integer c, char[][] res)
        {
        System.out.flush();
        for(int j=0;j<c;j++)
            {
            for(int i=0;i<r;i++)
                {
                if(res[i][j]!=' ') System.out.print(res[i][j]);
            }
            if(j!=c-1) System.out.print(" ");
        }
        System.out.flush();
    }
    public static char[][] getResultMatrix(Integer r, Integer c, String s)
        {
        //System.out.println(r + " " + c);
        char[][] res = new char[r][c];
        initializeResultArray(r, c, res);
        //printResult(r, c, res);
        s = s.replaceAll("\\s","");
        //System.out.println(s);
        int sIndex=0;
        for(int i=0;i<r && sIndex<s.length();i++)
            {
            for(int j=0;j<c && sIndex<s.length();j++)
                {
                //System.out.println(sIndex);
                res[i][j] = s.charAt(sIndex);
                sIndex+=1;
            }
        }
        return res;
    }
    public static void initializeResultArray(Integer r, Integer c, char[][] res)
        {
        for(int i=0;i<r;i++)
            {
            for(int j=0;j<c;j++)
                {
                res[i][j] = ' ';
            }
        }
    }
    public static Integer getStringLengthWithoutSpaces(String s)
        {
        Integer countWithoutSpaces = 0;
        for(int i =0;i<s.length();i++)
            {
            if(s.charAt(i)!=' ') countWithoutSpaces+=1;
        }
        return countWithoutSpaces;
    }
}