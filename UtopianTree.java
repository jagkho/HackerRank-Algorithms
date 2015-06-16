import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class UtopianTree {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        ArrayList<Integer> list = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt())
            {
            list.add(in.nextInt());
        }
        for(int i=1; i<list.size(); i++)
            {
            int value = list.get(i);
            int height = 1;
            if(value!=0)
                {
                for(int j=1;j<=value;j++)
                    {
                    if(j%2==0) height+=1;
                    else height = height*2;
                }
            }
            System.out.println(height);
        }
    }
}