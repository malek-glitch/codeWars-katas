/*
    kata link
    https://www.codewars.com/kata/5552101f47fc5178b1000050
*/
public class DigPow {

    public static long digPow(int n, int p) {
        long sum = 0;
        String num = n + "";
        for(int i = 0; i < num.length(); i++){
            sum += Math.pow(num.charAt(i)-'0', i+p);
        }
        if( sum % n == 0)
            return sum / n;

        return -1;
    }

}