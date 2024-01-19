

/*
kata link
https://www.codewars.com/kata/534e01fbbb17187c7e0000c6
*/


public class Spiralizor {

    public static int[][] spiralize(int size) {
        int[][] res = new int[size][size];
        int begi, begj, endi, endj;
        endi = endj = size;
        begi = begj = 0;
        int i, j , loop = 0;
        while(begi < endi){
            
            i = begi;   j = begj;
            
            while(j < endj)
                res[i][j++] = 1;
            
            j--;

            while(i < endi)
                res[i++][j] = 1;
            
            i--;    endj -= 2;  endi -= 2;
            
            if(endi <= begi)
                break;
            
            if(loop>0)
                begj++;
            
            while(j >= begj)
                res[i][j--] = 1;
            
            j++;    begi++;
            
            while(i > begi)
                res[i--][j] = 1;
            
            begi++; begj++; loop++;
        }
        return res;
    }
}