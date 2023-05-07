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

  Map<Integer,double[]> count = new HashMap<>() ;

  public List<Double> averageOfLevels(TreeNode root) {
    gatherLevelSum( root , 0 ) ;
    return average() ;
  }

  private void gatherLevelSum( TreeNode node , int level ) {
    if ( node == null ) return ;
    if ( !count.containsKey( level ) ) count.put( level , new double[] { 0.0 , 0.0 } ) ;
    double [] t = count.get( level ) ;
    t[0] += 1 ;
    t[1] += node.val ;
    gatherLevelSum( node.left , level + 1 ) ;
    gatherLevelSum( node.right , level + 1 ) ;
  }

  private List<Double> average() {
    ArrayList<Double> avg = new ArrayList<>() ;
    for ( int i : count.keySet() ) {
      double[] level = count.get( i ) ;
      avg.add( level[1] / level[0] ) ;
    }
    return avg ;
  }

}
