package CTCI_Arrays_And_Strings;

public class RotateMatrix {
    public static void main(String[] args){
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        print(matrix);
        System.out.println("---");
        matrix = rotate(matrix);
        print(matrix);
    }

    public static int[][] rotate(int[][] matrix) {
        int n = matrix.length;

        for(int layer=0; layer<n/2; layer++){
            int first = layer;
            int last = n - 1 - layer;
            for(int index=first; index<last; index++){
                int offset = index - first;
                int top = matrix[first][index];
                matrix[first][index] = matrix[last-offset][first];
                matrix[last-offset][first] = matrix[last][last-offset];
                matrix[last][last-offset] = matrix[index][last];
                matrix[index][last] = top;
            }
        }

        return matrix;
    }

    public static void print(int[][] matrix){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

