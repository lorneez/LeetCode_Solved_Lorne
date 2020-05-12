/**
 * Runtime complexity: O(n)
 * Space complexity: O(1)
 * CountingValleys determines the number of valleys the person enters/exits by counting each time the person
 * enters or exits a valley and then taking the smaller of the two values.
 */
public class CountingValleys {
    static int countingValleys(int n, String s) {
        int pos = 0;
        int enter = 0;
        int exit = 0;
        for(int i=0; i<n; i++){
            if(pos == 0 && s.substring(i,i+1).equals("D")){
                enter ++;
            }
            if(pos == -1 && s.substring(i,i+1).equals("U")){
                exit ++;
            }
            int change = (s.substring(i,i+1).equals("U")) ? 1 : -1;
            pos += change;
        }
        return Math.min(enter, exit);

    }
}
