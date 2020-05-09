/**
 * Runtime complexity: O(n)
 * Space complexity: O(n)
 * PalindromeNumber checks if an integer is a palindrome.
 * The first method converts the integer into a string and then checks each of the values inside the string.
 * The runtime is technically O(n/2).
 * The second method creates the reverse integer with a while loop. This runtime is O(n) and space is O(n).
 */
class PalindromeNumber {
    public boolean isPalindrome_String(int x) {
        String num = Integer.toString(x);
        int s = num.length();
        for(int i=0; i<s/2; i++){
            if(!num.substring(i,i+1).equals(num.substring(s-i-1, s-i))){
                return false;
            }
        }
        return true;
    }
    public boolean isPalindrome_Integer(int x) {
        if(x<0)
            return false;
        int temp = x;
        int reversed = 0;
        while(temp>0)
        {
            reversed = reversed*10 + (temp%10);
            temp = temp/10;
        }
        if(reversed==x)
            return true;
        return false;
    }
}