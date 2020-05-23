import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreqQueries {
    static List<Integer> freqQuery(int[][] queries) {

        List<Integer> ret = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int[] myList : queries){
            if(myList[0] == 1){
                if(!map.containsKey(myList[1])){
                    map.put(myList[1],1);
                }
                else{
                    map.put(myList[1],map.get(myList[1])+1);
                }
                int freq = map.get(myList[1]);
                if(!freqMap.containsKey(freq)){
                    freqMap.put(freq,1);
                }
                else{
                    freqMap.put(freq,freqMap.get(freq)+1);
                }
                //map.put(myList.get(1), maMapp.getOrDefault(myList.get(0)+1,1));
            }
            else if(myList[0] == 2){
                if(!map.containsKey(myList[1])){
                    map.put(myList[1],0);
                }
                else{
                    map.put(myList[1],map.get(myList[1])-1);
                    int freq = map.get(myList[1]);
                    if(freq != 0){
                        freqMap.put(freq, freqMap.get(freq) + 1);
                    }
                    freqMap.put(freq+1, freqMap.get(freq+1) - 1);
                }

                //map.put(myList.get(1), map.getOrDefault(myList.get(0)-1,0));
            }
            else{
                if(freqMap.containsKey(myList[1]) && freqMap.get(myList[1]) > 0){
                    ret.add(1);
                }
                else{
                    ret.add(0);
                }
            }
        }
        return ret;
    }

}
