
/*
    kata link
        (https://www.codewars.com/kata/52c4dd683bfd3b434c000292)
 */

public class CarMileage {

    public static int isInteresting(int number, int[] awesomePhrases) {

        if(isInterestingNumber(number, awesomePhrases))
            return 2;
        if (isInterestingNumber(number +1, awesomePhrases) || isInterestingNumber(number +2, awesomePhrases)) {
            return 1;
        }
        return 0;
    }

    private static boolean isInterestingNumber(int number, int[] awesomePhrases) {
        if(number < 100)
            return false;
        for (int awesomePhrase : awesomePhrases) {
            if (number == awesomePhrase)
                return true;
        }
        boolean isPalindrome = true, isIncrement = true,
                isDecrement  = true;
        char[] sNumber = Integer.toString(number).toCharArray();
        int length = sNumber.length;
        for(int i = 0; i < length; i++){
            int currentDigit = sNumber[i] - '0';
            //(Every digit is the same number) is a sub group of palindrome 
            if(sNumber[i] != sNumber[length -1 - i]) 
                isPalindrome = false;   // 12321 || 22222

            if(i > 0 && currentDigit != (sNumber[i -1] - '0' + 1) % 10)
                isIncrement = false;    // 1234567890
            if(i > 0 && (currentDigit) != (sNumber[i -1] -1 - '0') )
                isDecrement = false;    // 0987654321
        }
        boolean isDigitFollowedByZeros = number % (int) Math.pow(10, length -1) == 0;

        if(isDecrement || isIncrement || isPalindrome || isDigitFollowedByZeros)
            return true;

        return false;
    }
}