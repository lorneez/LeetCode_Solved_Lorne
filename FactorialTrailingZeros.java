/**
 * Runtime complexity: O(log(n))
 * Space complexity: O(1)
 * FactorialTrailingZeros finds the number of trailing zeros of n factorial. A factorial has a trailing zero for ever
 * factor that is divisible by 5. This is because there are more 2's than 5's so every five will contribute to a factor
 * of 10. The runtime is O(log(n)) because it first checks 5, then 25, then 625 and so on. It finds all numbers
 * divisible by 5 once and then all the numbers divisible by 5 twice and so on.
 */
class FactorialTrailingZeros {
    public int trailingZeroes(int n) {
        if(n<5){
            return 0;
        }
        long five = 0;
        long x = 5;
        while(x<=n){
            long a = n/x;
            five = five + a;
            x = x * 5;
        }
        return (int)five;
    }
}