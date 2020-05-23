import java.util.HashMap;

public class SherlockAndValidString {
    static String isValid(String s) {
        int[] count = new int[26];
        for(char i:s.toCharArray()){
            count[i-97]++;
        }
        HashMap<Integer, Integer> valid = new HashMap<>();
        for(int i=0; i<26; i++){
            if(count[i] != 0){
                //System.out.println(count[i]);
                valid.put(count[i], valid.getOrDefault(count[i], 0) + 1);
            }
        }
        if(valid.keySet().size() == 1){
            return "YES";
        }
        if(valid.keySet().size() > 2){
            return "NO";
        }
        else{
            int[] keys = new int[2];
            int index = 0;
            for(int x:valid.keySet()){
                keys[index] = x;
                index ++;
            }
            int first = keys[0]; // 4
            int second = keys[1]; // 2 or 1
            if(Math.abs(keys[0]-keys[1]) !=1){
                if(!((valid.get(keys[0]) ==1 && keys[0] == 1) || (valid.get(keys[1]) == 1) && keys[1] == 1)){
                    return "NO";
                }
                if(!(keys[0] ==1 || keys[1] == 1)){
                    return "NO";
                }
            }
            else{
                if(valid.get(keys[0]) !=1 && valid.get(keys[1]) != 1){
                    return "NO";
                }
            }


        }
        return "YES";


    }
}
