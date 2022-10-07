import java.util.LinkedList;
import java.util.Queue;

// took 1ms
class Solution1 {

    int min = Integer.MAX_VALUE ;

    public int minDepth(TreeNode root) {
        if ( root == null ) return 0 ;
        minDepth(root, 1);
        return min ;
    }

    public void minDepth( TreeNode node , int x ) {
        if ( node == null ) return ;
        if ( node.left == null && node.right == null ) {
            if ( min > x ) min = x ;
        } else if ( x-1 < min ) {
            minDepth(node.left, x+1);
            minDepth(node.right, x+1);
        }
    }

}

// took 3 ms
class Solution {

    public int minDepth( TreeNode root ) {
        if ( root == null ) return 0 ;
        int depth = 1;
        Queue<TreeNode> list = new LinkedList<>()  ;
        list.offer(root);
        while ( !list.isEmpty() ) {
            int size = list.size() ;
            for ( int i = 0 ; i < size ; i++ ){
                TreeNode node = list.poll();
                if ( node.left == null && node.right == null ) return depth ;
                if ( node.left != null ) list.offer(node.left) ;
                if ( node.right != null ) list.offer(node.right) ;
            }
            depth++ ;
        }
        return depth ;
    }

}