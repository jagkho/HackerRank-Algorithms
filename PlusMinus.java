import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PlusMinus {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfElements = in.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<numberOfElements;i++)
            {
            list.add(in.nextInt());
        }
        int posCount = 0;
        int negCount = 0;
        int zeroCount = 0;
        for(int i=0;i<list.size();i++)
            {
            if(list.get(i)>0) 
                {
                posCount+=1;
            }
            if(list.get(i)<0) 
                {
                negCount+=1;
            }
            else if(list.get(i)==0)
                {
                zeroCount+=1;
            }
        }
        DecimalFormat df = new DecimalFormat("#.#####");
        System.out.println(df.format((double)posCount/numberOfElements));
        System.out.println(df.format((double)negCount/numberOfElements));
        System.out.println(df.format((double)zeroCount/numberOfElements));
    }
}