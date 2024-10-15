#include <stdlib.h>
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* asteroidCollision(int* asteroids, int asteroidsSize, int* returnSize) {

  // create a stack using int
  int *stack = (int*) malloc(sizeof(int)*asteroidsSize) ;
  int size = 0 ;

  for ( int i = 0 ; i < asteroidsSize ; i++ ) {

    stack[size] = asteroids[i] ;
    size++ ;

    while ( size > 1 && stack[size-1] < 0 && stack[size-2] > -1 ) {

      int mod_a = stack[size-1] , mod_b = stack[size-2] ;
      mod_a = ( mod_a < 0 ) ? -1 * mod_a : mod_a ;

      if ( mod_b == mod_a ) size-- ;
      else if ( mod_b < mod_a ) stack[size-2] = stack[size-1] ;
      size-- ;

    }

  }

  *returnSize = size ;
  return stack;
}
