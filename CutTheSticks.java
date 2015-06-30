import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CutTheSticks {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<n;i++)
            {
            Integer val = in.nextInt();
            map.put(i, val);
        }
        Set<Integer> keys = null;
        boolean firstRun = true;
        
        while(map.size()!=0)
            {
            HashMap<Integer, Integer> cloneMap = (HashMap<Integer, Integer>)map.clone();
            keys = map.keySet();
            Integer minVal = getMinValFromMap(map);
            if(firstRun)
                {
                firstRun = false;
                System.out.println(map.size());
            }
            
            for (Integer key : keys)
                {   
                Integer existingKey = key;
                Integer existingValue = map.get(key);
                Integer updatedValue = existingValue -  minVal;
                cloneMap.remove(existingKey);
                if(updatedValue!=0)
                    {
                cloneMap.put(existingKey, updatedValue);
                }
            }
            map = cloneMap;
            if(map.size()!=0)
                {
                System.out.println(map.size());
            }
        }
    }
    public static Integer getMinValFromMap(HashMap<Integer, Integer> map)
        {
        Integer minVal = 0;
        Integer iteratorCount = 0;
        Set<Integer> keys = map.keySet();
	    for (Integer key : keys)
            {
            Integer mapVal = map.get(key);
            if(iteratorCount == 0)
                {
                minVal = mapVal;
                iteratorCount+=1;
            }
            else
                {
                if(mapVal<minVal) minVal = mapVal;
            }
        }
        return minVal;
    }
}