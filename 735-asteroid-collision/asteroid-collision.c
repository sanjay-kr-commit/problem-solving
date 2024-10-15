#include <stdlib.h>
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* asteroidCollision(int* asteroids, int asteroidsSize, int* returnSize) {

  int size = 0 ,
      *stack = (int*) malloc(sizeof(int)*asteroidsSize) ;

  for ( int i = 0 ; i < asteroidsSize ; i++ ) {
    // filling stack
    stack[size] = asteroids[i] ;
    size++ ;
    // calculating collisions
    while ( size > 1 && stack[size-1] < 0 && stack[size-2] > -1 ) {

      int mod_top = -1 * stack[size-1] ;

      if ( mod_top == stack[size-2] ) size-- ;
      else if ( mod_top > stack[size-2] ) stack[size-2] = stack[size-1] ;
    
      size-- ;

    }

  }

  *returnSize = size ;
  return stack;

}
