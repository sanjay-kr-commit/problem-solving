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
// 1ms
class Solution {

  public boolean findTarget( TreeNode root , int k ) {
    return findsumtarget( root , root , k ) ;
  }

	boolean findsumtarget(TreeNode root,TreeNode temp,int k){
		if ( temp == null ) return false;
		if ( findsumtarget(root,temp.left,k) || findsumtarget(root,temp.right,k) ) return true ;
		int check=k-temp.val;
		if(temp.val<check){
			if(find(root,check)){
				return true;
			}
		}
		return false;
	}

	boolean find(TreeNode root,int target){
	  if ( root == null ) return false;
		if ( root.val < target ) {
			return find(root.right,target);
		} else if ( target < root.val) {
			return find(root.left,target);
		}else return true ;
	}

}
// 3 ms
class Solution {  

  HashSet<Integer> hash = new HashSet<>() ;

  public boolean findTarget(TreeNode root, int k) {
    if ( root == null ) return false ;
    if ( hash.contains( root.val ) ) return true ;
    hash.add( k - root.val ) ;
    return findTarget( root.left , k ) || findTarget( root.right , k ) ;
  }

}
