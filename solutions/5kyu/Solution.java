
//kata link
// https://www.codewars.com/kata/525caa5c1bf619d28c000335

public class Solution {

    public static int isSolved(int[][] board) {
        int lx ,cx , lo, co ,zero = 0;
        int digLeft = 0, digRight = 0;
        for(int i = 0 ; i < 3 ; i++){
            if(board[i][i] != 0 && board[i][i] == board[1][1]){
                digLeft++;
            }
            if(board[i][3-1-i] != 0 && board[i][3-1-i] == board[1][1]){
                digRight++;
            }

            lx = cx = lo = co = 0;
            for(int j = 0 ; j <3 ; j++){
                if(board[i][j] == 1){
                    lx++;
                }else if(board[i][j] == 2){
                    lo++;
                }else{
                    zero++;
                }
                if(board[j][i] == 1){
                    cx++;
                }else if(board[j][i] == 2){
                    co++;
                }

            } 
            if(lx == 3 || cx == 3)
                return 1;
            if(lo == 3 || co == 3)
                return 2;
        }
        if(digLeft == 3 || digRight== 3 ) return board[1][1];
        if (zero > 0) return -1;
        return 0;
    }
}