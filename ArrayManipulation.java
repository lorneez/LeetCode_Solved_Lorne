/**
 * Runtime complexity: O(n+m)
 * Space complexity: O(n)
 * ArrayManipulation takes in a set of queries and modifies an array and returns the max value. Because each
 * query defines a range of how it is modified. We know that all the cells in the range are modified. The brute
 * force method is O(n*m) which essentially for loops through it all. The faster way is to recognize that the array can
 * represent the accumulation of edits at the index. For each query, we add that value to the starting index
 * and then subtract it at one + the ending index. Then for looping through the array and finding the max sum gives
 * the max value in the array.
 */
public class ArrayManipulation {
    static long arrayManipulation(int n, int[][] queries) {
        // O(n+m) runtime
        long[] arr = new long[n+1];
        for(int i=0; i<queries.length; i++){
            arr[queries[i][0]-1] += queries[i][2];
            arr[queries[i][1]] -= queries[i][2];
        }
        long max = 0;
        long iter = 0;
        for(long x:arr){
            iter += x;
            if(iter > max){
                max = iter;
            }
        }
        return max;
    }
}
