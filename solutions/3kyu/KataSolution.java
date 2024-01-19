
/*
kata solution : Binomial Expansion
https://www.codewars.com/kata/540d0fdd3b6532e5c3000b5b
*/

import java.util.Arrays;

public class KataSolution {

    public static int[] identification(String s){
        int[] res = new int[4];
        int k = 0, x = 1;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '-')
                x = -1;

            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                while(s.charAt(i) >= '0' && s.charAt(i) <= '9')
                    res[k] = res[k] * 10 + s.charAt(i++) -'0';
                res[k++] *= x ;
                x = 1;        
            }


            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                if(k == 0){
                    res[k++] = x;
                    x = 1;
                }
                res[3] = s.charAt(i);
            }
            if(s.charAt(i) == '^'){

                while(++i < s.length() ){
                    res[2] = res[2] * 10 + (s.charAt(i) - '0');
                }

            }
        }
        return res;
    }

    public static String expand(String expr) {
        int[] id = identification(expr);
        int a = id[0], b = id[1], n= id[2];
        char x =(char) id[3];
        System.out.println(a+ " " + x + " " + b + ") ^" + n);
        if(n == 0)
            return "1";
        if(n == 1)
            return expr.substring(1, expr.indexOf(")") );
        int[][] pascalTringle = new int[n+1][n+1];
        for( int[] row : pascalTringle)
            Arrays.fill(row, 1);

        for(int i = 2 ; i < n+1 ; i ++){                                       
            for(int j = 1 ; j < i; j++)
                pascalTringle[i][j] = pascalTringle[i-1][j] + pascalTringle[i-1][j-1];
        }                                                                     
    String res = new String(), SIGN;
        for(int i = 0 ; i <= n ; i++){

            long cof =  (long) ( (Math.pow((double) a, n-i) * Math.pow((double) b, i)) * pascalTringle[n][i] ) ;
            System.out.println(pascalTringle[n][i] + " ");
            if(cof == 0)
                continue;

            if(cof > 0 && i > 0) // sign of coeftion
                SIGN = "+";
            else if( cof < 0){
                SIGN = "-";
                cof *= -1;
            }else
                SIGN = "";

            if(n == i) // x pow 0
                res += SIGN + cof;
            else if(n-i == 1) // x pow 1
                res += SIGN + cof + "" + x ;
            else {  // x pow (n-i)
                if(cof == 1 || cof == -1)
                    res += SIGN +  x + "^" + (Integer) (n-i)  ;
                else
                    res += SIGN + cof + "" + x + "^" + (Integer) (n-i)  ;  
            }
        }

    return res;
    }

}