/**
 * Runtime complexity: O(n^2)
 * Space complexity: O(1)
 * LongestPalindromicSubstring finds the longest palindromic substring in a string. It uses one for loop to
 * loop through the string contributing O(n) to the runtime complexity. Then, at each index, it checks the length of
 * the odd and even palindromic strings starting at i,i and i,i+1 respectively. This contributes another O(n).
 * This loops to find the max length and also saves the indexes of the max substring.
 */
class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1){
            return "";
        }
        int start = 0;
        int end = 0;
        for(int i=0; i<s.length(); i++){
            int odd = checkPalindrome(s, i, i);
            int even = checkPalindrome(s, i, i+1);
            int maxLen = Math.max(odd, even);
            if(maxLen > end - start){
                start = i - ((maxLen-1)/2);
                end = i + (maxLen/2);
            }
        }
        return s.substring(start,end+1);
    }
    public int checkPalindrome(String s, int left, int right){
        if(left>right || s==null){
            return 0;
        }
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            right ++;
            left --;
        }
        return right - left - 1;
    }
}