import java.util.HashSet;

class Solution {
    
    HashSet<Integer> key = new HashSet<>() ;
    
    public boolean findTarget(TreeNode root, int k) {
        if ( root == null ) return false ;
        if ( key.contains( root.val ) ) return true ;
        key.add( k - root.val ) ;
        return findTarget( root.left, k ) || findTarget( root.right, k) ;
    }
}