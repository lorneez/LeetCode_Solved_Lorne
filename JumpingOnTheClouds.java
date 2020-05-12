/**
 * Runtime complexity: O(n)
 * Space complexity: O(1)
 * JumpingOnTheClouds returns the smallest number of jumps needed to finish the game. It takes two space jumps whenever
 * possible.
 */
public class JumpingOnTheClouds {
    static int jumpingOnClouds(int[] c) {
        int index = 0;
        int count = 0;
        while(index != c.length-1){
            if(index+2 < c.length && c[index+2] == 0){
                index += 2;
            }
            else{
                index ++;
            }
            count ++;
        }
        return count;
    }
}
