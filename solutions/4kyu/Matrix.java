/*
    kata link
    https://www.codewars.com/kata/52a382ee44408cea2500074c
*/

public class Matrix {
  
    public static int det4(int[][] matrix){
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

     public static int determinant(int[][] matrix) {
        int res = 0;
        if(matrix.length == 1)
            return matrix[0][0];

        if(matrix.length == 2)
            return det4(matrix);

        int n = matrix.length;
        int k = 1;

        for(int i = 0; i < matrix.length; i++){
            int[][] subMatrix = subMatrix(matrix, i);
            res += matrix[0][i] * k * determinant(subMatrix);
            k *= -1;
        }
         return res;
    }

     private static int[][] subMatrix(int[][] matrix, int d) {
        int n = matrix.length -1;
        int[][] sub = new int[n][n];
        for(int i = 1; i < matrix.length; i++){
            int c = 0;
            for(int j = 0; j < n+1 ; j++){
                if( j == d) continue;
                sub[i-1][c++] = matrix[i][j];
            }
        }
         return sub;
    }
}