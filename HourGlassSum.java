/**
 * Runtime complexity: O(n^2) ???
 * Space complexity: O(1)
 * HourGlassSum computes the largest hour glass sum in a 6x6 array using brute force.
 */
public class HourGlassSum {
    static int hourglassSum(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if(sum(arr, i, j) > max){
                    max = sum(arr,i,j);
                }
            }
        }
        return max;
    }
    private static int sum(int[][] arr, int i, int j){
        return arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2] + arr[i+1][j+1];
    }
}
