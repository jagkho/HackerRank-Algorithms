import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class GridSearch {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfTestCases = in.nextInt();
        for(int i=0;i<numberOfTestCases;i++)
            { 
            int rsm = in.nextInt();
            int csm = in.nextInt();
            char[][] sourceMatrix = new char[rsm][csm];
            for(int j=0;j<rsm;j++)
                {
                String s = in.next();
                for(int k=0;k<s.length();k++)
                    {
                    sourceMatrix[j][k] = s.charAt(k);
                }
            }
            //printMatrix(sourceMatrix,rsm,csm);
            
            int rpm = in.nextInt();
            int cpm = in.nextInt();
            char[][] patternMatrix = new char[rpm][cpm];
            for(int j=0;j<rpm;j++)
                {
                String s = in.next();
                for(int k=0;k<s.length();k++)
                    {
                    patternMatrix[j][k] = s.charAt(k);
                }
            }
            //printMatrix(patternMatrix,rpm,cpm);
            if(patternExists(sourceMatrix, patternMatrix, rsm, csm, rpm, cpm))
                {
                System.out.println("YES");
            }
            else System.out.println("NO");
        }
    }
    public static boolean patternExists(char[][] sMatrix, char[][] pMatrix, int rsm, int csm, int rpm, int cpm)
        {
        boolean patternFound = false;
        for(int i=0;i<rsm;i++)
            {
            for(int j=0;j<csm;j++)
                {
                if(pMatrix[0][0] == sMatrix[i][j])
                    {
                    int tempi = i;
                    int tempj = j;
                    boolean broken = false;
                    for(int a=0;a<rpm;a++)
                        {
                        for(int b=0;b<cpm;b++)
                            {
                            if(pMatrix[a][b] == sMatrix[tempi][tempj])
                                {
                                if(tempj<csm-1) tempj+=1;
                                else
                                    {
                                    broken = true;
                                    break;
                                }
                            }
                            else
                                {
                                broken = true;
                                break;
                            }
                        }
                        if(!broken)
                            {
                            tempj = tempj-cpm;
                            if(tempi<rsm-1) tempi+=1;
                            else break;
                        }
                        else break;
                    }
                    if(!broken) return true;
                }
            }
        }
        return false;
    }
    public static void printMatrix(char[][] matrix, int r, int c)
        {
        for(int i=0;i<r;i++)
            {
            for(int j=0;j<c;j++)
                {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}