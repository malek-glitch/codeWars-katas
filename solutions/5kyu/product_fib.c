/*
*   kata link
*   https://www.codewars.com/kata/5541f58a944b85ce6d00006a
* */

#include<stdlib.h>
#include<stdio.h>

typedef unsigned long long ull;

unsigned long long* product_fib(ull prod) {
  ull a = 1 , b = 1 ;
  while(a * b < prod){
    b = a + b ;
    a = b - a ;
  }

  ull * res ;
  res = (ull *) malloc (3*sizeof(ull));
  res[0] = a ;
  res[1] = (ull )b;
  res[2] = (ull)(a*b == prod) ;
  return res;
}