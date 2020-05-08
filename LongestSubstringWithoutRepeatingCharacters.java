import java.util.HashMap;
import java.util.Map;

/**
 * Runtime Complexity: O(n)
 * Space Complexity: O(n)
 * LongestSubstringWithoutRepeatingCharacters analyzes a string using a HashMap. It loops through the string
 * and stores the right and left indexes of the longest substring without repeating characters. It updates
 * the right index based on a for loop and updates the left index based on the maximum of the current left index
 * and the last index of the repeated value + 1.
 */
class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> myMap = new HashMap<>();
        int max = 0;
        int left = 0;
        for(int right=0; right<s.length(); right++){
            if(myMap.containsKey(s.charAt(right))){
                // sets left to either next value if previous was charAt(right) or left.
                // left is less if the next value is right.
                // left is greater if the last value has been seen a long time ago.
                // this removes redundancy.
                left = Math.max(left, myMap.get(s.charAt(right)) +1);
            }
            myMap.put(s.charAt(right), right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}