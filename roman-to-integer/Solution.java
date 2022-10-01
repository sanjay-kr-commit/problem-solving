/*
time complexity is O(N)
took 5 ms on leet code
we run a loop from right to left
and store the value in temp variable
than we multiply it by 4 and check if it's
smaller than total than we subtract or else we add

we does this because there's pattern in roman numbers
every simple is use value four variation first three being together
and last one being ahead of the next maajor symbol to decrease it's value
by the value of symbol

for example
I who's value is one is seen together in four variation
I = 1
II = 2
III = 3
and in last one we assign I infront of V ( value that comes after I )
IV = 4
Now we can see V holds 5 value and I hold 1 by placing I in front of V
we substracted I from V i.e. 5-1=4
this pattern is repeated everywhere 

so the maximum value of any symbol is The Symbol * 4
*/
class Solution {

    public int romanToInt(String s) {

        int value = 0 ;
        int temp = 0 ;
        for ( int i = s.length()-1 ; i >= 0 ; i-- ) {
            switch ( s.charAt(i) ) {
                case 'I' : temp = 1 ; break ;
                case 'V' : temp = 5 ; break ;
                case 'X' : temp = 10 ; break ;
                case 'L' : temp = 50 ; break ;
                case 'C' : temp = 100 ; break ;
                case 'D' : temp = 500 ; break ;
                case 'M' : temp = 1000 ; break ;
            }
            value += ( temp*4 < value ) ? -1*temp : temp ;
        }
        
        return value ;

    }
}