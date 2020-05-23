/**
 * Runtime complexity: O(n^2)
 * Space complexity: O(1)
 */
public class SpecialStringAgain {
    public static void main(String[] arg){
        System.out.println("Got: " + substrCount(12, "mnonopoo"));
    }
    static long substrCount(int n, String s) {
        System.out.println("Expected: " + n);
        long count = 1;
        for(int i=1; i<s.length(); i++){
            System.out.println("Checking: " + i);
            count += checkPalindrome(s, i);
        }
        return count;
    }

    static long checkPalindrome(String s, int i){
        long count = 1;
        //System.out.println("Found: " + count);
        // check all odd
        int left = i-1; //2
        int right = i+1; //2
        char check = s.charAt(i-1); //b
        while(left >= 0 && right < s.length() && s.charAt(left) == check && s.charAt(right) == check){
            count ++;
            right ++;
            left --;
            //System.out.println("Found: " + count);

        }
        // check all even
        int even = i-1;
        while(even >= 0 && s.charAt(even) == s.charAt(i)){
            if((i-even)%2==1){
                count ++;
            }
            even --;
        }
        System.out.println(count);
        return count;
    }
}
