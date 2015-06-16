import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class InPlaceQuickSortWithLomutoPartitioning {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfElements = in.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<numberOfElements;i++)
            {
            list.add(in.nextInt());
        }
        Integer [] arr = list.toArray(new Integer[list.size()]);
        //print(arr, 0, arr.length-1);
        quicksort(arr, 0, arr.length-1);
    }
    public static void quicksort(Integer arr[], int start, int end)
        {
        if(start<end)
            {
            int partitionIndex = partition(arr, start, end);
            print(arr, 0, arr.length-1);
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
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = temp;
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
}