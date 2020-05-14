import java.util.ArrayList;
import java.util.List;

/**
 * Runtime complexity: O(n)
 * Space complexity: O(n)
 * SpiralMatrix returns the elements by brute force for looping.
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ret = new ArrayList<>();
        if(matrix.length == 0){
            return new ArrayList<Integer>();
        }
        int trow = 0;
        int brow = matrix.length-1;
        int lcol = 0;
        int rcol = matrix[0].length-1;

        while(trow <= brow && rcol >= lcol){
            // move right towards right column
            for(int i=lcol; i<=rcol; i++){
                ret.add(matrix[trow][i]);
            }
            trow++;
            // move down towards bottom row
            for(int j=trow; j<=brow; j++){
                ret.add(matrix[j][rcol]);
            }
            rcol--;
            if(trow>brow || lcol>rcol){
                break;
            }
            for(int x=rcol; x>=lcol; x--){
                ret.add(matrix[brow][x]);
            }
            brow--;
            for(int y=brow; y>=trow; y--){
                ret.add(matrix[y][lcol]);
            }
            lcol++;
        }
        return ret;
    }
}
