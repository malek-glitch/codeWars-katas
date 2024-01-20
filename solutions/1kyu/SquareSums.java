public class SquareSums {
    List<Long> squares(int n){
        List<Long> res = new ArrayList<>();
        for(int i = 2; i * i < n; i++)
            res.add(i * i);
    }
    
    public static List<Integer> buildUpTo(int n) {
        
        List<Integer> res = new ArrayList<>(n);
        List<Long> squares = squares(2 * n);
        
        return null;
    }
    
    
}

/*

   16    16     16     16     16     16     16
   /+\   /+\    /+\    /+\    /+\    /+\    /+\
[ 9, 7, 2, 14, 11, 5, 4, 12, 13, 3, 6, 10, 15, 1, 8 ]
      \+/    \+/    \+/    \+/    \+/    \+/    \+/
        9     25      9     25      9     25      9
*/

// 15 max : 15 + 14 = 29

