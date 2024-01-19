/*
* kata link
* https://www.codewars.com/kata/526571aae218b8ee490006f4
* */

#include <stddef.h>

size_t bit_counting(unsigned v)
{
  int b = 0;
  while(v > 0){
    b += v%2;
    v = v / 2;
  }
  return b;
}