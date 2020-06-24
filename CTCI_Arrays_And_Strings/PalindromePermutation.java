package CTCI_Arrays_And_Strings;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {

    public static void main(String[] args){
        String[] strs = new String[3];
        strs[0] = "taco cat";
        strs[1] = "lorne";
        strs[2] = "abcdcba";
        for(int i=0; i<3; i++){
            System.out.println(checkWithMap(strs[i]));
            System.out.println(checkWithCount(strs[i]));
            System.out.println(checkWithBitVector(strs[i]));
            System.out.println("----");
        }
    }

    // store char count in map and check that no more than one has count that is odd
    public static boolean checkWithMap(String s){
        Map<Character, Integer> counts = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != ' '){
                counts.put(s.charAt(i), counts.getOrDefault(s.charAt(i), 0) + 1);
            }
        }
        int oddCount = 0;
        for(char key : counts.keySet()){
            if(counts.get(key) % 2 == 1){
                oddCount ++;
                if(oddCount > 1){
                    return false;
                }
            }
        }
        return true;
    }

    // optimize space complexity: go as you count
    public static boolean checkWithCount(String s){
        int[] chars = new int[200];
        int oddCount = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != ' '){
                chars[s.charAt(i)] ++;
                if(chars[s.charAt(i)] % 2 == 1){
                    oddCount ++;
                }
                else{
                    oddCount --;
                }
            }
        }
        return oddCount > 1 ? false : true;
    }

    // use bit vector
    public static boolean checkWithBitVector(String s){
        int checker = 0;
        for(int i=0; i<s.length(); i++){
            int val = s.charAt(i);
            if(val != ' '){
                checker = toggle(checker, val);
            }
        }
        return (checker & (checker - 1)) == 0; // this checks that there is only 1 odd
    }

    private static int toggle(int checker, int val) {
        if((checker & (1 << val)) > 0){ // if both are 1, toggle to 0
            checker = checker ^ (1<<val); // ^ is exclusive or. so all 1/0 pass but 1/1 is 0
        }
        else{
            checker = checker | (1<<val); // or operator to add (1<<val) to checker
        }
        return checker;
    }
}
