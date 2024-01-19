
// kata link
//https://www.codewars.com/kata/541c8630095125aba6000c00

int digital_root(int n)
{
  if(n/10 != 0){
    int sum = 0;
    while( n >0){
      sum += (n %10);
      n /= 10;
    }

    return  digital_root(sum);
  }
  return n;

}
