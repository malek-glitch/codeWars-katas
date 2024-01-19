/*  kata link
    https://www.codewars.com/kata/520b9d2ad5c005041100000f
*/

public class Solution {
    public static String repeatStr(final int repeat, final String string) {
        String res = "";
        for(int i = 0; i < repeat ; i++)
            res += string;
        return res;
    }
}