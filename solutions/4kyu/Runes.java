/*
kata link
    https://www.codewars.com/kata/546d15cebed2e10334000ed9
    
*/

class Runes {
    public static int solveExpression(final String expr) {
        int[] containInt = new int[10];
        for(int i  = 0; i < expr.length(); i++)
            if(expr.charAt(i) <= '9' && expr.charAt(i) >= '0')
                containInt[ expr.charAt(i) -'0' ] = 1;

        String[] operators = splitExpr(expr);
        char op = operators[1].charAt(0);


        for (int i = 0; i <= 9; i++) {
            if(containInt[i] == 1)
                continue;
            String a = convert(operators[0], i),  b = convert(operators[2], i),  res = convert(operators[3], i);
            if(!isValid(a) || !isValid(b) || !isValid(res))
                continue;

            long A = valueOf(a), B = valueOf(b), RES = valueOf(res);

            if (calcule(A, op, B) == RES)
                return i;
        }
        System.out.println(expr);
        return -1;
    }


    public static String convert(String s, int r){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == '?')
                res.append(r);
        else
            res.append(s.charAt(i));

        return res.toString();
    }

    public static long valueOf(String s) {
        return Long.parseLong(s);
    }


    private static long calcule(long a, char op, long b) {

        return switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            default  -> a * b;
        };
    }

    private static boolean isValid(String s) {
        int index = 0;
        if(s.charAt(index) == '-' || s.charAt(index) == '+')
            index++;
        if(s.length() == index+1)
            return true;
        if (s.charAt(index) == '0')
            return false;
        for (int i = index; i < s.length(); i++)
            if (s.charAt(i) != '0')
                return true;
        return false;
    }

    public static boolean isInt(char c) {
        return c == '?' || c >= '0' && c <= '9';
    }

    public static String[] splitExpr(String expr) {
        String[] res = new String[4];
        int index = expr.indexOf('=');
        res[3] = expr.substring(index+1);              //res

        for (int i = 1; expr.charAt(i) != 0; i++) {
            if (!isInt(expr.charAt(i)) && isInt(expr.charAt(i - 1))) {
                index = i;
                break;
            }
        }
        res[1] = expr.charAt(index) + "";                       // operator
        res[0] = expr.substring(0, index);                      // a
        res[2] = expr.substring(index + 1, expr.indexOf('='));  // b

        return res;
    }

}