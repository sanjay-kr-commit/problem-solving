#include <stdlib.h>

int comp(const void* a, const void* b) {
    return (*(int*)a - *(int*)b);
}

int* successfulPairs(
  int* spells, 
  int spellsSize, 
  int* potions, 
  int potionsSize, 
  long long success, 
  int* returnSize
) {
  qsort(potions, potionsSize, sizeof(int) , comp ) ;
  int *result = ( int * ) malloc(sizeof(int)*spellsSize) ;
  int l = 0 , r = potionsSize , m , isPrior = 0 ;
  for ( int i = 0 ; i < spellsSize ; i++ ) {
    if (isPrior) {
      if ( spells[i] == spells[i-1] ) {
        result[i] = result[i-1] ;
        continue; 
      } else if ( spells[i-1] > spells[i] ) {
        r = potionsSize ;
      } else {
        r = l ;
        l = 0 ;
      }
    } else isPrior = 1 ;
    long long x = success / ((long long)spells[i]) ;
    if ( success % spells[i] != 0 ) x++ ;
    while ( l < r ) { 
      m = l + ( r - l ) / 2 ;
      if ( potions[m] == x ) {
        l = m ;
        break;
      } else if ( potions[m] > x ) r = m-1 ;
      else l = m+1 ;
    }
    if ( l < potionsSize ) while ( l > 0 && potions[l] > x ) l-- ;
    if ( l > -1 ) while ( l < potionsSize && potions[l] < x ) l++ ;
    r = l ;
    if ( l < potionsSize ) while ( l > -1 && potions[l] == potions[r] ) l-- ;
    l += ( l == potionsSize ) ? 0 : 1 ;
    result[i] = potionsSize-l ;
  }
  *returnSize = spellsSize ;
  return result ;
}
