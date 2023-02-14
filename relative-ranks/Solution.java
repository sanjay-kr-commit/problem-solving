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
