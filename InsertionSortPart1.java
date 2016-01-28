package algorithms;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class InsertionSortPart1 {
    
    public static void insertIntoSorted(int[] ar) {
        // Fill up this function  
        int value = ar[ar.length-1];
        int j=ar.length-2;
        int i=ar.length-1;
        while(j>=0 && ar[j]>value){
            ar[i] = ar[j];
            j-=1;
            i-=1;
            for(int k=0;k<ar.length;k++)
                System.out.print(ar[k] + " ");
            System.out.println();
        }
        ar[i] = value;
        for(int k=0;k<ar.length;k++)
            System.out.print(ar[k] + " ");
    }
    
    
/* Tail starts here */
     public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
         for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
         }
         insertIntoSorted(ar);
    }
    
    
    private static void printArray(int[] ar) {
      for(int n: ar){
         System.out.print(n+" ");
      }
        System.out.println("");
   } 
}
 
