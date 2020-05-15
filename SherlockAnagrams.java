import java.util.Arrays;
import java.util.HashMap;

/**
 * Runtime complexity: O(n^2)
 * Space complexity: O(n^2)
 */
public class SherlockAnagrams {
    public static void main(String[] args){
        System.out.println(sherlockAndAnagrams("kkkk"));
    }
    static int sherlockAndAnagrams(String s) {
        HashMap<String, Integer> map = getMap(s);
        int sum = 0;
        for(String key:map.keySet()){
            int x = map.get(key)-1;
            for(int i=1; i<=x; i++){
                sum += i;
            }
        }
        return sum;
    }

    static HashMap<String, Integer> getMap(String s){
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            for(int j=i+1; j<=s.length(); j++){
                String w = s.substring(i,j);
                char[] c = w.toCharArray();
                Arrays.sort(c);
                String sub = new String(c);
                if(!map.containsKey(sub)){
                    map.put(sub,1);
                }
                else{
                    map.put(sub,map.get(sub)+1);
                }
            }
        }
        return map;
    }
}
