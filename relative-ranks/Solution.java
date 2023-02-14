class Solution {
  public String[] findRelativeRanks( int [] score ) {
    String formattedRank[] = new String[score.length] ;
    HashMap<Integer,String> map = new HashMap<>() ;
    PriorityQueue<Integer> rank = new PriorityQueue<>( Collections.reverseOrder() ) ;
    for ( int i : score ) rank.add( i ) ;
    int index = 1 ;
    while ( !rank.isEmpty() ) {
      switch ( index ) {
        case 1:
        map.put( rank.remove() , "Gold Medal" ) ;
        break;
        case 2:
        map.put( rank.remove() , "Silver Medal" ) ;
        break;
        case 3:
        map.put( rank.remove() , "Bronze Medal" ) ;
        break;
        default:
        map.put( rank.remove() , Integer.toString( index ) ) ;
        break;
      }
      index++ ;
    }
    index = 0 ;
    for ( int i : score ) formattedRank[index++] = map.get(i) ;
    return formattedRank ;
  }
}
