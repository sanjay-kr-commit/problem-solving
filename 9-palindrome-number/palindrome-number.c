bool isPalindrome(int x) {
    if ( x > -1 && x < 10 ) return true ;
    if ( x < 0 || x % 10 == 0 ) return false ;
    int split = 0 ,
        bak = x ;
    while ( split < bak ) {
        split *= 10 ;
        split += bak % 10 ;
        bak /= 10 ;
    }
    if ( split > bak ) split /= 10 ;
    return split == bak ;
}