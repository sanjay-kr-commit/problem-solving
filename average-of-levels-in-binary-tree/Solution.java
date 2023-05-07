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

  ArrayList<double[]> state = new ArrayList<>() ;

  public List<Double> averageOfLevels(TreeNode root) {
    gatherLevelSum( root , 0 ) ;
    return average() ;
  }

  private void gatherLevelSum( TreeNode node , int level ) {
    if ( node == null ) return ;
    if ( state.size()-1 < level ) {
       state.add( level , new double[2] ) ;
    }
    state.get( level )[0] += 1 ;
    state.get( level )[1] += node.val ;
    gatherLevelSum( node.left , level + 1 ) ;
    gatherLevelSum( node.right , level + 1 ) ;
  }

  private List<Double> average() {
    ArrayList<Double> avg = new ArrayList<>() ;
    for ( double[] i : state ) {
      avg.add( i[1] / i[0] ) ;
    }
    return avg ;
  }

}

// 2m HashMap isn't very spcace effiecient and also take quiet a long time to initialise compared to array list
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
