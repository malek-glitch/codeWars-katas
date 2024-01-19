/*
    kata link
    https://www.codewars.com/kata/5263c6999e0f40dee200059d
*/
import java.util.*;


public class ObservedPin {

    public static List<Character> adjacentDijt(char c){
        List<Character> list = new ArrayList<Character>();
        list.add(c);
        if(c == '0'){
            list.add('8');
            return list;
        }
        if(c == '8')
            list.add('0');
        int x = c - '0';
        if( (x-1) % 3 == 0 || (x+1) % 3 == 0 )
            list.add((char) (c+1));
        if(x % 3 == 0 || (x+1) % 3 == 0 )
            list.add((char) (c-1));
        if(x > 3)
            list.add((char) (c-3));
        if(x < 7)
            list.add((char) (c+3));
        return list;
    }

    public static List<String> getPINs(String observed) {
        int len =  observed.length();
        List<String> res = new ArrayList<String>(); 
        res.add("");

        for(int i = 0 ; i < len ; i++){
            int listLength = res.size();
            for(int j = 0 ; j < listLength ; j++){
                List<String> allAdjacentDijit = addAllAdjacentDijit(res.get(j), observed.charAt(i));
                res.addAll( allAdjacentDijit );
            }

        } 

        int i = -1;
        while(++i < res.size() ){
            if(res.get(i).length() != len )
                res.remove(i--);

        }
        return res; 
    } 

    public static List<String> addAllAdjacentDijit(String s, char c){
        List<Character> listc = adjacentDijt(c);
        List<String> lists = new ArrayList<String>();
        for(int i = 0 ; i < listc.size() ; i++)
            lists.add( s + listc.get(i));
        return lists;

    }

} 