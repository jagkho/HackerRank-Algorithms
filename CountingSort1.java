package algorithms;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CountingSort1 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfElements = in.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<numberOfElements;i++)
            list.add(in.nextInt());
        
        Integer [] arr = list.toArray(new Integer[list.size()]);
        Integer [] counting = new Integer[100];
        for(int i=0;i<counting.length;i++) counting[i] = 0; 
        for(int i=0;i<arr.length;i++){
            if(arr[i]>=0 || arr[i]<=99)
                counting[arr[i]] +=1;
        } 
        for(int i=0;i<counting.length;i++) System.out.print(counting[i] + " ");
    }
}