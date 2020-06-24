package CTCI_Arrays_And_Strings;

import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {
    public static void main(String[] args){
        System.out.println(checkPermutation("eleanor", "ronaele"));
        System.out.println(checkPermutation("eleanop", "ronaele"));

    }

    public static boolean checkPermutation(String match, String source){
        Map<Character, Integer> strMap = new HashMap<>();
        for(int i=0; i<match.length(); i++){
            strMap.put(match.charAt(i), strMap.getOrDefault(match.charAt(i), 0) + 1);
        }
        for(int i=0; i<source.length(); i++){
            if(!strMap.containsKey(source.charAt(i)) || strMap.get(source.charAt(i)) == 0) return false;
            strMap.put(source.charAt(i), strMap.get(source.charAt(i)) -1);
        }
        return true;
    }
}
