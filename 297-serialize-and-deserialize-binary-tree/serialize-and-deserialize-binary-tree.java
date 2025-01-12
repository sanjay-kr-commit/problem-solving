import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Codec {

    private int min = -1001 ;

    void serialize(TreeNode root , ArrayList<Integer> nodes ) {
        if ( root == null ) {
            nodes.add(min);
            return;
        }
        nodes.add(root.val);
        serialize(root.left, nodes);
        serialize(root.right, nodes);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        ArrayList<Integer> nodes = new ArrayList<>();
        serialize( root , nodes );
        StringBuilder sb = new StringBuilder();
        for ( int i : nodes ) {
            sb.append( i ).append(" ");
        }
        return sb.toString();
    }

    int index ;

    TreeNode deserialize(List<Integer> nodes ) {
        if ( index >= nodes.size() || nodes.get(index++) == -1001 ) return null ;
        TreeNode root = new TreeNode(nodes.get(index-1));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        ArrayList<Integer> nodes = new ArrayList<>();
        int temp , sign , len = data.length() , i = 0 ;
        while ( i < len ) {
            temp = 0 ;
            sign = ( data.charAt( i ) == '-' ) ? -1 : 1 ;
            if ( sign == -1 ) i++ ;
            while ( i < len && data.charAt( i ) != ' ' ) {
                temp *= 10 ;
                temp += data.charAt( i++ ) - '0' ;
            }
            i++ ;
            nodes.add( temp*sign );
        }
        index = 0 ;
        return deserialize(nodes);
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));