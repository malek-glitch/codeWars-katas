/*
    kata link
    https://www.codewars.com/kata/5726f813c8dcebf5ed000a6b
*/


import java.util.Arrays;

public class KPrimes {

    public static long[] countKprimes(int k, long start, long end) {
        long[] res = new long[100];
        int index = 0;
        for(long i = start; i <= end; i++){
            if(kPrime(i, k)){
                if(index == res.length){
                    res = Arrays.copyOf(res, index +1);
                }
                res[index++] = i;
            }
        }
        return Arrays.copyOf(res, index);
    }

    private static boolean kPrime(long num, int k) {
        int numberOfPrimes = 0;

        while (num % 2 == 0 && num > 1){
            num /= 2;
            numberOfPrimes++;
        }
        long p = 3;
        while(p <= Math.sqrt(num) ){
            if(num % p == 0){
                numberOfPrimes++;
                num /= p;
                p -= 2;
            }
            p += 2;
        }
        if(num > 1)
            numberOfPrimes++;
        return numberOfPrimes == k;
    }

    public static int puzzle(int s) {
        int res = 0;
        for(int i = 2; i <= s -8 -128; i++)
            if (kPrime(i, 1))
                for (int j = 8; j <= s - i - 128 ; j++)
                    if(kPrime(j, 3) && kPrime(s - i - j, 7))
                        res++;
        return res;
    }
}