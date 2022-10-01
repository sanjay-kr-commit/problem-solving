/*
The time complexity is O(N^2)
Took 150 ms on leet code and only faster than 6 % others
In this code we run two nested loop
the parent loop will iterate through 0 to n-1 with each iteration
in each iteration it will store a value to look for
which is target - parentLoopVariable in child loop
after this we will start a child loop from 0 to n-1 looking for the 
num target - parentLoopVariable
when matched it will return a new array of int with { parentLoopVarible , childLoopVariable }
else it will return the empty array
*/
class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        for ( int num1 = 0 ; num1 < nums.length ; num1++ ) {
            int secondNum = target - nums[num1] ;
            for ( int num2 = 0 ; num2 < nums.length ; num2++ ) {
                if ( num1 == num2 ) continue ;
                else if ( nums[num2] == secondNum ) {
                    return new int[]{ num1 , num2 } ;
                }
            }
        }
        return new int[]{};
    }
}

/*
Not sure how to state it but here goes nothing
Time complexity is O(N^2/4)
Took 0 ms in leetcode
this is someone else code not mine
in this code too we use two nested loop
but the bound of the loop will be different
also there are 4 pointer in this code two from parent and two from child
In this code snippet the parent loop will create two variable i and len
where i have starting index while len have ending index
with each iteration the i will move one step toward right(i++) and len will move one step toward left (len--)
and the parent loop will only iterate half time of array length
in child loop there will be two more pointer j and l where j will always start with one step ahead of i and l being
one step behing of len and with each iteration j will move toward right ( j++ ) and l will move toward left ( l-- ) by one step
the one thing two notice about is bound the bound is array length - i 
at the end of the loop of each iteration the j will be in rightest most index while l is in left most index
in each iteration they will check for two condtion
( nums[i] + nums[j] == target ) or ( nums[l] + nums[len] == target ) when matched they will return the index
if not found return empty index
*/
class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        // starting and ending pointer
        for ( int i = 0 , len = nums.length-1 ; i < nums.length/2 ; i++ , len-- ) {
            // another two pointer where j is one head of i and l is one behind of len
            for ( int j = i + 1 , l = len - 1 ; j < nums.length - i ; j++ , l-- ) {
                // with this loop the pointer will move 
                if ( nums[i] + nums[j] == target ) return new int[] { i , j } ;
                if ( nums[l] + nums[len] == target ) return new int[] { l , len } ;
            }
        }
        return new int[]{};
    }
}