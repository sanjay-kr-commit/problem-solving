class Solution {

  public String[] findRelativeRanks( int [] score ) {

    String[] formattedRank = new String[ score.length ] ;
    
    PriorityQueue<Integer> que = new PriorityQueue<>( Collections.reverseOrder() ) ;
    
    for ( int i = 0 ; i < score.length ; i++ ) que.add( score[i] ) ;
    
    HashMap<Integer,String> mappedRank = new HashMap<>() ;

    int index = 1 ;
    while ( !que.isEmpty() ) mappedRank.put( que.remove() , Integer.toString(index++) ) ;

    for ( int i = 0 ; i < score.length ; i++ ) {
      int rank = mappedRank.get( score[i] ) ;
      if ( rank == 1 ) formattedRank[i] = "Gold Medal" ;
      else if ( rank == 2 ) formattedRank[i] = "Silver Medal" ;
      else if ( rank == 3 ) formattedRank[i] = "Bronze Medal" ;
      else formattedRank[i] = Integer.toString(rank) ;
    }

    return formattedRank ;

  }

}

// Faster approach
class Solution2 {

  public String[] findRelativeRanks( int [] score ) {

    String[] formattedRank = new String[ score.length ] ;

    int max = Integer.MIN_VALUE ;
    for ( int i : score ) max = max <= i ?i : max ;
    int scoreArray[] = new int[ max+1 ] ;

    for ( int i = 0 ; i < score.length ; i++ ) scoreArray[ score[i] ] = i+1 ;

    int rank = 1 ;
    for ( int i = scoreArray.length-1 ; i >= 0 ; i-- ) {
      if ( rank > score.length ) break ;
      if ( scoreArray[i] > 0 ) {
        switch (rank) {
          case 1: formattedRank[scoreArray[i]-1] = "Gold Medal" ;
          break;
          case 2: formattedRank[scoreArray[i]-1] = "Silver Medal" ;
          break;
          case 3: formattedRank[scoreArray[i]-1] = "Bronze Medal" ;
          break;
          default:
          formattedRank[scoreArray[i]-1] = Integer.toString( rank ) ;
          break;
        }
        rank++ ;
      }
    }

    return formattedRank ;

  }

}
