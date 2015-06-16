import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ServiceLane {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int lengthOfFreeway = in.nextInt();
        int noOfTestCases = in.nextInt();
        ArrayList<Integer> widthArray = new ArrayList<Integer>();
        for(int i=0;i<lengthOfFreeway;i++)
            {
            widthArray.add(in.nextInt());
        }
        for(int i=0;i<noOfTestCases;i++)
            {
            int startIndex = in.nextInt();
            int endIndex = in.nextInt();
            int minValue = widthArray.get(startIndex);
            for(int j = startIndex; j<=endIndex; j++)
                {
                if(widthArray.get(j)<minValue)
                    {
                    minValue = widthArray.get(j);
                }
            }
            System.out.println(minValue);
        }
    }
}