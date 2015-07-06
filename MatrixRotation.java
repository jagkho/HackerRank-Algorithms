import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MatrixRotation {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int r = in.nextInt();
        //System.out.println(m + " " + n + " " + r);
        
        int[][] matrix = new int[m][n];
        int i=0;
        while(i<m)
            {
            for(int j=0;j<n;j++)
                {
                matrix[i][j] = in.nextInt();
            }
            i+=1; 
        }
        //printMatrix(matrix, m, n);
        
        i=0;
        for(i=0;i<r;i++)
            {
            matrix = rotateMatrix(matrix, m, n, r, 0, 0);
        }
        printMatrix(matrix, m, n);
    }
    public static int[][] rotateMatrix(int[][] matrix, int m, int n, int r, int rStartIndex, int cStartIndex)
        {
        if(rStartIndex>=m || cStartIndex>=n) return matrix;
        int extraVar = matrix[rStartIndex][cStartIndex];
        
        int i=rStartIndex;
        int cStartIndexTemp = cStartIndex;
        for(int j=cStartIndex+1;j<n;j++)
            {
            matrix[i][j-1] = matrix[i][j];
            if(j==n-1) matrix[i][j] = extraVar;
        }
        int temp = extraVar;
        extraVar = matrix[i+1][cStartIndexTemp];
        matrix[i+1][cStartIndexTemp] = temp;
        
        for(i=rStartIndex+2;i<m;i++)
            {
            int j=cStartIndex;
            temp = matrix[i][j];
            matrix[i][j] = extraVar;
            extraVar = temp;
        }
        
        for(int j=cStartIndex;j<n-1;j++)
            {
            i=m-1;
            temp = matrix[i][j+1];
            matrix[i][j+1] = extraVar;
            extraVar = temp;
        }
        
        for(i=m-2;i>=rStartIndex;i--)
            {
            int j = n-1;
            temp = matrix[i][j];
            matrix[i][j] = extraVar;
            extraVar = temp;
        }
        
        if(rStartIndex>=0 && cStartIndex>=0)
            {
            matrix = rotateMatrix(matrix, m-1, n-1, r, rStartIndex+1, cStartIndex+1);
        }
        
        return matrix;
    }
    public static void printMatrix(int[][] matrix, int r, int c)
        {
        for(int i=0;i<r;i++)
            {
            for(int j=0;j<c;j++)
                {
                if(j!=c-1) System.out.print(matrix[i][j] + " ");
                else System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}