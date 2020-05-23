/**
 * Runtime complexity: O(n)
 * Space complexity: O(n)
 * Uses int arr to count the number of char in each string. Then it sums and returns the difference.
 */
public class MakingAnagram {
    static int makeAnagram(String a, String b) {
        int[] a_map = new int[26];
        int[] b_map = new int[26];
        for(char i : a.toCharArray()){
            a_map[i-97]++;
        }
        for(char i : b.toCharArray()){
            b_map[i-97]++;
        }
        int removal = 0;
        for(int i=0; i<26; i++){
            removal += Math.abs(a_map[i] - b_map[i]);
        }
        return removal;
    }

}
