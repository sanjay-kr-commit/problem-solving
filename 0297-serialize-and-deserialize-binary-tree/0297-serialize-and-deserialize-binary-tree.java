import java.util.LinkedList;
import java.util.Queue;

class Codec {
    public String serialize(TreeNode root) {
        if ( root == null ) return "[]" ;
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while ( !queue.isEmpty() ) {
            TreeNode node = queue.poll();
            if ( node != null ) {
                sb.append(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            } else sb.append(';');
            sb.append( ',' );
        }
        int len = sb.length();
        while ( len > 2 && sb.charAt(len-2) == ';' && sb.charAt(len-1) == ','  ) {
            len -= 2 ;
        }
        sb.setCharAt( len - 1, ']' );
        return sb.substring( 0 , len);
    }

    private int [] tokenize( String data ) {
        int len = 0 , dLen = data.length();
        for ( int i = 1 ; i < dLen ; i++ ) if ( data.charAt(i) == ',' || data.charAt(i) == ']' ) len++;
        int [] tokenizedIndex = new int [len];
        if ( len == 0 ) return tokenizedIndex;
        int tokenLen = 1 ;
        tokenizedIndex[0] = 1 ;
        for ( int i = 1 ; i < dLen ; i++ ) {
            if ( data.charAt(i) == ',' ) tokenizedIndex[tokenLen++] = i+1 ;
        }
        return tokenizedIndex;
    }

    private int extractInt( String data , int index ) {
        boolean isNegative = data.charAt(index) == '-' ;
        if ( isNegative ) index++ ;
        int num = 0 , len = data.length();
        while ( index < len && data.charAt(index) != ',' && data.charAt(index) != ']'){
            num *= 10 ;
            num += data.charAt(index++)-'0';
        }
        return num * ((isNegative) ? -1 : 1) ;
    }

    public TreeNode deserialize(String data) {
        if ( data.equals("[]") ) return null;
        int [] tokenizedIndex = tokenize(data);
        TreeNode root = new TreeNode(extractInt(data,tokenizedIndex[0]));
        Queue<TreeNode> queue1 = new LinkedList<>();
        queue1.add(root);
        int i = 0 ;
        while ( !queue1.isEmpty() ) {
            TreeNode node = queue1.poll();
            int left = ++i , right = ++i ;
            if ( left < tokenizedIndex.length && data.charAt(tokenizedIndex[left]) != ';' ) {
                node.left = new TreeNode(extractInt(data,tokenizedIndex[left]));
                queue1.offer(node.left);
            }
            if (right < tokenizedIndex.length && data.charAt(tokenizedIndex[right]) != ';' ) {
                node.right = new TreeNode(extractInt(data,tokenizedIndex[right]));
                queue1.offer(node.right);
            }
        }
        return root ;
    }

}
