package algorithms;

import java.util.*;
public class QuickSort1Partition {
    static void partition(int[] arr) {
        int i=0;
        int j=arr.length-1;
        int temp = arr[0];
        arr[0] = arr[i + (j-i)/2];
        arr[i + (j-i)/2] = temp;
        int pivot = arr[i + (j-i)/2];
        while(i<=j){
            if(arr[i]<pivot) i+=1;
            else if(arr[j]>pivot) j-=1;
            else if(i<=j){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i+=1;
                j-=1;
            }
        }
        printArray(arr);
    }   

    static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i]=in.nextInt(); 
        }
        partition(ar);
    }    
}
