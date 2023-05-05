class Solution {

  public String[] findRestaurant(String[] list1, String[] list2) {
    if ( list1.length > list2.length ) return findRestaurant( list2 , list1 ) ;
    HashMap<String,Integer> hm = new HashMap<>() ;
    for ( int i = 0 ; i < list1.length ; i++ ) hm.put( list1[i] , i ) ;
    int minIndex = Integer.MAX_VALUE , count = 0 ;
    List<String> min = new ArrayList<>( list1.length ) ;
    for ( int i = 0 ; i < list2.length ; i++ ) {
      Integer x = hm.get( list2[i] ) ;
      if ( x == null ) continue ;
      if ( x+i < minIndex ) { 
        minIndex = x+i ;
        count =  0 ;
      }
      if ( x+i == minIndex ) min.add( count++ , list2[i] ) ;
    }
    return min.subList( 0 , count ).toArray( new String[0] ) ;
  }

} 
