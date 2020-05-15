import java.util.HashSet;
import java.util.Set;

/**
 * Runtime complexity: O(n)
 * Space complexity: O(n)
 * TwoStrings checks if two strings have a common substring between them using a set. It is possible to do this by
 * for looping through a char array of all possible characters.
 */
public class TwoStrings {
    static String twoStrings(String s1, String s2) {
        Set<Character> set = new HashSet<>();
        for(int i=0; i<s1.length(); i++){
            set.add(s1.charAt(i));
        }
        for(int j=0; j<s2.length(); j++){
            if(set.contains(s2.charAt(j))){
                return "YES";
            }
        }
        return "NO";
    }
}
