import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ChocolateFeast {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            System.out.println(Solve(in.nextInt(), in.nextInt(), in.nextInt()));
        }
    }
    
    private static long Solve(int N, int C, int M){
        int numberOfChocolatesHad = 0;
        numberOfChocolatesHad+=N/C;
        int numberOfWrappers = N/C;
        while(numberOfWrappers>=M)
            {
            long additionalAdd = numberOfWrappers/M;
            numberOfChocolatesHad+= numberOfWrappers/M;
            numberOfWrappers = numberOfWrappers%M;
            numberOfWrappers+= additionalAdd;

        }
        return numberOfChocolatesHad;
    }
    
    
}
