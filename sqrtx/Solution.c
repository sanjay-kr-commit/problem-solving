#include <stdio.h>
int main() {
    int user_input , lo , hi , mid , t ; 
    printf( "Enter the num whoes sqaure root you want to find : " ) ;
    scanf( "%d" , &user_input ) ;
    if ( user_input <= 1 ) {
        printf( "Sqrt of %d is %d" , user_input , user_input ) ;
        return user_input ;
    }
    lo = 1 ; hi = user_input/ 2 ;
    while ( lo < hi ) {
        mid = lo + ( hi - lo + 1 ) / 2 ;
        t = user_input / mid ;
        if ( t == mid ) break ;
        else if ( t < mid ) hi = mid-1;
        else lo = mid ;
    }
    printf( "Square root of %d is %d\n" , user_input , mid ) ;
    return mid ;
}