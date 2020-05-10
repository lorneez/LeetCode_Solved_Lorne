/**
 * Runtime complexity: O(n*m)
 * Space complexity: O(1);
 * LongestCommonPrefix finds the longest common prefix that an array of strings share. It first finds the shortest
 * string in the array and then stores both the string and the length. It then loops through from 0 to m the smallest
 * string length and checks all the characters at the index to see if they are the same. The total runtime is O(n + n*m)
 * which simplifies down to O(n*m) where n is the length of the array and m is the length of the smallest string.
 */
class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        String s ="";
        int smallest = Integer.MAX_VALUE;
        for(String str : strs){
            if(str.length() < smallest){
                smallest = str.length();
                s = str;
            }
        }
        for(int i=0; i<smallest; i++){
            for(String str: strs){
                if(str.charAt(i) != strs[0].charAt(i)){
                    return str.substring(0,i);
                }
            }
        }
        return s;
    }
}
