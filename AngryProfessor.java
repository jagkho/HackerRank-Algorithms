import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AngryProfessor {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfTestCases = in.nextInt();
        for(int i=0;i<numberOfTestCases;i++)
            {
            int n = in.nextInt();
            int k = in.nextInt();
            ArrayList<Integer> arrivalTimeList = new ArrayList<Integer>();
            for(int j=0;j<n;j++)
                {
                arrivalTimeList.add(in.nextInt());
            }
            if(doesClassGetsCancelled(arrivalTimeList, k)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
    public static boolean doesClassGetsCancelled(ArrayList<Integer> arrivalTimeList, int k)
        {
        int currentStudentCount = 0;
        for(int i=0;i<arrivalTimeList.size();i++)
            {
            if(arrivalTimeList.get(i)<=0) currentStudentCount+=1;
        }
        if(currentStudentCount >= k) return false;
        return true;
    }
    public static void print(ArrayList<Integer> list)
        {
        for(int i=0;i<list.size();i++)
            {
            if(i<list.size()-1) System.out.print(list.get(i) + " ");
            else System.out.println(list.get(i));
        }
    }
}