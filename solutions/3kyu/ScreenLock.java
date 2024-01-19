/*
    kata link
    https://www.codewars.com/kata/585894545a8a07255e0002f1
*/


import java.util.HashMap;
import java.util.Map;
import java.util.*;

/*
ScreenLock (schema) is represented as a grid :
    A   B   C
    D   E   F
    G   H   I 
*/



public class ScreenLock {
    private final static Map<Character, String> nextPoints= new HashMap(){{
//        the upperCase letter (in the value string) are the  POINTs that can be accessed
//        directly by key POINT
        
//        the lowerCase latter (in the value string) are the POINTs that can be accessed
//        if the previos (upperCase) POINT is already visited (its hiding behind it)
        
//        EXAMPLE:
//        if the current POINT is A we can go to B directly
//        and we can't visit C until we go to B first
        /*
                       (A)  B   c
                        D   E   F
                        g   H   i 
        */
        
        put('A', "BcDgEiHF");
        put('B', "ACDEhFGI");
        put('C', "BaDEgFiH");
        put('D', "ABCEfGHI");
        put('E', "ABCDFGHI");
        put('F', "ABCEdGHI");
        put('G', "DaEcFHiB");
        put('H', "ACDEbFGI");
        put('I', "BDEaFcHg");
    }};

    public static int calculateCombinations(char startPosition, int patternLength){
        if ( patternLength < 1  || patternLength > 9)
            return 0;
        int[] points = new int[9];
        Arrays.fill(points, 0);
        points[startPosition - 'A'] = 1;
        return numberPattern(startPosition, patternLength , points);
    }

    public static int numberPattern(char startPosition, int patternLength, int[] points){
        if(patternLength == 1)
            return 1;

        int res = 0, index = 0;
        String next = nextPoints.get(startPosition);
        for(int i = 0; i < next.length(); i++){
            if(next.charAt(i) <= 'I' && next.charAt(i) >= 'A'){
                index = next.charAt(i) - 'A';
                if(points[index] == 0){
                    int[] copiedPoints = Arrays.copyOf(points, points.length );
                    copiedPoints[index] = 1;
                    res += numberPattern(next.charAt(i), patternLength -1, copiedPoints );
                }
            }else if(next.charAt(i) <= 'i' && next.charAt(i) >= 'a'){
                index = next.charAt(i) - 'a';
                if(points[next.charAt(i-1) - 'A'] == 1 && points[index] == 0){
                    int[] copiedPoints = Arrays.copyOf(points, points.length );
                    copiedPoints[index] = 1;
                    res += numberPattern( (char)( index+'A'), patternLength -1, copiedPoints );
                }
            }
        }    
        return res;
    }

}
