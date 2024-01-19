/*
*   kata link
*   https://www.codewars.com/kata/5541f58a944b85ce6d00006a
*
*  */
public class ProdFib { // must be public for codewars	

    public static long[] productFib(long prod) {
        long f1 = 0, f2 = 1;
        while(f1 * f2 < prod){
            f2 = f1 + f2;
            f1 = f2 - f1;
        }
        return f1 * f2 == prod? new long[] {f1, f2 , 1} : new long[]{f1, f2, 0};
    }
}
