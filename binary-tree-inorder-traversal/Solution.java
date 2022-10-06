import java.util.ArrayList;
import java.util.List;
class Solution {

    List<Integer> ans = new ArrayList<>();

    public void add( TreeNode node ) {
        if ( node == null ) return ;
        add( node.left );
        ans.add( node.val ) ;
        add( node.right );
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if ( root != null ) add( root );
        return ans ;
    }
}