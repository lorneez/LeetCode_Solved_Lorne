package CTCI_Arrays_And_Strings;

public class ZeroMatrix {
    public static void main(String[] args){
        int[][] matrix = {
                {1, 2, 3, 3, 3},
                {4, 5, 0, 4, 4},
                {7, 8, 9, 6, 0}
        };
        print(matrix);



        System.out.println("----------");
        print(matrix);
    }

    public static void nullifyRow(int[][] matrix, int row){
        for(int i=0; i<matrix[0].length; i++){
            matrix[row][i] = 0;
        }
    }

    public static void nullifyCol(int[][] matrix, int col){
        for(int i=0; i<matrix.length; i++){
            matrix[i][col] = 0;
        }
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
