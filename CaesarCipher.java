package algorithms;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CaesarCipher {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        int k = in.nextInt();
        k=k%26;
        for(int i=0;i<s.length();i++){
            int ch = (int)s.charAt(i);
            if(ch>=65 && ch<=90){   
                char c = (char)(ch+k);
                if(ch+k > 90){
                    int diff = (ch+k) - 90;
                    c = (char)(64+diff);
                } 
                System.out.print(c);
            }
            else if(ch>=97 && ch<=122){
                char c = (char)(ch+k);
                if(ch+k > 122){
                    int diff = (ch+k) - 122;
                    c = (char)(96+diff);
                } 
                System.out.print(c);
            }
            else System.out.print(s.charAt(i));
        }
    }
}
