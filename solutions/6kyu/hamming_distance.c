/*
*   kata link
*   https://www.codewars.com/kata/58a6af7e8c08b1e9c40001c1
* */
unsigned hamming_distance (unsigned a, unsigned b)
{
  unsigned res=0;
  b > a ? (
              a = a + b, b = a - b,a = a - b):0;
  while(a > 0){ 

    if(b != 0)
      res += (a % 2) != (b % 2);
    else
      res += (a % 2 ); 

    a /= 2, b /= 2;    
  }
  return res;
}