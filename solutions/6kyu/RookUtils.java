/*
    kata link
    https://www.codewars.com/kata/64416600772f2775f1de03f9
 */

public class RookUtils {
    public static int countAttackingRooks(int[][] rooks) {
        int res = 0;
        int[][] board = new int[8][8];
        for (int[] rook : rooks) {
            int x = rook[0], y = rook[1];
            board[x][y] = 1;
        }
        for(int i = 0; i < 8; i++) {
            int l = 0, c = 0;
            for (int j = 0; j < 8; j++) {
                l += board[i][j];
                c += board[j][i];
            }
            res += Math.max(0, l -1) + Math.max(0, c -1);
        }
        return res;
    }
}