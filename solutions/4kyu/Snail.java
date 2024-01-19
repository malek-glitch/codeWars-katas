/*
* kata link
* https://www.codewars.com/kata/521c2db8ddc89b9b7a0000c1
*/

public class Snail {

    public static int[] snail(int[][] array) {

        int index = 0, n = array[0].length;
        int i = 0, j = 0;
        int beg = 0, end = n;
        int[] res = new int[n*n];

        while (beg < end) {

            while (j < end)
                res[index++] = array[i][j++];

            j--;    i++;

            while (i < end)
                res[index++] = array[i++][j] ;

            i--;    j--;

            while (j >= beg)
                res[index++] = array[i][j--];

            j++;   i--;

            while (i >= beg+1)
                res[index++] = array[i--][j];

            i++;    j++;

            end--; beg++;
        }
        return res;
    }
}