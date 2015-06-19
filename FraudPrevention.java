import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FraudPrevention {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numberOfRecords = in.nextInt();
        in.nextLine();
        ArrayList<String> arr = new ArrayList<String>();
        for(int i=0;i<numberOfRecords;i++)
            {
            arr.add(in.nextLine());
        }
        
        HashMap<String, ArrayList<String>> parentChildOrderIdMap = new HashMap<String, ArrayList<String>>();
        HashMap<String, HashMap<String, String>> firstConditionMap = new HashMap<String, HashMap<String, String>>();
        TreeSet firstFraudSet = new TreeSet();
        for(int i=0;i<arr.size();i++)
            {
            String s = arr.get(i);
            String[] sarr = s.split(",");
            String[] emailSplit = sarr[2].split("@");
            if(emailSplit[0].contains("."))
                {
                emailSplit[0] = emailSplit[0].toLowerCase().replaceAll("\\.","");
                sarr[2] = emailSplit[0] + "@" + emailSplit[1];
            }
            else if(emailSplit[0].contains("+"))
                {
                String[] userNameSplit = emailSplit[0].split("\\+");
                sarr[2] = userNameSplit[0] + "@" + emailSplit[1];
            }
            
            
            String key = sarr[1] + sarr[2].toLowerCase();
            if(!firstConditionMap.containsKey(key))
                {
                HashMap<String, String> valueMap = new HashMap<String, String>();
                valueMap.put(sarr[7], sarr[0]);
                firstConditionMap.put(key, valueMap);
            }
            else
                {
                HashMap<String, String> valueMap = firstConditionMap.get(key);
                Iterator<String> keySetIteratorS = valueMap.keySet().iterator();
                while(keySetIteratorS.hasNext())
                    {
                    String keyFromValueMap = keySetIteratorS.next();
                    if(!keyFromValueMap.equals(sarr[7]))
                        {
                        firstFraudSet.add(sarr[0]);
                        firstFraudSet.add(valueMap.get(keyFromValueMap));
                    }
                    else
                        {
                        if(!parentChildOrderIdMap.containsKey(valueMap.get(keyFromValueMap)))
                            {
                            ArrayList<String> childOrderIds = new ArrayList<String>();
                            childOrderIds.add(sarr[0]);
                            parentChildOrderIdMap.put(valueMap.get(keyFromValueMap), childOrderIds);
                        }
                        else
                            {
                            ArrayList<String> childOrderIds = parentChildOrderIdMap.get(valueMap.get(keyFromValueMap));
                            childOrderIds.add(sarr[0]);
                            parentChildOrderIdMap.put(valueMap.get(keyFromValueMap), childOrderIds);
                        }
                    }
                }
            }
        }
        
        HashMap<String, HashMap<String, String>> secondConditionMap = new HashMap<String, HashMap<String, String>>();
        TreeSet secondFraudSet = new TreeSet();
        for(int i=0;i<arr.size();i++)
            {
            String s = arr.get(i);
            String[] sarr = s.split(",");
            if(!sarr[5].toLowerCase().equals("ny") && sarr[5].toLowerCase().equals("new york"))
                {
                sarr[5] = sarr[5].toLowerCase().replaceAll("new york", "ny");
            }
            else if(!sarr[5].toLowerCase().equals("il") && sarr[5].toLowerCase().equals("illinois"))
                {
                sarr[5] = sarr[5].toLowerCase().replaceAll("illinois", "il");
            }
            else if(!sarr[5].toLowerCase().equals("ca") && sarr[5].toLowerCase().equals("california"))
                {
                sarr[5] = sarr[5].toLowerCase().replaceAll("california", "ca");
            }
            
            if(!sarr[3].toLowerCase().contains("street") && sarr[3].toLowerCase().contains("st."))
                {
                sarr[3] = sarr[3].toLowerCase().replaceAll("st\\.", "street");
            }
            if(!sarr[3].toLowerCase().contains("road") && sarr[3].toLowerCase().contains("rd."))
                {
                sarr[3] = sarr[3].toLowerCase().replaceAll("rd\\.", "road");
            }
            
            if(sarr[6].contains("-"))
                {
                sarr[6] = sarr[6].replaceAll("\\-", "");
            }
            String key = sarr[1] + sarr[3].toLowerCase() + sarr[4].toLowerCase() + sarr[5].toLowerCase() + sarr[6];
            if(!secondConditionMap.containsKey(key))
                {
                HashMap<String, String> valueMap = new HashMap<String, String>();
                valueMap.put(sarr[7], sarr[0]);
                secondConditionMap.put(key, valueMap);
            }
            else
                {
                HashMap<String, String> valueMap = secondConditionMap.get(key);
                Iterator<String> keySetIteratorS = valueMap.keySet().iterator();
                while(keySetIteratorS.hasNext())
                    {
                    String keyFromValueMap = keySetIteratorS.next();
                    if(!keyFromValueMap.equals(sarr[7]))
                        {
                        secondFraudSet.add(sarr[0]);
                        secondFraudSet.add(valueMap.get(keyFromValueMap));
                    }
                    else
                        {
                        if(!parentChildOrderIdMap.containsKey(valueMap.get(keyFromValueMap)))
                            {
                            ArrayList<String> childOrderIds = new ArrayList<String>();
                            childOrderIds.add(sarr[0]);
                            parentChildOrderIdMap.put(valueMap.get(keyFromValueMap), childOrderIds);
                        }
                        else
                            {
                            ArrayList<String> childOrderIds = parentChildOrderIdMap.get(valueMap.get(keyFromValueMap));
                            childOrderIds.add(sarr[0]);
                            parentChildOrderIdMap.put(valueMap.get(keyFromValueMap), childOrderIds);
                        }
                    }
                }
            }
        }

        Iterator<String> parentChildOrderIdMapIterator = parentChildOrderIdMap.keySet().iterator();
        while(parentChildOrderIdMapIterator.hasNext())
            {
            String xs = parentChildOrderIdMapIterator.next();
            boolean exists = firstFraudSet.contains(xs);
            if(exists)
                {
                ArrayList<String> list = parentChildOrderIdMap.get(xs);
                for(int len=0;len<list.size();len++)
                    {
                    firstFraudSet.add(list.get(len));
                }
            }
            
            exists = secondFraudSet.contains(xs);
            if(exists)
                {
                ArrayList<String> list = parentChildOrderIdMap.get(xs);
                for(int len=0;len<list.size();len++)
                    {
                    secondFraudSet.add(list.get(len));
                }
            }
        }
        
        TreeSet<String> totalFraudSet = new TreeSet<String>(firstFraudSet);
        totalFraudSet.addAll(secondFraudSet);
        Iterator it = totalFraudSet.iterator();
        ArrayList<Integer> finalFraudList = new ArrayList<Integer>();
        while(it.hasNext())
            {
            Object element = it.next();
            finalFraudList.add(Integer.valueOf(element.toString()));
        }
        Collections.sort(finalFraudList);
        for(int i=0;i<finalFraudList.size();i++)
            {
            if(i<finalFraudList.size()-1)
                {
                System.out.print(finalFraudList.get(i) + ",");
            }
            else System.out.print(finalFraudList.get(i));
        }
    }
    public static void print(ArrayList<String> arr)
        {
        for(int i=0;i<arr.size();i++)
            {
            if(i<arr.size()-1)
                {
                System.out.println(arr.get(i));
            }
            else 
                {
                System.out.print(arr.get(i));
            }
        }
    }
}