/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    TreeNode nearestCommonNode ;

    public String getDirections( TreeNode root , int startValue , int destValue ) {
        nearestCommonNode = null ;
        StringBuilder direction = new StringBuilder() ;
        if ( root == null ) return direction.toString() ;
        getNearestCommonNode( root , startValue , destValue ) ;
        if ( nearestCommonNode == null ) nearestCommonNode = root ;
        else startLookup( nearestCommonNode , startValue , direction ) ;
        StringBuilder endLookup = new StringBuilder() ;
        endLookup( nearestCommonNode.left , destValue , endLookup , 'L' );
        endLookup( nearestCommonNode.right , destValue , endLookup , 'R' );
        direction.append( endLookup.reverse() ) ;
        return direction.toString() ;
    }

    private boolean getNearestCommonNode( TreeNode node , int startValue , int destValue ) {
        if ( node == null ) return false ;
        boolean current = node.val == startValue || node.val == destValue ,
                left = getNearestCommonNode( node.left , startValue , destValue ) ,
                right = getNearestCommonNode( node.right , startValue , destValue ) ;
        if ( (left && right) || ( current && (right||left) ) ) {
            nearestCommonNode = node ;
            return false ;
        }
        return left || right || current ;
    }

    private boolean startLookup( TreeNode node , int x , StringBuilder direction ) {
        if ( node == null ) return false ;
        if ( node.val == x ) return true ;
        boolean left = startLookup( node.left , x , direction ) ,
                right = startLookup( node.right , x , direction ) ;
        if ( left || right ) direction.append( "U" ) ;
        return left || right ;
    }

    private boolean endLookup( TreeNode node , int x , StringBuilder direction , char path ) {
        if ( node == null ) return false ;
        if ( node.val == x ) {
            direction.append( path ) ;
            return true ;
        }
        boolean left = endLookup( node.left , x , direction , 'L' ) ,
                right = endLookup( node.right , x , direction , 'R' ) ;
        if ( left || right ) direction.append( path ) ;
        return left || right ;
    }

}
