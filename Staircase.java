package algorithms;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Staircase {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        for(int i=1;i<=n;i++)
            {
            int spaces = n-i;
            int j=1;
            for(;j<=spaces;j++)
                System.out.print(" ");
            for(;j<=n;j++)
                System.out.print("#");
            System.out.println();
        }
    }
}
