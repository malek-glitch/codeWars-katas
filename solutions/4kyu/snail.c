
/*
* kata link
* https://www.codewars.com/kata/521c2db8ddc89b9b7a0000c1
*/

#include <stdlib.h>
#include <stdio.h>
int *snail(size_t * outsz, const int **mat, size_t n, size_t m) {
  *outsz = n * m ;
  int k = n ,d = 0 ,sz = 0;
  
  // inti the res array with (-1) { -1, -1, -1, ...}
  int* res =(int*)malloc(*outsz * sizeof(int) + 1);
  for(int i = 0 ; i < n*m ; res[i++] = -1 );
  
  while ( k > 0){
    int i = d , j = d ;
    while(j < k )
      res[sz++] = mat[i][j++] ;
    while(i < k -1)
      res[sz++] = mat[++i][j-1] ; 

    while(j > d+1 ){
      res[sz++] = mat[i][ --j -1  ] ;
    }
    while(i > d + 1 )
      res[sz++] =  mat[--i][j-1] ;
    k-=1; d++;
  }
  return  res ;
}