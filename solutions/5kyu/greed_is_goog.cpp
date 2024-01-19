
// kata link
//https://www.codewars.com/kata/5270d0d18625160ada0000e4

#include <vector>

int score(const std::vector<int>& dice) {
  int tab[6] = {0}, sum = 0;
  for(int i = 0 ; i < 5 ; i++)
    tab[ dice[i]-1 ]++;
  if(tab[0] > 2)
    sum += 1000 , tab[0] -=3; 
  for(int i = 1 ; i < 6 ; i++)
    if(tab[i] >= 3)
      sum +=(i+1) * 100 , tab[i]-=3 ;

  sum += tab[0]>0? 100*tab[0] : 0;
  sum += tab[4]>0? 50*tab[4]: 0;


  return sum;
}