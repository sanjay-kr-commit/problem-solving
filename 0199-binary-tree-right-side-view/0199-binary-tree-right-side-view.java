import java.util.ArrayList;
import java.util.List;
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, 0, result);
        return result;
    }
    void helper( TreeNode root , int level , List<Integer> sideView ) {
        if ( root == null ) return;
        if ( sideView.size() == level ) sideView.add(root.val);
        level++ ;
        helper( root.right , level , sideView );
        helper( root.left , level , sideView );
    }

}
