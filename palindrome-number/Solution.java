/*
normal approach 
time take 15 ms
if num is smaller than 0 it's can't be palidrome because of sign
if num is greater the 0 simply reverse the number
and return ( normal == reverse ) boolean value
*/
class Solution1 {
    public boolean isPalindrome(int x) {
        if ( x < 0 ) return false ;
        int copy = x ;
        int reversed = 0 ;
        while ( copy != 0 ) {
            reversed *= 10 ;
            reversed += copy%10;
            copy /= 10 ;
        }
        return ( x == reversed ) ;
    }
}

/*
time taken 13 ms ms
if nums is between -1 to 10 range it is palidrome
if num is smaller than zero than it's can't be palidrome because of sign
we iterate the x untill it's smaller than reversed and keep appending value to reversed
in the last step we check if the x is greater than reversed
that means it was a odd num of digit and reversed have more digit than x
so we remove the rightest most and check is its equal

for example
we have 121
after loop
it will become
reversed = 12
and x = 1
we remove rightest most value because reversed is greater than x
so now it's ,
reversed = 1
and x = 1
now we return ( x == reversed )
*/
class Solution2 {
    public boolean isPalindrome(int x) {
        if (x >=0 && x <= 9) return true;
        // Ten is a exception 
        if (x < 0 || x%10 == 0 ) return false;
        int reversed  = 0;
        while (reversed < x){
            reversed = reversed * 10 + x % 10;
            x /=10;
        }
        return reversed > x ? ( reversed / 10 == x) : (reversed == x);
    }
}
