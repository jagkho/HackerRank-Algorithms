package algorithms;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RunningTimeOfQuicksort {
    public static int quickSortCount = 0;
    public static int insertionSortCount = 0;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfElements = in.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<numberOfElements;i++)
            {
            list.add(in.nextInt());
        }
        Integer [] arr1 = list.toArray(new Integer[list.size()]);
        Integer [] arr2 = list.toArray(new Integer[list.size()]);
        //print(arr, 0, arr.length-1);
        quicksort(arr1, 0, arr1.length-1);
        insertionSort(arr2);
        System.out.println(insertionSortCount-quickSortCount);
    }
    public static void quicksort(Integer arr[], int start, int end)
        {
        if(start<end)
            {
            int partitionIndex = partition(arr, start, end);
            //print(arr, 0, arr.length-1);
            quicksort(arr, start, partitionIndex-1);
            quicksort(arr, partitionIndex+1, end);
            //print(arr, start, arr.length-1);
            //System.out.println(partitionIndex); 
        }
    }
    public static int partition(Integer arr[], int start, int end)
        {
        int i=start-1;
        int pivot = arr[end];
        
        for(int j=start;j<=end-1;j++)
            {
            if(arr[j]<=pivot)
                {
                i+=1;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                quickSortCount+=1;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = temp;
        quickSortCount+=1;
        //print(arr, start, end);
        
        return i+1;
    }
    public static void print(Integer arr[], int start, int end)
        {
        for(int i=start;i<=end;i++)
            {
            if(i!=end)
                {
                System.out.print(arr[i] + " "); 
            }
            else
                {
                System.out.print(arr[i]);
                System.out.println();
            }
        }
    }
    public static void insertionSort(Integer[] A){
        for(int i = 1; i < A.length; i++){
            int value = A[i];
            int j = i - 1;
            while(j >= 0 && A[j] > value){
                A[j + 1] = A[j];
                insertionSortCount+=1;
                j = j - 1;
            }
            A[j + 1] = value;
        }
    }
}