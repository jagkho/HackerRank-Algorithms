import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FunnyString {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfTestcases = in.nextInt();
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0;i<numberOfTestcases;i++)
            {
            list.add(in.next());
        }
        for(int i=0; i<list.size(); i++)
            {
            String originalString = list.get(i);
            char[] arr1 = originalString.toCharArray();
            char[] arr2 = reverse(originalString);
            
            boolean isFunny = true;
            for(int j=0;j<arr1.length;j++)
                {
                if(j!=arr1.length-1)
                    {
                    int diff1 = Math.abs((int)arr1[j] - (int)arr1[j+1]);
                    int diff2 = Math.abs((int)arr2[j] - (int)arr2[j+1]);
                    if(diff1!=diff2) isFunny = false;
                }
            }
            if(isFunny) System.out.println("Funny");
            else System.out.println("Not Funny");
        }
    }
    public static char[] reverse(String s)
        {
        char[] arr = s.toCharArray();
        int j=0;
        for(int i=arr.length-1;i>=arr.length/2;i--)
            {
            char temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            j+=1;
        }
        return arr;
    }
}