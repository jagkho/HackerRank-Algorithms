package algorithms;

import java.io.*;
import java.util.*;

public class ClosestNumbers {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        if(arr.length>=2){
            int minDiff = arr[1]-arr[0];
            int minVal1 = arr[0];
            int minVal2 = arr[1];
            for(int i=0;i<arr.length;i++){
                if(i!=arr.length-1){
                    if(arr[i+1]-arr[i]<minDiff){
                        minDiff = arr[i+1]-arr[i];
                        minVal1 = arr[i];
                        minVal2 = arr[i+1];
                    }
                }
            }
            for(int i=0;i<arr.length;i++){
                if(i!=arr.length-1){
                    if(arr[i+1]-arr[i] == minDiff){
                        System.out.print(arr[i] + " " + arr[i+1] + " ");
                    }
                }
            }
        }
        else System.out.println(arr[0]);
    }
}