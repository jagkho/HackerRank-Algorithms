package algorithms;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class IntroToTutorialChallenges {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        int numberOfElements = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        String[] arr = s.split("\\s+");
        for(int i=0;i<arr.length;i++){
            if(Integer.valueOf(arr[i]) == number)
                System.out.println(i);
        }
    }
}