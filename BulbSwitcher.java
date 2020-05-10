/**
 * Runtime complexity: O(log(n))
 * Space complexity: O(1)
 * BulbSwitcher uses Math.sqrt to compute the answer in a runtime complexity of O(log(n)). The problem
 * essentially asks to find the number of integers 1-n that have an odd number of factors in their complete
 * prime factorization. This is only the case for square numbers. Thus, the square root of n represents the number
 * of squares from 1-n.
 */
public class BulbSwitcher {
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
}