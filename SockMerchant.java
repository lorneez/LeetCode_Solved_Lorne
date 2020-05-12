import java.util.HashMap;

/**
 * Runtime complexity: O(n)
 * Space complexity: O(n)
 * SockMerchant finds the number of pairs of socks by tracking the count of each type of sock with a hashmap.
 */
public class SockMerchant {
    static int sockMerchant(int n, int[] ar) {
        int ret = 0;
        HashMap<Integer, Integer> myMap = new HashMap<>();
        for(int x:ar){
            if(myMap.containsKey(x)){
                myMap.put(x, myMap.get(x) + 1);
            }
            else{
                myMap.put(x, 1);
            }
        }
        for(int key:myMap.keySet()){
            int p = myMap.get(key);
            ret += p/2;
        }
        return ret;
    }
}
