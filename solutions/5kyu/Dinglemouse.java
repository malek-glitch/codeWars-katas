

/*kata link : am I allAlone
https://www.codewars.com/kata/5c230f017f74a2e1c300004f
*/


// a really coool problem you must try it
public class Dinglemouse {

    public static boolean allAlone(char[][] house) {
        for(int i = 0 ; i < house.length ; i++)
            for(int j = 0 ; j <house[i].length ; j++)
                if(house[i][j] == 'X')
                    return !isAlone(house, i, j);
        return false;
    }

    public static boolean isAlone(char[][] map,int i , int j ){
        if( i == map.length || j == map[0].length || i == 0 || j == 0 )
            return false;
        if(map[i][j] == '#')
            return false;
        if(map[i][j] == 'o')
            return true;
        map[i][j] = '#';

        return ( isAlone(map, i, j+1) || isAlone(map, i, j-1) ||
                 isAlone(map, i+1, j) || isAlone(map, i-1, j) );

    }
}