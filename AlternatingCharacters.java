/**
 * Runtime complexity: O(n)
 * Space complexity: O(1)
 * AlternatingCharacters stores the last seen character. If the next character is the last seen, it adds to the count.
 * If it isn't, the character is swapped.
 */
public class AlternatingCharacters {
    static int alternatingCharacters(String s) {
        char last = s.charAt(0);
        int count = 0;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == last){
                count ++;
            }
            else{
                last = s.charAt(i);
            }
        }
        return count;

    }
}
