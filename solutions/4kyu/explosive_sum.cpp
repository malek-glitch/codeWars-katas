/*
    kata link
    https://www.codewars.com/kata/52ec24228a515e620b0005ef
*/

#include <vector>

using ull = unsigned long long;

ull exp_sum(unsigned int n) {
  std::vector<ull> vec ;
  for(unsigned int i = 0; i < n+1 ; i++)
    vec.push_back(0);
  vec[0] = 1;
  for(unsigned int i = 1; i < n+1 ; i++)
    for(unsigned int j = i; j < n+1 ; j++)
      vec[j] += vec[j - i];

  return vec[n];
}