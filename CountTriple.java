import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriple {
    static long countTriplets(List<Long> arr, long r) {
        Map<Long, Long> two = new HashMap<>();
        Map<Long, Long> finished = new HashMap<>();
        long result = 0L;

        for(Long check : arr) {
            // check finished
            result += finished.getOrDefault(check, 0L);
            // if second has it, try and add to finished
            if (two.containsKey(check)){
                Long val = finished.getOrDefault(check*r, 0L) + two.get(check);
                finished.put(check*r, val);
            }
            // update the second
            two.put(check*r, two.getOrDefault(check*r, 0L) + 1);
        }
        return result;
    }
    static long countTripletsIncorrect(List<Long> arr, long r) {
        if(r == 1){
            int size = arr.size();
            // 3Csize
            return size * (size-1) * (size-2) / 6;
        }
        HashMap<Long, Integer> seen = new HashMap<>();
        HashMap<Long, Integer> possible = new HashMap<>();
        long total = 0;
        // for loop thru every element.
        // edge case 100 1 161700
        // first add e into the seen map
        // second check e/r in seen to update poss.
        // third check e/r and e/r^2 in seen to update total.
        for(int i=0; i<arr.size(); i++){
            long check = arr.get(i);
            if(!seen.containsKey(check)){
                seen.put(check, 1);
            }
            else{
                seen.put(check, seen.get(check) + 1);
            }
            // 2
            if(seen.containsKey(check/r)){
                int count = seen.get(check/r);
                long next = check*r;
                if(!possible.containsKey(next)){
                    possible.put(next,count);
                }
                else{
                    possible.put(next,possible.get(next) + count);
                }
            }
            if(seen.containsKey(arr.get(i)/r) && seen.containsKey(arr.get(i)/r/r)){
                total = total + possible.get(arr.get(i));
            }
        }
        return total;

    }
}
