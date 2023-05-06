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

// 1ms beats 100%
class Solution {
  public String tree2str(TreeNode root) {
    StringBuilder st = new StringBuilder() ;
    formatTree( root , st ) ;
    return st.toString() ;
  }
  private void formatTree( TreeNode node , StringBuilder st ) {
    if ( node == null ) return ;
    boolean directCall = st.length() == 0 ,
            left = node.left != null ,
            right = node.right != null ;
    if ( !directCall ) st.append( '(' ) ;
    st.append( node.val ) ;
    if ( left ) formatTree( node.left , st ) ;
    else if ( right ) st.append( "()" ) ;
    if ( right ) formatTree( node.right , st ) ;
    if ( !directCall ) st.append( ')' ) ;
  }
}

// the reason this is slower than above is due to substring which takes linear time
// beats 98%
// 2ms
class Solution {
  
  public String tree2str(TreeNode root) {
    StringBuilder st = new StringBuilder() ;
    formatTree( root , st ) ;
    return st.substring( 1 , st.length()-1 ).toString() ;
  }
 
  private void formatTree( TreeNode node , StringBuilder st ) {
    st.append( "(" ) ;
    if ( node == null ) {
      st.append( ")" ) ;
      return ;
    } 
    boolean left = node.left != null , right = node.right != null ;
    st.append( node.val ) ;
    if ( left || right ) formatTree( node.left , st ) ;
    if ( right ) formatTree( node.right , st ) ;
    st.append( ")" ) ;
  }

}

// the reason this ans is taking so long is due to nature of string
// which are immutable in nature,
// so once a string has been created it cannot be changed
// the only way to append something to it is to recontruct
// which takes intial string length + new characters length time on
// each reconstruction
// which means with every reconstruction it will take linear time O(n)
// 12ms beats 50%
class Solution {
  public String tree2str(TreeNode root) {
    String st = stringOf( root ) ;
    return st.substring( 1 , st.length() -1) ;
  }
  private String stringOf( TreeNode node ) {
    if ( node == null ) return "()" ;
    String st = "(" ;
    boolean left = node.left != null , right = node.right != null ;
    st += node.val ;
    if ( left || right ) st += stringOf( node.left ) ;
    if ( right ) st += stringOf( node.right ) ;
    return st + ")" ;
  }
}
