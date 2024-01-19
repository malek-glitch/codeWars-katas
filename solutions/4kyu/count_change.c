
/*kata link
https://www.codewars.com/kata/541af676b589989aed0009e7
*/

// kata soved using DYNAMIC PROGRAMMING


int count_change(int money, int n_coins, const int * coins)
{
  if(money == 0)
    return 1;

  if(n_coins == 0)
    return 0;

  if(money < 0)
    return 0;

  return count_change(money, n_coins -1, coins ) + count_change(money - coins[n_coins-1], n_coins, coins);
}