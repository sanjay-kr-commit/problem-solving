class Solution {
    public int dayOfYear(String date) {
        int dayOfYear = 0 ;
        int year = 0 , month = 0 , day = 0 ;
        for ( int i = 0 ; i < 4 ; i++ ) {
            year *= 10 ;
            year += date.charAt( i ) - '0' ;
        }
        for ( int i = 5 ; i < 7 ; i++ ) {
            month *= 10 ;
            month += date.charAt( i ) - '0' ;
        }
        for ( int i = 8 ; i < 10 ; i++ ) {
            day *= 10 ;
            day += date.charAt( i ) -'0' ;
        }
        month--;
        if ( month > 1 && ((year % 4 == 0 && year%100!=0)||(year%100 == 0 && year%400==0)) )dayOfYear++ ;
        dayOfYear += month * 30 ;
        if ( month > 1 ) dayOfYear -= 2 ;
        month++ ;
        for ( int i = 1; i < month ; i++ ) dayOfYear += ( ( i < 8 && i%2 ==1 ) || (i>7&&i%2==0) ) ? 1 : 0 ;
        dayOfYear += day ;
        return dayOfYear ;
    }
}
