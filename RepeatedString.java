/**
 * Runtime complexity: O(n)
 * Space complexity: O(1)
 * RepeatedString finds the count of "a" in a repeated string by splitting the problem into two parts. The first part
 * finds the count in fully repeated sections. The second part finds the count in the remaining section that is not
 * fully repeated.
 */
public class RepeatedString {
    static long repeatedString(String s, long n) {
        long amount = 0;
        for(int i=0; i<s.length(); i++){
            if(s.substring(i,i+1).equals("a")){
                amount ++;
            }
        }
        long ret = (amount) * (n/s.length());
        long rem = n%s.length();
        for(int x=0; x<rem; x++){
            if(s.substring(x,x+1).equals("a")){
                ret ++;
            }
        }
        return ret;
    }
}
